package com.kh.mapper;

import java.util.List;

import com.kh.domain.Item;

public interface ItemMapper {
	public void create(Item item) throws Exception;
	
	public Item read(Item item) throws Exception;
	
	public void update(Item item) throws Exception;
	
	public void delete(Item item) throws Exception;
	
	public List<Item> list() throws Exception;
	
	public Item getPicture(Item item) throws Exception;
}
