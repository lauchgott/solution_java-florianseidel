package main.java.de.itdesign.model.output;

import main.java.de.itdesign.model.input.City;
import main.java.de.itdesign.model.input.Operation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class Results {

    @XmlElement(name = "result")
    private List<Result> resultList;

    public List<Result> getResultList() {
        return resultList;
    }


    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }


    @Override
    public String toString() {
        return "Results{" +
                "resultList=" + resultList +
                '}';
    }

    public Result calculate(List<City> cities, Operation operation) {

        //format the Output-String:
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("0.00", symbols);

        //Set fields:
        String type = operation.getType();
        String attrib = operation.getAttrib();

        //Building Caches
        String resultString = "";
        double calculatedResult = 0.0;
        int minPopulation = 0;
        int maxPopulation = 0;
        double minArea = 0.0;
        double maxArea = 0.0;

        //Create Result-Instance
        Result result = new Result();
        result.setName(operation.getName());

        //add matching entries to resultList
        List<City> resultList = new ArrayList<>();
        resultList = cities.stream()
                .filter(city -> city.getName().matches(operation.getFilter()))
                .collect(Collectors.toList());

        //Building Caches for Populations...
        List<Integer> populationList = new ArrayList<>();
        resultList.forEach(s -> {
            populationList.add(s.getPopulation());
        });
        Collections.sort(populationList);

        //... and for Areas
        List<Double> areaList = new ArrayList<>();
        resultList.forEach(s -> {
            areaList.add(s.getArea());
        });
        Collections.sort(areaList);


        switch (operation.getFunc()) {
            case "average":
                if (attrib.equals("population")) {
                    for (City city : resultList) {
                        calculatedResult += city.getPopulation();
                    }
                    calculatedResult = Math.round(100.00 * (calculatedResult / resultList.size())) / 100.0;

                } else {
                    for (City city : resultList) {
                        calculatedResult += city.getArea();
                    }
                    calculatedResult = Math.round(100.00 * (calculatedResult / resultList.size())) / 100.0;
                }
                resultString = df.format(calculatedResult);
                break;

            case "sum":
                if (attrib.equals("population")) {
                    for (City city : resultList) {
                        calculatedResult += city.getPopulation();
                    }
                } else {
                    for (City city : resultList) {
                        calculatedResult += city.getArea();
                    }
                    calculatedResult = calculatedResult;
                }
                resultString = df.format(calculatedResult);
                break;

            case "min":
                if (attrib.equals("population")) {
                    minPopulation = populationList.get(0);
                    calculatedResult = minPopulation;
                } else {
                    minArea = areaList.get(0);
                    calculatedResult = minArea;
                }

                resultString = df.format(calculatedResult);
                break;

            case "max":
                if (attrib.equals("population")) {
                    maxPopulation = populationList.get(populationList.size() - 1);
                    calculatedResult = Math.round(100.00 * maxPopulation) / 100;
                } else {
                    maxArea = areaList.get(areaList.size() - 1);
                    calculatedResult = maxArea;
                }

                resultString = df.format(calculatedResult);
                break;


        }

        result.setValue(resultString);
        return result;


    }

    public static List<Result> calculateAllOperations(Results results, List<City> cities, List<Operation> operations) {
        List<Result> xmlList = new ArrayList<>();
        for (Operation operation : operations) {
            xmlList.add(results.calculate(cities, operation));
        }

        results.setResultList(xmlList);
        return xmlList;
    }

    public static void createXmlOutput(Results results, File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(Results.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(results, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


}
