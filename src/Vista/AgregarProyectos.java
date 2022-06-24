package Vista;

import javax.swing.JFrame;
import javax.swing.JTextField;
import bd.Direccion;
import bd.Fecha_inicio;
import bd.MongoDB;
import bd.Nombre;
import bd.Proyecto;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AgregarProyectos {

	public JFrame frame;
	private JTextField txtNombreProyecto;
	private JTextField txtRut;
	private JTextField txtSubsidio;
	private JTextField txtMontoSubsidio;
	private JTextField txtPresupuesto;
	private JTextField txtDia;
	private JTextField txtDuracionObra;
	private JTextField txtEstadoObra;
	private JTextField txtNombrePersona;
	private JTextField txtCalle;
	private JTextField txtNumero;
	private JTextField txtCCP;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtMes;
	private JTextField txtAno;
	
	private ArrayList<JTextField> jTextFields;
	private ArrayList<JButton> jButtons;
	
	// 452, 209, 46, 23
	private static int btn_x = 452;
	private static int btn_y = 209-23;
	private static int btn_width = 46;
	private static int btn_height = 23;
	
	// 244, 210, 210, 20
	private static int txtField_x = 244;
	private static int txtField_y = 210-23;
	private static int txtField_width = 210;
	private static int txtField_height = 20;
	private JTextField txtRegistro0;
	private JTextField txtRegistro1;
	private JTextField txtRegistro2;
	private JTextField txtRegistro3;
	
	// modo = 1 : Agregación
	// modo = 2 : Edición
	int modo;
	String _id;

	public AgregarProyectos(int modo) {
		this.modo = modo;
		
		// 452, 209, 46, 23
		btn_x = 452;
		btn_y = 209-23;
		btn_width = 46;
		btn_height = 23;
		
		// 244, 210, 210, 20
		txtField_x = 244;
		txtField_y = 210-23;
		txtField_width = 210;
		txtField_height = 20;
		
		initialize();
	}
	public AgregarProyectos(int modo, String _id) {
		this.modo = modo;
		this._id = _id;
		
		// 452, 209, 46, 23
		btn_x = 452;
		btn_y = 209-23;
		btn_width = 46;
		btn_height = 23;
		
		// 244, 210, 210, 20
		txtField_x = 244;
		txtField_y = 210-23;
		txtField_width = 210;
		txtField_height = 20;
		
		initialize();
	}

	private void initialize() {
		
		jTextFields = new ArrayList<JTextField>();
		jButtons = new ArrayList<JButton>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 818, 554);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombreProyecto = new JLabel("Nombre Proyecto");
		lblNombreProyecto.setBounds(24, 30, 210, 14);
		frame.getContentPane().add(lblNombreProyecto);
		
		txtNombreProyecto = new JTextField();
		txtNombreProyecto.setBounds(24, 46, 210, 20);
		frame.getContentPane().add(txtNombreProyecto);
		txtNombreProyecto.setColumns(10);
		
		JLabel lblRut = new JLabel("Rut");
		lblRut.setBounds(24, 77, 210, 14);
		frame.getContentPane().add(lblRut);
		
		txtRut = new JTextField();
		txtRut.setColumns(10);
		txtRut.setBounds(24, 93, 210, 20);
		frame.getContentPane().add(txtRut);
		
		JLabel lblSubsidio = new JLabel("Subsidio");
		lblSubsidio.setBounds(24, 124, 210, 14);
		frame.getContentPane().add(lblSubsidio);
		
		txtSubsidio = new JTextField();
		txtSubsidio.setColumns(10);
		txtSubsidio.setBounds(24, 140, 210, 20);
		frame.getContentPane().add(txtSubsidio);
		
		JLabel lblMontoSubsidio = new JLabel("Monto subsidio");
		lblMontoSubsidio.setBounds(24, 171, 210, 14);
		frame.getContentPane().add(lblMontoSubsidio);
		
		txtMontoSubsidio = new JTextField();
		txtMontoSubsidio.setColumns(10);
		txtMontoSubsidio.setBounds(24, 187, 210, 20);
		frame.getContentPane().add(txtMontoSubsidio);
		
		JLabel lblPresupuesto = new JLabel("Presupuesto");
		lblPresupuesto.setBounds(24, 218, 210, 14);
		frame.getContentPane().add(lblPresupuesto);
		
		txtPresupuesto = new JTextField();
		txtPresupuesto.setColumns(10);
		txtPresupuesto.setBounds(24, 234, 210, 20);
		frame.getContentPane().add(txtPresupuesto);
		
		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(24, 284, 90, 14);
		frame.getContentPane().add(lblFechaInicio);
		
		txtDia = new JTextField();
		txtDia.setColumns(10);
		txtDia.setBounds(112, 281, 33, 20);
		frame.getContentPane().add(txtDia);
		
		JLabel lblDuracionObra = new JLabel("Duracion de Obra");
		lblDuracionObra.setBounds(24, 312, 210, 14);
		frame.getContentPane().add(lblDuracionObra);
		
		txtDuracionObra = new JTextField();
		txtDuracionObra.setColumns(10);
		txtDuracionObra.setBounds(24, 328, 90, 20);
		frame.getContentPane().add(txtDuracionObra);
		
		JLabel lblEstadoObra = new JLabel("Estado obra");
		lblEstadoObra.setBounds(24, 359, 210, 14);
		frame.getContentPane().add(lblEstadoObra);
		
		txtEstadoObra = new JTextField();
		txtEstadoObra.setColumns(10);
		txtEstadoObra.setBounds(24, 375, 210, 20);
		frame.getContentPane().add(txtEstadoObra);
		
		JLabel lblNombrePersona = new JLabel("Nombre persona");
		lblNombrePersona.setBounds(244, 30, 210, 14);
		frame.getContentPane().add(lblNombrePersona);
		
		txtNombrePersona = new JTextField();
		txtNombrePersona.setColumns(10);
		txtNombrePersona.setBounds(244, 46, 210, 20);
		frame.getContentPane().add(txtNombrePersona);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(464, 30, 210, 14);
		frame.getContentPane().add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(464, 46, 210, 20);
		frame.getContentPane().add(txtCalle);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(464, 77, 210, 14);
		frame.getContentPane().add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(464, 93, 210, 20);
		frame.getContentPane().add(txtNumero);
		
		JLabel lblCCP = new JLabel("Ciudad, comuna o provincia");
		lblCCP.setBounds(464, 124, 210, 14);
		frame.getContentPane().add(lblCCP);
		
		txtCCP = new JTextField();
		txtCCP.setColumns(10);
		txtCCP.setBounds(464, 140, 210, 20);
		frame.getContentPane().add(txtCCP);
		
		JButton btnAgregarProyecto = new JButton("Agregar Proyecto");
		if (modo == 2) {
			btnAgregarProyecto.setText("Editar Proyecto");
		}
		btnAgregarProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (modo == 1) {
					agregar_proyecto();
				} else if (modo == 2) {
					editar_proyecto();
				}
			}
		});
		btnAgregarProyecto.setBounds(587, 442, 172, 46);
		frame.getContentPane().add(btnAgregarProyecto);
		
		txtApellido1 = new JTextField();
		txtApellido1.setColumns(10);
		txtApellido1.setBounds(244, 93, 210, 20);
		frame.getContentPane().add(txtApellido1);
		
		JLabel lblApellido1 = new JLabel("Apellido 1");
		lblApellido1.setBounds(244, 77, 210, 14);
		frame.getContentPane().add(lblApellido1);
		
		txtApellido2 = new JTextField();
		txtApellido2.setColumns(10);
		txtApellido2.setBounds(244, 140, 210, 20);
		frame.getContentPane().add(txtApellido2);
		
		JLabel lblApellido2 = new JLabel("Apellido 2");
		lblApellido2.setBounds(244, 124, 210, 14);
		frame.getContentPane().add(lblApellido2);
		
		txtMes = new JTextField();
		txtMes.setColumns(10);
		txtMes.setBounds(155, 281, 33, 20);
		frame.getContentPane().add(txtMes);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(198, 281, 33, 20);
		frame.getContentPane().add(txtAno);
		
		JLabel lblDia = new JLabel("D\u00EDa");
		lblDia.setBounds(112, 265, 46, 14);
		frame.getContentPane().add(lblDia);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(155, 265, 46, 14);
		frame.getContentPane().add(lblMes);
		
		JLabel lblAno = new JLabel("A\u00F1o");
		lblAno.setBounds(198, 265, 46, 14);
		frame.getContentPane().add(lblAno);
		
		JLabel lblNewLabel = new JLabel("Agregar materiales");
		lblNewLabel.setBounds(244, 171, 210, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtRegistro0 = new JTextField();
		txtRegistro0.setColumns(10);
		txtRegistro0.setBounds(569, 222, 190, 20);
		frame.getContentPane().add(txtRegistro0);
		
		JLabel lblRegistro0 = new JLabel("0");
		lblRegistro0.setBounds(549, 225, 21, 14);
		frame.getContentPane().add(lblRegistro0);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setBounds(549, 197, 46, 14);
		frame.getContentPane().add(lblRegistro);
		
		JLabel lblRegistro1 = new JLabel("1");
		lblRegistro1.setBounds(549, 250, 21, 14);
		frame.getContentPane().add(lblRegistro1);
		
		txtRegistro1 = new JTextField();
		txtRegistro1.setColumns(10);
		txtRegistro1.setBounds(569, 247, 190, 20);
		frame.getContentPane().add(txtRegistro1);
		
		JLabel lblRegistro2 = new JLabel("2");
		lblRegistro2.setBounds(549, 275, 21, 14);
		frame.getContentPane().add(lblRegistro2);
		
		txtRegistro2 = new JTextField();
		txtRegistro2.setColumns(10);
		txtRegistro2.setBounds(569, 272, 190, 20);
		frame.getContentPane().add(txtRegistro2);
		
		JLabel lblRegistro3 = new JLabel("3");
		lblRegistro3.setBounds(549, 303, 21, 14);
		frame.getContentPane().add(lblRegistro3);
		
		txtRegistro3 = new JTextField();
		txtRegistro3.setColumns(10);
		txtRegistro3.setBounds(569, 300, 190, 20);
		frame.getContentPane().add(txtRegistro3);
		
		if (modo == 2) {
			setDatos();
		} else if (modo == 1) {
			nuevoMaterial();
		}
	}
	
	public void setDatos() {
		MongoDB mongo = new MongoDB();
		Proyecto proyecto = mongo.getProyecto(this._id);
		String nombre_proyecto = proyecto.get_nombre_proyecto();
		String rut = proyecto.get_rut();
		String nombre = proyecto.get_nombre().get_nombre();
		String apellido1 = proyecto.get_nombre().get_apellido1();
		String apellido2 = proyecto.get_nombre().get_apellido2();
		String calle = proyecto.get_direccion().get_calle();
		String numero = proyecto.get_direccion().get_numero();
		String CCP = proyecto.get_direccion().get_CCP();
		String subsidio = proyecto.get_subsidio();
		String monto_subsidio = proyecto.get_monto_subsidio();
		String presupuesto = proyecto.get_presupuesto();
		String duracion_obra = proyecto.get_duracion_obra();
		String dia = proyecto.get_fecha_inicio().get_dia();
		String mes = proyecto.get_fecha_inicio().get_mes();
		String ano = proyecto.get_fecha_inicio().get_ano();
		String estado_obra = proyecto.get_estado_obra();
		ArrayList<String> materiales_usados = proyecto.get_materiales_usados();
		ArrayList<String> registro = proyecto.get_registro();
		
		txtNombreProyecto.setText(nombre_proyecto);
		txtRut.setText(rut);
		txtNombrePersona.setText(nombre);
		txtApellido1.setText(apellido1);
		txtApellido2.setText(apellido2);
		txtCalle.setText(calle);
		txtNumero.setText(numero);
		txtCCP.setText(CCP);
		txtSubsidio.setText(subsidio);
		txtMontoSubsidio.setText(monto_subsidio);
		txtPresupuesto.setText(presupuesto);
		txtDuracionObra.setText(duracion_obra);
		txtDia.setText(dia);
		txtMes.setText(mes);
		txtAno.setText(ano);
		txtEstadoObra.setText(estado_obra);
		
		// Object "materiales_usados"
		for (String material_usado : materiales_usados) {
			nuevoMaterial(material_usado);
		}
		
		// Object "registro"
		int i = 0;
		for (String _registro : registro) {
			if (i == 0) {
				txtRegistro0.setText(_registro);
			} else if (i == 1) {
				txtRegistro1.setText(_registro);
			} else if (i == 2) {
				txtRegistro2.setText(_registro);
			} else if (i == 3) {
				txtRegistro3.setText(_registro);
			}
			i += 1;
		}
	}
	
	public void editar_proyecto() {
		String nombre_proyecto = txtNombreProyecto.getText();
		String rut = txtRut.getText();
		
		// Object "nombre"
		Nombre nombre;
		String _nombre = txtNombrePersona.getText();
		String apellido1 = txtApellido1.getText();
		String apellido2 = txtApellido2.getText();
		nombre = new Nombre(_nombre, apellido1, apellido2);
		
		// Object "Direccion"
		Direccion direccion;
		String calle = txtCalle.getText();
		String numero = txtNumero.getText();
		String CCP = txtCCP.getText();
		direccion = new Direccion(calle, numero, CCP);
		
		String subsidio = txtSubsidio.getText();
		String monto_subsidio = txtMontoSubsidio.getText();
		String presupuesto = txtPresupuesto.getText();
		String duracion_obra = txtDia.getText();
		
		// Object "fecha_inicio"
		Fecha_inicio fecha_inicio;
		String dia = txtDia.getText();
		String mes = txtMes.getText();
		String ano = txtAno.getText();
		fecha_inicio = new Fecha_inicio(dia, mes, ano);
		
		String estado_obra = txtEstadoObra.getText();
		
		// Object "materiales_usados"
		ArrayList<String> materiales_usados = new ArrayList<String>();
		for (JTextField textField : jTextFields) {
			materiales_usados.add(textField.getText());
		}
		
		// Object "registro"
		ArrayList<String> registro = new ArrayList<String>();
		registro.add(txtRegistro0.getText());
		registro.add(txtRegistro1.getText());
		registro.add(txtRegistro2.getText());
		registro.add(txtRegistro3.getText());
		
		Proyecto proyecto = new Proyecto(nombre_proyecto, rut, nombre, direccion, subsidio, monto_subsidio, presupuesto, duracion_obra, fecha_inicio,
				estado_obra, materiales_usados, registro);
		
		MongoDB mongo = new MongoDB();
		mongo.updtProyecto(_id, proyecto);
		
		frame.setVisible(false);
	}
	
	public void agregar_proyecto() {
		String nombre_proyecto = txtNombreProyecto.getText();
		String rut = txtRut.getText();
		
		// Object "nombre"
		Nombre nombre;
		String _nombre = txtNombrePersona.getText();
		String apellido1 = txtApellido1.getText();
		String apellido2 = txtApellido2.getText();
		nombre = new Nombre(_nombre, apellido1, apellido2);
		
		// Object "Direccion"
		Direccion direccion;
		String calle = txtCalle.getText();
		String numero = txtNumero.getText();
		String CCP = txtCCP.getText();
		direccion = new Direccion(calle, numero, CCP);
		
		String subsidio = txtSubsidio.getText();
		String monto_subsidio = txtMontoSubsidio.getText();
		String presupuesto = txtPresupuesto.getText();
		String duracion_obra = txtDia.getText();
		
		// Object "fecha_inicio"
		Fecha_inicio fecha_inicio;
		String dia = txtDia.getText();
		String mes = txtMes.getText();
		String ano = txtAno.getText();
		fecha_inicio = new Fecha_inicio(dia, mes, ano);
		
		String estado_obra = txtEstadoObra.getText();
		
		// Object "materiales_usados"
		ArrayList<String> materiales_usados = new ArrayList<String>();
		for (JTextField textField : jTextFields) {
			materiales_usados.add(textField.getText());
		}
		
		// Object "registro"
		ArrayList<String> registro = new ArrayList<String>();
		registro.add(txtRegistro0.getText());
		registro.add(txtRegistro1.getText());
		registro.add(txtRegistro2.getText());
		registro.add(txtRegistro3.getText());
		
		Proyecto proyecto = new Proyecto(nombre_proyecto, rut, nombre, direccion, subsidio, monto_subsidio, presupuesto, duracion_obra, fecha_inicio,
				estado_obra, materiales_usados, registro);
		
		MongoDB mongo = new MongoDB();
		mongo.addProyecto(proyecto);
		frame.setVisible(false);
	}
	
	public void nuevoMaterial() {
		// y + 23
		
		JTextField textField = new JTextField();
		textField.setColumns(10);
		txtField_y += 23;
		textField.setBounds(txtField_x, txtField_y, txtField_width, txtField_height);
		frame.getContentPane().add(textField);
		jTextFields.add(textField);
		textField.repaint();
		
		JButton btn = new JButton("+");
		btn_y += 23;
		btn.setBounds(btn_x, btn_y, btn_width, btn_height);
		frame.getContentPane().add(btn);
		jButtons.add(btn);
		
		btn.repaint();
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nuevoMaterial();
			}
		});
	}
	
	public void nuevoMaterial(String nuevo_material) {
		// y + 23
		
		JTextField textField = new JTextField(nuevo_material);
		textField.setColumns(10);
		txtField_y += 23;
		textField.setBounds(txtField_x, txtField_y, txtField_width, txtField_height);
		frame.getContentPane().add(textField);
		jTextFields.add(textField);
		textField.repaint();
		
		JButton btn = new JButton("+");
		btn_y += 23;
		btn.setBounds(btn_x, btn_y, btn_width, btn_height);
		frame.getContentPane().add(btn);
		jButtons.add(btn);
		
		btn.repaint();
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				nuevoMaterial();
			}
		});
	}
	
	
	
	
}
