package Task_01;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book("Гарри Поттер: Орден Феникса", "001", "Дж. К. Роулинг"));
        libraryItems.add(new Book("Властелин колец: Братство кольца", "002", "Дж. Р. Р. Толкин"));
        libraryItems.add(new Magazine("Наука и жизнь", "003", "М.Н. Глубоковский"));
        libraryItems.add(new Film("Планета Земля", "004", "Джону Лонгу "));
        libraryItems.add((new Book("Гарри Поттер: Филосовский камень", "005","Дж. К. Роулинг")));
        libraryItems.add(new Letter("Письмо к съезду", "006", "В.И. Ленин"));

        LibrarySearchService searchService = new LibrarySearchService(libraryItems);

        List<LibraryItem> itemsByInventoryNumber = searchService.searchByInventoryNumber("006");
        List<LibraryItem> itemsByAuthor = searchService.searchByAuthor("Дж. К. Роулинг");

        System.out.println("Поиск по инвентарному номеру:");
        for (LibraryItem item : itemsByInventoryNumber) {
            System.out.println(item.getTitle());
        }

        System.out.println("Поиск по автору:");
        for (LibraryItem i : itemsByAuthor) {
            System.out.println(i.getTitle());
        }
    }
}

