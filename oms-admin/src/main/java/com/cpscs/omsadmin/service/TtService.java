package com.cpscs.omsadmin.service;

import com.cpscs.omsadmin.domain.Tt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TtService {
    Tt get(Long id);

    List<Tt> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(Tt tt);

    List<Object> getInfo(Map<String, Object> map);
}
