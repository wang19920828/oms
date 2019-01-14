package com.cpscs.omsadmin.controller;

import com.cpscs.common.annotation.Log;
import com.cpscs.common.utils.PageUtils;
import com.cpscs.common.utils.Query;
import com.cpscs.common.utils.Result;
import com.cpscs.omsadmin.domain.Tt;
import com.cpscs.omsadmin.service.TtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.GET;
import java.util.List;
import java.util.Map;

@RequestMapping("/MyTt")
@RestController
public class TtController extends BaseController {

    @Autowired
    TtService ttService;
    /**
     * id获取
     * @param id
     * @return
     */
    @Log("查询")
    @GetMapping("/getid")
    Result get(Long id ){
        Tt tt = ttService.get(id);
        return Result.ok().put("data",tt);
    }
    /**
     * 分页
     * @param params
     * @return
     */
    @Log("分页测试")
    @GetMapping("/fenye")
    Result listByPage(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Tt> userDTOS = ttService.list(query);
        int total = ttService.count(query);
        PageUtils pageUtil = new PageUtils(userDTOS, total);
        return Result.ok().put("page",pageUtil);
    }

    /**
     * 增加
     * @param tt
     * @return
     */
    @Log("新增测试")
    @PostMapping("addce")
    Result save(@RequestBody Tt tt) {
        return Result.operate(ttService.save(tt) > 0);
    }
    /**
     * 复合查询
     * @param params
     * @return
     */
    @Log("复合查询")
    @RequestMapping("getInfo")
    Result getInfo(@RequestParam Map<String, Object> params) {
        List<Object> li = ttService.getInfo(params);
        return Result.ok().put("data",li);
    }


}
