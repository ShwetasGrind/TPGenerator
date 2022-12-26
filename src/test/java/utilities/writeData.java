package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class writeData
{

public static void writeData1(String tc) throws Exception
{
	
FileWriter fr=new FileWriter("C:\\DO NOT DELETE\\Composition.txt", true);
BufferedWriter br=new BufferedWriter(fr);

br.write(tc);
br.newLine();
br.close();

}

public static void deleteContents() throws IOException
{
	
	PrintWriter writer = new PrintWriter("C:\\DO NOT DELETE\\Composition.txt");
	writer.print("");
	writer.close();
}


}

