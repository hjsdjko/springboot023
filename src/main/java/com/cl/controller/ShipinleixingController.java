package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ShipinleixingEntity;
import com.cl.entity.view.ShipinleixingView;

import com.cl.service.ShipinleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 视频类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
@RestController
@RequestMapping("/shipinleixing")
public class ShipinleixingController {
    @Autowired
    private ShipinleixingService shipinleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinleixingEntity shipinleixing,
		HttpServletRequest request){
        EntityWrapper<ShipinleixingEntity> ew = new EntityWrapper<ShipinleixingEntity>();

		PageUtils page = shipinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinleixingEntity shipinleixing, 
		HttpServletRequest request){
        EntityWrapper<ShipinleixingEntity> ew = new EntityWrapper<ShipinleixingEntity>();

		PageUtils page = shipinleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinleixingEntity shipinleixing){
       	EntityWrapper<ShipinleixingEntity> ew = new EntityWrapper<ShipinleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinleixing, "shipinleixing")); 
        return R.ok().put("data", shipinleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinleixingEntity shipinleixing){
        EntityWrapper< ShipinleixingEntity> ew = new EntityWrapper< ShipinleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinleixing, "shipinleixing")); 
		ShipinleixingView shipinleixingView =  shipinleixingService.selectView(ew);
		return R.ok("查询视频类型成功").put("data", shipinleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinleixingEntity shipinleixing = shipinleixingService.selectById(id);
		shipinleixing = shipinleixingService.selectView(new EntityWrapper<ShipinleixingEntity>().eq("id", id));
        return R.ok().put("data", shipinleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinleixingEntity shipinleixing = shipinleixingService.selectById(id);
		shipinleixing = shipinleixingService.selectView(new EntityWrapper<ShipinleixingEntity>().eq("id", id));
        return R.ok().put("data", shipinleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinleixingEntity shipinleixing, HttpServletRequest request){
    	shipinleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinleixing);
        shipinleixingService.insert(shipinleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinleixingEntity shipinleixing, HttpServletRequest request){
    	shipinleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinleixing);
        shipinleixingService.insert(shipinleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinleixingEntity shipinleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinleixing);
        shipinleixingService.updateById(shipinleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
