package tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecetteDao extends DAO<Recette>{

	public RecetteDao(Connection connection) {
		super(connection);

	}

	@Override
	public  ArrayList<Recette> findAll(){
		ArrayList<Recette> recettes = new ArrayList<>();
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Recette");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	Recette recette = new Recette(resultSet.getString("RefRecette"), resultSet.getString("NomRecette"),resultSet.getString("DescriptifRecette"),resultSet.getInt("CaloriesRecette"),resultSet.getString("Difficulte"),resultSet.getInt("TempsPreparation"),resultSet.getInt("TempsCuisson"),resultSet.getInt("NbPersonnes"));
                recettes.add(recette);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recettes;
	}

	@Override
	public Recette find(String id)throws SQLException  {
		Recette recette =null;
		try {
			PreparedStatement stat=con.prepareStatement("SELECT * FROM Recette WHERE RefRecette=?");
			stat.setString(1, id);
			ResultSet resultSet = stat.executeQuery();
			 if (resultSet.next()) {
				  recette = new Recette(resultSet.getString("RefRecette"), resultSet.getString("NomRecette"),resultSet.getString("DescriptifRecette"),resultSet.getInt("CaloriesRecette"),resultSet.getString("Difficulte"),resultSet.getInt("TempsPreparation"),resultSet.getInt("TempsCuisson"),resultSet.getInt("NbPersonnes"));
	            }
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return recette;
	}

	@Override
	 public boolean create(Recette obj) throws SQLException {
        PreparedStatement statement = con.prepareStatement("INSERT INTO Recette (RefRecette, NomRecette, DescriptifRecette, CaloriesRecette, Difficulte, TempsPreparation, TempsCuisson, NbPersonnes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        statement.setString(1, obj.getRefRecette());
        statement.setString(2, obj.getNomRecette());
        statement.setString(3, obj.getDescriptifRecette());
        statement.setInt(4, obj.getCaloriesRecette());
        statement.setString(5, obj.getDifficulte());
        statement.setInt(6, obj.getTempsPreparation());
        statement.setInt(7, obj.getTempsCuisson());
        statement.setInt(8, obj.getNbPersonnes());
        int rowsInserted = statement.executeUpdate();
        statement.close();
        return rowsInserted > 0;
    }


	@Override
	public boolean update(Recette obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("UPDATE Recette SET NomRecette = ? WHERE RefRecette = ?");
        statement.setString(1, obj.getNomRecette());
        statement.setString(2, obj.getRefRecette());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
	}

	@Override
	public boolean delete(Recette obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("DELETE FROM Recette WHERE RefRecette = ?");
        statement.setString(1, obj.getRefRecette());
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
	}

	

	
}
