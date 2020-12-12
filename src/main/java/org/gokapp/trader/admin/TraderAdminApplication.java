package org.gokapp.trader.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "org.gokapp.trader.common", "org.gokapp.trader.admin" })
public class TraderAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraderAdminApplication.class, args);
	}

}
