package com.lec.ex4_supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerGUI extends JFrame implements ActionListener{

	private Container contanPane;
	private JPanel jp1;
	private JPanel jp2;
	private JButton btnId;
	private JButton btnTel;
	private JButton btnName;
	private JButton btnBuyPoint;
	private JButton btnBuy;
	private JButton btnLvOut;
	private JButton btnAllOut;
	private JButton btnInsert;
	private JButton btnUpdateTel;
	private JButton btnDelete;
	private JButton btnExit;
	private JComboBox<String> comLevel;
	private JTextField txtId;
	private JTextField txtTel;
	private JTextField txtName;
	private JTextField txtPoint;
	private JTextField txtAmount;
	private JTextArea jta;
	private JScrollPane scrollPane;
	
	private Vector<String> levels;
	private CustomerDao dao = CustomerDao.getIntance();
	private CustomerDto dto;
	private ArrayList<CustomerDto> customers;
	
	public CustomerGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contanPane = getContentPane();
		contanPane.setLayout(new FlowLayout());
		jp1 = new JPanel(new GridLayout(6, 3));
		jp2 = new JPanel();
		
		btnId = new JButton("아이디 검색");
		btnTel = new JButton("폰4자리(FULL) 검색");
		btnName = new JButton("고객 이름 검색");
		btnBuyPoint = new JButton("포인트로만 구매");
		btnBuy = new JButton("물품 구매");
		btnLvOut = new JButton("등급별출력");
		btnAllOut = new JButton("전체출력");
		btnInsert = new JButton("회원가입");
		btnUpdateTel = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		levels = dao.levelList();
		comLevel = new JComboBox<String>(levels);
		txtId = new JTextField(20);
		txtTel = new JTextField(20);
		txtName = new JTextField(20);
		txtPoint = new JTextField(20);
		txtAmount = new JTextField(20);
		
		jta = new JTextArea(10, 80);
		scrollPane = new JScrollPane(jta);
		
		jp1.add(new JLabel("아이디", (int) CENTER_ALIGNMENT));
		jp1.add(txtId);
		jp1.add(btnId);
		jp1.add(new JLabel("고객 전화", (int) CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(btnTel);
		jp1.add(new JLabel("고객 이름", (int) CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(btnName);
		jp1.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jp1.add(txtPoint);
		jp1.add(btnBuyPoint);
		jp1.add(new JLabel("구매 금액", (int) CENTER_ALIGNMENT));
		jp1.add(txtAmount);
		jp1.add(new JLabel());
		jp1.add(new JLabel("고객 등급", (int) CENTER_ALIGNMENT));
		jp1.add(comLevel);
		jp1.add(new JLabel());
		
		jp2.add(btnBuy);
		jp2.add(btnLvOut);
		jp2.add(btnAllOut);
		jp2.add(btnInsert);
		jp2.add(btnUpdateTel);
		jp2.add(btnDelete);
		jp2.add(btnExit);
		
		contanPane.add(jp1);
		contanPane.add(jp2);
		contanPane.add(scrollPane);
		
		setSize(new Dimension(1000, 500));
		setVisible(true);
		setLocation(200, 100);
		jta.setText("\t★ ★ ★ 고객 검색 후 구매하세요 ★ ★ ★");
		
		btnId.addActionListener(this);
		btnTel.addActionListener(this);
		btnName.addActionListener(this);
		btnBuyPoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLvOut.addActionListener(this);
		btnAllOut.addActionListener(this);
		btnInsert.addActionListener(this);
		btnUpdateTel.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnId) {  // ID 검색
			int id;
			try {
				id = Integer.parseInt(txtId.getText().trim());
			} catch (Exception e1) {
				jta.setText("유효하지 않는 아이디 입력 값입니다");
				return;
			}

			dto = dao.selectCid(id);
			
			if (dto == null) {
				jta.setText("검색되지 않은 ID입니다");
				txtTel.setText("");
				txtName.setText("");
				txtPoint.setText("");
				txtAmount.setText("");
				comLevel.setSelectedItem("");
			} else {
				txtTel.setText(dto.getcTel());
				txtName.setText(dto.getcName());
				txtPoint.setText(String.valueOf(dto.getcPoint()));
				comLevel.setSelectedItem(dto.getLevelName());
				jta.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jta.append("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				jta.append(dto.toString());
			}
			
		} else if (e.getSource() == btnTel) {  // 전화번호 검색
			String tel = txtTel.getText().trim();
			
			if (tel.equals("")) {
				jta.setText("전화번호를 입력하세요");
				return;
			}
			
			if (tel.length() < 4) {
				jta.setText("적어도 4자리 이상 입력하세요");
				return;
			}
			
			customers = dao.selectTel(tel);
			
			if (customers.isEmpty()) {
				jta.setText("해당 전화번호로 가입된 고객이 없습니다");
				txtId.setText("");
				txtName.setText("");
				txtPoint.setText("");
				txtAmount.setText("");
				comLevel.setSelectedItem("");
			} else {
				txtId.setText(String.valueOf(customers.get(0).getcId()));
				txtTel.setText(customers.get(0).getcTel());
				txtName.setText(customers.get(0).getcName());
				txtPoint.setText(String.valueOf(customers.get(0).getcPoint()));
				comLevel.setSelectedItem(customers.get(0).getLevelName());
				jta.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jta.append("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
			}
			
		} else if (e.getSource() == btnName) {  // 이름검색
			String name = txtName.getText().trim();
			
			if (name.equals("")) {
				jta.setText("이름을 입력하세요");
				return;
			}
			
			customers = dao.selectCName(name);
			
			if (customers.isEmpty()) {
				jta.setText("해당 이름으로 가입된 고객이 없습니다");
				txtId.setText("");
				txtTel.setText("");
				txtPoint.setText("");
				txtAmount.setText("");
				comLevel.setSelectedItem("");
			} else {
				txtId.setText(String.valueOf(customers.get(0).getcId()));
				txtTel.setText(customers.get(0).getcTel());
				txtPoint.setText(String.valueOf(customers.get(0).getcPoint()));
				comLevel.setSelectedItem(customers.get(0).getLevelName());
				jta.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jta.append("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
			}
			
		} else if (e.getSource() == btnBuyPoint) {  // 포인트로만 구매
			int id;
			int point;
			int amount;
			try {
				
				id = Integer.parseInt(txtId.getText().trim());
				point = Integer.parseInt(txtPoint.getText().trim());
				amount = Integer.parseInt(txtAmount.getText().trim());
				
				if (point < 0 || amount < 0) {
					jta.setText("0보다 큰 값을 입력하세요");
					return;
				}
				
				if (amount > point) {
					jta.setText("포인트가 부족하여 포인트로 구매가 불가합니다");
				} else {
					int result = dao.updatePoint(id, amount);
					jta.setText(result == CustomerDao.SUCCESS ? "포인트로만 구매 성공" : "구매 실패");
					txtPoint.setText(String.valueOf(point - amount));
					txtAmount.setText("");
				}
				
			} catch (Exception e1) {
				jta.setText("유효한 아이디, 포인트, 구매금액을 입력하세요");
				return;
			}

		} else if (e.getSource() == btnBuy) {  // 물품구매
			int id;
			int point;
			int amount;
			try {
				
				id = Integer.parseInt(txtId.getText().trim());
				point = Integer.parseInt(txtPoint.getText().trim());
				amount = Integer.parseInt(txtAmount.getText().trim());
				
				if (amount < 0) {
					jta.setText("0보다 큰 값을 입력하세요");
					return;
				}
				int result = dao.updateBuy(id, amount);
				jta.setText(result == CustomerDao.SUCCESS ? "물품 구매 및 고객 정보 업데이트 성공" : "구매 실패");
				txtPoint.setText(String.valueOf(point + (int)(amount * 0.05)));
				txtAmount.setText("");
			} catch (Exception e1) {
				jta.setText("유효한 아이디, 포인트, 구매금액을 입력하세요");
				return;
			}		
			
		} else if (e.getSource() == btnLvOut) { // 등급별 출력
			String levelName = comLevel.getSelectedItem().toString();
			
			if (levelName.equals("")) {
				jta.setText("고객 등급을 선택하세요");
				return;
			}
			customers = dao.selectLevel(levelName);
			
			if (customers.isEmpty()) {
				jta.setText("해당 등급의 고객이 없습니다");
			} else {
				jta.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jta.append("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
			}
			
		} else if (e.getSource() == btnAllOut) {  // 전체 출력
			customers = dao.selectAll();
			if (customers.isEmpty()) {
				jta.setText("가입된 고객이 없습니다");
			} else {
				jta.setText("ID\t전화\t\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위한 추가 구매할 금액\n");
				jta.append("――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――――\n");
				for (CustomerDto d : customers) {
					jta.append(d.toString());
				}
				jta.append("총 " + customers.size() + "명");
			}
		} else if (e.getSource() == btnInsert) {  // 회원가입
			String tel = txtTel.getText().trim();
			String name = txtName.getText().trim();
			
			if (tel.equals("") || name.equals("")) {
				jta.setText("전화번호 또는 이름을 입력하세요");
				return;
			}
			
			if (tel.length() != 13) {
				jta.setText("전화번호 입력시 010-0000-0000 의 형식으로 입력하세요");
				return;
			}
			
			int result = dao.insertCustomer(tel, name);
			jta.setText(result == CustomerDao.SUCCESS ? "회원가입 감사합니다. 포인트 1000점을 회원가입선물로 드립니다" : "가입 실패");			
	
		} else if (e.getSource() == btnUpdateTel) {  // 번호 수정
			int id;
			try {
				id = Integer.parseInt(txtId.getText().trim());
			} catch (Exception e1) {
				jta.setText("유효하지 않는 아이디 입력 값입니다");
				return;
			}
			String tel = txtTel.getText().trim();
			
			if (tel.equals("")) {
				jta.setText("ID, 전화번호를 입력하세요");
				return;
			}
			
			if (tel.length() != 13) {
				jta.setText("전화번호 입력시 010-0000-0000 의 형식으로 입력하세요");
				return;
			}
			
			int result = dao.updateTel(tel, id);
			jta.setText(result == CustomerDao.SUCCESS ? "전화번호가 수정되었습니다" : "수정 실패");

		} else if (e.getSource() == btnDelete) {  // 회원 탈퇴
			String tel = txtTel.getText().trim();
			
			if (tel.equals("")) {
				jta.setText("전화번호를 입력하세요");
				return;
			}
			
			if (tel.length() != 13) {
				jta.setText("전화번호 입력시 010-0000-0000 의 형식으로 입력하세요");
				return;
			}
			
			int result = dao.deleteCustomer(tel);
			jta.setText(result == CustomerDao.SUCCESS ? tel + "님의 회원탈퇴가 완료되었습니다" : "회원탈퇴 실패");
			
		} else if (e.getSource() == btnExit) {  // 나가기
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerGUI("슈퍼마켓 관리");
	}
}
