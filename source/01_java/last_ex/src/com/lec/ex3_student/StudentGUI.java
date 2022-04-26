package com.lec.ex3_student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class StudentGUI extends JFrame implements ActionListener {

	private Container contanPane;
	private JPanel jp1;
	private JPanel jp2;
	private JTextField txtSNo;
	private JTextField txtSName;
	private JTextField txtScore;
	private JComboBox<String> comMName;
	private JButton btnSNo;
	private JButton btnSName;
	private JButton btnMName;
	private JButton btnInsert;
	private JButton btnUpdate;
	private JButton btnStudentAll;
	private JButton btnExpelAll;
	private JButton btnExpel;
	private JButton btnExit;
	private JScrollPane scrollPane;
	private JTextArea jta;

	private Vector<String> major;
	private StudentDao dao = StudentDao.getInstance();
	private StudentDto dto;
	private ArrayList<StudentDto> student;

	public StudentGUI(String title) {
		super(title);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contanPane = getContentPane();
		contanPane.setLayout(new FlowLayout());
		jp1 = new JPanel(new GridLayout(4, 3));
		jp2 = new JPanel(new GridLayout(1, 6));
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		txtScore = new JTextField(10);
		major = dao.majorList();
		comMName = new JComboBox<String>(major);
		btnSNo = new JButton("학번검색");
		btnSName = new JButton("이름검색");
		btnMName = new JButton("전공검색");
		btnInsert = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentAll = new JButton("학생출력");
		btnExpelAll = new JButton("제적자출력");
		btnExpel = new JButton("제적처리");
		btnExit = new JButton("종료");
		jta = new JTextArea(10, 50);
		scrollPane = new JScrollPane(jta);

		jp1.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
		jp1.add(txtSNo);
		jp1.add(btnSNo);
		jp1.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jp1.add(txtSName);
		jp1.add(btnSName);
		jp1.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
		jp1.add(comMName);
		jp1.add(btnMName);
		jp1.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
		jp1.add(txtScore);

		jp2.add(btnInsert);
		jp2.add(btnUpdate);
		jp2.add(btnStudentAll);
		jp2.add(btnExpelAll);
		jp2.add(btnExpel);
		jp2.add(btnExit);

		contanPane.add(jp1);
		contanPane.add(jp2);
		contanPane.add(scrollPane);

		setSize(new Dimension(700, 450));
		setVisible(true);
		setLocation(200, 100);

		btnSNo.addActionListener(this);
		btnSName.addActionListener(this);
		btnMName.addActionListener(this);
		btnInsert.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentAll.addActionListener(this);
		btnExpelAll.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSNo) {
			String snoStr = txtSNo.getText().toString().trim();

			if (snoStr.equals("")) {
				jta.setText("학번을 입력해주세요");
				txtSName.setText("");
				txtScore.setText("");
				comMName.setSelectedItem("");
				return;
			}

			int sno = Integer.parseInt(snoStr);
			dto = dao.selectSno(sno);
			if (dto != null) {
				txtSName.setText(dto.getsName());
				comMName.setSelectedItem(dto.getmName());
				txtScore.setText(String.valueOf(dto.getScore()));
				jta.setText(sno + "번 검색완료");
			} else {
				jta.setText("해당 학번의 학생은 존재하지 않습니다");
			}
		} else if (e.getSource() == btnSName) {
			String sName = txtSName.getText().toString().trim();

			if (sName.length() == 0) {
				jta.setText("이름을 입력해주세요");
				txtSNo.setText("");
				txtScore.setText("");
				comMName.setSelectedItem("");
				return;
			}
			student = dao.selectSName(sName);

			if (student.isEmpty()) {
				jta.setText("");
				jta.setText("해당 이름의 학생은 존재하지않습니다");
			} else {
				if (student.size() == 1) {
					txtSNo.setText(String.valueOf(student.get(0).getSno()));
					comMName.setSelectedItem(student.get(0).getmName());
					txtScore.setText(String.valueOf(student.get(0).getScore()));
					jta.setText(sName + "학생 검색 완료");
				} else if (student.size() > 1) {
					jta.setText("\t" + "학번" + "\t" + "이름" + "\t" + "학과명" + "\t" + "점수" + "\n");
					jta.append("\t------------------------------------------------------------------------\n");
					for (StudentDto d : student) {
						jta.append("\t" + d);
					}
				}
			}

		} else if (e.getSource() == btnMName) {
			String mName = comMName.getSelectedItem().toString();

			if (mName.length() == 0) {
				jta.setText("전공을 선택해주세요");
			} else {
				student = dao.selectMName(mName);
				if (student.isEmpty()) {
					jta.setText(mName + " 소속 학생이 없습니다");
				} else {
					jta.setText("\t" + "등수" + "\t" + "이름" + "\t\t" + "학과명" + "\t" + "점수" + "\n");
					jta.append("\t------------------------------------------------------------------------\n");
					for (StudentDto d : student) {
						jta.append("\t" + d);
					}
				}
			}

		} else if (e.getSource() == btnInsert) {
			String sName = txtSName.getText().toString().trim();
			String mName = comMName.getSelectedItem().toString();
			String scoreStr = txtScore.getText().toString().trim();
			
			if (sName.length() == 0 || mName.length() == 0 || scoreStr.length() == 0) {
				jta.setText("이름, 전공, 점수 세가지 모두 입력해주세요");
				return;
			}
			
			int score = Integer.parseInt(scoreStr);
			
			dto = new StudentDto(sName, mName, score);
			int result = dao.insertStudent(dto);
			jta.setText("");
			jta.append(result == StudentDao.SUCCESS ? "입력성공" : "입력실패");

		} else if (e.getSource() == btnUpdate) {
			String snoStr = txtSNo.getText().toString().trim();
			String sName = txtSName.getText().toString().trim();
			String mName = comMName.getSelectedItem().toString();
			String scoreStr = txtScore.getText().toString().trim();
			
			if (snoStr.length() == 0 || sName.length() == 0 || mName.length() == 0 || scoreStr.length() == 0 || snoStr.length() != 7) {
				jta.setText("학번, 이름, 전공, 점수를 다시 확인해주세요");
				return;
			}
			
			int sno = Integer.parseInt(snoStr);
			int score = Integer.parseInt(scoreStr);
			if (score < 0 || score > 100) {
				jta.setText("점수를 다시 확인해주세요");
				return;
			}
			dto = new StudentDto(sno, sName, mName, score);
			
			int result = dao.updateStudent(dto);
			jta.setText(result == StudentDao.SUCCESS ? "수정 완료" : "수정 실패");
			
		} else if (e.getSource() == btnStudentAll) {
			student = dao.selectAll();
			if (student.isEmpty()) {
				jta.setText("재학중인 학생이 없습니다");
				return;
			} else {
				jta.setText("\t" + "등수" + "\t" + "이름" + "\t\t" + "학과명" + "\t" + "점수" + "\n");
				jta.append("\t----------------------------------------------------------------------------------------------\n");
				for (StudentDto d : student) {
					jta.append("\t" + d);
				}
			}
		} else if (e.getSource() == btnExpelAll) {
			student = dao.selectExpel();
			if (student.isEmpty()) {
				jta.setText("제적자가 없습니다");
				return;
			} else {
				jta.setText("\t" + "등수" + "\t" + "이름" + "\t\t" + "학과명" + "\t" + "점수" + "\n");
				jta.append("\t----------------------------------------------------------------------------------------------\n");
				for (StudentDto d : student) {
					jta.append("\t" + d);
				}
			}
		} else if (e.getSource() == btnExpel) {
			String snoStr = txtSNo.getText().toString().trim();
			
			if (snoStr.length() == 0 || snoStr.length() != 7) {
				jta.setText("학번을 다시 확인해주세요");
				return;
			}
			
			int sno = Integer.parseInt(snoStr);
			int result = dao.updateExpel(sno);
			
			dto = dao.selectSno(sno);
			if (dto == null) {
				jta.setText("없는 학번입니다");
				return;
			}
			jta.setText(result == StudentDao.SUCCESS ? "제적처리완료" : "제적처리실패");

		} else if (e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentGUI("학사관리");
		
	}
}
