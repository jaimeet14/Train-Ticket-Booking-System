import javax.swing.*;
import java.awt.*;

public class BookingUI extends JFrame {

    private BookingSystem bookingSystem = new BookingSystem();
    private Train train = new Train(101, 2); // Only 2 seats
    private JTextArea outputArea;

    public BookingUI() {
        setTitle("Train Ticket Booking System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JTextField nameField = new JTextField(15);
        JButton bookButton = new JButton("Book Ticket");
        outputArea = new JTextArea(10, 30);

        add(new JLabel("Enter Name:"));
        add(nameField);
        add(bookButton);
        add(new JScrollPane(outputArea));

        bookButton.addActionListener(e -> {
            String name = nameField.getText();
            User user = new User(name);

            // MULTITHREADING
            new Thread(() -> {
                String result = bookingSystem.bookTicket(user, train);

                // Update UI safely
                SwingUtilities.invokeLater(() -> {
                    outputArea.append(result + "\n");
                });
            }).start();
        });

        setVisible(true);
    }
}