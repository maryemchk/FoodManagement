package tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RangementDao extends DAO<Rangement>{

	public RangementDao(Connection connection) {
		super(connection);
	}

	@Override
	public ArrayList<Rangement> findAll() throws SQLException {
		ArrayList<Rangement> rangements = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Rangement");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Rangement rangement = new Rangement(resultSet.getString("RefRangement"), resultSet.getString("NomRangement"));
                rangements.add(rangement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rangements;
    }

	@Override
	public Rangement find(String id) throws SQLException {
        Rangement rangement = null;
        
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Rangement WHERE RefRangement = ?")) {
            statement.setString(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    rangement = new Rangement(resultSet.getString("RefRangement"), resultSet.getString("NomRangement"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rangement;
    }

	@Override
	public boolean create(Rangement obj) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement("INSERT INTO Rangement (RefRangement, NomRangement) VALUES (?, ?)")) {
            statement.setString(1, obj.getRefRangement());
            statement.setString(2, obj.getNomRangement());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean update(Rangement obj) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement("UPDATE Rangement SET NomRangement = ? WHERE RefRangement = ?")) {
            statement.setString(1, obj.getNomRangement());
            statement.setString(2, obj.getRefRangement());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Override
	public boolean delete(Rangement obj) throws SQLException {
        try (PreparedStatement statement = con.prepareStatement("DELETE FROM Rangement WHERE RefRangement = ?")) {
            statement.setString(1, obj.getRefRangement());
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }	
}
