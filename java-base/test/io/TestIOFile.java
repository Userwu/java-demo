package io;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Properties;

/**
 * java基础学习.
 * Date: 2017/1/12 0012
 * Time: 0:39
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
public class TestIOFile {
    @Test
    public void testCopy(){
        new IOFile().copy();
    }

    @Test
    public void testUseReadForCopy(){
        new IOFile().useReadForCopy();
    }
    @Test
    public void testPath(){
        final Properties props = System.getProperties();
        final Enumeration<?> enumeration = props.propertyNames();
        while (enumeration.hasMoreElements()){
            final Object o = enumeration.nextElement();
            System.out.println("键："+o+"--->  值:"+props.get(o));
        }
    }
    @Test
    public void testUserBuffer(){
        new IOFile().useBuffer();
    }
    @Test
    public void testUsePushBack(){
        new IOFile().usePushBack();
    }
    @Test
    public void testUseScanner(){
        new IOFile().userScanner();
    }
}
