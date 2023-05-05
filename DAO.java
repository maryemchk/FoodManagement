package tp5;

import java.sql.*;
import java.util.ArrayList;
public abstract class DAO<T> {
	protected  Connection con=null;

	public DAO(Connection con) {
		this.con = con;
	}
	public abstract ArrayList<T> findAll()throws SQLException;
	public abstract T find(String id)throws SQLException;
	public abstract boolean create(T obj) throws SQLException;
	public abstract boolean update(T obj)throws SQLException;
	public abstract boolean delete(T obj)throws SQLException;
	
	

}
