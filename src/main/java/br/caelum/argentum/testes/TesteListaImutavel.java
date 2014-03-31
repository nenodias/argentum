/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nenodias
 */
public class TesteListaImutavel {
    public static void main(String[] args) {
        List<Integer>list = Arrays.asList(1,2,4,5,623,3,432);
        List<Integer>lista = Arrays.asList(1);
        Collections.unmodifiableList(list);
//        Desse jeito você faz a lista se tornar imutavel, ou seja ela não poderá ser modificada
//        list.add(3);
//        list.clear();
        
//        Note que aqui a variável list recebe uma nova referência de uma lista
//        Porém isso em um atributo privado seria impossível
        list = lista;
        System.out.println(list.size());
    }
}
