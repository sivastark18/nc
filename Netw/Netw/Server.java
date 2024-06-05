import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(4000);
            System.out.println("Server Waiting for image");
            socket = server.accept();
            System.out.println("Client connected.");
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            int len = dis.readInt();
            System.out.println("Image Size: " + len / 1024 + "KB");
            byte[] data = new byte[len];
            dis.readFully(data);
            dis.close();
            in.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            BufferedImage bImage = ImageIO.read(bais); // Read image from ByteArrayInputStream
            JFrame f = new JFrame("Server");
            ImageIcon icon = new ImageIcon(bImage);
            JLabel label = new JLabel(icon);
            f.add(label);
            f.pack();
            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
            if (server != null) {
                server.close();
            }
        }
    }
}
