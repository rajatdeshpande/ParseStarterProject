package com.parse.starter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rajatdeshpande on 5/23/14.
 */
public class FoodieTohFragment extends Fragment {
    TextView mItem1;
    TextView mItem2;
    TextView mItem3;
    TextView mItem4;
    TextView mItem5;
    TextView dayName;
    ImageView backImage;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_foodie_toh, container, false);
        mItem1 = (TextView)rootView.findViewById(R.id.menu_item1);
        mItem2 = (TextView)rootView.findViewById(R.id.menu_item2);
        mItem3 = (TextView)rootView.findViewById(R.id.menu_item3);
        mItem4 = (TextView)rootView.findViewById(R.id.menu_item4);
        mItem5 = (TextView)rootView.findViewById(R.id.menu_item5);
        dayName = (TextView)rootView.findViewById(R.id.weekday_name);
        backImage = (ImageView)rootView.findViewById(R.id.corp_image);
        Bundle args = getArguments();
        mItem1.setText(args.getString("item_1"));
        mItem2.setText(args.getString("item_2"));
        mItem3.setText(args.getString("item_3"));
        mItem4.setText(args.getString("item_4"));
        mItem5.setText(args.getString("item_5"));
        dayName.setText(args.getString("day_name"));
        backImage.setImageResource(args.getInt("image_Res"));
        return rootView;
    }

}
