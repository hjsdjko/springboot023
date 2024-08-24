package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShipinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinxinxiView;


/**
 * 视频信息
 *
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
public interface ShipinxinxiService extends IService<ShipinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinxinxiView> selectListView(Wrapper<ShipinxinxiEntity> wrapper);
   	
   	ShipinxinxiView selectView(@Param("ew") Wrapper<ShipinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinxinxiEntity> wrapper);
   	

}

