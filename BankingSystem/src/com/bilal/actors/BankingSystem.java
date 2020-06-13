package com.bilal.actors;

public class BankingSystem {
    Student student;
    Grandmother grandmother;
    LoanCompany loanCompany;
    University university;

    CurrentAccount studentAccount;

    ThreadGroup people;
    ThreadGroup organizations;

    public BankingSystem() {
        this.people = new ThreadGroup("Peoples");
        this.organizations = new ThreadGroup("Organizations");
        this.studentAccount = new CurrentAccount("Bilal", 997, 0);

        this.student = new Student(studentAccount, studentAccount.getAccountHolder(), people);
        this.grandmother = new Grandmother(studentAccount, "Bilal's grandmother", people);

        this.loanCompany = new LoanCompany(studentAccount, "Loans\"B\"Us", organizations);
        this.university = new University(studentAccount, "UOW", organizations);
    }

    public static void main (String[] args) {
    ThreadGroup organizations;
        BankingSystem studentBankingSystem = new BankingSystem();

        studentBankingSystem.student.start();
        studentBankingSystem.grandmother.start();
        studentBankingSystem.loanCompany.start();
        studentBankingSystem.university.start();

        try {
            studentBankingSystem.student.join();
            studentBankingSystem.grandmother.join();
            studentBankingSystem.loanCompany.join();
            studentBankingSystem.university.join();
        } catch (InterruptedException e) { }

        // Printing out final statement for the bank account
        studentBankingSystem.studentAccount.printBankStatement();
    }
}
