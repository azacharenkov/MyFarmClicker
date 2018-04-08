package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.ProgressBar;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.Club;
import com.ideas.bright.people.little.myfarmclicker.resource.Queue;
import com.ideas.bright.people.little.myfarmclicker.resource.upgrades.GameMultipliers;

public class QueueProgress {

    private Queue queue;
    private Context context;
    private GameMultipliers gameMultipliers;
    private Handler repeatUpdateHandler = new Handler();
    private QueueUpdater queueUpdater = new QueueUpdater();

    public QueueProgress(Queue queue, GameMultipliers gameMultipliers, Context context) {
        this.queue = queue;
        this.context = context;
        this.gameMultipliers = gameMultipliers;
        repeatUpdateHandler.post( queueUpdater );
    }

    public Queue getQueue(){
        return queue;
    }

    public void updateProgress()
    {
        ProgressBar progressBar = ((Activity)context).findViewById(R.id.progressBar2);
        progressBar.setMax(queue.getCapacity());
        progressBar.setProgress(queue.getPeople());
    }

    public void setUpProgress()
    {
        updateProgress();
    }

    private void increment()
    {
        queue.putPeople(1);
        updateProgress();
    }

    class QueueUpdater implements Runnable {
        public void run() {
                increment();
                repeatUpdateHandler.postDelayed( queueUpdater, gameMultipliers.getQueueRate() );
            }
    }

    public void stopHandler()
    {
        repeatUpdateHandler.removeCallbacks(queueUpdater);
    }
}