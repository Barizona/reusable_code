import org.jdom.Element;

/**
 * Created by Napalm on 18/03/14.
 */
public class CanvasComponent extends Element {
    private int width;
    private int height;
    private Element bg;

    public CanvasComponent(int width, int height, Element background){
        this.setName("Canvas");
        this.setNamespace(XamlComponent.getDefaultNamespace());
        this.setAttribute("Width", String.valueOf(width));
        this.setAttribute("Height", String.valueOf(height));
        this.addContent(background);
    }

    public static String getTypeName(){
        return "Canvas";
    }

}
