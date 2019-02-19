package homework2;

public class MyException {

    public static void sumArray(String[][] matr) throws Exception {
        int sum = 0;
        if (matr.length != 4) throw new Exception();
        for (int i = 0; i < 4; i++) {
            if (matr[i].length != 4) throw new Exception();
        }
        for (int i = 0; i < matr.length; i++) {

            for (int j = 0; j < matr[i].length; j++) {

                System.out.print(matr[i][j] + " ");
                try {
                    sum += Integer.parseInt(matr[i][j]);
                } catch (NumberFormatException n){
                    throw new MyArreyDataException(i, j);
                }
            }
            System.out.println();
        }
        System.out.println("Сумма всех элементов массива: " + sum);
    }

    public static void main(String[] args) {
        String[][] matr = new String[4][4];
        matr[0][0] = "321";
        matr[0][1] = "321";
        matr[0][2] = "321";
        matr[0][3] = "321";

        matr[1][0] = "321";
        matr[1][1] = "321";
        matr[1][2] = "321";
        matr[1][3] = "321";

        matr[2][0] = "321";
        matr[2][1] = "321";
        matr[2][2] = "321";
        matr[2][3] = "321";

        matr[3][0] = "321";
        matr[3][1] = "321";
        matr[3][2] = "321";
        matr[3][3] = "321";

        try {
            sumArray(matr);
        } catch (MyArreyDataException m){
            System.out.println("В ячейке [" + m.line + "][" + m.column + "] непреобразуемое зачение");

        } catch (Exception e) {
            System.out.println("Массив несоответствующего размера");
        }

    }
}
