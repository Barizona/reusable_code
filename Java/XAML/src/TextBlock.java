import org.jdom.Element;

/**
 * Created by Vincent De Coen on 19/03/14.
 */
public class TextBlock extends Element{
    public TextBlock(String value) {
        setName("TextBlock");
        setText(value);
        setNamespace(XamlComponent.getDefaultNamespace());
    }
    public void setColor(String color){
        setAttribute("Foreground", color);
    }
    public void setBounds(int top, int left, int bottom, int right){
        setAttribute("Canvas.Top", String.valueOf(top));
        setAttribute("Canvas.Left", String.valueOf(left));
        setAttribute("Canvas.Right", String.valueOf(right));
        setAttribute("Canvas.Bottom", String.valueOf(bottom));
    }
}
