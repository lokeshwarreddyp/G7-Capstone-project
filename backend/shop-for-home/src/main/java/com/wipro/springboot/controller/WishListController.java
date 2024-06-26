package com.wipro.springboot.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import com.wipro.springboot.entity.Product;
import com.wipro.springboot.entity.User;
import com.wipro.springboot.entity.WishList;
import com.wipro.springboot.service.IProductService;
import com.wipro.springboot.service.IUserService;
import com.wipro.springboot.service.IWishListService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin
public class WishListController {

	@Autowired
	private IWishListService wishListService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IProductService productService;

	@GetMapping("/list")
	public Page<WishList> getWishList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size, Principal principal) {
		PageRequest request = PageRequest.of(page - 1, size);
		Page<WishList> wishListPage;
		User user = userService.findOne(principal.getName());
		wishListPage = wishListService.findByBuyerEmail(user.getId(), request);
		// Added a comment just
		return wishListPage;
	}
	public void print(){
		System.out.println("hi");
	}
	
	@PostMapping("/add/{productId}")
	public ResponseEntity<WishList> addWishList(@PathVariable String productId, Principal principal) {
		Product product = productService.findOne(productId);
		User user = userService.findOne(principal.getName());
		WishList wishList = new WishList(user, product);
		WishList wishListCreated = wishListService.createWishlist(wishList);
		return new ResponseEntity<WishList>(wishListCreated, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<Boolean> deletWishList(@PathVariable String productId, Principal principal) {
		User user = userService.findOne(principal.getName());
		Boolean wishListDeleted = wishListService.deleteWishlist(user, productId);
		return new ResponseEntity<Boolean>(wishListDeleted, HttpStatus.CREATED);
	}

}
