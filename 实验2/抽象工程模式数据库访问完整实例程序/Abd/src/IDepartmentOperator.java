public interface IDepartmentOperator {
    public Integer insert(Department department);
    public Integer delete(Department department);
    public Integer update(Department department);
    public Department getDepartmentByID(String sid);
}
