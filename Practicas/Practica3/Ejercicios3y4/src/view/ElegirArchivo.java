package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CollectionController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;

public class ElegirArchivo extends JDialog {

	private static final long serialVersionUID = 6642089645578319471L;
	private MainWindow main;
	private CollectionController c;

	private JPanel contentPane;
	private JPanel panelBotones;
	private JPanel panelPrincipal;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JLabel lblEligeUnArchivo;
	private JTextField textField;
	private JLabel lblError;

	/**
	 * Create the frame.
	 */
	public ElegirArchivo(MainWindow parent, CollectionController c) {
		super(parent, "ElegirArchivo");
		main = parent;
		this.c = c;
		initialize();
	}
	
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelBotones(), BorderLayout.SOUTH);
		contentPane.add(getPanelPrincipal(), BorderLayout.CENTER);
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnCancelar());
			panelBotones.add(getBtnAceptar());
		}
		return panelBotones;
	}
	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.add(getLblEligeUnArchivo());
			panelPrincipal.add(getTextField());
			panelPrincipal.add(getLblError());
		}
		return panelPrincipal;
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
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(c.parseFile(textField.getText())) {
						main.updateTable();
						dispose();
					} else {
						lblError.setVisible(true);
					}
					
				}
			});
		}
		return btnAceptar;
	}
	private JLabel getLblEligeUnArchivo() {
		if (lblEligeUnArchivo == null) {
			lblEligeUnArchivo = new JLabel("Elige un archivo xml:");
		}
		return lblEligeUnArchivo;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(40);
		}
		return textField;
	}
	private JLabel getLblError() {
		if (lblError == null) {
			lblError = new JLabel("Ha habido un problema procesando ese archivo");
			lblError.setVisible(false);
			lblError.setForeground(Color.RED);
		}
		return lblError;
	}
}
