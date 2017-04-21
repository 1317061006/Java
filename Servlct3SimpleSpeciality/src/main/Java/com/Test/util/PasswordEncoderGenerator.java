package com.Test.util;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PasswordEncoderGenerator {

	public static void main(String[] args) {
		StandardPasswordEncoder passwordEncoder;
		int i = 0;
        while (i < 10) {
			String password = "User";
			  passwordEncoder = new StandardPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}


	}
}