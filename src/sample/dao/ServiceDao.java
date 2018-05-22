package sample.dao;
import sample.entities.Service;
import java.util.List;

public interface ServiceDao {
	void insert(Service service);
	void update(Service service , int id);
	void delete(int id);
	int selectByName(String name);
	Service selectById ( int id);
	List<String> selectAllNames();
	List<Service> selectAll();
	int  checkId(int id);
}
