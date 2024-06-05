import java.net.*;
import java.io.*;
@SuppressWarnings("deprecation")
class DateClient {
    public static void main(String[] args) throws IOException {
        Socket soc;
        DataInputStream dis;
        String sdate;
        PrintStream ps;
        InetAddress ia = InetAddress.getLocalHost();
        soc = new Socket(ia, 8020);
        dis = new DataInputStream(soc.getInputStream());
        sdate = dis.readLine();
        System.out.println("THE date in the server is: " + sdate);
         ps = new PrintStream(soc.getOutputStream());
       ps.println(ia);
    }
}
