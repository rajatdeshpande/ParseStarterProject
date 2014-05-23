package com.parse.starter;
import com.parse.ParseClassName;
import com.parse.ParseObject;
/**
 * Created by rajatdeshpande on 5/9/14.
 */

@ParseClassName("Task")

public class Task extends ParseObject{

    public Task(){

    }

    public boolean isCompleted(){
        return getBoolean("completed");
    }

    public void setCompleted(boolean complete){
        put("completed", complete);
    }

    public String getDescription(){
        return getString("description");
    }

    public void setDescription(String description){
        put("description", description);
    }

}