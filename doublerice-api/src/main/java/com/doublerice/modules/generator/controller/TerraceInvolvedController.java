package com.doublerice.modules.generator.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doublerice.modules.generator.entity.TerraceInvolvedEntity;
import com.doublerice.modules.generator.service.TerraceInvolvedService;
import com.doublerice.common.utils.PageUtils;
import com.doublerice.common.utils.R;



/**
 * 
 *
 * @author songzhuoqi
 * @email sunlightcs@gmail.com
 * @date 2019-04-26 12:37:07
 */
@RestController
@RequestMapping("generator/terraceinvolved")
public class TerraceInvolvedController {
    @Autowired
    private TerraceInvolvedService terraceInvolvedService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("generator:terraceinvolved:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = terraceInvolvedService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("generator:terraceinvolved:info")
    public R info(@PathVariable("id") String id){
		TerraceInvolvedEntity terraceInvolved = terraceInvolvedService.getById(id);

        return R.ok().put("terraceInvolved", terraceInvolved);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("generator:terraceinvolved:save")
    public R save(@RequestBody TerraceInvolvedEntity terraceInvolved){
		terraceInvolvedService.save(terraceInvolved);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("generator:terraceinvolved:update")
    public R update(@RequestBody TerraceInvolvedEntity terraceInvolved){
		terraceInvolvedService.updateById(terraceInvolved);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("generator:terraceinvolved:delete")
    public R delete(@RequestBody String[] ids){
		terraceInvolvedService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
