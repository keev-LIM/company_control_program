import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;

/** Counter with JRadioButton and JComboBox */
@SuppressWarnings("serial")
public class SuperFrame extends JFrame implements ActionListener, Runnable {
	/////////////////////////////////////
	JButton[] TaButton = new JButton[4];
	JButton[] TaButton2 = new JButton[2];
	JButton[] PrButton = new JButton[5];
	JButton[] AdButton = new JButton[2];
	JButton[] AcButton = new JButton[3];
	JButton[] MoButton = new JButton[2];
	String Account = "";
	JLabel[] label = new JLabel[7];
	// Project
	JTextField[] PrTx = new JTextField[7];
	JTextField[] PrTx2 = new JTextField[4];
	JTextArea Pr_area = new JTextArea();
	JTextArea Ad_area = new JTextArea();
	JScrollPane Pr_scroll = new JScrollPane(Pr_area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JTextArea Ta_area = new JTextArea();
	JScrollPane Ta_scroll = new JScrollPane(Ta_area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextArea Ta_area2 = new JTextArea();
	JScrollPane Ta_scroll2 = new JScrollPane(Ta_area2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextArea anarea = new JTextArea();
	JScrollPane anscroll = new JScrollPane(anarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextArea hjarea = new JTextArea();
	JScrollPane hjscroll = new JScrollPane(hjarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextArea moarea = new JTextArea();
	JScrollPane moscroll = new JScrollPane(moarea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel gridproject = new JPanel(new GridLayout(1, 4, 30, 0));
	JPanel gridmo = new JPanel(new GridLayout(1, 2, 30, 0));
	JPanel gridTask = new JPanel(new GridLayout(1, 6, 30, 0));
	int[] prcheck = new int[7];
	int[] prcheck2 = new int[4];
	int[] tacheck = new int[2];
	//////
	//////////////////////////////////////
	JPanel init = new JPanel(new BorderLayout());
	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JButton[] button = new JButton[49];
	StringBuffer msg = new StringBuffer();
	StringBuffer msg2 = new StringBuffer();
	// 북, 남
	// 서쪽
	JButton Task = new JButton("업무처리");
	JButton Project = new JButton("프로젝트");
	JButton Admin = new JButton("관리");
	JButton announce = new JButton("공지사항");
	JButton money = new JButton("매출확인");
	JLabel ID = new JLabel("아이디 라벨");
	JLabel Present_time = new JLabel("hihi");
	ImageIcon iconCross = null;
	// JLabel label = new JLabel();
	JLabel Work = new JLabel("출퇴근 기록");
	JLabel Today_Plan = new JLabel("오늘의 일정");
	String ja_text = "hh";
	// String plan = JOptionPane.showInputDialog("일정을 추가하세요.");
	/// Scroll
	JTextArea ja = new JTextArea();
	JScrollPane jp = new JScrollPane(ja, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JTextArea ja2 = new JTextArea();
	JScrollPane jp2 = new JScrollPane(ja2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	//
	JButton hjcompany = new JButton("HJCompony");
	SimpleDateFormat format;
	Calendar time;
	String format_time;
	JPanel North;
	JPanel Center;
	JButton[] buttons;
	JPanel grid = new JPanel(new GridLayout(4, 1, 0, 0));
	JPanel gridan = new JPanel(new GridLayout(1, 3, 50, 0));
	Box workbox = Box.createVerticalBox();
	/// 출퇴근
	// JPanel p3 = new JPanel(new GridLayout(1,3,5,0));
	JPanel p3 = new JPanel(new FlowLayout());
	JButton Gotowork = new JButton("출근");
	JLabel Worktime = new JLabel("총 일한 시간", JLabel.CENTER);
	JButton Backtowork = new JButton("퇴근");
	JButton DeleteA = new JButton("오늘일정삭제");
	JButton DeleteB = new JButton("출근기록삭제");

	public SuperFrame() throws IOException {

		// Calendar
		new Thread(this).start();
		synchronized(this) {
		////////
		// JPanel North = new JPanel(new GridLayout(1,3,100,0));
		North = new JPanel(new GridLayout(1, 3, 230, 50));
		// North.hGap(40);
		// North.setBorder(BorderFactory.createTitledBorder("Horizontal Alignment"));
		JPanel South = new JPanel(new GridLayout(1, 3));
		South.setBorder(BorderFactory.createTitledBorder("Vertical Alignment"));
		JPanel West = new JPanel(new GridLayout(5, 1, 0, 30));
		Box East = Box.createVerticalBox();
		//////////////////////////
		System.out.println(LoginFrame.getID());
		System.out.println(LoginFrame.getNumber());
		ID.setText(LoginFrame.getID() + "님 환영합니다.");
		ID.setForeground(Color.yellow);
		ID.setFont(new Font("맑은고딕", Font.BOLD, 15));
		ID.setAlignmentX(RIGHT_ALIGNMENT);
		ID.setSize(200, 20);
		ID.setLocation(0, 10);

		// ID.setBounds(450, 20, 100, 100);
		Center = new JPanel(new FlowLayout());
////////////////////////////Top
		/////////////////////////////////////
		// 해야하는곳
		JLabel anLabel = new JLabel("공지사항");
		anLabel.setForeground(Color.white);
		anLabel.setFont(new Font("맑은고딕", Font.BOLD, 50));
		//////////////////////////////////////////////////////////////
		Center.removeAll();
		Center.revalidate();
		Center.repaint();
		Center.add(anLabel);
		Center.add(hjscroll);
		Center.setBackground(Color.black);
		hjarea.setEditable(true);
		hjarea.setLineWrap(true);
		hjarea.setBackground(Color.black);
		hjarea.setForeground(Color.white);
		hjarea.setText("");
		hjarea.setFont(new Font("맑은고딕", Font.BOLD, 15));
		hjscroll.setPreferredSize(new Dimension(1000, 550));

		try {
			StringBuffer msg = new StringBuffer();
			Client.Client_send("35");// 셀렉트 (보고받을 모든 것 가져오기)
			Client.Client_receive();
			Client.Client_send("Give me a Count");// 셀렉트 (보고받을 모든 것 가져오기)
			String count2 = Client.Client_receive();
			System.out.println("프로젝트의 개수는? " + count2);
			String[] msgRC = new String[Integer.parseInt(count2)];
			Client.Client_send("34");
			Client.Client_receive();
			Client.Client_send("Give me a contents");
			// Client.Client_receive();
			for (int i = 0; i < Integer.parseInt(count2); i++) {
				msgRC[i] = Client.Client_receive();
				msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
			}
			for (int i = 0; i < Integer.parseInt(count2); i++) {
				msg.append(
						"--------------------------------------------------------------------------------------------------------\n");
				msg.append(msgRC[i] + "\n\n");
			}
			hjarea.setText(msg.toString());
		} catch (IOException e8) {
			// TODO Auto-generated catch block
			e8.printStackTrace();
		}

		/////////////////////////////////////
		// TODO
		JPanel Tapanel = new JPanel(new GridLayout(1, 5, 30, 20));
		JPanel panel = new JPanel(new GridLayout(14, 1, 20, 20));
		TaButton[0] = new JButton("보고 목록");
		TaButton[1] = new JButton("결재 및 반려");// 2015301065의 결재를 수락하고, 그 결재에 대한 피드백을 전송하는 란
		TaButton[2] = new JButton("출퇴근 목록");
		TaButton[3] = new JButton("다함께 채팅하기");
		
		for (int i = 0; i < 4; i++) {
			gridTask.add(TaButton[i]);
			TaButton[i].setBackground(Color.black);
			TaButton[i].setForeground(Color.white);
		}
		JLabel[] Ta_label = new JLabel[2];
		Ta_label[0] = new JLabel("사원번호");
		Ta_label[1] = new JLabel("레포트번호");
		JTextField TaTx[] = new JTextField[2];
		String[] ox = { "O", "X" };
		final JComboBox<String> ox_combo = new JComboBox<String>(ox);
		for (int i = 0; i < 2; i++) {// 텍스트 필드, 라벨 폰트 설정
			TaTx[i] = new JTextField(10);
			TaTx[i].setForeground(Color.RED);
			TaTx[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
			Ta_label[i].setFont(new Font("맑은고딕", Font.BOLD, 15));
			Ta_label[i].setForeground(Color.white);
			Tapanel.add(Ta_label[i]);
			Tapanel.add(TaTx[i]);
			/// TOTOOTOTOTOTODODODODDODODODO
			tacheck[i] = 0;
		}
		Tapanel.add(ox_combo);
		Tapanel.setBackground(Color.black);
		/*
		 * Task Data목록 number name what status contents1//이거는 결재 할 데이터 contents1//이거는
		 * 결재해 줄 데이터 reportNum
		 */
		Task.addActionListener(e -> {
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.setBackground(Color.black);
			// Center.add(Tapanel);
			Center.add(Ta_scroll);
			gridTask.setBackground(Color.black);
			Center.add(gridTask);
			Ta_area.setEditable(true);
			Ta_area.setLineWrap(true);
			Ta_area.setBackground(Color.black);
			Ta_area.setForeground(Color.white);
			Ta_area.setText("");
			Ta_area.setFont(new Font("맑은고딕", Font.BOLD, 15));
			Ta_scroll.setPreferredSize(new Dimension(1000, 550));
			try {
				Client.Client_send("27");// 셀렉트 (보고받을 모든 것 가져오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (보고받을 모든 것 가져오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("28");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				String[] msgRC = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
				}
				Client.Client_send("29");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n"
									+ msgR[i] + "\n\n");
					msg.append(msgRC[i] + "\n\n");
				}
				Ta_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			} // 서버와 소통
		});
		TaButton[0].addActionListener(e -> { // 보고목록
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.setBackground(Color.black);
			// Center.add(Tapanel);
			Center.add(Ta_scroll);
			gridTask.setBackground(Color.black);
			Center.add(gridTask);
			Ta_area.setEditable(false);
			Ta_area.setLineWrap(true);
			Ta_area.setBackground(Color.black);
			Ta_area.setForeground(Color.white);
			Ta_area.setText("");
			Ta_area.setFont(new Font("맑은고딕", Font.BOLD, 15));
			Ta_scroll.setPreferredSize(new Dimension(1000, 550));
			/// 서버랑 소통하자
			try {
				Client.Client_send("27");// 셀렉트 (보고받을 모든 것 가져오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (보고받을 모든 것 가져오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("28");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				String[] msgRC = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
				}
				Client.Client_send("29");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n"
									+ msgR[i] + "\n\n");
					msg.append(msgRC[i] + "\n\n");
				}
				Ta_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			} // 서버와 소통
				//////////////////////////////////////////////////////////////////
		});
		TaButton[1].addActionListener(e -> { // 결재하기(보고목록 + 추가로 제어)
			StringBuffer msg = new StringBuffer();
			JPanel Ta_scroll_grid = new JPanel(new GridLayout(1, 2, 0, 30));
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.setBackground(Color.black);
			Center.add(Tapanel);
			Ta_scroll_grid.add(Ta_scroll);
			Ta_scroll_grid.add(Ta_scroll2);
			Center.add(Ta_scroll_grid);
			gridTask.setBackground(Color.black);
			Center.add(gridTask);
			Ta_area.setEditable(false);
			Ta_area.setLineWrap(true);
			Ta_area.setBackground(Color.black);
			Ta_area.setForeground(Color.white);
			Ta_area.setFont(new Font("맑은고딕", Font.BOLD, 15));
			Ta_scroll.setPreferredSize(new Dimension(550, 520));
			Ta_area2.setEditable(true);
			Ta_area2.setLineWrap(true);
			Ta_area2.setBackground(Color.black);
			Ta_area2.setForeground(Color.white);
			Ta_area2.setFont(new Font("맑은고딕", Font.BOLD, 15));
			Ta_scroll.setPreferredSize(new Dimension(550, 520));
			//////////////////////////// 좌측 보고서 띄우기
			try {
				Client.Client_send("27");// 셀렉트 (보고받을 모든 것 가져오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (보고받을 모든 것 가져오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("28");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				String[] msgRC = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
				}
				Client.Client_send("29");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n"
									+ msgR[i] + "\n\n");
					msg.append(msgRC[i] + "\n\n");
				}
				Ta_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			} // 서버와 소통
//////////////////////////좌측 보고서 띄우기
			String ta_text = Ta_area2.getText();

			ta_text = ta_text.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			String alert = "";
			// pr_text = pr_text.replaceAll(System.getProperty("line.separator"), " ");
			for (int i = 0; i < 2; i++) {
				if (!TaTx[i].getText().equals("")) {
					tacheck[i] = 1;
				}
				if (tacheck[i] == 0)
					alert += Ta_label[i].getText() + " ";
			}
			if (Ta_area2.getText().equals(""))
				alert += "보고서 코멘트 내용" + " ";
			if (tacheck[0] == 1 && tacheck[1] == 1 && !Ta_area2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "첨삭에 성공했습니다.");
				try {// 클라이언트에서 서버로 보낼 부분
					Client.Client_send("30");// 서버와 소통 13을 통해
					Client.Client_receive();
					Client.Client_send(TaTx[0].getText());// 사원번호
					Client.Client_receive();
					Client.Client_send(TaTx[1].getText());// 레포트번호
					Client.Client_receive();
					Client.Client_send(ox_combo.getSelectedItem().toString());// What O/X
					Client.Client_receive();
					Client.Client_send(ta_text);// 텍스트 에어리어 -> 첨삭 내용
					Client.Client_receive();
					Ta_area2.setText("");
					for (int i = 0; i < 2; i++)
						TaTx[i].setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, alert + "을(를)을 입력해주세요");
			}

			for (int i = 0; i < 2; i++) {
				tacheck[i] = 0;
			}
			//////////////////////////////////////////////
		});
		TaButton[2].addActionListener(e -> {// 오늘의 출퇴근 기록
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.setBackground(Color.black);
			// Center.add(Tapanel);
			Center.add(Ta_scroll);
			gridTask.setBackground(Color.black);
			Center.add(gridTask);
			Ta_area.setEditable(true);
			Ta_area.setLineWrap(true);
			Ta_area.setBackground(Color.black);
			Ta_area.setForeground(Color.white);
			Ta_area.setText("");
			Ta_area.setFont(new Font("맑은고딕", Font.BOLD, 15));
			Ta_scroll.setPreferredSize(new Dimension(1000, 550));
			//////////////////////////////////////////////////////////////////////////////////////
			try {
				Client.Client_send("31");// 셀렉트 (사원 인원수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (사원 인원 수 받아오기)
				String count = Client.Client_receive();
				System.out.println("오늘 출퇴근 개수는? " + count);
				Client.Client_send("32");// 인원수 만큼 출력
				Client.Client_receive();
				Client.Client_send("Give me a 출퇴근 기록!");

				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(Client.Client_receive() + "\n");
				}
				Ta_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}

			/////////////////////////////////////////////////////////////////////////////////////
		});
		TaButton[3].addActionListener(e -> {
			new Chatting();
		});

