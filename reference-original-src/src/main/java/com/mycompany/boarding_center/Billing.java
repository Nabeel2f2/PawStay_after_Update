package com.mycompany.boarding_center;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Billing extends javax.swing.JFrame {

    public Billing() {
        initComponents();
        populateSampleData();
    }

    private void populateSampleData() {
        DefaultTableModel model = (DefaultTableModel) tblItemizedCharges.getModel();
        model.setRowCount(0);
        model.addRow(new Object[]{"1", "Standard Kennel (Large Dog)", "5 nights", "3,000.00", "15,000.00"});
        model.addRow(new Object[]{"2", "Additional Playtime", "1", "1,000.00", "1,000.00"});
        model.addRow(new Object[]{"3", "Treats", "1", "500.00", "500.00"});
        model.addRow(new Object[]{"4", "Late Check-out Fee", "1", "500.00", "500.00"});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroupPaymentMethod = new javax.swing.ButtonGroup();
        pnlSidebar = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblSubTitle = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnCustomers = new javax.swing.JButton();
        btnPets = new javax.swing.JButton();
        btnReservations = new javax.swing.JButton();
        btnAccommodation = new javax.swing.JButton();
        btnCheckInOut = new javax.swing.JButton();
        btnDailyCare = new javax.swing.JButton();
        btnBilling = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        pnlMainContent = new javax.swing.JPanel();
        lblHeaderTitle = new javax.swing.JLabel();
        pnlInvoiceDetails = new javax.swing.JPanel();
        lblInvoiceNo = new javax.swing.JLabel();
        txtInvoiceNo = new javax.swing.JTextField();
        lblOwner = new javax.swing.JLabel();
        cmbOwner = new javax.swing.JComboBox<>();
        lblPet = new javax.swing.JLabel();
        cmbPet = new javax.swing.JComboBox<>();
        lblStayDates = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        lblTo = new javax.swing.JLabel();
        txtEndDate = new javax.swing.JTextField();
        lblBoardingNights = new javax.swing.JLabel();
        txtBoardingNights = new javax.swing.JTextField();
        lblBoardingRate = new javax.swing.JLabel();
        txtBoardingRate = new javax.swing.JTextField();
        pnlPaymentInfo = new javax.swing.JPanel();
        lblTotalAmountLabel = new javax.swing.JLabel();
        lblTotalAmountVal = new javax.swing.JLabel();
        lblAmountPaid = new javax.swing.JLabel();
        txtAmountPaid = new javax.swing.JTextField();
        lblBalanceLabel = new javax.swing.JLabel();
        lblBalanceVal = new javax.swing.JLabel();
        lblPaymentMethod = new javax.swing.JLabel();
        rdoCash = new javax.swing.JRadioButton();
        rdoCard = new javax.swing.JRadioButton();
        rdoBankTransfer = new javax.swing.JRadioButton();
        lblRefNo = new javax.swing.JLabel();
        txtRefNo = new javax.swing.JTextField();
        btnRecordPayment = new javax.swing.JButton();
        btnPrintInvoice = new javax.swing.JButton();
        pnlItemizedCharges = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemizedCharges = new javax.swing.JTable();
        lblTableTotalLabel = new javax.swing.JLabel();
        lblTableTotalVal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PawStay - Billing and Payments");
        setBackground(new java.awt.Color(240, 244, 248));

        pnlSidebar.setBackground(new java.awt.Color(11, 37, 69));

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setText("🐾 PawStay");

        lblSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 11));
        lblSubTitle.setForeground(new java.awt.Color(160, 180, 200));
        lblSubTitle.setText("Pet Boarding Management");

        btnDashboard.setBackground(new java.awt.Color(11, 37, 69));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorderPainted(false);
        btnDashboard.setFocusPainted(false);
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnCustomers.setBackground(new java.awt.Color(11, 37, 69));
        btnCustomers.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnCustomers.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomers.setText("Customers");
        btnCustomers.setBorderPainted(false);
        btnCustomers.setFocusPainted(false);
        btnCustomers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnPets.setBackground(new java.awt.Color(11, 37, 69));
        btnPets.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnPets.setForeground(new java.awt.Color(255, 255, 255));
        btnPets.setText("Pets");
        btnPets.setBorderPainted(false);
        btnPets.setFocusPainted(false);
        btnPets.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnReservations.setBackground(new java.awt.Color(11, 37, 69));
        btnReservations.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnReservations.setForeground(new java.awt.Color(255, 255, 255));
        btnReservations.setText("Reservations");
        btnReservations.setBorderPainted(false);
        btnReservations.setFocusPainted(false);
        btnReservations.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnAccommodation.setBackground(new java.awt.Color(11, 37, 69));
        btnAccommodation.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnAccommodation.setForeground(new java.awt.Color(255, 255, 255));
        btnAccommodation.setText("Accommodation");
        btnAccommodation.setBorderPainted(false);
        btnAccommodation.setFocusPainted(false);
        btnAccommodation.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnCheckInOut.setBackground(new java.awt.Color(11, 37, 69));
        btnCheckInOut.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnCheckInOut.setForeground(new java.awt.Color(255, 255, 255));
        btnCheckInOut.setText("Check-in/out");
        btnCheckInOut.setBorderPainted(false);
        btnCheckInOut.setFocusPainted(false);
        btnCheckInOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnDailyCare.setBackground(new java.awt.Color(11, 37, 69));
        btnDailyCare.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnDailyCare.setForeground(new java.awt.Color(255, 255, 255));
        btnDailyCare.setText("Daily Care");
        btnDailyCare.setBorderPainted(false);
        btnDailyCare.setFocusPainted(false);
        btnDailyCare.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnBilling.setBackground(new java.awt.Color(0, 150, 136));
        btnBilling.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnBilling.setForeground(new java.awt.Color(255, 255, 255));
        btnBilling.setText("Billing");
        btnBilling.setBorderPainted(false);
        btnBilling.setFocusPainted(false);
        btnBilling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnReports.setBackground(new java.awt.Color(11, 37, 69));
        btnReports.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnReports.setForeground(new java.awt.Color(255, 255, 255));
        btnReports.setText("Reports");
        btnReports.setBorderPainted(false);
        btnReports.setFocusPainted(false);
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnStaff.setBackground(new java.awt.Color(11, 37, 69));
        btnStaff.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnStaff.setForeground(new java.awt.Color(255, 255, 255));
        btnStaff.setText("Staff");
        btnStaff.setBorderPainted(false);
        btnStaff.setFocusPainted(false);
        btnStaff.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnSettings.setBackground(new java.awt.Color(11, 37, 69));
        btnSettings.setFont(new java.awt.Font("Segoe UI", 0, 13));
        btnSettings.setForeground(new java.awt.Color(255, 255, 255));
        btnSettings.setText("Settings");
        btnSettings.setBorderPainted(false);
        btnSettings.setFocusPainted(false);
        btnSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo)
                    .addComponent(lblSubTitle))
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCustomers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReservations, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAccommodation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCheckInOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDailyCare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBilling, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogo)
                .addGap(2, 2, 2)
                .addComponent(lblSubTitle)
                .addGap(30, 30, 30)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPets, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccommodation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCheckInOut, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDailyCare, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReports, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMainContent.setBackground(new java.awt.Color(244, 246, 249));

        lblHeaderTitle.setFont(new java.awt.Font("Segoe UI", 1, 20));
        lblHeaderTitle.setForeground(new java.awt.Color(30, 41, 59));
        lblHeaderTitle.setText("🧾  Billing and Payments");

        pnlInvoiceDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlInvoiceDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoice Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(30, 41, 59)));

        lblInvoiceNo.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblInvoiceNo.setText("Invoice No.");

        txtInvoiceNo.setText("INV-2025-0045");
        txtInvoiceNo.setEditable(false);

        lblOwner.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblOwner.setText("Owner");

        cmbOwner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nimal Perera" }));

        lblPet.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblPet.setText("Pet");

        cmbPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bobby (Golden Retriever)" }));

        lblStayDates.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblStayDates.setText("Stay Dates");

        txtStartDate.setText("2025-07-10");

        lblTo.setText("to");

        txtEndDate.setText("2025-07-15");

        lblBoardingNights.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblBoardingNights.setText("Boarding Nights");

        txtBoardingNights.setText("5");

        lblBoardingRate.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblBoardingRate.setText("Boarding Rate (per night)");

        txtBoardingRate.setText("LKR  3,000.00");

        javax.swing.GroupLayout pnlInvoiceDetailsLayout = new javax.swing.GroupLayout(pnlInvoiceDetails);
        pnlInvoiceDetails.setLayout(pnlInvoiceDetailsLayout);
        pnlInvoiceDetailsLayout.setHorizontalGroup(
            pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInvoiceDetailsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInvoiceNo)
                    .addComponent(lblOwner)
                    .addComponent(lblPet)
                    .addComponent(lblStayDates)
                    .addComponent(lblBoardingNights)
                    .addComponent(lblBoardingRate))
                .addGap(25, 25, 25)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtInvoiceNo)
                    .addComponent(cmbOwner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbPet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInvoiceDetailsLayout.createSequentialGroup()
                        .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEndDate, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                    .addComponent(txtBoardingNights)
                    .addComponent(txtBoardingRate))
                .addGap(15, 15, 15))
        );
        pnlInvoiceDetailsLayout.setVerticalGroup(
            pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInvoiceDetailsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInvoiceNo)
                    .addComponent(txtInvoiceNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOwner)
                    .addComponent(cmbOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPet)
                    .addComponent(cmbPet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStayDates)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTo)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBoardingNights)
                    .addComponent(txtBoardingNights, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlInvoiceDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBoardingRate)
                    .addComponent(txtBoardingRate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlPaymentInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlPaymentInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(30, 41, 59)));

        lblTotalAmountLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblTotalAmountLabel.setText("Total Amount");

        lblTotalAmountVal.setFont(new java.awt.Font("Segoe UI", 1, 16));
        lblTotalAmountVal.setText("LKR 17,000.00");

        lblAmountPaid.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblAmountPaid.setText("Amount Paid");

        txtAmountPaid.setFont(new java.awt.Font("Segoe UI", 0, 13));
        txtAmountPaid.setText("17,000.00");

        lblBalanceLabel.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblBalanceLabel.setText("Balance");

        lblBalanceVal.setFont(new java.awt.Font("Segoe UI", 1, 15));
        lblBalanceVal.setForeground(new java.awt.Color(46, 125, 50));
        lblBalanceVal.setText("LKR 0.00");

        lblPaymentMethod.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblPaymentMethod.setText("Payment Method");

        buttonGroupPaymentMethod.add(rdoCash);
        rdoCash.setSelected(true);
        rdoCash.setText("Cash");

        buttonGroupPaymentMethod.add(rdoCard);
        rdoCard.setText("Card");

        buttonGroupPaymentMethod.add(rdoBankTransfer);
        rdoBankTransfer.setText("Bank Transfer");

        lblRefNo.setFont(new java.awt.Font("Segoe UI", 0, 13));
        lblRefNo.setText("Reference No.");

        txtRefNo.setFont(new java.awt.Font("Segoe UI", 2, 12));
        txtRefNo.setForeground(new java.awt.Color(128, 128, 128));
        txtRefNo.setText("e.g. Card last 4 digits / Transfer ID");

        btnRecordPayment.setBackground(new java.awt.Color(0, 150, 136));
        btnRecordPayment.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnRecordPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnRecordPayment.setText("💳  Record Payment");

        btnPrintInvoice.setBackground(new java.awt.Color(240, 244, 248));
        btnPrintInvoice.setFont(new java.awt.Font("Segoe UI", 1, 13));
        btnPrintInvoice.setText("🖨  Print Invoice");

        javax.swing.GroupLayout pnlPaymentInfoLayout = new javax.swing.GroupLayout(pnlPaymentInfo);
        pnlPaymentInfo.setLayout(pnlPaymentInfoLayout);
        pnlPaymentInfoLayout.setHorizontalGroup(
            pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaymentInfoLayout.createSequentialGroup()
                        .addComponent(btnRecordPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(btnPrintInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtRefNo)
                    .addGroup(pnlPaymentInfoLayout.createSequentialGroup()
                        .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPaymentMethod)
                            .addComponent(lblRefNo)
                            .addGroup(pnlPaymentInfoLayout.createSequentialGroup()
                                .addComponent(rdoCash)
                                .addGap(18, 18, 18)
                                .addComponent(rdoCard)
                                .addGap(18, 18, 18)
                                .addComponent(rdoBankTransfer)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPaymentInfoLayout.createSequentialGroup()
                        .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalAmountLabel)
                            .addComponent(lblAmountPaid)
                            .addComponent(lblBalanceLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalAmountVal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAmountPaid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBalanceVal, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(15, 15, 15))
        );
        pnlPaymentInfoLayout.setVerticalGroup(
            pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentInfoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalAmountLabel)
                    .addComponent(lblTotalAmountVal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAmountPaid)
                    .addComponent(txtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBalanceLabel)
                    .addComponent(lblBalanceVal))
                .addGap(18, 18, 18)
                .addComponent(lblPaymentMethod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoCash)
                    .addComponent(rdoCard)
                    .addComponent(rdoBankTransfer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRefNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRefNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPaymentInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRecordPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnlItemizedCharges.setBackground(new java.awt.Color(255, 255, 255));
        pnlItemizedCharges.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Itemized Charges", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(30, 41, 59)));

        tblItemizedCharges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Description", "Quantity", "Rate (LKR)", "Amount (LKR)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblItemizedCharges);

        lblTableTotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblTableTotalLabel.setText("Total");

        lblTableTotalVal.setFont(new java.awt.Font("Segoe UI", 1, 13));
        lblTableTotalVal.setText("LKR 17,000.00");

        javax.swing.GroupLayout pnlItemizedChargesLayout = new javax.swing.GroupLayout(pnlItemizedCharges);
        pnlItemizedCharges.setLayout(pnlItemizedChargesLayout);
        pnlItemizedChargesLayout.setHorizontalGroup(
            pnlItemizedChargesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemizedChargesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlItemizedChargesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlItemizedChargesLayout.createSequentialGroup()
                        .addComponent(lblTableTotalLabel)
                        .addGap(40, 40, 40)
                        .addComponent(lblTableTotalVal))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlItemizedChargesLayout.setVerticalGroup(
            pnlItemizedChargesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlItemizedChargesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlItemizedChargesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTableTotalLabel)
                    .addComponent(lblTableTotalVal))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainContentLayout = new javax.swing.GroupLayout(pnlMainContent);
        pnlMainContent.setLayout(pnlMainContentLayout);
        pnlMainContentLayout.setHorizontalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainContentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHeaderTitle)
                    .addGroup(pnlMainContentLayout.createSequentialGroup()
                        .addComponent(pnlInvoiceDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlPaymentInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlItemizedCharges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlMainContentLayout.setVerticalGroup(
            pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainContentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHeaderTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlMainContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPaymentInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInvoiceDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlItemizedCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMainContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Billing().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAccommodation;
    private javax.swing.JButton btnBilling;
    private javax.swing.JButton btnCheckInOut;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDailyCare;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnPets;
    private javax.swing.JButton btnPrintInvoice;
    private javax.swing.JButton btnRecordPayment;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnReservations;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnStaff;
    private javax.swing.ButtonGroup buttonGroupPaymentMethod;
    private javax.swing.JComboBox<String> cmbOwner;
    private javax.swing.JComboBox<String> cmbPet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmountPaid;
    private javax.swing.JLabel lblBalanceLabel;
    private javax.swing.JLabel lblBalanceVal;
    private javax.swing.JLabel lblBoardingNights;
    private javax.swing.JLabel lblBoardingRate;
    private javax.swing.JLabel lblHeaderTitle;
    private javax.swing.JLabel lblInvoiceNo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblOwner;
    private javax.swing.JLabel lblPaymentMethod;
    private javax.swing.JLabel lblPet;
    private javax.swing.JLabel lblRefNo;
    private javax.swing.JLabel lblStayDates;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTableTotalLabel;
    private javax.swing.JLabel lblTableTotalVal;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblTotalAmountLabel;
    private javax.swing.JLabel lblTotalAmountVal;
    private javax.swing.JPanel pnlInvoiceDetails;
    private javax.swing.JPanel pnlItemizedCharges;
    private javax.swing.JPanel pnlMainContent;
    private javax.swing.JPanel pnlPaymentInfo;
    private javax.swing.JPanel pnlSidebar;
    private javax.swing.JRadioButton rdoBankTransfer;
    private javax.swing.JRadioButton rdoCard;
    private javax.swing.JRadioButton rdoCash;
    private javax.swing.JTable tblItemizedCharges;
    private javax.swing.JTextField txtAmountPaid;
    private javax.swing.JTextField txtBoardingNights;
    private javax.swing.JTextField txtBoardingRate;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtInvoiceNo;
    private javax.swing.JTextField txtRefNo;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration                   
}