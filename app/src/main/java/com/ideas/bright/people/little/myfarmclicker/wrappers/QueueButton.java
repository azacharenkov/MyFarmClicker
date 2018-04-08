package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.ideas.bright.people.little.myfarmclicker.resource.Club;
import com.ideas.bright.people.little.myfarmclicker.resource.Queue;

public class QueueButton {

    private static final long REP_DELAY = 50;
    private boolean mAutoIncrement = false;

    private ClubProgress club;
    private QueueProgress queue;

    private Handler repeatUpdateHandler = new Handler();

    public QueueButton(ClubProgress club, QueueProgress queue) {
        this.club = club;
        this.queue = queue;
        club.setUpProgress();
        queue.setUpProgress();
    }

    public void addQueueButtonTasks(Button button)
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });

        button.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View arg0) {
                        mAutoIncrement = true;
                        repeatUpdateHandler.post( new RptUpdater() );
                        return false;
                    }
                }
        );

        button.setOnTouchListener( new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                        && mAutoIncrement ){
                    mAutoIncrement = false;
                }
                return false;
            }
        });
    }

    private void increment()
    {
        int peopleToAdd = queue.getQueue().getPerson();
        int peopleAdded = club.getClub().addPeople(peopleToAdd);
        if(peopleAdded < peopleToAdd) {
            queue.getQueue().putPeople(Math.abs(peopleAdded - peopleToAdd));
            if(peopleAdded != 0)
            {
                queue.updateProgress();
                club.updateProgress();
            }
        } else {
            queue.updateProgress();
            club.updateProgress();
        }
    }

    class RptUpdater implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                increment();
                repeatUpdateHandler.postDelayed( new RptUpdater(), REP_DELAY );
            }
        }
    }
}
