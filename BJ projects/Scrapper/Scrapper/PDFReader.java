import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.*;
import java.io.FileReader;
import org.json.JSONObject;
/**
 * Write a description of class PDFReadertwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PDFReader
{
        /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public static ArrayList<String> listFiles(String directoryName){
        ArrayList<String> ar = new ArrayList<String>();
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                //System.out.println(file.getName());
                ar.add(file.getName());
            }
        }
        return ar;
        
    }
    
   
            
    public  static void main(String args[])throws FileNotFoundException, IOException{
        
        final String dirname ="/Users/ayao/Desktop/Folder/";
        //Windows directory example
        final String directoryWindows ="C://test";
            ArrayList<String> lestring = PDFReader.listFiles(dirname);
            for (int i = 0; i < lestring.size(); i++) {
                String e = lestring.get(i);
                String substr = e.substring(e.length() - 3);
                //System.out.println("e " + e + "   substr:" + substr);
                if (substr.equals("iff") || substr.equals("png")|| substr.equals("jpg") ) {
                    process(dirname + e);
                }
                
            }
        
        
    }
    
    /*Input: filename: the file name of the image to be processed.
     * 
     * 
     */
    public static void process(String filename)throws FileNotFoundException, IOException{
        
        String txtFileName = convertone(filename);
        String filecontent = readfileone(txtFileName);
        savetoES(filecontent);
        
    }
    public static void runcmd (String tsr){
        //tsr = ("/Users/ayao/Desktop/Folder/ponzi-scheme-politics-congress-obama-president-madoff-democr-demotivational-poster-1237071852.jpg");
            try{
            //String[] a = new String[] {"/bin/bash", "-c", "tesseract" + tsr + " /Users/ayao/Desktop/Folder/testingfirsttry.txt"};
            String[] a = new String[] {"/bin/bash", "-c", tsr};
            //String[] a = new String[] {"/bin/bash", "-c", "ls"};
            ProcessBuilder pb = new ProcessBuilder(a);
            Map<String, String> envs = pb.environment();
            envs.put("PATH", "/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/bin:/opt/X11/bin");
            
            final Process proc = pb.start();
            proc.waitFor();
            InputStream is = proc.getInputStream();
            InputStream stderr = proc.getErrorStream ();

            BufferedReader errorreader = new BufferedReader (new InputStreamReader(stderr));

            
            
            
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
              System.out.println(line);
            }
            while ((line = errorreader.readLine()) != null) {
              System.out.println(line);
            }
            
            System.out.println("Program terminated!");
            //runcmd("/bin/bash -c 'touch /Users/ayao/Desktop/Folder/filetest.txt'");
            //runcmd("ls -l");
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        } 
     }

    public static String convertone (String filename)
    {
                    String tsr = ("tesseract '" + filename + "' '" + filename  + "'");
                    System.out.println(tsr);
                    runcmd(tsr);
                    return filename + ".txt";
    }
    
    public static String readfileone (String filename) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader (filename));
            String         line = null;
            StringBuilder  stringBuilder = new StringBuilder();
            String         ls = System.getProperty("line.separator");
        
            try {
                while((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
        
                return stringBuilder.toString();
            } finally {
                reader.close();
            }
    }
    
    public static void savetoES (String filecontent)throws IOException
    {
        
            PDFReader example = new PDFReader(); 
            String json = example.bowlingJson(filecontent);
            System.out.println(json);
            String response = example.post("http://localhost:9200/allensfirstindex/external/1?pretty", json);
            
            System.out.println("ES Response");
            System.out.println(response);
        
        
        
            
        
   }
   
   public String post(String url, String json) throws IOException 
        {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
            try (Response response = client.newCall(request).execute()) {
              return response.body().string();
            }
        }
        
   public static final MediaType JSON
          = MediaType.parse("application/json; charset=utf-8");
    
   public OkHttpClient client = new OkHttpClient();  
   
   String bowlingJson(String player1) 
   {
        JSONObject obj = new JSONObject();
        
        obj.put("name", player1.trim());
        
        return obj.toString();
   }
}
