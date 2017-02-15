package kz.epam.text.parser.composite;


public class Symbol implements Element {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }
}
