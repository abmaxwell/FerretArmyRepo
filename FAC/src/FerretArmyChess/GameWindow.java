package FerretArmyChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class GameWindow {

    GameBoard GB;

    public GameWindow(Game _game) {


        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SourceX = SourceTextX.getText();
                SourceTextX.setText(null);
                String SourceY = SourceTextY.getText();
                SourceTextY.setText(null);
                String DestX = DestTextX.getText();
                DestTextX.setText(null);
                String DestY = DestTestY.getText();
                DestTestY.setText(null);
                int sx = (int) SourceX.charAt(0) - 48;
                int sy = (int) SourceY.charAt(0) - 48;
                int dx = (int) DestX.charAt(0) - 48;
                int dy = (int) DestY.charAt(0) - 48;
//                System.out.print(sx + " , ");
//                System.out.println(sy);
//                System.out.print(dx + " , ");
//                System.out.println(dy);


                boolean validInput = true;
                if (sx < 0 || sx > 8 || sy < 0 || sy > 8 || dx < 0 || dx > 8 || dy < 0 || dy > 8) {
                    validInput = false;
                    MessageBox.setText("Invalid Input");
                }
                //coordinate conversion -sigh-
                sx = 8 - sx;
                sy = 8 - sy;
                dx = 8 - dx;
                dy = 8 - dy;

                System.out.print(sx + " , ");
                System.out.println(sy);
                System.out.print(dx + " , ");
                System.out.println(dy);

                if (validInput) {
                    Piece sourcePiece = _game.getPiece(sx, sy);
                    if (sourcePiece.canMakeValidMove(dx, dy)) {
                        if (_game.inCheck(_game.turn())) {
                            MessageBox.setText(_game.turn().text() + " Checkmate");
                        } else {
                            MessageBox.setText("Moved!");
                        }
                        setGameBoard(new GameBoard(_game));
                    } else {
                        MessageBox.setText("Invalid Move, try again.");
                    }
                    sourcePiece = null;
                }


//                _game.GW.GWPanel.validate();
//                _game.GW.GWPanel.repaint();
                GWPanel.repaint();
            }

        });

        refreshButton.addActionListener(new

                                                ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        GWPanel.repaint();
                                                    }
                                                });
    }

    public static GameWindow main(Game _game) {
        GameWindow GW = new GameWindow(_game);
        JFrame frame = new JFrame("GameWindow");
        frame.setContentPane(GW.GWPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(550, 442);
        frame.setResizable(false);
        frame.setLocation(450, 275);
//        frame.pack();
        frame.setVisible(true);

        return GW;
    }


    public JPanel GWPanel;
    private JTextField SourceTextX;
    private JTextField DestTextX;
    private JTextField SourceTextY;
    private JTextField DestTestY;
    private JButton moveButton;
    private JTextArea MessageBox;
    private JPanel GameBoardPanel;
    private JButton refreshButton;


    public void setGameBoard(GameBoard GB) {
        GameBoardPanel.removeAll();
        GameBoardPanel.add(GB);
//        GameBoardPanel.revalidate();
//        GameBoardPanel.repaint();
//        GWPanel.repaint();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        GWPanel = new JPanel();
        GWPanel.setLayout(new GridBagLayout());
        GWPanel.setBackground(new java.awt.Color(-6644321));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        GWPanel.add(panel1, gbc);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("ScriptC", Font.BOLD, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("Ferret Army");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        panel1.add(label1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Source");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Destination");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label3, gbc);
        SourceTextX = new JTextField();
        SourceTextX.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(SourceTextX, gbc);
        DestTextX = new JTextField();
        DestTextX.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(DestTextX, gbc);
        SourceTextY = new JTextField();
        SourceTextY.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(SourceTextY, gbc);
        DestTestY = new JTextField();
        DestTestY.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(DestTestY, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Y");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("X");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label5, gbc);
        MessageBox = new JTextArea();
        MessageBox.setBackground(new java.awt.Color(-917761));
        MessageBox.setDisabledTextColor(new java.awt.Color(-16777216));
        MessageBox.setEditable(false);
        MessageBox.setText("Defaut Text!");
        MessageBox.setWrapStyleWord(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(MessageBox, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weighty = 2.5;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer1, gbc);
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Complex", Font.BOLD, 20, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setHorizontalAlignment(0);
        label6.setHorizontalTextPosition(0);
        label6.setText("CHESS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(label6, gbc);
        refreshButton = new JButton();
        refreshButton.setText("Refresh");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(refreshButton, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("Pieces Look Wrong?");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(label7, gbc);
        GameBoardPanel = new JPanel();
        GameBoardPanel.setLayout(new BorderLayout(0, 0));
        GameBoardPanel.setMaximumSize(new Dimension(512, 512));
        GameBoardPanel.setMinimumSize(new Dimension(512, 512));
        GameBoardPanel.setPreferredSize(new Dimension(512, 512));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        GWPanel.add(GameBoardPanel, gbc);
        moveButton = new JButton();
        moveButton.setText("Move");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GWPanel.add(moveButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GWPanel;
    }

    //    public void redrawGWPanel() {
//        GWPanel.revalidate();
//        GWPanel.repaint();
//    }

}
