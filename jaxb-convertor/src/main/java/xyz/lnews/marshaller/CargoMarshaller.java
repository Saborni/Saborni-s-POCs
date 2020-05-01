package xyz.lnews.marshaller;

import xyz.lnews.model.Cargo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CargoMarshaller {
    private static String OUTPUT_FILE = "src/main/resources/marshaller/cargo-marshalled.xml";

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Cargo.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Cargo cargo = new Cargo("VS",1122,"CCU","MAA");
        FileOutputStream output = new FileOutputStream(OUTPUT_FILE);

        marshaller.marshal(cargo,output);
    }
}
