package br.uff.compiladores.lexica;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter @Setter
public class Tokenizer {

    private List<String> initialCode;
    private Map<Integer, String> tokens;
    private StopWordsRemover stopWordsRemover;

    public Tokenizer(File initialCode){
        this.stopWordsRemover = new StopWordsRemover();
        try {
            this.initialCode = readFile(initialCode);
            stopWordsRemover.remove(this.initialCode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Tokenizer(List<String> initialCode){
        this.stopWordsRemover = new StopWordsRemover();
        tokens = stopWordsRemover.remove(initialCode);
        System.out.println("Print Tokens\n\n\n");
        tokens
            .entrySet()
            .stream()
            .map(Map.Entry::getValue)
            .forEach(System.out::println);

        System.out.println("Print whole string");
        tokens.entrySet().stream().collect(Collectors.toList()).forEach(System.out::print);

    }

    private List<String> readFile(File file) throws FileNotFoundException {
        Scanner s = null;
        try {
            s = new Scanner(file);
            List<String> list = new ArrayList<String>();
            while (s.hasNext()){
                list.add(s.next());
            }
            s.close();
            return list;
        } catch (FileNotFoundException e) {
            throw e;
        }
    }
}
