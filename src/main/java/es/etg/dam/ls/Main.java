package es.etg.dam.ls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

    private static final String[] COMMAND1 = {"grep", "o"};
    private static final String[] COMMAND2 = {"ls"};

    public static void main(String[] args) throws Exception {
        String ls = ejecutarComando(COMMAND2, null);
        String salida = ejecutarComando(COMMAND1, ls);
        System.out.println(salida);
    }

    
    
}
