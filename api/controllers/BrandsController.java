package com.kodlamaio.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.rentACar.business.abstracts.BrandService;
import com.kodlamaio.rentACar.business.requests.brands.CreateBrandRequest;
import com.kodlamaio.rentACar.business.requests.brands.DeleteBrandRequest;
import com.kodlamaio.rentACar.business.requests.brands.UpdateBrandRequest;
import com.kodlamaio.rentACar.business.responses.brands.ReadBrandResponse;
import com.kodlamaio.rentACar.core.utilities.results.DataResult;
import com.kodlamaio.rentACar.core.utilities.results.Result;
import com.kodlamaio.rentACar.entities.concretes.Brand;

@RestController // api formatındaysa ona göre hazırlar. annotation imzaya benzer.
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("/sayhello") // endpoint
	public String sayHello() {
		return "Hello spring";
	}

	@PostMapping("/add")

	public Result add(@RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}

	@PostMapping("/update")
	public Result update(@RequestBody UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody DeleteBrandRequest deleteBrandRequest) {
		return this.brandService.delete(deleteBrandRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<Brand>> getAll() {
		return brandService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Brand> getById(@RequestBody ReadBrandResponse readBrandResponse) {
		return brandService.getById(readBrandResponse);
	}
}
