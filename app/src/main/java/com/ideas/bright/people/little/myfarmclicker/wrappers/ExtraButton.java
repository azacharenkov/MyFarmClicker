package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

import java.util.Random;

public class ExtraButton {

    private class Extra {
        private double amount;
    }

    private Extra extra;

    private Context context;
    private GameMultipliers gameMultipliers;
    private Wrappers wrappers;


    private Handler repeatUpdateHandler = new Handler();
    private ExtraUpdater extraUpdater = new ExtraUpdater();

    public ExtraButton(Context context, GameMultipliers gameMultipliers, Wrappers wrappers) {
        this.context = context;
        this.gameMultipliers = gameMultipliers;
        this.wrappers = wrappers;
        setUpButton();
        repeatUpdateHandler.postDelayed(extraUpdater, getRepDelay());
    }

    private void setUpButton()
    {
        final Button button = getButton();
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrappers.getBankText().getBank().addMoney(extra.amount);
                wrappers.getBankText().updateProgress();
                extra = null;
                button.setVisibility(View.INVISIBLE);
            }
        });
    }

    private Button getButton()
    {
        return ((Activity) context).findViewById(R.id.extraButton);
    }

    private void showButton()
    {
        getButton().setVisibility(View.VISIBLE);
    }

    private void createExtra()
    {
        extra = new Extra();
        extra.amount = (1 + Math.random()) * wrappers.getClubProgress().getClub().getPeople() * gameMultipliers.getPricePerCustomer();
    }

    class ExtraUpdater implements Runnable {
        public void run() {
            if(extra == null) {
                createExtra();
                showButton();
            }
            repeatUpdateHandler.postDelayed( extraUpdater, getRepDelay() );
        }
    }

    private long getRepDelay()
    {
        return new Random().nextInt(5000) + 3000;
    }

    public void stopHandler()
    {
        repeatUpdateHandler.removeCallbacks(extraUpdater);
    }
}
