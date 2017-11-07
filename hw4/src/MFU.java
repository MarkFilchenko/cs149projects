
/**
 * Implementation of the most-frequently-used paging algorithm
 */
public class MFU extends PageHelper
{

    /**
     * @return index of the most frequently used process in the page table
     */
    public int getEvictionIndex()
    {
        int index = 0, max = 0, i = 0;
        for (Page p : getMemoryTable())
        {
            // new max found, reset max
            if (max < p.number)
            {
                max = p.number;
                index = i;
            }
            i++;
        }
        getMemoryTable().get(index).number = 0; // reset useCount after index found
        return index;
    }
}

