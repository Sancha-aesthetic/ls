package es.etg.dam.ls;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

    private static final String[] COMMAND1 = {"ls"};
    private static final String[] COMMAND2 = {"grep", "o"};
    private static final String ERROR = "Error al ejecutar";

    public static void main(String[] args) throws Exception {
        String ls = ejecutarComando(COMMAND1, null);
        String salida = ejecutarComando(COMMAND2, ls);
        System.out.println(salida);
    }

    public static String ejecutarComando(String[] command, String entrada) throws Exception {
        Process p = Runtime.getRuntime().exec(command);

        if (entrada != null) {
            try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()))) {
                pw.print(entrada);
                pw.flush();
            }
        }

        StringBuilder salida = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                salida.append(linea).append("\n");
            }
        }

        int exitCode = p.waitFor();

        return (exitCode == 0) ? salida.toString() : ERROR + command;
    }
}
