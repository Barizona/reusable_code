import org.jdom.Document;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Vincent on 25/02/14.
 */
public class XMLFileHandler {
    public void saveXml(Document document, String naam){
        XMLOutputter output = new XMLOutputter();
        Format format = Format.getPrettyFormat();

        output.setFormat(format);

        try{
            PrintWriter out = new PrintWriter(new File(naam));
            out.write(output.outputString(document));
            out.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}
