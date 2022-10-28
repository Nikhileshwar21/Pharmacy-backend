package com.code.supplierinventoryservice;

import com.code.supplierinventoryservice.entity.Supplier;
import com.code.supplierinventoryservice.repository.SupplierRepository;
import com.code.supplierinventoryservice.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class SupplierInventoryServiceApplicationTests {

	@Autowired
	SupplierService supplierService;
	@MockBean
	SupplierRepository supplierRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void getSuppliersTest() {
		when(supplierRepository.findAll()).thenReturn(Stream.of(new Supplier("1","Will", "Will@test")).collect(Collectors.toList()));
		assertEquals(1, supplierService.getAllSuppliers().size());
	}

	@Test
	public void saveSupplierTest() {
		Supplier supplier= new Supplier("12","Max", "max@test");
		when(supplierRepository.insert(supplier)).thenReturn(supplier);
		assertEquals(supplier, supplierService.addSupplier(supplier));
	}
}
