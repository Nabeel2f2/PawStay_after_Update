package com.mycompany.boarding_center;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private final CardLayout cards=new CardLayout(); private final JPanel content=new JPanel(cards);
    private final JButton[] navButtons=new JButton[7]; private String active="Dashboard";
    public MainFrame(String user){
        setTitle("PawStay - Pet Boarding Management");setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);setSize(1450,900);setMinimumSize(new Dimension(1100,700));setLocationRelativeTo(null);
        setLayout(new BorderLayout());add(sidebar(),BorderLayout.WEST);JPanel right=workspace(user);right.add(content,BorderLayout.CENTER);add(right,BorderLayout.CENTER);
        content.add(new DashboardPanel(),"Dashboard");
        content.add(new DataPanel("Customers","customers","customer_id","SELECT customer_id,full_name,phone,email,address FROM customers",
            new String[]{"ID","Full Name","Phone","Email","Address"},new String[]{"Full name *","Phone","Email","Address","Emergency contact","Emergency phone"},
            new String[]{"full_name","phone","email","address","emergency_contact","emergency_phone"}),"Customers");
        content.add(new DataPanel("Pets","pets","pet_id","SELECT p.pet_id,p.pet_name,c.full_name,p.species,p.breed FROM pets p JOIN customers c ON c.customer_id=p.customer_id",
            new String[]{"Pet ID","Pet Name","Owner","Species","Breed"},new String[]{"Customer ID *","Pet name *","Species","Breed","Sex","Age (years)","Vaccination expiry (YYYY-MM-DD)","Feeding instructions","Allergies","Special care"},
            new String[]{"customer_id","pet_name","species","breed","sex","age_years","vaccination_expiry","feeding_instructions","allergies","special_care"}),"Pets");
        content.add(new DataPanel("Reservations","reservations","reservation_id","SELECT r.reservation_id,c.full_name,p.pet_name,r.kennel_code,r.check_in,r.check_out,r.status,r.amount FROM reservations r JOIN customers c ON c.customer_id=r.customer_id JOIN pets p ON p.pet_id=r.pet_id",
            new String[]{"ID","Customer","Pet","Kennel","Check-in","Check-out","Status","Amount"},new String[]{"Pet ID *","Customer ID *","Kennel code","Accommodation type","Check-in (YYYY-MM-DD) *","Check-out (YYYY-MM-DD) *","Status","Amount"},
            new String[]{"pet_id","customer_id","kennel_code","accommodation_type","check_in","check_out","status","amount"}),"Reservations");
        content.add(new DataPanel("Staff","staff","staff_id","SELECT staff_id,full_name,role_name,phone,username,status FROM staff",
            new String[]{"ID","Full Name","Role","Phone","Username","Status"},new String[]{"Full name *","Role","Phone","Username","Password","Status"},
            new String[]{"full_name","role_name","phone","username","password_hash","status"}),"Staff");
        content.add(new DataPanel("Billing","payments","payment_id","SELECT payment_id,reservation_id,payment_date,amount,method,status FROM payments",
            new String[]{"Payment ID","Reservation ID","Payment date","Amount","Method","Status"},new String[]{"Reservation ID","Payment date (YYYY-MM-DD) *","Amount *","Method","Status"},
            new String[]{"reservation_id","payment_date","amount","method","status"}),"Billing");
        content.add(reportPanel(),"Reports");
        add(content,BorderLayout.CENTER);showCard("Dashboard");
    }
    private JPanel sidebar(){
        JPanel side=new JPanel();side.setPreferredSize(new Dimension(205,100));side.setBackground(Theme.NAVY);side.setLayout(new BoxLayout(side,BoxLayout.Y_AXIS));side.setBorder(new EmptyBorder(18,12,18,12));
        JLabel brand=new JLabel("  ⌂  PawStay");brand.setForeground(Color.WHITE);brand.setFont(new Font("Segoe UI",Font.BOLD,23));brand.setBorder(new EmptyBorder(8,6,28,0));brand.setAlignmentX(Component.LEFT_ALIGNMENT);side.add(brand);
        String[] names={"Dashboard","Customers","Pets","Reservations","Staff","Billing","Reports"};
        String[] icons={"▦","♟","●","▣","♙","＄","▤"};
        for(int i=0;i<names.length;i++){
            final String name=names[i];JButton b=new JButton(icons[i]+"   "+name);b.setHorizontalAlignment(SwingConstants.LEFT);b.setMaximumSize(new Dimension(Integer.MAX_VALUE,43));b.setAlignmentX(Component.LEFT_ALIGNMENT);b.setFont(new Font("Segoe UI",Font.PLAIN,13));b.setForeground(new Color(224,236,245));b.setBackground(Theme.NAVY);b.setBorder(new EmptyBorder(10,12,10,8));b.setFocusPainted(false);b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));b.addActionListener(e->showCard(name));side.add(b);side.add(Box.createVerticalStrut(5));navButtons[i]=b;
        }
        side.add(Box.createVerticalGlue());JLabel foot=new JLabel("  PET BOARDING SYSTEM");foot.setForeground(new Color(142,168,188));foot.setFont(new Font("Segoe UI",Font.PLAIN,10));side.add(foot);return side;
    }
    private JPanel workspace(String user){
        JPanel p=new JPanel(new BorderLayout());p.setBackground(Theme.BG);
        JPanel top=new JPanel(new BorderLayout());top.setBackground(Color.WHITE);top.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Theme.LINE));top.setPreferredSize(new Dimension(100,48));
        JLabel app=new JLabel("  PawStay  ·  Pet Boarding Management");app.setFont(new Font("Segoe UI",Font.PLAIN,12));app.setForeground(Theme.MUTED);top.add(app,BorderLayout.WEST);
        JLabel welcome=new JLabel("Welcome, Nimal Perera   |   Receptionist   |   "+java.time.LocalDate.now()+"    ");welcome.setFont(new Font("Segoe UI",Font.PLAIN,12));welcome.setForeground(Theme.MUTED);top.add(welcome,BorderLayout.EAST);p.add(top,BorderLayout.NORTH);return p;
    }
    private void showCard(String name){
        active=name;cards.show(content,name);
        String[] names={"Dashboard","Customers","Pets","Reservations","Staff","Billing","Reports"};
        for(int i=0;i<names.length;i++){boolean on=names[i].equals(name);navButtons[i].setBackground(on?Theme.TEAL:Theme.NAVY);navButtons[i].setForeground(Color.WHITE);navButtons[i].setFont(new Font("Segoe UI",on?Font.BOLD:Font.PLAIN,13));}
    }
    private JPanel reportPanel(){
        JPanel p=new JPanel(new BorderLayout(16,16));p.setBackground(Theme.BG);p.setBorder(new EmptyBorder(22,22,22,22));
        p.add(Theme.heading("Management Reports"),BorderLayout.NORTH);
        JPanel card=Theme.card();card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
        JLabel title=new JLabel("Reservation and customer summary");title.setFont(new Font("Segoe UI",Font.BOLD,18));title.setForeground(Theme.TEXT);
        JLabel desc=new JLabel("<html>Generate a PDF report joining Reservations, Customers and Pets.<br>Useful for occupancy review and upcoming stays.</html>");desc.setForeground(Theme.MUTED);
        JButton generate=new JButton("Generate Jasper PDF report");Theme.styleButton(generate,true);generate.setAlignmentX(Component.LEFT_ALIGNMENT);
        generate.addActionListener(e->{try{java.io.File out=ReportService.generateReservationReport();JOptionPane.showMessageDialog(this,"Report saved to:\n"+out.getAbsolutePath());if(Desktop.isDesktopSupported())Desktop.getDesktop().open(out);}catch(Exception ex){JOptionPane.showMessageDialog(this,"Report generation failed:\n"+ex.getMessage(),"Report error",JOptionPane.ERROR_MESSAGE);}});
        card.add(title);card.add(Box.createVerticalStrut(12));card.add(desc);card.add(Box.createVerticalStrut(22));card.add(generate);p.add(card,BorderLayout.CENTER);return p;
    }
}
