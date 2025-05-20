package screen;

import entity.peopleEntity;
import controller.peopleController;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class peopleScreen extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTabbedPane tabbedPane1;
    private JButton salvarButton;
    private JTable peopleTable;
    private JButton excluirButton;
    private JButton editarButton;
    private JCheckBox voluntarioCheckBox;
    private JButton AtualizarButton;

    peopleController peopleController = new peopleController();
    int codigo = 0;

    public peopleScreen() {
        makeTable();
            
        AtualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peopleEntity person = new peopleEntity();
                person.setName(textField1.getText());
                person.setCpfCnpj(textField2.getText());
                person.setTelephone(textField3.getText());
                person.setEmail(textField4.getText());
                person.setType(textField5.getText());
                person.setHistoric(textField6.getText());
                person.setVolunteer(voluntarioCheckBox.isSelected());

                if (codigo == 0) {
                    boolean retorno = peopleController.save(person);
                    if (retorno) {
                        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                        clearFields();
                        refreshTable();
                    
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, verifique os logs.");
                    }
                } else {
                    person.setId(codigo);
                    boolean retorno = peopleController.edit(person);
                    if (retorno) {
                        JOptionPane.showMessageDialog(null, "Editado com sucesso");
                        clearFields();
                        refreshTable();
                        tabbedPane1.setSelectedIndex(1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, verifique os logs.");
                    }
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = String.valueOf(peopleTable.getValueAt(peopleTable.getSelectedRow(), 0));
                int id = Integer.parseInt(idString);

                peopleEntity person = peopleController.recover(id);

                if (person == null) {
                    JOptionPane.showMessageDialog(null, "Registro não localizado!");
                } else {
                    codigo = person.getId();
                    tabbedPane1.setSelectedIndex(0);

                    textField1.setText(person.getName());
                    textField2.setText(person.getCpfCnpj());
                    textField3.setText(person.getTelephone());
                    textField4.setText(person.getEmail());
                    textField5.setText(person.getType());
                    textField6.setText(person.getHistoric());
                    voluntarioCheckBox.setSelected(person.isVolunteer());
                }
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = String.valueOf(peopleTable.getValueAt(peopleTable.getSelectedRow(), 0));
                int id = Integer.parseInt(idString);

                boolean retorno = peopleController.delete(id);
                if (retorno) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir!");
                }
            }
        });
    }

    private void refreshTable() {
        makeTable();
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        voluntarioCheckBox.setSelected(false);
        codigo = 0;
    }

    public void show() {
        JFrame frame = new JFrame("Manter Pessoas");
        frame.setContentPane(tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void makeTable() {
        ArrayList<peopleEntity> people = peopleController.recoverAll();
        if (people == null) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pessoas");
        } else {
            peopleTable.setModel(new AbstractTableModel() {
                @Override
                public String getColumnName(int column) {
                    switch (column) {
                        case 0:
                            return "ID";
                        case 1:
                            return "Nome";
                        case 2:
                            return "CPF/CNPJ";
                        case 3:
                            return "Telefone";
                        case 4:
                            return "Email";
                        case 5:
                            return "Tipo";
                        case 6:
                            return "Histórico";
                        case 7:
                            return "Voluntário";
                        default:
                            return "";
                    }
                }

                @Override
                public int getRowCount() {
                    return people.size();
                }

                @Override
                public int getColumnCount() {
                    return 8;
                }

                public Object getValueAt(int rowIndex, int columnIndex) {
                    peopleEntity p = people.get(rowIndex);

                    if (p != null) {
                        switch (columnIndex) {
                            case 0:
                                return p.getId();
                            case 1:
                                return p.getName();
                            case 2:
                                return p.getCpfCnpj();
                            case 3:
                                return p.getTelephone();
                            case 4:
                                return p.getEmail();
                            case 5:
                                return p.getType();
                            case 6:
                                return p.getHistoric();
                            case 7:
                                return p.isVolunteer() ? "Sim" : "Não";
                        }
                    }
                    return "n/d";
                }
            });
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("peopleScreen");
        frame.setContentPane(new peopleScreen().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
