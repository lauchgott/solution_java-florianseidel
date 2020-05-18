package main.java.de.itdesign.model.input;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="city")
public class City {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int population;

    @XmlElement(name="area")
    private double area;

    public City() {
    }

    public City(String name, int population, double area) {
        this.name = name;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}'+ "\n" ;
    }
}
