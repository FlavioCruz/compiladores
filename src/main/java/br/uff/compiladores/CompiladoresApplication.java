package br.uff.compiladores;

import br.uff.compiladores.lexica.Tokenizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Arrays;

@SpringBootApplication
public class CompiladoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompiladoresApplication.class, args);

//		Tokenizer tokenizer = new Tokenizer(new File("~/../../../../../code.txt"));
		Tokenizer tokenizer = new Tokenizer(
				Arrays.asList(
						"public class CompiladoresApplication {",
						"\n",
						"\tpublic static void main(String[] args) {",
						"\t}\n" +
								"\n" +
								"\n" +
								"\n" +
								"}"
				)
		);
	}



}
