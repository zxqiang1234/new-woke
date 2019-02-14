package orderTest;

import java.util.Date;

/**
 * @description: 测试
 * @author: xuqiang
 * @createDate: 2019-01-21 11:03
 **/
public class Apple {

    private  int weight;

    private String color;
    private Date birthDay;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Apple(int weight, String color, Date birthDay) {
        this.weight = weight;
        this.color = color;
        this.birthDay = birthDay;
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
