package day09HttpCookieSession;

/**
 * Created by 83731 on 2017/09/07.
 */
public class Book {
    private String id;
    private String name;
    private String price;
    private String author;
    private String desc;


    public Book(String id, String name, String price, String author, String desc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
