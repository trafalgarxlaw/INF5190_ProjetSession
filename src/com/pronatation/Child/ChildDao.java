package com.pronatation.Child;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.sun.tools.javac.util.List;

public class ChildDao {
	
	static String myPath = "/Users/vorolf/Documents/Course/SessionLive/Web app/INF5190_ProjetSession/WebContent/Data/UserChilds.txt";
	static String ElsaPath = "/Users/elsatran/Desktop/PROJECT_INF5190/INF5190_ProjetSession/WebContent/Data/UserChilds.txt";

	   public ChildDao() {
		   
	   }
	   
	   
	   public static boolean addChild(String Parent_username,String childName) {
		   
		    String line = "";
		    String newline = "";
		    
		    int lineNumber;
		    int targetLine=-1; 
		    try {
		      FileReader readfile = new FileReader(myPath);
		      BufferedReader readbuffer = new BufferedReader(readfile);
		      for (lineNumber = 1; lineNumber < 10; lineNumber++) {
		    	  
		    	  line=readbuffer.readLine();
		    	  
		    	  if(readFirstWord(line).equals(Parent_username)) {
		    		  targetLine=lineNumber;
		    		  newline=line;
		    		  
		    	  }
		    	   
		    	 
		      }
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    System.out.println(" The specific Line to add the child is: " + targetLine);
		    
		    if(targetLine!=-1) { //if the user has a child
		    	
		    	Path path = Paths.get(myPath);
		    	java.util.List<String> lines = null;
				try {
					lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	int position = targetLine -1;
		    	String extraLine = newline + " " + childName;  
		    	
		    	lines.add(position, extraLine);
		    	lines.remove(targetLine);

		    	try {
					Files.write(path, lines, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }else if (targetLine==-1) { //if the user has no childs
		    	
		    	Path path = Paths.get(myPath);
		    	java.util.List<String> lines = null;
				try {
					lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		    	int position = 0;
		    	String extraLine = Parent_username + " " + childName;  
		    	
		    	lines.add(position, extraLine);

		    	try {
					Files.write(path, lines, StandardCharsets.UTF_8);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    
		   
		   return true;
		   
	   }
	  
	   
	   private static String readFirstWord(String line) {
		   String firstWord="";
		   
		   if(line !=null) {
			   
			   String arr[] = line.split(" ", 2);

			    firstWord = arr[0];   
			   
		   }
		   

		   
		return firstWord;
	   }
	
	   
}
