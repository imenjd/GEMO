package sample.daoimpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.entities.Search;
import sample.dao.SearchDao;
import sample.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.entities.Patient;
public class SearchDaoImpl implements SearchDao {
	ObservableList<String> Problem_list = FXCollections.observableArrayList();
	ObservableList<String> Medicament_list = FXCollections.observableArrayList();
	ObservableList<String> Intervention_list = FXCollections.observableArrayList();
	ObservableList<String> data;

	
	@Override
	public ObservableList fillProblemlist() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT name FROM problem ");
			rs = statement.executeQuery();
			while (rs.next()) {
				
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					Problem_list.add(rs.getString(i));
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Problem_list;
		
	}
	
	@Override
	public ObservableList fillMedList() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT name FROM med ");
			rs = statement.executeQuery();
			while (rs.next()) {
				
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					Medicament_list.add(rs.getString(i));
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Medicament_list;
		
	}
	
	@Override
	public ObservableList fillInterventionList() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT name FROM intervention ");
			rs = statement.executeQuery();
			while (rs.next()) {
				
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					Intervention_list.add(rs.getString(i));
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Intervention_list;
		
	}
	
	@Override
	public List<Search> SearchByProblem(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  visit.id, visit.id_patient," +
					"patient.first_name, patient.last_name," +
					"service.name FROM problem " +
					"JOIN visit_dci ON visit_dci.id_problem=problem.id " +
					"JOIN visit ON visit.id=visit_dci.id_visit " +
					"JOIN visit_inter ON visit_inter.id_visit=visit.id " +
					
					"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
					"JOIN patient ON patient.id=visit.id_patient " +
					"JOIN user ON user.id=visit.id_user " +
					"JOIN service ON service.id=visit.id_service " +
					"JOIN DCI ON DCI.id=visit_dci.id_dci " +
					"JOIN med_dci ON med_dci.id_dci=DCI.id " +
					"JOIN med ON med.id=med_dci.id_med " +
					
					" WHERE problem.name=" + "\"" + valToSearch + "\" ");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByIntervention(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  visit.id, visit.id_patient," +
					" patient.first_name,patient.last_name," +
					"service.name FROM intervention " +
					"JOIN visit_inter ON visit_inter.id_intervention=intervention.id " +
					"JOIN visit ON visit.id=visit_inter.id_visit " +
					"JOIN visit_dci ON visit_dci.id_visit=visit.id " +
					
					"JOIN problem ON visit_DCI.id_problem=problem.id " +
					"JOIN patient ON patient.id=visit.id_patient " +
					"JOIN user ON user.id=visit.id_user " +
					"JOIN service ON service.id=visit.id_service " +
					"JOIN DCI ON DCI.id=visit_dci.id_dci " +
					"JOIN med_dci ON med_dci.id_dci=DCI.id " +
					"JOIN med ON med.id=med_dci.id_med " +
					
					" WHERE intervention.name=" +
					
					"\"" + valToSearch + "\" ");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByMed(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  visit.id, visit.id_patient," +
					" patient.first_name, patient.last_name," +
					"service.name FROM med " +
					"JOIN med_dci ON med_dci.id_med=med.id " +
					"JOIN DCI ON DCI.id=med_dci.id_dci " +
					"JOIN visit_dci ON visit_dci.id_dci=DCI.id " +
					"JOIN visit ON visit.id=visit_dci.id_visit " +
					"JOIN problem ON visit_dci.id_problem=problem.id " +
					"JOIN patient ON patient.id=visit.id_patient " +
					"JOIN user ON user.id=visit.id_user " +
					"JOIN service ON service.id=visit.id_service " +
					"JOIN visit_inter ON visit_inter.id_visit=visit_dci.id_visit " +
					
					"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
					
					" WHERE med.name="+
					
					"\"" + valToSearch + "\" ");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByContext(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT visit.id, visit.id_patient," +
							" patient.first_name, patient.last_name," +
							"service.name FROM visit_inter " +
							"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
							"JOIN visit ON visit.id=visit_inter.id_visit " +
							"JOIN visit_dci ON visit_dci.id_visit=visit.id " +
							"JOIN DCI ON DCI.id=visit_dci.id_dci " +
							"JOIN med_dci ON med_dci.id_dci=DCI.id " +
							"JOIN problem ON visit_dci.id_problem=problem.id " +
							"JOIN patient ON patient.id=visit.id_patient " +
							"JOIN user ON user.id=visit.id_user " +
							"JOIN service ON service.id=visit.id_service " +
							"JOIN med ON med_dci.id_med=med.id"+
							
							
							" WHERE LOWER(visit_inter.context) LIKE '%"+ valToSearch +"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByDCI(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT  visit.id, visit.id_patient," +
							" patient.first_name, patient.last_name," +
							"service.name FROM DCI " +
							"JOIN visit_dci ON visit_dci.id_dci=DCI.id " +
							"JOIN med_dci ON med_dci.id_dci=DCI.id " +
							"JOIN visit ON visit.id=visit_dci.id_visit " +
							"JOIN patient ON patient.id=visit.id_patient " +
							"JOIN user ON user.id=visit.id_user " +
							"JOIN service ON service.id=visit.id_service " +
							"JOIN visit_inter ON visit.id=visit_inter.id_visit " +
							"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
							"JOIN problem ON visit_dci.id_problem=problem.id " +
							"JOIN med ON med_dci.id_med=med.id"+
							
							
							
							" WHERE LOWER(DCI.name) LIKE '%"+valToSearch+"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByComment(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT  visit.id, visit.id_patient," +
							"patient.first_name, patient.last_name," +
							"service.name FROM visit " +
							"JOIN patient ON patient.id=visit.id_patient " +
							"JOIN user ON user.id=visit.id_user " +
							"JOIN service ON service.id=visit.id_service " +
							"JOIN visit_inter ON visit.id=visit_inter.id_visit " +
							"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
							"JOIN visit_dci ON visit_dci.id_visit=visit.id " +
							"JOIN DCI ON DCI.id=visit_dci.id_dci " +
							"JOIN med_dci ON med_dci.id_dci=DCI.id " +
							"JOIN problem ON visit_dci.id_problem=problem.id " +
							"JOIN med ON med_dci.id_med=med.id"+
							
							
							" WHERE LOWER(visit.comment) LIKE '%"+valToSearch+"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByDate(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT  visit.id, visit.id_patient," +
							" patient.first_name, patient.last_name," +
							"service.name FROM visit " +
							"JOIN patient ON patient.id=visit.id_patient " +
							"JOIN user ON user.id=visit.id_user " +
							"JOIN service ON service.id=visit.id_service " +
							"JOIN visit_inter ON visit.id=visit_inter.id_visit " +
							"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
							"JOIN visit_dci ON visit_dci.id_visit=visit.id " +
							"JOIN DCI ON DCI.id=visit_dci.id_dci " +
							"JOIN med_dci ON med_dci.id_dci=DCI.id " +
							"JOIN problem ON visit_dci.id_problem=problem.id " +
							"JOIN med ON med_dci.id_med=med.id"+
							
							
							" WHERE visit.date LIKE '%"+valToSearch+"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByPatient(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT  visit.id, visit.id_patient," +
							" patient.first_name, patient.last_name," +
							"service.name FROM patient " +
							"JOIN visit ON patient.id=visit.id_patient " +
							"JOIN user ON user.id=visit.id_user " +
							"JOIN service ON service.id=visit.id_service " +
							"JOIN visit_inter ON visit.id=visit_inter.id_visit " +
							"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
							"JOIN visit_dci ON visit_dci.id_visit=visit.id " +
							"JOIN DCI ON DCI.id=visit_dci.id_dci " +
							"JOIN med_dci ON med_dci.id_dci=DCI.id " +
							"JOIN problem ON visit_dci.id_problem=problem.id " +
							"JOIN med ON med_dci.id_med=med.id"+
							
							
							" WHERE LOWER(patient.first_name)  LIKE '%"+valToSearch+"%' OR LOWER(patient.last_name) LIKE '%"+valToSearch+"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	public List<Patient> SearchByPatientName(String valToSearch) {
		List<Patient> searches=new ArrayList<Patient>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT * FROM patient " +
							" WHERE LOWER(patient.first_name)  LIKE '%"+valToSearch+"%' OR LOWER(patient.last_name) LIKE '%"+valToSearch+"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Patient p=new Patient();
				p.setId(rs.getInt(1));
				p.setFirstName(rs.getString(2));
				p.setLastName(rs.getString(3));
				p.setBirthDate(rs.getString(4));
				
				searches.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
	
	@Override
	public List<Search> SearchByService(String valToSearch) {
		List<Search> searches=new ArrayList<Search>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			data = FXCollections.observableArrayList();
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement(
					
					"SELECT  visit.id, visit.id_patient" +
							" patient.first_name, patient.last_name," +
							"service.name FROM service " +
							"JOIN visit ON visit.id_service=service.id " +
							"JOIN patient ON patient.id=visit.id_patient " +
							"JOIN user ON user.id=visit.id_user " +
							"JOIN visit_inter ON visit.id=visit_inter.id_visit " +
							"JOIN intervention ON intervention.id=visit_inter.id_intervention " +
							"JOIN visit_dci ON visit_dci.id_visit=visit.id " +
							"JOIN DCI ON DCI.id=visit_dci.id_dci " +
							"JOIN med_dci ON med_dci.id_dci=DCI.id " +
							"JOIN problem ON visit_dci.id_problem=problem.id " +
							"JOIN med ON med_dci.id_med=med.id"+
							
							
							" WHERE LOWER(service.name) LIKE '%"+valToSearch+"%'");
			rs = statement.executeQuery();
			
			
			while (rs.next()) {
				Search s=new Search();
				s.setRef(rs.getString(1));
				s.setIdpatient(rs.getString(2));
				s.setFirstname(rs.getString(3));
				s.setLastname(rs.getString(4));
				s.setService(rs.getString(5));
				searches.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searches;
	}
}
