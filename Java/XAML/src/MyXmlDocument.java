import org.jdom.Document;
import org.jdom.Element;

/**
 * Created by Napalm on 18/03/14.
 */
public class MyXmlDocument extends Document {


    public MyXmlDocument(String rootElementName){
        setRootElement(new Element(rootElementName, XamlComponent.getDefaultNamespace()));
    }

    public void add(Element element){
        getRootElement().addContent(element);
    }

}
