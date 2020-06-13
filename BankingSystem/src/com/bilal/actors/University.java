package com.bilal.actors;

import com.bilal.resources.Transaction;

public class University extends Thread{
    private CurrentAccount currentAccount;
    private String studentName;

    public University (CurrentAccount account, String studentName, ThreadGroup group) {
        super(group, studentName);
        this.currentAccount = account;
        this.studentName = studentName;
    }

    @Override
    public void run() {
        System.out.println("******** Starting University Transactions ********");

        for (int i = 0; i < 3; i++) {
            Transaction universityCourseFee = new Transaction(this.studentName, 50000);
            currentAccount.withdrawal(universityCourseFee);
            System.out.println("[Student's University]: Withdrawing transaction made: " + universityCourseFee);

            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }

        System.out.println("******** Closing University Transactions ********");
    }
}
