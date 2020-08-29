package com.iota.core.distribute.load_balance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class LBWeightedRandom implements LBInterface{

    public Balanceable choice(Balanceable[] servers) {
        int seed = 0;
        for (Balanceable server : servers) {
            seed += server.getWeight();
        }
        Random random = new Random();
        int randomNum = random.nextInt(seed);
        ArrayList<Balanceable> tmpList = (ArrayList<Balanceable>) Arrays.asList(servers);
        Collections.sort(tmpList);
        int tmp = 0;
        for (Balanceable server : servers) {
            tmp += server.getWeight();
            if (tmp >= randomNum) {
                return server;
            }
        }
        return null;
    }
}
