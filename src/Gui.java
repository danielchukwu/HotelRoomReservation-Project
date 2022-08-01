import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Gui {

    // Global Variables
    String hotel;
    String [] roomLevels = {"1 Star", "2 Stars", "3 Stars", "4 Stars", "5 Stars", "ODOGWU"};
    
    Gui(String name) {
        hotel = name;
    }
    
    void welcomeUser() {
        // frame created
        JFrame f = new JFrame(hotel);
        
        // Hotel Button: when clicked takes you to pickRoom() function
        JButton hotelButton = new JButton(hotel);
        f.add(hotelButton);
        
        hotelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pickRoom();
                f.setVisible(false);
            }
        });

        // set frame size, frame layout and frame visibility
        f.setSize(500, 300);
        f.setLayout(new GridLayout(1, 1));
        f.setVisible(true);
    }
    
    void pickRoom() {

        // frame created
        JFrame f = new JFrame(hotel);

        for (int i = 0; i < roomLevels.length; i++) {
            String roomLevel = roomLevels[i];
            JButton button = new JButton(roomLevel);
            f.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    roomBooked(roomLevel);
                    f.setVisible(false);
                }
            });
        }

        
        // set frame size, frame layout and frame visibility
        f.setSize(500, 300);
        f.setLayout(new GridLayout(2, 3));
        f.setVisible(true);
    }

    void roomBooked(String roomLevel) {
        JFrame f = new JFrame(hotel);

        String successMessage = roomLevel + " Booked Successfully. Thank you for picking " + hotel;

        // Write information to file
        try {
            FileWriter filewriter = new FileWriter("info.txt");      // create or open existing file info.txt
            filewriter.write(successMessage);                                 // write to file
            filewriter.close();                                               // close file after writing
        } catch (Exception e) {
            System.out.println("catch " + e);
        }

        JButton successfulButton = new JButton(successMessage);
        f.add(successfulButton);

        successfulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
            }
        });


        // set frame size, frame layout and frame visibility
        f.setSize(500, 300);
        f.setLayout(new GridLayout(1, 1));
        f.setVisible(true);
    }
}
