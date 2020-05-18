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

@XmlRootElement(name="data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Data {

    @XmlElement(name="city")
    private List<City> cities;


    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Data{" +
                "cities=" + "\n" + cities +
                '}';
    }

    public Data unmarshalData(String file) throws JAXBException {
        File fileA = new File(file);


        JAXBContext context;


        context = JAXBContext.newInstance(Data.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Data data = (Data) unmarshaller.unmarshal(fileA);

        return data;


    }
}
