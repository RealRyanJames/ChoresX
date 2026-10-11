import DB.DBConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


void main() {

    JFrame frame = new JFrame("ChoresX");
    var pane = (JPanel) frame.getContentPane();
    frame.setVisible(true);

    JFrame f = new JFrame("Welcome Screen | Home");

    pane.setBackground(new Color(0, 0, 0));


    JCheckBox check = new JCheckBox("Open Next Window");
    JLabel todoL2 = new JLabel("Take Shower");
    JLabel todosL = new JLabel("Eat Breakfast");
    JLabel todos3 = new JLabel("Eat Lunch");
    JLabel todos4 = new JLabel("Do Laundry");
    JLabel p = new JLabel("Do Dishes");
    JLabel p1 = new JLabel("Programming");
    JPanel panel = new JPanel(new GridLayout(2, 2));

    JLabel l2 = new JLabel("Welcome to ChoresX Chores Reminders", SwingConstants.CENTER);
    l2.setForeground(new Color(255, 12, 43));

    f.add(l2);


    for (int i = 0; i < 1; i++) {

        todoL2.setForeground(new Color(20, 20, 20));
        pane.setBackground(new Color(255, 255, 255));

        panel.setLayout(new GridLayout(2, 2));
        panel.add(todoL2);
        panel.add(todosL);
        panel.add(todos3);
        panel.add(todos4);
        panel.add(p);
        panel.add(p1);

        todoL2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
                Date now = Calendar.getInstance().getTime();

                File file = new File("choresCompleted.txt");
                try (FileWriter write = new FileWriter(file.getName(), true)) {
                    write.write("Completed Shower on: " + date.format(now) + "\n");
                    DBConnector.ConnectDBClient("Completed Shower on: " + date.format(now));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        todos3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
                Date now = Calendar.getInstance().getTime();

                File file = new File("choresCompleted.txt");
                try (FileWriter write = new FileWriter(file.getName(), true)) {
                    write.write("Completed Lunch on: " + date.format(now) + "\n");

                    DBConnector.ConnectDBClient("Completed Lunch on: " + date.format(now));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        todosL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
                Date now = Calendar.getInstance().getTime();

                File file = new File("choresCompleted.txt");
                try (FileWriter write = new FileWriter(file.getName(), true)) {
                    write.write("Completed Breakfast on: " + date.format(now) + "\n");
                    DBConnector.ConnectDBClient("Completed Breakfast on: " + date.format(now));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        todos4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
                Date now = Calendar.getInstance().getTime();

                File file = new File("choresCompleted.txt");
                try (FileWriter write = new FileWriter(file.getName(), true)) {
                    write.write("Completed Laundry on: " + date.format(now) + "\n");
                    DBConnector.ConnectDBClient("Completed Laundry on: " + date.format(now));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        p1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
                Date now = Calendar.getInstance().getTime();

                File file = new File("choresCompleted.txt");
                try (FileWriter write = new FileWriter(file.getName(), true)) {
                    write.write("Completed Programming on: " + date.format(now));
                    DBConnector.ConnectDBClient("Completed Programming on: " + date.format(now));

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


                DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
                Date now = Calendar.getInstance().getTime();

                File file = new File("choresCompleted.txt");
                try (FileWriter write = new FileWriter(file.getName(), true)) {
                    write.write("Completed Dishes on: " + date.format(now) + "\n");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
    }

    DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
    Date now = Calendar.getInstance().getTime();

    JLabel l = new JLabel("Welcome to ChoresX Application".toUpperCase(), SwingConstants.CENTER);
    l.setFont(new Font("sans-serif", Font.BOLD, 15));
    l.setForeground(new Color(20, 20, 20));
    frame.add(l, BorderLayout.NORTH);
    JLabel lDate = new JLabel("Today is: " + date.format(now));

    lDate.setFont(new Font("sans-serif", Font.BOLD, 17));
    lDate.setForeground(new Color(20, 20, 20));
    frame.setResizable(false);
    frame.add(lDate, BorderLayout.SOUTH);

    pane.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 0));
    frame.setSize(new Dimension(700 / 2, 350 * 2));

    f.add(check);
    check.setFocusable(false);
    f.setVisible(true);

    check.addItemListener(_ -> {

        frame.setVisible(true);
        f.setVisible(false);

        f.setResizable(false);
        frame.setResizable(false);
    });

    f.setSize(new Dimension(300 * 5 / 3, 200));
    var pane_f = (JPanel)f.getContentPane();
    pane_f.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));

    frame.setVisible(false);
    f.add(check);
    pane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

