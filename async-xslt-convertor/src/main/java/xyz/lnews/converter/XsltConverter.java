package xyz.lnews.converter;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringReader;

public class XsltConverter {
    public void transformToText(String xmlMessage) throws Exception {
        //File xmlFile = new File("src/main/resources/cargodetails.xml");
        File xsltFile = new File("src/main/resources/cargodetails.xsl");
        File txtFile = new File("src/main/resources/output.txt");

        Source xmlSource = new StreamSource(new StringReader(xmlMessage));
        Source xsltSource = new StreamSource(xsltFile);
        StreamResult result = new StreamResult(txtFile);

        Transformer transformer =
                TransformerFactory.newInstance().newTransformer(xsltSource);

        transformer.transform(xmlSource,result);

    }

}
