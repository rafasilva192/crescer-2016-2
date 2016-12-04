package br.com.cwi.crescer.aula4;

import java.util.List;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 * @param <ID>
 */
public interface IDao<T, ID> {

    void insert(T t);
    
    void delete(T t);
    
    T find(ID id);
    
    List<T> findAll();
}
