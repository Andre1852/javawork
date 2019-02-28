package eggOrChicken;

public class ChickenVoice {

    static EggVoice eggVoice;

    public static void main(String[] args) {
        eggVoice = new EggVoice();
        //eggVoice.setDaemon(true);
        //поток демон
        System.out.println("Мы начинаем");
        eggVoice.start();//поток стартует
        System.out.println("Приоритет вспомогательного потока: " + eggVoice.getPriority());
        eggVoice.setPriority(1);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);//текущий поток MAX_PRIORITY
        System.out.println("Приоритет основного потока: " + Thread.currentThread().getPriority());

        for (int i = 0; i < 5 ; i++) {
            try {
                Thread.sleep(1000);//поток засыпает
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("курица");
        }
        if (eggVoice.isAlive()){//проверяем жив ли поток
            try {
                eggVoice.join();
                //метод join - основной поток ждет завершения второстепенного потока
                //eggVoice.interrupt();
                //завершение работы потока
            }
            catch (Exception e){

            }
            System.out.println("Первым оказалось яйцо");
        } else {
            System.out.println("Первым оказалась курица");
        }
    }
}
