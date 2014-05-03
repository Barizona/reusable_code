import org.jdom.Element;

/**
 * Created by Napalm on 18/03/14.
 */
public class Button extends Element {
    private String value;
    private  Element text;

    public Button(String value){
        makeButton();
    }

    public void setBackground(Element background){
        addContent(background);
    }

    public void setBorderColor(String color){
        setAttribute("BorderBrush", color);
    }

    public void setThickness(float thickness){
        setAttribute("BorderThickness", String.valueOf(thickness));
    }

    public void makeButton(){
        setAttribute("BorderBrush", "Ivory");
        setAttribute("BorderThickness", "0.5");
        setAttribute("Width", "60");
        setAttribute("Height", "20");
        setAttribute("Cursor", "Hand");
    }

    public void makeText(String value){
        text = new Element("TextBlock", XamlComponent.getDefaultNamespace());
        text.setAttribute("Foreground", "White");
        text.setAttribute("FontWeight", "ExtraBlack");
        text.setAttribute("HorizontalAlignment", "Center");

        text.addContent(value);

        addContent(text);
    }

    public void setForegroundColor(String color){
        text.setAttribute("Foreground", color);
    }
}
