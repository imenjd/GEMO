package sample.dao;
import sample.entities.UserPending;
import java.util.List;

public interface UserPendingDao {
	void insert(UserPending userp);
	
	void delete(int id);
	
	
	List<UserPending> selectAll();
	int  checkId(int id);
}
