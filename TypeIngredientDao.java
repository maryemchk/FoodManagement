package tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TypeIngredientDao extends DAO<TypeIngredient>{

	public TypeIngredientDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<TypeIngredient> findAll() throws SQLException {
		ArrayList<TypeIngredient> typeIngredients = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM TypeIngredient");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	TypeIngredient typeingredient = new TypeIngredient(resultSet.getString("RefType"), resultSet.getString("NomType"));
                typeIngredients.add(typeingredient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeIngredients;
	}

	@Override
	public boolean create(TypeIngredient obj) throws SQLException {
		 PreparedStatement statement = con.prepareStatement("INSERT INTO TypeIngredient (RefType, NomType) VALUES (?, ?)");
	        statement.setString(1, obj.getRefType());
	        statement.setString(2, obj.getNomType());
	        int rowsInserted = statement.executeUpdate();
	        return rowsInserted > 0;
	}

	@Override
	public boolean update(TypeIngredient obj) throws SQLException {
			PreparedStatement statement = con.prepareStatement("UPDATE TypeIngredient SET NomType = ? WHERE RefType = ?");
			statement.setString(1, obj.getRefType());
	        statement.setString(2, obj.getNomType());
	        int rowsUpdated = statement.executeUpdate();
	        return rowsUpdated > 0;
	}

	@Override
	public boolean delete(TypeIngredient obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("DELETE FROM TypeIngredient WHERE RefType = ?");
        statement.setString(1, obj.getRefType());
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
	}

	@Override
	public TypeIngredient find(String id) throws SQLException {
		TypeIngredient typeingredient = null;
        try {
            PreparedStatement stat = con.prepareStatement("SELECT * FROM TypeIngredient WHERE RefType = ?");
            stat.setString(1, id);
            ResultSet resultSet = stat.executeQuery();
            if (resultSet.next()) {
            	typeingredient = new TypeIngredient(resultSet.getString("RefType"), resultSet.getString("nomType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeingredient;
	
	}

}
