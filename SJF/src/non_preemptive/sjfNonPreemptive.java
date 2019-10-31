package non_preemptive;

import java.util.Scanner;

public class sjfNonPreemptive {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the total no. of process: ");
        int n = sc.nextInt();

        int pid[] = new int[n];
        int at[] = new int[n];             // arrival time
        int bt[] = new int[n];             // burst time
        int ct[] = new int[n];             // complete time
        int ta[] = new int[n];             // turn around time
        int wt[] = new int[n];             // waiting time
        int f[] = new int[n];              // flag
        int st = 0, tot = 0;
        float avgwt = 0, avgta = 0;

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + "'s Arrival Time:");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + "'s Burst Time:");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
            f[i] = 0;
        }

        boolean a = true;
        while (true) {
            int c = n, min = 999;
            if (tot == n) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }

        System.out.println("\nPid     AT      BT      CT      TaT     WT");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out.println(pid[i] + "\t" + "\t" + at[i] + "\t" + "\t" + bt[i] + "\t" + "\t" + ct[i] + "\t" + "\t" + ta[i] + "\t" + "\t" + wt[i]);
        }
        System.out.println("\nAverage Turnaround Time is " + (avgta / n));
        System.out.println("Average Waiting Time is " + (avgwt / n));
        sc.close();
    }

}
