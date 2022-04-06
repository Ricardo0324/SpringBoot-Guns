package com.stylefeng.guns.modular.peoplemanager.service;

import com.stylefeng.guns.modular.system.model.TblPeople;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyq
 * @since 2022-04-06
 */
public interface ITblPeopleService extends IService<TblPeople> {
    List<Map<String,Object>> selTest();
}
