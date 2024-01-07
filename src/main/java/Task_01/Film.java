package Task_01;

// Класс, представляющий фильмы
public class Film extends AbstractLibraryItem{
    private final String inventoryNumber;
    private final String author;

    public Film(String title, String inventoryNumber, String author) {
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
