package br.uff.compiladores.lexica;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    /**
     * Retira todos os espaços
     * @param filepath
     * @return
     */
    private String lerArquivo(String filepath){
        try {
            return Files.lines(Path.of(filepath))
                    .filter(x -> !x.contains("//"))
                    .collect(Collectors.joining());
//            return Stream.of(filepath.split(" ")).collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " ";
    }

    public void analiseLexica(String filepath) {
        String code = lerArquivo(filepath);
        code = removeEspacosEmBranco(code);
        code = removerBlocoComentario(code);
        while (code != null) {
//            geradorTokens(code);
            //vetorString = strtok(null, " ");
        }
    }

    private String removeEspacosEmBranco(String code){
        return code.replaceAll("[\n, \t, \r, \f]", "");
    }

    /**
     * -------------------------------------------------------------------------------------------------------------------
     * Valida strings
     * -------------------------------------------------------------------------------------------------------------------
     */
//    private int stringsIdentificadas(String id) {
//        int i = 0;
//        for (i = 0; i < indiceVetorStringsIdentificadas; i++) {
//            if (strcmp(vetorStringsIdentificadas[i], id) == 0) {
//                i = i + 1;
//                return i;
//            }
//        }
//        strcpy(vetorStringsIdentificadas[indiceVetorStringsIdentificadas], id);
//        i = indiceVetorStringsIdentificadas;
//        indiceVetorStringsIdentificadas++;
//        i = i + 1;
//        return i;
//    }

    /**
     * -------------------------------------------------------------------------------------------------------------------
     * Funcao que remove as linhas de comentario do codigo
     * -------------------------------------------------------------------------------------------------------------------
     */
    private String removerBlocoComentario(String code) {
        Boolean ignorar = false;
        StringBuilder codeWithoutComments = new StringBuilder();
        List<String> chars = Arrays.asList(code.split("(?!^)"));
        int indexInicial = 0;
        int indexFinal = 1;
        for (int i = 1; i < code.length(); i++) {
            if (chars.get(i).equals("/") && chars.get(i + 1).equals("*")) {
                ignorar = true;
                continue;
            } if (chars.get(i).equals("*") && chars.get(i + 1).equals("/") && ignorar) {
                ignorar = false;
            } else if (!ignorar) {
                codeWithoutComments.append(code.substring(indexInicial, indexFinal + 1));
                indexInicial = indexFinal + 1;
            } if(ignorar){
                indexInicial++;
            }
            indexFinal++;
            System.out.println(i + ": " + indexFinal);
        }
        System.out.println("remove linha de comentario\n");
        System.out.println(codeWithoutComments.toString());
        System.out.println("\n");
        return codeWithoutComments.toString();
    }

    private String removeComentarioEmLinha(String code){
        Boolean ignorar = false;
        StringBuilder codeWithoutComments = new StringBuilder();
        List<String> chars = Arrays.asList(code.split("(?!^)"));
        int indexInicial = 0;
        int indexFinal = 1;
        for (int i = 1; i < code.length(); i++) {

            if (chars.get(i).equals("/") && chars.get(i + 1).equals("/")) {
                ignorar = true;
                continue;
            }
            if (chars.get(i).equals("\n") && ignorar) {
                ignorar = false;
                continue;
            }
            if (!ignorar) {
                codeWithoutComments.append(code.substring(indexInicial, indexFinal + 1));
                indexInicial = indexFinal + 1;
            }
            if(ignorar){
                indexInicial++;
            }
            indexFinal++;
        }
        System.out.println("remove linha de comentario\n");
        System.out.println(codeWithoutComments.toString());
        System.out.println("\n");
        return codeWithoutComments.toString();
    }


    /**n
     * -------------------------------------------------------------------------------------------------------------------
     * Analisa a linha e determina o tipo de token a ser gravado no arquivo de saida
     * -------------------------------------------------------------------------------------------------------------------
     */
//    void geradorTokens(String code) {
//        // PALAVRAS RESERVADAS
//        if (strcmp("if", tk) == 0) {
//            escreverArquivo("<IF>");
//            return;
//        } else if (strcmp("while", tk) == 0) {
//            escreverArquivo("<WHILE>");
//            return;
//        } else if (strcmp("this", tk) == 0) {
//            escreverArquivo("<THIS>");
//            return;
//        } else if (strcmp("new", tk) == 0) {
//            escreverArquivo("<NEW>");
//            return;
//        } else if (strcmp("else", tk) == 0) {
//            escreverArquivo("<ELSE>");
//            return;
//        } else if (strcmp("System.out.println", tk) == 0) {
//            escreverArquivo("<SYSOUTPRINTLN>");
//            return;
//        } else if (strcmp("boolean", tk) == 0) {
//            escreverArquivo("<BOOLEAN>");
//            return;
//        } else if (strcmp("class", tk) == 0) {
//            escreverArquivo("<CLASS>");
//            return;
//        } else if (strcmp("extends", tk) == 0) {
//            escreverArquivo("<EXTENDS>");
//            return;
//        } else if (strcmp("public", tk) == 0) {
//            escreverArquivo("<PUBLIC>");
//            return;
//        } else if (strcmp("static", tk) == 0) {
//            escreverArquivo("<STATIC>");
//            return;
//        } else if (strcmp("void", tk) == 0) {
//            escreverArquivo("<VOID>");
//            return;
//        } else if (strcmp("main", tk) == 0) {
//            escreverArquivo("<MAIN>");
//            return;
//        } else if (strcmp("return", tk) == 0) {
//            escreverArquivo("<RETURN>");
//            return;
//        } else if (strcmp("int", tk) == 0) {
//            escreverArquivo("<INT>");
//            return;
//        }
//        // PONTUACAO
//        else if (strcmp("(", tk) == 0) {
//            escreverArquivo("<ABRE_PARENTESES>");
//            return;
//        } else if (strcmp(")", tk) == 0) {
//            escreverArquivo("<FECHA_PARENTESES>");
//            return;
//        } else if (strcmp("[", tk) == 0) {
//            escreverArquivo("<ABRE_COLCHETE>");
//            return;
//        } else if (strcmp("]", tk) == 0) {
//            escreverArquivo("<FECHA_COLCHETE>");
//            return;
//        } else if (strcmp("{", tk) == 0) {
//            escreverArquivo("<ABRE_CHAVES>");
//            return;
//        } else if (strcmp("}", tk) == 0) {
//            escreverArquivo("<FECHA_CHAVES>");
//            return;
//        } else if (strcmp(".", tk) == 0) {
//            escreverArquivo("<PONTO>");
//            return;
//        } else if (strcmp(",", tk) == 0) {
//            escreverArquivo("<VIRGULA>");
//            return;
//        } else if (strcmp(";", tk) == 0) {
//            escreverArquivo("<PONTOVIRGULA>");
//            return;
//        }
//        // OPERADORES
//        else if (strcmp("==", tk) == 0) {
//            escreverArquivo("<EQUIVALENTE>");
//            return;
//        } else if (strcmp("&&", tk) == 0) {
//            escreverArquivo("<AND>");
//            return;
//        } else if (strcmp("-", tk) == 0) {
//            escreverArquivo("<MENOS>");
//            return;
//        } else if (strcmp("+", tk) == 0) {
//            escreverArquivo("<MAIS>");
//            return;
//        } else if (strcmp("*", tk) == 0) {
//            escreverArquivo("<MULT>");
//            return;
//        } else if (strcmp("!", tk) == 0) {
//            escreverArquivo("<NOT>");
//            return;
//        } else if (strcmp("=", tk) == 0) {
//            escreverArquivo("<IGUAL>");
//            return;
//        } else if (strcmp("!=", tk) == 0) {
//            escreverArquivo("<DIFF>");
//            return;
//        } else if (strcmp("<", tk) == 0) {
//            escreverArquivo("<MENOR>");
//            return;
//        } else if (strcmp(">", tk) == 0) {
//            escreverArquivo("<MAIOR>");
//            return;
//        }
//        // NUMEROS -> num
//        char number[1024];
//        //Limpa area de memoria para concatenacao de numeros
//        memset(number, 0, 1024);
//        int index = 0;
//        int totalTimesCountNumber = 0;
//        int totalTimesIterate = 0;
//        int i;
//        for (i = 0; tk[i] != '\0'; i++) {
//            if (tk[i] == '0') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '1') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '2') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '3') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '4') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '5') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '6') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '7') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '8') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            } else if (tk[i] == '9') {
//                number[index++] = tk[i];
//                totalTimesCountNumber++;
//            }
//            totalTimesIterate++;
//        }
//        if (totalTimesCountNumber == totalTimesIterate) {
//            char n[1024];
//            strcpy(n, "<NUM,");
//            strcat(n, number);
//            strcat(n, ">");
//            escreverArquivo(n);
//            //identificou numero, portanto, deve parar execucao
//            return;
//        }
//        // VARIAVEIS -> id
//        bool primeiraLeitura = true;
//        char variavel[1024];
//        index = 0;
//        memset(variavel, 0, 1024);
//        for (i = 0; tk[i] != '\0'; i++) {
//            // Valida o caracter como variavel, inicido com letra e seguido de letra, ou numero ou underline (_)
//            if (tk[i] == 'a' || tk[i] == 'A' || tk[i] == 'b' || tk[i] == 'B' || tk[i] == 'c' || tk[i] == 'C'
//                    || tk[i] == 'd' || tk[i] == 'D' || tk[i] == 'e' || tk[i] == 'E' || tk[i] == 'f' || tk[i] == 'F'
//                    || tk[i] == 'g' || tk[i] == 'G' || tk[i] == 'h' || tk[i] == 'H' || tk[i] == 'i' || tk[i] == 'I'
//                    || tk[i] == 'j' || tk[i] == 'J' || tk[i] == 'k' || tk[i] == 'K' || tk[i] == 'l' || tk[i] == 'L'
//                    || tk[i] == 'm' || tk[i] == 'M' || tk[i] == 'n' || tk[i] == 'N' || tk[i] == 'o' || tk[i] == 'O'
//                    || tk[i] == 'p' || tk[i] == 'P' || tk[i] == 'q' || tk[i] == 'Q' || tk[i] == 'r' || tk[i] == 'R'
//                    || tk[i] == 's' || tk[i] == 'S' || tk[i] == 't' || tk[i] == 'T' || tk[i] == 'u' || tk[i] == 'U'
//                    || tk[i] == 'v' || tk[i] == 'V' || tk[i] == 'w' || tk[i] == 'W' || tk[i] == 'x' || tk[i] == 'X'
//                    || tk[i] == 'y' || tk[i] == 'Y' || tk[i] == 'z' || tk[i] == 'Z') {
//                primeiraLeitura = false;
//                variavel[index++] = tk[i];
//            }
//            // Valida o caracter como numero ou underline (_)
//            else if (tk[i] == '0' || tk[i] == '1' || tk[i] == '2'
//                    || tk[i] == '3' || tk[i] == '4' || tk[i] == '5'
//                    || tk[i] == '6' || tk[i] == '7' || tk[i] == '8'
//                    || tk[i] == '9' || tk[i] == '_') {
//                // Se iniciar com numero ou underline e um erro
//                if (primeiraLeitura == true) {
//                    printf("ERRO LEXICO: %s\n", tk);
//                    exit(-1);
//                }
//                primeiraLeitura = false;
//                variavel[index++] = tk[i];
//            }
//            // Caso nao seja aceito por nenhuma das condicoes devo rejeitar e encerrar a execucao
//            else {
//                printf("ERRO LEXICO: %s\n", tk);
//                exit(-1);
//            }
//        }
//        char n[1024];
//        int idIndex =addStructID(variavel);
//        char idIndexString[2];
//        sprintf(idIndexString, "%d", idIndex);
//        strcpy(n, "<ID,");
//        strcat(n, idIndexString);
//        strcat(n, ">");
//        escreverArquivo(n);
//        return;
//    }

}
