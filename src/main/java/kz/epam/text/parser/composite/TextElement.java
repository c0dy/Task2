package kz.epam.text.parser.composite;

import java.util.ArrayList;
import java.util.List;


public class TextElement implements Element {
    private List<Element> elements = new ArrayList<>();

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Element e : elements) {
            stringBuilder.append(e.toString());
        }
        return stringBuilder.toString();
    }
}
