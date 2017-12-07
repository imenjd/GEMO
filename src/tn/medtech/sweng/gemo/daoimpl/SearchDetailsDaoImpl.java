package tn.medtech.sweng.gemo.daoimpl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tn.medtech.sweng.gemo.dao.SearchDetailsDao;
import tn.medtech.sweng.gemo.entities.SearchDetails;
import tn.medtech.sweng.gemo.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SearchDetailsDaoImpl implements SearchDetailsDao {
    @Override
    public List<String> SearchById(String val) {
        List<SearchDetails> searches=new ArrayList<SearchDetails>();
        List<String> a=new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {

            connection = ConnectionConfiguration.getConnection();
            statement = connection.prepareStatement("SELECT med.name, DCI.name, visit.id, visit.id_patient,visit.date,visit.comment," +
                    "problem.name, patient.first_name, patient.last_name,patient.birth_date,user.firstName,user.lastName,user.status," +
                    "service.name,visit_inter.context,intervention.name FROM visit " +
                    "JOIN visit_dci ON visit_dci.id_visit=visit.id " +
                    "JOIN problem ON visit_dci.id_problem=problem.id " +
                    "JOIN patient ON patient.id=visit.id_patient " +
                    "JOIN user ON user.id=visit.id_user " +
                    "JOIN service ON service.id=visit.id_service " +
                    "JOIN visit_inter ON visit_inter.id_visit=visit_dci.id_visit " +
                    "JOIN intervention ON intervention.id=visit_inter.id_intervention " +
                    "JOIN DCI ON DCI.id=visit_dci.id_dci " +
                    "JOIN med_dci ON med_dci.id_dci=DCI.id " +
                    "JOIN med ON med_dci.id_med=med.id" +

                    " WHERE visit.id=" +

                    "\"" + val + "\" ");
            rs = statement.executeQuery();

            while (rs.next()) {
                SearchDetails s=new SearchDetails();
                s.setMed(rs.getString(1));
                a.add(s.getMed());
                s.setDci(rs.getString(2));
                a.add(s.getDci());
                s.setRef(rs.getString(3));
                a.add(s.getRef());
                s.setIdpatient(rs.getString(4));
                a.add(s.getIdpatient());
                s.setDate(rs.getString(5));
                a.add(s.getDate());
                s.setCommentaire(rs.getString(6));
                a.add(s.getCommentaire());
                s.setProbleme(rs.getString(7));
                a.add(s.getProbleme());
                s.setFirstname(rs.getString(8));
                a.add(s.getFirstname());
                s.setLastname(rs.getString(9));
                a.add(s.getLastname());
                s.setDbpatient(rs.getString(10));
                a.add(s.getDbpatient());
                s.setUserfn(rs.getString(11));
                a.add(s.getUserfn());
                s.setUserln(rs.getString(12));
                a.add(s.getUserln());
                s.setStatus(rs.getString(13));
                a.add(s.getStatus());
                s.setService(rs.getString(14));
                a.add(s.getService());
                s.setContexte(rs.getString(15));
                a.add(s.getContexte());
                s.setIntervention(rs.getString(16));
                a.add(s.getIntervention());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }


}
