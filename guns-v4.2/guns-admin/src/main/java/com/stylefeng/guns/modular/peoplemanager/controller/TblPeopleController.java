package com.stylefeng.guns.modular.peoplemanager.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.util.ToolUtil;
import com.stylefeng.guns.modular.system.warpper.TestWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TblPeople;
import com.stylefeng.guns.modular.peoplemanager.service.ITblPeopleService;

import java.util.List;
import java.util.Map;

/**
 * 人员管理控制器
 *
 * @author fengshuonan
 * @Date 2022-04-06 00:31:53
 */
@Controller
@RequestMapping("/tblPeople")
public class TblPeopleController extends BaseController {

    private String PREFIX = "/peoplemanager/tblPeople/";

    @Autowired
    private ITblPeopleService tblPeopleService;

    /**
     * 跳转到人员管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "tblPeople.html";
    }

    /**
     * 跳转到添加人员管理
     */
    @RequestMapping("/tblPeople_add")
    public String tblPeopleAdd() {
        return PREFIX + "tblPeople_add.html";
    }

    /**
     * 跳转到修改人员管理
     */
    @RequestMapping("/tblPeople_update/{tblPeopleId}")
    public String tblPeopleUpdate(@PathVariable Integer tblPeopleId, Model model) {
        TblPeople tblPeople = tblPeopleService.selectById(tblPeopleId);
        model.addAttribute("item",tblPeople);
        LogObjectHolder.me().set(tblPeople);
        return PREFIX + "tblPeople_edit.html";
    }

    /**
     * 获取人员管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        List<Map<String,Object>> test=tblPeopleService.selTest();
        //判断condition是否有值
        if (ToolUtil.isEmpty(condition)){
            //如果没有值则查询全部
            return new TestWarpper(test).warp();
        }else {
            //如果有值，则认为是按业务名称进行模糊查询
            EntityWrapper<TblPeople> entityWrapper=new EntityWrapper<>();
            Wrapper<TblPeople> wrapper=entityWrapper.like("name",condition);
            return tblPeopleService.selectList(wrapper);
        }
    }

    /**
     * 新增人员管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TblPeople tblPeople) {
        tblPeopleService.insert(tblPeople);
        return SUCCESS_TIP;
    }

    /**
     * 删除人员管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer tblPeopleId) {
        tblPeopleService.deleteById(tblPeopleId);
        return SUCCESS_TIP;
    }

    /**
     * 修改人员管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TblPeople tblPeople) {
        tblPeopleService.updateById(tblPeople);
        return SUCCESS_TIP;
    }

    /**
     * 人员管理详情
     */
    @RequestMapping(value = "/detail/{tblPeopleId}")
    @ResponseBody
    public Object detail(@PathVariable("tblPeopleId") Integer tblPeopleId) {
        return tblPeopleService.selectById(tblPeopleId);
    }
}
