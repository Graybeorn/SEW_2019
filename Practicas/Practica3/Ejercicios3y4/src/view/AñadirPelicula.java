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

public class A�adirPelicula extends JDialog {

	private static final long serialVersionUID = -6627657772539714137L;
	MainWindow main;
	CollectionController c;
	int editada;
	
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JTextField textTitulo;
	private JPanel panelPrincipal;
	private JPanel panelBotones;
	private JLabel lblA�o;
	private JTextField textFieldA�o;
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
	public A�adirPelicula(MainWindow parent, CollectionController c, String text) {
		super(parent, text);
		main = parent;
		this.c = c;
		editada = -1;
		initialize();
	}

	public void setIndex(int i) {
		editada = i;
		textTitulo.setText(c.getTitulo(i));
		textFieldA�o.setText(c.getFecha(i));
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
			GridBagConstraints gbc_lblA�o = new GridBagConstraints();
			gbc_lblA�o.fill = GridBagConstraints.BOTH;
			gbc_lblA�o.insets = new Insets(0, 0, 5, 5);
			gbc_lblA�o.gridx = 0;
			gbc_lblA�o.gridy = 1;
			panelPrincipal.add(getLblA�o(), gbc_lblA�o);
			GridBagConstraints gbc_textFieldA�o = new GridBagConstraints();
			gbc_textFieldA�o.fill = GridBagConstraints.BOTH;
			gbc_textFieldA�o.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldA�o.gridx = 1;
			gbc_textFieldA�o.gridy = 1;
			panelPrincipal.add(getTextFieldA�o(), gbc_textFieldA�o);
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
			panelBotones.add(getBtnA�adir());
		}
		return panelBotones;
	}
	private JLabel getLblA�o() {
		if (lblA�o == null) {
			lblA�o = new JLabel("A\u00F1o:*");
		}
		return lblA�o;
	}
	private JTextField getTextFieldA�o() {
		if (textFieldA�o == null) {
			textFieldA�o = new JTextField();
			textFieldA�o.setColumns(30);
		}
		return textFieldA�o;
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
	private JButton getBtnA�adir() {
		if (btnAadir == null) {
			btnAadir = new JButton("A\u00F1adir");
			btnAadir.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String titulo = textTitulo.getText();
					String a�o = textFieldA�o.getText();
					String director = textFieldDirector.getText();
					String actores = textFieldActores.getText();
					if(titulo.isEmpty() || a�o.isEmpty()) {
						JOptionPane.showMessageDialog(main, "El t�tulo y el a�o son campos obligatorios");
						return;
					}
					if(editada != -1) {
						c.getColeccion().removePelicula(editada);
					}
					c.addPelicula(titulo, a�o, director, actores);
					main.updateTable();
					dispose();
				}
			});
		}
		return btnAadir;
	}
}
