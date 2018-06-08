package sample.daoimpl;
import java.util.*;

import sample.dao.ProblemDao;
import sample.entities.Problem;
import sample.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProblemDaoImpl implements ProblemDao {
	@Override
	public void insert(Problem problem) {
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		
		
		
		
		try {
			connection = ConnectionConfiguration.getConnection();
			
			preparedStatement = connection.prepareStatement("INSERT INTO problem (name) VALUES(?)");
			preparedStatement.setString(1, problem.getName());
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
			preparedStatement = connection.prepareStatement( "SELECT  id FROM  problem WHERE  name = " + "\"" + a + "\" ");
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
	public List<Problem> selectAll() {
		
		
		
		List<Problem> probs = new ArrayList<Problem>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.prepareStatement("SELECT  * FROM problem" );
			resultSet = statement.executeQuery();
			
			while (resultSet.next()){
				Problem prob = new Problem();
				prob.setId(resultSet.getInt("id"));
				prob.setName(resultSet.getString("name"));
				
				probs.add(prob);
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
		
		
		
		return probs;
		
	}
}
