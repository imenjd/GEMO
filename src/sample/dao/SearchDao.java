package sample.dao;

import javafx.collections.ObservableList;
import java.util.List;


public interface SearchDao {
	ObservableList<String> fillProblemlist();
	ObservableList<String> fillMedList();
	ObservableList<String>  fillInterventionList();
	List SearchByProblem(String valToSearch);
	List SearchByIntervention(String valToSearch);
	List SearchByMed(String valToSearch);
	List SearchByContext(String valToSearch);
	List SearchByDCI(String valToSearch);
	List SearchByComment(String valToSearch);
	List SearchByDate(String valToSearch);
	List SearchByPatient(String valToSearch);
	List SearchByService(String valToSearch);
}
