import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Date;
import javax.swing.JOptionPane;

public class frame extends javax.swing.JFrame {
    //public static Vector data = new Vector();
    private String teamName;
    private int played;
    private int homeWins;
    private int homeConcede;
    private int awayConceded;
    private int homeDraws;
    private int homeLoses;
    private int goalHome;
    private int awayWins;
    private int awayGoals;
    private int awayLoses;
    private int awayDraws;
    private int points;
    private Object totalWins;
    private Object totalLost;
    private Object totalDraws;
    private Object Gd;
    private String nextFix;
    private String homeOrAway;
    Date d;
    int count = 0;


    /** Creates new form frame */
    public frame() {
        initComponents();
        readFile(files.getTable());
        //System.out.print(files.getTable());
        dateLbl.setText(dateLbl.getText() + d);
    }

   private void readFile() {

        // Declare file reader streams
        FileReader frs = null;

        // Declare streamTokenizer
        StreamTokenizer in = null;

        try {

            // Create file input and output streams
            frs = new FileReader(files.getTable().getName());

            int row=0;
            // Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);

           // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


            // Read first token
            in.nextToken();
            //procee txt file header
            //<editor-fold defaultstate="collapsed" desc="process record">
            // Process a record

            while (in.ttype != StreamTokenizer.TT_EOF) {


                // Get team name
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    teamName = (in.sval);

                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get number of games played
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                  played = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home wins
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    homeWins = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home draws
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                   homeDraws = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home loses
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    homeLoses = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home goals
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    goalHome = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home conceded
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    homeConcede = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get away wins
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    awayWins = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get away draws
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    awayDraws =(int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get away loses
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                   awayLoses = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get scored away
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                   awayGoals = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get conceded away
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    awayConceded= (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get gd
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    Gd = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get points
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    points = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                //get next fixture
                 if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    nextFix = in.sval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                //get home or away
                  if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    homeOrAway = in.sval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                totalWins = homeWins + awayWins;

                totalDraws = homeDraws + awayDraws;

                totalLost = homeLoses + awayLoses;

                Gd =(goalHome + awayGoals) - (homeConcede +awayConceded);
                //todo for loop store header in an array
                int col = 0;

                Object header[] = {teamName, played, totalWins, totalDraws, totalLost, Gd, points, nextFix, homeOrAway};

                for(int i=0;i<header.length+1;i++){
                    league.setValueAt(header[i], row, i);
                }

                row ++;
                in.nextToken();
            }
            //</editor-fold>
        }

            catch (FileNotFoundException ex) {
            System.out.println("File not found: in.dat");
        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        } finally {
            try {
                if (frs != null) {
                    frs.close();
                }

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        logo = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        dateLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        league = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setForeground(new java.awt.Color(153, 204, 255));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/premier_league.png"))); // NOI18N

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home.png"))); // NOI18N
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        dateLbl.setText("Last Modified:");

        league.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Team Name", "Games Played", "Wins", "Draws", "Loses", "GD", "PTS", "Next Fixture", "Home or Away"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        league.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leagueMouseClicked(evt);
            }
        });
        league.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                leagueKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(league);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 990, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dateLbl)
                            .add(homeButton))
                        .add(343, 343, 343)
                        .add(logo)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(homeButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 156, Short.MAX_VALUE)
                        .add(dateLbl, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(logo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 348, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leagueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_leagueKeyPressed

    }//GEN-LAST:event_leagueKeyPressed

    private void leagueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leagueMouseClicked

    }//GEN-LAST:event_leagueMouseClicked

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        mainMenu newFrame = new mainMenu();
        newFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_homeButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton homeButton;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable league;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables

    private void readFile(File file) {

        // Declare file reader streams
        FileReader frs = null;


        // Declare streamTokenizer
        StreamTokenizer in = null;

        try {

            // Create file input and output streams
            frs = new FileReader(file.getName());
            long date  = file.lastModified();
            d = new Date(date);
            //dateLbl.setText(dateLbl.getText() + d);
            //System.out.print(d);
            int row=0;
            // Create a stream tokenizer wrapping file input stream
            in = new StreamTokenizer(frs);

           // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


            // Read first token
            in.nextToken();
            //procee txt file header
            //<editor-fold defaultstate="collapsed" desc="process record">
            // Process a record

            while (in.ttype != StreamTokenizer.TT_EOF) {

                // Get team name
                if (in.ttype == StreamTokenizer.TT_WORD) {
                    teamName = (in.sval);
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get number of games played
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                  played = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home wins
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    homeWins = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home draws
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                   homeDraws = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home loses
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    homeLoses = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home goals
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    goalHome = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get home conceded
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    homeConcede = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get away wins
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    awayWins = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get away draws
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    awayDraws =(int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get away loses
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                   awayLoses = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get scored away
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                   awayGoals = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get conceded away
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    awayConceded= (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get gd
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    Gd = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                // Get points
                if (in.nextToken() == StreamTokenizer.TT_NUMBER) {
                    points = (int)in.nval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                //get next fixture
                 if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    nextFix = in.sval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                //get home or away
                  if (in.nextToken() == StreamTokenizer.TT_WORD) {
                    homeOrAway = in.sval;
                } else {
                    JOptionPane.showMessageDialog(this, "Bad file format");
                }

                totalWins = homeWins + awayWins;

                totalDraws = homeDraws + awayDraws;

                totalLost = homeLoses + awayLoses;


                Gd =(goalHome + awayGoals) - (homeConcede +awayConceded);
                //todo for loop store header in an array
                //int col = 0;

                Object header[] = {teamName, played, totalWins, totalDraws, totalLost, Gd, points, nextFix, homeOrAway};

                for(int i=0;i<header.length;i++){
                    league.setValueAt(header[i], row, i);
                }
                row ++;
                in.nextToken();
            }
            //</editor-fold>
        }

            catch (FileNotFoundException ex) {
            System.out.println("File not found: in.dat");
        } catch (IOException ex) {
        System.out.println(ex.getMessage());
        } finally {
            try {
                if (frs != null) {
                    frs.close();
                }

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }

}
