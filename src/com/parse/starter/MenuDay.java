package com.parse.starter;

/**
 * Created by rajatdeshpande on 5/23/14.
 */
public class MenuDay {
    public String food_item1;
    public String food_item2;
    public String food_item3;
    public String food_item4;
    public String food_item5;
    public String weekday_name;
    public Boolean isSelected;
    public int ImageRes;

    public MenuDay(){
        super();
    }

    public MenuDay(String food_item1, String food_item2, String food_item3, String food_item4, String food_item5, String weekday_name,Boolean isSelected, int imageRes) {
        super();
        this.food_item1 = food_item1;
        this.food_item2 = food_item2;
        this.food_item3 = food_item3;
        this.food_item4 = food_item4;
        this.food_item5 = food_item5;
        this.weekday_name = weekday_name;
        this.isSelected = isSelected;
        this.ImageRes = imageRes;
    }
}
