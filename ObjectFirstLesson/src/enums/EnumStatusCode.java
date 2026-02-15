package enums;

public enum EnumStatusCode  {
    SUCCESSFULLY("\nПокупка прошла успешно"),
    PRODUCT_IS_OUT_OF_STOCK("\nПродукт на складе закончился"),
    ERROR_CODE("\nОшибка работы программы!");
    private String title;
    EnumStatusCode(String title) {
        this.title = title;
    }

    public String getTitle() {

        return title;
    }
}
