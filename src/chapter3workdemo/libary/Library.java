package chapter3workdemo.libary;


import cqjtu.java.libary.catalogue.CatalogueItem;

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
     * Constructor that takes a library name and the loan length
     * as parameters
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
        // TODO: Implement
        return null;
    }

    /**
     * Returns the library name
     * @return Library name
     */
    public String getName() {
        // TODO: Implement
        return null;
    }

    /**
     * Add the given book to the catalogue.
     *
     * @param newItem Item to be added to catalogue
     * @return Returns true if there is space in the catalogue and new item is successfully added; false otherwise
     */
    public boolean addItem(CatalogueItem newItem) {
        // TODO: Implement
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
     * Find item with given title or ISBN and remove a given number of copies from the catalogue.
     * Assumes there are no duplicated title or ISBN.
     * @param titleOrISBN Exact title or ISBN of the item to be removed
     * @param n Number of copies to remove
     */
    public void removeItem(String titleOrISBN, int n) {
        // TODO: Implement
    }

    /**
     * Registers the loan of a book given its exact title or ISBN.
     * 
     * @param titleOrISBN The title or ISBN of the book to be loaned
     * @param user Name of user loaning catalogue item
     * @return true if the item's title or ISBN exist in the catalogue and there is a copy available; false otherwise
     * @throws ItemNotFoundException if a book with the given title does not exist in the catalogue
     * @throws NoCopyAvailableException if there are no copies available of the given book
     */
    public boolean loanItem(String titleOrISBN, Person user) {
        // TODO: Implement
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
     * <Output of call to method toString in the item>
     * ====================
     */
    public void printCatalogue() {
        // TODO: Implement
    };

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
