package org.example;        // DL note to self, Student may be better example, fbame, lname, dob, an no pk in fields
/*                       Reviewed: Nov 23
 *
 *  Book class  - focus: hashCode(), equals(), compareTo()
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

public class Book implements Comparable<Book>           // Comparable needed for TreeSet (if no Comparator provided)
{
    private final int code;         // final makes these immutable
    private final String title;     //    immutable (unchangable) objects are desired as if changes are made to a
                                    //    field then the hash mechanism will file

    public Book(int code, String title) {
        this.code = code;
        this.title = title;
    }

    /**
     * Provides the "Natural Ordering" of elements - needed for TreeSet sample.
     * @param other the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Book other)    {
        return Integer.compare(this.code,other.code);
    }


    /**
     *  equals() and hashCode() are required for using HashSet
     *  in this case we are comparing only on code field.
     *
     * @param o - other Book object
     * @return true or false
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return code == book.code; //  comparing only on code (int)
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
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