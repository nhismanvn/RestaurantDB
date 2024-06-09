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
import java.awt.*;
import java.util.List;

public class OrderHistoryFrame extends JFrame {
    private OrderDAO orderDAO;
    private JTextArea orderHistoryArea;

    public OrderHistoryFrame() {
        orderDAO = new OrderDAO();

        setTitle("Order History");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        orderHistoryArea = new JTextArea();
        orderHistoryArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderHistoryArea);

        add(scrollPane, BorderLayout.CENTER);

        displayOrderHistory();

        setVisible(true);
    }

    private void displayOrderHistory() {
        List<Order> orders = orderDAO.getAllOrders();
        StringBuilder history = new StringBuilder();

        for (Order order : orders) {
            history.append("Order ID: ").append(order.getId()).append("\n")
                    .append("Customer Name: ").append(order.getCustomerName()).append("\n")
                    .append("Order Date: ").append(order.getOrderDate()).append("\n")
                    .append("Total Amount: $").append(order.getTotalAmount()).append("\n");

            List<OrderDetail> orderDetails = orderDAO.getOrderDetails(order.getId());
            for (OrderDetail detail : orderDetails) {
                history.append("  Dish ID: ").append(detail.getDishId()).append("\n")
                        .append("  Quantity: ").append(detail.getQuantity()).append("\n");
            }

            history.append("\n");
        }

        orderHistoryArea.setText(history.toString());
    }

    public static void main(String[] args) {
        // new OrderHistoryFrame(); // Chỉ được gọi từ LoginFrame nếu người dùng là admin
    }
}
