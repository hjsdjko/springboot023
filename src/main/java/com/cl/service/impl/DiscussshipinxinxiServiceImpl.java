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


import com.cl.dao.DiscussshipinxinxiDao;
import com.cl.entity.DiscussshipinxinxiEntity;
import com.cl.service.DiscussshipinxinxiService;
import com.cl.entity.view.DiscussshipinxinxiView;

@Service("discussshipinxinxiService")
public class DiscussshipinxinxiServiceImpl extends ServiceImpl<DiscussshipinxinxiDao, DiscussshipinxinxiEntity> implements DiscussshipinxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshipinxinxiEntity> page = this.selectPage(
                new Query<DiscussshipinxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussshipinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshipinxinxiEntity> wrapper) {
		  Page<DiscussshipinxinxiView> page =new Query<DiscussshipinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussshipinxinxiView> selectListView(Wrapper<DiscussshipinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshipinxinxiView selectView(Wrapper<DiscussshipinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
