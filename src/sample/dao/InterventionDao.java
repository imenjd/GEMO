package sample.dao;
import sample.entities.Intervention;
public interface InterventionDao {
	void insert(Intervention intervention);
	void delete (int id);
	int selectByName(String a);
	void update (Intervention intervention , int id);
}
