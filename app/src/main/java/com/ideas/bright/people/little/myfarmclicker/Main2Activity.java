package com.ideas.bright.people.little.myfarmclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {

    private int maxClubbers = 200;

    private ProgressBar progressBar;
    private ProgressBar progressBar1;
    private Button moreClubbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressBar = findViewById(R.id.progressBar);
        progressBar1 = findViewById(R.id.progressBar2);
        moreClubbers = findViewById(R.id.button4);

        progressBar.setMax(maxClubbers);

        moreClubbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(progressBar.getProgress()+1);
                progressBar1.setProgress(progressBar1.getProgress()+1);
            }
        });
    }
}
