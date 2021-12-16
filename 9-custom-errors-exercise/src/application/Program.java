package application;

import models.entities.Account;
import models.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            Integer number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            Double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            Double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);
            System.out.println(account);

            System.out.print("\nEnter amount for withdraw: ");
            Double withdrawAmount = sc.nextDouble();
            account.withdraw(withdrawAmount);
            System.out.println(account);
        } catch (BusinessException e) {
            System.out.println("Withdraw Error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error: " + e);
        }
        sc.close();
    }
}
