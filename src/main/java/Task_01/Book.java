package Task_01;

// Класс, представляющий книги
public class Book extends AbstractLibraryItem {
    private final String inventoryNumber;
    private final String author;

    public Book(String title, String inventoryNumber, String author) {
        super(title);
        this.inventoryNumber = inventoryNumber;
        this.author = author;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getAuthor() {
        return author;
    }
}

