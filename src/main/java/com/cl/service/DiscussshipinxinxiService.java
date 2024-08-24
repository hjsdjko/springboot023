package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussshipinxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshipinxinxiView;


/**
 * 视频信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
public interface DiscussshipinxinxiService extends IService<DiscussshipinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshipinxinxiView> selectListView(Wrapper<DiscussshipinxinxiEntity> wrapper);
   	
   	DiscussshipinxinxiView selectView(@Param("ew") Wrapper<DiscussshipinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshipinxinxiEntity> wrapper);
   	

}

