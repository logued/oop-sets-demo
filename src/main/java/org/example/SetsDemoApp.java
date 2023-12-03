package org.example;

/**
 * Set (part of the Java Collections Framework)  Revised: November 2023
 *
 * A Set is a collection of objects that:
 * - does NOT ALLOW DUPLICATE elements
 * - allows us to check if a Set contains a specific element or not
 *
 * Use-Case
 * A common use for a Set is to check if a particular value is
 * present in a Set very quickly.
 *
 * There are two 'concrete' class implementations of the Set interface:
 * (1) HashSet and (2) TreeSet
 *
 * HashSet uses a Hash Table for storage,
 * so access, insert and delete are all very fast: O(1) constant time complexity.
 * The hashCode() and equals() methods MUST be implemented in the class type
 * of the elements being stored in a Set, as both methods are used by the internal
 * hashtable mechanism. (These are inbuilt for String, Integer and Double)
 * Elements in a HashSet are not ordered.
 *
 * TreeSet uses a Binary Tree structure, so access is somewhat slower O(log n).
 * However, it maintains elements in their "natural ordering".
 * The element class must implement Comparable, or an appropriate Comparator
 * must be supplied in the TreeSet constructor.
 * When we iterate over the elements, they will always be in the order
 * determined by the compareTo() method, or the compare() method.
 *
 * The "Set" interface defines a number of operations common to
 * all Sets.  It is common practice to use a reference of interface
 * type Set to refer to a HashSet or TreeSet object.
 * i.e.  Set<String> names = new HashSet<>();
 *
 * Sets can only store objects (and not primitive types; so Integer but not int)
 */

