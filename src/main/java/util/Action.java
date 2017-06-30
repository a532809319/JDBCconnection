package util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by hukai on 2017/6/29.
 */
public class Action {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Action.class.getClassLoader().getResourceAsStream("a.properties");

            properties.load(inputStream);

           System.err.print("1");

        }catch (Exception e){
            System.err.print("2");


        }
       System.err.print("3");

    }
}
