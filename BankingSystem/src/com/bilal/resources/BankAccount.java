package com.bilal.resources;

public interface BankAccount
{
    int    getBalance() ;           // returns the current balance

    int    getStudentAccountNumber() ;     // returns the Account number

    String getAccountHolder() ;     // returns the Account holder


    void deposit(Transaction trans) ;     // perform a deposit transaction on the bank account

    void withdrawal(Transaction trans) ;  // perform a withdrawal transaction on the bank account


    boolean isOverdrawn() ;         // returns true if overdrawn; false otherwise

    void printBankStatement() ;         // prints out the transactions performed so far
}