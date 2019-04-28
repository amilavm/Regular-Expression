import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataExtraction2 {

    public static void main(String[] args) throws IOException {
        // Write Mobile Numbers to output.txt file
        PrintWriter pw = new PrintWriter("/C:/Users/Asus/Desktop/output.txt");

        // Regular expression for mobile number
        Pattern p = Pattern.compile("[7-9][0-9]{6}");

        // BufferedReader for reading from input.txt file
        BufferedReader br = new BufferedReader
                (new FileReader("C:/Users/Asus/Desktop/datafile.txt"));
        String line = br.readLine();

        while (line != null)
        {
            Matcher m = p.matcher(line);

            while (m.find())
            {
                // Write the mobile number to output.txt file
                pw.println(m.group());
            }

            line = br.readLine();
        }
        pw.flush();
    }
}
