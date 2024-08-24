package com.cl.dao;

import com.cl.entity.ShipinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinxinxiView;


/**
 * 视频信息
 * 
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
public interface ShipinxinxiDao extends BaseMapper<ShipinxinxiEntity> {
	
	List<ShipinxinxiView> selectListView(@Param("ew") Wrapper<ShipinxinxiEntity> wrapper);

	List<ShipinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinxinxiEntity> wrapper);
	
	ShipinxinxiView selectView(@Param("ew") Wrapper<ShipinxinxiEntity> wrapper);
	

}
