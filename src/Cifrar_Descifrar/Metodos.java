
package Cifrar_Descifrar;

/**
 *
 * @author Pitt
 */
public class Metodos {
    
    private char[] mensaje;
    private char[] clave;
    private char[] resultado;
    private char[][] matrizGeneral= new char[27][27];

    public Metodos(String msj, String cl) {
        this.mensaje = msj.toCharArray();
        this.clave = this.claveAumento(cl);
    }
    
    private char[] claveAumento(String clave){
        char[] claveTemp=clave.toCharArray();
        char [] clave2 = new char[this.mensaje.length]; 
        int cont=0;
        for (int i = 0; i < this.mensaje.length; i++) {
            clave2[i]=claveTemp[cont];
            cont++;
            if(cont==claveTemp.length){
                cont=0;
            }
        }
        return clave2;
    }
    
    private char[] generarAbecedario(){
        char[] abc=new char[27];
        int asci=65;
        for (int i = 0; i <27; i++) {
            if(i!=14){
                abc[i]=(char)asci;
                asci++;
            }else{
                abc[i]='\u00D1';
            }
        }
        return abc;
    }
    
    public char[][] generarMatrizVigenere(){
        int contador;
        char abcTemp[]=this.generarAbecedario();
        char abc[]=new char[abcTemp.length*2];
        for (int i = 0; i < 27; i++) {
            abc[i]=abcTemp[i];
            abc[i+27]=abcTemp[i];
        }
        char[][] matriz = new char[27][27];
        for (int i = 0; i < 27; i++) {
            contador=0;
            for (int j = 0; j < 27; j++) {
                matriz[i][j]=abc[contador+i];
                matrizGeneral[i][j]=abc[contador+i];
                contador++;
            }
        }
        return matriz;
    }
    
    public char[] cifrar(char[][] matriz){
        int i = 0;
        int j = 0;
        int k=0;
        char[] cifrado= new char[mensaje.length];
        for (int l = 0; l < mensaje.length; l++) {
            do {  
                if(mensaje[l]==matriz[0][k]){
                    i=k;
//                    System.out.println("Msj-> "+matriz[0][k]);
                    break;
                }
                k++;
            } while (true);
            k=0;
            do {                
                if(clave[l]==matriz[k][0]){
                    j=k;
//                    System.out.println("Cl-> "+matriz[k][0]);
                    break;
                }
                k++;
            } while (true);
            k=0;
            cifrado[l]=matriz[i][j];
//            System.out.println("Cifrado-> "+matriz[i][j]);
        }
        
        
        return cifrado;
    }
    
    public char[] descifrar(char[][] matriz){
        int i = 0;
        int j = 0;
        int k=0;
        char[] descifrado= new char[mensaje.length];
        for (int l = 0; l < mensaje.length; l++) {
           do {                
                if(clave[l]==matriz[k][0]){
                    j=k;
                    
                    break;
                }
                k++;
            } while (true);
            k=0;
            
            do{
                if(mensaje[l]==matriz[k][j]){
                    i=k;
                    break;
                }
                k++;
            }while(true);
            k=0;
            
            
            
            descifrado[l]=matriz[0][i];
            
//            
        }
        return descifrado;
    }


    
    
}
