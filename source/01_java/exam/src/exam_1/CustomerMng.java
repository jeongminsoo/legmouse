package exam_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener{

	private Container contenPane;
	private JPanel jpup;
	private JPanel jpdown;
	private JTextField txtPhone;
	private JTextField txtName;
	private JTextField txtPoint;
	private JButton btnJoin;
	private JButton btnSearch;
	private JButton btnOutput;
	private JButton btnExit;
	private JTextArea jta;
	private JScrollPane scrollPane;
	
	private ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();;
	private CustomerDao dao = CustomerDao.getInstance();
	
	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel();
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);
		
		jpup.add(new JLabel("폰번호", (int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이  름", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpdown);
		contenPane.add(scrollPane);
		
		setVisible(true);
		setSize(400, 450);
		setLocation(200, 100);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnJoin) {  //  가입
			
			int point;
			
			try {
				point = Integer.parseInt(txtPoint.getText().trim());
				String phone = txtPhone.getText().trim();
				String name = txtName.getText().trim();
				
				if (phone.equals("") || name.equals("")) {
					jta.setText("폰번호, 이름을 입력해주세요");
					return;
				}

				if (phone.length() != 13 || phone.lastIndexOf('-') == -1) {
					jta.setText("폰번호는 010-0000-0000 형식으로 입력해주세요");
					return;
				}
				
				int result = dao.join(phone, name, point);
				
				jta.setText(result == CustomerDao.SUCCESS ? name + "님 가입성공" : "이미 동일한 폰번호로 가입된 고객이 있습니다");

			} catch (Exception e1) {
				jta.setText("유효하지 않은 포인트값 입니다.");
			}
			
		} else if (e.getSource() == btnSearch) { // 폰조회
			
			String phone = txtPhone.getText().trim();
			
			if (phone.equals("")) {
				jta.setText("폰번호를 입력해주세요");
				txtName.setText("");
				txtPoint.setText("");
				return;
			}
			
			customers = dao.searchphone(phone);
			
			if (customers.isEmpty()) {
				txtName.setText("");
				txtPoint.setText("");
				jta.setText("해당 폰번호의 고객은 존재하지 않습니다.");
			} else if (customers.size() > 1){
				txtName.setText("");
				txtPoint.setText("");
				jta.setText("폰번호\t\t이름\t포인트\n");
				for(CustomerDto cus : customers) {
					jta.append(cus.toString());
				}
			} else {
				jta.setText("폰번호 조회 완료");
				txtPhone.setText(customers.get(0).getPhone());
				txtName.setText(customers.get(0).getName());
				txtPoint.setText(String.valueOf(customers.get(0).getPoint()));
				
			}

		} else if (e.getSource() == btnOutput) { // 출력
			
			customers = dao.outputAll();
			
			if (customers.isEmpty()) {
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("");
				jta.setText("가입된 고객이 없습니다");
			} else {
				txtPhone.setText("");
				txtName.setText("");
				txtPoint.setText("");
				jta.setText("폰번호\t\t이름\t포인트\n");
				for(CustomerDto cus : customers) {
					jta.append(cus.toString());
				}
			}
			
		} else if (e.getSource() == btnExit) {  // 종료
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}
