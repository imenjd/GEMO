package sample.dao;
import sample.entities.Service;
import java.util.List;

public interface ServiceDao {
	void insert(Service service);
	int selectByName(String name);
	List<Service> selectNames()
	List<Service> selectAll();
}
