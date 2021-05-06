package round;

import java.util.Scanner;

public class Round {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int wtime[], btime[], rtime[], num, quantum, total;                                      // value initialization
        

        wtime = new int[10];
        btime = new int[10];
        rtime = new int[10];
                                                                                             // setting up max value
        System.out.println("enter number of processes(10 as a max )");
        num = s.nextInt();
        System.out.println("enter burst time ");                                              //btime == runtime
        for (int i = 0; i < num; i++) {
            System.out.print("P[" + (i + 1) + "]");

            btime[i] = s.nextInt();
            rtime[i] = btime[i];
            wtime[i] = 0;

        }
        System.out.println("enter quantum");                                                // quantum 
        quantum = s.nextInt();
        int rp = num;
        int i = 0;
        int time = 0;
                                                                                    // rp = number of processes
        wtime[0] = 0;
        int wait[] = new int[num];
                                                                                    // start loop with to conditions first when the rtime is bigger than the q or when it's smaller or equal
        while (rp != 0) {
            if (rtime[i] > quantum) {

                rtime[i] = rtime[i] - quantum;
                System.out.print("/P[" + (i + 1) + "]/");
                time += quantum;
                System.out.println(time);

            } else if (rtime[i] <= quantum && rtime[i] > 0) {
                time += rtime[i];
                rtime[i] = rtime[i] - rtime[i];
                System.out.print("/P[" + (i + 1) + "]/");
                rp--;
                System.out.println(time);

            }

            i++;
            if (i == num) {

                i = 0;
            }

        }

        do {
            for (i = 0; i < num; i++) {
                if (btime[i] > quantum)                                                         //do another loop for wait time calculation with familiar condiotns quantum is less than burst time
                {
                    for (int j = 0; j < num; j++) {
                        if (j != i && btime[j] != 0) {
                            wtime[j] += quantum;
                        }
                    }

                    btime[i] -= quantum;
                } else {
                    for (int j = 0; j < num; j++) {
                        if (j != i && btime[j] != 0) {
                            wtime[j] += btime[i];
                        }
                    }

                    btime[i] = 0;
                }
            }

            total = 0;

            for (i = 0; i < num; i++) {
                total += btime[i];
            }

        } while (total != 0);//if there all process burst time will become 0 then stop the do while loop    

        //now assign one variable to get the total of all waiting time
        float total_wait = 0;

        for (i = 0; i < num; i++) {

            total_wait += wtime[i];
        }

        System.out.println("Average waiting time is: " + (total_wait / num));
    }
}
