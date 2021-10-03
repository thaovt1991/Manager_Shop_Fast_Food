public class FoodAndDrink {
    private int idFoodAndDrink;
    private String nameFoodAndDrink;
    private String typeFoodAndDrink ;
    private long priceFoodAndDrink;
    private String otherFoodAndDrink;

    public FoodAndDrink(int idFoodAndDrink, String nameFoodAndDrink, String typeFoodAndDrink, long priceFoodAndDrink, String otherFoodAndDrink) {
        this.idFoodAndDrink = idFoodAndDrink;
        this.nameFoodAndDrink = nameFoodAndDrink;
        this.typeFoodAndDrink = typeFoodAndDrink;
        this.priceFoodAndDrink = priceFoodAndDrink;
        this.otherFoodAndDrink = otherFoodAndDrink;
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
