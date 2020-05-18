package main.java.de.itdesign.model.input;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

@XmlRootElement(name = "operations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operations {

    @XmlElement(name = "operation")
    private List<Operation> operations;

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "operations=" + operations +
                '}';
    }

    public Operations unmarshalOperations(String file) throws JAXBException {
        File fileA = new File(file);
        JAXBContext context;
        context = JAXBContext.newInstance(Operations.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Operations operations = (Operations) unmarshaller.unmarshal(fileA);
        return operations;


    }

}
