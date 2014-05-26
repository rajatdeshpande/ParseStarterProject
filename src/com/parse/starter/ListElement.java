package com.parse.starter;

/**
 * Created by rajatdeshpande on 5/23/14.
 */
public class ListElement {

    public String dayOfWeekLetter;
    public String nameOfItem;
    public String deliverySlot;
    public int imageResource;
    public int price;
    public int quantity;
    public boolean isOrdered;

    public ListElement(String dayOfWeekLetter,String nameOfItem,String deliverySlot, int price, int quantity, int imageResource, boolean isOrdered) {
        this.dayOfWeekLetter = dayOfWeekLetter;
        this.price = price;
        this.isOrdered = isOrdered;
        this.nameOfItem = nameOfItem;
        this.deliverySlot = deliverySlot;
        this.imageResource = imageResource;
        this.quantity = quantity;
    }
}
