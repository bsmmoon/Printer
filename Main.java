import java.lang.StringBuffer;

class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(new StringBuffer("Hello \n World!"));
    }
}

class Printer {
    private int WIDTH;
    private int HEIGHT;
    private int pageNumber = 0;

    public Printer() {

    }

    private void printParagraph(String paragraph) {
        System.out.print(paragraph);
    }

    public void print(StringBuffer input) {
        String paragraph;
        int from = 0;
        int to = input.length();
        while (input.indexOf("\n", from) != -1) {
            to = input.indexOf("\n", from) + 1; // include linebreaker
            paragraph = input.substring(from, to);
            printParagraph(paragraph);
            from = to;
        }
        paragraph = input.substring(from, input.length());
        printParagraph(paragraph);
    }
}