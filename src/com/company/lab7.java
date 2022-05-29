package com.company;
/*Design, develop and implement a C/C++/Java program to simulate the working of Shortest remaining time and Round Robin (RR) scheduling algorithms. Experiment with different quantum sizes for RR algorithm.*/
import java.util.*;
public class lab7  // main class that includes everything, including the main() method
{
    public static class Job     // class that represents a process
    {
        String pID;
        public int arrivalTime, burstTime, remainingTime, completionTime = 0, waitingTime = 0, turnAroundTime = 0;
        boolean isFinished = false;
        Job( String pid, int aT, int bT )
        {
            pID = pid;
            arrivalTime = aT;
            remainingTime = burstTime = bT;     // since remainingTime is essentially a duplicate of burstTime, both are initialised with the same value
        }
        public int execute( int currentTime, int timeQuantum )
        {
            if( remainingTime > timeQuantum )   // execute the process for 'timeQuantum' amount of time
            {
                remainingTime -= timeQuantum;
                return currentTime + timeQuantum;
            }
            else
            {
                currentTime += remainingTime;
                remainingTime = 0;
                isFinished = true;
                completionTime = currentTime;
                turnAroundTime = completionTime - arrivalTime;
                waitingTime = turnAroundTime - burstTime;
                return currentTime;
            }
        }
        public static void showResult( ArrayList<Job> jobs )
        {
            jobs.sort(Comparator.comparing(j -> j.pID));
            System.out.println("\n\nPID\t\tArrival Time\tBurst Time\tCompletion Time\t\tWaiting Time\tTurn-around Time\n");
            double  avgWaitingTime= 0, avgTurnAroundTime= 0;
            for( Job job: jobs )
            {
                System.out.printf("%s\t\t%d\t\t\t\t%d\t\t\t%d\t\t\t\t\t%d\t\t\t\t%d\n", job.pID, job.arrivalTime, job.burstTime, job.completionTime, job.waitingTime, job.turnAroundTime);
                avgWaitingTime += job.waitingTime;
                avgTurnAroundTime += job.turnAroundTime;
            }
            avgWaitingTime /= jobs.size();
            avgTurnAroundTime /= jobs.size();
            System.out.println("\nAverage waiting time: " + avgWaitingTime);
            System.out.println("Average turn-around time: " + avgTurnAroundTime);
        }
    }
    public static void RoundRobin( ArrayList<Job> jobs, int timeQuantum )
    {
        int currentTime = -1;                           // the current time at the processor
        Queue<Job> readyQueue = new LinkedList<>();     // a queue to hold the processes that are ready to execute
        jobs.sort(Comparator.comparingInt( j -> j.arrivalTime) );     // sort the list of processes by their arrival times
        while ( jobs.stream().anyMatch( it -> !it.isFinished ) )    // while at least one process is still remaining
        {
            if( readyQueue.isEmpty() )
            {
                currentTime++;      // if there are no processes that are ready, then increase the currentTime and look for newly arrived processes
                for ( Job job : jobs )
                {
                    if ( !job.isFinished && job.arrivalTime <= currentTime && !readyQueue.contains(job) )
                        readyQueue.add(job);
                }
                continue;
            }
            Job toExecute = readyQueue.remove();    // remove the process at the 'head' of the readyQueue and store it in toExecute
            currentTime = toExecute.execute(currentTime, timeQuantum);  // execute the process and update the value of currentTime
            for ( Job job : jobs ) {
                if (  !job.equals(toExecute) && !job.isFinished && job.arrivalTime <= currentTime && !readyQueue.contains(job) )
                    readyQueue.add(job);
            }
            if ( !toExecute.isFinished ) readyQueue.add(toExecute);
        }
        Job.showResult(jobs);
    }
    public static void SRTF( ArrayList<Job> jobs )
    {
        int currentTime = -1;
        Queue<Job> readyQueue = new LinkedList<>();
        jobs.sort(Comparator.comparingInt(j -> j.arrivalTime));
        while ( jobs.stream().anyMatch( it -> !it.isFinished ) )
        {
            if( readyQueue.isEmpty() )
            {
                currentTime++;
                for ( Job job : jobs )
                {
                    if ( !job.isFinished && job.arrivalTime <= currentTime && !readyQueue.contains(job) )
                        readyQueue.add(job);
                }
                continue;
            }
            Job toExecute = Collections.min(readyQueue, Comparator.comparingInt( j -> j.remainingTime ));
            currentTime = toExecute.execute(currentTime, 1);    // execute the process. timeQuantum is always 1 for SRTF
            if ( toExecute.isFinished )
                readyQueue.remove(toExecute);
        }
        Job.showResult(jobs);
    }
    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);          // to read the user-input
        ArrayList<Job> jobs = new ArrayList<>();        // to store the list of processes
        while( true )
        {
            jobs.clear();   // clear any previous processes
            System.out.print("\n1: Round Robin\t\t2: SRTF\t\t3: Exit\nEnter your choice: ");
            int choice = scan.nextInt();
            if (choice == 3) break;
            else
            {
                System.out.print("Enter the no. of processes: ");
                int n = scan.nextInt();
                System.out.println();
                for( int i = 0; i < n; i++ )
                {
                    System.out.print("Enter the arrival time and burst time for process " + (i + 1) + ": ");
                    int aT = scan.nextInt(), bT = scan.nextInt();
                    jobs.add( new Job("P" + (i + 1), aT, bT) );   // create a new 'Job' object and add it to the list
                }
                if( choice == 1 )
                {
                    System.out.print("\nEnter the time quantum: ");
                    int tQ = scan.nextInt();
                    RoundRobin(jobs, tQ);
                }
                if( choice == 2 )
                {
                    SRTF(jobs);
                }
                else System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}