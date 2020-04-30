import java.util.Arrays;

/*Sort the book objects with authors using Comparable interface */
public class Book implements Comparable<Book>{

    private String title;
    private String author;


    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int compareTo(Book b) {
        return this.author.compareTo(b.author);
    }

    public static void main(String[] args) {

        Book[] books = new Book[3];

        books[0] = new Book("Selfish Gene", "Richard Dawkins");

        books[1] = new Book("Anna Karenina", "Leo Tolstoy");


        books[2] = new Book("Great Expectations", "Charles Dawkins");

        Arrays.sort(books);

        for (Book book : books) {
            System.out.println(book.getTitle() + ", " + book.getAuthor());
        }

    }
}
