package tp5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProduitDao extends DAO<Produit>{

	public ProduitDao(Connection con) {
		super(con);
	}

	@Override
	public ArrayList <Produit>  findAll()throws SQLException{
		ArrayList<Produit> products = new ArrayList<>();
		try {
			PreparedStatement statement =con.prepareStatement("SELECT * FROM Produit");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	Produit produit = new Produit(resultSet.getString("RefProduit"), resultSet.getString("DescriptifProduit"),resultSet.getDate("DatePeremption"),resultSet.getInt("QuantiteProduit"),resultSet.getDouble("PrixProduit"),null,null);
                products.add(produit);
            }

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return products;
	}


	@Override
	public boolean create(Produit obj)throws SQLException  {
		PreparedStatement statement =con.prepareStatement("INSERT INTO Produit (RefProduit, DescriptifProduit,DatePeremption,QuantiteProduit,PrixProduit,RefRangement,RefIngredient) VALUES (?,?,?,?,?,?,?)");
        statement.setString(1, obj.getRefProduit());
        statement.setString(2, obj.getDescriptifProduit());
        statement.setDate(3, obj.getDatePeremption());
        statement.setInt(4, obj.getQuantiteProduit());
        statement.setDouble(5, obj.getPrixProduit());
        statement.setString(6, obj.getRangement());
        statement.setString(7, obj.getIngredient());
        int rowsInserted = statement.executeUpdate();
        return rowsInserted > 0;
		
	}


	@Override
	public boolean update(Produit obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("UPDATE Produit SET DescriptifProduit = ? WHERE RefProduit = ?");
        statement.setString(1, obj.getRefProduit());
        statement.setString(2, obj.getDescriptifProduit());
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
			}

	@Override
	public boolean delete(Produit obj) throws SQLException {
		PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUIT WHERE RefProduit = ?");
        statement.setString(1, obj.getRefProduit());
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
	}

	@Override
	public Produit find(String id) throws SQLException {
		Produit produit = null;
        try {
        	PreparedStatement stat = con.prepareStatement("SELECT * FROM PRODUIT WHERE RefProduit = ?");

            stat.setString(1, id);
            ResultSet resultSet = stat.executeQuery();
            if (resultSet.next()) {
                produit = new Produit(resultSet.getString("RefProduit"), resultSet.getString("DescriptifProduit"),resultSet.getDate("DatePeremption"),resultSet.getInt("QuantiteProduit"),resultSet.getDouble("PrixProduit"),null,null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
	}

}