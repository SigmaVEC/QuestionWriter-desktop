package questioneditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @author rahul
 */
public class AddQuestionUI extends javax.swing.JFrame {

	/**
	 * Creates new form AddQuestionUI
	 */
	private AddQuestionUI() {
		FileRadioButtonGroup = new javax.swing.ButtonGroup();
		QuestionTypeRadioButtonGroup = new javax.swing.ButtonGroup();
		SelectMainQuestionLabel = new javax.swing.JLabel();
		MainQuestionScrollPane = new javax.swing.JScrollPane();
		MainQuestionList = new javax.swing.JList<>();
		SelectFileLabel = new javax.swing.JLabel();
		FileScrollPane = new javax.swing.JScrollPane();
		FileList = new javax.swing.JList<>();
		MainQuestionSeparator = new javax.swing.JSeparator();
		OrLabel = new javax.swing.JLabel();
		FileSeparator = new javax.swing.JSeparator();
		CreateMainQuestionLabel = new javax.swing.JLabel();
		NoFileRadioButton = new javax.swing.JRadioButton();
		YesFileRadioButton = new javax.swing.JRadioButton();
		ChooseFileButton = new javax.swing.JButton();
		QuestionHasFileLabel = new javax.swing.JLabel();
		MainQuestionInputScrollPane = new javax.swing.JScrollPane();
		MainQuestionInputTextArea = new javax.swing.JTextArea();
		SubQuestionSeparator = new javax.swing.JSeparator();
		SubQuestionInputLabel = new javax.swing.JLabel();
		SubQuestionInputScrollPane = new javax.swing.JScrollPane();
		SubQuestionInputTextArea = new javax.swing.JTextArea();
		ReasonInputLabel = new javax.swing.JLabel();
		ReasonInputScrollPane = new javax.swing.JScrollPane();
		ReasonInputTextArea = new javax.swing.JTextArea();
		SubQuestionTypeLabel = new javax.swing.JLabel();
		FillInBlankRadioButton = new javax.swing.JRadioButton();
		ChoiceRadioButton = new javax.swing.JRadioButton();
		AnswerInputLabel = new javax.swing.JLabel();
		FillInBlankInputTextField = new javax.swing.JTextField();
		ChoiceInputTextField = new javax.swing.JTextField();
		ChoiceScrollPane = new javax.swing.JScrollPane();
		ChoiceList = new javax.swing.JList<>();
		ChoiceListModel = new javax.swing.DefaultListModel<>();
		AddChoiceButton = new javax.swing.JButton();
		DeleteChoiceButton = new javax.swing.JButton();
		ChoiceHelperLabel = new javax.swing.JLabel();
		NotificationLabel = new javax.swing.JLabel();
		SubmitButton = new javax.swing.JButton();

		setTitle("Add Question");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				MainUI.main(null);
			}
		});

		SelectMainQuestionLabel.setText("Select Main Question");

		updateQuestionList();

		MainQuestionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		MainQuestionScrollPane.setViewportView(MainQuestionList);

		SelectFileLabel.setText("Select File");

		FileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		FileScrollPane.setViewportView(FileList);

		OrLabel.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
		OrLabel.setText("OR");

		CreateMainQuestionLabel.setText("Create a new Main Question");

		FileRadioButtonListener = evt -> FileRadioButtonActionPerformed();

		FileRadioButtonGroup.add(NoFileRadioButton);
		NoFileRadioButton.setText("No");
		NoFileRadioButton.addActionListener(FileRadioButtonListener);
		NoFileRadioButton.setSelected(true);

		FileRadioButtonGroup.add(YesFileRadioButton);
		YesFileRadioButton.setText("Yes");
		YesFileRadioButton.addActionListener(FileRadioButtonListener);

		ChooseFileButton.setText("Choose File");
		ChooseFileButton.addActionListener(evt -> ChooseFileButtonActionPerformed());
		ChooseFileButton.setEnabled(false);

		QuestionHasFileLabel.setText("Does the Question include a file?");

		MainQuestionInputTextArea.setColumns(20);
		MainQuestionInputTextArea.setRows(5);
		MainQuestionInputScrollPane.setViewportView(MainQuestionInputTextArea);

		SubQuestionInputLabel.setText("Enter Sub Question");

		SubQuestionInputTextArea.setColumns(20);
		SubQuestionInputTextArea.setRows(5);
		SubQuestionInputScrollPane.setViewportView(SubQuestionInputTextArea);

		ReasonInputLabel.setText("Enter Reason (Leave empty if none)");

		ReasonInputTextArea.setColumns(20);
		ReasonInputTextArea.setRows(5);
		ReasonInputScrollPane.setViewportView(ReasonInputTextArea);

		SubQuestionTypeLabel.setText("Select Question type");

		QuestionTypeRadioButtonListener = evt -> QuestionTypeRadioButtonActionPerformed();

		QuestionTypeRadioButtonGroup.add(FillInBlankRadioButton);
		FillInBlankRadioButton.setText("Fill in the blank");
		FillInBlankRadioButton.addActionListener(QuestionTypeRadioButtonListener);
		FillInBlankRadioButton.setSelected(true);

		QuestionTypeRadioButtonGroup.add(ChoiceRadioButton);
		ChoiceRadioButton.setText("Choice");
		ChoiceRadioButton.addActionListener(QuestionTypeRadioButtonListener);

		AnswerInputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		AnswerInputLabel.setText("Enter Answer");

		ChoiceScrollPane.setViewportView(ChoiceList);
		ChoiceInputTextField.setEnabled(false);

		ChoiceList.setEnabled(false);

		AddChoiceButton.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
		AddChoiceButton.setText("+");
		AddChoiceButton.addActionListener(evt -> AddChoiceButtonActionPerformed());
		AddChoiceButton.setEnabled(false);

		DeleteChoiceButton.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
		DeleteChoiceButton.setText("-");
		DeleteChoiceButton.addActionListener(evt -> DeleteChoiceButtonActionPerformed());
		DeleteChoiceButton.setEnabled(false);

		ChoiceHelperLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		ChoiceHelperLabel.setText("<html>Please highlight the correct choice from the list before submitting</html>");

		SubmitButton.setText("Submit");
		SubmitButton.addActionListener(evt -> SubmitButtonActionPerformed());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(MainQuestionInputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(QuestionHasFileLabel)
																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
																		.addComponent(NoFileRadioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addComponent(YesFileRadioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(ChooseFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addComponent(CreateMainQuestionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(SubQuestionSeparator)
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(SelectMainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(SelectFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(layout.createSequentialGroup()
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(MainQuestionSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
																						.addComponent(MainQuestionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(OrLabel)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(FileSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(FileScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
																.addGap(0, 0, Short.MAX_VALUE))
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addGroup(layout.createSequentialGroup()
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																								.addComponent(SubQuestionInputScrollPane)
																								.addComponent(SubQuestionInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																						.addComponent(ReasonInputLabel))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(SubQuestionTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(FillInBlankRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(ChoiceRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																						.addComponent(ChoiceScrollPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
																						.addComponent(FillInBlankInputTextField, javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(AnswerInputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																						.addComponent(ChoiceInputTextField, GroupLayout.Alignment.LEADING)))
																		.addGroup(layout.createSequentialGroup()
																				.addComponent(ReasonInputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(NotificationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(SubmitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addGroup(layout.createSequentialGroup()
																				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(AddChoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(DeleteChoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																				.addComponent(ChoiceHelperLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
												.addGap(11, 11, 11))))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(SelectMainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(SelectFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(FileScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(FileSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(OrLabel, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(MainQuestionScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(MainQuestionSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(CreateMainQuestionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(QuestionHasFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(12, 12, 12)
												.addComponent(NoFileRadioButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(YesFileRadioButton)
														.addComponent(ChooseFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(MainQuestionInputScrollPane))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(SubQuestionSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(SubQuestionInputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
										.addComponent(AnswerInputLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(SubQuestionTypeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(FillInBlankRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(layout.createSequentialGroup()
																.addComponent(FillInBlankInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																		.addComponent(ChoiceInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(ChoiceRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(AddChoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(ChoiceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(DeleteChoiceButton)))
														.addComponent(ChoiceHelperLabel))
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addGroup(layout.createSequentialGroup()
																.addGap(11, 11, 11)
																.addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(NotificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGroup(layout.createSequentialGroup()
												.addComponent(SubQuestionInputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(ReasonInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(ReasonInputScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(24, Short.MAX_VALUE))
		);

		pack();
		setLocationRelativeTo(null);
	}

	private void updateQuestionList() {
		DefaultListModel<String> fileModel = new DefaultListModel<>();
		DefaultListModel<String> questionModel = new DefaultListModel<>();
		String[] files = util.sqlQuery("SELECT DISTINCT File FROM Questions");
		String[] questions = util.sqlQuery("SELECT DISTINCT Question FROM Questions");

		for (String file : files) {
			fileModel.addElement(file);
		}
		FileList.setModel(fileModel);

		for (String question : questions) {
			questionModel.addElement(question);
		}
		MainQuestionList.setModel(questionModel);
	}

	private boolean printMessage(boolean isNotificationLabelBusy, String message, boolean isSuccess) {
		if (!isNotificationLabelBusy) {
			if (isSuccess) {
				NotificationLabel.setForeground(new Color(0, 0, 255));
			} else {
				NotificationLabel.setForeground(new Color(255, 0, 0));
			}

			NotificationLabel.setText(message);
		}

		return true;
	}

	private int getFreeQuestionId() {
		int i = 1;

		while (util.sqlQuery("SELECT QuestionId FROM Questions WHERE QuestionId=" + i).length != 0) {
			i++;
		}

		return i;
	}

	private boolean insertData(File file) {
		int questionId = getFreeQuestionId();
		String mainQuestion;
		String fileString;
		String subQuestion = SubQuestionInputTextArea.getText();
		String reason = ReasonInputTextArea.getText();
		String answer;
		String[] choices;

		if (MainQuestionInputTextArea.getText().isEmpty()) {
			mainQuestion = MainQuestionList.getSelectedValue();
			fileString = FileList.getSelectedValue();
		} else {
			mainQuestion = MainQuestionInputTextArea.getText();

			if (file != null) {
				fileString = file.getPath().split("/static/")[1];
			} else {
				fileString = "";
			}
		}

		if (FillInBlankRadioButton.isSelected()) {
			answer = FillInBlankInputTextField.getText();
			choices = null;
		} else if (ChoiceRadioButton.isSelected()) {
			answer = ChoiceList.getSelectedValue();
			Object[] temp = ChoiceListModel.toArray();
			ArrayList<String> l = new ArrayList<>();

			for (Object aTemp : temp) {
				l.add(aTemp.toString());
			}

			choices = l.toArray(new String[l.size()]);
		} else {
			return false;
		}

		if (util.sqlUpdate("INSERT INTO Questions VALUES(" + questionId + ",'" + mainQuestion + "','" + fileString + "','" + subQuestion + "','" + answer + "','" + reason + "')")) {
			if (choices != null) {
				for (String choice : choices) {
					if (!util.sqlUpdate("INSERT INTO Choices VALUES(" + questionId + ",'" + choice + "')")) {
						util.sqlUpdate("DELETE FROM Questions WHERE QuestionId=" + questionId);
						util.sqlUpdate("DELETE FROM Choices WHERE QuestionId=" + questionId);
						return false;
					}
				}
			}

			return true;
		} else {
			return false;
		}
	}

	private void FileRadioButtonActionPerformed() {
		if (YesFileRadioButton.isSelected()) {
			ChooseFileButton.setEnabled(true);
		} else if (NoFileRadioButton.isSelected()) {
			ChooseFileButton.setEnabled(false);
		}
	}

	private void QuestionTypeRadioButtonActionPerformed() {
		if (FillInBlankRadioButton.isSelected()) {
			FillInBlankInputTextField.setEnabled(true);
			ChoiceInputTextField.setEnabled(false);
			ChoiceList.setEnabled(false);
			AddChoiceButton.setEnabled(false);
			DeleteChoiceButton.setEnabled(false);
		} else if (ChoiceRadioButton.isSelected()) {
			FillInBlankInputTextField.setEnabled(false);
			ChoiceInputTextField.setEnabled(true);
			ChoiceList.setEnabled(true);
			AddChoiceButton.setEnabled(true);
			DeleteChoiceButton.setEnabled(true);
		}
	}

	private void ChooseFileButtonActionPerformed() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			ChosenFile = fileChooser.getSelectedFile();
			ChooseFileButton.setText(fileChooser.getSelectedFile().getName());
		}
	}

	private void AddChoiceButtonActionPerformed() {
		ChoiceListModel.addElement(ChoiceInputTextField.getText());
		ChoiceList.setModel(ChoiceListModel);
	}

	private void DeleteChoiceButtonActionPerformed() {
		if (ChoiceListModel.getSize() > 0) {
			ChoiceListModel.remove(ChoiceListModel.getSize() - 1);
			ChoiceList.setModel(ChoiceListModel);
		}
	}

	@SuppressWarnings("UnusedAssignment")
	private void SubmitButtonActionPerformed() {
		boolean isNotificationLabelBusy = false;
		boolean isMainQuestionInputted = false;
		boolean isAnswerInputted = false;

		if ((MainQuestionList.getSelectedIndex() >= 0 && FileList.getSelectedIndex() >= 0) || (!MainQuestionInputTextArea.getText().isEmpty() && ChosenFile.isFile())) {
			isMainQuestionInputted = true;
		}

		if (FillInBlankRadioButton.isSelected() && !FillInBlankInputTextField.getText().isEmpty()) {
			isAnswerInputted = true;
		}

		if (ChoiceRadioButton.isSelected() && ChoiceListModel.getSize() > 1) {
			if (ChoiceList.getSelectedIndex() >= 0) {
				isAnswerInputted = true;
			} else {
				isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Please select a choice as answer", false);
			}
		}

		if (isAnswerInputted && isMainQuestionInputted && !SubQuestionInputTextArea.getText().isEmpty()) {
			if (YesFileRadioButton.isSelected()) {
				File file;

				try {
					File destination = new File("./static/" + Files.probeContentType(ChosenFile.toPath()));

					if (!Files.exists(destination.toPath())) {
						Files.createDirectories(destination.toPath());
					}

					file = new File(destination.getAbsolutePath() + "/" + ChosenFile.getName());
					Files.copy(
							ChosenFile.toPath(),
							file.toPath(),
							java.nio.file.StandardCopyOption.REPLACE_EXISTING,
							java.nio.file.StandardCopyOption.COPY_ATTRIBUTES,
							java.nio.file.LinkOption.NOFOLLOW_LINKS
					);

					if (insertData(file)) {
						isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Added Question to Database Successfully", true);
						updateQuestionList();
					} else {
						isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Error Adding Question", false);
					}
				} catch (IOException e) {
					isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Error copying file", false);
					e.printStackTrace();
				}
			} else {
				if (insertData(null)) {
					isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Added Question to Database Successfully", true);
					updateQuestionList();
				} else {
					isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Error Adding Question", false);
				}
			}
		} else {
			isNotificationLabelBusy = printMessage(isNotificationLabelBusy, "Please input all required fields", false);
		}
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
			java.util.logging.Logger.getLogger(AddQuestionUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

        /* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> new AddQuestionUI().setVisible(true));
	}

	private javax.swing.JButton AddChoiceButton;
	private javax.swing.JLabel AnswerInputLabel;
	private javax.swing.JLabel ChoiceHelperLabel;
	private javax.swing.JTextField ChoiceInputTextField;
	private javax.swing.JList<String> ChoiceList;
	private javax.swing.DefaultListModel<String> ChoiceListModel;
	private javax.swing.JRadioButton ChoiceRadioButton;
	private javax.swing.JScrollPane ChoiceScrollPane;
	private javax.swing.JButton ChooseFileButton;
	private File ChosenFile;
	private javax.swing.JLabel CreateMainQuestionLabel;
	private javax.swing.JButton DeleteChoiceButton;
	private javax.swing.JList<String> FileList;
	private javax.swing.ButtonGroup FileRadioButtonGroup;
	private java.awt.event.ActionListener FileRadioButtonListener;
	private javax.swing.JScrollPane FileScrollPane;
	private javax.swing.JSeparator FileSeparator;
	private javax.swing.JTextField FillInBlankInputTextField;
	private javax.swing.JRadioButton FillInBlankRadioButton;
	private javax.swing.JScrollPane MainQuestionInputScrollPane;
	private javax.swing.JTextArea MainQuestionInputTextArea;
	private javax.swing.JList<String> MainQuestionList;
	private javax.swing.JScrollPane MainQuestionScrollPane;
	private javax.swing.JSeparator MainQuestionSeparator;
	private javax.swing.JRadioButton NoFileRadioButton;
	private javax.swing.JLabel NotificationLabel;
	private javax.swing.JLabel OrLabel;
	private javax.swing.JLabel QuestionHasFileLabel;
	private javax.swing.ButtonGroup QuestionTypeRadioButtonGroup;
	private java.awt.event.ActionListener QuestionTypeRadioButtonListener;
	private javax.swing.JLabel ReasonInputLabel;
	private javax.swing.JScrollPane ReasonInputScrollPane;
	private javax.swing.JTextArea ReasonInputTextArea;
	private javax.swing.JLabel SelectFileLabel;
	private javax.swing.JLabel SelectMainQuestionLabel;
	private javax.swing.JLabel SubQuestionInputLabel;
	private javax.swing.JScrollPane SubQuestionInputScrollPane;
	private javax.swing.JTextArea SubQuestionInputTextArea;
	private javax.swing.JSeparator SubQuestionSeparator;
	private javax.swing.JLabel SubQuestionTypeLabel;
	private javax.swing.JButton SubmitButton;
	private javax.swing.JRadioButton YesFileRadioButton;
}
