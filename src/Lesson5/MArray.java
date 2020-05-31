package Lesson5;

import java.lang.reflect.Array;

public class MArray implements Runnable{
    static final int size = 10000000;
    float[] arr = new float[size];

    // заполняем массив единичками и замеряем время заполнения
    float[] fillingArray(){
        long a = System.currentTimeMillis();
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }
        System.out.println("Массив заполнен за : " + (System.currentTimeMillis() - a));
        return arr;
    }

    // делаем вычисления в массиве по наданной спецформуле
    void arrayCalculate(float[] array){
        this.arr = array;
        System.out.println("Размер массива " + arr.length + " в ячейке 0 = " + arr[0]);
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Перерасчёт массива закончен за : " + (System.currentTimeMillis() - a));

    }


    @Override
    // метод run(), для запуска в потоке.
    public void run() {
        fillingArray();
        long a = System.currentTimeMillis();
        arrayCalculate(arr);
        System.out.println("время исполнения в потоке : " + (System.currentTimeMillis() - a));

    }

    /*
    Создем следующие методы :
    1. Заполнение 1", и возвращаем заполненный массив и время выполнения  long a = System.currentTimeMillis();
    2. Метод - на вход результат метода 1. Возвращаем - для каждой ячейки считают новое значение по формуле:
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    3.
     */
}
