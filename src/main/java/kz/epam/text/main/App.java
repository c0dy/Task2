package kz.epam.text.main;

import kz.epam.text.parser.Parser;
import kz.epam.text.parser.composite.Element;
import kz.epam.text.service.ReaderAndWriter;


public class App {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Element element = parser.parseText(ReaderAndWriter.read("text.txt"));
        ReaderAndWriter.write(element.toString(), "MyText.txt");
    }
}
