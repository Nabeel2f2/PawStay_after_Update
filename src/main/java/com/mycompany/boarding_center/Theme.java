package com.mycompany.boarding_center;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public final class Theme {
    public static final Color NAVY=new Color(12,37,61), NAVY2=new Color(19,54,82), TEAL=new Color(0,174,156),
        TEAL_DARK=new Color(0,139,129), BG=new Color(244,247,250), TEXT=new Color(20,38,57), MUTED=new Color(100,117,135), LINE=new Color(222,230,237);
    private Theme(){}
    public static void styleButton(JButton b, boolean primary) {
        b.setFont(new Font("Segoe UI",Font.BOLD,13)); b.setForeground(primary?Color.WHITE:TEXT);
        b.setBackground(primary?TEAL:new Color(232,238,243)); b.setFocusPainted(false); b.setBorder(new EmptyBorder(10,16,10,16)); b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public static JPanel card(){ JPanel p=new JPanel(); p.setBackground(Color.WHITE); p.setBorder(new CompoundBorder(new LineBorder(LINE),new EmptyBorder(14,14,14,14))); return p; }
    public static JLabel heading(String s){ JLabel l=new JLabel(s); l.setFont(new Font("Segoe UI",Font.BOLD,22)); l.setForeground(TEXT); return l; }
    public static void styleTable(JTable t){ t.setFont(new Font("Segoe UI",Font.PLAIN,12)); t.setRowHeight(29); t.setShowVerticalLines(false); t.setGridColor(new Color(233,238,243)); t.setSelectionBackground(new Color(205,237,248)); t.setSelectionForeground(TEXT); t.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12)); t.getTableHeader().setBackground(new Color(239,244,248)); t.getTableHeader().setForeground(TEXT); t.getTableHeader().setPreferredSize(new Dimension(10,34)); }
}
