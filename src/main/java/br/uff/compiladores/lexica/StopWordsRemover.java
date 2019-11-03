package br.uff.compiladores.lexica;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsRemover {

    public Map<Integer, String> remove(List<String> code){
        return createMap(
                code
                    .stream()
                    .map(this::removeCommentsAndBlankSpaces)
                    .map(this::removeTabs)
                    .collect(Collectors.toList())
        );
    }

    private String removeTabs(String x){
        return x.replaceAll("\\t", "");
    }

    private String removeCommentsAndBlankSpaces(String x){
        System.out.println("Comments and blank spaces\n\n");
        System.out.println(x);
        System.out.println("\n\n");

        x = Stream.of(x).filter(y ->
                !(
                    y.equals(" ") ||
                    y.equals("\\n") ||
                    y.matches("//(.)*") ||
                    y.matches("/*(.)*\\*/")
                )
        ).collect(Collectors.joining());

        System.out.println("Printing list after\n\n");
        System.out.println(x);

        return x;
    }

    private Map<Integer, String> createMap(List<String> list){
        Map<Integer, String> map = new HashMap<>();

        for(int i = 1; i <= list.size(); i++){
            map.put(i, list.get(i - 1));
        }

        return map;
    }
}
