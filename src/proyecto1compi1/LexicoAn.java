/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1compi1;

import java.io.IOException;
import jflex.SilentExit;
/**
 *
 * @author Dominic
 */
public class LexicoAn {

    public static void main(String[] args) throws IOException, SilentExit, Exception {

        String ruta = "C:/Users/Dominic/Documents/NetBeansProjects/Proyecto1Compi1/src/proyecto1compi1/";
        //ruta donde tenemos los archivos con extension .jflex y .cup
        //String opcFlex[] = {ruta + "Lexer.jflex", "-d", ruta};
        //jflex.Main.generate(opcFlex);
        
        String opcCUP[] = {"-destdir", ruta, "-parser", "Parser", ruta + "Parser.cup"};
        java_cup.Main.main(opcCUP);
        

    }

}
