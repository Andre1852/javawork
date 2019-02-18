public class FormulaCalculator {
    private int a;
    private int b;

    public FormulaCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void calculate(){
        try {
            int x = a / b;
            System.out.println(x);
        } catch (RuntimeException e)
        {
            System.out.println("Произошла ошибка. Система заканчивает работу");
        }
    }

    public void calculate2() throws Exception {
        if (a % 2 == 0) {
                throw new Exception();//проверяемое исключение
            }//программа требует обернуть или пробросить наверх обертку try catch
        System.out.println("версия 2 All ok!");
    }

    public void calculate3() {
        if (a % 2 == 0) {
            throw new ArrayIndexOutOfBoundsException();//непроверяемое исключение
        }//обертка try catch размещается самостоятельно
        System.out.println("версия 3 All ok!!!!!!!");
    }

    public void calculate4() {
        if (a % 2 == 0) {
            throw new NullPointerException();//непроверяемое исключение
        }//обертка try catch размещается самостоятельно
        System.out.println("версия 4 All ok!6!5!4!3!2!1!");
    }


}


