package com.ecom.my_ecom.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ecom.my_ecom.entities.products;
import com.ecom.my_ecom.productrepository.productrepo;

@Component
public class demodata implements CommandLineRunner {

    @Autowired
    private productrepo repo;

    @Override
    public void run(String... args) throws Exception {

        // Insert only if table is empty
        if (repo.count() == 0) {

            List<products> demoProducts = List.of(

                // ===================== SUPPLEMENTS =====================
                new products(null, "Whey Protein 2kg", 59.0,
                        "High-quality whey protein for muscle growth and recovery", "Supplements", 4.7,
                        "MuscleBlaze", 40, List.of("https://images.pexels.com/photos/4498546/pexels-photo-4498546.jpeg")),

                new products(null, "Creatine Monohydrate 300g", 24.0,
                        "Improves strength, power, and workout performance", "Supplements", 4.8,
                        "Optimum Nutrition", 35, List.of("https://images.pexels.com/photos/4498532/pexels-photo-4498532.jpeg")),

                new products(null, "Pre-Workout Energy Booster", 29.0,
                        "Boosts energy, focus, and endurance during workouts", "Supplements", 4.6, "GNC", 30,
                        List.of("https://images.pexels.com/photos/4052535/pexels-photo-4052535.jpeg")),

                new products(null, "BCAA Amino Acids", 22.0,
                        "Supports muscle recovery and reduces fatigue", "Supplements", 4.5,
                        "MyProtein", 28, List.of("https://images.pexels.com/photos/3935524/pexels-photo-3935524.jpeg")),

                // ===================== CLOTHING =====================
                new products(null, "Men Gym T-Shirt", 19.0,
                        "Breathable and sweat-resistant gym t-shirt", "Clothing", 4.6,
                        "Nike", 45, List.of("https://images.pexels.com/photos/8428117/pexels-photo-8428117.jpeg")),

                new products(null, "Women Workout Leggings", 25.0,
                        "Stretchable leggings for yoga and gym workouts", "Clothing", 4.7,
                        "Adidas", 38, List.of("https://images.pexels.com/photos/8411304/pexels-photo-8411304.jpeg")),

                new products(null, "Men Training Shorts", 17.0,
                        "Lightweight shorts for intense training sessions", "Clothing", 4.5,
                        "Puma", 42, List.of("https://images.pexels.com/photos/10026422/pexels-photo-10026422.jpeg")),

                // ===================== EQUIPMENT =====================
                new products(null, "Adjustable Dumbbells Set", 99.0,
                        "Adjustable dumbbells for effective home workouts", "Equipment", 4.8,
                        "Decathlon", 15, List.of("https://images.pexels.com/photos/6695777/pexels-photo-6695777.jpeg")),

                new products(null, "Olympic Barbell Rod", 129.0,
                        "Heavy-duty barbell for strength training", "Equipment", 4.7,
                        "Strauss", 10, List.of("https://images.pexels.com/photos/416405/pexels-photo-416405.jpeg")),

                // ===================== ACCESSORIES =====================
                new products(null, "Gym Gloves", 14.0,
                        "Anti-slip gloves for better grip during workouts", "Accessories", 4.6,
                        "Boldfit", 60, List.of("https://images.pexels.com/photos/38338/pexels-photo-38338.jpeg")),

                new products(null, "Gym Shaker Bottle", 9.0,
                        "Leak-proof shaker bottle for protein shakes", "Accessories", 4.7,
                        "MuscleXP", 80, List.of("https://images.pexels.com/photos/4052459/pexels-photo-4052459.jpeg")),

                new products(null, "Gym Backpack", 34.0,
                        "Spacious backpack for gym and travel use", "Accessories", 4.6,
                        "Puma", 18, List.of("https://images.pexels.com/photos/296883/pexels-photo-296883.jpeg"))
            );

            repo.saveAll(demoProducts);
            System.out.println("✅ Demo products inserted successfully");

        } else {
            System.out.println("ℹ️ Products already exist. Skipping seeding.");
        }
    }
}
