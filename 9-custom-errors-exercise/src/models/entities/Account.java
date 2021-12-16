package models.entities;

import models.exceptions.BusinessException;

public class Account {
    Integer number;
    String holder;
    Double balance;
    Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        validateWithdrawOrError(amount);
        balance -= amount;
    }

    public void validateWithdrawOrError(Double amount) {
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("The inputted amount exceeds withdraw limit.");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Not enough balance.");
        }
    }

    @Override
    public String toString() {
        return "\nAccount data" +
                "\nNumber = " + number +
                " | Holder = '" + holder + '\'' +
                " | Balance = " + String.format("%.2f", balance) +
                " | WithdrawLimit = " + String.format("%.2f", withdrawLimit);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
