package com.day5.dao;

import java.util.List;

import com.day5.model.Bug;

public interface BugDao {

    boolean addBug(Bug bug);

    List<Bug> getAllBugs();

    boolean updateBugStatus(int id, String status);

    boolean deleteBug(int id);
}