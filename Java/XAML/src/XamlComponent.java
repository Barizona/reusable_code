import org.jdom.Namespace;

/**
 * Created by Napalm on 18/03/14.
 */
public class XamlComponent {

    public static Namespace getDefaultNamespace() {
        //return the default namespace
        return Namespace.getNamespace("http://schemas.microsoft.com/winfx/2006/xaml/presentation");
    }
}
