import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLabel extends JPanel implements ActionListener{

    // play stop button
    JButton startButton = new JButton("Start");
    JButton restartButton = new JButton("Reset");

    // game label up
    JLabel scoreBoard = new JLabel("Points: 0");
    JLabel timeBoard = new JLabel("Time: H/M/S");
    JLabel lifeBoard = new JLabel("Life : 3");
    JLabel gameOver = new JLabel("GAME OVER!!!!");

    // layous
    FlowLayout fLayout = new FlowLayout();
    FlowLayout fLayout2 = new FlowLayout();

    // up/down panels
    JPanel downPanel = new JPanel();
    JPanel upPanel = new JPanel();

    // scene
    Scene scene;

    // state for start/stop button
    boolean started = false;

    JavaMain jm;

    // consturctor
    public GameLabel(Scene scene, JavaMain jm){
        this.jm = jm;
        this.scene = scene;
        Timer t = scene.getTimer();
        setText();
        setButtonListener();
        t.addActionListener(this);
        bottomLabel();
        topLabel();
    }

    // bottom label
    public void bottomLabel(){
        downPanel.setLayout(fLayout);
        fLayout.setAlignment(FlowLayout.CENTER);

        startButton.setFont(new Font("Verdana",Font.PLAIN,20));
        startButton.setFocusable(false);

        restartButton.setFont(new Font("Verdana",Font.PLAIN,20));
        restartButton.setFocusable(false);

        downPanel.setBackground(new Color(6, 115, 55));

        downPanel.add(startButton);
        downPanel.add(restartButton);


    }

    // top label
    public void topLabel(){

        upPanel.setLayout(fLayout2);
        fLayout2.setAlignment(FlowLayout.CENTER);

        scoreBoard.setFont(new Font("Verdana",Font.PLAIN,20));
        scoreBoard.setForeground(new Color(52, 235, 161));
        scoreBoard.setFocusable(false);

        timeBoard.setFont(new Font("Verdana",Font.BOLD,20));
        timeBoard.setForeground(new Color(30, 214, 214));
        timeBoard.setFocusable(false);

        lifeBoard.setFont(new Font("Verdana",Font.BOLD,20));
        lifeBoard.setForeground(Color.red);
        lifeBoard.setFocusable(false);

        gameOver.setFont(new Font("Verdana",Font.BOLD,20));
        gameOver.setForeground(Color.red);
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

    // update values of text
    public void setText(){
        timeBoard.setText(scene.timeElapsed());
        scoreBoard.setText("Points:(" + scene.count + ")");
        lifeBoard.setText(scene.lifeBoard);

        // stop game if life is ended
        if(scene.life == 0){
            lifeBoard.setText(scene.lifeBoard);
            scene.stopTimer();
            scene.notGameOver = false;
            upPanel.add(gameOver);
        }

    }

    // update
    @Override
    public void actionPerformed(ActionEvent e) {
        setText();

    }

    // button action
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

        ActionListener restartTime = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jm.dispose();
                scene.stopTimer();
                jm.createGui();
            }
        };

        startButton.addActionListener(startTimer);
        restartButton.addActionListener(restartTime);


    }


}
