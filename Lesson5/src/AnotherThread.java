public class AnotherThread extends Thread{

    private volatile boolean n = true;// переменная не кешируется значение берется прямо из памяти

    @Override
    public void run() {
        System.out.println("ещё один поток");// переопределение метода run
    }
}
