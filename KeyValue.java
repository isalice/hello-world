package ch.css.testip.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "rtEvent")
public class KeyValue implements Serializable {
    // == private fields ==
    Map<String, String> pairs = new HashMap<>();

    // == constructors ==


    public KeyValue() {
    }

    public KeyValue(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    // == getter and setter

    public Map<String, String> getPairs() {
        return pairs;
    }

    public void setPairs(Map<String, String> pairs) {
        this.pairs = pairs;
    }

    // == public methods ==
    public void addKeyValue(String key, String value){
        // No check for duplicate or null parameter
        pairs.put(key, value);
    }
}
