package properties.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    public void systemPropertiesTests(){
        String browser = System.getProperty("browser");
        System.out.println(browser);//null
    }

    @Test
    public void systemPropertiesTests1(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);//chrome
    }

    @Test
    public void systemPropertiesTests2(){
        String browser = System.getProperty("browser","mozilla");
        System.out.println(browser);//mozilla
    }

    @Test
    public void systemPropertiesTests3() {
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);//chrome
    }

    @Test
    @Tag("property")
    public void systemPropertiesTests4() {
        String browser = System.getProperty("browser", "mozilla");
        System.out.println(browser);
        //gradle property_test -Dbrowser=opera
    }
}
