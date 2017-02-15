package kz.epam.text.parser;

import kz.epam.text.parser.composite.Element;
import kz.epam.text.parser.composite.Symbol;
import kz.epam.text.parser.composite.TextElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    private static final String PARAGRAPH_SPLIT_REGEX = "(\\n|^).*?(?=\\n|$)";
    private static final String SENTENCE_SPLIT_REGEX = "([\\s-А-ЯA-Z](|[^?!.\\(]|\\([^\\)]*\\))*[.?!])";
    private static final String WORD_SPLIT_REGEX = "([\\\\.,!\\\\?:;@]{1})|([^\\\\.,!\\\\?:;@]*)";

    public Element parseText(String text) {
        Element fullText = new TextElement();
        fullText = parseParagraph(fullText, text);
        return fullText;
    }

    public Element parseParagraph(Element fullText, String text) {
        Pattern p = Pattern.compile(PARAGRAPH_SPLIT_REGEX, Pattern.MULTILINE | Pattern.COMMENTS);
        Matcher matcher = p.matcher(text);
        while (matcher.find()) {
            Element paragraph = new TextElement();
            paragraph = parseSentence(paragraph, matcher.group());
            fullText.add(paragraph);
        }
        return fullText;
    }

    private Element parseSentence(Element paragraph, String paragraphText) {
        Pattern p = Pattern.compile(SENTENCE_SPLIT_REGEX);
        Matcher matcher = p.matcher(paragraphText);
        while (matcher.find()) {
            Element sentence = new TextElement();
            sentence = parseWord(sentence, matcher.group());
            paragraph.add(sentence);
        }
        return paragraph;
    }

    private Element parseWord(Element sentence, String sentenceText) {
        Pattern p = Pattern.compile(WORD_SPLIT_REGEX);
        Matcher matcher = p.matcher(sentenceText);
        while (matcher.find()) {
            Element word = new TextElement();
            word = parseSymbol(word, matcher.group());
            sentence.add(word);
        }
        return sentence;
    }

    private Element parseSymbol(Element word, String words) {
        for (int i = 0; i < words.length(); i++) {
            char sym = words.charAt(i);
            Element symbol = new Symbol(sym);
            word.add(symbol);
        }
        return word;
    }
}
