import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionEvent;

public class ShapeSwingProgram extends JFrame implements ActionListener {

    protected PaintPanel paintPanel = new PaintPanel();

    public ShapeSwingProgram(String title) {
        super(title);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());        

        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;


        JPanel textPanel = new JPanel(new FlowLayout());
        JTextField text1 = new JTextField("");
        text1.setColumns(5);
        text1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.currentWidth = Integer.parseInt(text1.getText());
            }
        });
        text1.setToolTipText("Width");
        JTextField text2 = new JTextField("");
        text2.setColumns(5);
        text2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintPanel.currentHeight = Integer.parseInt(text2.getText());
            }
        });
        text2.setToolTipText("Height");
        textPanel.add(text1);
        textPanel.add(text2);
        this.add(textPanel, BorderLayout.PAGE_START);


        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("File");
        menu.setMnemonic(MenuKeyEvent.VK_F);
        menuBar.add(menu);

        //a group of file-related menu items 
        menuItem = new JMenuItem("Open", MenuKeyEvent.VK_O);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save", MenuKeyEvent.VK_S);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Save As...", MenuKeyEvent.VK_A);
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuItem = new JMenuItem("Exit", MenuKeyEvent.VK_X);
        menuItem.addActionListener(this);
        menu.add(menuItem);

        // Create the color submenu
        menu.addSeparator();
        submenu = new JMenu("Shape");

        menuBar.add(submenu);
        //Build our shape menu
        ButtonGroup shapeMenu = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("Rectangle");
        rbMenuItem.addActionListener(this);
        rbMenuItem.setSelected(true);
        shapeMenu.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Square");
        rbMenuItem.addActionListener(this);
        shapeMenu.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Oval");
        rbMenuItem.addActionListener(this);
        shapeMenu.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Circle");
        rbMenuItem.addActionListener(this);
        shapeMenu.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Triangle");
        rbMenuItem.addActionListener(this);
        shapeMenu.add(rbMenuItem);
        submenu.add(rbMenuItem);


        // Create the color submenu
        //menu.addSeparator();
        submenu = new JMenu("Color");
        menuBar.add(submenu);

        // create a group, so you can only select one color at a time
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("Red");
        rbMenuItem.addActionListener(this);
        rbMenuItem.setSelected(true);
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Yellow");
        rbMenuItem.addActionListener(this);
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Green");
        rbMenuItem.addActionListener(this);
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Black");
        rbMenuItem.addActionListener(this);
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("White");
        rbMenuItem.addActionListener(this);
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);

        // Turn submenu into an actual submenu by adding it to another menu (specifically, our second menu)

        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        paintPanel.setPreferredSize(new Dimension(500,500));
        paintPanel.setBackground(Color.WHITE);
        this.getContentPane().add(paintPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        ShapeSwingProgram paintprogram = new ShapeSwingProgram("Shape Dropper Paint Program");
        paintprogram.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Rectangle"))
            paintPanel.currentShape = PaintPanel.ShapeType.RECTANGLE;
        else if (e.getActionCommand().equals("Square"))
            paintPanel.currentShape = PaintPanel.ShapeType.SQUARE;
        else if(e.getActionCommand().equals("Oval"))
            paintPanel.currentShape = PaintPanel.ShapeType.OVAL;
        else if(e.getActionCommand().equals("Circle"))
            paintPanel.currentShape = PaintPanel.ShapeType.CIRCLE;
        else if(e.getActionCommand().equals("Triangle"))
            paintPanel.currentShape = PaintPanel.ShapeType.TRIANGLE;
        else if(e.getActionCommand().equals("Red"))
            paintPanel.currentColor = "#ff0000";
        else if(e.getActionCommand().equals("Green"))
            paintPanel.currentColor = "#00ff00";
        else if(e.getActionCommand().equals("Yellow"))
            paintPanel.currentColor = "#ffff00";
        else if(e.getActionCommand().equals("Black"))
            paintPanel.currentColor = "#000000";
        else if(e.getActionCommand().equals("White"))
            paintPanel.currentColor = "#ffffff";

    }
}