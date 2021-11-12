import file.FileDirectory;
import models.Directory;
import services.DirectoryManagement;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DirectoryManagement directoryManagement = new DirectoryManagement();
        directoryManagement.add(new Directory(1, "khanh1", "0353413219", "khanh@gmail.com", "facebook"));
        directoryManagement.add(new Directory(2, "khanh2", "0353413333", "khanh@gmail.com", "facebook"));
        directoryManagement.add(new Directory(3, "khanh3", "0353414444", "khanh@gmail.com", "facebook"));
        directoryManagement.add(new Directory(4, "khanh4", "0353415555", "khanh@gmail.com", "facebook"));
        directoryManagement.add(new Directory(5, "khanh5", "0353416666", "khanh@gmail.com", "facebook"));
        int choice = -1;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                Main.menu();
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input. ");
            }
            switch (choice) {
                case 1:
                    directoryManagement.print();
                    break;
                case 2:
                    try {
                        directoryManagement.add(directoryManagement.create());
                    } catch (Exception e) {
                        System.out.println("Wrong input. ");
                    }
                    break;
                case 3:
                    try {
                        int id = scanner.nextInt();
                        directoryManagement.find2(id);
                    } catch (Exception e) {
                        System.out.println("Wrong input. ");
                    }
                    break;
                case 4:
                    try {
                        int delete = scanner.nextInt();
                        boolean check = directoryManagement.check(delete);
                        if (check) {
                            directoryManagement.delete(delete);
                        } else {
                            System.out.println("Wrong id. ");
                        }
                    } catch (Exception e) {
                        System.out.println("Wrong input. ");
                    }
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Enter number phone. ");
                    String number = scanner.nextLine();
                    directoryManagement.findByNumber(number);
                    break;
                case 6:
                    try {
                        FileDirectory.writeFile("demo.csv", directoryManagement.getDirectoryList());
                        System.out.println("Success. ");
                    } catch (Exception e) {
                        System.out.println("Wrong. ");
                    }
                    break;
                case 7:
                    try {
                        FileDirectory.read("demo.csv");
                    } catch (Exception e) {
                        System.out.println("Wrong. ");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option does not exist. ");
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println("Directory management program. ");
        System.out.println("Choice number. ");
        System.out.println("1. Print the list directory. ");
        System.out.println("2. Creat an directory. ");
        System.out.println("3. Find directory by id. ");
        System.out.println("4. Delete by id. ");
        System.out.println("5. Find directory by number phone. ");
        System.out.println("6. Write file. ");
        System.out.println("7. Read file. ");
        System.out.println("0. End program. ");
    }
}
