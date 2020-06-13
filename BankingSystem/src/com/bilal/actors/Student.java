package com.bilal.actors;

import com.bilal.resources.Transaction;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student extends Thread{
    private CurrentAccount currentAccount;
    private String studentName;

    public Student(CurrentAccount account, String name, ThreadGroup group) {
        super(group, name);
        this.currentAccount = account;
        this.studentName = name;
    }

    private void randomizeTransactions(Transaction[] transactions) {
        int iteratedIndexCount  = 0;
        Random rand = new Random();
        Set indexes = new HashSet();

        while (iteratedIndexCount < 6) {
            int index = rand.nextInt(6);
            if (indexes.add(index)) {
                if (index < 4) {
                    currentAccount.withdrawal(transactions[index]);
                    System.out.println("[Student]: Withdrawal transaction made: " + transactions[index]);
                } else {
                    currentAccount.deposit(transactions[index]);
                    System.out.println("[Student]: Deposit transaction made: " + transactions[index]);
                }

                try {
                    sleep( (int)(Math.random() * 100) ) ;
                }
                catch (InterruptedException e) { }
                iteratedIndexCount++;
            }
        }
    }

    @Override
    public void run() {
        System.out.println("******** Starting Student Transactions ********");

        Transaction buyPhone = new Transaction(this.studentName, 30000);
        Transaction goShopping = new Transaction(this.studentName, 5000);
        Transaction payPhoneBill = new Transaction(this.studentName, 2000);
        Transaction accommodationPayments = new Transaction(this.studentName, 10000);

        Transaction winLottery = new Transaction(this.studentName, 50000);
        Transaction allowance = new Transaction(this.studentName, 5000);

        // Randomizing the order in which transactions are performed
        Transaction[] transactions = new Transaction[6];
        transactions[0] = buyPhone;
        transactions[1] = goShopping;
        transactions[2] = payPhoneBill;
        transactions[3] = accommodationPayments;
        transactions[4] = winLottery;
        transactions[5] = allowance;
        randomizeTransactions(transactions);

        currentAccount.printBankStatement();

        System.out.println("******** Closing Student Transactions ********");
    }
}
