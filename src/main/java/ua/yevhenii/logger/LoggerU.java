package ua.yevhenii.logger;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;

import java.security.SecureRandom;
import java.util.Random;

public class LoggerU {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static void writeToLog(Logger logger, String message){
        logger.info(message + randomString(7*1024));
    }

    public static String randomString( int len ){
        if(len < 0){
            return "";
        }
        StringBuilder sb = new StringBuilder( len );
        for( int i = 0; i < len; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }


}
