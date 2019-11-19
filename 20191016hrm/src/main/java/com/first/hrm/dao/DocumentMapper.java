package com.first.hrm.dao;

import com.first.hrm.base.BaseMapper;
import com.first.hrm.bean.Document;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DocumentMapper 数据访问类

 * @date 2019-10-16 15:38:33
 * @version 1.0
 */

@Mapper
public interface DocumentMapper extends BaseMapper {

    List<Document> selectByTitle(Map<String,Object> map);

}