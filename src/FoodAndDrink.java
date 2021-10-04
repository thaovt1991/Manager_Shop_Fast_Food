import java.io.Serializable;

public class FoodAndDrink implements Serializable {
    private int idFoodAndDrink;
    private String nameFoodAndDrink;
    private String typeFoodAndDrink;
    private long priceFoodAndDrink;
    private long totalQuantity;
    private String otherFoodAndDrink;

    public FoodAndDrink(int idFoodAndDrink, String nameFoodAndDrink, String typeFoodAndDrink, long priceFoodAndDrink,long totalQuantity, String otherFoodAndDrink) {
        this.idFoodAndDrink = idFoodAndDrink;
        this.nameFoodAndDrink = nameFoodAndDrink;
        this.typeFoodAndDrink = typeFoodAndDrink;
        this.priceFoodAndDrink = priceFoodAndDrink;
        this.totalQuantity = totalQuantity;
        this.otherFoodAndDrink = otherFoodAndDrink;
    }

    public String getTypeFoodAndDrink() {
        return typeFoodAndDrink;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getIdFoodAndDrink() {
        return idFoodAndDrink;
    }

    public void setIdFoodAndDrink(int idFoodAndDrink) {
        this.idFoodAndDrink = idFoodAndDrink;
    }

    public String getNameFoodAndDrink() {
        return nameFoodAndDrink;
    }

    public void setNameFoodAndDrink(String nameFoodAndDrink) {
        this.nameFoodAndDrink = nameFoodAndDrink;
    }

    public String getOriginFoodAndDrink() {
        return typeFoodAndDrink;
    }

    public void setTypeFoodAndDrink(String typeFoodAndDrink) {
        this.typeFoodAndDrink = typeFoodAndDrink;
    }

    public long getPriceFoodAndDrink() {
        return priceFoodAndDrink;
    }

    public void setPriceFoodAndDrink(long priceFoodAndDrink) {
        this.priceFoodAndDrink = priceFoodAndDrink;
    }

    public String getStatus() {
        return otherFoodAndDrink;
    }

    public void setOtherFoodAndDrink(String otherFoodAndDrink) {
        this.otherFoodAndDrink = otherFoodAndDrink;
    }

    @Override
    public String toString() {
        return "Id FoodAndDrink : " + idFoodAndDrink + ", name FoodAndDrink : " + nameFoodAndDrink + ", Type : " + typeFoodAndDrink + ", Other : " + otherFoodAndDrink;
    }
}
