public class Department {
    private Integer id;
    private String name;
    private String code;
    private Integer manager_id;
    private String description;
    private Integer status;
    private String location;
    private String phone;
    private String email;
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
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Integer getManager_id() {
        return manager_id;
    }
    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Department() {
    }
    public Department(Integer id, String name, String code, Integer manager_id, String description, Integer status,
            String location, String phone, String email) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.manager_id = manager_id;
        this.description = description;
        this.status = status;
        this.location = location;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", code=" + code + ", manager_id=" + manager_id
                + ", description=" + description + ", status=" + status + ", location=" + location + ", phone=" + phone
                + ", email=" + email + "]";
    }
    
}
