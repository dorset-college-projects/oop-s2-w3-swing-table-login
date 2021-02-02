package com.dorsetcollegeoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimpleTable extends JPanel {

    private static boolean DEBUG = true;

    public static void main(String[] args) {
        // write your code here


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public SimpleTable() {
        // Call the constructor of JPanel which we extended
        super(new GridLayout(1,0));

        //Set up the column names

        String[] columnNames = {"First Name", "Last Name", "Sport", "# of years", "Vegetarian"};

        Object[][] data = {
                {"Katy", "Smith","Snowboarding", 5, false},
                {"John", "Doe", "Rowing" , 3, true},
                {"Sue", "Black", "Knitting", 2, false},
                {"Jame", "White", "Speed Reading", 20, true},
                {"Joe","Brown","Pool",10, false}

        };

        //Set up the data for the table

        //set up the table
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70)); // NEW
        table.setFillsViewportHeight(true); // NEW


        if (DEBUG) {

            table.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                    printDebugData(table);
                }

            });


        }




        //Add a scroll pane to the panel andata,d then we add table to the scroll pane

        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll  pane to this panel
        add(scrollPane);



    }

    private static void createAndShowGUI() {
        if (DEBUG) {
            System.out.println("Hello world SimpleTable");
        }

        JFrame frame = new JFrame("Simple Table Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create and set up the content pane.
        SimpleTable newContentPane = new SimpleTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);


        frame.pack();
        frame.setVisible(true);


    }


    private void printDebugData(JTable table) {
        System.out.println("Mouse is clicked");

        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();

        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of Data: ");

        for(int i = 0; i < numRows; i++) {
            System.out.println("    row " + i + ":");
            for(int j = 0; j < numCols; j++) {
                System.out.println("    " + model.getValueAt(i,j));
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");

    }

}
