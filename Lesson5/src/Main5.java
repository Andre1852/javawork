public class Main5 {
    public static void main(String[] args) {

        Runnable r = new SimpleRunnable();//создание потока используя интерфейс Runnable
        Thread newThread = new Thread(r);
        newThread.start();
        System.out.println("Main thread is finished");

        Thread another = new AnotherThread();//создание потока используя суперкласс Thread
        another.start();

    }

    public synchronized static void doSomething(){//пример синхронизации метода
    }
}
