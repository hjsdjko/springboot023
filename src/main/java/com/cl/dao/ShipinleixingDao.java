package com.cl.dao;

import com.cl.entity.ShipinleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinleixingView;


/**
 * 视频类型
 * 
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
public interface ShipinleixingDao extends BaseMapper<ShipinleixingEntity> {
	
	List<ShipinleixingView> selectListView(@Param("ew") Wrapper<ShipinleixingEntity> wrapper);

	List<ShipinleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinleixingEntity> wrapper);
	
	ShipinleixingView selectView(@Param("ew") Wrapper<ShipinleixingEntity> wrapper);
	

}
