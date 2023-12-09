package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertyFile {

	public static void main(String[] args) throws IOException {
		//to read values from config file
FileReader fr= new FileReader("C:\\Users\\hp\\eclipse-workspace\\TestAutomationFrmework\\src\\test\\resources\\configfiles\\config.properties");
Properties p= new Properties();
p.load(fr);
System.out.println(p.getProperty("browser"));
System.out.println(p.getProperty("testurl"));

	}

}
