package chapter3workdemo.libary;

import chapter3workdemo.libary.catalogue.Book;
import chapter3workdemo.libary.catalogue.FileReadWrite;

import java.io.IOException;

public class APP {
    public void app() {
        Library centralLibrary = new Library("centralLibrary", 10);

        // 创建 Book1
        Person author1 = new Person("Robert", "Martin");
        Book book1 = new Book("Clean Code", author1, "9780136083238", 2008);
        book1.setCopies(25);

        // 读取并创建 Book2
        try {
            String bibtex = FileReadWrite.readerFile("resources/Lee60.bib");
            Book book2 = Book.fromBibtex(bibtex);
            book2.setCopies(30);

            // 将书籍添加到目录中
            centralLibrary.addItem(book1);
            centralLibrary.addItem(book2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
