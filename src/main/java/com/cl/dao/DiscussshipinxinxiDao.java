package com.cl.dao;

import com.cl.entity.DiscussshipinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussshipinxinxiView;


/**
 * 视频信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-27 16:56:58
 */
public interface DiscussshipinxinxiDao extends BaseMapper<DiscussshipinxinxiEntity> {
	
	List<DiscussshipinxinxiView> selectListView(@Param("ew") Wrapper<DiscussshipinxinxiEntity> wrapper);

	List<DiscussshipinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshipinxinxiEntity> wrapper);
	
	DiscussshipinxinxiView selectView(@Param("ew") Wrapper<DiscussshipinxinxiEntity> wrapper);
	

}
