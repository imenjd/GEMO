package sample.daoimpl;
import java.util.*;

import sample.dao.InterventionDao;
import sample.entities.Intervention;
import sample.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InterventionDaoImpl implements InterventionDao {
	public InterventionDaoImpl(){}
	
	}
@Override
	public void insert(Intervention intervention) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		

		
		
		try {
			connection = ConnectionConfiguration.getConnection();
			
			preparedStatement = connection.prepareStatement("INSERT INTO intervention (name) VALUES(?)");
			preparedStatement.setString(1, intervention.getName());
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
			
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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
	
	}
	public int selectByName(String a) {
		
		int value=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement( "SELECT  id FROM  intervention WHERE  name= " + "\"" + a + "\" ");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				value=resultSet.getInt(1);
				
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return value;
		
		
		
		
	}
	public List<Intervention> selectAll() {
		
		//create array list of service object
		
		List<Intervention> services = new ArrayList<Intervention>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  * FROM intervention" );
			resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				Intervention service = new Intervention();
				service.setId(resultSet.getInt("id"));
				service.setName(resultSet.getString("name"));
				services.add(service);
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
					resultSet.close();
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
		
		
		
		return services;
		
	}
}
