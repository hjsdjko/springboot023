package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ShipinleixingDao;
import com.cl.entity.ShipinleixingEntity;
import com.cl.service.ShipinleixingService;
import com.cl.entity.view.ShipinleixingView;

@Service("shipinleixingService")
public class ShipinleixingServiceImpl extends ServiceImpl<ShipinleixingDao, ShipinleixingEntity> implements ShipinleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinleixingEntity> page = this.selectPage(
                new Query<ShipinleixingEntity>(params).getPage(),
                new EntityWrapper<ShipinleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinleixingEntity> wrapper) {
		  Page<ShipinleixingView> page =new Query<ShipinleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShipinleixingView> selectListView(Wrapper<ShipinleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinleixingView selectView(Wrapper<ShipinleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
