public interface IUserOperator {
    public void insert(User user);
    public void delete(User user);
    public void update(User user); 
    public User getUserByID(Integer id); 
}