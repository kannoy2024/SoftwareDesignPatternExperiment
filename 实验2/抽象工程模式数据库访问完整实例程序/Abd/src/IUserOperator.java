public interface IUserOperator {
    public void insert(User user);
    public void delete(User user);
    public void update(User user);  // 修正了之前的拼写错误 udpate -> update
    public User getUserByID(Integer id);  // 参数类型从 String 改为 Integer
}