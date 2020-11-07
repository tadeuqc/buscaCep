package com.tadeuqc.buscaCep.controller;

import com.tadeuqc.buscaCep.model.Address;
import com.tadeuqc.buscaCep.model.MapsResult;
import com.tadeuqc.buscaCep.service.GoogleMapsService;
import com.tadeuqc.buscaCep.shell.PromptColor;
import com.tadeuqc.buscaCep.shell.ShellHandler;
import org.jline.utils.InfoCmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BeanListTableModel;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ShellComponent
@ShellCommandGroup("Funcionalidades")
public class BuscaCepController {

    @Autowired
    GoogleMapsService mapsService;

    @Autowired
    ShellHandler shellHandler;

    @ShellMethod(value = "Buscar localização pelo CEP - exemplo: buscar-cep 01240-200")
    public void buscarCep(@ShellOption({"-C", "--cep"}) String cep) {
        shellHandler.print("Buscando Cep: " + cep);
        MapsResult retorno = mapsService.BuscaCep(cep);
        if(retorno.getStatus().equals("Cep Inválido")) {
            shellHandler.print("Cep inválido!");
        }
        else {
            shellHandler.print(String.format("Foram encontrados %s endereços: ", Arrays.stream(retorno.AddressesReturned()).count()),Arrays.stream(retorno.AddressesReturned()).count() > 0 ? PromptColor.GREEN : PromptColor.RED);
            for (Address address: retorno.AddressesReturned()) {
                shellHandler.print(address.toString(), PromptColor.BRIGHT);
            }
        }
    }
}

