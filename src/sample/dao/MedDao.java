package sample.dao;
import sample.entities.Med;
import java.util.List;

public interface MedDao {
	void insert(Med med);
	int selectByName(String name);
	List<Med> selectAll();
	
}
