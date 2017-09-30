import java.util.*;

public class ShortestRemainingTime {

	private PriorityQueue<Job> waitingJobs;//sort by runtime
	private PriorityQueue<Job> workingJobs;//sort by runtime
	private Job jobBeingWorked;

	int timer = 0;



	static Comparator<Job> compareByArrivalTime = new Comparator<Job>(){
		@Override
		public int compare(Job o1, Job o2) {
			// TODO Auto-generated method stub

			float oneComparison = o1.arrivalTime;
			float twoComparison = o2.arrivalTime;

			if(oneComparison < twoComparison)
				return -1;
			if(oneComparison > twoComparison)
				return 1;
			return 0;
		}

	};
	private static Comparator<Job> compareByRemainingTime = new Comparator<Job>(){
		@Override
		public int compare(Job o1, Job o2) {
			// TODO Auto-generated method stub

			float oneComparison = o1.getTimeLeft();
			float twoComparison = o2.getTimeLeft();

			if(oneComparison < twoComparison)
				return -1;
			if(oneComparison > twoComparison)
				return 1;
			return 0;
		}

	};


	/////////Constructors//////////////////////////////////
	public ShortestRemainingTime(){                     
		waitingJobs = new PriorityQueue<>(compareByRemainingTime);
		workingJobs = new PriorityQueue<Job>(compareByRemainingTime);
	}



	private Queue<Job> doJobs(PriorityQueue<Job> queue){
		//new queue length will be this integer when the jobs are all finished
		int limit = queue.size();
		//dummy queue because you don't want to change the data of actual queue
		PriorityQueue<Job> dummyQ = new PriorityQueue<>(queue);
		
		//queue to return 
		Queue<Job> newQueue = new LinkedList<Job>();
		
		//we already have the queue sorted by arrival time
		//need a queue sorted by time remaining
		PriorityQueue<Job> jobsWorking = new PriorityQueue<Job>(compareByRemainingTime);

		//timer goes to the time the first job is seen
		timer = (int)queue.peek().expectedRunTime;
		Job jobFinishing;
		Job jobAdding;
		while(newQueue.size() != limit){//loop until 100 quanta
			//
			if(dummyQ.peek() != null &&(int)dummyQ.peek().arrivalTime + 1 <= timer){
				jobAdding = dummyQ.poll();
				jobAdding.setStartTime(timer);
				jobsWorking.add(jobAdding);
			}
			if(jobsWorking.size() != 0){
				jobsWorking.peek().doJob();
				if(jobsWorking.peek().isComplete()){
					jobFinishing = jobsWorking.poll();
					jobFinishing.setEndTime(timer);
					dummyQ.remove(jobFinishing);
					newQueue.add(jobFinishing);
				}
			}

			timer++;
		}

		return newQueue;

	}

	public static void main(String[] args){
		Random r = new Random();
		PriorityQueue<Job> arg = Job.JOBS();
		ShortestRemainingTime str = new ShortestRemainingTime();
		Queue<Job> q = str.doJobs(arg);

		for(Job j : q)
			System.out.println(j.getEndTime() + " " + j.arrivalTime + " " + j.getExpectedRunTime() + "  " + j.name);
		//rand.nextInt((max - min) + 1) + min;
	}

}