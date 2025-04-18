import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Tuition {
    private String firstName;
    private String lastName;
    private String studNum;
    private final String STUDENT_TUITION_FILE = "F:\\Java2025\\SoftwareDesignPatternExperiment\\实验4\\实验4-外观模式-毕业生信息\\实验4-外观模式-毕业生信息\\Tuition.txt";

    // 声明 studentTuitions 变量
    private ArrayList<TuitionModel> studentTuitions = new ArrayList<>();
    private ArrayList<String> studentTuition = new ArrayList<>();

    // constructor
    public Tuition(String fname, String lname, String stuNum) {
        firstName = fname;
        lastName = lname;
        this.studNum = stuNum;
    }

    // 获取学生信息并封装为 TuitionModel 对象
	public ArrayList<TuitionModel> getStudentInfoByModel() {
		studentTuitions.clear(); // 清空列表以避免重复添加
		try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_TUITION_FILE))) {
			String line;
			while ((line = reader.readLine()) != null) { // 修正每次循环读取下一行
				if (line.trim().isEmpty()) continue; // 跳过空行
				String[] arr = line.split(","); // 使用正确的分隔符
				if (arr.length >= 5 && arr[0].trim().equals(firstName) 
						&& arr[1].trim().equals(lastName) 
						&& arr[2].trim().equals(studNum)) {
					TuitionModel tuitionModel = new TuitionModel(
							arr[0].trim(), arr[1].trim(), arr[2].trim(),
							arr[3].trim(), arr[4].trim());
					studentTuitions.add(tuitionModel);
				}
			}
		} catch (FileNotFoundException exc) {
			System.err.println("文件未找到: " + exc.getMessage());
			System.exit(1);
		} catch (IOException exc) {
			System.err.println("IO 异常: " + exc.getMessage());
			System.exit(1);
		}
		return studentTuitions;
	}

    // 获取学生的学费信息（原始字符串形式）
    public ArrayList<String> getStudentTuitionInfo() {
        studentTuition.clear(); // 清空列表以避免重复添加
        try (BufferedReader reader = new BufferedReader(new FileReader(STUDENT_TUITION_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // 跳过空行
                String[] arr = line.split(",");
                if (arr.length >= 3 && arr[0].trim().equals(firstName) 
                        && arr[1].trim().equals(lastName) 
                        && arr[2].trim().equals(studNum)) {
							line = line.replace(",", " ");
                    studentTuition.add(line);
                }
            }
        } catch (FileNotFoundException exc) {
            System.err.println("文件未找到: " + exc.getMessage());
            System.exit(1);
        } catch (IOException exc) {
            System.err.println("IO 异常: " + exc.getMessage());
            System.exit(1);
        }
        return studentTuition;
    }

    // Getter 方法
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