package com.parse.starter;

/**
 * Created by rajatdeshpande on 5/23/14.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by rajatdeshpande on 5/20/14.
 */
public class CheckOutAdapter extends ArrayAdapter<ListElement> {
    private final Activity context;
    private final ListElement[] listElements;

    static class ViewHolder {
        public TextView textViewItemName;
        public TextView textViewDeliverySlot;
        public TextView textViewPrice;
        public EditText editTextQuantity;
        public ImageButton imageButton;
    }

    public CheckOutAdapter(Activity context, ListElement[] listElements) {
        super(context, R.layout.checkout_list_item, listElements);
        this.context = context;
        this.listElements = listElements;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.checkout_list_item, null);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.textViewItemName = (TextView) rowView.findViewById(R.id.text_view_item_name);
            viewHolder.textViewDeliverySlot  = (TextView) rowView.findViewById(R.id.text_view_delivery_slot);
            viewHolder.textViewPrice = (TextView) rowView.findViewById(R.id.text_view_price);
            viewHolder.editTextQuantity = (EditText) rowView.findViewById(R.id.edit_text_quantity);
            viewHolder.imageButton = (ImageButton) rowView
                    .findViewById(R.id.image_button_day_pic);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        ListElement s = listElements[position];
        holder.textViewItemName.setText(s.nameOfItem);
        holder.textViewDeliverySlot.setText(s.deliverySlot);
        holder.textViewPrice.setText(Integer.toString(s.price));
        holder.editTextQuantity.setText(Integer.toString(s.quantity));
        holder.imageButton.setImageResource(s.imageResource);

        return rowView;
    }
}