import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// on development

public class  App {
    private static final String sea = "0123456789";
    private static final String shep = "@";
    private static final String shepC = "#";
    public static final String userDead = "X";
    public static final String compDead = "!";
    public static final String missShoot = "-";
    public static final Scanner terminalInput = new Scanner(System.in);
    public static final Random valueRandom = new Random();
    public static List<List<String>> arena = new ArrayList<>();
    public static List<List<String>> arenaDummy = new ArrayList<>();
   
    public static void main(String[] args) throws Exception {
        System.out.println("**** welcome to battle ship game ****\n");

        System.out.println("right now, the sea is empety");
        loopSea();
        newArena(arenaDummy);
        loop();       
    }
    
    private static void loop(){
            System.out.println("Deploy Player Ships ");
            arena = loopSea();
            int[][] userChoose = Shep();
            int[][] computer = Computer(userChoose);
            System.out.println(Arrays.deepToString(computer));
            System.out.println(Arrays.deepToString(userChoose));
           arena = setShep(computer,userChoose,arena);
            newArena(arenaDummy);
            batle(computer,arena);
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
    private static int[][] Shep(){
        int[][] cordinat = new int[5][2];
        int cordinat_y,cordinat_x;
        String[] nameShep = {
            "Ship1",
            "Ship2",
            "Ship3",
            "Ship4",
            "Ship5",
        };
        for (int i = 0; i < 5; i++) {
            try{
                System.out.println(nameShep[i]);
                System.out.print("Enter cordinate Y : ");
                cordinat_x = terminalInput.nextInt();
                System.out.print("Enter cordinat X : ");
                cordinat_y = terminalInput.nextInt(); 
                System.out.println("\n"); 
    
                String cordinat_x_y = arena.get(cordinat_y).get(cordinat_x);
                arena.get(cordinat_y).set(cordinat_x, shep);
                
                if(!cordinat_x_y.equals(" ")){
                    i = i - 1;
                    System.out.println("Cordinat cannot be the same! input Ship " + (i + 1) + " will be repeated!");
                }else{
                    cordinat[i][0] = cordinat_y;
                    cordinat[i][1] = cordinat_x;
                }
                
            }catch(InputMismatchException handling){
                System.out.println("You Must Write A Number");
                continue;
            }
                
        }
        return cordinat;
    }

    private static List<List<String>> loopSea(){
        for (int i = 0; i < sea.length(); i++) {
           arena.add(new ArrayList<>());
           arenaDummy.add(new ArrayList<>());
           for(int j = 0; j < sea.length(); j++){
               arena.get(i).add(" ");
               arenaDummy.get(i).add(" ");
           }
        }
       
        return arena;
    }

    private static List<List<String>> setShep(int[][] _cordinat_x_y_comp,int[][] _cordinat_x_y,List<List<String>> arena){
        
        for (int i = 0; i < _cordinat_x_y.length; i++) {
            arenaDummy.get(_cordinat_x_y[i][0]).set(_cordinat_x_y[i][1], shep);
            arena.get(_cordinat_x_y[i][0]).set(_cordinat_x_y[i][1], shep);
            arena.get(_cordinat_x_y_comp[i][0]).set(_cordinat_x_y_comp[i][1], shepC);
        }
        return arena;
    }
private static int[][] Computer(int[][] UserChoose){
    int[][] computer = new int[5][2];
    for(int i = 0; i < computer.length; i++){
        int _cordinat_y_comp = valueRandom.nextInt(9);
        int _cordinat_x_comp = valueRandom.nextInt(9);
       for (int j = 0; j < computer.length; j++) {
                if (!arena.get(_cordinat_y_comp).get(_cordinat_x_comp).equals(shep)) {
                    for (int k = 0; k < computer.length; k++) {
                        for (int l = 0; l < computer[l].length; l++) {
                            if (!computer[i].equals(_cordinat_y_comp)) {
                                computer[i][0] = _cordinat_y_comp;
                                computer[i][1] = _cordinat_x_comp;
                            }
                        }
                    }
                }
            }
    }
    return computer;
}

private static void batle(int[][] computer,List<List<String>> arena){
    int user = 0;
    int comp = 0;
    
    
    for (int i = 0; i < computer.length; i++) {
        System.out.println("YOU TURN");
        try{
            System.out.print("input cordinat y _comp : ");
            int userChoose_y = terminalInput.nextInt();
            System.out.print("input cordinat x _comp : ");
            int userChoose_x = terminalInput.nextInt();
    
                if(arena.get(userChoose_y).get(userChoose_x).equals(shepC)){
                    arenaDummy.get(userChoose_y).set(userChoose_x, compDead);
                    arena.get(userChoose_y).set(userChoose_x, compDead);
                    clearSc();
                    newArena(arenaDummy);
                    System.out.println("Boom! You Sunk The Ship!");
                    user = user + 1;
                }else if(arena.get(userChoose_y).get(userChoose_x).equals(compDead)){
                     System.out.println("You Can't Hit In The Same Place");
                }else if(arena.get(userChoose_y).get(userChoose_x).equals(shep)){
                    System.out.println("Oh No, You Sunk Your Own Ship :(");
                    arena.get(userChoose_y).set(userChoose_x,userDead);
                    arenaDummy.get(userChoose_y).set(userChoose_x,userDead);
                }else{
                    clearSc();
                    arenaDummy.get(userChoose_y).set(userChoose_x,missShoot );
                    arena.get(userChoose_y).set(userChoose_x, missShoot);
                    newArena(arenaDummy);
                    System.out.println("You missed");
                }
        }catch(InputMismatchException handling){
            System.out.println("You Must Write A Number");
            terminalInput.next();
            continue;
        }
            
       int _cordinat_y_comp = valueRandom.nextInt(9); 
       int _cordinat_x_comp = valueRandom.nextInt(9); 

       try{
           System.out.println("COMPUTER TURN");
           Thread.sleep(2000);
           if (arena.get(_cordinat_y_comp).get(_cordinat_x_comp).equals(shep)){
               System.out.println("The Computer Sunk Your Ship");
               arenaDummy.get(_cordinat_y_comp).set(_cordinat_x_comp, userDead);
               arena.get(_cordinat_y_comp).set(_cordinat_x_comp, userDead);
               newArena(arenaDummy);
              
                comp += 1;
           }else{
               clearSc();
               arena.get(_cordinat_y_comp).set(_cordinat_x_comp, missShoot);
               arenaDummy.get(_cordinat_y_comp).set(_cordinat_x_comp,missShoot);
               newArena(arenaDummy);
               System.out.println("cordinat_y -> "+_cordinat_y_comp);
               System.out.println("cordinat_x -> "+_cordinat_x_comp);
               System.out.println("Cmputer missed");
           }
       }catch(Exception ERRHANDLING){
            System.out.println("failed " + ERRHANDLING);
       }

    }
    if (user > comp){
        System.out.println("\nyour ship : " + user + " computer ships : " + comp);
        System.out.println("Hooray, you winer the battle");
        System.out.println("====================================");
    }else if (user < comp) {
        System.out.println("\nyour ship : " + user + " computer ships : " + comp);
        System.out.println("Sorry, You Lost The Battle :v");
        System.out.println("====================================");
        System.out.println("you lose");
    }else if(user == comp){
        System.out.println("\nyour ship : " + user + " computer ships : " + comp);
        System.out.println("the batle is drow");
        System.out.println("====================================");
        
    }

}

public static void newArena(List<List<String>> arena){
    
    System.out.println("\n  "+sea);
    for(int i = 0; i <= 9; i++){
    System.out.print(i + "|");
        for(int j = 0; j < 10; j++){
            System.out.print(arena.get(i).get(j));
        }
        System.out.println("|" + i);
    }
    System.out.println("  "+sea);
    System.out.println("\n");
}

public static void clearSc(){
    try {
        if (System.getProperty("os.name").contains("windows")) {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }else{
            System.out.print("\033\143");
        }
    } catch (Exception e) {
        System.err.println("canot clear Screan" + e);
    }
}
  
}