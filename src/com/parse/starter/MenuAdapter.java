package com.parse.starter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parse.ParseObject;

import java.util.List;

/**
 * Created by rajatdeshpande on 5/11/14.
 */
public class MenuAdapter extends ArrayAdapter<Menu> {

    private Context mContext;
    private List<Menu> mMenus;

    public MenuAdapter(Context context, List<Menu> objects) {
        super(context, R.layout.task_row_item, objects);
        this.mContext = context;
        this.mMenus = objects;
        ParseObject.registerSubclass(Menu.class);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
            convertView = mLayoutInflater.inflate(R.layout.task_row_item, null);
        }
        Menu menu = mMenus.get(position);
        TextView descriptionView = (TextView) convertView.findViewById(R.id.task_description);
        descriptionView.setText(menu.getItemName()+ " Price = " + Integer.toString(menu.getItemPrice()));
        return convertView;
    }




}
