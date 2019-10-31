import java.io.DataInputStream;
import java.io.IOException;

public class bankersAlgorithm {

    public static void main(String args[]) throws IOException {

        int all[][] = new int[10][10];           //to store allocation matrix
        int max[][] = new int[10][10];           //to store maximum allocation
        int need[][] = new int[10][10];          //need is stored in it
        int avail[] = new int[10];               //availability of process allocation
        int ord[] = new int[10];                 //stores order of process
        int flags[] = new int[10];               //flag states that process executed
        int i, j, pr, res, count = 0, flag = 0;

        DataInputStream dis = new DataInputStream(System.in);
        System.out.println("Enter no of processes : ");           //input for no of processes
        pr = Integer.parseInt(dis.readLine());
        System.out.println("Enter no.of resources : ");
        res = Integer.parseInt(dis.readLine());                     //input for no. of resources
        System.out.println("Enter allocation matrix : ");

        for (i = 0; i < pr; i++) {
            for (j = 0; j < res; j++) {
                all[i][j] = Integer.parseInt(dis.readLine());       //allocation matrix input
            }
        }

        System.out.println("Enter max matrix : ");
        for (i = 0; i < pr; i++) {
            for (j = 0; j < res; j++) {
                max[i][j] = Integer.parseInt(dis.readLine());     //max matrix input
                need[i][j] = max[i][j] - all[i][j];                 //calculate need matrix
            }
        }

        System.out.println("Enter avail matrix : ");
        for (j = 0; j < res; j++) {
            avail[j] = Integer.parseInt(dis.readLine());        // availability matrix
        }

        for (j = 0; j < pr; j++) {
            flags[j] = -1;
            System.out.println("Busy");                        //each process flag is made -1 i.e. not inserted
        }

        System.out.println("Need matrix : ");
        for (i = 0; i < pr; i++) {
            for (j = 0; j < res; j++) {
                System.out.print(need[i][j] + " ");
            }
            System.out.println();
        }

        int t = 0;
        while (count < pr) {
            for (i = 0; i < pr; i++) {
                if (flags[i] == -1) {                           //if flags[i]==-1 means process is not inserted
                    System.out.print("i =" + i +"    ");
                    flag = 0;
                    for (j = 0; j < res; j++) {
                        if (need[i][j] > avail[j]) {
                            flag = 1;                                 //check whether each resource is satisfying given condition
                        }

                    }
                    System.out.print("flag =" + flag +"    ");
                    if (flag == 0) {
                        for (j = 0; j < res; j++) {
                            avail[j] = avail[j] + all[i][j];      //after process inserted avail increamented
                        }
                        count++;
                        ord[t++] = i;                           //executed process’s order is stored
                        flags[i] = 1;                            //flags[i]=1 marks process executed
                    }
                    System.out.print("c =" + count +"  ");
                    for (j = 0; j < res; j++)
                        System.out.print(avail[j]);
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("Order: ");
        for (i = 0; i < pr; i++) {
            System.out.print(ord[i] +" ");              //process order is displayed
        }
    }

}
