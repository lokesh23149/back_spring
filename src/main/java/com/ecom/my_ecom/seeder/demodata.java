package com.ecom.my_ecom.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.my_ecom.entities.products;
import com.ecom.my_ecom.productrepository.productrepo;

//this is d dummy data for testing the application
@Component
public class demodata implements CommandLineRunner {

	@Autowired
	private productrepo repo;

	@Override
	public void run(String... args) throws Exception {

		if (repo.count() == 0) {
			List<products> demoproduct = List.of(
					new products(null, "Apple iPhone 13", 588.0, "Smartphone with AI11 chip", "Smartphone", 4.8,
							"Amazon", 5, List.of("/imagesproducts/1.jpg")),
					new products(null, "Vivo F11", 799.0, "Smartphone with A16 chip and enhanced camera", "Smartphone",
							4.8, "Amazon", 5, List.of("/imagesproducts/2.jpg")),
					new products(null, "Samsung Galaxy S26 Ultra", 999.0, "Flagship Android phone with 200MP camera",
							"Smartphone", 4.6, "Flipkart", 12, List.of("/imagesproducts/3.jpg")),
					new products(null, "Sony WH-1000XM7", 349.0, "Noise-cancelling wireless headphones", "Headphones",
							4.9, "Croma", 20, List.of("/imagesproducts/4.jpg")),
					new products(null, "Dell XPS 15 2025", 1599.0, "Premium laptop with OLED display", "Laptop", 4.7,
							"Dell Store", 8, List.of("/imagesproducts/5.jpg"))
//					new products(null, "Nike Air Zoom Pegasus 41", 129.0, "Lightweight premium running shoes", "Shoes",
//							4.5, "Nike", 15),
//					new products(null, "Apple iPhone 15", 899.0, "Smartphone with A17 Bionic chip", "Smartphone", 4.9,
//							"Amazon", 10),
//					new products(null, "Samsung Galaxy A75", 499.0, "Mid-range Android phone with AMOLED display",
//							"Smartphone", 4.4, "Flipkart", 25),
//					new products(null, "OnePlus Nord 5", 399.0, "5G smartphone with Snapdragon processor", "Smartphone",
//							4.3, "Amazon", 18),
//					new products(null, "MacBook Air M5", 1299.0, "Ultra-thin laptop with M5 chip", "Laptop", 4.8,
//							"Apple Store", 6),
//					new products(null, "HP Omen 17", 1699.0, "Gaming laptop with RTX 5090 GPU", "Laptop", 4.7,
//							"HP Store", 4),
//					new products(null, "Sony Alpha A5800", 1399.0, "Mirrorless camera with 8K recording", "Camera", 4.9,
//							"Croma", 7),
//					new products(null, "Boat Airdopes 800", 49.0, "Wireless earbuds with ANC", "Earbuds", 4.3, "Amazon",
//							30),
//					new products(null, "JBL Charge 7", 199.0, "Portable Bluetooth speaker with bass boost", "Speaker",
//							4.6, "Flipkart", 22),
//					new products(null, "Dell Inspiron 16 Pro", 899.0, "Productivity laptop with OLED display", "Laptop",
//							4.5, "Dell Store", 9),
//					new products(null, "Asus ROG Phone 9", 1099.0, "Gaming smartphone with vapor cooling", "Smartphone",
//							4.8, "Asus Store", 6),
//					new products(null, "Canon EOS R12", 2499.0, "Professional mirrorless camera with 45MP sensor",
//							"Camera", 4.9, "Canon Store", 3),
//					new products(null, "Lenovo Legion 9", 2199.0, "Gaming laptop with liquid cooling", "Laptop", 4.7,
//							"Lenovo Store", 5),
//					new products(null, "Xiaomi Mi Band 9", 59.0, "Fitness band with AMOLED display", "Wearable", 4.4,
//							"Amazon", 35),
//					new products(null, "Samsung Watch 7", 299.0, "Premium smartwatch with health tracking", "Wearable",
//							4.6, "Samsung Store", 15),
//					new products(null, "Apple AirPods Pro 3", 299.0, "ANC wireless earbuds with H3 chip", "Earbuds",
//							4.8, "Apple Store", 12),
//					new products(null, "Puma Velocity Nitro 4", 119.0, "Premium cushioned running shoes", "Shoes", 4.6,
//							"Puma", 14),
//					new products(null, "LG OLED C4 55-inch", 1599.0, "4K OLED smart TV", "Television", 4.9,
//							"Reliance Digital", 8),
//					new products(null, "Samsung QLED Q90 65-inch", 1899.0, "High-end QLED TV with HDR+", "Television",
//							4.8, "Flipkart", 6),
//					new products(null, "Logitech MX Master 5", 149.0, "Ergonomic wireless mouse", "Computer Accessory",
//							4.8, "Amazon", 28),
//					new products(null, "Razer Huntsman V5", 199.0, "Optical mechanical gaming keyboard",
//							"Computer Accessory", 4.7, "Razer Store", 11),
//					new products(null, "Redgear Pro Wireless Controller", 39.0, "Budget-friendly gaming controller",
//							"Gaming Accessory", 4.3, "Amazon", 40),
//					new products(null, "Fitbit Charge 8", 159.0, "Fitness tracker with advanced sensors", "Wearable",
//							4.6, "Amazon", 14),
//					new products(null, "Samsung T9 SSD 1TB", 129.0, "Portable SSD with ultra-fast speed", "Storage",
//							4.8, "Samsung Store", 18),
//					new products(null, "Seagate SkyHawk 4TB", 149.0, "High-performance surveillance HDD", "Storage",
//							4.6, "Croma", 10)

			);

			repo.saveAll(demoproduct);
			System.out.println("product excesion is success");

		} else {
			System.out.println("product already exists ");
		}

	}
}
