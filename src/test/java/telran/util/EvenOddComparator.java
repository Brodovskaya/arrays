/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package telran.util;

import java.util.Comparator;


public class EvenOddComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer arg0, Integer arg1) {
        int res;
        boolean isEvenArg0 = (arg0 % 2 == 0);
        boolean isEvenArg1 = (arg1 % 2 == 0);

        if (isEvenArg0 && isEvenArg1){
            int comp = Integer.compare(arg0, arg1);
            res = isEvenArg0 ? comp : - comp;
        } else {
            res = isEvenArg0 ? -1 : 1;
        }
              
        return res;
    }

}
