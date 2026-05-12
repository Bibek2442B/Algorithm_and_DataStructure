/**
 * Interface a ser usada no trabalho prático de AED.
 */
package mylists;

import java.util.Iterator;

/**
 * Interface para listas ordenadas sem repetições.
 * A ordem dos elementos é estabelecida pela relação de grandeza entre eles.
 * A lista não pode conter elementos iguais.
 * @author Paulo Gouveia
 * @param <E> tipo de elemento a colecionar.
 * @since 03/05/2025
 */
public interface SortedList<E extends Comparable<E>> extends Iterable<E>{ 
    
    /**
     * Devolve um iterador para os elementos da lista.
     * @return um iterador para os elementos da lista, referenciando, desde logo, o primeiro deles.
     */
    @Override
    Iterator<E> iterator();
    
    /**
     * Devolve a quantidade de elementos contidos na lista.
     * @return número total de elementos da lista.
     */
    int size();
    
    /**
     * Verifica se a lista não contém elementos.
     * @return true se a lista estiver vazia.
     */
    boolean isEmpty();
    
    /**
     * Verifica se a lista contém o elemento específico, ou mais precisamente,
     * se a lista atual contém um elemento considerado igual ao elemento específico.
     * @param e elemento cuja presença na lista é verificada.
     * @return true se for encontardo na lista um elemento igual ao elemento específico; false caso contrário.
     */
    boolean contains(E e);
     
    /**
     * Adiciona um novo elemento à "lista ordenada", mas só se esse elemento ainda não existir.
     * @param e elemento a adicionar à lista.
     * @return true se o elemento for inserido; false caso contrário (i.e. se for encontrado na lista um elemento igual ao novo elemento).
     */
    boolean add(E e);  
          
    /**
     * Devolve, sem remover, o elemento duma posição específica.
     * @param i posição do elemento a devolver.
     * @return o elemento, ou null caso não exista.
     */
    E get(int i);   
    
    /**
     * Remove o elemento duma posição específica, devolvendo-o.
     * @param i posição do elemento a remover.
     * @return o elemento removido, ou null caso não exista.
     */
    E remove(int i);
   
    /**
     * Devolve a posição dum elemento.
     * @param e elemento a procurar.
     * @return a posição do elemento, ou -1 caso o elemento não exista.
     */
    int indexOf(E e);
    
    /**
     * Adiciona à lista atual todos os elementos contidos numa outra lista.
     * @param other lista que tem os elementos a serem adicionados à lista atual.
     */
    void addAll(SortedList<E> other);
      
    /**
     * Remove da lista atual todos os elementos iguais aos elementos contidos na lista específica.
     * @param other lista com os elementos a serem removidos da lista atual.
     */
    void removeAll(SortedList<E> other);
 
    /**
     * Verifica se a lista atual contém todos os elementos de uma outra lista.
     * @param other lista a verificar se todos os seus elementos estão contidas na lista atual.
     * @return true se a lista atual contiver todos os elementos da lista específica.
     */
    boolean containsAll(SortedList<E> other);    
         
    /**
     * Remove todos os elementos da lista, deixando-a vazia.
     */
    void clear();
    
    /**
     * Devolve uma string com todos os elementos colecionados, ordenados pelo seu valor.
     * @return uma string com os elementos colecionados.
     */ 
    @Override
    String toString();
      
    /**
     * Devolve uma cópia superficial da lista atual (sem clonagem dos objetos colecionados).
     * @return uma lista com os mesmos elementos da lista atual.
     */ 
    SortedList<E> clone();   
    
    /**
     * Verifica se o objeto específico é uma lista igual à lista atual. Duas listas
     * são consideradas iguais se todos os seu elementos são iguais.
     * @param obj objeto a ser comparado com a lista atual.
     * @return true se os objetos forem considerados iguais.
     */ 
    @Override
    boolean equals(Object obj);
}
 