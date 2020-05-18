package main.java.de.itdesign.application;

import main.java.de.itdesign.model.input.Data;
import main.java.de.itdesign.model.input.Operations;
import main.java.de.itdesign.model.output.Results;

import javax.xml.bind.JAXBException;
import java.io.File;

import static main.java.de.itdesign.model.output.Results.calculateAllOperations;
import static main.java.de.itdesign.model.output.Results.createXmlOutput;

public class XMLCalculator {


    public static void main(String[] args) {


        //Don't change this part
        if (args.length == 3) {
            //Path to the data file, e.g. data/data.xml
            final String DATA_FILE = args[0];
            //Path to the data file, e.g. operations/operations.xml
            final String OPERATIONS_FILE = args[1];
            //Path to the output file
            final String OUTPUT_FILE = args[2];

            try {
                Data data = new Data();
                data = data.unmarshalData(DATA_FILE);

                Operations allOperations = new Operations();
                allOperations = allOperations.unmarshalOperations(OPERATIONS_FILE);

                Results results = new Results();
                calculateAllOperations(results, data.getCities(), allOperations.getOperations());
                createXmlOutput(results, new File(OUTPUT_FILE));

            } catch (JAXBException e) {
                e.printStackTrace();
            }


        } else {

            final String DATA_FILE = "data.xml";
            final String OPERATIONS_FILE = "operations.xml";
            final String OUTPUT_FILE = "generatedOutput.xml";

            try {
                Data data = new Data();
                data = data.unmarshalData(DATA_FILE);

                Operations allOperations = new Operations();
                allOperations = allOperations.unmarshalOperations(OPERATIONS_FILE);

                Results results = new Results();
                calculateAllOperations(results, data.getCities(), allOperations.getOperations());
                createXmlOutput(results, new File(OUTPUT_FILE));

            } catch (JAXBException e) {
                e.printStackTrace();
            }

        }










    }

}
