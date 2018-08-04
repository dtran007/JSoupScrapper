
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ImageGrabber
{

   public static void main(String[] args) throws IOException
   {
      //Enter website 
      String website = "http://www.google.com";
      
      Document doc;
      doc = Jsoup.connect(website).get();
      Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
      //To get the list of image from website
      for(Element image: images)
      {
         String l = image.attr("src");
         if(l.length()>0)
         {
            if(l.length()<4)
            {
               l = doc.baseUri()+l.substring(1);
            }
            else if(!l.substring(0, 4).equals("http"))
            {
               l = doc.baseUri()+l.substring(1);
            }
         }
         System.out.println(l);
      }

   }

}
