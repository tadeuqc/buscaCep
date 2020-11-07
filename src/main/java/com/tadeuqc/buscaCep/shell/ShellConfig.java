package com.tadeuqc.buscaCep.shell;

import com.tadeuqc.buscaCep.shell.ShellHandler;
import org.jline.terminal.Terminal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ShellConfig {
    @Bean
    public ShellHandler shellHandler(@Lazy Terminal terminal) {
        return new ShellHandler(terminal);
    }
}
