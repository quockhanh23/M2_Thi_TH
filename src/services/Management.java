package services;

public interface Management <T> {
    void print();
    void add(T t);
    void edit(int id, T t);
    void delete(int id);
    int find(int id);
}
