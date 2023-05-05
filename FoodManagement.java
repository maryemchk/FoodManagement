package tp5;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class FoodManagement extends JFrame {


	
    private JTextField recetteRefField;
    private JTextField recetteNomField;
    private JTextArea recetteDescriptifField;
    private JTextField recetteCaloriesField;
    private JComboBox<String> recetteDifficulteComboBox;
    private JTextField recetteTempsPreparationField;
    private JTextField recetteTempsCuissonField;
    private JTextField recetteNbPersonnesField;


   
 
    public FoodManagement(RangementDao rangementDao, IngredientDao ingredientDao, RecetteDao recDao) {
        super("FOOD ");

        //ingredient 
        // Create the search panels
        JPanel ingredientSearchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        ingredientSearchPanel.setBackground(new Color(245, 245, 245));
        ingredientSearchPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        // Create the ingredient search components
        JLabel ingredientSearchLabel = new JLabel("Search Ingredient:");
        ingredientSearchLabel.setFont(new Font("Arial", Font.BOLD, 16));
        ingredientSearchPanel.add(ingredientSearchLabel);

        JTextField ingredientSearchField = new JTextField(30);
        ingredientSearchField.setFont(new Font("Arial", Font.PLAIN, 16));
        ingredientSearchPanel.add(ingredientSearchField);

        JButton ingredientSearchButton = new JButton("Search");
        ingredientSearchButton.setFont(new Font("Arial", Font.PLAIN, 16));
        ingredientSearchButton.setBackground(new Color(50, 150, 250));
        ingredientSearchButton.setForeground(Color.WHITE);
        ingredientSearchButton.setFocusPainted(false);
        ingredientSearchPanel.add(ingredientSearchButton);

       

        
        
        ingredientSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = ingredientSearchField.getText();
                try {
                    // Call the find method in your IngredientDao to retrieve the search results
                    Ingredient result = ingredientDao.find(query);
                    if (result != null) {
                        // Create a new window to display the search results
                        JFrame searchResultsWindow = new JFrame("Search Results");
                        searchResultsWindow.setLayout(new BorderLayout());

                        // Create a table model with the column names and the search results data
                        String[] columnNames = {"Ingredient ID", "Ingredient Name", "Quantity"};
                        Object[][] data = new Object[1][3];
                        data[0][0] = result.getRefIngredient();
                        data[0][1] = result.getNomIngredient();
                        data[0][2] = result.getRefType();
                        
                        JTable searchResultsTable = new JTable(data, columnNames);
                        JScrollPane searchResultsScrollPane = new JScrollPane(searchResultsTable);
                        searchResultsWindow.add(searchResultsScrollPane, BorderLayout.CENTER);

                        // Create a return button to go back to the main window
                        JButton returnButton = new JButton("Return to Main Window");
                        returnButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                searchResultsWindow.dispose();
                            }
                        });
                        searchResultsWindow.add(returnButton, BorderLayout.SOUTH);

                        // Set the size and location of the search results window
                        searchResultsWindow.setSize(600, 400);
                        searchResultsWindow.setLocationRelativeTo(null);
                        searchResultsWindow.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(FoodManagement.this, "No results found", "Search Results", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        

        // Add the createRecetteButton to the recetteCreatePanel
        
        
     // Create the show all recettes button panel
        JPanel showAllRecettesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        showAllRecettesPanel.setBackground(new Color(245, 245, 245));

        JButton showAllRecettesButton = new JButton("Show All Recettes");
        showAllRecettesButton.setFont(new Font("Arial", Font.BOLD, 16));
        showAllRecettesButton.setBackground(new Color(50, 150, 250));
        showAllRecettesButton.setForeground(Color.WHITE);
        showAllRecettesButton.setFocusPainted(false);
        showAllRecettesPanel.add(showAllRecettesButton);

        showAllRecettesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call the findAll method in your RecetteDao to retrieve all the recettes
                ArrayList<Recette> recettes = recDao.findAll();

                // Create a new window to display the results
                JFrame recettesWindow = new JFrame("All Recettes");
                recettesWindow.setLayout(new BorderLayout());

             // Create a table model with the column names and the recettes data
                String[] columnNames = {"Ref Recette", "Nom Recette", "Descriptif Recette", "Calories Recette", "Difficulte", "Temps Preparation", "Temps Cuisson", "Nb Personnes"};
                
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                for (Recette r : recettes) {
                    Object[] rowData = {r.getRefRecette(), r.getNomRecette(), r.getDescriptifRecette(), r.getCaloriesRecette(), r.getDifficulte(), r.getTempsPreparation(), r.getTempsCuisson(), r.getNbPersonnes()};
                    model.addRow(rowData);
                }

                JTable recettesTable = new JTable(model);
                JScrollPane recettesScrollPane = new JScrollPane(recettesTable);
                recettesWindow.add(recettesScrollPane, BorderLayout.CENTER);

                JButton returnButton = new JButton("Return to Main Menu");
                returnButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        recettesWindow.dispose();
                        setVisible(true);
                    }
                });
                recettesWindow.add(returnButton, BorderLayout.SOUTH);

                recettesWindow.setSize(800, 550);
                recettesWindow.setLocationRelativeTo(null);
                recettesWindow.setVisible(true);
            }
            

        });
        // Create the "Create Recette" panel
        JPanel createRecettePanel = new JPanel(new GridLayout(8, 2, 10, 10));
        createRecettePanel.setBackground(new Color(245, 245, 245));
        createRecettePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Create Recette", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.BOLD, 16)));

        // Add the "Recette Reference" label and text field
        createRecettePanel.add(new JLabel("Recette Reference:"));
        recetteRefField = new JTextField(20);
        createRecettePanel.add(recetteRefField);

        // Add the "Recette Name" label and text field
        createRecettePanel.add(new JLabel("Recette Name:"));
        recetteNomField = new JTextField(20);
        createRecettePanel.add(recetteNomField);

        // Add the "Recette Description" label and text area
        createRecettePanel.add(new JLabel("Recette Description:"));
        recetteDescriptifField = new JTextArea(3, 20);
        recetteDescriptifField.setLineWrap(true);
        createRecettePanel.add(new JScrollPane(recetteDescriptifField));

        // Add the "Recette Calories" label and text field
        createRecettePanel.add(new JLabel("Recette Calories:"));
        recetteCaloriesField = new JTextField(20);
        createRecettePanel.add(recetteCaloriesField);

        // Add the "Recette Difficulty" label and combo box
        createRecettePanel.add(new JLabel("Recette Difficulty:"));
        String[] difficulteValues = {"facile", "Moyenne", "Difficile"};
        recetteDifficulteComboBox = new JComboBox<>(difficulteValues);
        createRecettePanel.add(recetteDifficulteComboBox);

        // Add the "Recette Preparation Time" label and text field
        createRecettePanel.add(new JLabel("Recette Preparation Time (min):"));
        recetteTempsPreparationField = new JTextField(20);
        createRecettePanel.add(recetteTempsPreparationField);

        // Add the "Recette Cooking Time" label and text field
        createRecettePanel.add(new JLabel("Recette Cooking Time (min):"));
        recetteTempsCuissonField = new JTextField(20);
        createRecettePanel.add(recetteTempsCuissonField);

        // Add the "Recette Number of People" label and text field
        createRecettePanel.add(new JLabel("Number of People:"));
        recetteNbPersonnesField = new JTextField(20);
        createRecettePanel.add(recetteNbPersonnesField);

        

  
        // Create the "Create Recette" button
        JButton createRecetteButton = new JButton("Create Recette");
        createRecetteButton.setFont(new Font("Arial", Font.PLAIN, 16));
        createRecetteButton.setBackground(new Color(50, 150, 250));
        createRecetteButton.setForeground(Color.WHITE);
        createRecetteButton.setFocusPainted(false);
        
        createRecetteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new Recette object with the data entered by the user
                String refRecette = recetteRefField.getText();
                String nomRecette = recetteNomField.getText();
                String descriptifRecette = recetteDescriptifField.getText();
                int caloriesRecette = 0;
                int tempsPreparation = 0;
                int tempsCuisson = 0;
                int nbPersonnes = 0;
                String difficulte = (String) recetteDifficulteComboBox.getSelectedItem();

                try {
                    if (!recetteCaloriesField.getText().isEmpty()) {
                        caloriesRecette = Integer.parseInt(recetteCaloriesField.getText());
                    }
                    if (!recetteTempsPreparationField.getText().isEmpty()) {
                        tempsPreparation = Integer.parseInt(recetteTempsPreparationField.getText());
                    }
                    if (!recetteTempsCuissonField.getText().isEmpty()) {
                        tempsCuisson = Integer.parseInt(recetteTempsCuissonField.getText());
                    }
                    if (!recetteNbPersonnesField.getText().isEmpty()) {
                        nbPersonnes = Integer.parseInt(recetteNbPersonnesField.getText());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FoodManagement.this, "Invalid input: " + ex.getMessage(), "Create Recette", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                DBMSConnection con =new DBMSConnection();
                Recette newRecette = new Recette(refRecette, nomRecette, descriptifRecette, caloriesRecette, difficulte, tempsPreparation, tempsCuisson, nbPersonnes);
                RecetteDao recette =new RecetteDao(con.getConnection());
                // Call the create method in your RecetteDao to add the new Recette to the table
                try  {
                    boolean success = recette.create(newRecette);
                    if (success) {
                        // Display a message to the user that the Recette was created successfully
                        JOptionPane.showMessageDialog(FoodManagement.this, "Recette created successfully", "Create Recette", JOptionPane.INFORMATION_MESSAGE);
                        // Clear the fields in the create Recette panel
                        recetteRefField.setText("");
                        recetteNomField.setText("");
                        recetteDescriptifField.setText("");
                        recetteCaloriesField.setText("");
                        recetteDifficulteComboBox.setSelectedIndex(0);
                        recetteTempsPreparationField.setText("");
                        recetteTempsCuissonField.setText("");
                        recetteNbPersonnesField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(FoodManagement.this, "Failed to create Recette", "Create Recette", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(FoodManagement.this, "Failed to create Recette: " + ex.getMessage(), "Create Recette", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JPanel mainPanel = new JPanel(new BorderLayout());
        setContentPane(new JPanel(new BorderLayout()));
        mainPanel.setBackground(Color.WHITE);

        mainPanel.add(ingredientSearchPanel, BorderLayout.NORTH); 
        mainPanel.add(createRecettePanel, BorderLayout.CENTER);
        mainPanel.add(createRecetteButton, BorderLayout.SOUTH);

        
        add(mainPanel, BorderLayout.CENTER);
        add(showAllRecettesPanel, BorderLayout.SOUTH);
        
        setFont(new Font("Arial", Font.PLAIN, 16));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        setSize(800, 500);
        setVisible(true);



    }
}