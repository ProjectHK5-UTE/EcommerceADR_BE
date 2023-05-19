package com.ecomerce.android.responsitory;

import com.ecomerce.android.dto.OrderDTO;
import com.ecomerce.android.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Option, Integer> {
	
	@Query(value = "SELECT product_ID FROM `options` WHERE options_ID =:optionId", nativeQuery = true)
	Integer findProductIdByOptionId(@Param("optionId") Integer optionId);
}
