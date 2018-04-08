package com.ideas.bright.people.little.myfarmclicker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.Celebrity;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class CelebrityAdapter extends BaseAdapter {

    private Context context;
    private final List<Celebrity> celebrityList;

    public CelebrityAdapter(Context context, List<Celebrity> celebrityList) {
        this.context = context;
        this.celebrityList = celebrityList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView = convertView;

        if (convertView == null) {

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.celebrity_window, null);
        }

            Celebrity celebrity = celebrityList.get(position);

            // set value into textview
            TextView celebrityNameTextView = (TextView) gridView
                    .findViewById(R.id.celebrityNameTextView);

            // set image based on selected text
            TextView celebrityBonusTextView = (TextView) gridView
                    .findViewById(R.id.celebrityBonusTextView);

            celebrityNameTextView.setText("?");
            celebrityBonusTextView.setText("+?");

            if(celebrity.getLevel() > 0) {
                celebrityNameTextView.setText(celebrityList.get(position).getName());
                celebrityBonusTextView.setText("" + (celebrityList.get(position).getMultiplier() * celebrity.getLevel()));
            }

        return gridView;
    }

    @Override
    public int getCount() {
        return celebrityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
