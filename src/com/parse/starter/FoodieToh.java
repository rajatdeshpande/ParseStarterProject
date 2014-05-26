package com.parse.starter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

/**
 * Created by rajatdeshpande on 5/23/14.
 */
public class FoodieToh extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 5;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    private MenuData menusByDay;


    private ParseApplication myApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodie_toh);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageTransformer(true, new DepthPageTransformer());
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

//        CustomDialogClass cdd=new CustomDialogClass(this);
//        cdd.show();
//        Intent intent = new Intent(this, CheckoutActivity.class);
//        startActivity(intent);
        myApp = (ParseApplication) getApplication();
        menusByDay = myApp.getMenuDataForDay("1");

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public MenuDay menu_arr[] = new MenuDay[]{
                new MenuDay("Salad 1", "Rice 1","Dal 1","Sabzi 1","Dessert 1","Monday",false,R.drawable.food1),
                new MenuDay("Salad 2", "Rice 2","Dal 2","Sabzi 2","Dessert 2","Tuesday",false,R.drawable.food2),
                new MenuDay("Salad 3", "Rice 3","Dal 3","Sabzi 3","Dessert 3","Wednesday",false,R.drawable.food3),
                new MenuDay("Salad 4", "Rice 4","Dal 4","Sabzi 4","Dessert 4","Thursday",false,R.drawable.food4),
                new MenuDay("Salad 5", "Rice 5","Dal 5","Sabzi 5","Dessert 5","Friday",false,R.drawable.food5)
        };

        @Override
        public FoodieTohFragment getItem(int position) {
            FoodieTohFragment dayMenuFragment;
            //MenuDay menu_item;
            //menu_item = menu_arr[position];
            dayMenuFragment = new FoodieTohFragment();
            Bundle args = new Bundle();
            args.putString("item_1", menu_arr[position].food_item1);
            args.putString("item_2", menu_arr[position].food_item2);
            args.putString("item_3", menu_arr[position].food_item3);
            args.putString("item_4", menu_arr[position].food_item4);
            args.putString("item_5", menu_arr[position].food_item5);
            args.putString("day_name", menu_arr[position].weekday_name);
            args.putInt("image_Res", menu_arr[position].ImageRes);
            dayMenuFragment.setArguments(args);
            return dayMenuFragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


}