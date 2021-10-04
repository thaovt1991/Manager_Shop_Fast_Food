

import java.io.*;
import java.util.*;

public class Main {
    public static final String LINK_FILE_ACCOUNT = "D:\\Manager_Shop_Fast_Food\\data\\account.txt";
    public static final String LINK_FILE_QUEUE_OF_TABLES = "D:\\Manager_Shop_Fast_Food\\data\\queue_of_tables.txt";
    public static final String LINK_FILE_FOOD_AND_DRINK = "D:\\Manager_Shop_Fast_Food\\data\\food_and_drink.txt";
    public static final String LINK_FILE_FOOD_AND_DRINK_CSV ="D:\\Manager_Shop_Fast_Food\\data\\food_and_drink.csv";

    public static boolean isNumber(String input){
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<FoodAndDrink> readToFile(String path) {
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

    public static void writeToFile(String path, List<FoodAndDrink> list) {
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

    public static void writeToCsvProduct(String path, List<FoodAndDrink> foodAndDrinks) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
            writer.append("ID");
            writer.append(",");
            writer.append("NAME PRODUCT");
            writer.append(",");
            writer.append("ORIGIN PRODUCT");
            writer.append(",");
            writer.append("PRICE");
            writer.append(",");
            writer.append("STATUS");
            writer.append("\n");

            for (FoodAndDrink foodAndDrink : foodAndDrinks) {
                writer.append(String.valueOf(foodAndDrink.getIdFoodAndDrink()));
                writer.append(",");
                writer.append(foodAndDrink.getNameFoodAndDrink());
                writer.append(",");
                writer.append(foodAndDrink.getOriginFoodAndDrink());
                writer.append(",");
                writer.append(String.valueOf(foodAndDrink.getPriceFoodAndDrink()));
                writer.append(",");
                writer.append(foodAndDrink.getStatus());
                writer.append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
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

    public static void writeToFileQueueTables(String path, List<Table> list) {
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

    public static void main(String[] args) {

        FoodAndDrink fad1 = new FoodAndDrink(1,"coffee","drink",15000,"origin: make in Vietnam");
        FoodAndDrink fad2 = new FoodAndDrink(2,"Aquafina","drink",10000,"origin: make in Vietnam");
        FoodAndDrink fad3 = new FoodAndDrink(3,"cake","food",20000,"origin: make in Vietnam");
        List<FoodAndDrink> listFaD = new ArrayList<>();
        listFaD.add(fad1);
        listFaD.add(fad2);
        listFaD.add(fad3);

        writeToFile(LINK_FILE_FOOD_AND_DRINK,listFaD);
        writeToCsvProduct(LINK_FILE_FOOD_AND_DRINK_CSV,listFaD);

        TreeMap<String,Integer> tree = new TreeMap<>();
        tree.put(fad1.getNameFoodAndDrink(),2);
        tree.put(fad3.getNameFoodAndDrink(),2);
        Table tb1 = new Table(1,"Table 1",tree);
        List<Table> tableList = new ArrayList<>();
        tableList.add(tb1);
        writeToFileQueueTables(LINK_FILE_QUEUE_OF_TABLES,tableList);



        Scanner input = new Scanner(System.in) ;
        System.out.println("Wellcom to Manager Shop Fast Food ! You need login to work !");
        System.out.print("User name : ");
        String userName = input.nextLine();
        System.out.print("User password : ");
        String pass = input.nextLine();

        Personnel p = new Personnel(userName, pass);
        p.menuWorksPersonnel();

//        List<Users> = new ArrayList<>() ;
//        Users
//        accounts.add()
////        accounts = readToFile(LINK_FILE_ACCOUNT);
////        for(Users account : accounts)


    }
}
