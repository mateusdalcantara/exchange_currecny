package br.com.example.principal;

import br.com.example.entites.Data;
import br.com.example.entites.ApiHandler;
import br.com.example.entites.Messager;
import java.util.Locale;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Data data = new Data();
        Messager messager = new Messager();
        ApiHandler api = new ApiHandler();

        int option = 0;
        boolean invalidEntry;
        double moneyAmount = 0;

        while (option != 9) {

            do {
                System.out.println("Please enter the amount of money to convert.");
                try {
                    moneyAmount = sc.nextDouble();
                    invalidEntry = true;
                } catch (InputMismatchException | NumberFormatException e) {
                    sc.next();
                    invalidEntry = false;
                }
            } while (!invalidEntry);

            try {
                System.out.println(messager.menuOptions());
                System.out.println("Choose the operation");

                option = sc.nextInt();

                if (option < 1 || option > 9) {
                    System.out.println("You have chosen an invalid option. Please enter a number between 1 and 9");
                }

            } catch (InputMismatchException e) {
                System.out.println("You have entered an invalid option. Please enter a number between 1 and 9.");
                sc.next();

            }

            switch (option) {

                case 1:
                    api.currency("BRL", "USD", moneyAmount);
                    break;
                case 2:
                    api.currency("USD", "BRL", moneyAmount);
                    break;
                case 3:
                    api.currency("BRL", "JPY", moneyAmount);
                    break;
                case 4:
                    api.currency("JPY", "BRL", moneyAmount);
                    break;
                case 5:
                    api.currency("BRL", "EUR", moneyAmount);
                    break;
                case 6:
                    api.currency("EUR", "BRL", moneyAmount);
                    break;
                case 7:
                    api.currency("BRL", "GBP", moneyAmount);
                    break;
                case 8:
                    api.currency("GBP", "BRL", moneyAmount);
                    break;
                default:
                    System.out.println("Thank you, and come back soon!");
                    break;
            }
        }
    }
}
