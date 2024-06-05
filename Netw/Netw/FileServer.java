import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) throws IOException {
        // Register service on port 15123
        ServerSocket serverSocket = new ServerSocket(15123);
        Socket socket = serverSocket.accept();
        System.out.println("Accepted connection: " + socket);
        File transferFile = new File("C:\\Users\\OVIYA\\Downloads\\727822TUCS134\\oviya.txt");
        byte[] byteArray = new byte[(int) transferFile.length()];
        FileInputStream fin = new FileInputStream(transferFile);
        BufferedInputStream bin = new BufferedInputStream(fin);
        bin.read(byteArray, 0, byteArray.length);
        OutputStream os = socket.getOutputStream();
        System.out.println("Sending Files...");
        os.write(byteArray, 0, byteArray.length);
        os.flush();
        socket.close();
        serverSocket.close();
    }
}