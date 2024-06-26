package com.example.ludwig.libraryP.service;

import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.repo.CateRepo;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    void addCate(Category category);
    void updateCate(Category category);
    //Add list of Categories
    List<Category> listCate();
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
	public List<Category> listCate() {
		return cateRepo.findAll();
	}
}

