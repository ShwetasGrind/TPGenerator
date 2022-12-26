package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiles {

	public static String globalPropertyFile(String strval) throws IOException {
		FileInputStream fr = new FileInputStream("C:\\DO NOT DELETE\\Generic.properties");
		Properties pr = new Properties();
		pr.load(fr);
		String value = pr.getProperty(strval);
		return value;
	}

	public static String[] readGenericArrayValues(String strarr) throws IOException
	{
		String Val= globalPropertyFile(strarr);
		String[] array = Val.split(";");
		
		//System.out.println(array.length);
		return array;
		
	}
	public static void main(String[] args) throws IOException {
		String[] array = readGenericArrayValues("SolutionDetails");
		for(String value1:array)
		{
			System.out.println(value1);
		
		}
	}
}
