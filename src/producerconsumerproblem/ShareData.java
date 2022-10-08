package producerconsumerproblem;

/**
 *
 * @author quykhang
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ShareData {

    private BlockingQueue<Integer> shareData;
    private int max_size;
    private int count = 1;

    public ShareData() {
        shareData = new ArrayBlockingQueue<>(6);
        max_size = 6;
    }

    public ShareData(int max) {
        shareData = new ArrayBlockingQueue<>(max);
        max_size = max;
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized void addProduct() throws InterruptedException {
        while (shareData.size() == max_size) {
            System.out.println("Stock is full! Producers are waiting...");
            wait();
        }
        int x = count;
        shareData.put(x);
        System.out.println("Produced product with code: " + x + " - Stock's size: " + shareData.size());
        count++;
        notify();
    }

    public synchronized void takeProduct() throws InterruptedException {
        while (shareData.isEmpty()) {
            System.out.println("Stock is empty! Consumers are waiting...");
            wait();
        }
        System.out.println("Consumed product with code: " + shareData.element() + " - Stock's size: "
                + (shareData.size() - 1));
        shareData.take();
        notify();
    }

    public synchronized int size() {
        return shareData.size();
    }

    public synchronized int getElement() {
        return shareData.element();
    }
}

