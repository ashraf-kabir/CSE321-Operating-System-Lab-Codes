import java.io.*;

public class FIFO {

    public static void main(String[] args) throws Exception {

        int f, p, num = 0, pageHit = 0;
        int pages[];
        int frame[];
        boolean flag = true;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number of frames : ");
        f = Integer.parseInt(br.readLine());
        System.out.println("Enter number of pages : ");
        p = Integer.parseInt(br.readLine());

        frame = new int[f];
        pages = new int[p];

        for (int i = 0; i < f; i++) {
            frame[i] = -1;
        }

        System.out.println("Enter page number : ");
        for (int i = 0; i < p; i++)
            pages[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < p; i++) {
            flag = true;
            int page = pages[i];
            for (int j = 0; j < f; j++) {
                if (frame[j] == page) {
                    flag = false;
                    pageHit++;
                    break;
                }
            }
            if (num == f)
                num = 0;

            if (flag) {
                frame[num] = page;
                num++;
            }
            System.out.print("frame : ");
            for (int k = 0; k < f; k++)
                System.out.print(frame[k] + " ");
            System.out.println();

        }
        System.out.println("No. of page hit : " + pageHit);
    }
}
