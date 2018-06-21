package ru.foxit.grayfox;

public class Main {
    public static void main(String[] args) {

        MyArr arr = new MyArr(10);
        arr.insert(2);
        arr.insert(1);
        arr.insert(4);
        arr.insert(3);
        arr.insert(6);
        arr.insert(5);
        arr.insert(8);
        arr.insert(7);
        arr.insert(10);
        arr.insert(9);

        int search = 4;
        System.out.println(arr.binaryFind(search));

        //region Линейный поиск
//        System.out.println("Выводим на экран");
//        arr.display();
//        if (arr.find(search)) {
//            arr.delete(search);
//            System.out.println("Элемент " + search + " удален");
//        } else System.out.println("Не удалось найти элемент " + search);
//
//
//        System.out.println("Выводим новый массив");
//        arr.display();
        //endregion
    }
}
