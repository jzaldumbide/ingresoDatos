import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class formInsercion {
    private JButton button1;
    JPanel form1;
    private JLabel mensajeTxt;
    private JButton insertarButton;
    private JTextField calif2TF;
    private JTextField calif1TF;
    private JTextField cedulaTF;
    private JTextField nombreTF;
    private JButton borrarCamposButton;

    public formInsercion() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conexionBDD miconexion=new conexionBDD();
                miconexion.conexionLocal(
                        "jdbc:mysql://localhost:3306/estudiantes",
                        "root","");
                mensajeTxt.setText(miconexion.getMensaje());
            }

        });
        borrarCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreTF.setText("");
                cedulaTF.setText("");
                calif2TF.setText("");
                calif1TF.setText("");
            }
        });
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarDatos insertardatos=new insertarDatos();
                insertardatos.ingresoDatos(nombreTF.getText(), cedulaTF.getText(),
                        Integer.parseInt(calif1TF.getText()),
                        Integer.parseInt(calif2TF.getText()));
            }
        });
    }
}
