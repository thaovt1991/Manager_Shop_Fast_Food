import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    private String usersName ;
    private String password ;

    public Users(String usersName , String password){
        this.usersName  = usersName ;
        this.password = password ;
    } ;

    public void logIn(String usersName , String password){
        System.out.println("Wellcom");
    } ;

    public void logOut(){
        char choice  ;
        do{
        System.out.println("--------------------");
        System.out.println("|  You are sure !  |");
        System.out.println("|      1. Yes      |");
        System.out.println("|      2. No       |");
        System.out.println("--------------------");

        Scanner input = new Scanner(System.in) ;
         choice = input.nextLine().charAt(0) ;
        switch (choice){
            case '1':
                System.out.println("Thank you for using the software!");
                System.exit(0);
                break;
            case '2' :
                //goi ham cua tung user
                break;
            default:
                logOut() ;
        }
    }while (choice == '1' || choice == '2');}

    public List<Object> readToFile(String path){
        List<Object> listObject = new ArrayList<>() ;
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listObject =(List<Object>) ois.readObject();
            ois.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listObject ;
    }

    public void writeToFile(String path,List<Object> list){
         try{
             FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(list);
             oos.close();
             fos.close();
         }catch (IOException e){
             e.getStackTrace();
         }
    }
}
