package Vista;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import bd.ItemA;
import bd.ItemB;
import bd.ItemC;
import bd.ItemD;
import bd.ItemF;
import bd.ItemH;
import bd.ItemI;
import bd.Materiales;
import bd.MongoDB;
import bd.Proyecto;

import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ScrollPaneConstants;

public class Administracion extends JFrame {

	private static final long serialVersionUID = 7758166338717075721L;
	
	public JLayeredPane layeredPane_1 = new JLayeredPane();
	public DefaultTableModel modeloTabla;
	public ArrayList<Materiales> elementosTablaMateriales;
	public ArrayList<ItemA> elementosTablaItemA;
	public ArrayList<ItemB> elementosTablaItemB;
	public ArrayList<ItemC> elementosTablaItemC;
	public ArrayList<ItemD> elementosTablaItemD;
	public ArrayList<ItemF> elementosTablaItemF;
	public ArrayList<ItemH> elementosTablaItemH;
	public ArrayList<ItemI> elementosTablaItemI;
	public ArrayList<Proyecto> elementosTablaProyectos;
//	public ArrayList<Usuarios> elementosTablaUsuarios;
//	public ArrayList<Articulos> elementosTablaArticulos;
//	public ArrayList<RegistrosCompras> elementosTablaRegistrosCompras;
//	public ArrayList<RegistrosVentas> elementosTablaRegistrosVentas; 
	//public String nombreAdmin;
	
	private int xMouse;
	private int yMouse;
	// modo = 1 : Agregación
	// modo = 2 : Edición
	public int modo = 1;
	public int columnaPK = 1;
	private JPanel IconoIlovenyPanel;
	private JButton btnUsuarios;
	private JButton btnArticulos;
	private JScrollPane tablaScrollPane;
	private JTable tabla;
	private JLayeredPane funcionesLayeredPane;
//	public AgregarUsuarioPanel agregarUsuarioPanel;
//	public AgregarArticuloPanel agregarArticuloPanel;
//	public AgregarRegistroVentaPanel agregarRegistroVentaPanel;
//	public AgregarRegistroCompraPanel agregarRegistroCompraPanel;
	private JPanel panelPrincipal;
	private JButton btnRegistroCompra;
	private TableRowSorter<TableModel> sorter;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblTabla;
	private JButton btnNewButton;
	private JButton btnEliminar;
	private JButton btnEditar;
	private JButton btnAgregar;
	private JButton btnActualizar;

	public Administracion() {
		//TODO setIconImage(Toolkit.getDefaultToolkit().getImage(Administracion.class.getResource("/imagenes/iloveny-icon.png")));
		initialize();
	}

