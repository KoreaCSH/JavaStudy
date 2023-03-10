package properties;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("timeout", "30");
        properties.setProperty("language", "kr");
        properties.setProperty("size", "10");
        properties.setProperty("capacity", "10");

        Enumeration e = properties.propertyNames();

        while(e.hasMoreElements()) {
            String element = (String)e.nextElement();
            System.out.println(element + " = " + properties.getProperty(element));
        }
        System.out.println();

        properties.setProperty("size", "20");
        System.out.println("size = " + properties.getProperty("size"));
        System.out.println("capacity = " + properties.getProperty("capacity" , "20"));
        System.out.println("loadfactor = " + properties.getProperty("loadfactor", "0.75"));
        System.out.println(properties);

        System.out.println();
        properties.list(System.out);
    }

}
