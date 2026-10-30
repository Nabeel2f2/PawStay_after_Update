package com.mycompany.boarding_center;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/** JasperReports report uses data joined from reservations, customers and pets. */
public final class ReportService {
    private ReportService(){}
    public static File generateReservationReport() throws Exception {
        try(Connection c=Database.getConnection()){
            JasperReport report;
            try(var in=ReportService.class.getResourceAsStream("/reports/reservation_report.jrxml")){
                if(in==null)throw new IllegalStateException("Missing /reports/reservation_report.jrxml resource.");
                report=JasperCompileManager.compileReport(JRXmlLoader.load(in));
            }
            String sql="SELECT r.reservation_id,c.full_name AS customer_name,p.pet_name,p.breed,r.kennel_code,r.check_in,r.check_out,r.status,r.amount FROM reservations r JOIN customers c ON c.customer_id=r.customer_id JOIN pets p ON p.pet_id=r.pet_id ORDER BY r.check_in";
            JasperPrint print=JasperFillManager.fillReport(report,new HashMap<>(),c);
            File dir=new File("reports");if(!dir.exists())dir.mkdirs();
            File out=new File(dir,"PawStay_Reservation_Report.pdf");
            JasperExportManager.exportReportToPdfFile(print,out.getAbsolutePath());return out;
        }
    }
}
