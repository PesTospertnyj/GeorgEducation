package gavryshg.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by gaw on 3/17/2018.
 */
@WebListener
public class ExampleRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(final ServletRequestAttributeEvent srae) {
        System.out.println("ExampleRequestAttributeListener.attributeAdded");
        System.out.println(String.format("name [%s] value [%s]", srae.getName(), srae.getValue()) );
    }

    @Override
    public void attributeRemoved(final ServletRequestAttributeEvent srae) {
        System.out.println("ExampleRequestAttributeListener.attributeRemoved");
        System.out.println(String.format("name [%s] value [%s]", srae.getName(), srae.getValue()) );
    }

    @Override
    public void attributeReplaced(final ServletRequestAttributeEvent srae) {
        System.out.println("ExampleRequestAttributeListener.attributeReplaced");
        System.out.println(String.format("name [%s] value [%s]", srae.getName(), srae.getValue()) );
    }
}
