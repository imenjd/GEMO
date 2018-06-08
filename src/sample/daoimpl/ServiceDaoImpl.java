package sample.daoimpl;
import java.util.*;
import sample.dao.ServiceDao;
import sample.entities.Service;
import sample.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;

public class ServiceDaoImpl implements ServiceDao {
	public ServiceDaoImpl(){}
	@Override
	public void insert(Service service) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		

		
		
			try {
				connection = ConnectionConfiguration.getConnection();
				preparedStatement = connection.prepareStatement("INSERT INTO service (name) VALUES(?)");
				preparedStatement.setString(1, service.getName());
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
	
	@Override
	public int selectByName(String service) {
		
		int value=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement( "SELECT  id FROM  service WHERE  name=" + "\"" + service + "\" " );
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
	

	
	
	
	@Override
	public List<Service> selectAll() {
		
		//create array list of service object
		
		List<Service> services = new ArrayList<Service>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  * FROM service");
			resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				Service service = new Service();
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
		
		
		
		return services;
		
	}
	
}
