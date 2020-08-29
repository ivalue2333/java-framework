package com.iota.core.distribute.load_balance;

import java.util.Random;

public class LBLeastConnections {
    public Balanceable choice(Balanceable[] servers) {
        int length = servers.length;
        int leastActive = -1;
        int leastCount = 0;
        int[] leastIndexs = new int[length];
        int totalWeight = 0;
        int firstWeight = 0;
        boolean sameWeight = true;
        for (int i = 0; i < length; i++) {
            Balanceable server = servers[i];
            int active = server.getActive();
            int weight = server.getWeight();

            if (leastActive == -1 || active < leastActive) {
                leastActive = active;
                leastCount = 1;
                leastIndexs[0] = i;
                totalWeight = weight;
                firstWeight = weight;
                sameWeight = true;
            } else if (active == leastActive) {
                leastIndexs[leastCount++] = i;
                totalWeight += weight;
                if (sameWeight && i > 0
                        && weight != firstWeight) {
                    sameWeight = false;
                }
            }
        }

        if (leastCount == 1) {
            return servers[leastIndexs[0]];
        }

        Random random = new Random();
        if (!sameWeight && totalWeight > 0) {
            int offsetWeight = random.nextInt(totalWeight);
            for (int i = 0; i < leastCount; i++) {
                int leastIndex = leastIndexs[i];
                offsetWeight -= servers[leastIndex].getWeight();
                if (offsetWeight <= 0)
                    return servers[leastIndex];
            }
        }

        return servers[leastIndexs[random.nextInt(leastCount)]];
    }
}
