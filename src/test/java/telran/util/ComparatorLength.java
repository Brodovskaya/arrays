/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package telran.util;

import java.util.Comparator;


public class ComparatorLength implements Comparator<String>{

    @Override
    public int compare(String arg0, String arg1) {
        return arg0.length() - arg1.length();
    }

}