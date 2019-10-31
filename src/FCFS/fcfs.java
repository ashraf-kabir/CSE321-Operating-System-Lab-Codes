package FCFS;

import java.util.Scanner;

public class fcfs {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total number of process: ");
        int n = sc.nextInt();

        int pid[] = new int[n];              // process ids
        int ar[] = new int[n];               // arrival times
        int bt[] = new int[n];               // burst or execution times
        int ct[] = new int[n];               // completion times
        int ta[] = new int[n];               // turn around times
        int wt[] = new int[n];               // waiting times
        int temp;
        float avgwt = 0, avgta = 0;

        System.out.println("\n##Input Arrival Time One by One##\n");
        // arrival time
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " Arrival time: ");
            ar[i] = sc.nextInt();
            pid[i] = i + 1;
        }

        System.out.println("\n##Input Burst Time One by One##\n");
        // burst time
        for (int j = 0; j < n; j++) {
            System.out.println("Enter process " + (j + 1) + " Brust time: ");
            bt[j] = sc.nextInt();
            pid[j] = j + 1;
        }

        // sorting according to arrival times
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (ar[j] > ar[j + 1]) {
                    temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }

        // finding completion times
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ct[i] = ar[i] + bt[i];
            } else {
                if (ar[i] > ct[i - 1]) {
                    ct[i] = ar[i] + bt[i];
                } else
                    ct[i] = ct[i - 1] + bt[i];
            }
            ta[i] = ct[i] - ar[i]; // turnaround time= completion time- arrival time
            wt[i] = ta[i] - bt[i]; // waiting time= turnaround time- burst time
            avgwt += wt[i]; // total waiting time
            avgta += ta[i]; // total turnaround time
        }

        System.out.println("\nPid     AT      BT      CT      TaT     WT");

        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + "\t" + ar[i] + "\t" + "\t" + bt[i] + "\t" + "\t" + ct[i] + "\t" + "\t" + ta[i] + "\t" + "\t" + wt[i]);

        }
        sc.close();
        System.out.println("\nAverage Waiting Time: " + (avgwt / n));
        System.out.println("Average Turnaround Time:" + (avgta / n));
    }

}
