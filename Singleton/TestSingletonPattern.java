public class TestSingletonPattern {

    public static  void  main(String[] args) {

        System.out.println("Crated Singleton1 and Singleton2 Singleton instances");
        Singleton singleton1 = Singleton.getInstance("Singleton 1");
        Singleton singleton2 = Singleton.getInstance("Singleton 2");

        System.out.println("Singleton1 name is " + singleton1.getName());
        System.out.println("Singleton2 name is " + singleton2.getName());

        assert (singleton1.getName().equals(singleton2.getName()));

        Thread nonSyn1 = new Thread(new ThreadNonSyncSingleton1());
        Thread nonSyn2 = new Thread(new ThreadNonSyncSingleton2());
        nonSyn1.start();
        nonSyn2.start();
        assert (nonSyn1.getName().equals(nonSyn2.getName()));


        Thread Syn1 = new Thread(new ThreadSyncSingleton1());
        Thread Syn2 = new Thread(new ThreadSyncSingleton2());
        Syn1.start();
        Syn2.start();
        assert (singleton1.getName().equals(singleton2.getName()));
    }


    static class ThreadNonSyncSingleton1 implements  Runnable{
        @Override
        public void run() {
            nonSynchronizedSingleton nonSynSingleton1 = nonSynchronizedSingleton.getInstance("non Synchronized Singleton1");
            System.out.println(nonSynSingleton1.getName());
        }
    }

    static class ThreadNonSyncSingleton2 implements  Runnable{
        @Override
        public void run() {
            nonSynchronizedSingleton nonSynSingleton2 = nonSynchronizedSingleton.getInstance("non Synchronized Singleton2");
            System.out.println(nonSynSingleton2.getName());
        }
    }

    static class ThreadSyncSingleton1 implements  Runnable{
        @Override
        public void run() {
            SynchronizedSingleton SynSingleton1 = SynchronizedSingleton.getInstance("Synchronized Singleton1");
            System.out.println(SynSingleton1.getName());
        }
    }

    static class ThreadSyncSingleton2 implements  Runnable{
        @Override
        public void run() {
            SynchronizedSingleton SynSingleton2 = SynchronizedSingleton.getInstance("Synchronized Singleton2");
            System.out.println(SynSingleton2.getName());
        }
    }


}

