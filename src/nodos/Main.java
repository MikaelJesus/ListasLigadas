/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author Alumnos
 */
public class Main {

    private static Nodo p = null;

    public static void main(String[] args) {
        ListaLigada<String> lista = new ListaLigada<>();
        ListaLigada<String> lista02 = new ListaLigada<>();
        lista.insertarInicio("1");
        lista.insertarInicio("2");
        lista.insertarInicio("3");
        lista.insertarInicio("4");
        lista.mostrarLista();
        lista.invertirLista().mostrarLista();
        System.out.println(lista.buscar("2"));
    }
}
