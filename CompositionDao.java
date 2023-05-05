package tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CompositionDao extends DAO<Composition> {

	public CompositionDao(Connection connection) {
		super(connection);
	}

	@Override
	public ArrayList<Composition> findAll() {
		ArrayList<Composition> compositions = new ArrayList<>();
		try {
			 PreparedStatement stmt = con.prepareStatement("SELECT * FROM Composition");
			 ResultSet rs = stmt.executeQuery();
			 
			 while (rs.next()) {
				 int refComposition = rs.getInt("refComposition");
		            double quantiteComposition = rs.getDouble("quantiteComposition");
		            String refrecette=rs.getString("RefRecette");
		            String refingredient=rs.getString("RefIngridient");
		           
		            Composition composition = new Composition(refComposition, quantiteComposition, refrecette, refingredient);
		            compositions.add(composition);
			 }
			 
		}catch(SQLException e) {
			System.out.println(e.getErrorCode());
		}
		return compositions;
	}

	@Override
	public boolean create(Composition obj) throws SQLException {
	    PreparedStatement statement = con.prepareStatement("INSERT INTO Composition (RefComposition, QuantiteComposition, RefRecette, RefIngredient) VALUES (?,?,?,?)");
	    statement.setInt(1, obj.getRefComposition());
	    statement.setDouble(2, obj.getQuantiteComposition());
	    statement.setString(3, obj.getRecette());
	    statement.setString(4, obj.getIngredient());
	    int rowsInserted = statement.executeUpdate();
	    return rowsInserted > 0;
	}
	@Override
	public boolean update(Composition obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("UPDATE Composition SET QuantiteComposition  = ? WHERE RefComposition = ?");
        statement.setDouble(2, obj.getQuantiteComposition());
        statement.setInt(1, obj.getRefComposition());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
		
	}

	@Override
	public boolean delete(Composition obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("DELETE FROM Composition WHERE RefComposition = ?");
		statement.setInt(1, obj.getRefComposition());
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
	}

	@Override
	public Composition find(String id) throws SQLException {
		Composition composition = null;
        try {
            PreparedStatement stat = con.prepareStatement("SELECT * FROM Composition WHERE RefCompostion = ?");
            stat.setString(1, id);
            ResultSet resultSet = stat.executeQuery();
            if (resultSet.next()) {
                composition = new Composition(resultSet.getInt("RefComposition"), resultSet.getDouble("QuantiteComposition"),null,null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return composition;
	}

}
