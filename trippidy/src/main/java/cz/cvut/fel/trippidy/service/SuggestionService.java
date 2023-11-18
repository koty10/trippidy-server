package cz.cvut.fel.trippidy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.client.OpenAiApi;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import cz.cvut.fel.trippidy.config.ConfigReader;
import cz.cvut.fel.trippidy.dto.SuggestionRequestDto;
import cz.cvut.fel.trippidy.dto.SuggestionResponseDto;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.theokanning.openai.service.OpenAiService.*;

@Stateless
public class SuggestionService {
    private static final Logger log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public SuggestionResponseDto suggestItems(SuggestionRequestDto suggestionRequestDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        var message = "I prepare myself for an event. You can find info in following json: " +
                objectMapper.writeValueAsString(suggestionRequestDto) +
                ". Suggest me 10 more items that I should pack. Your response must be a json array of strings in this format {\"suggestedItems\": []}. Dont write anything else! " +
                "Answer should be in language: english";

        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), message);
        messages.add(userMessage);

        ObjectMapper mapper = defaultObjectMapper();
        OkHttpClient client = defaultClient(ConfigReader.getOpenaiApiKey(), java.time.Duration.ofSeconds(60))
                .newBuilder()
                //.interceptor(HttpLoggingInterceptor())
                .build();
        Retrofit retrofit = defaultRetrofit(client, mapper);

        OpenAiApi api = retrofit.create(OpenAiApi.class);
        OpenAiService service = new OpenAiService(api);

        //OpenAiService service = new OpenAiService(ConfigReader.getOpenaiApiKey());

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(ConfigReader.getOpenaiModel())
                .messages(messages)
                .build();

        long start = System.nanoTime();
        var completion = service.createChatCompletion(chatCompletionRequest);
        long end = System.nanoTime();
        long elapsedTime = end - start;
        log.info("gpt call took " + elapsedTime / 1000000 + "ms.");

        var response = new SuggestionResponseDto();

        try {
            response = objectMapper.readValue(completion.getChoices().get(0).getMessage().getContent(), SuggestionResponseDto.class);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        return response;
    }

}
