/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package systemPackage;

import static groovy.inspect.Inspector.print;
import java.awt.Container;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author NishanV
 */
public class ReportView extends JFrame
{
    public ReportView(String fileName)
    {
        this(fileName, null);
    }
    public ReportView(String fileName, HashMap para)
    {   
        super("Video lending System (Report Viewer)");

        try
        {
            DBConnect connect = new DBConnect();
            //connect.conn=connect.DBConnect();
            //Connection con=dba.DBConnect();
            JasperPrint print = JasperFillManager.fillReport(fileName, para, connect.conn);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (Exception Exception)
        {
            
        }
        setBounds(10, 10, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}
