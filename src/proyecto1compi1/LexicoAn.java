/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1compi1;

import jflex.exceptions.SilentExit;

/**
 *
 * @author Dominic
 */
public class LexicoAn {
    
    public static void main(String[] args) throws SilentExit {
        
        String ruta = "C:/Users/Dominic/Documents/NetBeansProjects/Proyecto1Compi1/src/proyecto1compi1/";
        
        //ruta donde tenemos los archivos con extension .jflex y .cup
        String opcFlex[] = {ruta + "Lexer.jflex", "-d", ruta};
        jflex.Main.generate(opcFlex);

    }
    
}
