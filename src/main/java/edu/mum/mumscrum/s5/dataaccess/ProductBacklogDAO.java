package edu.mum.mumscrum.s5.dataaccess;

import java.util.List;

import edu.mum.mumscrum.s5.entity.ProductBacklog;

public interface ProductBacklogDAO {
	public void addProductBacklog(ProductBacklog pb);
	public void updateProductBacklog(ProductBacklog pb);
	public ProductBacklog getProductBacklogById(int id);
	public List<ProductBacklog> listProductBacklog();
}
