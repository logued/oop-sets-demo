package org.example;

/**
 * Set  (part of the Java Collections Framework)  Revised: February 2022
 *
 * A Set is a collection that does NOT ALLOW DUPLICATE elements.
 *
 * There are two concrete class implementations of the Set interface:
 * (1) HashSet and (2) TreeSet
 *
 * HashSet uses a Hash Table for storage,
 * so access, insert and delete are all very fast: O(1).
 * The hashCode() and equals() methods MUST be implemented for HashSet in the
 * class of the elements being used, as both methods are used by the internal
 * hash table mechanism.
 *
 * TreeSet uses a Binary Tree structure, so access is somewhat slower O(log n).
 * However, it maintains elements in their "natural ordering", by elements
 * implementing Comparable, or by the element class supplying a Comparator.
 *
 * The "Set" interface defines a number of operations common to
 * all Sets.  It is good practice to use a reference of interface type Set to
 * refer to a HashSet or TreeSet object.
 *
 * Sets can store only objects (and not primitive types; so Integer but not int)
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetsDemoApp {

    public static void main(String[] args)
    {
        SetsDemoApp app = new SetsDemoApp();
        app.start();
 }

    public void start() {
        System.out.println("Set Demonstration App - Sets store UNIQUE values - No Duplicates allowed");
        hashSetOfString();      // HashSet of String objects
        treeSetOfString();      // TreeSet of String objects, sorts elements
        treeSetOfBookObjects(); // TreeSet of Books sorted using Comparable - compareTo()
        treeSetWithComparator();// TreeSet of Books, sorted using a Comparator "ComparatorBookTitleCode"
        hashSetOfBookObjects(); // HashSet of Book object relies on hascCode() and equals() methods
    }

    public void hashSetOfString()
    {
        Set<String> names = new HashSet<>();  // note reference of type Set

        // Note that the String class implements the hashCode() and the equals()
        // methods which are required to use a HashSet

        names.add("Zoe");
        names.add("Donald");
        names.add("John");
        names.add("Bill");
        names.add("Bill");  // duplicate element will not be added (nothing changes in the Set)
        names.add("Adam");
        names.add("Niamh");
        names.remove("Donald");

        // The contains() method gives fast 'hash table' access O(1)
        // It relies on hashCode() and equals() methods to match elements.

        String name = "John";
        if (names.contains(name)) {
            System.out.println(name + " is in the Set.");
        }
        else
            System.out.println(name + " NOT found in the Set");

        System.out.println("Names from the HashSet - no duplicates, and NOT in order");
        display(names);
    }

    public void treeSetOfString()    // TreeSet - sorted order maintained
    {
        Set<String> cars = new TreeSet<>(); // TreeSet maintains sorted order
        // using a Binary Tree structure

        // The order of elements here is determined by the compareTo() method
        // provided in the String class. (String class implements the Comparable interface)

        cars.add("Nissan");
        cars.add("BMW");
        cars.add("Audi");
        cars.add("Audi");  // duplicate will not be added
        cars.add("Jaguar");

        System.out.println("Cars (String) from the TreeSet - no duplicates, sorted in order");
        display(cars);

        //TODO
        // complete the code to find out if the 'cars' Set contains the given car or not
        // and display an appropriate message
        String car ="Maserati";
        // code here.....

    }

    public void treeSetOfBookObjects()
    {
        Set<Book> books = new TreeSet<>();  // TreeSet maintains sorted order
        // determined by the compareTo() defined in Book class

        // To use a TreeSet to store Book objects, the Book class must implement
        // the Comparable interface and thus override compareTo().
        // (Alternatively, use a Comparator (shown below)).
        // See the compareTo() method in the Book class which compares firstly on book code
        // and then on title (i.e "title within code")

        books.add(new Book(9999, "Jaws"));      // won't be added, NO Duplicates books allowed in a Set
        books.add(new Book(9999, "Jaws"));      // uses compareTo() to identify duplicates.
        books.add(new Book(7777, "Jaws"));      // this is allowed, as it is not a duplicate book
        books.add(new Book(2222, "Heist"));
        books.add(new Book(4444, "Alien"));
        books.add(new Book(1111, "Tatoos"));
        books.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the TreeSet - no duplicates, in order (by code then title)");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void treeSetWithComparator()
    {
        // In this sample, TreeSet maintains sorted order
        // using a supplied Comparator called "ComparatorBookTitleCode"
        // This takes priority over the compareTo() method implemented
        // in the Book class.
        // We must write the comparator (see ComparatorBookTitleCode class)

        Set<Book> books = new TreeSet<>( new ComparatorBookTitleCode() );

        books.add(new Book(9999, "Jaws"));
        books.add(new Book(9999, "Jaws"));     // no duplicates, compareTo() used
        books.add(new Book(7777, "Jaws"));      // this is allowed, as it is not a duplicate book
        books.add(new Book(9999, "Stardust"));
        books.add(new Book(2222, "Heist"));
        books.add(new Book(4444, "Alien"));
        books.add(new Book(1111, "Tatoos"));
        books.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the TreeSet - no duplicates,  in order "
                + "(sorted by title then code) - Using Comparator");

        for (Book book : books) {
            System.out.println(book);
        }

        //TODO
        // Write a second (separate) comparator class ComparatorCodeTitle that will order elements
        // by Title within Code  (ie, book code gets priority, and then book title).
        // Change the argument passed to the TreeSet constructor and check that the output
        // matches your expected output.
    }

    public void hashSetOfBookObjects()
    {
        Set<Book> books = new HashSet<>();

        // The Book class must implement the hashCode() and equals() methods
        // if Book objects are to be stored in a HashSet. (Both methods
        // are used in the hashing process).
        // Note that NO sorted order is maintained, not even the order they were
        // added in. (unlike in a List , where the order is maintained - until modified)

        books.add(new Book(9999, "Jaws"));
        books.add(new Book(9999, "Jaws"));     // NO Duplicates allowed in Set
        books.add(new Book(7777, "Jaws"));      // this is allowed, as it is not a duplicate book
        books.add(new Book(9999, "Stardust"));
        books.add(new Book(2222, "Heist"));
        books.add(new Book(4444, "Alien"));
        books.add(new Book(1111, "Tatoos"));
        books.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the HashSet - no duplicates,  NO particular order - not even chronological order");

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void display(Set<String> set)  // The interface type 'Set' is used
    {                                     // to accept either HashSet or TreeSet

        System.out.println("Display set using for() loop:");
        for (String s : set)
            System.out.println(s);

        // the above loop is equivalent to using the following iterator

//        System.out.println("Display set using Iterator:");
//
//         Iterator iter = set.iterator();
//         while (iter.hasNext())
//            System.out.println(iter.next());

    }
}
