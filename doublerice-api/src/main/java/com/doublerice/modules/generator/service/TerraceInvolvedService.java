package com.doublerice.modules.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.doublerice.common.utils.PageUtils;
import com.doublerice.modules.generator.entity.TerraceInvolvedEntity;

import java.util.Map;

/**
 * 
 *
 * @author songzhuoqi
 * @email sunlightcs@gmail.com
 * @date 2019-04-26 12:37:07
 */
public interface TerraceInvolvedService extends IService<TerraceInvolvedEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

