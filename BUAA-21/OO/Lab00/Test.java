import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        while(scan.hasNext()) {
            input = scan.nextLine();
            if(input.equals("QUIT") )
            {
                System.out.println("----- Good Bye! -----");
                System.exit(0);
            }
        }
    }
}