import java.net.*;
import java.io.*;

public class SlideSender {
    public static void main(String a[]) throws Exception {
        ServerSocket ser = new ServerSocket(10);
        Socket s = ser.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter p = new PrintWriter(s.getOutputStream(), true);
        String sbuff[] = new String[8];
        int sptr = 0, sws = 8, nf, ano, i;
        String ch;
        do {
            System.out.print("Enter the no. of frames : ");
            nf = Integer.parseInt(in.readLine());
            p.println(nf);
            if (nf <= sws - 1) {
                System.out.println("Enter " + nf + " Messages to be sent\n");
                for (i = 0; i < nf; i++) {
                    sbuff[sptr] = in.readLine();
                    p.println(sbuff[sptr]);
                    sptr = ++sptr % 8;
                }
                sws -= nf;
                System.out.print("Acknowledgment received");
                ano = Integer.parseInt(in1.readLine());
                System.out.println(" for " + ano + " frames");
                sws += nf;
            } else {
                System.out.println("The no. of frames exceeds window size");
                break;
            }
            System.out.print("\nDo you want to send some more frames : ");
            ch = in.readLine();
            p.println(ch);
        } while (ch.equalsIgnoreCase("yes"));
        s.close();
    }
}