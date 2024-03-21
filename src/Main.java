import java.util.ArrayList;
import java.util.Scanner;

/**
 * "Main" class in which all magic happens
 *
 * @author Ivan Popovych
 */
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

    /**
     * Menu function which outputs start menu and returns user choice
     *
     * @return user's choice
     */
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

    /**
     * Function in which testing of our project happens
     *
     * @param library passing the library object
     */
    public static void Program(Library library) {
        Scanner scan = new Scanner(System.in);
        int userChoice;
        boolean exitRequested = false;
        while (!exitRequested) { // loop until user decides to step back
            userChoice = LibraryMenu(); // user choice variable that collects input from the user
            switch (userChoice) { // switch menu
                case 1:
                    System.out.println("Add an author (write his name).");
                    String name = scan.nextLine();
                    if (library.containsAuthor(name)) { // if author's name is already in the list
                        System.out.println("This author is already in our list! Please try another one...");
                    } else {
                        Author author = new Author(name); // creating new author with a specified name
                        library.addAuthor(author); // adding author to the library
                        System.out.println("The author was successfully added to our list. Thanks for your help!");
                    }
                    break;
                case 2:
                    System.out.println("Add a book to our library!");
                    System.out.println("Write it's author:");
                    String authorName = scan.nextLine();
                    if (!library.containsAuthor(authorName)) { // if author's name is not in the list
                        System.out.println("There is no such author in our library! Please add one first...");
                    } else {
                        Author bookAuthor = library.getAuthor(authorName); // putting author's object with specified name in the variable
                        System.out.println("Write the book's name:");
                        String bookName = scan.nextLine();
                        Author.Book book = bookAuthor.new Book(bookName, bookAuthor); // creating new book that belongs to user's author
                        library.addBook(book); // adds the book to the library
                        System.out.println("The book was successfully added to our library. Thanks for your help!");
                    }
                    break;
                case 3:
                    System.out.println("Enter author's name whose book you want to remove:");
                    String authorRemName = scan.nextLine();
                    if (!library.containsAuthor(authorRemName)) { // if author's name is not in the list
                        System.out.println("There is no such author in our library! Please add one first...");
                    } else {
                        Author bookRemAuthor = library.getAuthor(authorRemName); // putting author's object with specified name in the variable
                        System.out.println("Write the book's name:");
                        String bookName = scan.nextLine();
                        if (!library.containsBook(bookName)) { // if the book is not in the library list
                            System.out.println("There is no such book in our library! Please add one first...");
                        } else {
                            Author.Book remBook = library.getBook(bookName);
                            library.removeBook(remBook); // removes the book from the list
                            System.out.println("The book was successfully deleted from our library!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter author's name who you want to remove:");
                    String authorRem = scan.nextLine();
                    if (!library.containsAuthor(authorRem)) { // if author's name is not in the list
                        System.out.println("There is no such author in our library! Please add one first...");
                    } else {
                        Author remAuthor = library.getAuthor(authorRem);
                        library.removeAuthor(remAuthor);
                        System.out.println("The author was successfully removed from our library");
                    }
                    break;
                case 5:
                    library.displayLibraryInfo(); // outputs some info with a list of library books
                    break;
                case 6:
                    exitRequested = true; // exitRequested = true - while loop ends
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
        System.out.println("4 - Remove an author");
        System.out.println("5 - Display info");
        System.out.println("6 - Back");
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