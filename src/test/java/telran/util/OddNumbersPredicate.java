/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package telran.util;

import java.util.function.Predicate;


public class OddNumbersPredicate implements Predicate <Integer>{

    @Override
    public boolean test(Integer t) {

        return t % 2 != 0;
    }

}
