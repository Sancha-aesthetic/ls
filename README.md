# EJERCICIO GREP LS

## PARTES DEL PROGRAMA

### CONSTANTES
```java 
    private static final String[] COMMAND1 = {"ls"};
    private static final String[] COMMAND2 = {"grep", "o"};
    private static final String ERROR = "Error al ejecutar";
```

### METODOS

- **Metodo MAIN**
    - En este primer metodo lo crearemos para la ejecucion de los comandos:
      - **ls**
      - **grep**
```java 
    String ls = ejecutarComando(COMMAND1, null);
    String salida = ejecutarComando(COMMAND2, ls);
    System.out.println(salida);
```

- **Metodo EjecutarComando**
  - Creamos el metodo y dentro de el el proceso para ejecutar le comando:
``` java
    public static String ejecutarComando(String[] command, String entrada) throws Exception {
    Process p = Runtime.getRuntime().exec(command);
```
  - **Lanzar el comando para ejecutar el proceso**

```java
        if (entrada != null) {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()))) {
            pw.print(entrada);
            pw.flush();
        }
    }
```

  - **Bucle**
    - Creamos el bucle para que recorra el proceso varias veces y saque los resultados
  ```java
        StringBuilder salida = new StringBuilder();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            salida.append(linea).append("\n");
        }
    }
  ```
  - **SALIDA DEL PROCESO**
    - Esperamos a que el proceso termine y nos de la salida con el resultadp.

  >SI OCURRE ALGUN ERROR NOS APARECERA UNA ADVERTENCIA SOBRE ELLO CON UN MENSAJE DE ERROR

```java 
    int exitCode = p.waitFor();
    return (exitCode == 0) ? salida.toString() : ERROR + command;
```
### Junit
- He tenido problemas para realizar las pruebas y lo he entregado sin ellas.

## Link GitHUB

- https://github.com/Sancha-aesthetic/ls