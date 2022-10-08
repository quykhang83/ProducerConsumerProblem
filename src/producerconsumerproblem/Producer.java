package producerconsumerproblem;

/**
 *
 * @author quykhang
 */
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private ShareData shareData;

    public Producer(ShareData s) {
        shareData = s;
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                shareData.addProduct();
                Thread.sleep(1500);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

