package core.xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;


public class XmlWrite {

    private Document document = null;
    private Element root = null;

    private String pathname;

    public XmlWrite(String path) throws IOException, JDOMException {

        this.pathname = path;
        File xmlFile = new File(pathname);
        if(xmlFile.exists()) {
            // try to load document from xml file if it exist
            // create a file input stream
            FileInputStream fis = new FileInputStream(xmlFile);
            // create a sax builder to parse the document
            SAXBuilder sb = new SAXBuilder();
            // parse the xml content provided by the file input stream and create a Document object
            document = sb.build(fis);
            // get the root element of the document
            root = document.getRootElement();
            fis.close();

        }


    }

    public void addContent(Element element){
        this.root.addContent(element);
    }

    public void write(){
        try {
            this.document.setContent(root);
            FileWriter writer = new FileWriter(pathname);
            XMLOutputter outputter = new XMLOutputter();
            outputter.setFormat(Format.getPrettyFormat());
            outputter.output(document, writer);
            outputter.output(document, System.out);
            writer.close(); // close writer
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
