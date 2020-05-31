package Lesson5;

public class MHalfArray implements Runnable {
    float[] arr;
    public int size = 10000000;
    public int h = size / 2;

    public MHalfArray(float[] arr) {
        this.arr = arr;
    }

    @Override
    // метод run() из интерфейса
    public float[] run(float[] arr) {
        this.arr = arr;
        // нужно в два потока пересчитать массив
        // для начала заполняем единицами пол массива
        for (int i = 0; i < size ; i++) {
            arr[i] = 1;
        }
        // теперь пересчитываем массив согласно формуле
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        return arr;// возвращаем пересчитанный массив для слияния
    }
}
