public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from another stream");
        System.out.println("Another thread is finished");
    }
}
