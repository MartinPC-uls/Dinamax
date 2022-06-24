package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import bd.MongoDB;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JLabel lblErrorCredenciales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 517, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setVisible(true);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(148, 137, 187, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(148, 122, 187, 14);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setBounds(148, 176, 187, 14);
		frame.getContentPane().add(lblContrasena);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MongoDB mongo = new MongoDB();
				boolean verificado = mongo.verificarAdministrador(txtUsuario.getText(), String.valueOf(txtContrasena.getPassword()));
				if (verificado) {
					frame.setVisible(false);
					new Administracion().setVisible(true);
				} else {
					lblErrorCredenciales.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(204, 246, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(148, 189, 187, 20);
		frame.getContentPane().add(txtContrasena);
		
		lblErrorCredenciales = new JLabel("Las credenciales no son correctas");
		lblErrorCredenciales.setBounds(145, 221, 236, 14);
		frame.getContentPane().add(lblErrorCredenciales);
		lblErrorCredenciales.setVisible(false);
	}
}
