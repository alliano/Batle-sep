import java.util.Scanner;

public class  App {
    public static void main(String[] args) throws Exception {
        System.out.println("\n");
        System.out.println("\t\t====================");
        System.out.println("\t\t=====BATLE SHIP=====");
        System.out.println("\t\t====================");
        System.out.println("\n");
        loop(9);
        
    }
    
    private static void loop(int increment){
        Boolean next = true;
        while(next){
            Scanner terminalInput = new Scanner(System.in);
            System.out.print("masukan nilai Tebakan anda : ");
            int tebakanUser = terminalInput.nextInt();
            System.out.println(tebakanUser);
            
            System.out.println("  123456789");
            for(int i = 0; i <= increment; i++){
                System.out.print(i + "|");
                for(int j = 0; j < increment; j++){
                    System.out.print("@");
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

        while(!inputuser.equalsIgnoreCase("y") && !inputuser.equalsIgnoreCase("n")){
            System.out.println("======================");
            System.err.println("u just can choose [Y/N]");
            System.out.println("======================");  

            System.out.print(message + "[Y/N]");
              inputuser = terminalInput.nextLine();
              cond = inputuser.equalsIgnoreCase("y");
        }

        if(!cond){
            System.out.println("======================");
            System.err.println("======good beye=======");
            System.out.println("======================");
        }
        return cond;

    }




}
