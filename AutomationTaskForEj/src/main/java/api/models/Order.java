package api.models;

public class Order {
    private String bookId;
    private String customerName;

    public Order(String bookId, String customerName) {
        this.bookId = bookId;
        this.customerName = customerName;
    }

    // Getters
    public String getBookId() { return bookId; }
    public String getCustomerName() { return customerName; }
}