import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bottomLabel extends JPanel implements ActionListener{

    JButton startButton = new JButton("Start");
    JButton restartButton = new JButton("Restart");

    JLabel scoreBoard = new JLabel("Points: 0");
    JLabel timeBoard = new JLabel("Time: H/M/S");
    JLabel lifeBoard = new JLabel("Life : 3");
    JLabel gameOver = new JLabel("GAME OVER!!!!");

    FlowLayout fLayout = new FlowLayout();
    FlowLayout fLayout2 = new FlowLayout();

    JPanel downPanel = new JPanel();
    JPanel upPanel = new JPanel();


    Scene scene;

    boolean started = false;



    public bottomLabel(Scene scene){

        this.scene = scene;
        //t.start();
        Timer t = scene.getTimer();
        setText();
        setButtonListener();
        t.addActionListener(this);
        bottomLabel();
        topLabel();



    }


    public void bottomLabel(){
        downPanel.setLayout(fLayout);
        fLayout.setAlignment(FlowLayout.CENTER);

        startButton.setFont(new Font("Verdana",Font.PLAIN,20));
        startButton.setFocusable(false);

        downPanel.add(startButton);

    }

    public void topLabel(){

        upPanel.setLayout(fLayout2);
        fLayout2.setAlignment(FlowLayout.CENTER);

        scoreBoard.setFont(new Font("Verdana",Font.PLAIN,20));
        scoreBoard.setFocusable(false);

        timeBoard.setFont(new Font("Verdana",Font.PLAIN,20));
        timeBoard.setFocusable(false);

        lifeBoard.setFont(new Font("Verdana",Font.PLAIN,20));
        lifeBoard.setFocusable(false);

        gameOver.setFont(new Font("Verdana",Font.PLAIN,20));
        gameOver.setFocusable(false);

        upPanel.setBackground(new Color(6, 115, 55));

        upPanel.add(lifeBoard);
        upPanel.add(scoreBoard);
        upPanel.add(timeBoard);
    }

    public JPanel getTop() {
        return upPanel;
    }
    public JPanel getBot(){
        return downPanel;
    }

    public void setText(){
        timeBoard.setText(scene.timeElapsed());
        scoreBoard.setText("Points: " + scene.count);
        lifeBoard.setText(scene.lifeBoard);

        if(scene.life == 0){
            lifeBoard.setText(scene.lifeBoard);
            scene.stopTimer();
            scene.notGameOver = false;
            upPanel.add(gameOver);
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setText();

    }

    public void setButtonListener(){

        ActionListener startTimer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(started){
                    scene.stopTimer();
                    startButton.setText("Start");
                    started = false;
                }else{
                    scene.startTimer();
                    startButton.setText("Stop");
                    started = true;
                }
            }
        };

        startButton.addActionListener(startTimer);
    }







}
