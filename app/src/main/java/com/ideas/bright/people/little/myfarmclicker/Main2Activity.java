package com.ideas.bright.people.little.myfarmclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.ideas.bright.people.little.myfarmclicker.adapters.CelebrityAdapter;
import com.ideas.bright.people.little.myfarmclicker.adapters.UpgradesAdapter;
import com.ideas.bright.people.little.myfarmclicker.resource.Bank;
import com.ideas.bright.people.little.myfarmclicker.resource.Club;
import com.ideas.bright.people.little.myfarmclicker.resource.Queue;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.Celebrity;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.Upgrade;
import com.ideas.bright.people.little.myfarmclicker.wrappers.BankText;
import com.ideas.bright.people.little.myfarmclicker.wrappers.CelebrityButton;
import com.ideas.bright.people.little.myfarmclicker.wrappers.ClubProgress;
import com.ideas.bright.people.little.myfarmclicker.wrappers.ExtraButton;
import com.ideas.bright.people.little.myfarmclicker.wrappers.QueueButton;
import com.ideas.bright.people.little.myfarmclicker.wrappers.QueueProgress;
import com.ideas.bright.people.little.myfarmclicker.wrappers.Wrappers;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Button moreClubbers;
    private ListView listview;
    private CelebrityButton celebrityButton;

    private GameMultipliers gameMultipliers;

    private Club club;
    private Queue queue;
    private Bank bank;

    private Wrappers wrappers;
    private ExtraButton extraButton;

    GridView celebrityTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        moreClubbers = findViewById(R.id.button4);
        gameMultipliers = new GameMultipliers();
        club = new Club(gameMultipliers);
        queue = new Queue(gameMultipliers);
        bank = new Bank();
        BankText bankText = new BankText(bank, this);
        ClubProgress clubProgress = new ClubProgress(club, R.id.progressBar2, bankText,this);
        QueueProgress queueProgress = new QueueProgress(queue, gameMultipliers, this);

        wrappers = new Wrappers(bankText,clubProgress,queueProgress);

        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new UpgradesAdapter(this, Upgrade.createUpgrades(), gameMultipliers, wrappers));

        QueueButton queueButton = new QueueButton(clubProgress, queueProgress);
        queueButton.addQueueButtonTasks(moreClubbers);

        extraButton = new ExtraButton(this, gameMultipliers, wrappers);

        celebrityButton = new CelebrityButton(Celebrity.getCelebrities(), gameMultipliers ,this);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        wrappers.stopHandlers();
        extraButton.stopHandler();
    }

}
