
    	package tp5;


    	import java.sql.Connection;



    	public class main {

    		 public static void main(String[] args) {
    		        DBMSConnection db = new DBMSConnection();
    		        Connection con = db.getConnection();
    		        
    		        RangementDao rgDao = new RangementDao(con);
    		      
    		        IngredientDao ingDao = new IngredientDao(con);
    		        
    		        RecetteDao recDao = new RecetteDao(con);
    		      

    	
    		        new FoodManagement(rgDao,ingDao,recDao);
    		    }
    		 	
    	}