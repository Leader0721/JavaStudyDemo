package day09HttpCookieSession;

import java.util.HashMap;
import java.util.Map;

/**
 * 用这个模拟数据
 * 相当于直接全局内存
 * Created by 83731 on 2017/09/07.
 */
public class BookDB {
    //key 书的ID，value 对应的书
    private static Map<String, Book> bookMap = new HashMap<String, Book>();

    static {
        bookMap.put("1", new Book("1", "葵花宝典", "10", "牛前", "玉莲次用"));
        bookMap.put("2", new Book("2", "三国演义", "10", "牛前", "玉莲次用"));
        bookMap.put("3", new Book("3", "水浒传", "10", "牛前", "玉莲次用"));
        bookMap.put("4", new Book("4", "红楼梦", "10", "牛前", "玉莲次用"));
        bookMap.put("5", new Book("5", "西游记", "10", "牛前", "玉莲次用"));
    }

    public static Map<String, Book> findAllBooks() {
        return bookMap;
    }

    public static Book findBookById(String bookId) {
        return bookMap.get(bookId);
    }


}
