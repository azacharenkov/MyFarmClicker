package com.ideas.bright.people.little.myfarmclicker.wrappers;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ideas.bright.people.little.myfarmclicker.R;
import com.ideas.bright.people.little.myfarmclicker.resource.Club;

public class ClubProgress {

    private static final long REP_DELAY = 500;
    private static final long AUTO_ATTENDANCE_DELAY = 4000;

    private Club club;
    private Context context;
    int clubProgressBar;
    private BankText bankText;

    private Handler repeatUpdateHandler = new Handler();
    private MoneyUpdater moneyUpdater = new MoneyUpdater();
    private AutoAttendanceUpdater autoAttendanceUpdater = new AutoAttendanceUpdater();

    public ClubProgress(Club club, int clubProgressBar, BankText bankText, Context context) {
        this.club = club;
        this.context = context;
        this.clubProgressBar = clubProgressBar;
        this.bankText = bankText;
        repeatUpdateHandler.post( moneyUpdater );
        repeatUpdateHandler.post( autoAttendanceUpdater );
    }

    public Club getClub(){
        return club;
    }

    public void updateProgress()
    {
        ProgressBar progressBar = ((Activity)context).findViewById(R.id.progressBar);
        progressBar.setMax(club.getCapacity());
        progressBar.setProgress(club.getPeople());

        TextView progressTextView = ((Activity) context).findViewById(R.id.clubProgressTextView);
        progressTextView.setText("" + club.getPeople());
    }

    public void setUpProgress()
    {
        updateProgress();
    }

    private void increment()
    {
        bankText.getBank().addMoney(club.getMoney());
        bankText.updateProgress();
    }

    private void autoAttend()
    {
        club.autoAttend();
        updateProgress();
    }

    class MoneyUpdater implements Runnable {
        public void run() {
            increment();
            repeatUpdateHandler.postDelayed( moneyUpdater, REP_DELAY );
        }
    }

    class AutoAttendanceUpdater implements Runnable {
        public void run() {
            autoAttend();
            repeatUpdateHandler.postDelayed( autoAttendanceUpdater, AUTO_ATTENDANCE_DELAY );
        }
    }

    public void stopHandler()
    {
        repeatUpdateHandler.removeCallbacks(moneyUpdater);
        repeatUpdateHandler.removeCallbacks(autoAttendanceUpdater);
    }
}
