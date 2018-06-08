package sample.dao;
import sample.entities.UserPending;
import java.util.List;

public interface UserPendingDao {
	void insert(UserPending userp);
	UserPending selectById(int id);
	void delete(int id);
	List<UserPending> selectAll();
	int  checkId(int id);
}
