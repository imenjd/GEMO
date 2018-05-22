package sample.dao;
import sample.entities.Problem;
public interface ProblemDao {
	void insert(Problem problem);
	void delete (int id);
	
	void update (Problem problem , int id);
}
