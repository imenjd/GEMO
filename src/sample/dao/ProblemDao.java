package sample.dao;
import sample.entities.Problem;
import java.util.List;
public interface ProblemDao {
	void insert(Problem problem);
	int selectByName(String a);
	List<Problem> selectAll();
	
}
