package ru.foxit.grayfox;

public class MyArr {

    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.arr = new int[size];
        this.size = 0;
    }

    /**
     * Бинарный поиск
     * @param value
     * @return
     */
    public boolean binaryFind(int value) {
        int low = 0;
        int hight = this.size - 1;
        int mid;
        while (low < hight) {
            mid = (low + hight) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    hight = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    /**
     * Линейный поиск
     * @param value
     * @return
     */
    public boolean find(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) break;
        }
        if (i == this.size) return false;
        else return true;
    }

    /**
     * Удаление эл-та
     * @param value
     */
    public void delete(int value) {
        int i = 0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) break;
        }
        for (int j = i; j < this.size - 1; j++) {
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    /**
     * Отображение в консоль
     */
    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    /**
     * Вставка эл-та
     * @param value
     */
    public void insert(int value) {

        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] > value) break;
        }
        for (int j = this.size; j > i; j--) {
            this.arr[j] = this.arr[j - 1];
        }
        this.arr[i] = value;
        this.size++;
    }
}
