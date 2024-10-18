package chapter3.libary;

import chapter3.libary.catalogue.CatalogueItem;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class Library {
    /**
     * Use this constant to initialise the catalogue
     */
    private final int CATALOGUE_CAPACITY = 100;
    private String name;
    private CatalogueItem[] catalogue;
    private Loan[] loans;
    private int loanLength;

    /**
     * Constructor that initialises the library name to "Library"
     * and the loan length to 10 days
     */
    public Library() {

    }

    /**
     * Constructor that takes a library name as parameter and
     * initialises the loan length to 10 days
     * @param name The name of the library
     */
    public Library(String name) {
        // TODO: Implement
    }

    /**
     * 采用库名称和借用长度的构造函数
     * 作为参数
     * @param name The name of the library
     * @param loanLength The number of days books should be loaned for
     */
    public Library(String name, int loanLength) {
        this.name = name;
        this.loanLength = loanLength;
    }

    /**
     * Returns a simple welcome message
     * @return "Welcome to <library name>"
     */
    public String welcome() {
        return "Welcome to " + this.name;
    }

    /**
     * 返回库名称
     * @return Library name
     */
    public String getName() {
        // TODO: Implement
        return null;
    }

    /**
     * 将给定的书籍添加到目录中。
     *
     * @param newItem 要添加到目录的商品
     * @return 如果目录中有空间并且成功添加新商品，则返回 true; 否则返回 false
     */
    public boolean addItem(CatalogueItem newItem) {
        for (int i = 0; i < catalogue.length; i++) {
            if (catalogue[i] == null) {
                catalogue[i] = newItem;
                return true;
            }
        }
        return false;
    }

    /**
     * Finds item with given title or ISBN and removes a copy from the catalogue.
     * Assumes there are no duplicated title or ISBN.
     * @param titleOrISBN Exact title or ISBN of the item to be removed.
     */
    public void removeItem(String titleOrISBN) {
        // TODO: Implement
    }

    /**
     * 查找具有给定标题或 ISBN 的项目，并从目录中删除给定数量的副本。
     * 假设没有重复的标题或 ISBN。
     * @param titleOrISBN Exact title or ISBN of the item to be removed
     * @param n Number of copies to remove
     */
    public void removeItem(String titleOrISBN, int n) {
        // TODO: Implement
    }

    /**
     * 根据确切的书名或 ISBN 登记图书的借阅。
     * 
     * @param titleOrISBN The title or ISBN of the book to be loaned
     * @param user Name of user loaning catalogue item
     * @return true if the item's title or ISBN exist in the catalogue and there is a copy available; false otherwise
     * @throws ItemNotFoundException if a book with the given title does not exist in the catalogue
     * @throws NoCopyAvailableException if there are no copies available of the given book
     */
    public boolean loanItem(String titleOrISBN, Person user) throws ItemNotFoundException, NoCopyAvailableException {
        CatalogueItem item = findItem(titleOrISBN);
        if (item == null) {
            throw new ItemNotFoundException("Item with title or ISBN " + titleOrISBN + " not found.");
        }
        if (item.getCopies() <= 0) {
            throw new NoCopyAvailableException("No copies available for item with title or ISBN " + titleOrISBN);
        }
        item.setCopies(item.getCopies() - 1);
        Loan loan = new Loan(item, user, loanLength);
        // 假设 loans 数组已经初始化并且有足够的空间
        for (int i = 0; i < loans.length; i++) {
            if (loans[i] == null) {
                loans[i] = loan;
                return true;
            }
        }
        return false;
    }

    /**
     * Find an item in the catalogue given a title or ISBN.
     * 
     * @param titleOrISBN Title or ISBN of item to find
     * @return The catalogue item found or null otherwise
     */
    private CatalogueItem findItem(String titleOrISBN) {
        // TODO: Implement
        return null;
    }

    /**
     * Mark the item in a Returns a given loan
     */
    public void returnItem(Loan loan) {
        // TODO: Implement
    }

    /**
     * Extends the given loan
     */
    public void extendLoan(Loan loan, int days) {
        // TODO: Implement
    }

    /**
     * Return the number of copies available for a given catalogue item
     * @param item the item
     * @return number of copies available for the given item
     */
    public int copiesAvailable(CatalogueItem item) {
        // TODO: Implement
        return -1;
    }

    /**
     * Returns the current list of books in the catalogue excluding nulls
     *
     * @return Array of books contained in the catalogue (excluding nulls)
     */
    public CatalogueItem[] getCatalogue() {
        // TODO: Implement
        return null;
    }

    /**
     * Print the full catalogue in the following format (sorted by title)
     * ====================
     * <Output of call to {@link Library#welcome()}>
     * Catalogue
     * ====================
     * <对项中方法 toString 的调用输出>
     * ====================
     */
    public void printCatalogue() {
        System.out.println("====================");
        System.out.println(welcome());
        System.out.println("Catalogue");
        System.out.println("====================");
        for (CatalogueItem item : catalogue) {
            if (item != null) {
                System.out.println(item.toString());
                System.out.println("====================");
            }
        }


    }

    /**
     * Print the list of loans that are overdue (i.e., due date has passed),
     * sorted by the number of days they are overdue by, and in the following
     * format:
     * ====================
     * Loans Overdue
     * ====================
     * <Output of call to {@link Loan#toString()}; one overdue loan>
     * ====================
     */
    public void printOverdue() {
        // TODO: Implement
    }

}
