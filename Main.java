import java.lang.StringBuffer;

class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(new StringBuffer(""
            +"A thread-safe, mutable sequence of characters. A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters, but the length and content of the sequence can be changed through certain method calls.\n"
            +"String buffers are safe for use by multiple threads. The methods are synchronized where necessary so that all the operations on any particular instance behave as if they occur in some serial order that is consistent with the order of the method calls made by each of the individual threads involved.\n"
            +"The principal operations on a StringBuffer are the append and insert methods, which are overloaded so as to accept data of any type. Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string buffer. The append method always adds these characters at the end of the buffer; the insert method adds the characters at a specified point.\n"
            +"For example, if z refers to a string buffer object whose current contents are \"start\", then the method call z.append(\"le\") would cause the string buffer to contain \"startle\", whereas z.insert(4, \"le\") would alter the string buffer to contain \"starlet\".\n"
            +"In general, if sb refers to an instance of a StringBuffer, then sb.append(x) has the same effect as sb.insert(sb.length(), x).\n"
            +"Whenever an operation occurs involving a source sequence (such as appending or inserting from a source sequence) this class synchronizes only on the string buffer performing the operation, not on the source.\n"
            +"Every string buffer has a capacity. As long as the length of the character sequence contained in the string buffer does not exceed the capacity, it is not necessary to allocate a new internal buffer array. If the internal buffer overflows, it is automatically made larger. As of release JDK 5, this class has been supplemented with an equivalent class designed for use by a single thread, StringBuilder. The StringBuilder class should generally be used in preference to this one, as it supports all of the same operations but it is faster, as it performs no synchronization.\n"
            +"\n"
            +"A thread-safe, mutable sequence of characters. A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters, but the length and content of the sequence can be changed through certain method calls.\n"
            +"String buffers are safe for use by multiple threads. The methods are synchronized where necessary so that all the operations on any particular instance behave as if they occur in some serial order that is consistent with the order of the method calls made by each of the individual threads involved.\n"
            +"The principal operations on a StringBuffer are the append and insert methods, which are overloaded so as to accept data of any type. Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string buffer. The append method always adds these characters at the end of the buffer; the insert method adds the characters at a specified point.\n"
            +"For example, if z refers to a string buffer object whose current contents are \"start\", then the method call z.append(\"le\") would cause the string buffer to contain \"startle\", whereas z.insert(4, \"le\") would alter the string buffer to contain \"starlet\".\n"
            +"In general, if sb refers to an instance of a StringBuffer, then sb.append(x) has the same effect as sb.insert(sb.length(), x).\n"
            +"Whenever an operation occurs involving a source sequence (such as appending or inserting from a source sequence) this class synchronizes only on the string buffer performing the operation, not on the source.\n"
            +"Every string buffer has a capacity. As long as the length of the character sequence contained in the string buffer does not exceed the capacity, it is not necessary to allocate a new internal buffer array. If the internal buffer overflows, it is automatically made larger. As of release JDK 5, this class has been supplemented with an equivalent class designed for use by a single thread, StringBuilder. The StringBuilder class should generally be used in preference to this one, as it supports all of the same operations but it is faster, as it performs no synchronization.\n"
            +"\n"
            +"A thread-safe, mutable sequence of characters. A string buffer is like a String, but can be modified. At any point in time it contains some particular sequence of characters, but the length and content of the sequence can be changed through certain method calls.\n"
            +"String buffers are safe for use by multiple threads. The methods are synchronized where necessary so that all the operations on any particular instance behave as if they occur in some serial order that is consistent with the order of the method calls made by each of the individual threads involved.\n"
            +"The principal operations on a StringBuffer are the append and insert methods, which are overloaded so as to accept data of any type. Each effectively converts a given datum to a string and then appends or inserts the characters of that string to the string buffer. The append method always adds these characters at the end of the buffer; the insert method adds the characters at a specified point.\n"
            +"For example, if z refers to a string buffer object whose current contents are \"start\", then the method call z.append(\"le\") would cause the string buffer to contain \"startle\", whereas z.insert(4, \"le\") would alter the string buffer to contain \"starlet\".\n"
            +"In general, if sb refers to an instance of a StringBuffer, then sb.append(x) has the same effect as sb.insert(sb.length(), x).\n"
            +"Whenever an operation occurs involving a source sequence (such as appending or inserting from a source sequence) this class synchronizes only on the string buffer performing the operation, not on the source.\n"
            +"Every string buffer has a capacity. As long as the length of the character sequence contained in the string buffer does not exceed the capacity, it is not necessary to allocate a new internal buffer array. If the internal buffer overflows, it is automatically made larger. As of release JDK 5, this class has been supplemented with an equivalent class designed for use by a single thread, StringBuilder. The StringBuilder class should generally be used in preference to this one, as it supports all of the same operations but it is faster, as it performs no synchronization.\n"
));
    }
}

class Printer {
    private int WIDTH = 100;
    private int HEIGHT = 70;
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
        System.out.print("| ");
        System.out.printf("%-"+WIDTH+"s", line);
        System.out.println(" |");
        if (numLines > HEIGHT) {
            pageBreak();
            numLines = 0;
        }
    }

    private void pageBreak() {
        System.out.printf("\n");
        for (int i = 0; i < WIDTH + 4; i++) {
            System.out.print("=");
        }
        System.out.printf("\n\n");
    }

    public void print(StringBuffer input) {
        pageBreak();
        
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

        pageBreak();
    }
}