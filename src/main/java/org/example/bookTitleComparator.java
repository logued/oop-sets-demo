package org.example;

/**                                                 Nov 2023
 * Comparator that will compare Books based on title code.
 * Passed into TreeSet constructor so is used instead of
 * the Natural Ordering.
 */

import java.util.Comparator;

public class bookTitleComparator implements Comparator<Book> {

    public int compare(Book book1, Book book2)
    {
        return Integer.compare(book1.getCode(),book2.getCode());
    }
}