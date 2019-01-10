package gavryshg.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by gaw on 4/2/2018.
 */
@WebListener
public class ExampleSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(final HttpSessionBindingEvent event) {
        System.out.println(String.format("ExampleSessionAttributeListener.attributeAdded name [%s] value [%s]", event.getName(), event.getValue() ));
    }

    @Override
    public void attributeRemoved(final HttpSessionBindingEvent event) {
        System.out.println(String.format("ExampleSessionAttributeListener.attributeRemoved name [%s] value [%s]", event.getName(), event.getValue() ));
    }

    @Override
    public void attributeReplaced(final HttpSessionBindingEvent event) {
        System.out.println(String.format("ExampleSessionAttributeListener.attributeReplaced name [%s] value [%s]", event.getName(), event.getValue() ));
    }
}
