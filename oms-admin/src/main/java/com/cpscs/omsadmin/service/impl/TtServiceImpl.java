package com.cpscs.omsadmin.service.impl;

import com.cpscs.common.utils.Query;
import com.cpscs.common.utils.Result;
import com.cpscs.omsadmin.client.BaseClientServise;
import com.cpscs.omsadmin.dao.TtDao;
import com.cpscs.omsadmin.domain.Tt;
import com.cpscs.omsadmin.domain.TtInfo;
import com.cpscs.omsadmin.service.TtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional(rollbackFor = Exception.class)
@Service
public class TtServiceImpl implements TtService {

    @Autowired
    TtDao TtMapper;
    @Autowired
    BaseClientServise baseClientServise;
    @Override
    public Tt get(Long id) {
        Tt tt = TtMapper.get(id);
        return tt;
    }

    @Override
    public List<Tt> list(Map<String, Object> map) {
        return TtMapper.list(map);
    }


    @Override
    public int count(Map<String, Object> map) {
        return TtMapper.count(map);
    }

    @Override
    public int save(Tt tt) {
        tt.setTtime(new Date());
        int count = TtMapper.save(tt);
        return count;
    }

    @Override
    public List<Object> getInfo(Map<String, Object> map) {
        List<Object> li =new ArrayList<>();
        String str = (String) map.get("id");
        Tt tt = TtMapper.get(Long.parseLong(str));
        TtInfo info = TtMapper.getInfo(Long.parseLong(str));
        Map<String, Object> qq=new HashMap<>();

        Result result = baseClientServise.count(qq);
        li.add("测试调用其他模块数据！");
        li.add(result);
        li.add(tt);
        li.add(info);

        return li;
    }
}
