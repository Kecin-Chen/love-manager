package cn.love.service;

import cn.love.common.pojo.EasyUIDataGridResult;
import cn.love.pojo.TbItem;

public interface ItemService {
	
	TbItem getItemById(long itemId);
	
	public EasyUIDataGridResult getItemList(int page,int rows);
}
