
/**
 * Abstract class Media - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Media
{
    protected String author = null;
    protected String title = null;
    protected int id = 0;
    protected int available = 0;
    protected double price = 0.0;
    protected Rating rating = new Rating();
    protected int sold = 0;
    
    public void setID(int pid)
    {
        id = pid;
    }

    /**
     * @return (id)
     */
    public final int getID()
    {
        return id;
    }

    /**
     * @param (# of copies available)
     */
    public void setAvailable(int pavailable)
    {
        available = pavailable;
    }

    /**
     * @return (available)
     */
    public final int getAvailable()
    {
        return available;
    }

    /**
     * @param (the price as a double)
     */
    public void setPrice(double pprice)
    {
        price = pprice;
    }
    
    /**
     * @return (Dprice)
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @param (Isold)
     */
    public void setSold(int psold)
    {
        sold = psold;
    }
    
    /**
     * @return (# sold)
     */
    public final int getSold()
    {
        return sold;
    }
    
    /**
     * Sells the copies, updates sold
     * @return # of successful transactions
     * for now, only sell one copy per transaction
     */
    public int sellCopies(int howMany)
    {
        if(available > 0 && available >= howMany){
            sold += howMany;
            available -= howMany;
        }
        
        return available;
    }

    /**
     * updates the rating
     */
    public void updateRating(int newRating)
    {
        rating.updateRating(newRating);
    }
    
    /**
     * @return (rating)
     */
    public final Rating getRating()
    {
        return rating;
    }
    
    /**
     * @return (IaverageRating)
     */
    public int getAverageRating()
    {
        return rating.getAverage();
    }
}
