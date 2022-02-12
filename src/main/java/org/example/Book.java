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
    public int hashCode()
    {
        int hash = 7;
        hash = 47 * hash + this.code;
        hash = 47 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
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