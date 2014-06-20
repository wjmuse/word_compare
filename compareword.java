import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 
 * for all of the .txt files in a folder
 * find out the word existed in all of the files
 * 
 * */
public class compareword {
	public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\wayne\\Desktop\\etu\\downloaded data\\tupledata";
        String[] filename;
        Map<String,Integer> wordMap = new HashMap<String,Integer>();
        File f = new File(filePath);
        String word;
        if (f.isDirectory())
        {
            filename = f.list();
            System.out.println("start to read..." + filename.length);
            for (int i = 0; i < filename.length; i++)
            {
            	FileReader fr = new FileReader(filePath+"\\"+filename[i]);
            	BufferedReader br = new BufferedReader(fr);
            	String line="";
            	System.out.println(filename[i]);
            	while((line = br.readLine()) != null){
            		StringTokenizer itr = new StringTokenizer(line.toString(),",");   
        	        while (itr.hasMoreTokens()) {
        	        	word = itr.nextToken().toUpperCase();
        	        	if (!wordMap.containsKey(word)) {
        	        		wordMap.put(word, 1);
        	        	} else {
        	        		wordMap.put(word, wordMap.get(word)+1);
        	        	}
        	        }
            	} 
            }
            for (String dataKey : wordMap.keySet())
            {
            	if (wordMap.get(dataKey).equals(filename.length)) {
                	System.out.println(dataKey );	
            	}
            }
        }
        else
        {
            System.out.println("Directory Error!!");
        }  	
	}
}
