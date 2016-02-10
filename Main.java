import java.lang.StringBuffer;

class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(new StringBuffer(""
            +"When creating a Paper object, it is the application's responsibility "
            +"to ensure that the paper size and the imageable area are compatible.\n"
            +"For example, if the paper size is changed from 11 x 17 to 8.5 x 11, the "
            +"application might need to reduce the imageable area so that whatever is "
            +"printed fits on the page."));
    }
}

class Printer {
    private int WIDTH = 18;
    private int HEIGHT = 2;
    private int pageNumber = 0;
    private int numLines = 0;

    public Printer() {

    }

    private void printParagraph(String paragraph) {
        // System.out.println(paragraph+"!");
        paragraph = paragraph.trim();
        String line = "";
        String word;
        int from = 0;
        int to = paragraph.length();
        while (paragraph.indexOf(" ", from) != -1) {
            to = paragraph.indexOf(" ", from);
            word = paragraph.substring(from, to);
            if (line.length() + word.length() + 1 > WIDTH) {
                printLine(line);
                line = "";
            }
            if (line.length() > 0) line += " ";
            line += word;
            from = to + 1;
        }
        // the rest
        word = paragraph.substring(from, paragraph.length());
        if (line.length() + word.length() + 1 > WIDTH) {
            printLine(line);
            printLine(word);
        } else {
            numLines++;
            printLine(line+" "+word);
        }
    }

    private void printLine(String line) {
        numLines++;
        System.out.println(line);
        if (numLines > HEIGHT) {
            pageBreak();
            numLines = 0;
        }
    }

    private void pageBreak() {
        for (int i = 0; i < WIDTH; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public void print(StringBuffer input) {
        String paragraph;
        int from = 0;
        int to = input.length();
        while (input.indexOf("\n", from) != -1) {
            to = input.indexOf("\n", from);
            paragraph = input.substring(from, to);
            printParagraph(paragraph);
            from = to + 1; // after linebreak
        }

        // the rest
        paragraph = input.substring(from, input.length());
        printParagraph(paragraph);
    }
}