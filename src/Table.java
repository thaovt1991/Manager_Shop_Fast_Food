import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;


public class Table implements Serializable {
    private int idTable ;
    private String name ;
    private TreeMap<String, Integer> usedFoodAndDrink;
    private long totalMoney = 0;

    public Table(int idTable, String name, TreeMap<String,Integer> usedFoodAndDrink) {
        this.idTable = idTable;
        this.name = name;
        this.usedFoodAndDrink = usedFoodAndDrink;
        long totalMoney = 0;
        List<FoodAndDrink> listFoodAndDrink = new ArrayList<>();
        listFoodAndDrink = Main.readToFile(Main.LINK_FILE_FOOD_AND_DRINK);
        for (String p : usedFoodAndDrink.keySet()){
            int num = usedFoodAndDrink.get(p) ;
            for (FoodAndDrink fad : listFoodAndDrink){
                if (fad.getNameFoodAndDrink() == p){
                    totalMoney += fad.getPriceFoodAndDrink() * num  ;
                }
            }
        }
        this.totalMoney = totalMoney ;
    }

    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeMap<String,Integer> getUsedProduct() {
        return usedFoodAndDrink;
    }

    public void setUsedProduct(TreeMap<String,Integer> usedFoodAndDrink) {
        this.usedFoodAndDrink = usedFoodAndDrink;
    }

    public long getTotalMoney() {
        long totalMoney = 0;
        List<FoodAndDrink> listFoodAndDrink = new ArrayList<>();
       listFoodAndDrink = Main.readToFile(Main.LINK_FILE_FOOD_AND_DRINK);
        for (String p : usedFoodAndDrink.keySet()){
            int num = usedFoodAndDrink.get(p) ;
            for (FoodAndDrink fad : listFoodAndDrink){
                if (fad.getNameFoodAndDrink() == p){
                    totalMoney += fad.getPriceFoodAndDrink() * num  ;
                }
            }
        } return totalMoney;
    }


}
