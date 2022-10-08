package producerconsumerproblem;

/**
 *
 * @author quykhang
 */
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(
                "//---------------  PRESS ENTER TO STOP THE PROCESS  ---------------//");
        Scanner sc = new Scanner(System.in);
        int max_size;
        System.out.print("Enter size of stock: ");
        max_size = sc.nextInt();
        ShareData shareData = new ShareData(max_size);

        // Create producers with number which is inputed from keyboard
        System.out.print("Number of producer: ");
        int numProducer = sc.nextInt();
        Producer producer[] = new Producer[numProducer];
        Thread prThread[] = new Thread[numProducer];
        for (int i = 0; i < numProducer; i++) {
            producer[i] = new Producer(shareData);
            prThread[i] = new Thread(producer[i]);
        }

        // Create consumers with number which is inputed from keyboard
        System.out.print("Number of consumer: ");
        int numConsumer = sc.nextInt();
        Consumer consumer[] = new Consumer[numConsumer];
        Thread conThread[] = new Thread[numConsumer];
        for (int i = 0; i < numConsumer; i++) {
            consumer[i] = new Consumer(shareData);
            conThread[i] = new Thread(consumer[i]);
        }
        System.out.print("\n");

        // Start Producer & Consumer Thread
        for (int i = 0; i < numConsumer; i++) {
            conThread[i].start();
        }
        for (int i = 0; i < numProducer; i++) {
            prThread[i].start();
        }
        Thread.sleep(500);
        try {
            //Press enter to stop the process
            if (System.in.read() != ' ') {
                System.exit(0);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

