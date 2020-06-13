package com.bilal.actors;

import com.bilal.resources.Transaction;

public class LoanCompany extends Thread{
    private CurrentAccount currentBankAccount;
    private String StudentName;

    public LoanCompany(CurrentAccount account, String name, ThreadGroup group) {
        super(group, name);
        this.currentBankAccount = account;
        this.StudentName = name;
    }

    @Override
    public void run() {
        System.out.println("******** Starting LoanCompany Transactions ********");

        for (int i = 0; i < 3; i++) {
            Transaction loanDeposit = new Transaction(this.StudentName, 60000);
            currentBankAccount.deposit(loanDeposit);
            System.out.println("[Student's LoanCompany]: Deposit transaction made: " + loanDeposit);

            try {
                sleep( (int)(Math.random() * 100) ) ;
            }
            catch (InterruptedException e) { }
        }

        System.out.println("******** Closing LoanCompany Transactions ********");
    }
}
