package view;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CollectionController;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.JButton;

public class AñadirPelicula extends JDialog {

	private static final long serialVersionUID = -6627657772539714137L;
	MainWindow main;
	CollectionController c;
	int editada;
	
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JTextField textTitulo;
	private JPanel panelPrincipal;
	private JPanel panelBotones;
	private JLabel lblAño;
	private JTextField textFieldAño;
	private JLabel lblDirector;
	private JTextField textFieldDirector;
	private JLabel lblActores;
	private JTextField textFieldActores;
	private JLabel lblAadeLosActores;
	private JPanel panel;
	private JButton btnCancelar;
	private JButton btnAadir;

	/**
	 * Create the frame.
	 */
	public AñadirPelicula(MainWindow parent, CollectionController c, String text) {
		super(parent, text);
		main = parent;
		this.c = c;
		editada = -1;
		initialize();
	}

	public void setIndex(int i) {
		editada = i;
		textTitulo.setText(c.getTitulo(i));
		textFieldAño.setText(c.getFecha(i));
		textFieldDirector.setText(c.getDirector(i));
		textFieldActores.setText(c.getActores(i));
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelBotones(), BorderLayout.SOUTH);
		contentPane.add(getPanel(), BorderLayout.CENTER);
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Titulo:*");
		}
		return lblTitulo;
	}
	private JTextField getTextTitulo() {
		if (textTitulo == null) {
			textTitulo = new JTextField();
			textTitulo.setColumns(30);
		}
		return textTitulo;
	}
	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 0));
			GridBagLayout gbl_panelPrincipal = new GridBagLayout();
			gbl_panelPrincipal.columnWidths = new int[]{95, 309, 0};
			gbl_panelPrincipal.rowHeights = new int[]{35, 35, 35, 35, 0};
			gbl_panelPrincipal.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panelPrincipal.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panelPrincipal.setLayout(gbl_panelPrincipal);
			GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
			gbc_lblTitulo.fill = GridBagConstraints.BOTH;
			gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitulo.gridx = 0;
			gbc_lblTitulo.gridy = 0;
			panelPrincipal.add(getLblTitulo(), gbc_lblTitulo);
			GridBagConstraints gbc_textTitulo = new GridBagConstraints();
			gbc_textTitulo.fill = GridBagConstraints.BOTH;
			gbc_textTitulo.insets = new Insets(0, 0, 5, 0);
			gbc_textTitulo.gridx = 1;
			gbc_textTitulo.gridy = 0;
			panelPrincipal.add(getTextTitulo(), gbc_textTitulo);
			GridBagConstraints gbc_lblAño = new GridBagConstraints();
			gbc_lblAño.fill = GridBagConstraints.BOTH;
			gbc_lblAño.insets = new Insets(0, 0, 5, 5);
			gbc_lblAño.gridx = 0;
			gbc_lblAño.gridy = 1;
			panelPrincipal.add(getLblAño(), gbc_lblAño);
			GridBagConstraints gbc_textFieldAño = new GridBagConstraints();
			gbc_textFieldAño.fill = GridBagConstraints.BOTH;
			gbc_textFieldAño.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldAño.gridx = 1;
			gbc_textFieldAño.gridy = 1;
			panelPrincipal.add(getTextFieldAño(), gbc_textFieldAño);
			GridBagConstraints gbc_lblDirector = new GridBagConstraints();
			gbc_lblDirector.fill = GridBagConstraints.BOTH;
			gbc_lblDirector.insets = new Insets(0, 0, 5, 5);
			gbc_lblDirector.gridx = 0;
			gbc_lblDirector.gridy = 2;
			panelPrincipal.add(getLblDirector(), gbc_lblDirector);
			GridBagConstraints gbc_textFieldDirector = new GridBagConstraints();
			gbc_textFieldDirector.fill = GridBagConstraints.BOTH;
			gbc_textFieldDirector.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldDirector.gridx = 1;
			gbc_textFieldDirector.gridy = 2;
			panelPrincipal.add(getTextFieldDirector(), gbc_textFieldDirector);
			GridBagConstraints gbc_lblActores = new GridBagConstraints();
			gbc_lblActores.fill = GridBagConstraints.BOTH;
			gbc_lblActores.insets = new Insets(0, 0, 0, 5);
			gbc_lblActores.gridx = 0;
			gbc_lblActores.gridy = 3;
			panelPrincipal.add(getLblActores(), gbc_lblActores);
			GridBagConstraints gbc_textFieldActores = new GridBagConstraints();
			gbc_textFieldActores.fill = GridBagConstraints.BOTH;
			gbc_textFieldActores.gridx = 1;
			gbc_textFieldActores.gridy = 3;
			panelPrincipal.add(getTextFieldActores(), gbc_textFieldActores);
		}
		return panelPrincipal;
	}
	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnCancelar());
			panelBotones.add(getBtnAñadir());
		}
		return panelBotones;
	}
	private JLabel getLblAño() {
		if (lblAño == null) {
			lblAño = new JLabel("A\u00F1o:*");
		}
		return lblAño;
	}
	private JTextField getTextFieldAño() {
		if (textFieldAño == null) {
			textFieldAño = new JTextField();
			textFieldAño.setColumns(30);
		}
		return textFieldAño;
	}
	private JLabel getLblDirector() {
		if (lblDirector == null) {
			lblDirector = new JLabel("Director:");
		}
		return lblDirector;
	}
	private JTextField getTextFieldDirector() {
		if (textFieldDirector == null) {
			textFieldDirector = new JTextField();
			textFieldDirector.setColumns(30);
		}
		return textFieldDirector;
	}
	private JLabel getLblActores() {
		if (lblActores == null) {
			lblActores = new JLabel("Actores:");
		}
		return lblActores;
	}
	private JTextField getTextFieldActores() {
		if (textFieldActores == null) {
			textFieldActores = new JTextField();
			textFieldActores.setColumns(30);
		}
		return textFieldActores;
	}
	private JLabel getLblAadeLosActores() {
		if (lblAadeLosActores == null) {
			lblAadeLosActores = new JLabel("A\u00F1ade los actores separados por comas \"actor1,actor2,etc\"");
			lblAadeLosActores.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblAadeLosActores.setEnabled(false);
		}
		return lblAadeLosActores;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(getPanelPrincipal());
			panel.add(getLblAadeLosActores());
		}
		return panel;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnCancelar;
	}
	private JButton getBtnAñadir() {
		if (btnAadir == null) {
			btnAadir = new JButton("A\u00F1adir");
			btnAadir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String titulo = textTitulo.getText();
					String año = textFieldAño.getText();
					String director = textFieldDirector.getText();
					String actores = textFieldActores.getText();
					if(titulo.isEmpty() || año.isEmpty()) {
						JOptionPane.showMessageDialog(main, "El título y el año son campos obligatorios");
						return;
					}
					if(editada != -1) {
						c.getColeccion().removePelicula(editada);
					}
					c.addPelicula(titulo, año, director, actores);
					main.updateTable();
					dispose();
				}
			});
		}
		return btnAadir;
	}
}
