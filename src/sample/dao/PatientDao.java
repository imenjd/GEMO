package sample.dao;
import sample.entities.Patient;
public interface PatientDao {
	void insert(Patient patient);
	List<Patient> select(String a);
	List<Patient> selectAll();
	int searchLast()
	
}
