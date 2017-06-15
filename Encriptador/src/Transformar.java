public class Transformar {

    public String encriptar(String texto,String clave)
    {
        int tamtext=texto.length();
        int tamclav=clave.length();
        int temp,p=0;
        String encriptado="";
    /* Se crea un array de enteros que contendran los numeros que
       corresponde a los caracteres en Ascii de los String Texto y la Clave */

        int textoAscii[]= new int[tamtext];
        int claveAscii[]= new int[tamclav];

    /* Se guardan los caracteres de cada String en
       numeros correspondientes al Ascii           */
        for(int i=0;i<tamtext;i++)
          textoAscii[i] = texto.charAt(i);

        for(int i=0;i<tamclav;i++)
          claveAscii[i] = clave.charAt(i);

        //Se procede al ENCRIPTADO
       for(int i=0;i<tamtext;i++){
         p++;

         if(p >= tamclav)
          p=0;

         temp =textoAscii[i]+claveAscii[p];

         if (temp > 255)
         temp=temp-255;

         encriptado = encriptado + (char)temp;
        }

     return encriptado;
    }

    public String desencriptar(String texto,String clave){
        int tamtext=texto.length();
        int tamclav=clave.length();
        int temp,p=0;
        String desencriptado="";
    /* Se crea un array de enteros que contendran los numeros que
       corresponde a los caracteres en Ascii de los String Texto y la Clave */

        int textoAscii[]= new int[tamtext];
        int claveAscii[]= new int[tamclav];

    /* Se guardan los caracteres de cada String en
       numeros correspondientes al Ascii           */
        for(int i=0;i<tamtext;i++)
          textoAscii[i] = texto.charAt(i);

        for(int i=0;i<tamclav;i++)
          claveAscii[i] = clave.charAt(i);

        //Se procede al DESENCRIPTADO
        for(int i=0;i<tamtext;i++)
        {
         p++;

          if(p>=tamclav)
          p=0;

         temp=textoAscii[i]-claveAscii[p];

         if (temp < 0)
         temp=temp+256;

         desencriptado=desencriptado + (char)temp;
        }
     return desencriptado;
    }

}
