import java.io.*;
import java.net.*;

public class RemoteClient {

    public static void main(String[] args) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Port Address: ");
            int port = Integer.parseInt(buf.readLine());

            Socket socket = new Socket("localhost", port);

            if (socket.isConnected()) {
                System.out.println("Server Socket is Connected Successfully.");
            }

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(in));
            PrintWriter writer = new PrintWriter(out);

            System.out.print("Enter the Command to be Executed: ");
            writer.println(reader.readLine());
            writer.flush();
            String response = serverReader.readLine();
            System.out.println("Server Response: " + response);

            reader.close();
            serverReader.close();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
