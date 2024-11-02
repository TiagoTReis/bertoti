    import io.github.ollama4j.OllamaAPI;
    import io.github.ollama4j.exceptions.OllamaBaseException;
    import io.github.ollama4j.models.response.OllamaResult;
    import io.github.ollama4j.types.OllamaModelType;
    import io.github.ollama4j.utils.OptionsBuilder;

    import java.io.IOException;
    import java.util.Scanner;

    public class Ollama {

        public static void main(String[] args) throws OllamaBaseException, IOException, InterruptedException {
            Scanner sc = new Scanner(System.in);

            String host = "http://localhost:11434/";

            OllamaAPI ollamaAPI = new OllamaAPI(host);

            ollamaAPI.setRequestTimeoutSeconds(200);

            System.out.println("Escreva uma pergunta para o manOllama:");
            String prompt = sc.nextLine();

            OllamaResult result =
                    ollamaAPI.generate("gemma2:2b", prompt, true, new OptionsBuilder().build());

            System.out.println(result.getResponse());

            sc.close();
        }
    }
