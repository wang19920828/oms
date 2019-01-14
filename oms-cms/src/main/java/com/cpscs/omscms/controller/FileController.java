package com.cpscs.omscms.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cpscs.common.context.FilterContextHandler;
import com.cpscs.common.utils.FileUtils;
import com.cpscs.common.utils.PageUtils;
import com.cpscs.common.utils.Query;
import com.cpscs.common.utils.Result;
import com.cpscs.omscms.domain.FileDO;
import com.cpscs.omscms.service.FileService;

/**
 * 文件上传
 *
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-03-12 12:17:36
 */

@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${app.filePath}")
    String filePath;

    @Value("${app.pre}")
    String filePre;

    @Autowired
    private FileService fileService;

/*    @GetMapping("{id}")
    public R get(@PathVariable Long id) {
        FileDTO fileDTO = FileConvert.MAPPER.do2dto(fileService.get(id));
        return R.data(fileDTO);
    }*/

    @GetMapping("getToken")
    public Result getToken() {
        return Result.ok().put("token", FilterContextHandler.getToken()).put("url", "http://localhost:8002/api-cms/file/upload")
                .put("key", UUID.randomUUID().toString());
    }

    @PostMapping("upload")
    public Result upload(MultipartFile file, String key) {
        try {
            String resPath = FileUtils.saveFile(file.getBytes(), filePath, key);
            fileService.save(new FileDO() {{
                setCreateDate(new Date());
                setUrl("http://localhost:8004" + filePre + "/"+resPath);
                setType(1);
            }});
            return Result.ok().put("resPath", resPath);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error("文件上传失败");
        }
    }

    /**
     * 分页查询
     */
    @GetMapping
    public Result list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<FileDO> fileList = fileService.list(query);
//        List<FileDTO> fileDTOS = FileConvert.MAPPER.dos2dtos(fileList);
        int total = fileService.count(query);
//        PageUtils pageUtils = new PageUtils(fileDTOS, total);
        PageUtils pageUtils = new PageUtils(fileList, total);
        return Result.page(pageUtils);
    }

    /**
     * 保存
     */
    @PostMapping
    public Result save(FileDO file) {
        return Result.operate(fileService.save(file) > 0);
    }

    /**
     * 修改
     */
    @PutMapping
    public Result update(FileDO file) {
        return Result.operate(fileService.update(file) > 0);
    }

    /**
     * 删除
     */
    @DeleteMapping
    public Result remove(Long id) {
        return Result.operate(fileService.remove(id) > 0);
    }

    /**
     * 删除
     */
    @DeleteMapping("/batchRemove")
    public Result remove(@RequestParam("ids[]") Long[] ids) {
        return Result.operate(fileService.batchRemove(ids) > 0);
    }
}
