/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Practices;

/**
 *
 * @author Sora
 */
public class DivideAWord {
    public static void main(String[] args){
        String text = "1,2,3,";
        String[] texts = text.split(",");
        
        for(int i=0; i<texts.length;i++){
            System.out.println("text :" + texts[i]);
        }
    }
}
