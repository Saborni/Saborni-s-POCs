package sab.boot.model;

public class Book {

    private long bookID;
    public void setBookID(long bookID) {
        this.bookID = bookID;
    }
    public long getBookID() {
        return bookID;
    }

    private String bookName;
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    private double price;
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
