public class User {
    private int studentID;
    private String studentName;
    private int studentAge;
    private int deptID;
    private String dept;
    private String studentClass;
    private String studentAddr;
    private String studentGender;

    // 构造函数、getter 和 setter 方法
    public User(int studentID, String studentName, int studentAge, int deptID, String dept, String studentClass, String studentAddr, String studentGender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.deptID = deptID;
        this.dept = dept;
        this.studentClass = studentClass;
        this.studentAddr = studentAddr;
        this.studentGender = studentGender;
    }

    // getter 和 setter 方法
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentAddr() {
        return studentAddr;
    }

    public void setStudentAddr(String studentAddr) {
        this.studentAddr = studentAddr;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    @Override
    public String toString() {
        return "User [studentID=" + studentID + ", studentName=" + studentName + ", studentAge=" + studentAge + ", deptID=" + deptID + ", dept=" + dept + ", studentClass=" + studentClass + ", studentAddr=" + studentAddr + ", studentGender=" + studentGender + "]";
    }
}