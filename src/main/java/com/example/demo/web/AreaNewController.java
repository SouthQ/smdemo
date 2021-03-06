package com.example.demo.web;

import com.example.demo.bean.Area;
import com.example.demo.bean.vo.AreaVo;
import com.example.demo.entity.DataReturn;
import com.example.demo.service.AreaService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class AreaNewController {
    @Autowired
    private AreaService areaService;

    private static Logger logger = LoggerFactory.getLogger(AreaNewController.class);

    /* 最初的返回数据结构
    // http://localhost:8082/demo/school/listarea
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String, Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }*/

    // http://localhost:8082/demo/department/listarea
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    public DataReturn<Area> listArea(){
        return ResultUtil.returnSuccess(areaService.getAreaList());
    }

    @RequestMapping(value = "/queryAreaByPage",method = RequestMethod.POST)
    public DataReturn<Area> queryAreaByPage(@RequestBody AreaVo areaVo){
        return ResultUtil.returnSuccess(areaService.queryAreaByPage(areaVo));
    }

    // http://localhost:8082/demo/department/getareabyid?areaId=1
    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    public DataReturn<Area> getAreaById(Integer areaId){
        return ResultUtil.returnSuccess(areaService.getAreaById(areaId));
    }

    // http://localhost:8082/demo/department/addarea {"areaName": "南区","priority": 2}
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    public DataReturn addArea(@RequestBody Area area){
        areaService.addArea(area);
        return ResultUtil.returnSuccess();
    }

    // http://localhost:8082/demo/department/modifyarea {"areaId": 4,"areaName": "南区","priority": 3}
    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    public DataReturn modifyArea(@RequestBody Area area){
        areaService.modifyArea(area);
        return ResultUtil.returnSuccess();
    }

    // http://localhost:8082/demo/department/removearea?areaId=4
    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    public DataReturn removeArea(Integer areaId){
        areaService.deleteArea(areaId);
        return ResultUtil.returnSuccess();
    }

    // 日志测试
    @RequestMapping(value = "/testlog",method = RequestMethod.GET)
    public DataReturn testLog(){
        logger.debug("======debug");
        logger.info("======info");
        logger.warn("======warn");
        logger.error("======error");
        return ResultUtil.returnSuccess();
    }
}
