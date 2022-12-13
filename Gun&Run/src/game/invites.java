package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class invites {
	
	
	public enum State{
		ACCEPTED, DECLINED, PROCESSING
	}

	/*String filename = "Friendlist.txt";
	
	public void writeFriendInvites(String filename, List<String> invites) {
	    try {
	        FileWriter writer = new FileWriter(filename,true);
	        for (String invite : invites) {
	            writer.write(invite);
	        }
	        writer.close();
	    } catch (IOException e) {
	        System.out.println("An error occurred while writing to the file.");
	        e.printStackTrace();
	    }
	}

	public List<String> readFriendInvites(String filename) {
	    List<String> invites = new ArrayList<>();
	    try {
	        FileReader reader = new FileReader(filename);
	        BufferedReader bufferedReader = new BufferedReader(reader);
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            invites.add(line);
	        }
	        reader.close();
	    } catch (IOException e) {
	        System.out.println("An error occurred while reading from the file.");
	        e.printStackTrace();
	    }
	    return invites;
	}

	/*File f1=new File("input.txt"); //Creation of File Descriptor for input file
    String[] words=null;  //Intialize the word Array
    FileReader fr = new FileReader(f1);  //Creation of File Reader object
    BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
    String s;     
    String input="Java";   // Input word to be searched
    int count=0;   //Intialize the word to zero
    while((s=br.readLine())!=null)   //Reading Content from the file
    {
       words=s.split(" ");  //Split the word using space
        for (String word : words) 
        {
               if (word.equals(input))   //Search for the given word
               {
                 count++;    //If Present increase the count by one
               }
        }
    }
    if(count!=0)  //Check for count not equal to zero
    {
       System.out.println("The given word is present for "+count+ " Times in the file");
    }
    else
    {
       System.out.println("The given word is not present in the file");
    }
    
       fr.close();
 }*/


}
