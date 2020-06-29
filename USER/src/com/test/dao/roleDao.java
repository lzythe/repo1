package com.test.dao;

import com.test.entity.role;

import java.util.List;

public interface roleDao {
    public int getType(String type);
    public List<role> AllPost();
}
