package task2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Stead {
    private int weight;
    private int height;
    private BigDecimal price; //цена всего участка
    private BigDecimal priceForUnit; //... и за сотку земли.

    public Stead(int weight, int height, BigDecimal price) {
        this.weight = weight;
        this.height = height;
        this.price = price;
        this.priceForUnit = new BigDecimal(price.doubleValue()/((weight*height)/100));
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceForUnit() {
        return priceForUnit;
    }

    @Override
    public String toString() {
        return "Stead{" +
                "ширина=" + weight +
                ", длинна=" + height +
                ", цена=" + price +
                ", цена за сотку =" + priceForUnit.setScale(2, RoundingMode.HALF_EVEN)+
                '}';
    }
}
