package producerconsumerproblem;

/**
 *
 * @author quykhang
 */

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    private ShareData shareData;

    public Consumer(ShareData s) {
        shareData = s;
    }

    @Override
    public void run() {
        try {
            while (true) {
                shareData.takeProduct();
                Thread.sleep(2000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
