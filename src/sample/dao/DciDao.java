package sample.dao;
import sample.entities.Dci;
import java.util.List;

public interface DciDao {
	
	void insert(Dci dci);
	void update(Dci dci , int id);
	void delete(int id);
	int selectByName(String name);
	Dci selectById ( int id);
	
	List<Dci> selectAll();
	int  checkId(int id);
}
