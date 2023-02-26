package com.ecomerce.android.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomerce.android.model.Brand;




@Repository
public interface BrandReponsitory extends JpaRepository<Brand, String>{
	
	
}