		//////////// /////////////// ////////////////
		//////////// /////////////// ////////////////
		//////////// /////////////// ////////////////
		PrButton[0] = new JButton("프로젝트 생성");
		PrButton[1] = new JButton("블록 생성");
		PrButton[2] = new JButton("프로젝트 진행목록");
		PrButton[3] = new JButton("프로젝트 완료목록");
		PrButton[4] = new JButton("프로젝트 상태");
		gridproject.add(PrButton[0]);
		gridproject.add(PrButton[1]);
		gridproject.add(PrButton[2]);
		gridproject.add(PrButton[3]);
		gridproject.add(PrButton[4]);
		JLabel[] pr_label = new JLabel[7];
		JLabel[] pr_label2 = new JLabel[4];

		pr_label[0] = new JLabel("ProjectNum");
		pr_label[1] = new JLabel("year");
		pr_label[2] = new JLabel("month");
		pr_label[3] = new JLabel("day");
		pr_label[4] = new JLabel("level");
		pr_label[5] = new JLabel("money");
		pr_label[6] = new JLabel("status");
		JTextField PrTx[] = new JTextField[7];
		for (int i = 0; i < 7; i++) {// 텍스트 필드, 라벨 폰트 설정
			PrTx[i] = new JTextField(10);
			PrTx[i].setForeground(Color.RED);
			PrTx[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
			pr_label[i].setFont(new Font("맑은고딕", Font.BOLD, 15));
			pr_label[i].setForeground(Color.white);
			prcheck[i] = 0;
		}
		panel.add(pr_label[0]);
		panel.add(PrTx[0]);
		panel.add(pr_label[1]);
		panel.add(PrTx[1]);
		panel.add(pr_label[2]);
		panel.add(PrTx[2]);
		panel.add(pr_label[3]);
		panel.add(PrTx[3]);
		panel.add(pr_label[4]);
		panel.add(PrTx[4]);
		panel.add(pr_label[5]);
		panel.add(PrTx[5]);
		panel.add(pr_label[6]);
		panel.add(PrTx[6]);
		panel.setBackground(Color.black);

		/////////////////////////////// 프로젝트 구현부분
		for(int i = 0; i< 5;i++) {
			PrButton[i].setBackground(Color.black);
			PrButton[i].setForeground(Color.white);
		}
		Project.addActionListener(e -> {
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(Pr_scroll);
			gridproject.setBackground(Color.black);
			Center.add(gridproject);
			Center.setBackground(Color.black);
		});

		JPanel panel2 = new JPanel(new GridLayout(8, 1, 20, 20));
		Center.setBackground(Color.black);
		Pr_area.setEditable(true);
		Pr_area.setLineWrap(true);
		Pr_area.setBackground(Color.black);
		Pr_area.setForeground(Color.white);
		Pr_area.setText("");
		Pr_area.setFont(new Font("맑은고딕", Font.BOLD, 15));
		Pr_scroll.setPreferredSize(new Dimension(1000, 550));
		
		/////////////////////////////// ///////////////////////////////
		PrButton[0].addActionListener(e0 -> { // 프로젝트 생성
			System.out.println("Project 생성 버튼 ! : " + e0.getActionCommand());
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(panel);
			Center.add(Pr_scroll);
			gridproject.setBackground(Color.black);
			Center.add(gridproject);
			Pr_area.setEditable(true);
			String pr_text = Pr_area.getText();

			pr_text = pr_text.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			String alert = "";
			// pr_text = pr_text.replaceAll(System.getProperty("line.separator"), " ");
			for (int i = 0; i < 7; i++) {
				if (!PrTx[i].getText().equals("")) {
					prcheck[i] = 1;
				}
				if (prcheck[i] == 0)
					alert += pr_label[i].getText() + " ";
			}
			if (Pr_area.getText().equals(""))
				alert += "프로젝트 내용" + " ";
			if (prcheck[0] == 1 && prcheck[1] == 1 && prcheck[2] == 1 && prcheck[3] == 1 && prcheck[4] == 1
					&& prcheck[5] == 1 && prcheck[6] == 1 && !Pr_area.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "프로젝트 생성에 성공하셨습니다.");
				try {// 클라이언트에서 서버로 보낼 부분
					Client.Client_send("13");// 서버와 소통 13을 통해
					Client.Client_receive();
					Client.Client_send(PrTx[0].getText());
					Client.Client_receive();
					Client.Client_send(PrTx[1].getText());
					Client.Client_receive();
					Client.Client_send(PrTx[2].getText());
					Client.Client_receive();
					Client.Client_send(PrTx[3].getText());
					Client.Client_receive();
					Client.Client_send(PrTx[4].getText());
					Client.Client_receive();
					Client.Client_send(pr_text);// 텍스트 에어리어 -> 프로젝트 내용
					Client.Client_receive();
					Client.Client_send(PrTx[5].getText());
					Client.Client_receive();
					Client.Client_send(PrTx[6].getText());
					Client.Client_receive();
					Pr_area.setText("");
					for (int i = 0; i < 7; i++)
						PrTx[i].setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, alert + "을(를)을 입력해주세요");
			}

			for (int i = 0; i < 7; i++) {
				prcheck[i] = 0;
			}
			/*
			 * pr_text = pr_text.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			 * System.out.println(pr_text); pr_text = pr_text.replaceAll("<br>", "\n");
			 * System.out.print(pr_text); pr_text = pr_text.replaceAll("(\r\n|\r|\n|\n\r)",
			 * "<br>"); System.out.println(pr_text); pr_text = pr_text.replaceAll("<br>",
			 * "\n"); System.out.print(pr_text);
			 */
		});
		/////////////////////////////// ///////////////////////////////
		pr_label2[0] = new JLabel("ProjectNum");
		pr_label2[1] = new JLabel("blockNum");
		pr_label2[2] = new JLabel("money");
		pr_label2[3] = new JLabel("level");
		panel2.setBackground(Color.black);
		for (int i = 0; i < 4; i++) {// 텍스트 필드, 라벨 폰트 설정
			PrTx2[i] = new JTextField(10);
			PrTx2[i].setForeground(Color.RED);
			PrTx2[i].setBorder(javax.swing.BorderFactory.createEmptyBorder());
			pr_label2[i].setFont(new Font("맑은고딕", Font.BOLD, 15));
			pr_label2[i].setForeground(Color.white);
		}
		panel2.add(pr_label2[0]);
		panel2.add(PrTx2[0]);
		panel2.add(pr_label2[1]);
		panel2.add(PrTx2[1]);
		panel2.add(pr_label2[2]);
		panel2.add(PrTx2[2]);
		panel2.add(pr_label2[3]);
		panel2.add(PrTx2[3]);
		Pr_area.setText("");// 블록 : 프로젝트 넘버, 블록 넘버 블록 금액 블록내용
		// 오픈소스 프로그래밍 성취율 80%를 넘기셔야합니다.
		PrButton[1].addActionListener(e1 -> {// 블록생성
			System.out.println("Project 생성 버튼 ! : " + e1.getActionCommand());
			// Pr_area.setText("");//블록 : 프로젝트 넘버, 블록 넘버 블록 금액 블록내용

			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(panel2);
			Center.add(Pr_scroll);
			gridproject.setBackground(Color.black);
			Center.add(gridproject);
			String pr_text = Pr_area.getText();
			pr_text = pr_text.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			String alert = "";
			Pr_area.setEditable(true);
			// pr_text = pr_text.replaceAll(System.getProperty("line.separator"), " ");
			for (int i = 0; i < 4; i++) {
				if (!PrTx2[i].getText().equals("")) {
					prcheck2[i] = 1;
				}
				if (prcheck2[i] == 0)
					alert += pr_label2[i].getText() + " ";
			}
			if (Pr_area.getText().equals(""))
				alert += "블록 내용 ";
			if (prcheck2[0] == 1 && prcheck2[1] == 1 && prcheck2[2] == 1 && prcheck2[3] == 1&& !Pr_area.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "블록 생성에 성공하셨습니다.");
				try {// 클라이언트에서 서버로 보낼 부분
					Client.Client_send("14");// 서버와 소통 14을 통해
					Client.Client_receive();
					Client.Client_send(PrTx2[0].getText());
					Client.Client_receive();
					Client.Client_send(PrTx2[1].getText());
					Client.Client_receive();
					Client.Client_send(PrTx2[2].getText());
					Client.Client_receive();
					Client.Client_send(PrTx2[3].getText());
					Client.Client_receive();
					Client.Client_send(pr_text);// TextAreaBlock
					Client.Client_receive();
					Pr_area.setText("");
					for (int i = 0; i < 4; i++)
						PrTx2[i].setText("");
				} catch (IOException e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, alert + "을(를)을 입력해주세요");
			}
			for (int i = 0; i < 4; i++) {
				prcheck2[i] = 0;
			}
		});
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		PrButton[2].addActionListener(e2 -> {
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(Pr_scroll);
			gridproject.setBackground(Color.black);
			Center.add(gridproject);
			Pr_area.setText("");
			Pr_area.setEditable(false);
			// 메세지
			try {
				Client.Client_send("18");// 셀렉트 (프로젝트 개수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (프로젝트 개수 받아오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("19");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				String[] msgRC = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
					// msg.append(Client.Client_receive()+"\n");
				}
				Client.Client_send("20");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n"
									+ msgR[i] + "\n\n");
					msg.append(msgRC[i] + "\n\n");
				}
				Pr_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			} // 서버와 소통 14을 통해

		});
		/////////////////////////////////////////////////////////////////////////////////
		PrButton[3].addActionListener(e3 -> {
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(Pr_scroll);
			gridproject.setBackground(Color.black);
			Center.add(gridproject);
			Pr_area.setText("");
			Pr_area.setEditable(false);
			// 메세지
			try {
				Client.Client_send("21");// 셀렉트 (프로젝트 개수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (프로젝트 개수 받아오기)
				String count = Client.Client_receive();
				System.out.println("완료의 개수는? " + count);
				Client.Client_send("22");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				String[] msgRC = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
					// msg.append(Client.Client_receive()+"\n");
				}
				Client.Client_send("23");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n"
									+ msgR[i] + "\n\n");
					msg.append(msgRC[i] + "\n\n");
				}
				Pr_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			} // 서버와 소통 14을 통해
		});

		PrButton[4].addActionListener(e4 -> {// select 프로젝트 (프로젝트 받아와서 출력하기)
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(Pr_scroll);
			gridproject.setBackground(Color.black);
			Center.add(gridproject);
			Pr_area.setText("");
			Pr_area.setEditable(false);
			// 메세지
			try {
				Client.Client_send("15");// 셀렉트 (프로젝트 개수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (프로젝트 개수 받아오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("16");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				String[] msgRC = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
					// msg.append(Client.Client_receive()+"\n");
				}
				Client.Client_send("17");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n"
									+ msgR[i] + "\n\n");
					msg.append(msgRC[i] + "\n\n");
				}
				Pr_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			} // 서버와 소통 14을 통해
		});
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		// Center.add(panel);
		// Ad_area
		JScrollPane Ad_scroll = new JScrollPane(Ad_area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Ad_area.setEditable(false);
		Ad_area.setLineWrap(true);
		Ad_area.setBackground(Color.black);
		Ad_area.setForeground(Color.white);
		Ad_area.setText("");
		Ad_area.setFont(new Font("맑은고딕", Font.BOLD, 15));
		Ad_scroll.setPreferredSize(new Dimension(1000, 550));

		JPanel gridPanel = new JPanel(new GridLayout(1, 2, 30, 30));

		JLabel Ad_label = new JLabel("사원의 사원번호를 입력해주세요");
		JLabel Ad_label2 = new JLabel("바꿀 레벨을 입력해주세요");
		JTextField adtx = new JTextField(10);
		JTextField adtx2 = new JTextField(10);
		Ad_label.setFont(new Font("맑은고딕", Font.BOLD, 15));
		Ad_label.setForeground(Color.white);
		adtx.setForeground(Color.RED);
		adtx.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		Ad_label2.setFont(new Font("맑은고딕", Font.BOLD, 15));
		Ad_label2.setForeground(Color.white);
		adtx2.setForeground(Color.RED);
		adtx2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		AdButton[0] = new JButton("사원 레벨 승급 및 하락");
		AdButton[0].setBackground(Color.black);
		AdButton[0].setForeground(Color.white);
		Admin.addActionListener(e10 -> {// 해야할일
			StringBuffer msg = new StringBuffer();
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			gridPanel.add(Ad_label);
			gridPanel.add(adtx);
			gridPanel.add(Ad_label2);
			gridPanel.add(adtx2);
			gridPanel.setBackground(Color.black);
			Center.setBackground(Color.black);
			Center.add(gridPanel);
			Center.add(Ad_scroll);
			Center.add(AdButton[0]);
			Ad_area.setText("");
			//////////////
			try {
				Client.Client_send("24");// 셀렉트 (사원 인원수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (사원 인원 수 받아오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("25");// 인원수 만큼 출력
				Client.Client_receive();
				Client.Client_send("Give me a 사원!");
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(Client.Client_receive() + "\n");
				}
				Ad_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
			////////////////
		});
		AdButton[0].addActionListener(k -> {
			StringBuffer msg = new StringBuffer();
			String alert = new String("");
			int[] Adcheck = new int[2];
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			gridPanel.add(Ad_label);
			gridPanel.add(adtx);
			gridPanel.add(Ad_label2);
			gridPanel.add(adtx2);
			gridPanel.setBackground(Color.black);
			Center.add(gridPanel);
			Center.add(Ad_scroll);
			Center.add(AdButton[0]);
			Ad_area.setText("");
			if (!adtx.getText().equals(""))
				Adcheck[0] = 1;
			if (!adtx2.getText().equals(""))
				Adcheck[1] = 1;
			if (Adcheck[0] == 0)
				alert += "사원번호 ";
			if (Adcheck[1] == 0)
				alert += "레벨 ";
			if (Adcheck[0] == 1 && Adcheck[1] == 1) {
				JOptionPane.showMessageDialog(null, "레벨 변경에 성공하셨습니다.");
				try {// 클라이언트에서 서버로 보낼 부분
					Client.Client_send("26");// Update 레벨
					Client.Client_receive();
					Client.Client_send(adtx.getText());
					Client.Client_receive();
					Client.Client_send(adtx2.getText());
					Client.Client_receive();
					adtx.setText("");
					adtx2.setText("");
				} catch (IOException e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, alert + "을(를)을 입력해주세요");
			}
			for (int i = 0; i < 2; i++) {
				Adcheck[i] = 0;
			}
			//////////////// Update하기
			try {
				Client.Client_send("24");// 셀렉트 (사원 인원수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (사원 인원 수 받아오기)
				String count = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count);
				Client.Client_send("25");// 인원수 만큼 출력
				Client.Client_receive();
				Client.Client_send("Give me a 사원!");
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(Client.Client_receive() + "\n");
				}
				Ad_area.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
			////////////////////////////////////
		});

		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		/////////////////////////////// ///////////////////////////////
		AcButton[0] = new JButton("공지하기");
		AcButton[1] = new JButton("직원 소집");
		AcButton[2] = new JButton("직원 소집 해제");
		for(int i = 0 ; i < 3; i++) {
			AcButton[i].setBackground(Color.black);
			AcButton[i].setForeground(Color.white);
		}
		gridan.add(AcButton[0]);
		gridan.add(AcButton[1]);
		gridan.add(AcButton[2]);
		gridan.setBackground(Color.black);
		announce.addActionListener(e20 -> {
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(anscroll);
			Center.add(gridan);
			// 해야하는 곳
			Center.setBackground(Color.black);
			anarea.setEditable(true);
			anarea.setLineWrap(true);
			anarea.setBackground(Color.black);
			anarea.setForeground(Color.white);
			anarea.setText("");
			anarea.setFont(new Font("맑은고딕", Font.BOLD, 15));
			anscroll.setPreferredSize(new Dimension(1000, 550));
		});

		AcButton[0].addActionListener(e -> {
/////////////////////////////////////////////
			String alert = new String("");
			String antext = anarea.getText();
			antext = antext.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
			anarea.setEditable(true);
			// pr_text = pr_text.replaceAll(System.getProperty("line.separator"), " ");
			if (anarea.getText().equals(""))
				alert += "공지사항 본문 ";
			// 해야하는 곳
			if (!anarea.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "공지사항 작성에 성공하셨습니다.");
				try {// 클라이언트에서 서버로 보낼 부분
					Client.Client_send("33");// 서버와 소통 33을 통해
					Client.Client_receive();
					Client.Client_send(antext);// TextAreaBlock
					Client.Client_receive();
					anarea.setText("");

				} catch (IOException e11) {
					// TODO Auto-generated catch block
					e11.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, alert + "을(를)을 입력해주세요");
			}
			////////////////////////////////////

		});
		AcButton[1].addActionListener(e -> {
			try {
				Client.Client_send("41");
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
			// 공지하자
		
	});
		AcButton[2].addActionListener(e -> {
			try {
				Client.Client_send("42");
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
			// 공지하자
		
	});

		/////////////////////////////////////////////

		MoButton[0] = new JButton("총매출");
		MoButton[1] = new JButton("예상매출");
		MoButton[0].setBackground(Color.black);
		MoButton[0].setForeground(Color.white);
		MoButton[1].setBackground(Color.black);
		MoButton[1].setForeground(Color.white);
		gridmo.add(MoButton[0]);
		gridmo.add(MoButton[1]);
		moarea.setText("");
		moarea.setEditable(false);
		moarea.setBackground(Color.black);
		moarea.setForeground(Color.white);
		moarea.setText("");
		moarea.setFont(new Font("맑은고딕", Font.BOLD, 15));
		moscroll.setPreferredSize(new Dimension(1000, 550));

		money.addActionListener(e30 -> {
			moarea.setText("");
			moarea.setEditable(false);
			moarea.setBackground(Color.black);
			moarea.setForeground(Color.white);
			moarea.setFont(new Font("맑은고딕", Font.BOLD, 15));
			moscroll.setPreferredSize(new Dimension(1000, 550));
			Center.setBackground(Color.black);
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(moscroll);
			gridmo.setBackground(Color.black);
			Center.add(gridmo);
			// 메세지
			try {
				moarea.setText("");
				StringBuffer msg10 = new StringBuffer();
				int sum = 0;
				Client.Client_send("36");// 셀렉트 (프로젝트 개수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (프로젝트 개수 받아오기)
				String count = Client.Client_receive();
				System.out.println("Money(완료된 프로젝트) 개수는? " + count);
				Client.Client_send("37");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
					sum += Integer.parseInt(msgR[i]);
					// msg.append(Client.Client_receive()+"\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg10.append(msgR[i] + "\n");
				}
				msg10.append(
						"---------------------완료된 프로젝트 개수 : " + count + "---------------------------\n매출액 : " + sum);
				moarea.setText(msg10.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
		});
		MoButton[0].addActionListener(e -> {
			moarea.setText("");
			Center.setBackground(Color.black);
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(moscroll);
			gridmo.setBackground(Color.black);
			Center.add(gridmo);
			try {
				StringBuffer msg10 = new StringBuffer();
				int sum = 0;
				Client.Client_send("36");// 셀렉트 (프로젝트 개수 받아오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (프로젝트 개수 받아오기)
				String count = Client.Client_receive();
				System.out.println("Money(완료된 프로젝트) 개수는? " + count);
				Client.Client_send("37");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
					sum += Integer.parseInt(msgR[i]);
					// msg.append(Client.Client_receive()+"\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg10.append(msgR[i] + "\n");
				}
				msg10.append(
						"---------------------완료된 프로젝트 개수 : " + count + "---------------------------\n매출액 : " + sum);
				moarea.setText(msg10.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
		});
		MoButton[1].addActionListener(e -> {
			moarea.setText("");
			Center.setBackground(Color.black);
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(moscroll);
			gridmo.setBackground(Color.black);
			Center.add(gridmo);
			try {
				StringBuffer msg11 = new StringBuffer();
				int sum = 0;
				Client.Client_send("38");
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 진행완료개수
				String count = Client.Client_receive();
				System.out.println("Money(진행+완료된 프로젝트) 개수는? " + count);
				Client.Client_send("39");
				Client.Client_receive();
				Client.Client_send("Give me a data");
				String[] msgR = new String[Integer.parseInt(count)];
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msgR[i] = Client.Client_receive();
					sum += Integer.parseInt(msgR[i]);
					// msg.append(Client.Client_receive()+"\n");
				}
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg11.append(msgR[i] + "\n");
				}
				msg11.append("---------------------진행 + 완료된 프로젝트 개수 : " + count
						+ "---------------------------\n예상 매출액 : " + sum);
				moarea.setText(msg11.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
		});

		// //////////////////////////////////////
		// West
		West.add(Task);
		West.add(Project);
		West.add(Admin);
		West.add(announce);
		West.add(money);
		Task.setForeground(Color.white);
		Task.setFont(new Font("맑은고딕", Font.BOLD, 30));
		Task.setBackground(Color.black);
		Task.setBorderPainted(false);
		Task.setFocusPainted(false);
		Task.setContentAreaFilled(false);
		Project.setForeground(Color.white);
		Project.setFont(new Font("맑은고딕", Font.BOLD, 30));
		Project.setBackground(Color.black);
		Project.setBorderPainted(false);
		Project.setFocusPainted(false);
		Project.setContentAreaFilled(false);

		Admin.setForeground(Color.white);
		Admin.setFont(new Font("맑은고딕", Font.BOLD, 30));
		Admin.setBackground(Color.black);
		Admin.setBorderPainted(false);
		Admin.setFocusPainted(false);
		Admin.setContentAreaFilled(false);

		announce.setForeground(Color.white);
		announce.setFont(new Font("맑은고딕", Font.BOLD, 30));
		announce.setBackground(Color.black);
		announce.setBorderPainted(false);
		announce.setFocusPainted(false);
		announce.setContentAreaFilled(false);

		money.setForeground(Color.white);
		money.setFont(new Font("맑은고딕", Font.BOLD, 30));
		money.setBackground(Color.black);
		money.setBorderPainted(false);
		money.setFocusPainted(false);
		money.setContentAreaFilled(false);
		West.setBackground(Color.black);
		// TODO

		////////////////////////////////////////
		// East
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7, 0, 0));
		// p1.setPreferredSize(new Dimension(430, 120));
		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			button[x].setBackground(Color.black);
			if (x > 6)
				// TODO

				button[x].addActionListener(e -> {
					day = button[selection].getActionCommand();
					// button[selection].addActionListener(this);
					java.util.Calendar cal = java.util.Calendar.getInstance();
					String today_year2 = cal.get(Calendar.YEAR) + "";
					String today_month2 = (cal.get(Calendar.MONTH) + 1 + "");
					String today_day2 = cal.get(Calendar.DAY_OF_MONTH) + "";
					cal.set(year, month, 1);
					String today_year = cal.get(Calendar.YEAR) + "";
					String today_month = (cal.get(Calendar.MONTH) + 1 + "");
					String today_day = cal.get(Calendar.DAY_OF_MONTH) + "";
					// number ,year, month, day, plan
					StringBuffer msg2 = new StringBuffer();
					if (e.getActionCommand() != "") {
						String plan = JOptionPane.showInputDialog(null, "일정을 추가하세요.");
						if (plan != null) {
							try {// 추가
								Client.Client_send("8");
								Client.Client_receive();
								Client.Client_send(LoginFrame.getNumber());
								Client.Client_receive();
								Client.Client_send(today_year);
								Client.Client_receive();
								Client.Client_send(today_month);
								Client.Client_receive();
								Client.Client_send(e.getActionCommand());
								Client.Client_receive();
								Client.Client_send(plan);
								Client.Client_receive();
								///////////////////////////// 갱신
								Client.Client_send("10");
								Client.Client_receive();
								Client.Client_send(LoginFrame.getNumber());
								Client.Client_receive();
								Client.Client_send(today_year2);
								Client.Client_receive();
								Client.Client_send(today_month2);
								Client.Client_receive();
								Client.Client_send(today_day2);
								Client.Client_receive();
								String count = Client.Client_receive();
								Client.Client_send("9");
								Client.Client_receive();
								Client.Client_send(LoginFrame.getNumber());
								Client.Client_receive();
								Client.Client_send(today_year2);
								Client.Client_receive();
								Client.Client_send(today_month2);
								Client.Client_receive();
								Client.Client_send(today_day2);
								Client.Client_receive();
								for (int i = 0; i < Integer.parseInt(count); i++) {
									msg2.append(Client.Client_receive() + "\n");
								}
								ja2.setText(msg2.toString());

							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						/// /// /// /// /// /// /// ///

						/// /// /// /// /// /// /// ///
					} ////
						// TODO

				});

			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
				button[x].setBackground(Color.black);
			}
			p1.add(button[x]);
			// displayDate();
		}
		displayDate();
		// JPanel p2 = new JPanel(new GridLayout(1, 3));
		JPanel p2 = new JPanel(new FlowLayout(20));
		p2.setBackground(Color.black);
		JButton previous = new JButton("<< Previous");
		previous.setBackground(Color.black);
		previous.setForeground(Color.white);
		previous.addActionListener(e6 -> {
			month--;
			displayDate();
		});
		p2.add(previous);
		l.setBackground(Color.black);

		p2.add(l);
		JButton next = new JButton("Next >>");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.addActionListener(e7 -> {
			month++;
			displayDate();
		});
		p2.add(next);
		p2.add(Gotowork);
		Gotowork.addActionListener(e5 -> {
			java.text.SimpleDateFormat sdf;
			java.util.Calendar cal = java.util.Calendar.getInstance();
			String today_day = cal.get(Calendar.DAY_OF_MONTH) + "";
			String today_year = cal.get(Calendar.YEAR) + "";
			String today_month = (cal.get(Calendar.MONTH) + 1 + "");
			String format_time = String.format("%tT", cal);
			// TODO
			try {
				Client.Client_send("5");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				Client.Client_receive();
				Client.Client_send(today_year);
				Client.Client_receive();
				Client.Client_send(today_month);
				Client.Client_receive();
				Client.Client_send(today_day);
				Client.Client_receive();
				Client.Client_send(format_time);
				Client.Client_receive();
				Client.Client_send("출근");
				Client.Client_receive();
				StringBuffer msg = new StringBuffer();
				Client.Client_send("6");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				String count = Client.Client_receive();

				Client.Client_send("7");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				// Client.Client_receive();
				System.out.println("개수는 이거다 ! :" + count);
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(Client.Client_receive() + "\n");
				}

				ja.setText(msg.toString());

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		ja.setLineWrap(true);
		ja2.setLineWrap(true);
		Gotowork.setBackground(Color.black);
		Gotowork.setForeground(Color.white);
		// p3.add(Worktime);
		Backtowork.setBackground(Color.black);
		Backtowork.setForeground(Color.white);
		Backtowork.addActionListener(ek -> {
			java.text.SimpleDateFormat sdf;
			java.util.Calendar cal = java.util.Calendar.getInstance();
			String today_day = cal.get(Calendar.DAY_OF_MONTH) + "";
			String today_year = cal.get(Calendar.YEAR) + "";
			String today_month = (cal.get(Calendar.MONTH) + 1 + "");
			String format_time = String.format("%tT", cal);
			try {
				Client.Client_send("5");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				Client.Client_receive();
				Client.Client_send(today_year);
				Client.Client_receive();
				Client.Client_send(today_month);
				Client.Client_receive();
				Client.Client_send(today_day);
				Client.Client_receive();
				Client.Client_send(format_time);
				Client.Client_receive();
				Client.Client_send("퇴근");
				Client.Client_receive();
				StringBuffer msg = new StringBuffer();
				Client.Client_send("6");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				String count = Client.Client_receive();

				Client.Client_send("7");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				// Client.Client_receive();
				System.out.println("개수는 이거다 ! :" + count);
				for (int i = 0; i < Integer.parseInt(count); i++) {
					msg.append(Client.Client_receive() + "\n");
				}

				ja.setText(msg.toString());

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO
			// msg.append(today_year +"년"+ today_month+"월"+today_day+"일" + format_time +
			// "퇴근\n");
			// ja_text += ja_text;
			// ja.setText(msg.toString());
		});
		// ja.setText(t);
		///////// 초기 출퇴근기록부
		Client.Client_send("7");
		Client.Client_receive();
		Client.Client_send(LoginFrame.getNumber());
		// Client.Client_receive();
		System.out.println("개수는 이거다 ! :" + Integer.parseInt(LoginFrame.getCount()));
		for (int i = 0; i < Integer.parseInt(LoginFrame.getCount()); i++) {
			msg.append(Client.Client_receive() + "\n");
		}
		ja.setText(msg.toString());
		/// /// /// /// /// /// /// ///
		// TODO
		java.util.Calendar cal = java.util.Calendar.getInstance();
		String today_day = cal.get(Calendar.DAY_OF_MONTH) + "";
		String today_year = cal.get(Calendar.YEAR) + "";
		String today_month = (cal.get(Calendar.MONTH) + 1 + "");
		StringBuffer msg2 = new StringBuffer();
		Client.Client_send("10");
		Client.Client_receive();
		Client.Client_send(LoginFrame.getNumber());
		Client.Client_receive();
		Client.Client_send(today_year);
		Client.Client_receive();
		Client.Client_send(today_month);
		Client.Client_receive();
		Client.Client_send(today_day);
		Client.Client_receive();
		String count = Client.Client_receive();
		Client.Client_send("9");
		Client.Client_receive();
		Client.Client_send(LoginFrame.getNumber());
		Client.Client_receive();
		Client.Client_send(today_year);
		Client.Client_receive();
		Client.Client_send(today_month);
		Client.Client_receive();
		Client.Client_send(today_day);
		Client.Client_receive();
		for (int i = 0; i < Integer.parseInt(count); i++) {
			msg2.append(Client.Client_receive() + "\n");
		}
		ja2.setText(msg2.toString());
		/// /// /// /// /// /// /// ///
		p2.add(Backtowork);
		// 오늘 일정 기록 삭제
		DeleteA.setBackground(Color.black);
		DeleteA.setForeground(Color.white);
		DeleteA.addActionListener(e -> {
			try {
				Client.Client_send("11");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				Client.Client_receive();
				Client.Client_send(today_year);
				Client.Client_receive();
				Client.Client_send(today_month);
				Client.Client_receive();
				Client.Client_send(today_day);
				Client.Client_receive();
				// ja.setText("");
				ja2.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		DeleteB.setBackground(Color.black);
		DeleteB.setForeground(Color.white);
		DeleteB.addActionListener(e -> {
			try {
				Client.Client_send("12");
				Client.Client_receive();
				Client.Client_send(LoginFrame.getNumber());
				Client.Client_receive();
				// ja.setText("");
				ja.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		p2.add(DeleteB);
		p2.add(DeleteA);
		// p1.setBounds(250,50,10,10);
		East.add(p1);
		// East.setBounds(250,250,10,10);
		// p2.setBounds(250,300,10,10);
		East.add(p2);
		East.setBackground(Color.black);
		// grid.add(new JLabel("출근 도장"));
		ja.setEditable(false);
		ja.setBackground(Color.black);
		ja.setFont(new Font("맑은고딕", Font.BOLD, 13));
		ja.setForeground(Color.white);
		jp.setPreferredSize(new Dimension(300, 120));
		jp2.setPreferredSize(new Dimension(300, 120));
		grid.setBackground(Color.black);
		ja2.setBackground(Color.black);
		ja2.setEditable(false);
		ja2.setFont(new Font("맑은고딕", Font.BOLD, 13));
		ja2.setForeground(Color.white);
		// grid.add(new JLabel("퇴근 도장"));
		grid.add(Work);
		Work.setForeground(Color.white);
		Work.setFont(new Font("맑은고딕", Font.BOLD, 30));
		grid.add(jp);
		grid.add(Today_Plan);
		Today_Plan.setForeground(Color.white);
		Today_Plan.setFont(new Font("맑은고딕", Font.BOLD, 30));
		grid.add(jp2);
		workbox.add(Work);
		workbox.add(jp);
		workbox.add(Today_Plan);
		workbox.add(jp2);
		// workbox.add(grid);
		East.add(workbox);

		// East.add(grid);

		// East
		//////////////////////////
		// South
		Container cp = getContentPane();
		// cp.setLayout(new FlowLayout());
		// cp.setLayout(new BorderLayout()); //수평 간격, 수직 간격을 설정합니다.
		hjcompany.setForeground(Color.yellow);
		hjcompany.setFont(new Font("맑은고딕", Font.BOLD, 30));
		hjcompany.setBackground(Color.black);
		hjcompany.setBorderPainted(false);
		hjcompany.setFocusPainted(false);
		hjcompany.setContentAreaFilled(false);
		hjcompany.setBounds(500, 10, 100, 100);
		anLabel.setForeground(Color.white);
		anLabel.setFont(new Font("맑은고딕", Font.BOLD, 50));
		hjcompany.addActionListener(e -> {
			//////////////////////////////////////////////////////////////
			Center.removeAll();
			Center.revalidate();
			Center.repaint();
			Center.add(anLabel);
			Center.add(hjscroll);
			Center.setBackground(Color.black);
			hjarea.setEditable(true);
			hjarea.setLineWrap(true);
			hjarea.setBackground(Color.black);
			hjarea.setForeground(Color.white);
			hjarea.setText("");
			hjarea.setFont(new Font("맑은고딕", Font.BOLD, 15));
			hjscroll.setPreferredSize(new Dimension(1000, 550));

			try {
				StringBuffer msg = new StringBuffer();
				Client.Client_send("35");// 셀렉트 (보고받을 모든 것 가져오기)
				Client.Client_receive();
				Client.Client_send("Give me a Count");// 셀렉트 (보고받을 모든 것 가져오기)
				String count2 = Client.Client_receive();
				System.out.println("프로젝트의 개수는? " + count2);
				String[] msgRC = new String[Integer.parseInt(count2)];
				Client.Client_send("34");
				Client.Client_receive();
				Client.Client_send("Give me a contents");
				// Client.Client_receive();
				for (int i = 0; i < Integer.parseInt(count2); i++) {
					msgRC[i] = Client.Client_receive();
					msgRC[i] = msgRC[i].replaceAll("<br>", "\n");
				}
				for (int i = 0; i < Integer.parseInt(count2); i++) {
					msg.append(
							"--------------------------------------------------------------------------------------------------------\n");
					msg.append(msgRC[i] + "\n\n");
				}
				hjarea.setText(msg.toString());
			} catch (IOException e8) {
				// TODO Auto-generated catch block
				e8.printStackTrace();
			}
			///////////////////////////////////////////
		});
		North.setBackground(Color.black);
		North.add(hjcompany);
		North.add(Present_time);
		North.add(ID);
		// East.add(new JButton("hi"));
		// Calendar
		cp.add(init);
		init.add(North, BorderLayout.NORTH);
		init.add(South, BorderLayout.SOUTH);
		init.add(East, BorderLayout.EAST);
		init.add(West, BorderLayout.WEST);
		// init.add(label, BorderLayout.CENTER);
		init.add(Center, BorderLayout.CENTER);
		init.setBackground(Color.black);

		setTitle("사장");
		setSize(1950, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setBackground(Color.black);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			display();
			//ShowPoP();

		}
	}

	public synchronized void ShowPoP() {
		try {
			Client.Client_send("40");
			String count = Client.Client_receive();
			if (count.equals("1")) {
				JOptionPane.showMessageDialog(null, "강당으로 모두 모여주세요 ^^");
			}

		} catch (Exception e) {

		}

	}

	//////////////////// Calendar
	public synchronized void displayDate() {
		java.text.SimpleDateFormat sdf;
		for (int x = 7; x < button.length; x++) {
			button[x].setText("");
			button[x].setForeground(Color.white);
			button[x].setBackground(Color.black);
		}
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Calendar cal2 = java.util.Calendar.getInstance();
		String today_day = cal2.get(Calendar.DAY_OF_MONTH) + "";
		String today_year = cal2.get(Calendar.YEAR) + "";
		String today_month = (cal2.get(Calendar.MONTH) + 1 + "");
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
			button[x].setText("" + day);
			button[x].setForeground(Color.white);
			button[x].setBackground(Color.black);
			if (today_day.equals(button[x].getText()) && today_year.equals(cal.get(Calendar.YEAR) + "")
					&& today_month.equals(cal.get(Calendar.MONTH) + 1 + "")) {
				button[x].setForeground(Color.green);
			}
			// button[x].addActionListener(this);
			// if(button[x].getText()=="") {
			// button[x].setEnabled(false);
			// }

		}
		sdf = new java.text.SimpleDateFormat("MM월 yyyy년");
		l.setText(sdf.format(cal.getTime()));
		l.setForeground(Color.white);
	}

	/*
	 * public String setPickedDate() { if (day.equals("")) return day;
	 * java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
	 * "dd-MM-yyyy"); java.util.Calendar cal = java.util.Calendar.getInstance();
	 * cal.set(year, month, Integer.parseInt(day)); return
	 * sdf.format(cal.getTime()); }
	 */
//////////////////////////////
//////////////////////Time
	public void display() {
		Calendar cal = Calendar.getInstance();

		String format_time = String.format("%tF %tT", cal, cal);
		// System.out.println(format_time);
		Present_time.setText(format_time);
		Present_time.setForeground(Color.yellow);
		Present_time.setFont(new Font("맑은고딕", Font.BOLD, 15));
		Present_time.setBounds(200, 10, 10, 10);
	}

	@Override
	public void actionPerformed(ActionEvent ek) {

	}

}
