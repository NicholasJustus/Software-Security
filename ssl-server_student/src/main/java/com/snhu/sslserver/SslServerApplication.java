package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
@RestController
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

	// NEW HASH ENDPOINT FOR CHECKSUM
	@GetMapping("/hash")
	public String getHash() throws NoSuchAlgorithmException {
		String data = "Hello Artemis Financial";  // <- your unique data string
		String name = "Nicholas Justus";

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedHash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

		StringBuilder hexString = new StringBuilder();
		for (byte b : encodedHash) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return "Name: " + name + " | Data: " + data + " | Checksum (SHA-256): " + hexString.toString();
	}
}