import java.util.HashSet;
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
        treeSetWithComparator();// TreeSet of Books, sorted using a Comparator "bookTitleComparator"
        hashSetOfBookObjects(); // HashSet of Book object relies on hashCode() and equals() methods
    }

    public void hashSetOfString()
    {
        HashSet<String> namesSet = new HashSet<>();  // note reference of type Set

        // Note that the String class implements the hashCode() and the equals()
        // methods which are required to use a HashSet

        namesSet.add("Zoe");
        namesSet.add("Donald");
        namesSet.add("John");
        namesSet.add("Bill");
        namesSet.add("Bill");  // duplicate element will NOT be added (nothing changes in the Set)
        namesSet.remove("Donald");

        // The contains() method provides very fast check to see if a value is in the set. O(1)
        // It relies on hashCode() and equals() methods to locate and match elements
        // which are in-built in the String class.

        // A common use-case for Set is to use it as a fast mechanism to look up
        // a value in a set of values.  We check that the set contains the value.

        String name = "John";
        if (namesSet.contains(name)) {
            System.out.println(name + " is contained in the Set.");
        }
        else
            System.out.println(name + " NOT found in the Set");

        System.out.println("Display all elements in the HashSet - no duplicates, and NOT in order");

        displayStringElements(namesSet);
    }

    /**
     * TreeSet maintains order of its elements (using a Binary Tree structure internally).
     * The order of elements is determined by the inbuilt compareTo() method
     * provided in the String class. (String class implements the Comparable interface)
     * or, by a Comparator passed into the TreeSet constructor.
     */
    public void treeSetOfString()
    {
        TreeSet<String> carsTreeSet = new TreeSet<>();  // order based on Natural Ordering of String

        carsTreeSet.add("BMW");
        carsTreeSet.add("Nissan");
        carsTreeSet.add("Audi");
        carsTreeSet.add("Audi");  // duplicate will not be added
        carsTreeSet.add("Jaguar");
        carsTreeSet.add("Opel");

        System.out.println("Display Cars (String) from the TreeSet - no duplicates, in order");
        displayStringElements(carsTreeSet);

        //TODO
        // Write code to find out if the 'carsTreeSet' Set contains the given car or not
        // and display an appropriate message
        String car ="Maserati";
        // code here.....
    }

    /**
     * Using a TreeSet to store Book objects.
     * TreeSet maintains an ORDERING of its elements. To maintain an ordering,
     * the Book class must implement the Comparable interface
     * and thus, implement the compareTo() method.  (or provide a Comparator)
     * In this sample, the compareTo() method compares based
     * on the Book code field. So, two Books with the same code
     * cannot be added to the Set.  (as a Set does not allow duplicates)
     */
    public void treeSetOfBookObjects()
    {
        TreeSet<Book> bookTreeSet = new TreeSet<>();

        bookTreeSet.add(new Book(9999, "Jaws"));
        // Next one is a Duplicate, according to compareTo() method. So, it won't be added
        // The compareTo() compares  book code
        bookTreeSet.add(new Book(9999, "Jaws"));

        bookTreeSet.add(new Book(7777, "Jaws"));
        bookTreeSet.add(new Book(2222, "Heist"));

        bookTreeSet.add(new Book(4444, "Alien"));
        bookTreeSet.add(new Book(1111, "Tatoos"));
        bookTreeSet.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the TreeSet - no duplicates, in order of code field");

        for (Book book : bookTreeSet) {
            System.out.println(book);
        }

        Book book = new Book(7777, null ); // book to search for
        if( bookTreeSet.contains( book ) )// only the code is needed to search
            System.out.println("Book with title: " +  book.getTitle() +" is in the Set");
        else
            System.out.println("Not there!");
    }

    /**
     *  In this sample, TreeSet orders the elements
     *  using a supplied Comparator called "bookTitleComparator"
     *  This takes priority over the compareTo() method implemented
     *  in the Book class.
     *  We must write the comparator (see bookTitleComparator class)
     *  and pass it into the TreeSet constructor.
     *  This TreeSet will contain Books with UNIQUE Titles.
     */
    public void treeSetWithComparator()
    {
        Set<Book> bookTreeSet = new TreeSet<>( new bookTitleComparator() );
        // alternatively, you could pass a lambda to specify the compare

        bookTreeSet.add(new Book(9999, "Jaws"));
        bookTreeSet.add(new Book(9999, "Jaws"));     // Duplicate - will not be added.

        bookTreeSet.add(new Book(7777, "Jaws"));      // this is allowed

        bookTreeSet.add(new Book(9999, "Stardust"));
        bookTreeSet.add(new Book(2222, "Heist"));
        bookTreeSet.add(new Book(4444, "Alien"));
        bookTreeSet.add(new Book(1111, "Tattoos"));
        bookTreeSet.add(new Book(3333, "Life on Earth"));

        System.out.println("Books from the TreeSet - no duplicates,  in order "
                + "(sorted by title then code) - Using Comparator");

        for (Book book : bookTreeSet) {
            System.out.println(book);
        }

        //TODO
        // Write a second (separate) comparator class "BookCodeComparator" that will compare elements
        // by Code.
        // Change the argument passed to the TreeSet constructor and check that the output
        // matches your expected output.
    }

    /**
     *  In order to store Book objects in a HashSet - the Book class must
     *  implement the hashCode() and equals() methods
     *  (Both methods are used in the hashing and finding processes).
     *  Note that NO sorted order is maintained, not even the order they were
     *  added in. (unlike in a List or TreeSet , where the order is maintained - until modified)
     *  HashSet gives us very fast access ( contains() ), add() and remove().  O(1)
     */
    public void hashSetOfBookObjects()
    {
        HashSet<Book> bookHashSet = new HashSet<>();
        // hashCode() from books compare on code field only, therefore books are
        // equal if they have the same code.
        bookHashSet.add(new Book(9999, "Jaws"));
        bookHashSet.add(new Book(9999, "Jaws"));     // NO Duplicates allowed in Set
        bookHashSet.add(new Book(9999, "Stardust")); // nod duplicate allowed
        bookHashSet.add(new Book(2222, "Heist"));
        bookHashSet.add(new Book(4444, "Alien"));
        bookHashSet.add(new Book(1111, "Tatoos"));
        bookHashSet.add(new Book(3333, "Life on Earth"));

        System.out.println("Book from the HashSet - no duplicates,  NO particular order - not even chronological order");

        for (Book book : bookHashSet) {
            System.out.println(book);
        }

        //check if a particular Book is contained in a HashSet
        Book book = new Book(3333, "Alien" ); // book to search for

        if( bookHashSet.contains( book ) )// only the book code value will be used to compare elements
            System.out.println("Book with code: " +  book.getCode() +" is in the Set");
        else
            System.out.println("Not there!");
         }

    /**
     * Display all elements from a Set. (
     * @param set  - A Set (HashSet or TreeSet)
     * The interface type 'Set' is used to accept either HashSet or TreeSet
     */
    public void displayStringElements(Set<String> set)
    {
        for (String str : set)
            System.out.print(str + ", ");

        System.out.println();

        /**
         *   the for-each loop above is equivalent to using the following iterator
         *
         *   Iterator<String> iterator = set.iterator();
         *   while (iterator.hasNext()) {
         *       String str = iterator.next();
         *       System.out.print(str+", ");
         *   }
         */
    }
}
