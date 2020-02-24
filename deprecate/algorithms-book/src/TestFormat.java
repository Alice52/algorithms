import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TestFormat {

    public static void main(String[] args) throws UnsupportedEncodingException {

        double d = 2.0321457;
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
        //2.03215
        out.printf("%.5f\n", d);
        //   2.03215
        out.printf("%10.5f\n", d);
        out.printf("%-10.5f\n", d);
        out.printf("PI is approximately %.2f\n", Math.PI);
    }
}