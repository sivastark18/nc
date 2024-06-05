import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        try {
            // Open your connection to a server, at port 15123
            Socket socket = new Socket("127.0.0.1", 15123);
            byte[] byteArray = new byte[1024];
            int bytesRead;
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\OVIYA\\Downloads\\727822TUCS134\\oviya.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            try {
                while ((bytesRead = is.read(byteArray)) != -1) {
                    bos.write(byteArray, 0, bytesRead);
                }
                bos.flush();
                System.out.println("File received successfully.");
            } catch (IOException e) {
                System.err.println("Error reading from the server: " + e.getMessage());
            } finally {
                try {
                    bos.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Error connecting to the server: " + e.getMessage());
        }
    }
}