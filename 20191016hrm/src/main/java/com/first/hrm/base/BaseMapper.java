package com.first.hrm.base;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper {


    public <T> void insert(T entity);

    public <T> void delete(Serializable id);

    public <T> void update(T entity);

    public <T> List<T> select();

    public <T> T selectById(Serializable id);


}
