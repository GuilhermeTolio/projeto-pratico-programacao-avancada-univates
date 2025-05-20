package screen;

import entity.animalEntity;
import controller.animalController;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class animalScreen extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTabbedPane tabbedPane1;
    private JButton salvarButton;
    private JTable AnimalTable;
    private JButton excluirButton;
    private JButton editarButton;
    private JButton AtualizarButton;

    animalController animalController = new animalController();
    int codigo = 0;

    public animalScreen() {
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
                animalEntity animal = new animalEntity();
                animal.setNome(textField1.getText());
                animal.setEspecie(textField2.getText());
                animal.setRaca(textField3.getText());
                animal.setIdade(textField4.getText());
                animal.setEstadoSaude(textField5.getText());
                animal.setHistoricoVacinas(textField6.getText());
                animal.setDataResgate(textField7.getText());

                if (codigo == 0) {
                    boolean retorno = animalController.save(animal);
                    if (retorno) {
                        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
                        clearFields();
                        resetCodigo();
                        refreshTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro, verifique os logs.");
                    }
                } else {
                    animal.setId(codigo);
                    boolean retorno = animalController.edit(animal);
                    if (retorno) {
                        JOptionPane.showMessageDialog(null, "Editado com sucesso");
                        clearFields();
                        resetCodigo();
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
                String idString = String.valueOf(AnimalTable.getValueAt(AnimalTable.getSelectedRow(), 0));
                int id = Integer.parseInt(idString);

                animalEntity animal = animalController.recover(id);

                if (animal == null) {
                    JOptionPane.showMessageDialog(null, "Registro não localizado!");
                } else {
                    codigo = animal.getId();
                    tabbedPane1.setSelectedIndex(0);

                    textField1.setText(animal.getNome());
                    textField2.setText(animal.getEspecie());
                    textField3.setText(animal.getRaca());
                    textField4.setText(animal.getIdade());
                    textField5.setText(animal.getEstadoSaude());
                    textField6.setText(animal.getHistoricoVacinas());
                    textField7.setText(animal.getDataResgate());
                }
            }
        });

        excluirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idString = String.valueOf(AnimalTable.getValueAt(AnimalTable.getSelectedRow(), 0));
                int id = Integer.parseInt(idString);

                boolean retorno = animalController.delete(id);
                if (retorno) {
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!");
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao excluir!");
                }
            }
        });
    }

    // Método para atualizar a tabela
    private void refreshTable() {
        makeTable();
    }

    // Método para limpar os campos
    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }

    private void resetCodigo() {
        codigo = 0;
    }

    public void show() {
        JFrame frame = new JFrame("Manter Animais");
        frame.setContentPane(tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void makeTable() {
        ArrayList<animalEntity> animal = animalController.recoverAll();
        if (animal == null) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar animais");
        } else {
            AnimalTable.setModel(new AbstractTableModel() {
                @Override
                public String getColumnName(int column) {
                    switch (column) {
                        case 0:
                            return "ID";
                        case 1:
                            return "Nome";
                        case 2:
                            return "Espécie";
                        case 3:
                            return "Raça";
                        case 4:
                            return "Idade";
                        case 5:
                            return "Estado de Saúde";
                        case 6:
                            return "Histórico de Vacina";
                        case 7:
                            return "Data de Resgate";
                        default:
                            return "";
                    }
                }

                @Override
                public int getRowCount() {
                    return animal.size();
                }

                @Override
                public int getColumnCount() {
                    return 8;
                }

                public Object getValueAt(int rowIndex, int columnIndex) {
                    animalEntity a = animal.get(rowIndex);

                    if (a != null) {
                        switch (columnIndex) {
                            case 0:
                                return a.getId();
                            case 1:
                                return a.getNome();
                            case 2:
                                return a.getEspecie();
                            case 3:
                                return a.getRaca();
                            case 4:
                                return a.getIdade();
                            case 5:
                                return a.getEstadoSaude();
                            case 6:
                                return a.getHistoricoVacinas();
                            case 7:
                                return a.getDataResgate();
                        }
                    }
                    return "n/d";
                }
            });
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("animalScreen");
        frame.setContentPane(new animalScreen().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
