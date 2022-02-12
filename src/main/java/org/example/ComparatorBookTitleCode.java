package org.example;

/**                                                 Feb 2022
 * Comparator that will compare Books based on title + book code.
 * Used by TreeSet (or other sorting methods)
 */

import java.util.Comparator;

public class ComparatorBookTitleCode implements Comparator<Book> {

    public int compare(Book book1, Book book2)
    {
        // Concatenate (i.e. join) the title + code fields for comparison purposes.
        // Compares on "book code within title" order (i.e. title first)

        // Note, this is the opposite of what was done in the compareTo()
        // method in the Book class to demonstrate a difference.

        return (book1.title+book1.code).compareTo(book2.title+book2.code);
    }
}