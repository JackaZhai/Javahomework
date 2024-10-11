package chapter3workdemo.libary.catalogue;

import chapter3workdemo.libary.Person;

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
            String[] parts = bibtex.split(",");
            String title = parts[1].split("=")[1].trim().replace("{", "").replace("}", "");
            String author = parts[2].split("=")[1].trim().replace("{", "").replace("}", "");
            String isbn = parts[3].split("=")[1].trim().replace("{", "").replace("}", "");
            int year = Integer.parseInt(parts[4].split("=")[1].trim().replace("{", "").replace("}", ""));
            String[] authorName = author.split(" ");
            return new Book(title, new Person(authorName[0], authorName[1]), isbn, year);
        } catch (Exception e) {
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
