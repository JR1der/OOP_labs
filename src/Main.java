import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // creating a scanner
        int userChoice;
        ArrayList<Author> authors = new ArrayList<Author>();
        ArrayList<Author.Book> books = new ArrayList<Author.Book>();
        Library library = new Library(authors, books);
        boolean exitRequested = false; // boolean to check if you had pressed the exit button (3)
        while (!exitRequested) { // loop until user decides to exit the program
            userChoice = Menu(); // user choice variable that collects input from the user
            switch (userChoice) { // switch menu
                case 1:
                    Program(library);
                    break;
                case 2:
                    System.out.println("Exiting the program");
                    exitRequested = true; // bool is true - exits the program
                default:
                    System.out.println("...");
            }
        }
    }

    public static int Menu() {
        Scanner scan = new Scanner(System.in);
        int choice = 0; // init of choice variable
        System.out.println("Choose what you want to do:");
        System.out.println("___________________________");
        System.out.println("1 - Start");
        System.out.println("2 - Exit");
        System.out.println("___________________________");
        try {
            System.out.println("You picked:");
            choice = scan.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR! Insert an integer to choose your future actions!");
        }
        return choice; // returns choice in the main
    }

    public static void Program(Library library) {
        Scanner scan = new Scanner(System.in);
        int userChoice;
        boolean exitRequested = false;
        while (!exitRequested) { // loop until user decides to step back
            userChoice = LibraryMenu(); // user choice variable that collects input from the user
            switch (userChoice) { // switch menu
                case 1:
                    System.out.println("Add an author (write his name).");
                    String name = scan.next();
                    if (library.containsAuthor(name)) {
                        System.out.println("This author is already in our list! Please try another one...");
                    } else {
                        Author author = new Author(name);
                        library.addAuthor(author);
                        System.out.println("The author was successfully added to our list. Thanks for your help!");
                    }
                    break;
                case 2:
                    System.out.println("Add a book to our library!");
                    System.out.println("Write it's author:");
                    String authorName = scan.next();
                    if (!library.containsAuthor(authorName)) {
                        System.out.println("There is no such author in our library! Please add one first...");
                    } else {
                        Author bookAuthor = library.getAuthor(authorName);
                        System.out.println("Write the book's name:");
                        String bookName = scan.next();
                        Author.Book book = bookAuthor.new Book(bookName, bookAuthor);
                        library.addBook(book);
                        System.out.println("The book was successfully added to our library. Thanks for your help!");
                    }
                    break;
                case 3:
                    System.out.println("Enter author's name whose book you want to remove:");
                    String authorRemName = scan.next();
                    if (!library.containsAuthor(authorRemName)) {
                        System.out.println("There is no such author in our library! Please add one first...");
                    } else {
                        Author bookRemAuthor = library.getAuthor(authorRemName);
                        System.out.println("Write the book's name:");
                        String bookName = scan.next();
                        if (!library.containsBook(bookName)) {
                            System.out.println("There is no such book in our library! Please add one first...");
                        } else {
                            Author.Book remBook = library.getBook(bookName);
                            library.removeBook(remBook);
                            System.out.println("The book was successfully deleted from our library!");
                        }
                    }
                    break;
                case 4:
                    library.displayLibraryInfo();
                    break;
                case 5:
                    exitRequested = true;
                    System.out.println("Taking a step back...");

                default:
                    System.out.println("...");
            }
        }
    }

    public static int LibraryMenu() {
        Scanner scan = new Scanner(System.in);
        int choice = 0; // init of choice variable
        System.out.println("Choose what you want to do:");
        System.out.println("___________________________");
        System.out.println("1 - Add an author");
        System.out.println("2 - Add a book");
        System.out.println("3 - Remove a book");
        System.out.println("4 - Display info");
        System.out.println("5 - Back");
        System.out.println("___________________________");
        try {
            System.out.println("You picked:");
            choice = scan.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR! Insert an integer to choose your future actions!");
        }
        return choice; // returns choice in the main
    }
}