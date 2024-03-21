import java.util.ArrayList;
import java.util.Set;

/**
 * "Library" class with main functional of our program
 */
public class Library {
    ArrayList<Author> authors = new ArrayList<Author>();
    ArrayList<Author.Book> books = new ArrayList<Author.Book>();


    public Library(ArrayList<Author> authors, ArrayList<Author.Book> books) {
        this.authors = authors;
        this.books = books;
    }

    /**
     * function which checks the availability of the book in the list by it's title
     *
     * @param title title of the book which availability we want to check
     * @return boolean value, true - if book is in the list, false - if not
     */
    public boolean containsBook(String title) {
        for (Author.Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * getter
     *
     * @param title title of the book which we want to take
     * @return book object
     */
    public Author.Book getBook(String title) {
        for (Author.Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * adds author in our list
     *
     * @param author
     */
    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    /**
     * Function which checks if the author is in the list by his name
     *
     * @param name
     * @return boolean value, true - if author is in the list, false - if not
     */
    public boolean containsAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * getter
     *
     * @param name
     * @return author object
     */
    public Author getAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    /**
     * removes author from the list only if he has no books in the library
     *
     * @param author
     */
    public void removeAuthor(Author author) {
        boolean removed = containsAuthor(author.getName());
        if (removed) {
            boolean f = false;
            for (Author i : authors) {
                for (Author.Book book : books) {
                    if (book.getAuthor() == i) {
                        f = true;
                        System.out.println("Firstly, you need to remove all books of this author!");
                        break;
                    }
                }
                if (f) break;
            }
            if (!f) {
                this.authors.remove(author);
                System.out.println("The author and was removed successfully!");
            }
        } else {
            System.out.println("It seems that there is no author with such name in the library...");
        }
    }

    /**
     * adds book to the list
     *
     * @param book
     */
    public void addBook(Author.Book book) {
        this.books.add(book);
    }

    /**
     * removes book from the list
     *
     * @param book
     */
    public void removeBook(Author.Book book) {
        boolean removed = this.books.remove(book);
        if (removed) {
            System.out.println("The book " + book.getTitle() + " by " + book.getAuthor().getName() + " was removed successfully!");
        } else {
            System.out.println("It seems that there is no book with this title in the library...");
        }
    }

    /**
     * static class "BookCatalog" which helps showing some information about the library.
     */
    public static class BookCatalog {
        private ArrayList<Author.Book> catalog;

        public BookCatalog(ArrayList<Author.Book> catalog) {
            catalog = this.catalog;
        }

        public void addToCatalog(Author.Book book) {
            this.catalog.add(book);
        }
    }

    /**
     * function that displays information about the library
     */
    public void displayLibraryInfo() {
        /**
         * inner class which does the main functional
         */
        class LibraryInfo {
            public void display() {
                if (books.isEmpty()) {
                    System.out.println("There are no books in our library. We will be happy if you will add one! Thanks ;)");
                } else {
                    System.out.println("Number of books in the library: " + books.size());
                    System.out.println("List of the books:");
                    for (Author author : authors) {
                        for (Author.Book book : books) {
                            if (author == book.getAuthor()) {
                                System.out.println(book.getTitle() + " by " + author.getName());
                                System.out.println("...");
                            }
                        }
                    }
                }
            }
        }
        LibraryInfo info = new LibraryInfo();
        info.display();
    }
}
