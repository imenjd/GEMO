package sample.dao;
import sample.entities.User;
import java.util.List;

public interface UserDao {
	void insert(User user);
	void delete(int id);
	int selectByName(String u);
	User selectByUserName(String userName);
	List<User> selectAll();
	List<String> selectAllNames();
}
