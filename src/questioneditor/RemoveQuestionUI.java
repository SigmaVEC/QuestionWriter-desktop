package questioneditor;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author rahul
 */
public class RemoveQuestionUI extends javax.swing.JFrame {

	/**
	 * Creates new form EditQuestionUI
	 */
	private RemoveQuestionUI() {
		PreviousQuestionButton = new javax.swing.JButton();
		NextQuestionButton = new javax.swing.JButton();
		QuestionListComboBox = new javax.swing.JComboBox<>();
		DeleteButton = new javax.swing.JButton();
		ViewSeparator = new javax.swing.JSeparator();
		MainQuestionLabel = new javax.swing.JLabel();
		MainQuestionScrollPane = new javax.swing.JScrollPane();
		MainQuestionDataLabel = new javax.swing.JLabel();
		FileLabel = new javax.swing.JLabel();
		FileDataLabel = new javax.swing.JLabel();
		SubQuestionLabel = new javax.swing.JLabel();
		SubQuestionScrollPane = new javax.swing.JScrollPane();
		SubQuestionDataLabel = new javax.swing.JLabel();
		AnswerLabel = new javax.swing.JLabel();
		AnswerScrollPane = new javax.swing.JScrollPane();
		AnswerDataLabel = new javax.swing.JLabel();
		ReasonLabel = new javax.swing.JLabel();
		ReasonScrollPane = new javax.swing.JScrollPane();
		ReasonDataLabel = new javax.swing.JLabel();

		setTitle("Remove Questions");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MainUI.main(null);
			}
		});

		PreviousQuestionButton.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
		PreviousQuestionButton.setText("<");
		PreviousQuestionButton.setPreferredSize(new java.awt.Dimension(27, 27));
		PreviousQuestionButton.addActionListener(evt -> PreviousQuestionButtonActionPerformed());

		NextQuestionButton.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
		NextQuestionButton.setText(">");
		NextQuestionButton.setPreferredSize(new java.awt.Dimension(27, 27));
		NextQuestionButton.addActionListener(evt -> NextQuestionButtonActionPerformed());

		int qns = Integer.parseInt(util.sqlQuery("SELECT COUNT(QuestionId) FROM Questions")[0]);
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
		for (int i = 1; i <= qns; i++) {
			model.addElement(i);
		}
		QuestionListComboBox.setModel(model);
		QuestionListComboBox.addActionListener(evt -> QuestionListComboBoxActionPerformed());

		updateOnScreenData();

		DeleteButton.setText("Delete");
		DeleteButton.addActionListener(evt -> DeleteButtonActionPerformed());

		MainQuestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		MainQuestionLabel.setText("Main Question");

		MainQuestionScrollPane.setViewportView(MainQuestionDataLabel);

		FileLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		FileLabel.setText("Associated File");

		SubQuestionLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		SubQuestionLabel.setText("Sub Question");

		SubQuestionScrollPane.setViewportView(SubQuestionDataLabel);

		AnswerLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		AnswerLabel.setText("Answer (with choices if any)");

		AnswerScrollPane.setViewportView(AnswerDataLabel);

		ReasonLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
		ReasonLabel.setText("Answer Reason");

		ReasonScrollPane.setViewportView(ReasonDataLabel);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addComponent(AnswerLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
										.addComponent(SubQuestionLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(ReasonLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(SubQuestionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(AnswerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(143, 143, 143))
										.addGroup(layout.createSequentialGroup()
												.addComponent(ReasonScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addContainerGap())))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addComponent(ViewSeparator))
										.addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
												.addGap(368, 368, 368)
												.addComponent(PreviousQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(QuestionListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(NextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(DeleteButton))
										.addGroup(layout.createSequentialGroup()
												.addContainerGap()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(FileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(18, 18, 18)
																.addComponent(FileDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(MainQuestionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGap(18, 18, 18)
																.addComponent(MainQuestionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGap(131, 131, 131)))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(PreviousQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(NextQuestionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(QuestionListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(DeleteButton))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(ViewSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(MainQuestionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(MainQuestionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(FileDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(FileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(SubQuestionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(SubQuestionScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(AnswerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(AnswerScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(ReasonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(ReasonScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
								.addContainerGap(57, Short.MAX_VALUE))
		);

		pack();
		setLocationRelativeTo(null);
	}

	private void updateOnScreenData() {
		int i = QuestionListComboBox.getSelectedIndex();
		String[] data = util.sqlQuery("SELECT * FROM Questions LIMIT 1 OFFSET " + i);
		String[] choice = util.sqlQuery("SELECT Choice FROM Choices WHERE QuestionId=" + data[0]);

		MainQuestionDataLabel.setText(data[1]);
		FileDataLabel.setText(data[2]);
		SubQuestionDataLabel.setText(data[3]);
		ReasonDataLabel.setText(data[5]);

		if (choice.length != 0) {
			StringBuilder ans = new StringBuilder("<html>");

			for (i = 0; i < choice.length; i++) {
				if (choice[i].equals(data[4])) {
					ans.append("Ans-> ");
				} else {
					ans.append("-> ");
				}
				ans.append(choice[i]);
				ans.append("<br>");
			}

			ans.append("</html>");
			AnswerDataLabel.setText(ans.toString());
		} else {
			AnswerDataLabel.setText(data[4]);
		}
	}

	private void PreviousQuestionButtonActionPerformed() {
		int i = QuestionListComboBox.getSelectedIndex();

		if (i != 0) {
			QuestionListComboBox.setSelectedIndex(i - 1);
			updateOnScreenData();
		}
	}

	private void NextQuestionButtonActionPerformed() {
		int i = QuestionListComboBox.getSelectedIndex();

		if (i != QuestionListComboBox.getItemCount() - 1) {
			QuestionListComboBox.setSelectedIndex(i + 1);
			updateOnScreenData();
		}
	}

	private void DeleteButtonActionPerformed() {
		int i = QuestionListComboBox.getSelectedIndex();
		String questionId = util.sqlQuery("SELECT * FROM Questions LIMIT 1 OFFSET " + i)[0];

		util.sqlUpdate("DELETE FROM Questions WHERE QuestionId=" + questionId);
		util.sqlUpdate("DELETE FROM Choices WHERE QuestionId=" + questionId);
		util.sqlUpdate("DELETE FROM StudentAnswers WHERE QuestionId=" + questionId);

		int qns = Integer.parseInt(util.sqlQuery("SELECT COUNT(QuestionId) FROM Questions")[0]);
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();

		for (int j = 1; j <= qns; j++) {
			model.addElement(j);
		}
		QuestionListComboBox.setModel(model);

		if (i < QuestionListComboBox.getItemCount()) {
			QuestionListComboBox.setSelectedIndex(i);
		}
		updateOnScreenData();
	}

	private void QuestionListComboBoxActionPerformed() {
		updateOnScreenData();
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
			java.util.logging.Logger.getLogger(RemoveQuestionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

        /* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> new RemoveQuestionUI().setVisible(true));
	}

	private javax.swing.JLabel AnswerDataLabel;
	private javax.swing.JLabel AnswerLabel;
	private javax.swing.JScrollPane AnswerScrollPane;
	private javax.swing.JButton DeleteButton;
	private javax.swing.JLabel FileDataLabel;
	private javax.swing.JLabel FileLabel;
	private javax.swing.JLabel MainQuestionDataLabel;
	private javax.swing.JLabel MainQuestionLabel;
	private javax.swing.JScrollPane MainQuestionScrollPane;
	private javax.swing.JButton NextQuestionButton;
	private javax.swing.JButton PreviousQuestionButton;
	private javax.swing.JComboBox<Integer> QuestionListComboBox;
	private javax.swing.JLabel ReasonDataLabel;
	private javax.swing.JLabel ReasonLabel;
	private javax.swing.JScrollPane ReasonScrollPane;
	private javax.swing.JLabel SubQuestionDataLabel;
	private javax.swing.JLabel SubQuestionLabel;
	private javax.swing.JScrollPane SubQuestionScrollPane;
	private javax.swing.JSeparator ViewSeparator;
}
