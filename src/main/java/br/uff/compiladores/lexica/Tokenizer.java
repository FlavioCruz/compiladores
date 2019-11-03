package br.uff.compiladores.lexica;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

        System.out.println("Print whole string\n\n");
        new ArrayList<>(tokens
                .entrySet())
            .forEach(System.out::print);

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
