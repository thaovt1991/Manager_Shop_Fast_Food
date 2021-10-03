import java.util.ArrayList;
import java.util.TreeMap;

public class Table {
    private int idTable ;
    private String name ;
    private TreeMap<FoodAndDrink, Integer> usedFoodAndDrink;
    private long totalMoney = 0;

    public Table(int idTable, String name, TreeMap<FoodAndDrink,Integer> usedFoodAndDrink) {
        this.idTable = idTable;
        this.name = name;
        this.usedFoodAndDrink = usedFoodAndDrink;
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

    public TreeMap<FoodAndDrink,Integer> getUsedProduct() {
        return usedFoodAndDrink;
    }

    public void setUsedProduct(TreeMap<FoodAndDrink,Integer> usedFoodAndDrink) {
        this.usedFoodAndDrink = usedFoodAndDrink;
    }

    public long getTotalMoney() {
        long totalMoney = 0;
        for (FoodAndDrink p : usedFoodAndDrink.keySet()){
            int num = usedFoodAndDrink.get(p) ;
            totalMoney += p.getPriceFoodAndDrink() * num  ;
        }
        return totalMoney ;
    }


}
