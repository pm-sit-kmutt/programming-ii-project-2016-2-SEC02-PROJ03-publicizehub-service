/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;

import java.util.Date;

/**
 *
 * @author นัน
 */
public class Comment {
    private static String author;
    private static Date date;
    private static String text;

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        Comment.author = author;
    }

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        Comment.date = date;
    }

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Comment.text = text;
    }
    
    
}
