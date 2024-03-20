import java.util.ArrayList;
import java.util.Set;

public class Library {
    ArrayList<Author> authors = new ArrayList<Author>();
    ArrayList<Author.Book> books = new ArrayList<Author.Book>();


    public Library(ArrayList<Author> authors, ArrayList<Author.Book> books) {
        this.authors = authors;
        this.books = books;
    }

    public boolean containsBook(String title) {
        for (Author.Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Author.Book getBook(String title) {
        for (Author.Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);

    }

    public boolean containsAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Author getAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }

    public void removeAuthor(Author author) {
        boolean removed = this.authors.remove(author);
        if (removed) {
            System.out.println("The author was removed successfully!");
        } else {
            System.out.println("It seems that there is no author with such name in the library...");
        }
    }

    public void addBook(Author.Book book) {
        this.books.add(book);
    }

    public void removeBook(Author.Book book) {
        boolean removed = this.books.remove(book);
        if (removed) {
            System.out.println("The book was removed successfully!");
        } else {
            System.out.println("It seems that there is no book with this title in the library...");
        }
    }

    public static class BookCatalog {
        private ArrayList<Author.Book> catalog;

        public BookCatalog(ArrayList<Author.Book> catalog) {
            catalog = this.catalog;
        }

        public void addToCatalog(Author.Book book) {
            this.catalog.add(book);
        }
    }

    public void displayLibraryInfo() {
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
