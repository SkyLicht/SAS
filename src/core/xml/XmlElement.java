package core.xml;

import org.jdom2.Element;

public class XmlElement {

    private Element element;

    public XmlElement(String name,String value){
        this.element = new Element(name);
        this.element.setAttribute("id",value);
    }

    public void push(String name, String value){
        element.addContent(new Element(name).setText(value));
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
