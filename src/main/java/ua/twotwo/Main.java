package ua.twotwo;



import ua.twotwo.service.impl.StationServiceImpl;
import org.apache.log4j.Logger;


public class Main {
    final static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {


        logger.debug("log");
        logger.warn("log");
        logger.info("log");
        logger.trace("log");
    }
}
