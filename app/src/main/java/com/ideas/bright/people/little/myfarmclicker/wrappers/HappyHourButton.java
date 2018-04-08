package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

public class HappyHourButton {

    private Context context;
    private GameMultipliers gameMultipliers;

    public HappyHourButton(Context context, GameMultipliers gameMultipliers) {
        this.context = context;
        this.gameMultipliers = gameMultipliers;
        setUpButton();

    }

    private void setUpButton() {
        getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameMultipliers.setMultiplier(2.0);
            }
        });
    }

    private Button getButton()
    {
        return ((Activity) context).findViewById(R.id.happyHourButton);
    }
}
