package Runecessor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Captcha extends JApplet {
	static JLabel captcha, result;

	JTextField edit;

	JButton submit;

	static String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

	static String val = "";

	static int n = 8;


	public static String translateCaptcha() {
		val = "";
		for (int i = 0; i < n; i++) {
			int z = LogInScreen.captchaCode[i] - 852;
			val += str.replaceAll("(.{1})", "$1,").split(",")[z];
		}
		return val;
	}

	public Captcha() {
		final JFrame frame = new JFrame("Captcha");
		frame.setLayout(new FlowLayout());
		frame.setSize(250, 120);
		result = new JLabel();
		captcha = new JLabel();
		edit = new JTextField(n);

		captcha.setText(translateCaptcha());
		submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (edit.getText().compareTo(captcha.getText()) == 0) {
					Client.instance.setLoginMessage1("Captcha Solved.");
					Client.logInScreenPage = "SECOND";
					try {
						Thread.sleep(500);
					}
					catch (Exception e) {
					}
					frame.setVisible(false);
				}
				else {
					result.setText("Incorrect Captcha");
					LogInScreen.loginCount = -1;
				}
			}
		});

		frame.add(captcha);
		frame.add(edit);
		frame.add(submit);
		frame.add(result);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}