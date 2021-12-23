import java.util.Scanner;

public class  App {
    public static void main(String[] args) throws Exception {
        
        loop(9);

    }

    private static void loop(int increment){
        Boolean next = true;
        while(next){
            System.out.println("  123456789");
            for(int i = 0; i <= increment; i++){
                System.out.print(i + "|");
                for(int j = 0; j < increment; j++){
                    System.out.print(" ");
                }
            
                System.out.println("|" + i);
            }
            System.out.println("  123456789");
            System.out.println("\n");
            next = isnext("apakah kamu mau lanjut? ");
        }
        
    }

    private static Boolean isnext(String message){
        System.out.print(message + "[Y/N] : ");
        Scanner terminalInput = new Scanner(System.in);
        String inputuser = terminalInput.nextLine();
        Boolean cond = inputuser.equalsIgnoreCase("y");
        
        if(!cond){
            System.out.println("======================");
            System.err.println("goodbeye");
            System.out.println("======================");
        }
        return cond;

    }




}
