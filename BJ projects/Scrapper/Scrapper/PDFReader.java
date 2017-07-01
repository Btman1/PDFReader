 
import java.io.IOException;
import java.io.File;
import java.io.*;
import java.util.*;
/**
 * Contains some methods to list files and folders from a directory
 *
 * @author Loiane Groner
 * http://loiane.com (Portuguese)
 * http://loianegroner.com (English)
 */
public class PDFReader {

    /**
     * List all the files and folders from a directory
     * @param directoryName to be listed
     */
    public void listFilesAndFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            System.out.println(file.getName());
        }
    }
    
    /**
     * List all the files under a directory
     * @param directoryName to be listed
     */
    public ArrayList<String> listFiles(String directoryName){
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
    
    private String[] filelistarray = new String[20];
    
    /**
     * List all the folder under a directory
     * @param directoryName to be listed
     */
    public void listFolders(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public void listFilesAndFilesSubDirectories(String directoryName){
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
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
     
     
    public static void main (String[] args){
        PDFReader PDFReader = new PDFReader();
        

        
        final String dirname ="/Users/ayao/Desktop/Folder/";
        //Windows directory example
        final String directoryWindows ="C://test";
        ArrayList<String> lestring = PDFReader.listFiles(dirname);
        for (int i = 0; i < lestring.size(); i++) {
            String e = lestring.get(i);
            String substr = e.substring(e.length() - 3);
            //System.out.println("e " + e + "   substr:" + substr);
            if (substr.equals("iff") || substr.equals("png")|| substr.equals("jpg") ) {
                String tsr = ("tesseract '" + dirname + e + "' '" + dirname + e + ".txt'" );
                System.out.println(tsr);
                runcmd(tsr);
            }
            
        }

        String srcname = "ponzi-scheme-politics-congress-obama-president-madoff-democr-demotivational-poster-1237071852.jpg";

        
        

        
        
    }
    
  
    
}
