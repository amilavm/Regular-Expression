import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.*;

public class Demo {
    public static void main(String[] args) throws IOException {

        Demo demo = new Demo();
        String data = demo.readFile("C:/Users/Asus/Desktop/datafile.txt");
//        System.out.println(data);

        // Write Mobile Numbers to output.txt file
        PrintWriter pw = new PrintWriter("/C:/Users/Asus/Desktop/output3.txt");

        // Regular expressions for company number,date and company name
        Pattern p = Pattern.compile("\\d{1,2}(st?|th?|rd?)\\s+(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s+\\d{4}");
        Pattern n = Pattern.compile("[7-9][0-9]{6}");
        Pattern a = Pattern.compile("hereby certifies that\n(.*)\nis this day incorporated");

        Matcher m = p.matcher(data);
        Matcher n1 = n.matcher(data);
        Matcher a1 = a.matcher(data);

        while (m.find())
        {
            pw.println(m.group());
            System.out.println(m.group());
        }
        while (n1.find())
        {
            pw.println(n1.group());
            System.out.println(n1.group());
        }
        while (a1.find())
        {
            pw.println(a1.group());
            System.out.println(a1.group(1));
        }

        pw.flush();
    }

    String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

}