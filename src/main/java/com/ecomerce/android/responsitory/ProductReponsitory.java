package com.ecomerce.android.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import com.ecomerce.android.model.Product;


@Repository
public interface ProductReponsitory extends JpaRepository<Product, Integer>{
	
	
}
