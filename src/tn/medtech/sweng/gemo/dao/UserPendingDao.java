package tn.medtech.sweng.gemo.dao;

import tn.medtech.sweng.gemo.entities.UserPending;

import java.util.List;

public interface UserPendingDao {





        void insert(UserPending userp);

        void delete(int id);


        List<UserPending> selectAll();
        int  checkId(int id);

}


