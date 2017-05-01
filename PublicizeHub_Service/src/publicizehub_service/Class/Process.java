/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;

import java.sql.Date;

/**
 *
 * @author นัน
 */
public class Process {
    private static String text;
    private static Date date;

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Process.text = text;
    }

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        Process.date = date;
    }
}
