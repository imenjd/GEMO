package tn.medtech.sweng.gemo.daoimpl;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import tn.medtech.sweng.gemo.entities.Visit;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;


public class VisitDaoImpl {

    public void insert(Visit visit) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO visit (id_patient, date ,comment,id_service,id_user) VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, visit.getIdp());
            preparedStatement.setString(2, visit.getDate());
            preparedStatement.setString(3, visit.getComment());
            preparedStatement.setInt(4, visit.getIds());
            preparedStatement.setInt(5, 1);
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

        insert2(visit);
        insert3(visit);
    }


    public void insert2(Visit visit) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO visit_inter SET id_visit=?,id_intervention=?,context=?");
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, visit.getIdi());
            preparedStatement.setString(3, visit.getContext());


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
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, visit.getIdd());
            preparedStatement.setInt(3, visit.getIdpb());


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

    public void update(Visit visit, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE visit SET id_patient=?,date=?,comment=?,id_service=? WHERE id=?");
            preparedStatement.setInt(1, visit.getIdp());
            preparedStatement.setString(2, visit.getDate());
            preparedStatement.setString(3, visit.getComment());
            preparedStatement.setInt(4, visit.getIds());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            System.out.println();
            System.out.println();
            System.out.println("updated successfully !!!!! ");
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
            preparedStatement = connection.prepareStatement("SELECT * FROM visit");

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
}
