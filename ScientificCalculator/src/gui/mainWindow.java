//
//package gui;
//
//
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.math.BigDecimal;
//import java.text.DecimalFormat;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//
//import parser.Calculator;
///**
// * 
// * @author Santisco
// * 窗口类
// *
// */
//public class mainWindow implements ActionListener
//{
//  JFrame mainFrame;
//  JTextField inputField;
//  JTextField outputField;
//  JButton getResult, clearText, showEquals;
//  int i;
//  JPanel p0, p1, p2, p3, p4, p5, p6, p7, p8,p9;
//  JLabel l1, l2;
//  JMenuBar menubar;
//  JMenuItem item1, item2, item3, item4, item5, item6, item7, item8;
//  int lbrflag = 0;
//  int rbrflag = 0;
//  int lbmflag = 0;
//  int rbmflag = 0;
//  public void display() {
//    mainFrame = new JFrame("冠龙小学生计算器");
//    mainFrame.addWindowListener(new WindowAdapter() {
//      public void windowClosing(WindowEvent e) {
//        int i = JOptionPane.showConfirmDialog(null, "是否确定退出系统",
//            "退出确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
//        if (i == 0) {
//          System.exit(0);
//        }
//      }
//    });
//    mainFrame.getContentPane().setLayout(new BorderLayout());
//    mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//    JPanel ioPanel = new JPanel();
//    mainFrame.getContentPane().add(ioPanel);
//    mainFrame.add(ioPanel);
//    ioPanel.setLayout(new BorderLayout());
//    menubar = new JMenuBar();
//
//    mainFrame.setJMenuBar(menubar);
//    JMenu menu1 = new JMenu("编辑");
//    JMenu menu2 = new JMenu("操作");
//    JMenu menu3 = new JMenu("帮助");
//    menubar.add(menu1);
//    menubar.add(menu2);
//    menubar.add(menu3);
//    item1 = new JMenuItem("复制", 'C');
//    item2 = new JMenuItem("粘贴", 'V');
//    item3 = new JMenuItem("剪切", 'X');
//    item4 = new JMenuItem("计算", 'G');
//    item5 = new JMenuItem("清空所有", 'R');
//    item6 = new JMenuItem("退出", 'Q');
//    item7 = new JMenuItem("关于计算器", 'H');
//    item8 = new JMenuItem("计算其用法说明", 'W');
//    menu1.add(item1);
//    menu1.add(item2);
//    menu1.add(item3);
//    menu2.add(item4);
//    menu2.add(item5);
//    menu2.addSeparator();
//    menu2.add(item6);
//    menu3.add(item7);
//    menu3.add(item8);
//    // 给菜单项注册监听器
//    item1.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        outputField.setEnabled(true);
//        outputField.selectAll();
//        outputField.copy();
//        outputField.setEnabled(false);
//      }
//    });
//
//    item2.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        inputField.setText("");
//        inputField.paste();
//      }
//    });
//
//    item3.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        inputField.selectAll();
//        inputField.cut();
//      }
//    });
//
//    item5.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        inputField.setText("");
//        outputField.setText("");
//        lbrflag = rbrflag =0;
//      }
//    });
//
//    item6.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        int i = JOptionPane.showConfirmDialog(null, "是否确定退出系统",
//            "退出确认对话框", JOptionPane.YES_NO_CANCEL_OPTION);
//        if (i == 0) {
//          System.exit(0);
//        }
//      }
//    });
//
//    item7.addActionListener(new ActionListener() {
//      public void actionPerformed(ActionEvent e) {
//        JOptionPane.showMessageDialog(mainFrame, getHelpMessage());
//      }
//    });
//    
//    item8.addActionListener(new ActionListener() {
//        public void actionPerformed(ActionEvent e) {
//          JOptionPane.showMessageDialog(mainFrame, getHelpInstruction());
//        }
//      });
//
//    Font font = new Font("Arial", Font.BOLD, 20);
//    l1 = new JLabel("算术表达式为:");
//    l2 = new JLabel("计算的结果为:");
//
//    inputField = new JTextField();
//    inputField.setPreferredSize(new Dimension(800, 40));
//    inputField.setFont(font);
//    inputField.addKeyListener(new EnterKey());
//    
//    outputField = new JTextField();
//    outputField.setPreferredSize(new Dimension(800, 40));
//    outputField.setFont(font);
//    outputField.setEnabled(false);
//    getResult = new JButton("Get Result");
//    getResult.addActionListener(new ActionListener()
//    {
//      public void actionPerformed(ActionEvent e){
//        if(e.getActionCommand()=="Get Result")
//                {
//                  getResult();
//             }
//      }
//    });
//    p2 = new JPanel(new GridLayout(4, 5, 10, 10));
//    p7 = new JPanel(new GridLayout(4, 5, 10, 10));
//    String name[] = {"9", "8", "7", "+", "[","6", "5", "4", "-", "]", "3", "2", "1", "*", "(", "0", ",", ".", "/", ")"};
//    for(int i = 0; i<name.length; i++){
//    	Font font2 = new Font("Arial", Font.BOLD, 20);
//    	JButton b = new JButton(name[i]);
//    	p2.add(b);
//    	if(i == 14){
//    		b.addActionListener(new ActionKey());
//    	}
//    	if(i == 19){
//    		b.addActionListener(new ActionKey1());
//    	}
//    	b.addActionListener(this);
//    	b.setFont(font2);
//    	b.setPreferredSize(new Dimension(60, 60));
//    }
//    String name1[] = {"cos(", "sin(", "tan(", "arcsin(", "arccos(", "arctan(", "log(", "ln(", "log10(", "yroot(", "cuberoot(", "fact(", "pow(", "exp(", "mod(", "stdevp([", "var([" };
//    for(int i = 0; i<name1.length; i++){
//    	Font font2 = new Font("Arial", Font.BOLD, 20);
//    	JButton b = new JButton(name1[i]);
//    	p7.add(b);
//    	b.addActionListener(new ActionKey());
//    	b.addActionListener(this);
//    	b.setFont(font2);
//    	b.setPreferredSize(new Dimension(130, 60));
//    }
//    Font font2 = new Font("Arial", Font.BOLD, 60);
//    showEquals = new JButton("=");
//    showEquals.setFont(font2);
//    showEquals.setPreferredSize(new Dimension(100, 100));
//    showEquals.addActionListener(new ActionListener(){
//    	public void actionPerformed(ActionEvent e){
//    		if(e.getActionCommand() == "="){
//    			getResult();
//    		}
//    	}
//    });
//    clearText = new JButton("C");
//    clearText.setFont(font2);
//    clearText.setPreferredSize(new Dimension(100, 100));
//    clearText.setPreferredSize(new Dimension(100, 100));
//    clearText.addActionListener(new ActionListener(){
//    	public void actionPerformed(ActionEvent e){
//    		if(e.getActionCommand() == "C"){
//    			clearField();
//    		}
//    	}
//    });
//    p6 = new JPanel(new FlowLayout(1, 100, 10));
//    p3 = new JPanel(new FlowLayout());
//    p4 = new JPanel(new FlowLayout());
//    p1 = new JPanel(new GridLayout(2, 2, 0, 0));
//    p5 = new JPanel(new GridLayout(2, 1, 10, 10));
//    p5.add(clearText);
//    p5.add(showEquals);
//    p6.add(p7);
//    p6.add(p2);
//    p6.add(p5);
//    p3.add(l1);
//    p3.add(inputField);
//    p4.add(l2);
//    p4.add(outputField);
//    p1.add(p3);
//    p1.add(p4);
//    p0 = new JPanel(new GridLayout(2, 1, 0, -60));
//    p0.add(p1, p6);
//    ioPanel.add(p6);
//    ioPanel.add(p0, "North");
//    ioPanel.add(getResult, "South");
//    mainFrame.setSize(1550, 600);
//    mainFrame.setVisible(true);
//  }
//
//  public void getResult() {
//    try {
//      for(int i = 1; i <= lbrflag - rbrflag; i++){
//    	  inputField.setText( inputField.getText() + ")");
//      }
//      if(lbrflag < rbrflag){
//    	  for(int i = 1 ; i <=rbrflag -lbrflag; i++){
//    		  inputField.setText( inputField.getText().substring(0,inputField.getText().length() - 1));
//    	  }
//      }
//      Calculator calculator = new Calculator();
//      BigDecimal bigResult = calculator.calculate(inputField.getText().trim());
//      //bigResult.setScale(100 ,BigDecimal.ROUND_DOWN); 
//      DecimalFormat df = new DecimalFormat("#.000000000000000");
//      System.out.println(df.format(bigResult));
//      outputField.setText("" + df.format(bigResult));
//      lbrflag = rbrflag =0 ;
//      System.out.println(lbrflag);
//    } catch (Exception ex) {
//      outputField.setText(ex.getMessage());
//      lbrflag = rbrflag =0 ;
//    }
//  }
//  
//  public void clearField(){
//	  inputField.setText("");
//	  outputField.setText("");
//	  lbrflag = rbrflag = 0;
//  }
//  
//  public void augmentLBR(){
//	  lbrflag++;
//  }
//  
//  public void augmentRBR(){
//	  rbrflag++;
//  }
//  
//  String getHelpMessage() {
//    String msg = "吴冠龙制作";
//    msg += "";
//    msg += "";
//    return msg;
//  }
//  
//  String getHelpInstruction(){
//	  String msg = "<html><p>由于现在还没有加上图片，所以先对函数功能进行说明</p><p>fact():求解递归操作,格式为fact(n)</p>"
//	  		+ "<p>yroot():求解平方根,格式为yroot(a,b)</p>"
//	  		+ "<p>cuberoot():求解立方根,格式为cuberoot(n)</p>"
//	  		+ "<p>mod():求解模,格式为mod(a,b)</p>"
//	  		+ "<p>exp():求解以e为底的幂函数,格式为exp(n)</p>"
//	  		+ "<p>pow():求解指数函数,格式为pow(a,b)</p>"
//	  		+ "<p>stevp([]):求解方差,格式为stevp([a,b])</p>"
//	  		+ "<p>var([]):求解标准差,格式为stvp([a,b])</p><html>";
//	  return msg;
//  }
//  
//  @Override
//  public void actionPerformed(ActionEvent ae) {
//      inputField.setText( inputField.getText() + ae.getActionCommand() );
//  }
//  
//  class EnterKey implements KeyListener
//  {
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//      // TODO Auto-generated method stub
//      if (e.getKeyChar() == KeyEvent.VK_ENTER)
//      {
//        getResult();
//      }
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//      // TODO Auto-generated method stub
//      
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//      // TODO Auto-generated method stub
//      
//    }
//    
//  }
//
//  class ActionKey implements ActionListener{
//	  @Override
//	  public void actionPerformed(ActionEvent e){
//		  augmentLBR();
//	  }
//  }
//  
//  class ActionKey1 implements ActionListener{
//	  @Override
//	  public void actionPerformed(ActionEvent e){
//		  augmentRBR();
//	  }
//  }
//  
//}
