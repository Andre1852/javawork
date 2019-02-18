package homework2;

public class MainDZ2 {

    public static void main(String[] args) {
        try {
            String[][] arr = new String[4][4];

            arr[0][0] = "123";
            arr[0][1] = "123";
            arr[0][2] = "123";
            arr[0][3] = "123";

            arr[1][0] = "123";
            arr[1][1] = "123";
            arr[1][2] = "123";
            arr[1][3] = "123";

            arr[2][0] = "123";
            arr[2][1] = "123";
            arr[2][2] = "123";
            arr[2][3] = "123";

            arr[3][0] = "123";
            arr[3][1] = "=123";
            arr[3][2] = "123";
            arr[3][3] = "123";

            //arr[3][4] = "123";

            sumArr(arr);
        }catch (ArrayIndexOutOfBoundsException a){
            //a.printStackTrace();
            System.out.println("Ошибка индексации элемента массива: " + a);
        }
    }

    private static void sumArr(String[][] arr) {
        try {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {

                for (int j = 0; j < arr.length; j++) {

                    System.out.print(arr[i][j] + " ");

                    int n = Integer.parseInt(arr[i][j]);
                    sum += n;
                }
                System.out.println();
            }
            System.out.println("Сумма всех элементов массива: " + sum);
        }catch (NumberFormatException e){
            //e.printStackTrace();
            System.out.println("Сумма не может быть вычислена: " + e);
            System.out.println("Вышеуказанный элемент массива не соответствует формату int.");
        }finally {
            System.out.println("Работа закончена.");
        }
    }
}
