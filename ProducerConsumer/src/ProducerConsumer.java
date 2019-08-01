import java.io.*;

class ProducerConsumer extends Thread {

    static float buffer[];  //bounded buffer
    final int n;            //max size of buffer
    static int p;           //producer pointer
    static int c;           //consumer pointer
    float number;
    int sPtr;
    boolean producer;       //whether a producer or a consumer
    static String task;     //stores task string

    ProducerConsumer() { //default constructor
        this.n = 5;
        buffer = new float[5];
        this.producer = true;
        number = 0;
        sPtr = 0;
    }

    ProducerConsumer(int n, boolean producer, String task) { //constructor to initialize
        this.n = n;
        buffer = new float[n];
        this.producer = producer;
        number = 0;
        sPtr = 0;
        this.task = task;
    }

    private synchronized boolean produce() { //called to produce
        if (producer) {
            if (p < n) {
                buffer[p] = number;
                p++;
                return true;
            }
        }
        return false;
    }

    private synchronized boolean consume() {  //called to consume
        if (!producer) {
            if (c < n) {
                {
                    buffer[p] = number;
                    p++;
                    return true;
                }
            }
        }
        return false;
    }

    public void run() {
        for (int i = 0; i < task.length(); i++) {
            if (task.charAt(i) == 'P')
                produce();
            if (task.charAt(i) == 'C')
                consume();
            System.out.println("Array:");
            for (int j = 0; j < n; j++)
                System.out.print(producer + " " + buffer[j]);
            System.out.println();
        }
    }
}

class PCMain {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter string: ");
            String str = br.readLine();
            System.out.println("Enter buffer length: ");
            int len = Integer.parseInt(br.readLine());

            ProducerConsumer p = new ProducerConsumer(len, true, str);
            ProducerConsumer c = new ProducerConsumer(len, false, str);
            p.start();
            c.start();
        } catch (IOException e) {
            System.err.println(e.toString());
        }
    }

}
