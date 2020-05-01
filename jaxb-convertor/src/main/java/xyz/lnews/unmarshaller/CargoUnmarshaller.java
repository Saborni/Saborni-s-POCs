package xyz.lnews.unmarshaller;

import xyz.lnews.model.Cargo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class CargoUnmarshaller {
    private static String INPUT_FILE = "src/main/resources/unmarshaller/cargo-unmarshalled.xml";

    public static void main(String[] args) throws Exception{
        File file = new File(INPUT_FILE);
        JAXBContext context = JAXBContext.newInstance(Cargo.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Cargo cargo = (Cargo) unmarshaller.unmarshal(file);

        System.out.println(cargo.getCarrierCode()+"/"
                +cargo.getOrg()+"/"
        +cargo.getDest()+"/"
        +cargo.getFlightNumber());
    }
}
