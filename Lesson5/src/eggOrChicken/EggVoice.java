package eggOrChicken;

public class EggVoice extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {
            try {
                sleep(1000);//при использовании sleep требуется InterruptedException
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("яйцо");
        }
    }
}
