package Lesson5;

public class MultiThread {

    public int size = 10000000;
    public int h = size / 2;
    float[] arr = new float[size];
    float[] a1 = new float[h];
    float[] a2 = new float[h];

    public static void main(String[] args) {
    /*
    Урок 5. Многопоточность.
     */

    // разбиваем массив size на два массива для последующего перерасчёта в потоках
    System.arraycopy(arr, 0, a1, 0, h);
    System.arraycopy(arr, h, a2, 0, h);
    //
    MHalfArray arr1 = new MHalfArray(a1);
    MHalfArray arr2 = new MHalfArray(a2);
    Thread th1 = new Thread(arr1);
    Thread th2 = new Thread(arr2);

    // склеиваем массивы обратно в один.
    System.arraycopy(a1, 0, arr, 0, h);
    System.arraycopy(a2, 0, arr, h, h);
    // ------------------------------------------------------
    // в данном блоке просто пересчитываем весь массив size
    MArray arr1 = new MArray();
    // создаем экземпляр класса Thread и передаем в него в качестве аргумента arr1
    Thread t1 = new Thread (arr1);
    t1.start();


    }


}
