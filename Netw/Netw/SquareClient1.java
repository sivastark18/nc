import java.io.*;
import java.net.*;

public class SquareClient1 {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket s = new Socket("localhost", 8500);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Read a number from the user
            System.out.print("Enter a number: ");
            int num = Integer.parseInt(br.readLine());

            // Send data to the server
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println("Client 1");
            pw.println(num);

            // Receive the square from the server
            BufferedReader br1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
            int squ = Integer.parseInt(br1.readLine());

            // Display the square
            System.out.println("Square of " + num + " is " + squ + "\n");

            // Close resources
            br1.close();
            br.close();
            pw.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
