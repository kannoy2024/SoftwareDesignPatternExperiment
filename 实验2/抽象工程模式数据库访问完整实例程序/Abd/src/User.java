public class User {
    private Integer id;
    private String name;
    private Integer sage;
    private Integer dept_id;
    private String dept;
    private String sclass;
    private String saddr;
    private String sgender;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSage() {
        return sage;
    }
    public void setSage(Integer sage) {
        this.sage = sage;
    }
    public Integer getDept_id() {
        return dept_id;
    }
    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }
    public String getDept() {
        return dept;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public String getSclass() {
        return sclass;
    }
    public void setSclass(String sclass) {
        this.sclass = sclass;
    }
    public String getSaddr() {
        return saddr;
    }
    public void setSaddr(String saddr) {
        this.saddr = saddr;
    }
    public String getSgender() {
        return sgender;
    }
    public void setSgender(String sgender) {
        this.sgender = sgender;
    }
    public User() {
    }
    public User(Integer id, String name, Integer sage, Integer dept_id, String dept, String sclass, String saddr,
            String sgender) {
        this.id = id;
        this.name = name;
        this.sage = sage;
        this.dept_id = dept_id;
        this.dept = dept;
        this.sclass = sclass;
        this.saddr = saddr;
        this.sgender = sgender;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sage=" + sage + ", dept_id=" + dept_id + ", dept=" + dept
                + ", sclass=" + sclass + ", saddr=" + saddr + ", sgender=" + sgender + "]";
    }
    
}
