

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        System.out.println("Wellcom to Manager Shop Fast Food ! You need login to work !");
        System.out.print("User name : ");
        String userName = input.nextLine();
        System.out.print("User password : ");
        String pass = input.nextLine();
        //ArrayList<String> account = new ArrayList<>() ;
        Users user = new Users(userName,pass) ;
        user.logIn(userName,pass);
    }
}
