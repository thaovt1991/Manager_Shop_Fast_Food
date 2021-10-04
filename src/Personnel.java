import jdk.nashorn.internal.ir.Symbol;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Personnel extends Users {
    private String part = "personnel";
    private ArrayList<FoodAndDrink> arrayFoodAndDrink;
    private ArrayList<Table> queueTable;
    private String timeLogIn;
    private String timeLogOut;
    public final String LINK_FILE_QUEUE_OF_TABLES = "D:\\Manager_Shop_Fast_Food\\data\\queue_of_tables.txt";
    public final String LINK_FILE_FOOD_AND_DRINK = "D:\\Manager_Shop_Fast_Food\\data\\food_and_drink.txt";


    public Personnel(String userName, String pass) {
        super(userName, pass);
        String part = "personnel";
    }

    public Personnel(String usersName, String password, String fullName, String personalInformation) {
        super(usersName, password, fullName, personalInformation);
        String part = "personnel";
    }

    public String getTimeLogIn() {
        return timeLogIn;
    }

    public void setTimeLogIn(String timeLogIn) {
        this.timeLogIn = timeLogIn;
    }

    public String getTimeLogOut() {
        return timeLogOut;
    }

    public void setTimeLogOut(String timeLogOut) {
        this.timeLogOut = timeLogOut;
    }

    public String getPart() {
        return part;
    }

    public void menuWorksPersonnel() {
        char choice = 'x';
        String timeLogIn = java.time.LocalTime.now() + " - " + java.time.LocalDate.now();
        do {
            System.out.println("=====================================================================");
            System.out.println(displayUser() + "- part : " + part + "- time : " + timeLogIn);
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
                    creatTable();
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
        boolean isIdTable;
        int id = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Input id : ");
            String idInput = input.nextLine();
            isIdTable = isInteger(idInput) && 1 <= Integer.parseInt(idInput) && Integer.parseInt(idInput) <= 100;
            if (isIdTable) {
                id = Integer.parseInt(idInput);
                List<Table> queueTable = readToFileQueueTables(LINK_FILE_QUEUE_OF_TABLES);
                for (Table table : queueTable) {
                    if (table.getIdTable() == id) {
                        System.out.println("Table already exists !");break;
                    }
                }
            } else System.out.println("Table not have in shop !");
        } while (!isIdTable || isHadInListTable(id));
        String nameTable = "Table " + id;
        System.out.println(nameTable);
        System.out.println("List oder of " + nameTable);
        String choice = "";
        int idFAD = -1;
        List<FoodAndDrink> listFoodAndDrink = readToFileFoodAndDrink(LINK_FILE_FOOD_AND_DRINK);
        while (choice != "q") {
            System.out.println("============= FOOD AND DRINK ================");
            for (FoodAndDrink fad : listFoodAndDrink) {
                idFAD = fad.getIdFoodAndDrink();
                System.out.println(idFAD + ". " + fad);
            }
            System.out.println("q. Exit menu");
            System.out.println("===============================================");
            Scanner input = new Scanner(System.in);
            System.out.print("choice Food and Drink !: ");
            int idFaD = input.nextInt();
            System.out.print("Quality : ");
            int numFAD = input.nextInt();
            System.out.println("Press any key to continue, press q to exit ");
            Scanner press = new Scanner(System.in);
            choice = press.nextLine();
            TreeMap<String, Integer> usedFoodAndDrink = new TreeMap<>();
            long totalMoney = 0;
            if (choice == "q") {
                char change = 'x';
                do {
                    System.out.println("--------------------");
                    System.out.println("|  You are sure !  |");
                    System.out.println("|      1. Yes      |");
                    System.out.println("|      2. No       |");
                    System.out.println("--------------------");

                    change = input.nextLine().charAt(0);
                    DecimalFormat formater = new DecimalFormat("###,###,###");
                    switch (change) {
                        case '1':
                            Table table = new Table(id, nameTable, usedFoodAndDrink);
                            queueTable.add(table);
                            writeToFileQueueTables(LINK_FILE_QUEUE_OF_TABLES, queueTable);
                            String str = "";
                            for (String p : usedFoodAndDrink.keySet()) {
                                int num = usedFoodAndDrink.get(p);
                                for (FoodAndDrink fad : listFoodAndDrink) {
                                    if (fad.getNameFoodAndDrink() == p) {
                                        totalMoney += fad.getPriceFoodAndDrink() * num;
                                        str += fad.getNameFoodAndDrink() + ", quantity : " + num + fad.getPriceFoodAndDrink() * num + "\n";
                                    }
                                }
                            }
                            System.out.println(str + formater.format(totalMoney));
                            menuWorksPersonnel();
                            break;
                        case '2':
                            creatTable();
                            break;
                        default:
                            System.out.println();
                            logOut();
                    }
                } while (change != '1' && change != '2');
            }
        }
    }


    public boolean isHadInListTable(int id) {
        List<Table> queueTable = new ArrayList<>();
        queueTable = readToFileQueueTables(LINK_FILE_QUEUE_OF_TABLES);
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

    public List<Table> readToFileQueueTables(String path) {
        List<Table> listObject = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listObject = (List<Table>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }

    public void writeToFileQueueTables(String path, List<Table> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public List<FoodAndDrink> readToFileFoodAndDrink(String path) {
        List<FoodAndDrink> listObject = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listObject = (List<FoodAndDrink>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }

    public void writeToFileFoodAndDrink(String path, List<FoodAndDrink> list) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}