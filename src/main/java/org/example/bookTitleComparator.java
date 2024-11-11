package org.example;

/**                                                 Nov 2024
 * Comparator that will compare Books based on title.
 * Passed into TreeSet constructor so is used instead of
 * the Natural Ordering.
 */

import java.util.Comparator;

public class bookTitleComparator implements Comparator<Book> {

    public int compare(Book book1, Book book2)
    {
        return book1.getTitle().compareTo(book2.getTitle());
    }
}