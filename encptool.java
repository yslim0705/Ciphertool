/* Author yslim on CIPHER*/
import java.util.Scanner;
import java.io.*;


public class testcipher
{

    public static String Ciphertool(String input, int noc)
    {
        input = input.toLowerCase();
        char[] inputText = input.toCharArray();
        int firstchar_idx = 'a';
		int offsetChar = ('z' - 'a') + 1;
        String outputText = "";

        for (int i = 0; i < inputText.length; i++)
        {
        	if (inputText[i]==' ')
        	{
        		inputText[i]=' ';
        	}
        	else {
        		char oldchar_idx = inputText[i];
			int old_idx = oldchar_idx - firstchar_idx;
			int new_idx = (old_idx + noc) % offsetChar;

			char newchar_idx = (char)(firstchar_idx + new_idx);
			inputText[i] = newchar_idx;
        	}

        }
        	return new String(inputText);

    }


    public static void main(String[] args) throws IOException
    {
    	String plainText="";

    	File inFile = new File ("input.txt");
        Scanner input = new Scanner (inFile);
        File outFile = new File ("52336.txt");
         FileWriter fWriter = new FileWriter (outFile);
         PrintWriter pWriter = new PrintWriter (fWriter);
        while (input.hasNextLine())
        {
        	plainText = input.nextLine();
        	int noc=plainText.replace(" ", "").length();
        	pWriter.println (Ciphertool(plainText, noc));
        }


        input.close();
       //System.out.println(encrypt(plainText, noc));
       pWriter.close();

 }

}


