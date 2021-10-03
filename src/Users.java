import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    private String usersName;
    private String password;
    private String part;
    private String fullName;
    private String personalInformation;


    public Users(String usersName, String password) {
        this.usersName = usersName;
        this.password = password;
    }

    public Users(String usersName, String password, String fullName, String personalInformation) {
        this.usersName = usersName;
        this.password = password;
        this.fullName = fullName;
        this.personalInformation = personalInformation;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(String personalInformation) {
        this.personalInformation = personalInformation;
    }

    public String displayUser() {
        return "User Name : " + usersName + " - Full name : " + fullName;
    }

    @Override
    public String toString() {
        return displayUser() + "\nPersonal Information : " + personalInformation;
    }


    public void logIn(String usersName, String password) {
        System.out.println("Wellcom! ");
    }

    ;


    public void logOut() {
        char choice;
        do {
            System.out.println("--------------------");
            System.out.println("|  You are sure !  |");
            System.out.println("|      1. Yes      |");
            System.out.println("|      2. No       |");
            System.out.println("--------------------");

            Scanner input = new Scanner(System.in);
            choice = input.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    System.out.println("Thank you for using the software!");
                    System.exit(0);
                    break;
                case '2':
                    if (part == "personnel") {
                        Personnel users = new Personnel(this.usersName, this.password, this.fullName, this.personalInformation);
                        users.menuWorksPersonnel();
                    }
                    break;
                default:
                    System.out.println();
                    logOut();
            }
        } while (choice != '1' && choice != '2');
    }
}
