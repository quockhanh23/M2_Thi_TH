package file;

import models.Directory;
import services.DirectoryManagement;

import java.io.*;
import java.util.List;

public class FileDirectory {

    public static void writeFile(String patch, List<Directory> list) throws IOException {
        FileWriter fileWriter = new FileWriter(patch);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Id,Name,Number phone,Email,SocialNetwork";
        for (Directory directory : list) {
            str += "\n";
            str += directory.getNumberPhone() + ",";
            str += directory.getName() + ",";
            str += directory.getId() + ",";
            str += directory.getEmail() + ",";
            str += directory.getSocialNetwork();
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Directory> read(String patch) throws IOException {
        DirectoryManagement directoryManagement = new DirectoryManagement();
        FileReader fileReader = new FileReader(patch);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine()) != null) {
            String[] arr = line.split(",");
            int id = Integer.parseInt(arr[0]);
            String name = arr[1];
            String number = arr[2];
            String email = arr[3];
            String socialNetwork = arr[4];
            directoryManagement.add(new Directory(id, name, number, email, socialNetwork));
            bufferedReader.close();
            fileReader.close();
            directoryManagement.print();
        }
        return null;
    }
}
