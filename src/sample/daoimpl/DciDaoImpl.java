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
		
		DciDaoImpl dao = new DciDaoImpl();
		
		
		try {
			connection = ConnectionConfiguration.getConnection();
			
			
			int id=0;
			
			
			
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
	public void update(Dci dci, int id) {
	
	}
	
	@Override
	public void delete(int id) {
	
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
	public Dci selectById(int id) {
		return null;
	}
	
	@Override
	public List<Dci> selectAll() {
		return null;
	}
	
	@Override
	public int checkId(int id) {
		return 0;
	}
}
