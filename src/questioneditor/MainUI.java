package questioneditor;

import java.awt.*;
import java.net.URI;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author rahul
 */
public class MainUI extends javax.swing.JFrame {
	/**
	 * Creates new form MainUI
	 */
	private MainUI() {
		MainLabel = new javax.swing.JLabel();
		AddQuestionsButton = new javax.swing.JButton();
		RemoveQuestionsButton = new javax.swing.JButton();
		Banner = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		MainLabel.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
		MainLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		MainLabel.setText("Question Editor");

		AddQuestionsButton.setText("Add Questions");
		AddQuestionsButton.addActionListener((evt) -> AddQuestionsButtonActionPerformed());

		RemoveQuestionsButton.setText("Remove Questions");
		RemoveQuestionsButton.addActionListener((evt) -> RemoveQuestionsButtonActionPerformed());

		Banner.setText("<html> <u>Powered By Sigma</u> </html>");
		Banner.setCursor(Cursor.getPredefinedCursor(12));
		Banner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Banner.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				BannerMouseClicked();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(130, 130, 130)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(RemoveQuestionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(AddQuestionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(0, 118, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(Banner, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(MainLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(MainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(AddQuestionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(RemoveQuestionsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Banner, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
								.addContainerGap())
		);

		pack();
		setLocationRelativeTo(null);
	}

	private void BannerMouseClicked() {
		if (Desktop.isDesktopSupported()) {
			try {
				Desktop.getDesktop().browse(new URI("https://github.com/SigmaVEC"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void AddQuestionsButtonActionPerformed() {
		setVisible(false);
		dispose();
		AddQuestionUI.main(null);
	}

	private void RemoveQuestionsButtonActionPerformed() {
		setVisible(false);
		dispose();
		RemoveQuestionUI.main(null);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the GTK look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		try {
			javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

        /* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> new MainUI().setVisible(true));
	}

	private javax.swing.JButton AddQuestionsButton;
	private javax.swing.JLabel Banner;
	private javax.swing.JLabel MainLabel;
	private javax.swing.JButton RemoveQuestionsButton;
}
