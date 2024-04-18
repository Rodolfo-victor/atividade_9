package br.com.lista_atividade;

import java.io.*;

public class JavaAparece {
    public static void main(String[] args) {
        String wordToCount = "Java";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("meuarquivo.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += countOccurrencesInLine(line, wordToCount);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
            return;
        }

        System.out.println("A palavra '" + wordToCount + "' aparece um total de: " + count + "x");
    }

    private static int countOccurrencesInLine(String line, String wordToCount) {
        String[] words = line.split("\\s+");
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(wordToCount)) {
                count++;
            }
        }
        return count;
    }
}
