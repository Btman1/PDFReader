
/**
 * Write a description of class APIthingy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   
 


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.ImageWriter;
import java.util.Iterator;
import javax.imageio.ImageIO;
import com.sun.media.imageio.plugins.tiff.TIFFImageWriteParam;

public class PDFReader
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class APIthingy
     */
    public PDFReader()
    {
  
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
      	protected boolean saveTiff(String filename, BufferedImage image) {
			
		File tiffFile = new File(filename);
		ImageOutputStream ios = null;
		ImageWriter writer = null;
		try {
			
			// find an appropriate writer
			Iterator it = ImageIO.getImageWritersByFormatName("TIF");
			if (it.hasNext()) {
				writer = (ImageWriter)it.next();	
			} else {
				return false;
			}
			
			// setup writer
			ios = ImageIO.createImageOutputStream(tiffFile);
			writer.setOutput(ios);
			TIFFImageWriteParam writeParam = new TIFFImageWriteParam(Locale.ENGLISH);
			writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
			//  see writeParam.getCompressionTypes() for available compression type strings
			writeParam.setCompressionType("PackBits"); 
			
			// convert to an IIOImage
			IIOImage iioImage = new IIOImage(image, null, null);
			// write it!
			writer.write(null, iioImage, writeParam);
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;		

	}
}
