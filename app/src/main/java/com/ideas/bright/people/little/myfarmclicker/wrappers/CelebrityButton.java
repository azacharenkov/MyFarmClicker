package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.adapters.CelebrityAdapter;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.Celebrity;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

import java.util.List;

public class CelebrityButton {

    private List<Celebrity> celebrityList;
    private GameMultipliers gameMultipliers;
    private Context context;
    private CelebrityAdapter adapter;

    public CelebrityButton(List<Celebrity> celebrityList, GameMultipliers gameMultipliers, Context context) {
        this.celebrityList = celebrityList;
        this.gameMultipliers = gameMultipliers;
        this.context = context;
        adapter = new CelebrityAdapter(context, celebrityList);
        getGridView().setAdapter(adapter);
        setUpButton();
    }

    private void setUpButton()
    {
        Button button = getButton();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Celebrity celebrity = Celebrity.getRandom(celebrityList, Math.random());
                celebrity.setLevel(celebrity.getLevel() + 1);
                gameMultipliers.addMultiplier(celebrity.getMultiplier());
                adapter.notifyDataSetChanged();
            }
        });
    }

    private Button getButton()
    {
        return ((Activity) context).findViewById(R.id.celebrityButton);
    }

    private GridView getGridView()
    {
        return ((Activity) context).findViewById(R.id.celebritiesTable);
    }
}
