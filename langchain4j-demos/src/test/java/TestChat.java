import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;


public class TestChat {

    @Test
    void test01() {
        ChatLanguageModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String res = model.chat("你是谁？");
        System.out.println(res);
    }

    @Test
    void test02() {
        ChatLanguageModel model = OpenAiChatModel.builder()
                .baseUrl("https://api.deepseek.com")
                .apiKey("官网获取")
                .modelName("deepseek-chat")
                .build();
        String res = model.chat("你是谁？");
        System.out.println(res);
    }

    @Test
    void test03() {
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("deepseek-r1:8b")
                .build();
        String res = model.chat("你是谁？");
        System.out.println(res);
    }
}
