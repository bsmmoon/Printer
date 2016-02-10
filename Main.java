import java.lang.StringBuffer;

class Printer {
    private int WIDTH;
    private int HEIGHT;
    private int pageNumber = 0;

    public Printer() {

    }

    private void printParagraph(String paragraph) {

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
        printParagraph(from, input.length());
    }
}