import javax.swing.*;
import java.awt.*;

public class BookingUI extends JFrame {

    private JTextArea outputArea;
    private JLabel seatsLabel;
    private JTextField nameField;

    public BookingUI() {

        setTitle("Train Ticket Booking System");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        nameField = new JTextField(15);

        JButton bookButton = new JButton("Book Ticket");
        JButton cancelButton = new JButton("Cancel Ticket");

        seatsLabel = new JLabel("Seats Available: Demo");
        outputArea = new JTextArea(10, 30);

        add(new JLabel("Enter Name:"));
        add(nameField);
        add(bookButton);
        add(cancelButton);
        add(seatsLabel);
        add(new JScrollPane(outputArea));

        // Dummy actions (since backend not included)
        bookButton.addActionListener(e -> {
            outputArea.append(nameField.getText() + " clicked BOOK\n");
        });

        cancelButton.addActionListener(e -> {
            outputArea.append(nameField.getText() + " clicked CANCEL\n");
        });

        setVisible(true);
    }
}