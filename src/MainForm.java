import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public JPanel pnlMainForm;
    public JPanel pnlMain;
    public JPanel pnlDeposit;
    public JPanel pnlControls;
    public JCheckBox chkCapitalization;
    public JButton btnCalculate;
    public JButton btnSave;
    public JTextField tfPercentage;
    public JTextField tfTime;
    public JTextField tfDeposit;
    public JTextField tfResultIncome;
    private JComboBox cmbTime;

    public MainForm() {
        this.setTitle("Deposit Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(600, 250);
        this.setVisible(true);
        cmbTime.addItem("Months");
        cmbTime.addItem("Year");
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float deposit = 0, percentage = 0, time = 0;
                int monthly = 0, capitalization = 0;
                try {
                    deposit = Float.parseFloat(tfDeposit.getText());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error: " + exception.getMessage());
                    return;
                }
                try {
                    percentage = Float.parseFloat(tfPercentage.getText());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error: " + exception.getMessage());
                    return;
                }
                try {
                    time = Float.parseFloat(tfTime.getText());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(new JFrame(), "Error: " + exception.getMessage());
                    return;
                }
                Calculations calc = new Calculations();

                if (cmbTime.getSelectedItem() == "Months") monthly = 1;
                if (chkCapitalization.isSelected())
                    tfResultIncome.setText(String.valueOf(calc.calculate_income_cap(deposit, percentage, time, monthly)));
                else
                    tfResultIncome.setText(String.valueOf(calc.calculate_income_no_cap(deposit, percentage, time, monthly)));
            }
        });
    }
}
