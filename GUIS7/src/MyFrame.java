import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar; //특정 순간과 캘린더를 필트 세트 사이를 변환하는 메소드 제공 추상 클래스 

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{

	Calendar calendar;
//	간단한 날짜 형식 인스턴스
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;

	
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;

	String time;
	String day;
	String date;

	MyFrame(){
		//프레임 자체 생성 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//제목 설정
		this.setTitle("시계");
		this.setLayout(new FlowLayout());
		this.setSize(400,200);
		//크기 조정 X
		this.setResizable(false);
		
//		시간 형식은 새로운 단순
		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("EEEE");
		dateFormat = new SimpleDateFormat("MMMM dd, yyyy");

		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free",Font.PLAIN,35));

		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free",Font.PLAIN,25));

		
		
		this.add(timeLabel);
		this.add(dayLabel);
		this.add(dateLabel);
		this.setVisible(true);
		
		setTime();
	}
	public void setTime() {
		while(true) {
		time = timeFormat.format(Calendar.getInstance().getTime());
		timeLabel.setText(time);
		
		day = dayFormat.format(Calendar.getInstance().getTime());
		dayLabel.setText(day);
		
		date = dateFormat.format(Calendar.getInstance().getTime());
		dateLabel.setText(date);
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	}


}
