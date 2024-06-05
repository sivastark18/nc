import java.net.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@SuppressWarnings("deprecation")
public class DateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8020);
        Socket s = ss.accept();
        PrintStream ps = new PrintStream(s.getOutputStream());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss");
        String formattedDateTime = now.format(formatter);
        ps.println(formattedDateTime);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String inet = dis.readLine();
        System.out.println("THE CLIENT SYSTEM ADDRESS IS: " + inet);
        ps.close();
    }
}
