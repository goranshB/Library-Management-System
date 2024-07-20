
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook extends JFrame {

    static ReturnBook frame;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JDateChooser jDateChooser2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ReturnBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ReturnBook() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 516, 480);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblReturnBook = new JLabel("   RETURN BOOK   ");
        lblReturnBook.setForeground(Color.GRAY);
        lblReturnBook.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));

        JLabel lblBookCallno = new JLabel("Book Callno:");

        JLabel lblStudentId = new JLabel("Student Id:");

        JLabel lblReturn = new JLabel("Return Date:");

        textField = new JTextField();
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);

        jDateChooser2 = new JDateChooser();

        JButton btnReturnBook = new JButton("RETURN");
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookcallno = textField.getText();
                int studentid = Integer.parseInt(textField_1.getText());

                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
                String Rdate = dFormat.format(jDateChooser2.getDate());

                int i = ReturnBookDao.delete(bookcallno, studentid, Rdate);
                if (i > 0) {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Book returned successfully!");
                    ReturnBook.main(new String[]{});
                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Sorry, unable to return book!");
                }
            }
        });

        JButton btnCharge = new JButton("Check Fine");
        btnCharge.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Finedao.main(new String[]{});

            }
        });
        btnCharge.setFont(new Font("Tahoma", Font.BOLD, 12));

        JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianSuccess.main(new String[]{});
                frame.dispose();
            }
        });

        JButton btnPayfine = new JButton("Pay Fine");
        btnPayfine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PaymentForm.main(new String[]{});
                frame.dispose();
            }
        });

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(36)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                                        .addComponent(lblStudentId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblBookCallno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                        .addComponent(lblReturn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                )
                                .addGap(56)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(139, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(210, Short.MAX_VALUE)
                                .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                                .addGap(196))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(305, Short.MAX_VALUE)
                                .addComponent(lblReturnBook)
                                .addGap(147))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(305, Short.MAX_VALUE)
                                .addComponent(btnCharge)
                                .addGap(200))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(355, Short.MAX_VALUE)
                                .addComponent(btnPayfine)
                                .addGap(210))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(19)
                                .addComponent(lblNewLabel)
                                .addContainerGap(294, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(355, Short.MAX_VALUE)
                                .addComponent(btnBack)
                                .addGap(220))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblReturnBook)
                                .addGap(32)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblBookCallno)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(34)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblStudentId)
                                        .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblReturn)
                                        .addComponent(jDateChooser2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(29)
                                .addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(btnCharge, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(btnPayfine)
                                .addGap(10)
                                .addComponent(btnBack)
                                .addGap(10)
                                .addComponent(lblNewLabel)
                                .addGap(10))
        );
        contentPane.setLayout(gl_contentPane);
    }

}
