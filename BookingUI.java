import javax.swing.*;
import java.awt.*;

public class BookingUI extends JFrame {

    private BookingSystem bookingSystem = new BookingSystem();
    private Train train = new Train(101, 2);

    private JTextArea outputArea;
    private JLabel seatsLabel;
    private JTextField nameField;

    public BookingUI() {

        setTitle("Train Ticket Booking System");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Input
        nameField = new JTextField(15);

        // Buttons
        JButton bookButton = new JButton("Book Ticket");
        JButton cancelButton = new JButton("Cancel Ticket");

        // Output + Seat Display
        seatsLabel = new JLabel("Seats Available: " + train.getAvailableSeats());
        outputArea = new JTextArea(10, 30);

        // Add components
        add(new JLabel("Enter Name:"));
        add(nameField);
        add(bookButton);
        add(cancelButton);
        add(seatsLabel);
        add(new JScrollPane(outputArea));

        // BOOK ACTION
        bookButton.addActionListener(e -> {
            String name = nameField.getText();
            User user = new User(name);

            new Thread(() -> {
                String result = bookingSystem.bookTicket(user, train);

                SwingUtilities.invokeLater(() -> {
                    outputArea.append(result + "\n");
                    seatsLabel.setText("Seats Available: " + train.getAvailableSeats());
                });
            }).start();
        });

        // CANCEL ACTION
        cancelButton.addActionListener(e -> {
            String name = nameField.getText();
            User user = new User(name);

            new Thread(() -> {
                String result = bookingSystem.cancelTicket(user, train);

                SwingUtilities.invokeLater(() -> {
                    outputArea.append(result + "\n");
                    seatsLabel.setText("Seats Available: " + train.getAvailableSeats());
                });
            }).start();
        });

        setVisible(true);
    }
}