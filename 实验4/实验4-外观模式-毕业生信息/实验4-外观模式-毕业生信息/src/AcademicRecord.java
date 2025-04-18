import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AcademicRecord {
    private String firstName;
    private String lastName;
    private String studNum;
    private String aFile;

    // 使用泛型指定集合类型
    private ArrayList<StudentAcademicModel> allScores = new ArrayList<>();

    // 构造方法
    public AcademicRecord(String firstName, String lastName, String studNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studNum = studNum;
    }

    // 从文件中获取所有成绩信息
    public ArrayList<StudentAcademicModel> getAllScores(String file) {
        aFile = file;
        try (BufferedReader reader = new BufferedReader(new FileReader(aFile))) { // 使用try-with-resources自动关闭资源
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().length() > 0) { // 检查非空行
                    String[] arr = line.split(",");
                    if (arr.length == 6) { // 确保数组长度正确
                        StudentAcademicModel studentAcademicModel = new StudentAcademicModel(
                            arr[0].trim(), arr[1].trim(), arr[2].trim(),
                            arr[3].trim(), arr[4].trim(), arr[5].trim()
                        );
                        if (studentAcademicModel.getStudFirstName().equals(firstName) &&
                            studentAcademicModel.getStudLastName().equals(lastName) &&
                            studentAcademicModel.getStudSerialNum().equals(studNum)) {
                            allScores.add(studentAcademicModel);
                        }
                    } else {
                        System.err.println("Invalid line format: " + line);
                    }
                }
            }
        } catch (FileNotFoundException exc) {
            System.err.println("File not found: " + aFile);
            exc.printStackTrace();
            System.exit(1);
        } catch (IOException exc) {
            System.err.println("Error reading file: " + aFile);
            exc.printStackTrace();
            System.exit(1);
        }
        return allScores;
    }

    // Getter方法
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