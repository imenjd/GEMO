package sample.dao;
import sample.entities.Problem;
public interface ProblemDao {
	void insert(Problem problem);
	int selectByName(String a);
	List<Problem> selectAll()
	
}
