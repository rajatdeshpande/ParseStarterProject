package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by rajatdeshpande on 5/23/14.
 */
public class CheckoutActivity extends Activity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        ListElement[] listElements = new ListElement[2];
        listElements[0] = new ListElement("T","abc","1-2pm",100,10,R.drawable.ic_launcher,false);
        listElements[0].quantity = 2;
        listElements[0].imageResource = R.drawable.ic_launcher;
        listElements[0].deliverySlot = "1-2pm";
        listElements[0].nameOfItem = "Paneer Thali";
        listElements[1] = new ListElement("T","xyz","2-3pm",100,10,R.drawable.ic_launcher,false);
        listElements[1].quantity = 3;
        listElements[1].imageResource = R.drawable.ic_launcher;
        listElements[1].deliverySlot = "2-3pm";
        listElements[1].nameOfItem = "Bakwaas Thali";

        listView = (ListView) findViewById(R.id.list_view_checkout_items);
        CheckOutAdapter adapter = new CheckOutAdapter(this, listElements);
        listView.setAdapter(adapter);

    }
}
