public class BackupPageHelper extends PageHelper
{
    /**@return the index of the page put into memory first */
    @Override
    public int getEvictionIndex() 
    {
        int processNumber = getMemoryOrdered().peek().number;
        int i = 0;
        for (Page p : getMemoryTable())
        {
            if (p.number == processNumber)
                return i;
            ++i;
        }
        return -1; // this should never happen
    }
}