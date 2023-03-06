package com.example.svr.controllers;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.svr.pojo.Poi;
import com.example.svr.service.IPicService;
import com.example.svr.service.IPoiService;
import com.example.svr.vo.PoiVo;
import com.example.svr.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
// Restful 风格
@Slf4j
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private IPoiService poiService;
    @Autowired
    private IPicService picService;



    //http协议中有4种方法，get post delete put/patch
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") int pageNum,
                       @RequestParam(defaultValue = "1") int pageSize) {
        log.info("log info list pageNum={}, pageSize:{}", pageNum, pageSize);

        Page<Poi> page = new Page<Poi>(pageNum, pageSize);
        IPage<Poi> pageResult = poiService.page(page);

        List<Poi> poiList = pageResult.getRecords();
        List voList = new ArrayList();
                //传原数据格式会奇怪，应该用vo的数据格式
        for (Poi poi: poiList) {
            PoiVo poiVo = new PoiVo();
//            名称必须相同
            BeanUtils.copyProperties(poi, poiVo);

            voList.add(poiVo);
        }

        pageResult.setRecords(voList);
        //return result
        return Result.success(pageResult);

    }
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable int id) {
        log.info("poi detail={}", id);

//        var tempPoiVo = new PoiVo();
//        tempPoiVo.name="Lee Sei";
//        tempPoiVo.description="Who is a great person";

        Poi poi = poiService.getById(id);


        return Result.success(poi);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Poi poi) {
        log.info("log info add {}", poi);
        boolean result = poiService.save(poi);
//        if (result) {
//            log.info("插入成功");
//        } else {
//            log.info("插入失败");
//        }


        // 让前端知道插入后的id
        PoiVo poiVo = new PoiVo();
        BeanUtils.copyProperties(poi, poiVo);


        //设计 return result
        return Result.success(poiVo);
    }

    @PutMapping("/edit/{id}")
    public Result edit(@RequestBody Poi poi, @PathVariable int id) {
        log.info("log info edit {}", poi);

        poi.setId(id);
        poiService.updateById(poi);

        PoiVo poiVo = new PoiVo();
        BeanUtils.copyProperties(poi, poiVo);
        return Result.success(poiVo);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        log.info("delete id={}", id);


        poiService.removeById(id);

        //设计 return result
        return Result.success();
    }

}
