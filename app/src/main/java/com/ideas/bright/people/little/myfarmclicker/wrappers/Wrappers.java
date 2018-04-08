package com.ideas.bright.people.little.myfarmclicker.wrappers;

public class Wrappers {

    private BankText bankText;
    private ClubProgress clubProgress;
    private QueueProgress queueProgress;

    public Wrappers(BankText bankText, ClubProgress clubProgress, QueueProgress queueProgress) {
        this.bankText = bankText;
        this.clubProgress = clubProgress;
        this.queueProgress = queueProgress;
    }

    public BankText getBankText() {
        return bankText;
    }

    public ClubProgress getClubProgress() {
        return clubProgress;
    }

    public QueueProgress getQueueProgress() {
        return queueProgress;
    }

    public void updateAll()
    {
        bankText.updateProgress();
        clubProgress.updateProgress();
        queueProgress.updateProgress();
    }

    public void stopHandlers()
    {
        clubProgress.stopHandler();
        queueProgress.stopHandler();
    }
}
