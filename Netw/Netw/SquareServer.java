import java.io.*;
import java.net.*;

public class SquareServer {
    public static void main(String[] args) {
        try {
            // Register service on port 8500
            ServerSocket ss = new ServerSocket(8500);
            System.out.println("Waiting for client...");

            while (true) {
                // ServerSocket in order to listen for and accept connections from clients
                Socket s = ss.accept();
                System.out.println("Client connected.");

                // Get data from the client
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String cli_name = br.readLine();
                System.out.println("\nCLIENT NAME: " + cli_name);
                int no = Integer.parseInt(br.readLine());

                // Calculate square
                int sq = no * no;
                
                // Send the result back to the client
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
                pw.println(sq);
                System.out.println("OUTPUT - The square of " + no + " is " + sq);
                
                // Close resources
                pw.close();
                br.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
