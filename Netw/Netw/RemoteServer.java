import java.io.*;
import java.net.*;

@SuppressWarnings("deprecation")
public class RemoteServer {

    public static void main(String[] args) {
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Port Address: ");
            int port = Integer.parseInt(buf.readLine());
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is Ready To Receive a Command.");
            System.out.println("Waiting.....");
            Socket socket = serverSocket.accept();
            if (socket.isConnected()) {
                System.out.println("Client Socket is Connected Successfully.");
            }
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String command = reader.readLine();
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(command);
            BufferedReader processOutput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = processOutput.readLine()) != null) {
                writer.println(line);
            }
            writer.close();
            processOutput.close();
            process.destroy();
            reader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
