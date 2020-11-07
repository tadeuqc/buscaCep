package com.tadeuqc.buscaCep.shell.commands;

import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.InfoCmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.CommandRegistry;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.*;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.toCollection;

@ShellComponent
@ShellCommandGroup("Navegação")
public class ShellNavigationCommands {

    @Autowired
    private Terminal terminal;

    @Autowired
    private CommandRegistry commandRegistry;

    @ShellMethod(value = "Limpar a Tela")
    public void limpar() {
        terminal.puts(InfoCmp.Capability.clear_screen);
    }

    @ShellMethod(value = "Lista os comandos disponíveis")
    public void ajuda() {
        Map<String, MethodTarget> commandsByName = commandRegistry.listCommands();
        SortedMap<String, Map<String, MethodTarget>> commandsByGroupAndName = commandsByName.entrySet().stream()
                .collect(groupingBy(e -> e.getValue().getGroup(), TreeMap::new,
                        toMap(Map.Entry::getKey, Map.Entry::getValue)));

        AttributedStringBuilder result = new AttributedStringBuilder();
        result.append("COMANDOS DISPONÍVEIS\n\n", AttributedStyle.BOLD);

        commandsByGroupAndName.forEach((group, commandsInGroup) -> {
            if(!group.equals("Built-In Commands")) {
                result.append("".equals(group) ? "Default" : group, AttributedStyle.BOLD).append('\n');

                Map<MethodTarget, SortedSet<String>> commandNamesByMethod = commandsInGroup.entrySet().stream()
                        .collect(groupingBy(Map.Entry::getValue,
                                mapping(Map.Entry::getKey, toCollection(TreeSet::new))));

                commandNamesByMethod.forEach((key, value) -> result
                        .append(String.join(", ", value), AttributedStyle.BOLD)
                        .append(": ")
                        .append(key.getHelp())
                        .append('\n'));

                result.append('\n');
            }
        });

        terminal.writer().println(result);
    }

    @ShellMethod(value = "Sair do Aplicativo")
    public void sair() {
        throw new ExitRequest();
    }
}
