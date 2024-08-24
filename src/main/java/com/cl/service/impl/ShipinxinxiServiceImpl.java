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


import com.cl.dao.ShipinxinxiDao;
import com.cl.entity.ShipinxinxiEntity;
import com.cl.service.ShipinxinxiService;
import com.cl.entity.view.ShipinxinxiView;

@Service("shipinxinxiService")
public class ShipinxinxiServiceImpl extends ServiceImpl<ShipinxinxiDao, ShipinxinxiEntity> implements ShipinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShipinxinxiEntity> page = this.selectPage(
                new Query<ShipinxinxiEntity>(params).getPage(),
                new EntityWrapper<ShipinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShipinxinxiEntity> wrapper) {
		  Page<ShipinxinxiView> page =new Query<ShipinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShipinxinxiView> selectListView(Wrapper<ShipinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShipinxinxiView selectView(Wrapper<ShipinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
