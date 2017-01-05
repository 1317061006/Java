package com.Test.Controller;

import com.Test.Dao.mybatis.CountyMapper;
import com.Test.entity.County;
import com.Test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by han on 2016/12/27.
 */
@RestController
@RequestMapping("/County")
public class CountyController {

      @Autowired
     CountyMapper countyMapper;

    @RequestMapping(value = "/findById")
    @ResponseBody
    public County findById(@RequestParam Integer id) {
//        County county = new County();  采用万能mapper
//        county.setId(id);
//        return countyMapper.selectOne(county);
        return countyMapper.selectById(1);
    }


    @RequestMapping(value = "findAll")
    @ResponseBody
    public List<County> findAll(){
        return countyMapper.selectAll();
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
