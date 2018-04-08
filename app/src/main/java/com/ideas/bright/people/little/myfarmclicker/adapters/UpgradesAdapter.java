package com.ideas.bright.people.little.myfarmclicker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.MoneyUtils;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.Upgrade;
import com.ideas.bright.people.little.myfarmclicker.wrappers.BankText;
import com.ideas.bright.people.little.myfarmclicker.wrappers.Wrappers;

import java.text.DecimalFormat;
import java.util.List;

public class UpgradesAdapter extends BaseAdapter {

    private Context context;
    private List<Upgrade> upgrades;

    private Wrappers wrappers;
    private GameMultipliers gameMultipliers;
    private static LayoutInflater inflater = null;

    public UpgradesAdapter(Context context, List<Upgrade> upgrades, GameMultipliers gameMultipliers, Wrappers wrappers) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.upgrades = upgrades;
        this.gameMultipliers = gameMultipliers;
        this.wrappers = wrappers;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return upgrades.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return upgrades.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null) {
            vi = inflater.inflate(R.layout.upgrade_layout, null);
        }
        final Upgrade upgrade = upgrades.get(position);
        TextView name = (TextView) vi.findViewById(R.id.textView4);
        TextView description = (TextView) vi.findViewById(R.id.textView6);
        TextView progressText = (TextView) vi.findViewById(R.id.progressText);
        Button buyButton = (Button) vi.findViewById(R.id.button5);
        ProgressBar progressBar = vi.findViewById(R.id.upgradeProgressBar);

        name.setText(upgrade.getName());
        description.setText(upgrade.getDescription());
        progressText.setText(upgrade.getProgressText());

        buyButton.setEnabled(false);
        buyButton.setText("Maxed");

        progressBar.setMax(upgrade.getMaxLevel());
        progressBar.setProgress(upgrade.getLevel());
        final double nextPrice = upgrade.getPrice() * (upgrade.getLevel() + 1);

        if(upgrade.getLevel() < upgrade.getMaxLevel())
        {
            buyButton.setEnabled(true);
            buyButton.setText(MoneyUtils.toString(nextPrice, new DecimalFormat("#,###")));
        }

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nextPrice < wrappers.getBankText().getBank().getBalance())
                {
                    upgrade.incrementLevel();
                    wrappers.getBankText().getBank().removeMoney(nextPrice);
                    gameMultipliers.applyUpgrade(upgrade);
                    wrappers.updateAll();
                    UpgradesAdapter.this.notifyDataSetChanged();
                }
            }
        });

        return vi;
    }
}