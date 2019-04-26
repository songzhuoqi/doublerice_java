package com.doublerice.modules.generator.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doublerice.common.utils.PageUtils;
import com.doublerice.common.utils.Query;

import com.doublerice.modules.generator.dao.TerraceInvolvedDao;
import com.doublerice.modules.generator.entity.TerraceInvolvedEntity;
import com.doublerice.modules.generator.service.TerraceInvolvedService;


@Service("terraceInvolvedService")
public class TerraceInvolvedServiceImpl extends ServiceImpl<TerraceInvolvedDao, TerraceInvolvedEntity> implements TerraceInvolvedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TerraceInvolvedEntity> page = this.page(
                new Query<TerraceInvolvedEntity>().getPage(params),
                new QueryWrapper<TerraceInvolvedEntity>()
        );

        return new PageUtils(page);
    }

}