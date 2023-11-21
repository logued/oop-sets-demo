package org.example;


/*                                             Reviewed: January 2019
 *
 *  Book class  - focus: hashCode, equals(), compareTo()
 *
 * HashSet
 *  If objects of this class are to be stored in a HashSet, then this
 *  class must override hashCode() and equals() methods.
 *
 * TreeSet
 *  If objects of this class are to be stored in a TreeSet, then this
 *  class must implement the Comparable Interface [i.e. implement compareTo() ].
 *  Alternatively, a Comparator can be specified for the TreeSet on creation.
 *
 */


import java.util.Objects;

public class Book implements Comparable<Book> {

    int code;       // i.e. scanner code
    String title;

    public Book(int code, String title)
    {
        this.code = code;
        this.title = title;
    }

    @Override
    public int compareTo(Book other)
    {
        // Concatenate (join) the code and title fields for comparison purposes.
        // Sorts on "title within book-code" order.

        return (Integer.toString(this.code)+this.title).compareTo(Integer.toString(other.code)+other.title);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return code == book.code && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title);
    }

    @Override
    public String toString()
    {
        return "Book{" + "code=" + code + ", title=" + title + '}';
    }

    public int getCode()
    {
        return code;
    }

    public String getTitle()
    {
        return title;
    }
}