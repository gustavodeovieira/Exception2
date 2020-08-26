package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws DomainException{
		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter account data:");
			System.out.println("Number: ");
			int number = sc.nextInt();
			System.out.println("Holder: ");
			String holder = sc.next();
			sc.nextLine();
			System.out.println("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.println("Withdraw limit: ");
			double withDrawLimit = sc.nextDouble();

			Account acc = new Account(number, holder, balance, withDrawLimit);
			
			System.out.println();
			System.out.println("Enter amount for withdraw:");
			Double amount = sc.nextDouble();
			try {
				
				acc.withDraw(amount);
				System.out.println("New balance: " + String.format("%.2f",acc.getBalance()));
			
		} catch (DomainException e) {
			System.out.println("Withdraw error: "+ e.getMessage());
		}

		sc.close();
	}

}
