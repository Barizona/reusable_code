import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Created by Napalm on 18/03/14.
 */
public class Background extends Element {
    private String[] colors;
    private float offset;

    public Background(String parentElementName, String[] colors, float offset) {
        setName(parentElementName + ".Background");
        setNamespace(XamlComponent.getDefaultNamespace());
        this.colors = colors;
        this.offset = offset;
        makeBackground();
    }

    public void makeBackground() {
        Element gradientStop;
        Element gradientBrush = new Element("LinearGradientBrush", XamlComponent.getDefaultNamespace());

        for (int i = 0; i < colors.length; i++) {
            gradientStop = new Element("GradientStop",  XamlComponent.getDefaultNamespace());
            gradientStop.setAttribute(new Attribute("Color", colors[i]));
            gradientStop.setAttribute(new Attribute("Offset", String.valueOf(0 + (i * offset))));
            gradientBrush.addContent(gradientStop);
        }

        addContent(gradientBrush);
    }
}
