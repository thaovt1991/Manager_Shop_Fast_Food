

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String LINK_FILE_ACCOUNT = "D:\\Manager_Shop_Fast_Food\\data\\account.txt";
    public static final String LINK_FILE_FOOD_AND_DRINK = "D:\\Manager_Shop_Fast_Food\\data\\food_and_drink.csv";


    public static boolean isNumber(String input){
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Object> readToFile(String path) {
        List<Object> listObject = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listObject = (List<Object>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listObject;
    }

    public static void writeToFile(String path, List<Object> list) {
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
            System.out.println("Success !");
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

//    public static void readToCsv(String filePath){
//        try{
//
//        }
//    }


    public static void main(String[] args) {
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
