import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
//работа Exception с циклом
        List<Integer> collection = Arrays.asList(5, 6, 7);
        try {
            for (Integer i: collection
            ) {
                System.out.println(i);
                    int x = i / 0;
                }
        }catch (Exception e){
            System.out.println("Исключение");
        }

//работа Exception в методе
        FormulaCalculator formulaCalculator = new FormulaCalculator(5, 0);
        formulaCalculator.calculate();

//проброс Exception через сигнатуру метода calculate2 выше и заключение в обертку try catch
        try {
            formulaCalculator.calculate2();
        } catch (Exception e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
        System.out.println("Работа завершилась корректно.");

    try {
        formulaCalculator.calculate3();
    }catch (ArrayIndexOutOfBoundsException d){
        d.printStackTrace();
    }


    try {
        formulaCalculator.calculate4();
    }catch (NullPointerException e){
        System.out.println("в блоке NullPointerException");
        e.printStackTrace();
    }finally {
        System.out.println("должно обязательно выполнятся");
    }

    }
}
