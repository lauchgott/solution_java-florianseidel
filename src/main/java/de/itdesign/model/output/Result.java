package main.java.de.itdesign.model.output;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class Result {


    @XmlAttribute(name="name")
    private String name;

    @XmlValue
    private String value;

    public Result() {
    }

    public Result(String name) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
