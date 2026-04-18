import javax.swing.*;
import java.awt.*;

public class BookingUI extends JFrame {

    private JTextArea outputArea;
    private JLabel seatsLabel;
    private JTextField nameField;

    private int seats = 5;

    public BookingUI() {

        setTitle("Train Ticket Booking System");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nameField = new JTextField(15);

        JButton bookButton = new JButton("Book Ticket");
        JButton cancelButton = new JButton("Cancel Ticket");

        seatsLabel = new JLabel("Seats Available: " + seats);
        outputArea = new JTextArea(10, 30);

        add(new JLabel("Enter Name:"));
        add(nameField);
        add(bookButton);
        add(cancelButton);
        add(seatsLabel);
        add(new JScrollPane(outputArea));

        // BOOK BUTTON
        bookButton.addActionListener(e -> {
            if (seats > 0) {
                seats--;
                outputArea.append(nameField.getText() + " booked ticket\n");
            } else {
                outputArea.append("No seats available\n");
            }
            seatsLabel.setText("Seats Available: " + seats);
        });

        // CANCEL BUTTON
        cancelButton.addActionListener(e -> {
            seats++;
            outputArea.append(nameField.getText() + " canceled ticket\n");
            seatsLabel.setText("Seats Available: " + seats);
        });

        setVisible(true);
    }
}