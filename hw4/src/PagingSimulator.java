
public class PagingSimulator 
{
    public static final int SIM_RUNS = 5;
    
    private static class Simulator
    {
        private PageHelper page;
        private String pageStr;
        private double hitRatioSum;
        
        public Simulator(PageHelper page, String pageStr)
        {
            this.page = page;
            this.pageStr = pageStr;
            this.hitRatioSum = 0.0;
        }
    }    
    
    public static void main(String[] args)
    {
        Simulator[] sims = new Simulator[] 
        {
            new Simulator(new FIFO(), "First In First Out"),
            //LRU
            //LFU
            //MFU
            //random pick
           
        };       
        
        for (int i = 0; i < SIM_RUNS; ++i)
        {
            System.out.println("+------------------------------+");
            System.out.format("| Starting Simulation Run %d    |\n", i + 1);
            System.out.println("+------------------------------+");
            
            for (Simulator sim : sims)
            {
                System.out.println("--------------------------------");
                System.out.format("Using %s Algorithm\n", sim.pageStr);
                System.out.print("--------------------------------");
                
                sim.page.simulate();
                
                double hitRatio = sim.page.getHitRatio();
                sim.hitRatioSum += hitRatio;
                System.out.format("\nHit Ratio: %f\n", hitRatio);
                
                sim.page.reset();//ended one simulation run
            }
        }        
        System.out.println("--------------------------------");
        System.out.format("Average Hit Ratios over %d runs:\n", SIM_RUNS);
        
        for (Simulator sim : sims)
            System.out.format("    %s: %f\n", sim.pageStr, sim.hitRatioSum / SIM_RUNS);
    }
}
