package com.ideas.bright.people.little.myfarmclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ideas.bright.people.little.myfarmclicker.resource.CowBarn;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button mBtnAdd;
    Button mBtnMilk;
    Button mBtnSell;

    TextView mTvCows;
    TextView mTvMilk;
    TextView mTvMoney;

    CowBarn cowBarn;

    private double priceOfMilk = 0.5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAdd = findViewById(R.id.button);
        mBtnMilk = findViewById(R.id.button2);
        mBtnSell = findViewById(R.id.button3);

        mTvCows = findViewById(R.id.cows_total);
        mTvMilk = findViewById(R.id.milk_total);
        mTvMoney = findViewById(R.id.money_total);

        cowBarn = new CowBarn();

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cowBarn.addAnimals();
                mTvCows.setText("" + cowBarn.getAnimals());
            }
        });

        mBtnMilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cowBarn.produce();
                mTvMilk.setText("" + twoDecimals(cowBarn.getProduce()));
            }
        });

        mBtnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvMoney.setText("$" + twoDecimals(cowBarn.sellProduce(priceOfMilk)));
                mTvMilk.setText("" + twoDecimals(cowBarn.getProduce()));
            }
        });

    }

    private String twoDecimals(double number)
    {
        return new DecimalFormat("#.00").format(number);
    }
}
