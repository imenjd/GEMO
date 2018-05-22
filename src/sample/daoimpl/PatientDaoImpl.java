package sample.daoimpl;
import java.util.*;
import java.sql.*;
import sample.util.*;
import sample.dao.PatientDao;
import sample.entities.Patient;

public class PatientDaoImpl implements PatientDao {
	@Override
	public void insert(Patient patient) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		
		try{
			connection= ConnectionConfiguration.getConnection();
			preparedStatement=connection.prepareStatement("INSERT INTO patient (first_name,last_name,birth_date) VALUES(?,?,?)");
			preparedStatement.setString(1,patient.getFirstName());
			preparedStatement.setString(2,patient.getLastName());
			preparedStatement.setString(3,patient.getBirthDate());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public List<Patient> select(String a) {
		List<Patient> patientss=new ArrayList<>();
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		try{
			connection= ConnectionConfiguration.getConnection();
			preparedStatement=connection.prepareStatement("SELECT * FROM patient (id,first_name,last_name,birth_date) VALUES(?,?,?,?)");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				Patient p=new Patient();
				p.setId(resultSet.getInt(1));
				p.setFirstName(resultSet.getString(2));
				p.setLastName(resultSet.getString(3));
				p.setBirthDate(resultSet.getString(4));
				
				patientss.add(p);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( connection != null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return patientss;
	}
	
	
	
	public List<Patient> selectAll() {
		
		
		
		List<Patient> pats = new ArrayList<Patient>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery( "SELECT  * FROM patient"  );
			
			while (resultSet.next()){
				Patient pat = new Patient();
				pat.setId(resultSet.getInt("id"));
				pat.setFirstName(resultSet.getString("first_name"));
				pat.setLastName(resultSet.getString("last_name"));
				pat.setBirthDate(resultSet.getString("birth_date"));
				
				pats.add(pat);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		return pats;
		
	}
	public boolean exist(int id) {
		Connection connection=null;
		connection=ConnectionConfiguration.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement=connection.prepareStatement("SELECT * FROM patient");
			
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int idd=0;
		try {
			while (resultSet.next()){
				idd=idd+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (id>idd){
			return false;
		}
		else {
			return true;
		}
		
	}
	public int searchLast(){
		Connection connection=null;
		connection=ConnectionConfiguration.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int value=0;
		try {
			preparedStatement=connection.prepareStatement("SELECT MAX(id) FROM patient");
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()){
				value=resultSet.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return value;
	}
	
	
}
