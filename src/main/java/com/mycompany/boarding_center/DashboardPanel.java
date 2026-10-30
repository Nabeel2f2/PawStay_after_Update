package com.mycompany.boarding_center;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DashboardPanel extends JPanel {
    private final JLabel petsValue=new JLabel("—"), kennelsValue=new JLabel("—"), arrivalsValue=new JLabel("—"), departuresValue=new JLabel("—");
    public DashboardPanel(){
        setLayout(new BorderLayout(18,18));setBackground(Theme.BG);setBorder(new EmptyBorder(22,22,22,22));
        add(Theme.heading("Dashboard"),BorderLayout.NORTH);
        JPanel body=new JPanel(new BorderLayout(16,16));body.setOpaque(false);
        JPanel stats=new JPanel(new GridLayout(1,4,12,12));stats.setOpaque(false);
        stats.add(statCard("Pets staying",petsValue,new Color(228,243,252),"●"));stats.add(statCard("Available kennels",kennelsValue,new Color(229,248,235),"⌂"));
        stats.add(statCard("Today's arrivals",arrivalsValue,new Color(255,246,226),"➜"));stats.add(statCard("Today's departures",departuresValue,new Color(255,235,236),"↩"));
        body.add(stats,BorderLayout.NORTH);
        JPanel lower=new JPanel(new GridLayout(1,2,14,14));lower.setOpaque(false);
        JPanel recent=Theme.card();recent.setLayout(new BorderLayout(8,8));JLabel h=new JLabel("Upcoming reservations");h.setFont(new Font("Segoe UI",Font.BOLD,16));recent.add(h,BorderLayout.NORTH);
        JTextArea info=new JTextArea();info.setEditable(false);info.setFont(new Font("Segoe UI",Font.PLAIN,13));info.setBackground(Color.WHITE);recent.add(new JScrollPane(info),BorderLayout.CENTER);
        JPanel occupancy=Theme.card();occupancy.setLayout(new BorderLayout(10,10));JLabel oh=new JLabel("Kennel occupancy");oh.setFont(new Font("Segoe UI",Font.BOLD,16));occupancy.add(oh,BorderLayout.NORTH);
        JProgressBar bar=new JProgressBar(0,24);bar.setStringPainted(true);bar.setForeground(Theme.TEAL);bar.setPreferredSize(new Dimension(100,28));occupancy.add(bar,BorderLayout.CENTER);
        JLabel note=new JLabel("<html>Keep customer and pet records updated.<br>Use Reservations to manage check-in and check-out.</html>");note.setForeground(Theme.MUTED);occupancy.add(note,BorderLayout.SOUTH);
        lower.add(recent);lower.add(occupancy);body.add(lower,BorderLayout.CENTER);add(body,BorderLayout.CENTER);
        loadStats(info,bar);
    }
    private JPanel statCard(String title,JLabel value,Color bg,String icon){
        JPanel p=new JPanel(new BorderLayout(4,8));p.setBackground(bg);p.setBorder(new EmptyBorder(16,16,16,16));
        JLabel i=new JLabel(icon);i.setFont(new Font("Segoe UI",Font.BOLD,25));i.setForeground(Theme.TEAL_DARK);p.add(i,BorderLayout.NORTH);
        value.setFont(new Font("Segoe UI",Font.BOLD,29));value.setForeground(Theme.TEXT);JLabel t=new JLabel(title);t.setFont(new Font("Segoe UI",Font.BOLD,13));
        JPanel b=new JPanel(new BorderLayout(4,2));b.setOpaque(false);b.add(t,BorderLayout.NORTH);b.add(value,BorderLayout.CENTER);p.add(b,BorderLayout.CENTER);return p;
    }
    private void loadStats(JTextArea info,JProgressBar bar){
        try(Connection c=Database.getConnection();Statement s=c.createStatement()){
            petsValue.setText(scalar(s,"SELECT COUNT(*) FROM reservations WHERE status='Checked In'"));
            int occupied=Integer.parseInt(scalar(s,"SELECT COUNT(DISTINCT kennel_code) FROM reservations WHERE status='Checked In'"));
            kennelsValue.setText(String.valueOf(Math.max(0,24-occupied)));
            arrivalsValue.setText(scalar(s,"SELECT COUNT(*) FROM reservations WHERE check_in=CURDATE() AND status='Reserved'"));
            departuresValue.setText(scalar(s,"SELECT COUNT(*) FROM reservations WHERE check_out=CURDATE() AND status='Checked In'"));
            bar.setValue(occupied);bar.setString(occupied+" / 24 kennels occupied");
            try(ResultSet rs=s.executeQuery("SELECT r.check_in,c.full_name,p.pet_name,r.kennel_code,r.status FROM reservations r JOIN customers c ON c.customer_id=r.customer_id JOIN pets p ON p.pet_id=r.pet_id ORDER BY r.check_in LIMIT 12")){
                StringBuilder b=new StringBuilder("DATE          CUSTOMER                   PET                 KENNEL    STATUS\n");
                while(rs.next())b.append(rs.getDate(1)).append("   ").append(rs.getString(2)).append("   ").append(rs.getString(3)).append("   ").append(rs.getString(4)).append("   ").append(rs.getString(5)).append('\n');
                info.setText(b.toString());
            }
        }catch(Exception ex){info.setText("Connect to MySQL to load live dashboard data.\n"+ex.getMessage());}
    }
    private String scalar(Statement s,String sql)throws SQLException{try(ResultSet r=s.executeQuery(sql)){r.next();return r.getString(1);}}
}
