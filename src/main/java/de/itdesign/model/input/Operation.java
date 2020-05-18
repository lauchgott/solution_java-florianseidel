package main.java.de.itdesign.model.input;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "operation")
public class Operation {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String type;

    @XmlAttribute
    private String func;

    @XmlAttribute
    private String attrib;

    @XmlAttribute
    private String filter;

    public Operation() {
    }

    public Operation(String name, String type, String func, String attrib, String filter) {
        this.name = name;
        this.type = type;
        this.func = func;
        this.attrib = attrib;
        this.filter = filter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }

    public String getAttrib() {
        return attrib;
    }

    public void setAttrib(String attrib) {
        this.attrib = attrib;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", func='" + func + '\'' +
                ", attrib='" + attrib + '\'' +
                ", filter='" + filter + '\'' +
                "\n" +
                '}';
    }
}
