package com.iota.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

/*
    controller默认是单例的，不要使用非静态的成员变量，否则会发生数据逻辑混乱。正因为单例所以不是线程安全的。
    我们首先访问 http://localhost:8080/testScope，得到的答案是1；然后我们再访问 http://localhost:8080/testScope2，得到的答案是 2。
    接下来我们再来给controller增加作用多例 @Scope("prototype")

    解决方法
        1、不要在controller中定义成员变量。
        2、万一必须要定义一个非静态成员变量时候，则通过注解@Scope(“prototype”)，将其设置为多例模式。
        3、在Controller中使用ThreadLocal变量

    spring bean作用域有以下5个：
        singleton:单例模式，当spring创建applicationContext容器的时候，spring会欲初始化所有的该作用域实例，加上lazy-init就可以避免预处理；
        prototype：原型模式，每次通过getBean获取该bean就会新产生一个实例，创建后spring将不再对其管理；
        （下面是在web项目下才用到的）
        request：搞web的大家都应该明白request的域了吧，就是每次请求都新产生一个实例，和prototype不同就是创建后，接下来的管理，spring依然在监听；
        session:每次会话，同上；
        global session:全局的web域，类似于servlet中的application。

 */
@RestController
//@Scope("prototype")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CurrentSafeController {
    private static final Logger logger = LogManager.getLogger(CurrentSafeController.class);

    private int num = 0;

    private static ThreadLocal<Integer> data = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    @RequestMapping("/testScope")
    public void testScope() {
        System.out.println(++num);
    }

    @RequestMapping("/testScope2")
    public void testScope2() {
        System.out.println(++num);
    }

    // thread local 成功
    @RequestMapping("/testScope3")
    public String testScope3()  {
        int a = data.get();
        a++;
        data.set(a);
        System.out.println(data.get());
        return String.format("data:%d", data.get());
    }
}
