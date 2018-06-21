package ru.foxit.grayfox;

public class Sort {

    public static void main(String[] args) {
        int[] mass = new int[10];
        for (int i = 0; i < mass.length; i++) {
            mass[i] = (int) Math.round(Math.random() * 500);
        }
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + ",");
        }
        System.out.println();
        sortInsert(mass);
//        sortSelect(mass);
//        sortBubble(mass);
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + ",");
        }
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
