/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cifrar_Descifrar;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Pitt
 */
public class Reporte {
    
    
    
    public void generarReporte(String clave,String cifrado,char[][] matriz,int num) throws IOException{
        try (PrintWriter out1 = new PrintWriter("src//ArchivosGenerados//Cifrado_"+num+".txt", StandardCharsets.UTF_8)) {
            out1.println("MATRIZ DE VIGENERE:");
            out1.println("");
            for (int i = 0; i < 27; i++) {
                String msj="";
                for (int j = 0; j < 27; j++) {
                    msj=msj+matriz[i][j]+" ";
                }
                out1.println(msj);
            }
            out1.println("");
            out1.println("");
            out1.println("Mensaje Cifrado -> "+cifrado);
            out1.println("Clave -> "+clave);
        }
    }
}
