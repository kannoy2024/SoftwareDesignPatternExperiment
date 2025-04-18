import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Award {
    private String firstName;
    private String lastName;
    private String studNum;
    private String aFile;

    private ArrayList<StudentAwardModel> allAwards = new ArrayList<>();

    // Constructor
    public Award(String fname, String lname, String stuNum) {
        firstName = fname;
        lastName = lname;
        studNum = stuNum;
    }

    // Get basic student awards information from a text file that is passed in from the parameter
    public ArrayList<StudentAwardModel> getAllAwards(String file) {
        aFile = file;
        allAwards = new ArrayList<>(); // 修复：指定泛型类型
        try (BufferedReader reader = new BufferedReader(new FileReader(aFile))) { // 使用try-with-resources自动关闭资源
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() != 0) { // 去除空行
                    String[] arr = line.split("\\,", -1); // 通过逗号分割，-1确保保留空字段
                    if (arr.length >= 5) { // 防止数组越界
                        StudentAwardModel studentAwardModel = new StudentAwardModel(
                                arr[0].trim(), arr[1].trim(),
                                arr[2].trim(), arr[3].trim(),
                                arr[4].trim()
                        );
                        if (studentAwardModel.getStudFirstName().equals(firstName) &&
                            studentAwardModel.getStudLastName().equals(lastName) &&
                            studentAwardModel.getStudSerialNum().equals(studNum)) {
                            allAwards.add(studentAwardModel);
                        }
                    } else {
                        System.err.println("Invalid line format: " + line);
                    }
                }
            }
        } catch (FileNotFoundException exc) {
            System.err.println("File not found: " + aFile);
            exc.printStackTrace();
        } catch (IOException exc) {
            System.err.println("Error reading file: " + aFile);
            exc.printStackTrace();
        }
        return allAwards;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudNumber() {
        return studNum;
    }
}