package org.example.repo;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepo<T, ID> {
    //create
    void add(T t) throws SQLException;

    //read
    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    //update
    T update(T t) throws SQLException;

    //delete
    void remove(ID id) throws SQLException;
}
