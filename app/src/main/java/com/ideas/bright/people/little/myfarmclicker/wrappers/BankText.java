package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.app.Activity;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.Bank;
import com.ideas.bright.people.little.myfarmclicker.resource.Queue;

public class BankText {

    private Bank bank;
    private Context context;

    public BankText(Bank bank, Context context) {
        this.bank = bank;
        this.context = context;
    }

    public Bank getBank(){
        return bank;
    }

    public void updateProgress()
    {
        TextView balanceText = ((Activity)context).findViewById(R.id.textView2);
        balanceText.setText(bank.toString());
    }

}
