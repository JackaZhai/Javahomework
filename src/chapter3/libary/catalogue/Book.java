package chapter3.libary.catalogue;

import chapter3.libary.Person;

public class Book extends CatalogueItem {

    private Person author;
    private String isbn;

    public Book(String title) {
        // TODO: Implement
    }
    public Book(String title, Person author) {
        // TODO: Implement
    }

    public Book(String title, Person author, String isbn) {
        // TODO: Implement
    }

    public Book(String title, Person author, String isbn, int year) {
        this(title, author, isbn);
    }


    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person person) {
        this.author = person;
    }

    @Override
    public boolean equals(Object other) {
        // TODO: Implement
        return false;
    }

    public static Book fromBibtex(String bibtex) {
        try {
            // 使用逗号分隔符将Bibtex字符串分割成多个部分
            String[] parts = bibtex.split(",");
            // 提取标题并去除大括号
            String title = parts[1].split("=")[1].trim().replace("{", "").replace("}", "");
            // 提取作者并去除大括号
            String author = parts[2].split("=")[1].trim().replace("{", "").replace("}", "");
            // 提取ISBN并去除大括号
            String isbn = parts[3].split("=")[1].trim().replace("{", "").replace("}", "");
            // 提取年份并去除大括号
            int year = Integer.parseInt(parts[4].split("=")[1].trim().replace("{", "").replace("}", ""));
            // 将作者字符串按空格分割成名字和姓氏
            String[] authorName = author.split(" ");
            // 使用提取的信息创建一个Book对象
            return new Book(title, new Person(authorName[0], authorName[1]), isbn, year);
        } catch (Exception e) {
            // 如果在解析过程中出现任何异常，抛出IllegalArgumentException
            throw new IllegalArgumentException("Invalid BibTex entry");
        }
    }

    /**
     * Returns a string representation of a book
     *
     * @return A string representation of a book in
     * the format "Book: Author=<{@link Person#toString()}>; ISBN=<ISBN>;Title=<title>"
     */
    @Override
    public String toString() {
        // TODO: Implement
        return null;
    }

    @Override
    public int hashCode() {
        // TODO: Implement
        return 0;
    }

}
