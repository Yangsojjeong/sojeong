import javax.swing.*;
import java.awt.event.*;
public class Login{
    public static void main(String[] args) {
    JFrame f=new JFrame("로그인 창");          // 프레임 생성
    JLabel l1=new JLabel("사용자:");             // 사용자 라벨 
    l1.setBounds(20,20, 80,30);
    JTextField text = new JTextField();          // 사용자 입력창 
    text.setBounds(100,20, 100,30);
    JLabel l2=new JLabel("비밀번호:");            // 비밀번호 라벨
    l2.setBounds(20,75, 80,30);    
    JPasswordField value = new JPasswordField(); // 비밀번호 입력창 
    value.setBounds(100,75, 100,30);
    JButton b = new JButton("로그인");         // 로그인 버튼
    b.setBounds(100,120, 80,30);

    f.add(l1); f.add(text);    //프레임에 사용자 라벨, 입력창 붙이기             
    f.add(l2);  f.add(value); f.add(b); // 프레임에 비밀번호 라벨, 입력창, 버튼 붙이기
    f.setSize(300,250);
    f.setLayout(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
             String data = "사용자: " + text.getText();
             data += ", 비밀번호: "
                    + new String(value.getPassword());
             JOptionPane.showMessageDialog(f, data);
             }
           });
}
}
File;

public class FileEx {
	public static void listDirectory(File dir) {
		System.out.println("----" + dir.getPath() + "의 서브 리스트 입니다.----");
		File[] subFiles = dir.listFiles();
		for(int i=0; i<subFiles.length; i++) {
		File f = subFiles[i];
		long t = f.lastModified();
		System.out.print(f.getName());
		System.out.print("\t파일크기: " + f.length());
		System.out.printf("\t수정한 시간: %tb %td %ta %tT\n" ,t, t, t, t);
		}
	}
	
	public static void main(String[] args) {
		File f1 = new File("c:\\Windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		
		String res="";
		if(f1.isFile()) res = "파일";
		else if(f1.isDirectory()) res = "디렉토리";
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		File f2 = new File("c:\\Temp\\java_sample");
		if(!f2.exists()) {
			f2.mkdir();
		}
		listDirectory(new File("c:\\Temp"));
		f2.renameTo(new File("c:\\Temp\\javasample"));
		listDirectory(new File("c:\\Temp"));
	}

}
