package SpringAzureOpenAI.Chat.controller;

import SpringAzureOpenAI.Chat.model.ChatResponse;
import SpringAzureOpenAI.Chat.model.Question;
import SpringAzureOpenAI.Chat.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping(path = "/chat", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.ALL_VALUE})
    public ChatResponse chat(@RequestParam Question question){
        return chatService.respond(question);
    }
}
