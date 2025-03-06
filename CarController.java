import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController  extends JFrame {

    private static final int X = 800;
   // private static final int Y = 800;

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Lower Bed");
    JButton lowerBedButton = new JButton("Lift Bed");
    JButton turnleftButton = new JButton("Turn Left");
    JButton turnrightButton = new JButton("Turn Right!!");
    JButton addVolvo = new JButton("Add Car");
    JButton removecar = new JButton("Remove car");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    JPanel controlPanel = new JPanel();
    DrawPanel drawPanel;
    JPanel gasPanel = new JPanel();

    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    Application model;
    CarView carView;

     

    public CarController (String title, DrawPanel drawPanel, Application model) {

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.setLayout(new GridLayout(2,7));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(turnleftButton,6);
        controlPanel.add(turnrightButton, 7);
        controlPanel.add(addVolvo,8);
        controlPanel.add(removecar,9);

        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        controlPanel.setBackground(Color.CYAN);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.drawPanel = drawPanel;
        this.carView = new CarView(title, controlPanel, drawPanel, gasPanel, startButton , stopButton);
        this.model = model;
        initComponents();
    }

    public void initComponents () {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    
    gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                model.gas(100);
                System.out.println("Gas amount: " + 1);
            }
        });
        
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopAllCars();
            }
            
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startAllCars();
            }
            
        });

        turboOnButton.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            model.turboOn();
        }
        });

        turboOffButton.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            model.turboOn();
        }
        });

        liftBedButton.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            model.liftScaniaBed();
        }
        });

        lowerBedButton.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            model.lowerScaniaBed();
        }
        });

        turnleftButton.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            model.turnLeft();
        }
        });

        turnrightButton.addActionListener(new ActionListener(){
            @Override
        public void actionPerformed(ActionEvent e){
            model.turnRight();
        }
        });

        addVolvo.addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent e){
            model.addCar();
            //drawPanel.repaint();
           } 
        });

        removecar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.removeCar();
                //drawPanel.repaint();
            }
        });
    }
}

    // Calls the gas method for each car once
    