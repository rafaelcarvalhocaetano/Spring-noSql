package com.redis;

import java.util.Arrays;
import java.util.List;

import com.redis.model.Address;
import com.redis.model.Hotel;
import com.redis.model.Review;
import com.redis.repository.HotelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisApplication implements CommandLineRunner {


	// @Autowired
	// private HotelRepository hotelRepository;


	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Hotel ht = new Hotel(
				"Rafael", 
				130, 
				new Address("Caracas", "Brasil"),
				Arrays.asList(
					new Review("RRView", 8, true),
					new Review("VRVRR", 4, false)
				)
			);

			// hotelRepository.save(ht);

			Hotel ibis = new Hotel(
				"Rafael", 
				130, 
				new Address("Caracas", "Brasil"),
				Arrays.asList(
					new Review("RRView", 8, true),
					new Review("VRVRR", 4, false)
				)
			);

			// hotelRepository.save(ibis);


			Hotel sofitel = new Hotel(
				"Rafael", 
				130, 
				new Address("Caracas", "Brasil"),
				Arrays.asList(
					new Review("RRView", 8, true),
					new Review("VRVRR", 4, false)
				)
			);

			List<Hotel> li = Arrays.asList(ht, ibis, sofitel);
			// hotelRepository.saveAll(li);
	}

}
