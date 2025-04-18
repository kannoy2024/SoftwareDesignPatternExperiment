//=========================================
// This class represents basic infomation of a student,
// including student's
//      name,
//      birth date
//      serial number
// With the getStudentBasicInfo() method, we can retrieve
// all the basic information of a student from the
// STUDENT_BASIC_INFO file, including
//      social security number,
//      major
//      degree
//========================================

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class StudentBasicInfo {
	private String name;
	private String birthDate;
	private String serialNum;
	private ArrayList<StudentBasicInfoModel> student;
	final static String STUDENT_BASIC_INFO = "F:\\Java2025\\SoftwareDesignPatternExperiment\\实验4\\实验4-外观模式-毕业生信息\\实验4-外观模式-毕业生信息\\StudentBasicInfo.txt";

	// Constructor
	public StudentBasicInfo(String name, String birthDate, String serialNum) {
		this.name = name;
		this.birthDate = birthDate;
		this.serialNum = serialNum;
	}

	// Check if the student name is in the student list or not
	public static boolean isExistingStudentName(String name) {
		boolean flag = false;
		// ArrayList<StudentBasicInfoModel> student = new ArrayList();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STUDENT_BASIC_INFO));
			String line = reader.readLine();
			while (line != null) {
				if (line.length() != 0) {
					String[] arr = line.split("\\,");
					if (arr[0].trim().equals(name))
						flag = true;
					break;
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException exc) {
			// exc.printStackTrace();
			// System.exit(1);
			System.err.println("Error: File 'StudentBasicInfo.txt' not found. Please check the file path.");
			// return student; // 返回空列表
		} catch (IOException exc) {
			exc.printStackTrace();
			System.exit(1);
		}
		return flag;
	}

	// Get basic student information from STUDENT_BASIC_INFO
	// and return it with type ArrayList<StudentBasicInfoModel>
	public ArrayList<StudentBasicInfoModel> getStudentBasicInfo() {
		student = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(STUDENT_BASIC_INFO));
			String line = reader.readLine();
			while (line != null) {
				if (line.length() != 0) {
					String[] arr = line.split("\\,");
					StudentBasicInfoModel studentBasicInfoModel = new StudentBasicInfoModel(arr[0].trim(),
							arr[1].trim(),
							arr[2].trim(), arr[3].trim(),
							arr[4].trim(), arr[5].trim());
					if (studentBasicInfoModel.getName().equals(name)
							&& studentBasicInfoModel.getSerialNum().equals(serialNum))
						student.add(studentBasicInfoModel);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException exc) {
			exc.printStackTrace();
			System.exit(1);
		} catch (IOException exc) {
			exc.printStackTrace();
			System.exit(1);
		}
		return student;
	}

	public String getName() {
		return name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getSerialNum() {
		return serialNum;
	}
}
