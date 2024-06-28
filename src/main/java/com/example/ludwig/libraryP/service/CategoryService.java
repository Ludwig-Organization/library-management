package com.example.ludwig.libraryP.service;

import com.example.ludwig.libraryP.dto.CateDTO;
import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.repo.CateRepo;

import java.util.*;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    void addCate(Category category);
    void updateCate(Category category);
    //Add list of Categories
    List<CateDTO> listCate();
}
@Service
class CateServiceImpl1 implements CategoryService{
	private final CateRepo cateRepo;
	@Autowired
	public CateServiceImpl1(CateRepo cateRepo) {
		this.cateRepo = cateRepo;
	}
	@Override
	@Transactional
	public void addCate(Category category) {
		cateRepo.save(category);
	}
	@Override
	@Transactional
	public void updateCate(Category category) {
		cateRepo.save(category);
	}
	@Override
	@Transactional
	public List<CateDTO> listCate() {
		List<Category> list =  cateRepo.findAll();
		List<CateDTO> dtoSet = new ArrayList<>();
		list.stream().forEach(s->dtoSet.add(CateServiceImpl1.ConvertCateToCateDTO(s)));
		return dtoSet;
	}
	private static CateDTO ConvertCateToCateDTO(Category category){
		CateDTO cateDTO = new CateDTO();
		List<Book> list = category.getBookList();
		Map<Integer, String> listDTO = new HashMap<>();
		list.stream().forEach(s -> listDTO.put(s.getId(), s.getName()));
		//Should use modelMapper to efficiently map object
		cateDTO.setId(category.getId());
		cateDTO.setCate_name(category.getCateName());
		cateDTO.setBookList(listDTO);
		return cateDTO;
	}
}

