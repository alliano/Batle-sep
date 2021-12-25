import java.util.Arrays;
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
            
            // seep1
            System.out.println("shep1");
            int[] shep1 = Shep();
            // shep2
            System.out.println("shep2");
            int[] shep2 = Shep();
            // shep3
            System.out.println("shep3");
            int[] shep3 = Shep();
            // shep4
            System.out.println("shep4");
            int[] shep4 = Shep();
            // shep5
            System.out.println("shep5");
            int[] shep5 = Shep();
            

            int[][] arrays = {
                shep1,
                shep2,
                shep3,
                shep4,
                shep5
            };
            array(arrays);
            System.out.println("\n  123456789");
            for(int i = 0; i <= increment; i++){
                System.out.print(i + "|");
                for(int j = 0; j < increment; j++){
                   
                    for(int k = 0; k < arrays.length; k++){
                        if (i == arrays[k][0] && j == arrays[k][1]){
                            System.out.print("#");
                        }
                    }
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


    private static int[] Shep(){
        int cordinat_x,cordinat_y;
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("Enter cordinate X : ");
        cordinat_x = terminalInput.nextInt();
        System.out.print("Enter cordinat Y : ");
        cordinat_y = terminalInput.nextInt();
        int[] cordinat = {cordinat_x,cordinat_y};
        System.out.println("\n");
        return cordinat;

    }

private static void array(int[][] arr){
    for (int i = 0; i < arr.length; i++) {
        String array = Arrays.toString(arr[i]);
        System.out.println(array);
        System.out.println(arr[i].length);
    }
}

}
