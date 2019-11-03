package br.uff.compiladores.lexica;

import org.springframework.context.annotation.PropertySource;

import java.util.List;

@PropertySource("../../../../../resources/application.properties")
public class ReservedWordsConfig {

    public static List<String> reservedWords;
}
