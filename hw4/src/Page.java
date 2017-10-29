/**
 * Class represents a page and holds data relevant for pages and Paging Algorithms
 * 
 */
public class Page 
{
    public boolean inMemory;
    public int number;
    public int lastReferenced;
        
    public Page(int number)
    {
        this.inMemory = false;
        this.number = number;
        this.lastReferenced = -1;
    }
}