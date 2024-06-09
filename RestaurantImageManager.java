 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADMIN
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantImageManager extends JFrame {
    private JTextField imageUrlField;
    private JTextArea descriptionArea;
    private RestaurantImageDAO DAO;

    public RestaurantImageManager() {
        DAO = new RestaurantImageDAO();

        setTitle("Restaurant Image Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel imageUrlLabel = new JLabel("Image URL:");
        imageUrlLabel.setBounds(10, 20, 80, 25);
        panel.add(imageUrlLabel);

        imageUrlField = new JTextField(20);
        imageUrlField.setBounds(100, 20, 165, 25);
        panel.add(imageUrlField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 50, 80, 25);
        panel.add(descriptionLabel);

        descriptionArea = new JTextArea();
        descriptionArea.setBounds(100, 50, 165, 75);
        panel.add(descriptionArea);

        JButton addButton = new JButton("Add Image");
        addButton.setBounds(10, 140, 150, 25);
        panel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imageUrl = imageUrlField.getText();
                String description = descriptionArea.getText();
                DAO.createImage(imageUrl, description);
                JOptionPane.showMessageDialog(null, "Image added successfully!");
            }
        });

        JButton viewButton = new JButton("View Images");
        viewButton.setBounds(170, 140, 150, 25);
        panel.add(viewButton);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO.readImages();
            }
        });
    }

    public static void main(String[] args) {
        new RestaurantImageManager();
    }
    
}
