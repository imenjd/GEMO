package sample.daoimpl;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import sample.util.ConnectionConfiguration;

import sample.dao.DciDao;
import sample.entities.Dci;

import java.util.List;

public class DciDaoImpl implements DciDao {
	
	
	public DciDaoImpl(){}
	@Override
	public void insert(Dci dci) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
	
		try {
			connection = ConnectionConfiguration.getConnection();
			
			preparedStatement = connection.prepareStatement("INSERT INTO DCI (name) VALUES(?)");
			preparedStatement.setString(1, dci.getName());
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
	public int selectByName(String a) {
		
		int value=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement( "SELECT  id FROM  DCI WHERE  name='" + a +"'" );
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
	public List<Dci> selectAll() {
		List<Dci> dcis = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  * FROM DCI" );
			resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				Dci dci = new Dci();
				dci.setId(resultSet.getInt("id"));
				dci.setName(resultSet.getString("name"));
				dcis.add(dci);
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
		
		
		
		return dcis;
		
	}
}
