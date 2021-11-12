package models;

import javax.crypto.spec.PSource;

public class Directory {
    private int id;
    private String name;
    private String numberPhone;
    private String email;
    private String socialNetwork;

    public Directory(int id, String name, String numberPhone, String email, String socialNetwork) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
        this.socialNetwork = socialNetwork;
    }

    public Directory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-20s%-20s%-5s",
                getId(), getName(), getNumberPhone(), getEmail(), getSocialNetwork());
    }
}
