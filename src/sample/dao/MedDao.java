package sample.dao;
import sample.entities.Med;
import java.util.List;

public interface MedDao {
	void insert(Med med);
	void update(Med med , int id);
	void delete(int id);
	int selectByName(String name);
	Med selectById ( int id);
	
	List<Med> selectAll();
	int  checkId(int id);
}
