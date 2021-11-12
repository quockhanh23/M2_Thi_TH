package services;

import models.Directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoryManagement implements Management<Directory> {
    private List<Directory> directoryList = new ArrayList<>();

    public DirectoryManagement(List<Directory> directoryList) {
        this.directoryList = directoryList;
    }

    public DirectoryManagement() {
        directoryList = new ArrayList<>();
    }

    public List<Directory> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(List<Directory> directoryList) {
        this.directoryList = directoryList;
    }

    @Override
    public void print() {
        System.out.println(String.format("%-10s%-15s%-20s%-20s%-5s","Id","Name","Phone","Email","SocialNetwork"));
        for (int i = 0; i < directoryList.size(); i++) {
            System.out.println(directoryList.get(i));
        }
    }

    @Override
    public void add(Directory directory) {
        directoryList.add(directory);

    }

    @Override
    public void edit(int id, Directory directory) {
        int edit = find(id);
        directoryList.set(edit, directory);
    }

    @Override
    public void delete(int id) {
        directoryList.remove(id);

    }

    @Override
    public int find(int id) {
        for (int i = 0; i < directoryList.size(); i++) {
            if (directoryList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void findByNumber(String number) {
        for (int i = 0; i < directoryList.size(); i++) {
            if (directoryList.get(i).getNumberPhone().equals(number)) {
                System.out.println(directoryList.get(i));
            }
        }
    }

    public void find2(int id) {
        for (int i = 0; i < directoryList.size(); i++) {
            if (directoryList.get(i).getId() == id) {
                System.out.println(directoryList.get(i));
            }
        }
    }

    public boolean check(int id) {
        if (find(id) == id) {
            return true;
        }
        return false;
    }

    public Directory create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name. ");
        String name = scanner.nextLine();
        System.out.println("Enter number phone. ");
        String numberPhone = scanner.nextLine();
        System.out.println("Enter email. ");
        String email = scanner.nextLine();
        System.out.println("Enter social network. ");
        String socialNetwork = scanner.nextLine();
        System.out.println("Enter id. ");
        int id = scanner.nextInt();
        return new Directory(id, name, numberPhone, email, socialNetwork);
    }
}
