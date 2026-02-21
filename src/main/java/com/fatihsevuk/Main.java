package com.fatihsevuk;

import dev.langchain4j.model.openai.OpenAiChatModel;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ask me anything (type 'exit' to quit):");

        while (true) {
            System.out.print("> ");
            String question = scanner.nextLine(); // waits until Enter

            // exit condition
            if (question.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye 👋");
                break;
            }

            // process the question
            String answer = processQuestion(question);

            // print answer
            System.out.println(answer);
        }

        scanner.close();
    }

    // Example processing logic
    private static String processQuestion(String question) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();

        return model.chat(question);
    }

}