package BookManagement;

import com.google.gson.Gson;

public class Book {
    private int bookid;
    private String title;
    private String author;
    private String publisher;
    
    public int getBookid() {
        return bookid;
    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String toString() {
        Gson g = new Gson();
        return g.toJson(this);
    }
}
