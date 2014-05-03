import org.jdom.Element;

/**
 * Created by Napalm on 18/03/14.
 */
public class Border extends Element {
    public Border(){
        setName("Border");
        setNamespace(XamlComponent.getDefaultNamespace());

    }

    public void setColor(String color){
        setAttribute("BorderBrush" , color);
    }

    public void setThickness(double thickness){
        setAttribute("BorderThickness", String.valueOf(thickness));
    }

    public void setWidth(int width){
        setAttribute("Width", String.valueOf(width));
    }

    public void setHeight(int height){
        setAttribute("Height", String.valueOf(height));
    }

    public void setBounds(int top, int left, int bottom, int right){
        setAttribute("Canvas.Top", String.valueOf(top));
        setAttribute("Canvas.Left", String.valueOf(left));
        setAttribute("Canvas.Right", String.valueOf(right));
        setAttribute("Canvas.Bottom", String.valueOf(bottom));
    }

    public void setBackground(Element background) {
        addContent(background);
    }

    public void setTextBlock(TextBlock textBlock){
        addContent(textBlock);
    }

}
