/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javax.swing.JTable;

/**
 *
 * @author นัน
 */
public class ProjectProcess {
    private String text;
    private Date date;

    public ProjectProcess() {
    }

    public ProjectProcess(String text, Date date) {
        this.text = text;
        this.date = date;
    }
    
    public static ProjectProcess[] jTableToArrayProcess(JTable table) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        int tableRow = table.getRowCount();
        ProjectProcess[] ArrayProcess = new ProjectProcess[tableRow];
        for (int i = 0; i < tableRow; i++) {
            ArrayProcess[i] = new ProjectProcess(table.getValueAt(i, 1).toString(), new Date(df.parse((String) table.getValueAt(i, 2)).getTime()));
        }
        return ArrayProcess;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Process{" + "text=" + text + ", date=" + date + '}';
    }

   
}
