import jdk.nashorn.internal.ir.Symbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Personnel extends Users {
    private  String part = "personnel";
    private ArrayList<FoodAndDrink> arrayFoodAndDrink;
    private LinkedList<Table> queueTable;

    public Personnel(String userName, String pass) {
        super(userName, pass);
        String part = "personnel";
    }

    public Personnel(String usersName, String password, String fullName, String personalInformation) {
        super(usersName, password, fullName, personalInformation);
        String part = "personnel";
    }

    public String getPart() {
        return part;
    }

    public  void menuWorksPersonnel() {
        char choice = 'x';
        do {
            System.out.println("=====================================================================");
            System.out.println(displayUser() + "- part : " + part);
            System.out.println("1. Creat table");
            System.out.println("2. Add food and drink to table");
            System.out.println("3. Payment table");
            System.out.println("4. Display list table");
            System.out.println("5. Log Out");
            System.out.println("=====================================================================");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Your choice :");
            choice = scanner.nextLine().charAt(0);
            switch (choice) {
                case '1':
                    //createTable();
                    break;
                case '2':
                    //Add;
                    break;
                case '3':
                    //paymentTable();
                    break;
                case '4':
                    //displayListTable();
                    break;
                case '5':
                    logOut();
                    break;
                default:
                    System.out.println("Please choose from the menu !");
            }
        } while (choice != '5');
    }

    public void creatTable() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input id : ");
        String idInput = input.nextLine();
        boolean isIdTable = isInteger(idInput) && Integer.parseInt(idInput) >= 1 && Integer.parseInt(idInput) <= 100;
        int id = 0;
        do {
            if (isIdTable) {
                id = Integer.parseInt(idInput);
                for (Table table : queueTable) {
                    if (table.getIdTable() == id) {
                        System.out.println("Table already exists !");
                        break;
                    }
                }
            } else System.out.println("Table not have in shop !");
        } while (!isIdTable || isHadInListTable(id));
        String nameTable = "Table " + id ;
        System.out.println(nameTable);
        System.out.println("List oder of " +nameTable);
        char choice ='x';
        int idFAD = -1;
        List<Object> listFoodAndDrink = Main.readToFile(Main.LINK_FILE_FOOD_AND_DRINK);
        while (choice != 'q'){
            System.out.println("============= FOOD AND DRINK ================");
            for(Object fad : listFoodAndDrink ){
                FoodAndDrink p = (FoodAndDrink) fad;
                idFAD =p.getIdFoodAndDrink();
                System.out.println(idFAD + ". " + p.toString());
            }
            System.out.println("q. Exit menu");
        }


    }


    public boolean isHadInListTable(int id) {
        for (Table table : queueTable) {
            if (table.getIdTable() == id) return true;
        }
        return false;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}