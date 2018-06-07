package sample.dao;
import sample.entities.Dci;
import java.util.List;

public interface DciDao {
	
	void insert(Dci dci);
	int selectByName(String name);
	List<Dci> selectAll();
	
}
