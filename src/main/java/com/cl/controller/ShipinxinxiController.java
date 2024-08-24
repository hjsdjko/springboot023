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

import com.cl.entity.ShipinxinxiEntity;
import com.cl.entity.view.ShipinxinxiView;

import com.cl.service.ShipinxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 视频信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
@RestController
@RequestMapping("/shipinxinxi")
public class ShipinxinxiController {
    @Autowired
    private ShipinxinxiService shipinxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShipinxinxiEntity shipinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shipinxinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();

		PageUtils page = shipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShipinxinxiEntity shipinxinxi, 
		HttpServletRequest request){
        EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();

		PageUtils page = shipinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shipinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShipinxinxiEntity shipinxinxi){
       	EntityWrapper<ShipinxinxiEntity> ew = new EntityWrapper<ShipinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shipinxinxi, "shipinxinxi")); 
        return R.ok().put("data", shipinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShipinxinxiEntity shipinxinxi){
        EntityWrapper< ShipinxinxiEntity> ew = new EntityWrapper< ShipinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shipinxinxi, "shipinxinxi")); 
		ShipinxinxiView shipinxinxiView =  shipinxinxiService.selectView(ew);
		return R.ok("查询视频信息成功").put("data", shipinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
		shipinxinxi = shipinxinxiService.selectView(new EntityWrapper<ShipinxinxiEntity>().eq("id", id));
        return R.ok().put("data", shipinxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
		shipinxinxi = shipinxinxiService.selectView(new EntityWrapper<ShipinxinxiEntity>().eq("id", id));
        return R.ok().put("data", shipinxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
        if(type.equals("1")) {
        	shipinxinxi.setThumbsupnum(shipinxinxi.getThumbsupnum()+1);
        } else {
        	shipinxinxi.setCrazilynum(shipinxinxi.getCrazilynum()+1);
        }
        shipinxinxiService.updateById(shipinxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShipinxinxiEntity shipinxinxi, HttpServletRequest request){
    	shipinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinxinxi);
        shipinxinxiService.insert(shipinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShipinxinxiEntity shipinxinxi, HttpServletRequest request){
    	shipinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shipinxinxi);
        shipinxinxiService.insert(shipinxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShipinxinxiEntity shipinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shipinxinxi);
        shipinxinxiService.updateById(shipinxinxi);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShipinxinxiEntity> list = new ArrayList<ShipinxinxiEntity>();
        for(Long id : ids) {
            ShipinxinxiEntity shipinxinxi = shipinxinxiService.selectById(id);
            shipinxinxi.setSfsh(sfsh);
            shipinxinxi.setShhf(shhf);
            list.add(shipinxinxi);
        }
        shipinxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shipinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
