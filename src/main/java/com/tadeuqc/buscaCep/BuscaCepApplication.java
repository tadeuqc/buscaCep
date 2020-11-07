package com.tadeuqc.buscaCep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class BuscaCepApplication {

	public static void main(String[] args) {
		String[] disabledCommands = {"--spring.shell.command.help.enabled=false"};
		String[] fullArgs = StringUtils.concatenateStringArrays(args, disabledCommands);
		SpringApplication.run(BuscaCepApplication.class, fullArgs);
	}

}
