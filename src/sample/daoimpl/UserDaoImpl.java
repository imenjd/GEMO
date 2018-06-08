package sample.daoimpl;
import java.util.*;
import java.sql.*;
import sample.util.*;
import sample.dao.UserDao;
import sample.entities.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
	public void insert(User user) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection= ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO user (first_name,last_name,username,status,email,password,admin) VALUES(?,?,?,?,?,?,?) ");
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getUserName());
			preparedStatement.setString(4, user.getStatus());
			preparedStatement.setString(5, user.getEmail());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setBoolean(7, user.isAdmin());
			preparedStatement.executeUpdate();
		
		
			
		} catch (SQLException e) {
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
	
	
	public void delete(int id) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			//open connection
			connection= ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id=?");
			preparedStatement.setInt(1, id);
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
	
	public int selectByName(String u){
		int value=0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement( "SELECT  id FROM  user WHERE  username= " + "\"" + u + "\" ");
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
	
	public User selectByUserName(String userName) {
		
		User user = new User();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;  // from java sql package ; resultSrt is a table of records from your database
		try {
			connection= ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("SELECT  * FROM  user WHERE  userName = ?");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setId(resultSet.getInt("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
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
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return user;
	}
	
	
	public List<User> selectAll() {
		
		List<User> uzers = new ArrayList<User>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT id,first_name,last_name,username FROM user");
			
			while (resultSet.next()) {
				User uzer = new User();
				uzer.setId(resultSet.getInt("id"));

				uzer.setFirstName(resultSet.getString("first_name"));
				uzer.setLastName(resultSet.getString("last_name"));
				uzer.setUserName(resultSet.getString("username"));
				uzers.add(uzer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		
		
		return uzers;
		
	}
	
	
	public List<String> selectAllNames() {
		
		//create array list of names
		
		List<String> names = new ArrayList<String>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery( "SELECT username FROM user");
			
			while (resultSet.next()){
				String name;
				
				name = (resultSet.getString("userName"));
				
				names.add(name);
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
		
		
		
		return names;
		
	}
	
}

