package com.stylefeng.guns.modular.peoplemanager.service.impl;

import com.stylefeng.guns.modular.system.model.TblPeople;
import com.stylefeng.guns.modular.system.dao.TblPeopleMapper;
import com.stylefeng.guns.modular.peoplemanager.service.ITblPeopleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wyq
 * @since 2022-04-06
 */
@Service
public class TblPeopleServiceImpl extends ServiceImpl<TblPeopleMapper, TblPeople> implements ITblPeopleService {

    @Override
    public List<Map<String, Object>> selTest() {
        return this.baseMapper.selTest();
    }
}
