package chapter3workdemo.libary;

import cqjtu.java.libary.catalogue.CatalogueItem;

import java.time.LocalDateTime;

public class Loan {
    
    private CatalogueItem item;
    private Person user;
    private LocalDateTime loanDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnedDate;

    /**
     * Constructor that takes as parameters the item being loaned,
     * the user borrowing the item, and the loan length.
     * Sets the loan date and time to
     * the current date using {@link LocalDateTime#now()},
     * the due date to the current date plus loan length
     * and the returned date to null.
     * 
     * @param item CatalogueItem being loaned
     * @param user Person loaning item
     * @param loanLength Number of days the loan is valid for
     */
    public Loan(CatalogueItem item, Person user, int loanLength) {
        // TODO: Implement
    }

    public CatalogueItem getItem() {
        // TODO: Implement
        return null;
    }

    public Person getUser() {
        // TODO: Implement
        return null;
    }

    public LocalDateTime getLoanDate() {
        // TODO: Implement
        return null;
    }

    public LocalDateTime getReturnedDate() {
        // TODO: Implement
        return null;
    }

    public LocalDateTime getDueDate() {
        // TODO: Implement
        return null;
    }

    /**
     * Prints loan receipt in the following format:
     * <Loan date in format dd-MM-yyyy HH-mm-ss>
     * <User name> has borrowed <Book title>
     * Date due: <Date item is due to be returned>
     * Returned: <Returned date and time in format dd-MM-yyyy HH-mm-ss if already returned; otherwise "n/a">
     * Thank you!
     */
    public void printReceipt() {
        // TODO: Implement
    }

    /**
     * Updates field {@link Loan#returnedDate} with current date and time
     * @throws ItemAlreadyReturnedException if the item was already returned
     */
    public void returnItem() {
        // TODO: Implement
    }

    /**
     * Extends the loan term by adding the given amount of days to field {@link Loan#dueDate}
     * @throws ItemAlreadyReturnedException if the item was already returned
     */
    public void extendLoan(int days) {
        // TODO: Implement
    }

    /**
     * Returns a string representation of a Loan
     *
     * @return A string representation of a loan in
     * the format "Loan: User=<User name>; Item=<Book title>; Type=<"Book" or "Magazine">; Due=<Due date dd-MM-yyyy>"
     */
    @Override
    public String toString() {
        // TODO: Implement
        return null;
    }
}