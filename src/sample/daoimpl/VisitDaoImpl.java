package sample.daoimpl;
import sample.entities.Visit;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.util.ConnectionConfiguration;

public class VisitDaoImpl {
	
	
	public void insert(Visit visit) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO visit (id_patient, date ,comment,id_service,id_user) VALUES(?,?,?,?,?)");
			preparedStatement.setInt(1, visit.getIdp());
			preparedStatement.setString(2, visit.getDate());
			preparedStatement.setString(3, visit.getCommentaire());
			preparedStatement.setInt(4, visit.getService());
			preparedStatement.setInt(5, visit.getUser());
			try {
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println();
			System.out.println();
			
			System.out.println("Added successfully !!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	
	public int ExtractIdVisit(Visit visit) throws SQLException {
		Connection connection = null;
		connection = ConnectionConfiguration.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT id FROM visit WHERE id_patient=(?) AND comment=(?)");
			preparedStatement.setInt(1,visit.getIdp());
			preparedStatement.setString(2,visit.getCommentaire());
			
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()){
				id=resultSet.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	

	
	public void insert2(Visit visit) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO visit_inter SET id_visit=?,id_intervention=?,context=?");
			preparedStatement.setInt(1, visit.getIdv());
			preparedStatement.setInt(2, visit.getInterv());
			preparedStatement.setString(3, visit.getContexte());
			
			
			try {
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
	
	public void insert3(Visit visit) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO visit_dci SET id_visit=?,id_dci=?,id_problem=?");
			preparedStatement.setInt(1, visit.getIdv());
			preparedStatement.setInt(2, visit.getDci());
			preparedStatement.setInt(3, visit.getProb());
			
			
			try {
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
	public void insert4(Visit visit) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionConfiguration.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO med_dci SET id_dci=?,id_med=?");
			preparedStatement.setInt(1, visit.getDci());
			preparedStatement.setInt(2, visit.getMed());
			
			
			
			try {
				preparedStatement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
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
	public boolean exist(int id) {
		Connection connection = null;
		connection = ConnectionConfiguration.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT id FROM visit");
			
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int idd = 0;
		try {
			while (resultSet.next()) {
				idd = idd + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if (id > idd) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public String findId() {
		Connection connection = null;
		connection = ConnectionConfiguration.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT id FROM visit");
			
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int max =0;int id;
		try {
			while (resultSet.next()) {
				id = resultSet.getInt("id");
				if(id>max)
					max=id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return String.valueOf((max+1));
		
	}
	public int searchLast(){
		Connection connection=null;
		connection=ConnectionConfiguration.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int value=0;
		try {
			preparedStatement=connection.prepareStatement("SELECT MAX(id) FROM visit");
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()){
				value=resultSet.getInt(1);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value+1;
	}
	}
		
	
	

