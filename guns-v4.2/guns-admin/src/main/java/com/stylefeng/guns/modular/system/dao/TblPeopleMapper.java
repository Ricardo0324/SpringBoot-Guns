package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.modular.system.model.TblPeople;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wyq
 * @since 2022-04-06
 */
public interface TblPeopleMapper extends BaseMapper<TblPeople> {
    List<Map<String,Object>> selTest();
}