	private void initialize() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 755, 643);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		this.construirPanelIloveny();
		this.construirPanelMenu();
		this.construirHeader();
		this.iniciarPanelPrincipal();		
	}
	
	private void iniciarPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(10, 39, 732, 558);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		tabla = new JTable();
		tabla.setShowGrid(false);
		tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Descripción", "Unidad", "Precio Vigente (UF)"
				}
		));
		tabla.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent mouseEvent) {
				JTable table = (JTable)mouseEvent.getSource();
				Point point = mouseEvent.getPoint();
				int row = table.rowAtPoint(point);
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					switch (modo) {
						case 1:
							String value1 = tabla.getValueAt(row, 0).toString();
//							new DetallesUsuario(value1);
							break;
						case 2:
							String value2 = tabla.getValueAt(row, 5).toString();
//							new DetallesArticulo(value2);
							break;
						case 3:
							String value3 = tabla.getValueAt(row, 3).toString();
//							new DetallesRegistroVenta(value3);
							break;
						case 4:
							String value4 = tabla.getValueAt(row, 6).toString();
//							new DetallesRegistroCompra(value4);
							break;
					}
				}
			}
		});
		
		iniciarTabla();
		rellenarTabla();
		
		panelPrincipal.add(tablaScrollPane);
		
		lblTabla = new JLabel("Materiales");
		lblTabla.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTabla.setBounds(280, 11, 127, 38);
		panelPrincipal.add(lblTabla);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(632, 91, 89, 23);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarFilaTabla();
			}
			
		});
		btnEliminar.setEnabled(false);
		panelPrincipal.add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tabla.getSelectedRow() > -1) {
					switch(modo) {
						case 3:
							String _id = tabla.getValueAt(tabla.getSelectedRow(), 11).toString();
							new AgregarProyectos(2, _id).frame.setVisible(true);
							//cambiarPanel(agregarRegistroVentaPanel);
							break;
						default:
					
					}
					//moverLayeredPanel();
					//panelPrincipal.setVisible(false);
				} else {
					Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
					JOptionPane.showMessageDialog(null, "Porfavor, seleccione una fila","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
				}
			
			}
		});
		btnEditar.setBounds(533, 91, 89, 23);
		btnEditar.setEnabled(false);
		panelPrincipal.add(btnEditar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(modo) {
					case 3:
						new AgregarProyectos(1).frame.setVisible(true);;
						break;
					default:
				
				}
			}
		});
		btnAgregar.setBounds(434, 91, 89, 23);
		panelPrincipal.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarDatosTabla();
				repintarTabla();
				rellenarTabla();
			}
		});
		btnActualizar.setBounds(10, 91, 115, 23);
		panelPrincipal.add(btnActualizar);
		
		btnNewButton_3 = new JButton("Materiales");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 1) {
					btnEliminar.setEnabled(false);
					btnEditar.setEnabled(false);
					btnAgregar.setEnabled(false);
					modo = 1;
					columnaPK = 1;
					eliminarDatosTabla();
					//lblTitulo.setText("Usuarios");
					lblTabla.setText("Materiales");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Descripción", "Unidad", "Precio Vigente (UF)"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnNewButton_3.setBounds(241, 5, 104, 23);
		getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Partidas");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 2) {
					btnEliminar.setEnabled(false);
					btnEditar.setEnabled(false);
					btnAgregar.setEnabled(false);
					modo = 2;
					columnaPK = 1;
					eliminarDatosTabla();
					//lblTitulo.setText("Usuarios");
					lblTabla.setText("Partidas");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Partida", "Designación", "Unidad", "Precio Total"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnNewButton_4.setBounds(355, 5, 104, 23);
		getContentPane().add(btnNewButton_4);
		
		btnNewButton = new JButton("Proyectos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 3) {
					btnEditar.setEnabled(true);
					btnEliminar.setEnabled(true);
					btnAgregar.setEnabled(true);
					modo = 3;
					columnaPK = 1;
					eliminarDatosTabla();
					//lblTitulo.setText("Usuarios");
					lblTabla.setText("Proyectos");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Nombre Proyecto", "Rut", "Nombre", "Direccion", "Subsidio", "Monto Subsidio", "Presupuesto", "Duración Obra",
									"Fecha Inicio", "Estado de obra", "Registro", "_id"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnNewButton.setBounds(10, 5, 111, 23);
		getContentPane().add(btnNewButton);
	}

	private void repintarTabla() {
		modeloTabla = (DefaultTableModel)tabla.getModel();
		int espacioParaColumna = 0;
		if(150*tabla.getColumnCount() <= 711) {
			espacioParaColumna = 711/tabla.getColumnCount();
			if(espacioParaColumna*tabla.getColumnCount()<711) {
				espacioParaColumna+=(711-espacioParaColumna*tabla.getColumnCount());
			}
		} else {
			espacioParaColumna = 150;
		}
		for(int i = 0; i<tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(espacioParaColumna);
			tabla.setBounds(0, 0, tablaScrollPane.getWidth(), tablaScrollPane.getHeight());
			sorter = new TableRowSorter<TableModel>(tabla.getModel());
			tabla.setRowSorter(sorter);
			List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
			sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
			sorter.setSortKeys(sortKeys);
		}
	}
	
	private void iniciarTabla() {
		modeloTabla = (DefaultTableModel)tabla.getModel();
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.setPreferredScrollableViewportSize(tabla.getPreferredSize());
		for(int i = 0; i<tabla.getColumnCount(); i++) {
			tabla.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
		tabla.getTableHeader().setOpaque(false);
		tabla.getTableHeader().setForeground(new Color(255, 255, 255));
		tablaScrollPane = new JScrollPane(tabla);
		tablaScrollPane.getViewport().setOpaque(false);
		tablaScrollPane.setOpaque(false);
		tablaScrollPane.setBounds(10, 114, 711, 434);
		
		tabla.setBounds(0, 0, tablaScrollPane.getWidth(), tablaScrollPane.getHeight());
		tabla.getTableHeader().setBackground(new Color(51,51,51));
		
		sorter = new TableRowSorter<TableModel>(tabla.getModel());
		tabla.setRowSorter(sorter);
		
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
		sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
	}

	private void construirHeader() {
		this.eventoHeader();
		this.eventoBotonX();
	}

	public void construirPanelMenu() {
	}
	
	private void reacomodarPaneles() {
		panelPrincipal.setVisible(true);
		funcionesLayeredPane.setBounds(929,39,732,558);
	}	
	
	public void eliminarDatosTabla() {
		int rowCount = modeloTabla.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}
	
	public void rellenarTabla() {
		MongoDB mongo = new MongoDB();
		switch(modo) {
		case 1:
			elementosTablaMateriales = mongo.getMateriales();
			Vector<String> elementos1 = new Vector<String>();
			for (int i = 0; i < elementosTablaMateriales.size(); i++) {
				elementos1 = new Vector<String>();
				elementos1.add(elementosTablaMateriales.get(i).get_descripcion());
				elementos1.add(elementosTablaMateriales.get(i).get_unidad());
				elementos1.add(elementosTablaMateriales.get(i).get_precio_vigente_uf());
				modeloTabla.addRow(elementos1);
			}
			break;
		case 2:
			elementosTablaItemA = mongo.getItemA();
			elementosTablaItemB = mongo.getItemB();
			elementosTablaItemC = mongo.getItemC();
			elementosTablaItemD = mongo.getItemD();
			elementosTablaItemF = mongo.getItemF();
			elementosTablaItemH = mongo.getItemH();
			elementosTablaItemI = mongo.getItemI();
			Vector<String> elementos2 = new Vector<String>();
			for (int i = 0; i < elementosTablaItemA.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemA.get(i).get_partida());
				elementos2.add(elementosTablaItemA.get(i).get_designacion());
				elementos2.add(elementosTablaItemA.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemA.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			for (int i = 0; i < elementosTablaItemB.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemB.get(i).get_partida());
				elementos2.add(elementosTablaItemB.get(i).get_designacion());
				elementos2.add(elementosTablaItemB.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemB.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			for (int i = 0; i < elementosTablaItemC.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemC.get(i).get_partida());
				elementos2.add(elementosTablaItemC.get(i).get_designacion());
				elementos2.add(elementosTablaItemC.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemC.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			for (int i = 0; i < elementosTablaItemD.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemD.get(i).get_partida());
				elementos2.add(elementosTablaItemD.get(i).get_designacion());
				elementos2.add(elementosTablaItemD.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemD.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			for (int i = 0; i < elementosTablaItemF.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemF.get(i).get_partida());
				elementos2.add(elementosTablaItemF.get(i).get_designacion());
				elementos2.add(elementosTablaItemF.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemF.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			for (int i = 0; i < elementosTablaItemH.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemH.get(i).get_partida());
				elementos2.add(elementosTablaItemH.get(i).get_designacion());
				elementos2.add(elementosTablaItemH.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemH.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			for (int i = 0; i < elementosTablaItemI.size(); i++) {
				elementos2 = new Vector<String>();
				elementos2.add(elementosTablaItemI.get(i).get_partida());
				elementos2.add(elementosTablaItemI.get(i).get_designacion());
				elementos2.add(elementosTablaItemI.get(i).get_unidad());
				elementos2.add(String.valueOf(elementosTablaItemI.get(i).get_preciototal()));
				modeloTabla.addRow(elementos2);
			}
			break;
		case 3:
			elementosTablaProyectos = mongo.getProyectos();
			Vector<String> elementos3 = new Vector<String>();
			for (int i = 0; i < elementosTablaProyectos.size(); i++) {
				elementos3 = new Vector<String>();
				elementos3.add(elementosTablaProyectos.get(i).get_nombre_proyecto());
				elementos3.add(elementosTablaProyectos.get(i).get_rut());
				elementos3.add(elementosTablaProyectos.get(i).get_nombre().get_nombre().trim() +
						" " + elementosTablaProyectos.get(i).get_nombre().get_apellido1().trim() +
						" " + elementosTablaProyectos.get(i).get_nombre().get_apellido2().trim());
				elementos3.add(elementosTablaProyectos.get(i).get_direccion().get_calle() +
						" " + elementosTablaProyectos.get(i).get_direccion().get_numero() +
						", " + elementosTablaProyectos.get(i).get_direccion().get_CCP());
				elementos3.add(elementosTablaProyectos.get(i).get_subsidio());
				elementos3.add(elementosTablaProyectos.get(i).get_monto_subsidio());
				elementos3.add(elementosTablaProyectos.get(i).get_presupuesto());
				elementos3.add(elementosTablaProyectos.get(i).get_duracion_obra());
				elementos3.add(elementosTablaProyectos.get(i).get_fecha_inicio().get_dia() +
						"/" + elementosTablaProyectos.get(i).get_fecha_inicio().get_mes() +
						"/" + elementosTablaProyectos.get(i).get_fecha_inicio().get_ano());
				elementos3.add(elementosTablaProyectos.get(i).get_estado_obra());
				elementos3.add(elementosTablaProyectos.get(i).get_registro().get(0) +
						", " + elementosTablaProyectos.get(i).get_registro().get(1) +
						", " + elementosTablaProyectos.get(i).get_registro().get(2) +
						", " + elementosTablaProyectos.get(i).get_registro().get(3));
				elementos3.add(elementosTablaProyectos.get(i).get__id());
				modeloTabla.addRow(elementos3);
			}
			break;
		}
	}
	
	public void construirPanelIloveny() {
		
		funcionesLayeredPane = new JLayeredPane();
		funcionesLayeredPane.setLayout(null);
		funcionesLayeredPane.setBounds(929, 39, 732, 558);
		getContentPane().add(funcionesLayeredPane);
		
		btnUsuarios = new JButton("USUARIOS");
		btnUsuarios.setBounds(0, 0, 197, 43);
		//IconoIlovenyPanel.add(btnUsuarios);
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//btnUsuarios.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/user-icon-white.png")));
		btnUsuarios.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 1) {
					modo = 1;
					columnaPK = 2;
					eliminarDatosTabla();
					//lblTitulo.setText("Usuarios");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Rut", "Nombre", "Apellidos", "Telefono", "Email"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}	
		});
		btnUsuarios.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnUsuarios);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setBackground(new Color(34,34,34));
		btnUsuarios.setBorder(null);
		
		btnArticulos = new JButton("ARTICULOS");
		btnArticulos.setBounds(0, 42, 197, 43);
		//IconoIlovenyPanel.add(btnArticulos);
		btnArticulos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		//btnArticulos.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/Box-White.png")));
		btnArticulos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 2) {
					modo = 2;
					columnaPK = 0;
					eliminarDatosTabla();
					//lblTitulo.setText("Articulos");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
								"Tipo", "Marca", "Descripcion", "Stock", "Precio Unitario", "ID"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnArticulos.setFocusPainted(false);
		this.addEventoBotonEnteredAndExitedMenu(btnArticulos);
		btnArticulos.setForeground(Color.WHITE);
		btnArticulos.setBackground(new Color(34,34,34));
		btnArticulos.setBorder(null);
		
		JButton btnRegistroVenta = new JButton("REGISTRO VENTA");
		btnRegistroVenta.setBounds(0, 85, 197, 43);
		//IconoIlovenyPanel.add(btnRegistroVenta);
		//btnRegistroVenta.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/monedas-icono-white.png")));
		btnRegistroVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistroVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 3) {
					modo = 3;
					columnaPK = 4;
					eliminarDatosTabla();
					//lblTitulo.setText("Registro venta");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Fecha", "Cantidad Vendida", "Rut", "ID"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnRegistroVenta.setForeground(Color.WHITE);
		btnRegistroVenta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRegistroVenta.setFocusPainted(false);
		btnRegistroVenta.setBorder(null);
		btnRegistroVenta.setBackground(new Color(34, 34, 34));
		addEventoBotonEnteredAndExitedMenu(btnRegistroVenta);
		
		btnRegistroCompra = new JButton("REGISTRO COMPRA");
		btnRegistroCompra.setBounds(0, 127, 197, 43);
		//IconoIlovenyPanel.add(btnRegistroCompra);
		//btnRegistroCompra.setIcon(new ImageIcon(Administracion.class.getResource("/imagenes/carrito-white.png")));
		btnRegistroCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistroCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(modo != 4) {
					modo = 4;
					columnaPK = 0;
					eliminarDatosTabla();
					//lblTitulo.setText("Registro compra");
					//buscadorTextField.setText("");
					tabla.setModel(new DefaultTableModel(
							new Object[][] {
							},
							new String[] {
									"Usuario", "Nombre Proveedor", "Unidades Adquiridas", "Costo Unitario", "Fecha Pedida", "Fecha Recibo", "ID"
							}
					));
					repintarTabla();
					rellenarTabla();
				}
				if(!panelPrincipal.isVisible()) {
					reacomodarPaneles();
				}
			}
		});
		btnRegistroCompra.setForeground(Color.WHITE);
		btnRegistroCompra.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRegistroCompra.setFocusPainted(false);
		btnRegistroCompra.setBorder(null);
		btnRegistroCompra.setBackground(new Color(34, 34, 34));
		addEventoBotonEnteredAndExitedMenu(btnRegistroCompra);
	}
	
	private void moverLayeredPanel() {
		funcionesLayeredPane.setBounds(197, 39, 732, 558);
	}

	private void cambiarPanel(JPanel panel) {
		funcionesLayeredPane.removeAll();
		funcionesLayeredPane.add(panel);
		funcionesLayeredPane.repaint();
		funcionesLayeredPane.revalidate();
	}
	
	public void addEventoBotonEnteredAndExitedMenu(JButton boton) {
		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setBackground(new Color(221, 30, 38));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				boton.setBackground(new Color(34, 34, 34));
			}
		});
	}
	
	private void eliminarFilaTabla() {
		MongoDB mongo = new MongoDB();
		int row = tabla.getSelectedRow();
		if(row>-1) {
			int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el elemento seleccionado?");
			if (JOptionPane.YES_OPTION == confirm) {
				switch(modo) {
					case 3:
						mongo.delProyecto(tabla.getValueAt(row, 11).toString());
						break;
				}
				eliminarDatosTabla();
				repintarTabla();
				rellenarTabla();
			}
		} else {
			Icon icon = new ImageIcon(Login.class.getResource("/imagenes/Exclamation-mark-icon.png"));
			JOptionPane.showMessageDialog(null, "No tiene una fila seleccioanda","Mensaje",JOptionPane.PLAIN_MESSAGE,icon);
		}
	}
	
	public void addEventoBotonEnteredAndExited(JButton boton){
	}
	
	private void eventoHeader() {
	}

	private void eventoBotonX() {
	}
}
