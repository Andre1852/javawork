package homework5;
//Малыгин Андрей, домашнее задание к 5 уроку Java2.
public class TimeMain {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static double[] arr = new double[SIZE];
    static double[] a1 = new double[HALF];
    static double[] a2 = new double[HALF];
    static HalfArray halfArray;


    public static void main(String[] args) {

        for (int i = 0; i < arr.length  ; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        fillArray(arr);
        long b = System.currentTimeMillis();
        System.out.println((b - a) + " ms: время работы одним потоком");

        for (int i = 0; i < arr.length  ; i++) {
            arr[i] = 1;
        }
        halfArray = new HalfArray();

        long c = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);

        fillArray(a1);
        halfArray.start();
        if (halfArray.isAlive()){
            try {
                halfArray.join();
            } catch (Exception e){
            }
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        long d = System.currentTimeMillis();
        System.out.println((d - c) + " ms: время работы двумя потоками");
    }

    public static void fillArray(double[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = arr[1] * Math.sin(0.2 * i / 5) * Math.cos(0.2 + i / 5) * Math.cos(0.4 + i / 2);
        }
    }
}
