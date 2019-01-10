package gavryshg.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by gaw on 3/17/2018.
 */
@WebListener
public class ExampleServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(final ServletRequestEvent sre) {
        System.out.println("ExampleServletRequestListener.requestDestroyed");
    }

    @Override
    public void requestInitialized(final ServletRequestEvent sre) {
        System.out.println("ExampleServletRequestListener.requestInitialized");
    }
}
