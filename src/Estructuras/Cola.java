package edd.src.Estructuras;

public class Cola<T> extends PushPop<T>{

    /**
    * Metodo para agregar al inicio.
    * @param elemento - elemento a agregar
    */
    public void push(T elemento){
        if(elemento == null){
            throw new IllegalArgumentException();
        }
        Nodo aux = new Nodo(elemento);
        if(isEmpty()){
            cabeza = ultimo = aux;
            longi++;
            return;
        }
        aux.siguiente = cabeza;
        cabeza = aux;
        longi++;
    }

    /**
    * Metodo que clona la cola
    * @return Cola - La cola clonada
    */
    public Cola clone(){
        Cola<T> nueva = new Cola<T>();
        Cola<T> aux = new Cola<T>();
        if (this.isEmpty()) {
            return nueva;
        }
        Nodo aux2 = this.cabeza;
        while(aux2 != null){
            aux.push(aux2.elemento);
            aux2 = aux2.siguiente;
        }
        while (!aux.isEmpty()) {
            nueva.push(aux.pop());
        }
        return nueva; 
    }

    /**
    * Metodo que regresa la cadena de una cola, donde la direccion marca la forma en que sale de
    * la cola
    * Ejemplo: 1, 2, 3
    * @return String - la cadena que genera la cola
    */
    public String toString(){
        if (this.isEmpty()) {
            return "";
        }
        String regreso = this.cabeza.elemento.toString();
        Nodo n = this.cabeza;
        while (n.siguiente != null) {
            regreso += ", " + n.siguiente.elemento.toString();
            n = n.siguiente;
        }
        return regreso;
    }
}
