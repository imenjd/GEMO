package tn.medtech.sweng.gemo.daoimpl;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;
import tn.medtech.sweng.gemo.entities.Patient ;

public class PatientDaoImpl {

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
            System.out.println();
            System.out.println();

            System.out.println("Added successfully !!!!!!!!!");
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

    public void update (Patient patient, int id){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            connection=ConnectionConfiguration.getConnection();
            preparedStatement=connection.prepareStatement("UPDATE patient SET first_name=?,last_name=?,birth_date=? WHERE id=?");
            preparedStatement.setString(1, patient.getFirstName());
            preparedStatement.setString(2,patient.getLastName());
            preparedStatement.setString(3,patient.getBirthDate());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
            System.out.println();
            System.out.println();
            System.out.println("updated successfully !!!!! ");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

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
}
