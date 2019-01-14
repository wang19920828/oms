package com.cpscs.omsadmin.dao;

import com.cpscs.omsadmin.domain.Tt;
import com.cpscs.omsadmin.domain.TtInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TtDao {
    Tt get(Long id);

    List<Tt> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(Tt tt);

    TtInfo getInfo (Long id);
}
