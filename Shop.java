
/**
 * Gets books/cds/movies from the warehouse and sells them
 */
import java.util.List;
import java.util.ArrayList;

public class Shop
{
    // instance variables - replace the example below with your own
    private List<Book> books;
    private List<CD> cds;
    private List<Movie> movies;
    Warehouse warehouse = null;

    private int sellableBooks = 0;
    private int sellableCDs = 0;
    private int sellableMovies = 0;

    /**
     * Constructor for objects of class Shop
     */
    public Shop()
    {
        warehouse = new Warehouse();
        books = warehouse.getBooks();
        cds = warehouse.getCDs();
        movies = warehouse.getMovies();

        executeSellable();
    }

    /**
     * calculates total amount of items that are available
     */
    public void executeSellable()
    {
        for(int i = 0; i < books.size(); ++i){
            if(books.get(i).getAvailable() > 0){
                ++sellableBooks;
            }
        }

        for(int i = 0; i < movies.size(); ++i){
            if(movies.get(i).getAvailable() > 0){
                ++sellableMovies;
            }
        }

        for(int i = 0; i < cds.size(); ++i){
            if(cds.get(i).getAvailable() > 0){
                ++sellableCDs;
            }
        }
    }

    /**
     * @return (how many books in the warehouse)
     */
    public final int getSellableBooks()
    {
        return sellableBooks;
    }

    /**
     * @return (how many cds in the warehouse)
     */
    public final int getSellableCDs()
    {
        return sellableCDs;
    }

    /**
     * @return (how many movies in the warehouse)
     */
    public final int getSellableMovies()
    {
        return sellableMovies;
    }

    public final List<Book> getBooks()
    {
        return books;
    }

    public final List<CD> getCDs()
    {
        return cds;
    }

    public final List<Movie> getMovies()
    {
        return movies;
    }   

    /**
     * shows what's for sale
     * @param (Iselection)
     */
    public String displaySalesItems(int pselection)
    {
        String text = "";
        int j = 1;
        //         we are looking at books. 
        // Yes, the user wants to buy books.
        if(pselection == 1){
            System.out.println("Type the number to choose a book\n");
            books = warehouse.getBooks();
            for(int i = 0; i < books.size(); ++i){
                if(books.get(i).getAvailable() > 0){
                    books.get(i).setID(j++);
                    text += books.get(i).getID() + " " + books.get(i).toString();
                }
            }
            return text;
        }     

        if(pselection == 2){
            System.out.println("Type the number to choose a CD\n");
            cds = warehouse.getCDs();
            for(int i = 0; i < cds.size(); ++i){
                if(cds.get(i).getAvailable() > 0){
                    cds.get(i).setID(j++);
                    text += cds.get(i).getID() + " " + cds.get(i).toString();
                }
            }
            return text;
        }
        if(pselection == 3){
            System.out.println("Type the number to choose a Movie\n");
            movies = warehouse.getMovies();
            for(int i = 0; i < movies.size(); ++i){
                if(movies.get(i).getAvailable() > 0){
                    movies.get(i).setID(j++);
                    text += movies.get(i).getID() + " " + movies.get(i).toString();
                }
            }
            return text;
        }
        return text;

    }

    /**
     * sell a book, returns a receipt
     * @param (Iselection)
     * @return (Dprice)
     */
    public double sellBook(int pselection)
    {
        for(int i = 0; i < books.size(); ++i){ //loop through the entire list
            if(pselection == books.get(i).getID()){ //and now we've found the specified item
                books.get(i).sellCopies(1);
                return books.get(i).getPrice();
            }
        }
        return 0;
    }

    /**
     * rates the book
     * @param (Iselection, Irating)
     */
    public void rateBook(int pselection, int prating)
    {
        for(int i = 0; i < books.size(); ++i){ //loop through the entire list
            if(pselection == books.get(i).getID()){ //and now we've found the specified item
                books.get(i).updateRating(prating);
            }
        }
    }

    /** 
     * sells a cd, returns a receipt
     * @param (Iselection)
     * @return (Dprice)
     */
    public double sellCD(int pselection)
    {
        for(int i = 0; i < cds.size(); ++i){ //loop through the entire list
            if(pselection == cds.get(i).getID()){ //and now we've found the specified item
                cds.get(i).sellCopies(1);
                return cds.get(i).getPrice();
            }
        }
        return 0;
    }

