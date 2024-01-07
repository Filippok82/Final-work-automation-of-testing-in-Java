package Task_01;


// Создаем абстрактный класс, который реализует LibraryItem и добавляет общие свойства
public  abstract  class AbstractLibraryItem implements LibraryItem {
    private final String title;

    public AbstractLibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
