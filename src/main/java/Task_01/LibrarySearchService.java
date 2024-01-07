package Task_01;

import java.util.ArrayList;
import java.util.List;

// Сервис для поиска в библиотеке
public class LibrarySearchService {
    private final List<LibraryItem> libraryItems;

    public LibrarySearchService(List<LibraryItem> libraryItems) {
        this.libraryItems = libraryItems;
    }

    public List<LibraryItem> searchByInventoryNumber(String inventoryNumber) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getInventoryNumber().equals(inventoryNumber)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item.getAuthor().equals(author)) {
                result.add(item);
            }
        }
        return result;
    }
}