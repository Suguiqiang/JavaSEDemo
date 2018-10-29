package concurrent;

//﻿在java内存模型中，是分为主内存和工作内存两块的。
//        主内存，主要是存储各个线程都会用到共享变量等。
//        对于每个线程都有自己的一个存储变量的地方，就是工作内存。各个线程之间的工作内存是相互独立的，不可见的。


//﻿flag: TestVolatile线程读取的flag值是自己线程中存储在工作内存中的值，主线程中的flag值虽然更新了，但是对于TestVolatile线程是不可见、无感知的。
//flag2: ﻿volatile关键字就排上用场了,﻿该变量是强制要求从主内存读以及往主内存写，这样保证各个线程在操作这个变量的值时，都是最新鲜的数据。
public class TestVolatile extends Thread {

    private static boolean flag = false;

    private volatile static boolean flag2 = false;

//    @Override
//    public void run() {
//        while (!flag) {
//        }
//    }


    @Override
    public void run() {

        while (!flag2) {

        }
    }

    public static void main(String[] args) throws Exception {
        new TestVolatile().start();
        Thread.sleep(100);
        flag = true;
        flag2 = true;
    }
}
