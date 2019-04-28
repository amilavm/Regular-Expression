import java.util.regex.*;
import java.io.*;

public class DataExtraction {

    public static void main(String[] args) throws IOException {
        // Write Mobile Numbers to output.txt file
        PrintWriter pw = new PrintWriter("/C:/Users/Asus/Desktop/output3.txt");

        // Regular expressions for company number,date and company name
        Pattern p = Pattern.compile("\\d{1,2}(st?|th?|rd?)\\s+(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)\\s+\\d{4}");
        Pattern n = Pattern.compile("[7-9][0-9]{6}");
        Pattern a = Pattern.compile("that(.*)is");

        // BufferedReader for reading from input.txt file
        BufferedReader br = new BufferedReader
                (new FileReader("C:/Users/Asus/Desktop/datafile.txt"));
        String line = br.readLine();

        while (line != null)
        {
            Matcher m = p.matcher(line);
            Matcher n1 = n.matcher(line);
            Matcher a1 = a.matcher(line);

            while (m.find())
            {
                // Write the mobile number to output.txt file
                pw.println(m.group());
                System.out.println(m.group());
            }
            while (n1.find())
            {
                // Write the mobile number to output.txt file
//                pw.println(m.group());
                pw.println(n1.group());
                System.out.println(n1.group());
            }
            while (a1.find())
            {
                // Write the mobile number to output.txt file
//                pw.println(m.group());
                pw.println(a1.group());
                System.out.println(a1.group());
            }


            line = br.readLine();
        }
        pw.flush();
    }
}
