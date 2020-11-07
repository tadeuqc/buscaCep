package com.tadeuqc.buscaCep.shell;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

public class ShellHandler {

    private final Terminal terminal;

    public ShellHandler(Terminal terminal) {
        this.terminal = terminal;
    }

    public String getColored(String message, PromptColor color) {
        return (new AttributedStringBuilder()).append(message, AttributedStyle.DEFAULT.foreground(color.toAttributedStyle())).toAnsi();
    }

    public void print(String message) {
        print(message, null);
    }


    public void print(String message, PromptColor color) {
        String output = message;
        if (color != null) {
            output = getColored(message, color);
        }
        terminal.writer().println(output);
        terminal.flush();
    }
}
