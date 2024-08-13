package SpringAzureOpenAI.Chat.service.impl;

import SpringAzureOpenAI.Chat.model.ChatResponse;
import SpringAzureOpenAI.Chat.model.Question;
import SpringAzureOpenAI.Chat.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger log = LoggerFactory.getLogger(ChatServiceImpl.class);

    private final ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    /**
     * @param question
     * @return
     */
    @Override
    public ChatResponse respond(Question question) {
        String response = chatClient.prompt()
                .user(question.question())
                .call()
                .content();
        log.info("Question: {}%nResponse: {}", question.question(), response);
        return new ChatResponse(question.question(), response);
    }

}
