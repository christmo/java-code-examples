package i18n.resources;

import java.util.*;

/**
 *
 * Created by soporte on 4/5/17.
 */
public class i18nMain {

    public static void main(String[] args) {

        ResourceBundle res = new MyResources();//.getBundle("myResource");
        System.out.println(res.getObject("okKey"));
        System.out.println(res.getObject("cancelKey"));
    }

}

// default (English language, United States)
class MyResources extends ResourceBundle {

    public Object handleGetObject(String key) {
        if (key.equals("okKey")) return "Ok";
        if (key.equals("cancelKey")) return "Cancel";
        return null;
    }

    public Enumeration<String> getKeys() {
        return Collections.enumeration(keySet());
    }

    // Overrides handleKeySet() so that the getKeys() implementation
    // can rely on the keySet() value.
    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList("okKey", "cancelKey"));
    }
}

// German language
class MyResources_de extends MyResources {
    public Object handleGetObject(String key) {
        // don't need okKey, since parent level handles it.
        if (key.equals("cancelKey")) return "Abbrechen";
        return null;
    }

    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList("cancelKey"));
    }
}