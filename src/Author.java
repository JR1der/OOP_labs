/**
 * "Author" class with inner class "Book"
 *
 * @author Ivan Popovych
 */
public class Author {
    private String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public class Book {
        private String title;
        private Author author;

        public Book(String title, Author author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return this.title;
        }

        public Author getAuthor() {
            return this.author;
        }
    }
}
