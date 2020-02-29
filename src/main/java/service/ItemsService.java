package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beans.ItemsDTO;
import entities.Items;
import exceptions.RecordNotFoundException;
import repositories.ItemsRepository;

@Service
public class ItemsService {
	@Autowired
	private ItemsRepository itemsRepository;
	
	public ItemsDTO convertEntityToBean(Items entity) {
		ItemsDTO bean = new ItemsDTO();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	
	public Items convertBeanToEntity(ItemsDTO bean) {
		Items entity = new Items();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
	//find and return all items on the menu, with attributes
	public List<ItemsDTO> findAllItems() {
		List<Items> items = itemsRepository.findAll();
		List<ItemsDTO> itemsDto = null;
		BeanUtils.copyProperties(items, itemsDto);
		return itemsDto;
	}
	
	//find items by id
	@SuppressWarnings("null")
	public ItemsDTO findItemById(int id) throws RecordNotFoundException {
		Optional<Items> item = itemsRepository.findById(id);
		Optional<ItemsDTO> itemsDto = null;
		BeanUtils.copyProperties(item, itemsDto);
		if(itemsDto.isPresent()) {
			return itemsDto.get();
		}
		else {
			throw new RecordNotFoundException("Item is not found!");
		}
	}
	
	//add new items
	@SuppressWarnings("null")
	public Items addOrUpdateItem(Items itemsEntity) {
		Optional<Items> items = itemsRepository.findById(itemsEntity.getItems());
		Optional<ItemsDTO> itemsDto = null;
		BeanUtils.copyProperties(items, itemsDto);
		ItemsDTO itemsBean = new ItemsDTO();
		BeanUtils.copyProperties(itemsEntity, itemsBean);
		if(itemsDto.isPresent()) {
			ItemsDTO updatedItems = itemsDto.get();
			updatedItems.setItemAttributes(itemsBean.getItemAttributes());
			updatedItems.setName(itemsBean.getName());
			Items updateItem = new Items();
			BeanUtils.copyProperties(updatedItems, updateItem);
			return itemsRepository.save(updateItem);
		}
		else 
			return itemsRepository.save(itemsEntity);
	}
	
	//remove item
	public void deleteItem(Items item) {
		itemsRepository.delete(item);
	}
	
	//find item by name
	@SuppressWarnings("null")
	public ItemsDTO findByItemName(String name) {
		Optional<Items> item = itemsRepository.findByName(name);
		Optional<ItemsDTO> itemDto = null;
		BeanUtils.copyProperties(item, itemDto);
		return itemDto.get();
	}
}
