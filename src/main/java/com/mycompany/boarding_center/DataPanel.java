package com.mycompany.boarding_center;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/** Reusable MVC-style CRUD panel for customers, pets, reservations and staff. */
public class DataPanel extends JPanel {
    private final String title, tableName, idColumn, selectSql;
    private final String[] columns, fieldLabels, fieldColumns;
    private final JTextField[] inputs;
    private final JTable table = new JTable();
    private final DefaultTableModel model = new DefaultTableModel();
    private final JLabel status = new JLabel("Ready");
    private int selectedId = -1;

    public DataPanel(String title, String tableName, String idColumn, String selectSql,
                     String[] columns, String[] fieldLabels, String[] fieldColumns) {
        this.title=title; this.tableName=tableName; this.idColumn=idColumn; this.selectSql=selectSql;
        this.columns=columns; this.fieldLabels=fieldLabels; this.fieldColumns=fieldColumns;
        this.inputs=new JTextField[fieldLabels.length];
        buildUI(); refresh();
    }

    private void buildUI() {
        setLayout(new BorderLayout(14,14)); setBackground(Theme.BG); setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        JPanel top=new JPanel(new BorderLayout()); top.setOpaque(false);
        top.add(Theme.heading(title),BorderLayout.WEST);
        JButton refresh=new JButton("Refresh"); Theme.styleButton(refresh,false); refresh.addActionListener(e->refresh()); top.add(refresh,BorderLayout.EAST);
        add(top,BorderLayout.NORTH);

        JPanel left=Theme.card(); left.setLayout(new BorderLayout(8,10)); left.setPreferredSize(new Dimension(340,400));
        JLabel formTitle=new JLabel("Record details"); formTitle.setFont(new Font("Segoe UI",Font.BOLD,16)); formTitle.setForeground(Theme.TEXT); left.add(formTitle,BorderLayout.NORTH);
        JPanel fields=new JPanel(new GridBagLayout()); fields.setOpaque(false);
        GridBagConstraints g=new GridBagConstraints(); g.gridx=0; g.gridy=0; g.weightx=1; g.fill=GridBagConstraints.HORIZONTAL; g.insets=new Insets(4,0,3,0); g.anchor=GridBagConstraints.WEST;
        for(int i=0;i<fieldLabels.length;i++){
            JLabel label=new JLabel(fieldLabels[i]); label.setFont(new Font("Segoe UI",Font.PLAIN,12)); label.setForeground(Theme.MUTED);
            g.gridy++; fields.add(label,g);
            inputs[i]=new JTextField(); inputs[i].setFont(new Font("Segoe UI",Font.PLAIN,13)); inputs[i].setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.LineBorder(Theme.LINE),BorderFactory.createEmptyBorder(7,8,7,8)));
            g.gridy++; fields.add(inputs[i],g);
        }
        left.add(new JScrollPane(fields),BorderLayout.CENTER);
        JPanel actions=new JPanel(new GridLayout(2,2,8,8)); actions.setOpaque(false);
        JButton save=new JButton("Save / Update"), clear=new JButton("Clear"), delete=new JButton("Delete"), search=new JButton("Search");
        Theme.styleButton(save,true); Theme.styleButton(clear,false); Theme.styleButton(delete,false); Theme.styleButton(search,false);
        save.addActionListener(e->saveRecord()); clear.addActionListener(e->clearForm()); delete.addActionListener(e->deleteRecord()); search.addActionListener(e->searchRecords());
        actions.add(save); actions.add(clear); actions.add(delete); actions.add(search); left.add(actions,BorderLayout.SOUTH);

        JPanel right=Theme.card(); right.setLayout(new BorderLayout(8,8));
        JLabel listTitle=new JLabel("Records"); listTitle.setFont(new Font("Segoe UI",Font.BOLD,16)); right.add(listTitle,BorderLayout.NORTH);
        model.setColumnIdentifiers(columns); table.setModel(model); Theme.styleTable(table); table.setAutoCreateRowSorter(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); table.getSelectionModel().addListSelectionListener(e->{if(!e.getValueIsAdjusting()&&table.getSelectedRow()>=0) loadSelected();});
        right.add(new JScrollPane(table),BorderLayout.CENTER); status.setForeground(Theme.MUTED); right.add(status,BorderLayout.SOUTH);
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,right); split.setResizeWeight(0.30); split.setBorder(null); split.setOpaque(false);
        add(split,BorderLayout.CENTER);
    }

    private void refresh() {
        try(Connection c=Database.getConnection(); Statement s=c.createStatement(); ResultSet rs=s.executeQuery(selectSql)){
            model.setRowCount(0); int count=0; ResultSetMetaData md=rs.getMetaData(); int n=Math.min(columns.length,md.getColumnCount());
            while(rs.next()){ Object[] row=new Object[n]; for(int i=0;i<n;i++)row[i]=rs.getObject(i+1); model.addRow(row); count++; }
            status.setText(count+" record(s)"); selectedId=-1;
        } catch(SQLException ex){ status.setText("Database unavailable"); }
    }

    private void loadSelected(){
        int view=table.getSelectedRow(); if(view<0)return; int row=table.convertRowIndexToModel(view);
        try { selectedId=Integer.parseInt(String.valueOf(model.getValueAt(row,0))); } catch(Exception ex){selectedId=-1;}
        // Load values in the form in the same order as fieldColumns.
        try(Connection c=Database.getConnection(); PreparedStatement p=c.prepareStatement("SELECT * FROM "+tableName+" WHERE "+idColumn+"=?")){
            p.setInt(1,selectedId); try(ResultSet rs=p.executeQuery()){ if(rs.next()) for(int i=0;i<fieldColumns.length;i++){ Object v=rs.getObject(fieldColumns[i]); inputs[i].setText(v==null?"":String.valueOf(v)); } }
        } catch(SQLException ex){ status.setText("Could not load selected record"); }
    }

    private void validateInput() throws UserDefinedValidationException {
        for(int i=0;i<fieldLabels.length;i++){
            if(fieldLabels[i].toLowerCase().contains("name") && inputs[i].getText().trim().isEmpty())
                throw new UserDefinedValidationException(fieldLabels[i]+" is required.");
        }
        if(tableName.equals("pets") && !inputs[0].getText().trim().matches("\\d+"))
            throw new UserDefinedValidationException("Customer ID must be a number that exists in Customers.");
        if(tableName.equals("reservations")){
            if(!inputs[0].getText().trim().matches("\\d+") || !inputs[1].getText().trim().matches("\\d+"))
                throw new UserDefinedValidationException("Pet ID and Customer ID must be numeric.");
            if(inputs[3].getText().trim().isEmpty() || inputs[4].getText().trim().isEmpty())
                throw new UserDefinedValidationException("Check-in and check-out dates are required (YYYY-MM-DD).");
        }
    }

    private void saveRecord(){
        try{
            validateInput();
            if(selectedId>0){
                StringJoiner set=new StringJoiner(","); for(String col:fieldColumns)set.add(col+"=?");
                try(Connection c=Database.getConnection(); PreparedStatement p=c.prepareStatement("UPDATE "+tableName+" SET "+set+" WHERE "+idColumn+"=?")){
                    bindFields(p); p.setInt(fieldColumns.length+1,selectedId); p.executeUpdate();
                }
                JOptionPane.showMessageDialog(this,"Record updated successfully.");
            } else {
                StringJoiner cols=new StringJoiner(","), marks=new StringJoiner(",");
                for(String col:fieldColumns){cols.add(col);marks.add("?");}
                try(Connection c=Database.getConnection(); PreparedStatement p=c.prepareStatement("INSERT INTO "+tableName+" ("+cols+") VALUES ("+marks+")")){
                    bindFields(p); p.executeUpdate();
                }
                JOptionPane.showMessageDialog(this,"Record saved successfully.");
            }
            refresh(); clearForm();
        }catch(UserDefinedValidationException ex){JOptionPane.showMessageDialog(this,ex.getMessage(),"Check input",JOptionPane.WARNING_MESSAGE);}
        catch(SQLException ex){JOptionPane.showMessageDialog(this,"Save failed. Check required fields, IDs and date format.\n"+ex.getMessage(),"Database error",JOptionPane.ERROR_MESSAGE);}
    }

    private void bindFields(PreparedStatement p)throws SQLException{
        for(int i=0;i<fieldColumns.length;i++){
            String value=inputs[i].getText().trim();
            if(value.isEmpty()) p.setNull(i+1,Types.VARCHAR);
            else if((fieldColumns[i].equals("age_years")||fieldColumns[i].equals("customer_id")||fieldColumns[i].equals("pet_id")) && value.matches("\\d+")) p.setInt(i+1,Integer.parseInt(value));
            else if(fieldColumns[i].equals("amount")) p.setBigDecimal(i+1,new java.math.BigDecimal(value));
            else if(fieldColumns[i].endsWith("_date")||fieldColumns[i].equals("check_in")||fieldColumns[i].equals("check_out")||fieldColumns[i].equals("vaccination_expiry")) p.setDate(i+1,java.sql.Date.valueOf(value));
            else p.setString(i+1,value);
        }
    }

    private void deleteRecord(){
        if(selectedId<0){JOptionPane.showMessageDialog(this,"Select a record from the table first.");return;}
        if(JOptionPane.showConfirmDialog(this,"Delete selected record?","Confirm delete",JOptionPane.YES_NO_OPTION)!=JOptionPane.YES_OPTION)return;
        try(Connection c=Database.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM "+tableName+" WHERE "+idColumn+"=?")){
            p.setInt(1,selectedId);p.executeUpdate();refresh();clearForm();JOptionPane.showMessageDialog(this,"Record deleted.");
        }catch(SQLException ex){JOptionPane.showMessageDialog(this,"This record may be linked to another record.\n"+ex.getMessage(),"Delete failed",JOptionPane.ERROR_MESSAGE);}
    }
    private void searchRecords(){
        String q=JOptionPane.showInputDialog(this,"Enter text to search in the current table:"); if(q==null||q.isBlank()){refresh();return;}
        try(Connection c=Database.getConnection();PreparedStatement p=c.prepareStatement(selectSql+"")){
            try(ResultSet rs=p.executeQuery()){model.setRowCount(0);ResultSetMetaData md=rs.getMetaData();int n=Math.min(columns.length,md.getColumnCount());
                while(rs.next()){boolean match=false;for(int i=1;i<=n;i++)if(String.valueOf(rs.getObject(i)).toLowerCase().contains(q.toLowerCase()))match=true;
                    if(match){Object[] row=new Object[n];for(int i=0;i<n;i++)row[i]=rs.getObject(i+1);model.addRow(row);}}
            }
        }catch(SQLException ex){status.setText("Search failed");}
    }
    private void clearForm(){selectedId=-1;for(JTextField f:inputs)f.setText("");table.clearSelection();}
}
