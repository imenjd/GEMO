package sample.dao;
import sample.entities.Intervention;
import java.util.List;
public interface InterventionDao {
	void insert(Intervention intervention);
	int selectByName(String a);
	List<Intervention> selectAll();
	
}
