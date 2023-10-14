package cz.cvut.fel.trippidy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import cz.cvut.fel.trippidy.config.ConfigReader;
import cz.cvut.fel.trippidy.dto.SuggestionRequestDto;
import cz.cvut.fel.trippidy.dto.SuggestionResponseDto;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class SuggestionService {
    private static final Logger log = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());

    public SuggestionResponseDto suggestItems(SuggestionRequestDto suggestionRequestDto) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        var message = "I prepare myself for an event. You can find info in following json: " +
                objectMapper.writeValueAsString(suggestionRequestDto) +
                ". Suggest me 10 more items that I should pack. Your response must be a json array of strings in this format {\"suggestedItems\": []}. " +
                "Answer should be in language: cs";

        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), message);
        messages.add(userMessage);

        OpenAiService service = new OpenAiService(ConfigReader.getOpenaiApiKey());

        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest.builder()
                .model(ConfigReader.getOpenaiModel())
                .messages(messages)
                .build();

        var completion = service.createChatCompletion(chatCompletionRequest);
        var response = new SuggestionResponseDto();

        try {
            response = objectMapper.readValue(completion.getChoices().get(0).getMessage().getContent(), SuggestionResponseDto.class);
        } catch (Exception e) {
            log.warning(e.getMessage());
        }

        return response;
    }

}
