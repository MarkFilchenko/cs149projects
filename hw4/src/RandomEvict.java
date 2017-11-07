import java.util.Random;
public class RandomEvict extends PageHelper {
	/**@return the index of a random page in the memory table
	     */
	@Override
	public int getEvictionIndex() 
	{
		Random r = new Random();
		return r.nextInt(getMemoryTable().size()); // never happens
	}

}
