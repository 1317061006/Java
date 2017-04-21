package com.Test.Controller;

import com.Test.Dao.mybatis.CountyMapper;
import com.Test.entity.County;
import com.Test.entity.PageUtil;
import com.Test.service.CountyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by han on 2016/12/27.
 */
@RestController
@RequestMapping("/County")
public class CountyController {

    @Autowired
    private CountyService countyService;

    @Autowired
    private CountyMapper countyMapper;

    @RequestMapping(value = "/findById")
    @ResponseBody
    public County findById(@RequestParam Integer id) {
//        County county = new County();  采用万能mapper
//        county.setId(id);
//        return countyMapper.selectOne(county);
        System.out.println(countyService.selectById(id));
        return countyService.selectById(id);
    }


    @RequestMapping(value = "findAll")
    @ResponseBody
    public List<County> findAll(){
        return countyMapper.selectAll();
    }

    @RequestMapping(value = "PagingFindAll")
    public @ResponseBody  Map<String,Object>  PagingFindAll (@RequestBody PageUtil pageUtil){
        Map<String,Object> maps = new HashMap<>();
        PageHelper.startPage(pageUtil.getOffset() / pageUtil.getLimit() + 1, pageUtil.getLimit());
        List<County> lists= countyMapper.selectAll();
        PageInfo<County> info = new PageInfo<>(lists);
        maps.put("total",info.getTotal());
        maps.put("rows", lists);
        return maps;
    }



    @RequestMapping(value = "saveCounty")
    public ModelAndView saveCounty( ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("County/saveCounty");
        County county = new County();
        modelAndView.addObject(county);
        return  modelAndView;
    }


    @RequestMapping(value = "saveSuccess",method = RequestMethod.POST)
    public ModelAndView saveSuccess(County county) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Success");
        return modelAndView;
    }


}
