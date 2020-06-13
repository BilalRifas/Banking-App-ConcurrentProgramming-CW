package com.bilal.actors;

import com.bilal.resources.BankAccount;
import com.bilal.resources.Statement;
import com.bilal.resources.Transaction;

public class CurrentAccount implements BankAccount {
    private String studentID;
    private int studentAccountNumber;
    private Statement statement;
    private int balance;

    public CurrentAccount(String studentID, int studentAccountNumber, int balance) {
        this.studentID = studentID;
        this.studentAccountNumber = studentAccountNumber;
        this.statement = new Statement(studentID, studentAccountNumber);
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public int getStudentAccountNumber() {
        return this.studentAccountNumber;
    }

    @Override
    public String getAccountHolder() {
        return this.studentID;
    }

    @Override
    public synchronized void deposit(Transaction trans) {
        int depositAmount = trans.getAmount();
        this.balance += depositAmount;
        this.statement.addTransaction(trans.getCID(), depositAmount, this.balance);

        notifyAll();
    }

    @Override
    public boolean isOverdrawn() {
        return this.balance < 0;
    }

    @Override
    public void printBankStatement() {
        this.statement.print();
    }

    @Override
    public synchronized void withdrawal(Transaction t) {
        int withdrawAmount = t.getAmount();

        while (withdrawAmount > this.balance) {
            try {
                System.out.println("[Student CurrentAccount]: Withdrawing of " + withdrawAmount + " by " + t.getCID() +
                        " unsuccessful. Please wait until funds are available...");
                wait();
            } catch (InterruptedException e) { }
        }

        this.balance -= withdrawAmount;
        this.statement.addTransaction(t.getCID(), withdrawAmount, this.balance);
    }


}
