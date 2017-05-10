/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;

import javax.swing.JTable;


/**
 *
 * @author นัน
 */
public class Money {
    private String text;
    private double cost;
    private static double sumCost = 0;

    public Money() {
    }

    public Money(String text, double cost) {
        this.text = text;
        this.cost = cost;
    }
    
    public static Money[] jTableToArrayMoney(JTable table){
        int tableRow = table.getRowCount();
        Money[] ArrayMoney = new Money[tableRow];
        sumCost = 0;
        for (int i = 0; i < tableRow; i++) {
            ArrayMoney[i] = new Money(table.getValueAt(i, 1).toString(), (double)table.getValueAt(i, 2));
            sumCost += (double)table.getValueAt(i, 2);
        }
        return ArrayMoney;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public static double getSumCost() {
        return sumCost;
    }

    @Override
    public String toString() {
        return "Money{" + "text=" + text + ", cost=" + cost + '}';
    }
    
}
