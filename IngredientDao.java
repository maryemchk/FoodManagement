package tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDao extends DAO<Ingredient> {

	public IngredientDao(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Ingredient> findAll() {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		try {
			 PreparedStatement statement = con.prepareStatement("SELECT * FROM Ingredient");
	            ResultSet resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                Ingredient ingredient = new Ingredient(resultSet.getString("RefIngredient"), resultSet.getString("NomIngredient"),resultSet.getString("RefType"));
	                ingredients.add(ingredient);
	            }
	            
		}catch (SQLException e){
			e.printStackTrace();
		}
		return ingredients;
	}

	@Override
	public Ingredient find(String id) throws SQLException {
		Ingredient ingredient=null;
		try {
			PreparedStatement stat=con.prepareStatement("SELECT *FROM Ingredient WHERE RefIngredient=?");
			stat.setString(1, id);
			ResultSet resultSet = stat.executeQuery();
			if(resultSet.next()) {
				ingredient=new Ingredient(resultSet.getString("RefIngredient"),resultSet.getString("NomIngredient"),null);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ingredient;
	}

	@Override
	public boolean create(Ingredient obj) throws SQLException {
		PreparedStatement statement =con.prepareStatement("Insert into Ingredient (RefIngredient,NomIngredient,RefType)VALUES(?,?,?)");
		statement.setString(1,obj.getRefIngredient());
		statement.setString(2, obj.getNomIngredient());
		statement.setString(3, obj.getRefType());
		int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
	}

	@Override
	public boolean update(Ingredient obj) throws SQLException {
		PreparedStatement statement =con.prepareStatement("Update Ingredient SET NomIngredient=? WHERE RefIngredient=?");
		statement.setString(1, obj.getNomIngredient());
		statement.setString(2, obj.getRefIngredient());
		int rowsUpdated = statement.executeUpdate();
	    return rowsUpdated > 0;
	}

	@Override
	public boolean delete(Ingredient obj) throws SQLException {
		PreparedStatement statement=con.prepareStatement("DELETE FROM Ingredient WHERE RefIngredient =?");
		statement.setString(1, obj.getRefIngredient());
		int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
	}

}