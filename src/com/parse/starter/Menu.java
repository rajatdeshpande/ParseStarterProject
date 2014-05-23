package com.parse.starter;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by rajatdeshpande on 5/11/14.
 */

@ParseClassName("Menu")
public class Menu extends ParseObject{

    public Menu(){

    }

    public String getItemName(){
        return getString("item_name");
    }

    public int getItemPrice(){
        return getInt("item_price");
    }


}
