import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel jpanel;
    private JButton btnOrder;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;

    public GUI() {
        rbNone.setSelected(true);
        JRadioButton[] rbDiscounts = { rbNone, rb5, rb10, rb15 };
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String discountString = null;
                double discount = 0;
                double order = 0;
                for(JRadioButton rb : rbDiscounts) {
                    if (rb.isSelected()) discountString = rb.getText();
                }
                switch(discountString) {
                    case "None":
                        discount = 0;
                        break;
                    case "5% Off":
                        discount = 0.05;
                        break;
                    case "10% Off":
                        discount = 0.10;
                        break;
                    case "15% Off":
                        discount = 0.15;
                        break;
                }
                if (cPizza.isSelected()) order += 100;
                if (cBurger.isSelected()) order += 80;
                if (cFries.isSelected()) order += 65;
                if (cSoftDrinks.isSelected()) order += 55;
                if (cTea.isSelected()) order += 50;
                if (cSundae.isSelected()) order += 40;
                order = order - (order * discount);
                JOptionPane.showMessageDialog(null, "The total price is Php. " + String.format("%.2f", order));
            }
        });
    }
    public static void main(String[] args) {
        GUI app = new GUI();
        app.setContentPane(app.jpanel);
        app.setSize(400, 500);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setTitle("Food Ordering System");
        app.setVisible(true);
    }
}
