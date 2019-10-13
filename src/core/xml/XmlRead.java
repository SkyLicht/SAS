package core.xml;


import org.jdom2.DataConversionException;
import org.jdom2.Document;

import org.jdom2.Element;
import org.jdom2.JDOMException;

import org.jdom2.input.StAXEventBuilder;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileReader;
import java.io.IOException;

public class XmlRead {

    public XmlRead(){

    }


    public Document getStAXParsedDocument(final String fileName)
    {

        Document document = null;
        try
        {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(fileName));
            StAXEventBuilder builder = new StAXEventBuilder();
            document = builder.build(reader);
        }
        catch (JDOMException | IOException | XMLStreamException e)
        {
            e.printStackTrace();
        }
        return document;
    }


    public Element getElementByIndex(Element element, int index) {

        for (Element inElement:element.getChildren()) {

            try {
                if(inElement.getAttribute("id").getIntValue() == index){
                    return inElement;
                }
            }catch (DataConversionException data){
                data.getMessage();
            }

        }

        return null;
    }

    public Element getElementByName(Element element, String name){
        for (Element inElement:element.getChildren()) {
            System.out.println(inElement.getName());

        }

        return null;
    }
}
