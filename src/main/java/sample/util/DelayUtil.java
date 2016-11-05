package sample.util;

public class DelayUtil {
    public static void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //ignore..for demo.
        }
    }
}
