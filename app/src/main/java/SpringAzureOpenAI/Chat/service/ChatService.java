package SpringAzureOpenAI.Chat.service;

import SpringAzureOpenAI.Chat.model.ChatResponse;
import SpringAzureOpenAI.Chat.model.Question;

public interface ChatService {

    ChatResponse respond(Question question);
}
