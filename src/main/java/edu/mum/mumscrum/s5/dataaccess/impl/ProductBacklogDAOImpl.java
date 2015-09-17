package edu.mum.mumscrum.s5.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.ProductBacklogDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.ProductBacklog;

@Repository
public class ProductBacklogDAOImpl implements ProductBacklogDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductBacklogDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addProductBacklog(ProductBacklog pb) {
		entityManager.persist(pb);
		entityManager.flush();
		LOGGER.info("Employee saved successfully, Employee Details=" + pb);

	}

	@Override
	@Transactional
	public void updateProductBacklog(ProductBacklog pb) {
		LOGGER.info("Employee to be updated = " + pb);
		entityManager.merge(pb);
		LOGGER.info("Employee updated successfully, Employee Details=" + pb);

	}

	@Override
	@Transactional
	public ProductBacklog getProductBacklogById(int id) {
		ProductBacklog pb = (ProductBacklog) entityManager.find(ProductBacklog.class, new Integer(id));
		LOGGER.info("ProductBacklog loaded successfully, ProductBacklog details=" + pb);
		return pb;
	}

	@Override
	@Transactional
	public List<ProductBacklog> listProductBacklog() {
		List<ProductBacklog> productBacklogList = entityManager.createQuery("select o from ProductBacklog o", ProductBacklog.class)
				.getResultList();

		for (ProductBacklog e : productBacklogList) {
			LOGGER.info("ProductBacklog List::" + e);
		}
		return productBacklogList;
	}

}
