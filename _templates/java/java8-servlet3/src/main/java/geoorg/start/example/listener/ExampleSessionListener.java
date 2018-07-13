package gavryshg.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by gaw on 4/2/2018.
 */
@WebListener
public class ExampleSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(final HttpSessionEvent se) {
        System.out.println("ExampleSessionListener.sessionCreated");
    }

    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
        System.out.println("ExampleSessionListener.sessionDestroyed");
    }
}
