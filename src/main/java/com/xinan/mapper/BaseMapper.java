package com.xinan.mapper;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 11:28
 */
public interface BaseMapper<T> {

    /**
     * save one
     *
     * @param entity the entity
     */
    void save(T entity);

    /**
     * delete one
     *
     * @param id the id
     */
    void deleteById(Integer id);

    /**
     * update one
     *
     * @param entity the entity
     */
    void update(T entity);

    /**
     * find by id
     *
     * @param id the id
     * @return the entity
     */
    T findById(Integer id);

    /**
     * find by entity
     *
     * @param entity the entity
     * @return entity list
     */
    List<T> findByEntity(T entity);
}
