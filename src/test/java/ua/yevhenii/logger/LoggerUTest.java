package ua.yevhenii.logger;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUTest {
    @Test
    public void testRandomString() {
        int len = 40;
        String str = LoggerU.randomString(len);
        Assert.assertEquals(len, str.length());

        len = -1;
        str = LoggerU.randomString(len);
        Assert.assertEquals("", str);

        len = 0;
        str = LoggerU.randomString(len);
        Assert.assertEquals("", str);
    }

    @Test
    public void testWriteToLog(){
        Logger logger = LoggerFactory.getLogger(LoggerUTest.class);
    }

}