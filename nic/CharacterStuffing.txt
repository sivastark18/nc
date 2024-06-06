
import java.util.Scanner;

public class CharacterStuffing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original data: ");
        String originalData = scanner.nextLine();
        char FLAG = '@';
        char ESCAPE = '#';
        StringBuilder stuffedData = new StringBuilder();
        stuffedData.append(FLAG); 
        for (char c : originalData.toCharArray()) {
            if (c == FLAG || c == ESCAPE) {
                stuffedData.append(ESCAPE).append(c);
            } else {
                stuffedData.append(c);
            }
        }
        stuffedData.append(FLAG);
        System.out.println("Stuffed data: " + stuffedData.toString());
        scanner.close();
    }
}
