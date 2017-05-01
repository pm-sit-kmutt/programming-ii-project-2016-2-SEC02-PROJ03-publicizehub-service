/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;


/**
 *
 * @author นัน
 */
public class Money {
    private static String text;
    private static double cost; 

    public static String getText() {
        return text;
    }

    public static void setText(String text) {
        Money.text = text;
    }

    public static double getCost() {
        return cost;
    }

    public static void setCost(double cost) {
        Money.cost = cost;
    }
    
    
}
