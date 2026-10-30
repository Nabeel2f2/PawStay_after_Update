package com.mycompany.boarding_center;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {
    private final JTextField username=new JTextField("staff01");
    private final JPasswordField password=new JPasswordField("staff01");
    public LoginFrame(){
        setTitle("PawStay - Pet Boarding Management");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setSize(980,590);setLocationRelativeTo(null);setMinimumSize(new Dimension(850,520));
        JPanel root=new JPanel(new GridLayout(1,2));root.setBackground(Color.WHITE);setContentPane(root);
        JPanel hero=new JPanel(new BorderLayout());hero.setBackground(Theme.NAVY);
        JLabel photo=new JLabel();photo.setHorizontalAlignment(SwingConstants.CENTER);
        try{java.awt.image.BufferedImage img=javax.imageio.ImageIO.read(getClass().getResource("/images/dog.jpg"));photo.setIcon(new ImageIcon(img.getScaledInstance(490,590,Image.SCALE_SMOOTH)));}catch(Exception ignored){photo.setText("🐾 PawStay");photo.setForeground(Color.WHITE);}
        hero.add(photo,BorderLayout.CENTER);root.add(hero);
        JPanel form=new JPanel();form.setBackground(Color.WHITE);form.setLayout(new BoxLayout(form,BoxLayout.Y_AXIS));form.setBorder(new EmptyBorder(55,55,45,55));
        JLabel logo=new JLabel("⌂  PawStay");logo.setAlignmentX(Component.CENTER_ALIGNMENT);logo.setFont(new Font("Segoe UI",Font.BOLD,38));logo.setForeground(Theme.TEAL_DARK);
        JLabel subtitle=new JLabel("Pet Boarding Facility Management");subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);subtitle.setForeground(Theme.MUTED);
        form.add(logo);form.add(Box.createVerticalStrut(6));form.add(subtitle);form.add(Box.createVerticalStrut(42));
        form.add(label("Username"));styleInput(username);form.add(username);form.add(Box.createVerticalStrut(17));
        form.add(label("Password"));styleInput(password);form.add(password);form.add(Box.createVerticalStrut(22));
        JButton sign=new JButton("➜   Sign In");Theme.styleButton(sign,true);sign.setAlignmentX(Component.CENTER_ALIGNMENT);sign.setMaximumSize(new Dimension(Integer.MAX_VALUE,44));sign.addActionListener(e->login());form.add(sign);
        form.add(Box.createVerticalStrut(18));JLabel hint=new JLabel("Demo login: staff01 / staff01");hint.setAlignmentX(Component.CENTER_ALIGNMENT);hint.setForeground(Theme.MUTED);form.add(hint);root.add(form);
        getRootPane().setDefaultButton(sign);
    }
    private JLabel label(String s){JLabel l=new JLabel(s);l.setFont(new Font("Segoe UI",Font.BOLD,13));l.setForeground(Theme.TEXT);l.setAlignmentX(Component.LEFT_ALIGNMENT);return l;}
    private void styleInput(JTextField f){f.setFont(new Font("Segoe UI",Font.PLAIN,14));f.setMaximumSize(new Dimension(Integer.MAX_VALUE,40));f.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Theme.LINE),new EmptyBorder(8,10,8,10)));f.setAlignmentX(Component.LEFT_ALIGNMENT);}
    private void login(){
        if(username.getText().trim().equals("staff01")&&new String(password.getPassword()).equals("staff01")){
            dispose();new MainFrame(username.getText().trim()).setVisible(true);
        }else JOptionPane.showMessageDialog(this,"Invalid username or password.","Sign in failed",JOptionPane.WARNING_MESSAGE);
    }
}
