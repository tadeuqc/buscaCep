package com.tadeuqc.buscaCep.shell;

import org.springframework.shell.jline.PromptProvider;
import org.springframework.stereotype.Component;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;

@Component
public class CustomPromptProvider implements PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("buscaCEP:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}
