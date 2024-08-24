package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShipinleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinleixingView;


/**
 * 视频类型
 *
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
public interface ShipinleixingService extends IService<ShipinleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinleixingView> selectListView(Wrapper<ShipinleixingEntity> wrapper);
   	
   	ShipinleixingView selectView(@Param("ew") Wrapper<ShipinleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinleixingEntity> wrapper);
   	

}

