import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// on development

public class  App {
    private static final String sea = "0123456789";
    private static final String shep = "#";
    private static final String shepC = "@";
    public static final Scanner terminalInput = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("\n");
        System.out.println("\t\t====================");
        System.out.println("\t\t=====BATLE SHIP=====");
        System.out.println("\t\t====================");
        System.out.println("\n");
        loop(9);       
    }
    
    private static void loop(int increment){
        // Boolean next = true;
        // while(next){
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
            List<List<String>> arena = loopSea();
          
            int[][] computer = Computer(arrays);
            List<List<String>> newArena = setShep(computer,arrays, arena);

            System.out.println(Arrays.deepToString(arrays) + "-->user");
            System.out.println(Arrays.deepToString(computer) + "-->computer");

            System.out.println("\n  "+sea);
            for(int i = 0; i <= increment; i++){
                System.out.print(i + "|");
                for(int j = 0; j < increment; j++){
                    System.out.print(newArena.get(i).get(j));
                }
                System.out.println("|" + i);
            }
            System.out.println("  "+sea);
            System.out.println("\n");

            batle(arrays,computer );
        //     next = isnext("apakah kamu mau lanjut? ");
        // }  
    }

    private static Boolean isnext(String message){
        System.out.print(message + "[Y/N] : ");
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
        System.out.print("Enter cordinate X : ");
        cordinat_x = terminalInput.nextInt();
        System.out.print("Enter cordinat Y : ");
        cordinat_y = terminalInput.nextInt();
        int[] cordinat = {cordinat_x,cordinat_y};
        System.out.println("\n");
        return cordinat;

    }
    private static List<List<String>> loopSea(){
        List<List<String>> arrays = new ArrayList<>();

        for (int i = 0; i < sea.length(); i++) {
           arrays.add(new ArrayList<>());
           for(int j = 0; j < sea.length(); j++){
               arrays.get(i).add(" ");
           }
        }
       
        return arrays;
    }

    private static List<List<String>> setShep(int[][] _cordinat_x_y_comp,int[][] _cordinat_x_y,List<List<String>> arena){
        
        for (int i = 0; i < _cordinat_x_y.length; i++) {
            arena.get(_cordinat_x_y[i][0]).set(_cordinat_x_y[i][1], shep);
            arena.get(_cordinat_x_y_comp[i][0]).set(_cordinat_x_y_comp[i][1], shepC);
        }
        return arena;
    }

private static int[][] Computer(int[][] UsersChoice){
    Random valueRandom = new Random();
    int[][] computer = new int[5][2];
    for(int i = 0; i < computer.length; i++){
        int _cordinat_y_comp = valueRandom.nextInt(9);
        int _cordinat_x_comp = valueRandom.nextInt(9);
        for (int j = 0; j < computer.length; j++) {
            if (UsersChoice[i][0] != _cordinat_y_comp && UsersChoice[i][1] != _cordinat_x_comp) {
                computer[i][0] = _cordinat_y_comp;
                computer[i][1] = _cordinat_x_comp;
            }  
        }
    }
    return computer;
}

private static void batle(int[][] user,int[][] computer){
    
        System.out.println("\t\t\t!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("\t\t\t!!!battle is started !!!");
        System.out.println("\t\t\t!!!!!!!!!!!!!!!!!!!!!!!!");
        

        System.out.print("tebak shep comp : ");
        String inputUSer = terminalInput.nextLine();
        System.out.println(inputUSer);
    
    
    


}


  
}
