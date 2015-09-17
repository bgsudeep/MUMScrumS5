package edu.mum.mumscrum.s5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.ProductBacklogDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.service.ProductBacklogService;

@Service
public class ProductBacklogServiceImpl implements ProductBacklogService{
	
	@Autowired
	private ProductBacklogDAO productBacklogDAO;


	@Override
	public void addProductBacklog(ProductBacklog pb) {
		this.productBacklogDAO.addProductBacklog(pb);
		
	}

	@Override
	public void updateProductBacklog(ProductBacklog pb) {
		this.productBacklogDAO.updateProductBacklog(pb);
		
	}

	@Override
	public ProductBacklog getProductBacklogById(int id) {
		return this.productBacklogDAO.getProductBacklogById(id);
	}

	@Override
	public List<ProductBacklog> listProductBacklog() {
		return this.productBacklogDAO.listProductBacklog();
	}

	public ProductBacklogDAO getProductBacklogDAO() {
		return productBacklogDAO;
	}

	public void setProductBacklogDAO(ProductBacklogDAO productBacklogDAO) {
		this.productBacklogDAO = productBacklogDAO;
	}
	
	
	
	
	

}
