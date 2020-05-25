package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RepositoryParser {
	public FileInputStream stream;
	public String RepositoryFile;
	public static Properties propertyFile = new Properties();

	public RepositoryParser(String file) throws IOException {
		
		this.RepositoryFile = file;
		stream = new FileInputStream(RepositoryFile);
		propertyFile.load(stream);
		
	}
	
	public static String getBrowserInfo(String filename)
	{
		String actualfile=propertyFile.getProperty(filename);
		return actualfile;
	}

	

}
