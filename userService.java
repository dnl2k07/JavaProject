import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class userService{
    String currentName;

    public static void main(String[] args) throws IOException {
        //scanner deklaras
        Scanner scanner = new Scanner(System.in);

        //csak sortores, hogy cleanebb legyen a konzol
        System.err.println();
        
        while (true) {
            System.out.println("Melyik metódust szeretnéd alkalmazni?");
            System.out.println("(Login - L), (Register - R), (Get usernames - G), (Exit - E)");
            String userChoice = scanner.nextLine();
            userChoice = userChoice.toUpperCase();
            switch (userChoice) {
                case "L":
                    System.out.println("Login");
                    break;

                case "R":
                    System.out.println("Register");
                    break;

                case "G":
                    System.out.println("Getting users");
                    break;

                case "E":
                    System.out.println("Exit");
                    return;

                default:
                    System.out.println("Ilyen opció nincsen :D");
                    break;
            }
            if (userChoice.equals("E")) {
                break;
            }
        }
        

        System.out.println("Hello idegen, hogyan szólíthatlak?");
        String userName = scanner.nextLine();

        
        if (ableToLogin(userName)==true) {
            System.out.println("Ez a felhasználó már létezik, szóval nem adom hozzá UwU");
        }else{
            Files.writeString(Path.of("users.txt"), userName+";" ,StandardOpenOption.CREATE ,StandardOpenOption.APPEND);
            System.out.println(kiirFunction(userName));
        }

        //egyesevel kiiratja oket
        for (String n : fileReading()) {
            if (userName.equals(n)) {
                System.out.println("Current user: "+ n +",");
            }
            System.out.println("Potentional user: "+ n +",");
        }

        scanner.close();
    }

    public static String[] fileReading() throws IOException {
        String users = Files.readString(Path.of("users.txt"));
        String[] userNames = users.trim().split(";");
        return userNames;
    }

    public static boolean ableToLogin(String name) throws IOException {
        boolean exists = false;
        String[] names = fileReading();
        if (names.length!=0) {
            for (int i = 0; i < names.length; i++) {
                if (name.equalsIgnoreCase(names[i])) {
                    exists=true;
                }
            }
        }
        return exists;
    }

    public static String kiirFunction(String name){
        return "Üdv "+ name +" ,remélem tetszik a konzolos szirszarságom :D";
    } 
}