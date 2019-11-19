package com.first.hrm.dao;

import com.first.hrm.base.BaseMapper;
import com.first.hrm.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * NoticeMapper 数据访问类

 * @date 2019-10-16 15:38:33
 * @version 1.0
 */

@Mapper
public interface NoticeMapper extends BaseMapper {

    List<Notice> selectByTitle(Map<String,Object> map);

}