    /**
     * @param (Iselection, Irating)
     */
    public void rateCD(int pselection, int prating)
    {
        for(int i = 0; i < cds.size(); ++i){ //loop through the entire list
            if(pselection == cds.get(i).getID()){ //and now we've found the specified item
                cds.get(i).updateRating(prating);
            }
        }
    }

    /** 
     * sells a movie, returns a receipt
     * @param (Iselection)
     * @return (Dprice)
     */
    public double sellMovie(int pselection)
    {
        for(int i = 0; i < movies.size(); ++i){ //loop through the entire list
            if(pselection == movies.get(i).getID()){ //and now we've found the specified item
                movies.get(i).sellCopies(1);
                return movies.get(i).getPrice();
            }
        }
        return 0;
    }

    /**
     * @param (Iselection, Irating)
     */
    public void rateMovie(int pselection, int prating)
    {
        for(int i = 0; i < movies.size(); ++i){ //loop through the entire list
            if(pselection == movies.get(i).getID()){ //and now we've found the specified item
                movies.get(i).updateRating(prating);
            }
        }
    }

    /**
     * displays a string which says ‘Sold x books, y CDs and z movies, total revenue $xxx’.
     */
    public String show()
    {
        String text = "Sold ";
        int bookSold = 0, cdSold = 0, movieSold = 0;
        double revenue = 0;

        for(int i = 0; i < books.size(); ++i){ //get total of books sold
            bookSold += books.get(i).getSold();
            //find the price, multiply with the amount sold
            revenue += books.get(i).getPrice() * books.get(i).getSold();
        }

        for(int i = 0; i < cds.size(); ++i){ //get total cds sold
            cdSold += cds.get(i).getSold();
            revenue += cds.get(i).getPrice() * cds.get(i).getSold();
        }

        for(int i = 0; i < movies.size(); ++i){ //get total movies sold
            movieSold += movies.get(i).getSold();
            revenue += cds.get(i).getPrice() * cds.get(i).getSold();
        }

        text += bookSold + " books, " + cdSold + " CDs, and " + movieSold + " movies, total revenue $" + revenue + ".";
        return text;
    }

    /**
     * A test harness, demonstrates how the real show would work when storing to files is enabled.
     * displays a string which says ‘Sold x books, y CDs and z movies, total revenue $xxx’.
     */
    public String testShow()
    {
        String text = "Sold ";
        int bookSold = 0, cdSold = 0, movieSold = 0;
        double revenue = 0;

        //feed application with dummy data
        for(int i = 0; i < books.size(); ++i){
            books.get(i).sellCopies(10);
        }

        for(int i = 0; i < cds.size(); ++i){
            cds.get(i).sellCopies(10);
        }

        for(int i = 0; i < movies.size(); ++i){
            movies.get(i).sellCopies(10);
        }

        for(int i = 0; i < books.size(); ++i){ //get total of books sold
            bookSold += books.get(i).getSold();
            //find the price, multiply with the amount sold
            revenue += books.get(i).getPrice() * books.get(i).getSold();
        }

        for(int i = 0; i < cds.size(); ++i){ //get total cds sold
            cdSold += cds.get(i).getSold();
            revenue += cds.get(i).getPrice() * cds.get(i).getSold();
        }

        for(int i = 0; i < movies.size(); ++i){ //get total movies sold
            movieSold += movies.get(i).getSold();
            revenue += cds.get(i).getPrice() * cds.get(i).getSold();
        }

        text += bookSold + " books, " + cdSold + " CDs, and " + movieSold + " movies, total revenue $" + revenue + ".";
        return text;
    }

    /**
     * test harness to test the pop_front rating function
     * and also to get the average for a book
     */
    public String testRating()
    {
        String text = "1st 20: \n";

        //feed application with dummy data
        for(int i = 0; i < 100; ++i){
            books.get(0).updateRating(10);
        }

        for(int i = 0; i < 20; ++i){
            text += i+1 + ": " + books.get(0).getRating().getScoreByIndex(i) + "\n";
        }
        text += "\npushing rating #101\n";
        text += "\nLast 20: \n" ;
        //push another in, remove front, add to back
        books.get(0).updateRating(5);
        for(int i = 80; i < 100; ++i){
            text += i+1 + ": " + books.get(0).getRating().getScoreByIndex(i) + "\n";
        }
        
        text += "\nThe average rating for: " + books.get(0).toString() + " is: " + books.get(0).getAverageRating();        

        return text;
    }
}
