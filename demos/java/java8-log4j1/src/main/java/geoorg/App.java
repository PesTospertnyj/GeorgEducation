package geoorg;

import org.apache.log4j.Logger;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static Logger LOGGER = Logger.getLogger(App.class);

    public static void main( String[] args )
    {
        Runnable runnable = () -> {
            LOGGER.trace("Hello trace");
            LOGGER.debug("debug");
            LOGGER.error("error");
            LOGGER.fatal("fatal");
            LOGGER.info("Hello java 8 and log4j-1");
        };
        new Thread(runnable).start();
    }
}
