import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class Test{
    public static void main(String[] args) throws IOException {
        //scanner deklaras
        Scanner scannerUwU = new Scanner(System.in);

        //csak sortores, hogy cleanebb legyen a konzol
        System.err.println("");
        //file beolvasas + feldarabolja oket
        fileReading();

        System.out.println("Hello idegen, hogyan szólíthatlak?");
        String userName = scannerUwU.nextLine();

        boolean ogUser = false;
        for (String n : fileReading()) {
            if (userName.equals(n)) {
                ogUser=true;
            }
            break;
        }
        if (ogUser==true) {
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

        scannerUwU.close();
    }

    public static String[] fileReading() throws IOException {
        String users = Files.readString(Path.of("users.txt"));
        String[] userNames = users.trim().split(";");
        return userNames;
    }

    public static String kiirFunction(String name){
        return "Üdv "+ name +" ,remélem tetszik a konzolos szirszarságom :D";
    } 
}