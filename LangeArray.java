package ru.foxit.grayfox;

import java.util.Arrays;
import java.util.stream.Stream;

public class LangeArray {
    // Создать массив большого размера (миллион элементов).

    /**
     * 1. Создать массив большого размера (миллион элементов).
     * 2. Написать методы удаления, добавления, поиска элемента массива.
     * 3. Заполнить массив случайными числами.
     * 4. Написать методы, реализующие рассмотренные виды сортировок и проверить скорость выполнения каждой.
     */

    /**
     * 1. Создать массив большого размера (миллион элементов).
     * @param args
     */
    public static void main(String[] args) {
        int arr = 1000000;
        int[] array = new int[arr];
//        for(int i = 0; i < array.length; i++) {
//            array[i] = (int) Math.round(Math.random() * 500);
//            System.out.println(array[i]);
//        }

        /*
         * Speed test
         */

        // Bubble sort speed

        printTime();
        sortBubble( array );
        printTime();

        // Bubble sort speed



        // Insert sort speed

        printTime();
        sortInsert( array );
        printTime();

        // Insert sort speed


        // Select sort speed

        printTime();
        sortSelect( array );
        printTime();

        // Select sort speed
    }

    private static void printTime() {
        System.out.println( System.currentTimeMillis() );
    }

    /**
     * 2. Написать методы удаления, добавления, поиска элемента массива.
     * @param array
     * @param index
     */

    private int[] deleteItemArray(int[] array, int index){
        Integer[] ar = new Integer[array.length];
        for( int i = 0; i < array.length; i++ ) ar[i] = array[ i ];

        return Arrays.stream(Stream.concat(Arrays.stream(ar).limit(index), Arrays.stream(ar).skip(index+1))
                .toArray(Integer[]::new)).mapToInt(Integer::intValue).toArray();
    }

    /**
     * 3. Написать методы удаления, добавления, поиска элемента массива.
     * @param array
     * @param object
     */
    public static int[] addItemArray(int[] array, int object) {
        return append( array, object );
    }

    /**
     * 4. Написать методы удаления, добавления, поиска элемента массива.
     * @param array
     * @param element
     */

    public static void searchElement(int[] array, int element) {
        boolean searched = Arrays.stream( array ).anyMatch( a -> element == a );

        System.out.println( String.format( "Founded numeric %d", element ) );

    }

    private static int[] append( int[] arr, int element) {
        final int n = arr.length;
        arr = Arrays.copyOf( arr, n + 1 );
        arr[n] = element;

        return arr;
    }

    /**
     * Сортировка методом вставки
     * @param mass
     */
    public static void sortInsert(int[] mass) {
        int out, in;
        for (out = 1; out < mass.length; out++) {
            int temp = mass[out];
            in = out;
            while (in > 0 && mass[in - 1] >= temp) {
                mass[in] = mass[in - 1];
                --in;
            }
            mass[in] = temp;
        }
    }

    /**
     * Сортировка методом выбора
     * @param mass
     */
    public static void sortSelect(int[] mass) {
        int out, in, mark;
        for (out = 0; out < mass.length; out++) {
            mark = out;
            for (in = out + 1; in < mass.length; in++) {
                if (mass[in] < mass[mark]) {
                    mark = in;
                }
            }
            int tmp = mass[out];
            mass[out] = mass[mark];
            mass[mark] = tmp;
        }
    }

    /**
     * Пузырьковая сортировка
     * @param mass
     */
    public static void sortBubble(int[] mass) {
        int out, in;
        for (out = mass.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (mass[in] > mass[in + 1]) {
                    int tmp = mass[in];
                    mass[in] = mass[in + 1];
                    mass[in + 1] = tmp;
                }
            }
        }
    }

}
