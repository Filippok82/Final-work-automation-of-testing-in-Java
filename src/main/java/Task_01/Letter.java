package Task_01;


// Класс, представляющий письма
public class Letter extends AbstractLibraryItem{
    private final String inventoryNumber;
    private final String author;

    public Letter(String title, String inventoryNumber, String author) {
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
