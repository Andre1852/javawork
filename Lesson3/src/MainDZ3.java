import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Малыгин Андрей, домашнее задание к 3 уроку Java2.

public class MainDZ3 {
    public static void main(String[] args) {

        System.out.println("-----Задание 1-----");

        String[] abc = {"A", "D", "M", "V", "S", "E", "Q", "D", "F", "B", "D", "E"};
        Set<String> abcUnique = new HashSet<>();

        System.out.println("размер массива: " + abc.length);
        for (String s: abc) {
            abcUnique.add(s);
        }
        System.out.println("количество уникальных слов: " + abcUnique.size());
        for (String s: abcUnique) {
            System.out.print(s + "; ");
        }
        System.out.println();

        getWord(abc, "A");// Метод getWord считает сколько раз в исходном массиве
                               // встречается заданное слово.

        System.out.println("-----Задание 2-----");

        List<AddressBook> addressBook = new ArrayList<>();//адресная книга

        addressBook.add(new AddressBook("Peter", "237-12"));
        addressBook.add(new AddressBook("Mari ", "237-09"));
        addressBook.add(new AddressBook("Irena", "237-00"));
        addressBook.add(new AddressBook("Peter", "237-78"));
        addressBook.add(new AddressBook("Ivan ", "237-42"));

        addRecord(addressBook, "Leo  ", "237-08");//добавить запись
        getRecord(addressBook, "Peter");//найти телефон по имени

        System.out.println();
        System.out.println("Содержание адресной книги");


        for (AddressBook a: addressBook) {
            System.out.println(a.getName() + ": " + a.getNumer());
        }
    }

    private static void getWord(String[] arr, String word){
        int i = 0;
        for (String s: arr) {
            if (word.equals(s)){
                i++;
            }
        }
        if (i == 0){
            System.out.println("Слово " + word + " в массиве не найдено");
        } else {
            System.out.println("Слово " + word + " встречается - " + i + " раз.");
        }
    }

    private static void addRecord(List<AddressBook> addressBook, String name, String numer) {
        addressBook.add(new AddressBook(name, numer));
    }

    private static void getRecord(List<AddressBook> addressBook, String name) {
        for (AddressBook a: addressBook) {
            if (name.equals(a.getName())){
                System.out.println(a.getName() + ": " + a.getNumer());
            }
        }
    }
}
