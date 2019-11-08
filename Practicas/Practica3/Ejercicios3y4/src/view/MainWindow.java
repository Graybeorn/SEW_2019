package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.CollectionController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = -5035406507797604106L;
	private MainWindow main = this;
	private CollectionController controller;
	
	private JFrame frame;
	private JPanel panelControlesLista;
	private JPanel panelControlesApps;
	private JScrollPane scrollPane;
	private JTable tablePeliculas;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnRemove;
	private JButton btnFile;
	private JButton btnSave;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void updateTable() {
		((PeliculasTableModel)tablePeliculas.getModel()).actualizarContenido();;
		tablePeliculas.update(getGraphics());
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		controller = new CollectionController();
		controller.noFile();
		main = this;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPanelControlesLista(), BorderLayout.NORTH);
		frame.getContentPane().add(getPanelControlesApps(), BorderLayout.SOUTH);
		frame.getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanelControlesLista() {
		if (panelControlesLista == null) {
			panelControlesLista = new JPanel();
			panelControlesLista.add(getBtnAdd());
			panelControlesLista.add(getBtnEdit());
			panelControlesLista.add(getBtnRemove());
		}
		return panelControlesLista;
	}
	private JPanel getPanelControlesApps() {
		if (panelControlesApps == null) {
			panelControlesApps = new JPanel();
			panelControlesApps.add(getBtnFile());
			panelControlesApps.add(getBtnSave());
			panelControlesApps.add(getBtnExit());
		}
		return panelControlesApps;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTablePeliculas());
		}
		return scrollPane;
	}
	private JTable getTablePeliculas() {
		if (tablePeliculas == null) {
			tablePeliculas = new JTable(new PeliculasTableModel(controller));
			tablePeliculas.setFillsViewportHeight(true);
		}
		return tablePeliculas;
	}
	private JButton getBtnAdd() {
		if (btnAdd == null) {
			btnAdd = new JButton("Añadir");
			btnAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AñadirPelicula a = new AñadirPelicula(main, controller, "Añadir Pelicula");
					a.setVisible(true);
				}
			});
		}
		return btnAdd;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("Editar");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tablePeliculas.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(main, "Tienes que seleccionar una película");
						return;
					}
					AñadirPelicula a = new AñadirPelicula(main, controller, "Editar Pelicula");
					a.setIndex(tablePeliculas.getSelectedRow());
					a.setVisible(true);
				}
			});
		}
		return btnEdit;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Borrar");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(tablePeliculas.getSelectedRow()==-1) {
						JOptionPane.showMessageDialog(main, "Tienes que seleccionar una película");
						return;
					}
					((PeliculasTableModel)tablePeliculas.getModel()).eliminarPelicula(tablePeliculas.getSelectedRow());
				}
			});
		}
		return btnRemove;
	}
	private JButton getBtnFile() {
		if (btnFile == null) {
			btnFile = new JButton("Elegir archivo");
			btnFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ElegirArchivo archivo = new ElegirArchivo(main, controller);
					archivo.setVisible(true);
				}
			});
		}
		return btnFile;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Guardar lista");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuardarArchivo g = new GuardarArchivo(main, controller);
					g.setVisible(true);
				}
			});
		}
		return btnSave;
	}
	private JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Salir");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
		}
		return btnExit;
	}
}
