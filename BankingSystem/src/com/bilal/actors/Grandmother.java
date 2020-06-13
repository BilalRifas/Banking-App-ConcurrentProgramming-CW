package com.bilal.actors;

import com.bilal.resources.Transaction;

public class Grandmother extends Thread{
    private CurrentAccount bankCurrentAccount;
    private String studentName;

    public Grandmother(CurrentAccount account, String studentName, ThreadGroup group) {
        super(group, studentName);
        this.bankCurrentAccount = account;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("******** Beginning  Grandmother's Bank Transactions ********");

        Transaction birthdayGift = new Transaction(this.studentName, 20000);
        bankCurrentAccount.deposit(birthdayGift);

        System.out.println("[Student's Grandmother]: Deposit transaction made: " + birthdayGift);

        try {
            sleep( (int)(Math.random() * 100) ) ;
        }
        catch (InterruptedException e) { }

        Transaction christmasGift = new Transaction(this.studentName, 50000);
        bankCurrentAccount.deposit(christmasGift);
        System.out.println("[Student's Grandmother]: Deposit transaction made: " + christmasGift);

        System.out.println(" ******** Closing Grandmother's Transactions ********");
    }
}
