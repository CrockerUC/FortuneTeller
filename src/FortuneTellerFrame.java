import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    JPanel mainPnl, titlePnl, displayPnl, cmdPnl;
    JLabel titleLbl;
    ImageIcon icon;
    JScrollPane scroller;
    JTextArea fortuneTA;
    JButton quitBtn, fortuneBtn;
    String[] fortunes = new String [15];

    int curFortuneDex = -1;

    public FortuneTellerFrame()
    {
        loadFortunes();
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();

        setTitle("Fortune Teller");
        setSize(550, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void loadFortunes() {
        fortunes[0] = "You will have a great day!";
        fortunes[1] = "Things will go well for you today.";
        fortunes[2] = "Enjoy your day!";
        fortunes[3] = "Be humble and all will be well.";
        fortunes[4] = "Today is a good day for exercising restraint.";
        fortunes[5] = "Be careful not to get caught up in the schedules.";
        fortunes[6] = "Be kind to those around you.";
        fortunes[7] = "Man, I'm glad I'm not alone!";
        fortunes[8] = "Don't be afraid to be yourself!";
        fortunes[9] = "Everyone has their day.";
        fortunes[10] = "Exercise caution and good judgment.";
        fortunes[11] = "Happiness is a warm gun!";
        fortunes[12] = "Be grateful for all that is in your life.";
        fortunes[13] = "Live a life of luxury.";
        fortunes[14] = "You will have a wonderful day!";
    }

    public void createTitlePanel()
    {
        titlePnl = new JPanel();
        icon = new ImageIcon("src/FortuneTeller.jpg");
        titleLbl = new JLabel(icon);
        titleLbl.setText("Get your Fortune!");
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);

        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }

    public void createDisplayPanel()
    {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(15, 50);
        scroller = new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    public void createControlPanel()
    {
        Random rnd = new Random();
        cmdPnl = new JPanel();
        cmdPnl.setLayout(new GridLayout(1, 2));
        fortuneBtn = new JButton("Get a Fortune!");
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener(ae ->
        {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION)
                System.exit(0);
        });

        fortuneBtn.addActionListener(ae ->
        {
            int newDex;
            do {
                newDex = rnd.nextInt(fortunes.length);
            } while (newDex == curFortuneDex);
            curFortuneDex = newDex;
            fortuneTA.setText(fortunes[curFortuneDex]);
        });
        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);
        mainPnl.add(cmdPnl, BorderLayout.SOUTH);
    }
}