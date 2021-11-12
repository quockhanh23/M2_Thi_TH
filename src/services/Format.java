package services;

import models.Regex;

import java.util.Scanner;

public class Format {
    public static String inputPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        String clientPhoneNumber;
        boolean invalidPhoneNUmber;
        do {
            System.out.print("Enter client phone number: ");
            clientPhoneNumber = scanner.nextLine();
            invalidPhoneNUmber = !Regex.validate(clientPhoneNumber, Regex.PHONE_NUMBER_REGEX);
            if (invalidPhoneNUmber) System.out.println("Wrong format of phone number. ");
        } while (invalidPhoneNUmber);
        return clientPhoneNumber;
    }
    public static String inputEmail() {
        Scanner scanner = new Scanner(System.in);
        String clientEmail;
        boolean invalidEmail;
        while (true) {
            System.out.print("Enter client email: ");
            clientEmail = scanner.nextLine();
            invalidEmail = !Regex.validate(clientEmail, Regex.LICENSE_REGEX);
            if (invalidEmail) {
                System.out.println("Wrong format of email. ");
            } else {
                return clientEmail;
            }
        }
    }
}
