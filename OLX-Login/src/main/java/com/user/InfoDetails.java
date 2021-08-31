package com.user;

import java.util.Random;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoDetails implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		Random random = new Random();
		int totaluser = random.nextInt(1000);
		int activeLogin = random.nextInt(100);
		builder.withDetail("total registered users", totaluser);
		builder.withDetail("Total no of logins", activeLogin);
		
				
		
	}

}
