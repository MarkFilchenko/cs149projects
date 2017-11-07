
/**
 * Implementation of the least-frequently-used paging algorithm
 */
public class LFU extends PageHelper
{

    /**
     * @return index of the least frequently used process in the page table
     */
    public int getEvictionIndex()
    {
        int index = 0, min = 0, i = 0;
        for (Page p : getMemoryTable())
        {
            if (i == 0)
            {
                min = p.number;
                index = i;
            }
            // new min found, reset min
            else if (min > p.number)
            {
                min = p.number;
                index = i;
            }
            i++;
        }
        getMemoryTable().get(index).number = 0; // reset useCount after index found
        return index;
    }

}

