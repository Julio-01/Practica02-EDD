package edd.src.Estructuras;
import java.util.Scanner;

public class Practica2 {
    
    /**
    * Metodo que resuelve el juego de torres de Hanoi.
    * @param cantidadDiscos - El numero de discos que tendremos al comienzo
    * @param origen - El primer pilar, donde se encuentran todos los discos.
    * @param auxiliar - El segundo pilar, el de apoyo
    * @param destino - El tercer pilar, donde tienen que quedar todos los discos.
    */
    public static void torresHanoi(int cantidadDiscos,Pila<Integer> origen, Pila<Integer> auxiliar, Pila<Integer> destino){
        int movimientos = (int) ((Math.pow(2, cantidadDiscos) - 1));
        int n = cantidadDiscos;
        // Agregamos el numero de discos al primer pilar
        while(n > 0){
            origen.push(n);
            n = n - 1;
        }
        // Iniciamos con el juego
        System.out.println("\n------------------ TORRES HANOI ------------------\n" +
                            "Comienzo del juego\n" + 
                            "Numero de discos: " + cantidadDiscos + " discos\n" + 
                            "Movimientos estimados: " + movimientos + "\n");
        imprimirPilares(origen, auxiliar, destino, 0);
        // Si (discos == 1) entonces solo hacemos 1 movimiento.
        if(cantidadDiscos == 1){
            destino.push(origen.pop());
            imprimirPilares(origen, auxiliar, destino, 1);
            return;
        }
        // Si (discos == 0) entonces no hacemos nada
        if(cantidadDiscos == 0){
            System.out.println("No podemos hacer nada con 0 discos.");
            return;
        }
        // Iteracion de movimientos de discos. Dependendiendo del # movimiento entramos a los casos,
        // imprimiremos cada que se muevan.
        for(int i = 1; i <= movimientos; i++){
            // Primer caso
            if(i % 3 == 1){
                if(cantidadDiscos % 2 == 0){
                    moverDisco(origen, auxiliar);
                }else{
                    moverDisco(origen, destino);
                }
                imprimirPilares(origen, auxiliar, destino, i);
            // Segundo caso
            }else if(i % 3 == 2){
                if(origen.size() % 2 == 0){
                    moverDisco(origen, auxiliar);
                }else{
                    moverDisco(origen, destino);
                }
                imprimirPilares(origen, auxiliar, destino, i);
            // Tercer caso
            }else if(i % 3 == 0){
                moverDisco(auxiliar, destino);
                imprimirPilares(origen, auxiliar, destino, i);
            } 
        }
    }

    /** 
    * Metodo para mover el disco
    * @param pila1 - la pila que modificaremos, sacamos o metemos el elemento
    * @param pila2 - la pila que modificaremos, sacamos o metemos el elemento
    */
    private static void moverDisco(Pila<Integer> pila1, Pila<Integer> pila2){
        if(pila1.isEmpty()){
            pila1.push(pila2.pop());
            return;
        }else if(pila2.isEmpty()){
            pila2.push(pila1.pop());
            return;
        }
        int aux = pila1.peek();
        int aux2 = pila2.peek();
        if(aux == 1){
            pila2.push(pila1.pop());
        }else if(aux2 == 1){
            pila1.push(pila2.pop());
        }else if(aux > aux2){
            pila1.push(pila2.pop());
        }else{
            pila2.push(pila1.pop());
        }
    }

    /**
    * Metodo para imprimir el estado actual del juego.
    * @param origen - La pila origen
    * @param auxiliar - La pila auxiliar
    * @param destino - La pila final
    * @param n - # de movimientos
    */
    private static void imprimirPilares(Pila<Integer> origen, Pila<Integer> auxiliar, Pila<Integer> destino, int n){
        System.out.println("----------------------------------------\n");
        System.out.println("Movimiento: " + n + "\n");
        System.out.println("pilarInicial < " + origen.toString() + "\n");
        System.out.println("pilarAuxiliar < " + auxiliar.toString() + "\n");
        System.out.println("pilarFinal < " + destino.toString() + "\n");
        System.out.println("----------------------------------------\n");
    }

    /**
     * Metodo para coinvertir de sistema decimal a sistema binario
     * @param N - hasta el numero para imprimir en binario
     */
    public static void binarioColas(int N){
        System.out.println("------------------ NUMEROS BINARIOS ------------------");
        System.out.println("Convertiremos en numero binario hasta el numero: " + N + "\n");
        // Si es N==0 entonces solo devolvemos y acabamos
        if (N==0){
            System.out.println("0");
            return;
        }
        // Creamos la cola donde almacenaremos los digitos 0 y 1
        Cola<String> cola = new Cola<String>();
        // Inicializamos con 1, ya que es el caso base
        cola.push("1");
        String cadena;
        String aux;
        // Iteracion de los numeros binarios
        for(int i = 0; i < N; i++){
            cadena = cola.pop();
            cola.push(cadena + "0");
            cola.push(cadena + "1");
            System.out.println("Numero " + (i + 1) + " --> " + cadena);
        }
    }

    /**
     * Metodo main, para inicializar el programa. Importamos Scanner para darle un toque bonito al
     * codigo con el usuario.
     * @param args
     */
    public static void main(String[] args) {
        // Escribe aqui tu codigo para probar los metodos anteriores. 
        // No olvides comentar tu codigo y escribir tu nombre en el readme.
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nIngrese el numero de discos para jugar torres de Hanoi: ");
        int n = entrada.nextInt();
        Pila<Integer> origen = new Pila<Integer>();
        Pila<Integer> auxiliar = new Pila<Integer>();
        Pila<Integer> destino = new Pila<Integer>();
        torresHanoi(n, origen, auxiliar, destino);

        System.out.println("\nIngrese el numero en sistema decimal para convertir a binario: ");
        int aux = entrada.nextInt();
        binarioColas(aux);
    }

}
