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
						"class Factorial{\n" +
						"\tpublic static void main(String[] a){\n" +
						"\tSystem.out.println(new Fac().ComputeFac(10));\n" +
						"\t}\n" +
						"}\n" +
						"class Fac {\n" +
						"\tpublic int ComputeFac(int num){\n" +
						"\t\tint num_aux;\n" +
						"\t\tif (num < 1){\n" +
						"\t\t\tnum_aux = 1;\n" +
						"\t\t}else{\n" +
						"\t\t\tnum_aux = num * (this.ComputeFac(num-1));\n" +
						"\t\t\treturn num_aux ;\n" +
						"\t\t}\n" +
						"\t}" +
						"}"
				)
		);
	}



}
