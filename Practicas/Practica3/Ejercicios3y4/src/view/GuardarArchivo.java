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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class GuardarArchivo extends JDialog {
	
	private static final long serialVersionUID = -9084471514698125756L;

	private CollectionController c;

	private JPanel contentPane;
	private JPanel panelBotones;
	private JPanel panelPrincipal;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JLabel lblTipo;
	private JComboBox<String> comboBoxTipo;
	private JTextField textFieldArchivo;
	private JPanel panel;
	private JLabel lblEligeDndeQuieres;

	/**
	 * Create the frame.
	 */
	public GuardarArchivo(JFrame parent, CollectionController c) {
		super(parent, "ElegirArchivo");
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
		contentPane.add(getLblEligeDndeQuieres(), BorderLayout.NORTH);
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnCancelar());
			panelBotones.add(getBtnGuardar());
		}
		return panelBotones;
	}
	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
			panelPrincipal.add(getPanel());
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
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					switch(comboBoxTipo.getSelectedIndex()) {
					case 0:
						c.saveXML(textFieldArchivo.getText());
						break;
					case 1:
						c.savePretty(textFieldArchivo.getText());
						break;
					default:
						break;
					}
					dispose();
				}
			});
		}
		return btnGuardar;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
		}
		return lblTipo;
	}
	private JComboBox<String> getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox<String>();
			comboBoxTipo.setModel(new DefaultComboBoxModel<String>(new String[] {".xml", ".txt"}));
		}
		return comboBoxTipo;
	}
	private JTextField getTextFieldArchivo() {
		if (textFieldArchivo == null) {
			textFieldArchivo = new JTextField();
			textFieldArchivo.setColumns(20);
		}
		return textFieldArchivo;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLblTipo());
			panel.add(getComboBoxTipo());
			panel.add(getTextFieldArchivo());
		}
		return panel;
	}
	private JLabel getLblEligeDndeQuieres() {
		if (lblEligeDndeQuieres == null) {
			lblEligeDndeQuieres = new JLabel("Elige d\u00F3nde quieres guardar la colecci\u00F3n:");
		}
		return lblEligeDndeQuieres;
	}
}
