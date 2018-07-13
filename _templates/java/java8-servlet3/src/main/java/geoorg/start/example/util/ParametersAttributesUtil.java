package geoorg.start.example.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by gaw on 3/19/2018.
 */
public class ParametersAttributesUtil {
    public static void printRequestParameters(HttpServletRequest request) {
        System.out.println("request info:");
        final Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            final String attrName = attributeNames.nextElement();
            System.out.println(String.format("Attribute name [%s] value [%s]",
                    attrName, request.getAttribute(attrName) ));
        }
    }

    public static void printAllServletContextInitParameters(ServletContext servletContext){
        final Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        System.out.println("All servlet context init parameters:");
        while (initParameterNames.hasMoreElements()) {
            final String initParameterName = initParameterNames.nextElement();
            final String initParameterValue = servletContext.getInitParameter(initParameterName);
            final String output = String.format("\t name = [%s] value = [%s]", initParameterName, initParameterValue);
            System.out.println(output);
        }
    }
}
