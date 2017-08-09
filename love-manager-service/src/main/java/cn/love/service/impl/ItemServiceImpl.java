package cn.love.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.love.common.pojo.EasyUIDataGridResult;
import cn.love.mapper.TbItemMapper;
import cn.love.pojo.TbItem;
import cn.love.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		return itemMapper.selectByPrimaryKey(itemId);
	}

	public EasyUIDataGridResult getItemList(int page,int rows){
		PageHelper.startPage(page,rows);
		List<TbItem> list = itemMapper.selectByExample(null);
		
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		
		PageInfo<TbItem> info = new PageInfo<>(list);
		result.setTotal(info.getTotal());
		return result;
	}
}
