

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DirectoryWatcherApp {
	
//	Method to check if String is JSON or not
	public static boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}
	
//	Method to read a file 
	public static String readFile(String fileName) throws IOException {
		BufferedReader in  = new BufferedReader(new FileReader(fileName));
		String line = "";
		while ((fileName = in.readLine()) != null) {
		       line = line.concat(fileName);
		}
		in.close();
		return line;
	}
	
// Method to initialize existing files called ONLY once at start
	public static void init(String directoryName) throws IOException {
	    File directory = new File(directoryName);
	    
	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile()) {
	            System.out.println(file);
		        System.out.println("File " + file + " is JSON? : " + isJSONValid(readFile(file.toString())));
//		        if(isJSONValid(readFile(file.toString()))) 
//		        	Do Something
	        } else if (file.isDirectory()) {
	            init(file.getPath());
	        }
	    }
	}
	
	public static void main(String[] args) {		
		String path;
		if(args.length == 0)
			path = ".";
		else 
			path = args[0];
		try {
			init(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
