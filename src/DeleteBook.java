import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;



public class DeleteBook extends JFrame {
    static DeleteBook frame;
	private JPanel contentPane;
        private JTextField textField;
	//private JTextField textField_1;
        
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteBook();
					frame.setVisible(true);
				} catch (Exception e) {e.printStackTrace();}
			}
		});
	}
        
        
        
        public DeleteBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
                contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUpdatebook = new JLabel("   DELETE BOOK   ");
		lblUpdatebook.setForeground(Color.GRAY);
		lblUpdatebook.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 22));
                
                JLabel lblCallNo = new JLabel("Callno:");
                
                //JLabel lblQuantity = new JLabel("Quantity:");
                
                
                
                
                
                textField = new JTextField();
		textField.setColumns(10);
		
		//textField_1 = new JTextField();
		//textField_1.setColumns(10);
                
                
                JButton btnupdatebutton = new JButton("DELETE");
		btnupdatebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String callno=textField.getText();
                       // String squantity=textField_1.getText();
                        //int quantity=Integer.parseInt(squantity);
                        int i = Updao.Delete(callno);
                        if(i>0){
				JOptionPane.showMessageDialog(DeleteBook.this,"Books updated successfully!");
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(DeleteBook.this,"Sorry, unable to delete!");
			}
                        
                        
                        }
                });
                JButton btnBack = new JButton("BACK");
                btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		
gl_contentPane.setHorizontalGroup(
    gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGap(120)
            .addComponent(lblUpdatebook))
        .addGroup(gl_contentPane.createSequentialGroup()
            .addContainerGap()
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addComponent(lblCallNo))
                //.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
            .addGap(47)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                //.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGap(161)
            .addComponent(btnupdatebutton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
        .addGroup(gl_contentPane.createSequentialGroup()
            .addContainerGap(150, Short.MAX_VALUE)
            .addComponent(btnBack)
                .addGap(180)
            .addContainerGap()
        ));
gl_contentPane.setVerticalGroup(
    gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addComponent(lblUpdatebook)
            .addGap(18)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                .addComponent(lblCallNo)
                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18)
            //.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                //.addComponent(lblQuantity)
                //.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(10)
            .addComponent(btnupdatebutton)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnBack)
            .addContainerGap(53, Short.MAX_VALUE))
);
contentPane.setLayout(gl_contentPane);

                                                        
        }

    
}








