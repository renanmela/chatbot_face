package com.example.chatbottest;

import com.example.chatbottest.dialogflow.DialogFlowWebHook;
import com.example.chatbottest.weather.WeatherWebHook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("webhook")
public class WebHook {
	private final String PAGE_TOKEN = "EAAKIOzAzo9ABAFktJQZBAmhFqnWUyf7ByZANl5EQRJ8THvNP2aYBySdBZCmO54OvJJZB4RMvAAosfXZCD2ZBcbe3ZCaAZC12mq3tR5aoazmgZAS65TRQZCiKlMGkdrkA9LwKYsZAtBrlWq8ZAK3BsbwJRXAcmdAUeIFOxcZBO2qVSBozEY0JCvbqv02uxO2MsWgOb0rQZD";
	private final String VERIFY_TOKEN = "xyz";
	private final String FB_MSG_URL="https://graph.facebook.com/v2.6/me/messages?access_token=" + PAGE_TOKEN;
	private final RestTemplate template = new RestTemplate();

	// This is necessary for register a webhook in facebook
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public String get(@RequestParam(name = "hub.verify_token") String token,
			@RequestParam(name = "hub.challenge") String challenge) {
		if (token != null && !token.isEmpty() && token.equals(VERIFY_TOKEN)) {
			return challenge;
		} else {
			return "Wrong Token";
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void post(@RequestBody FacebookHookRequest request) {
		for (FacebookEntry e : request.getEntry()) {
			for (FacebookMessaging m : e.getMessaging()) {
				String id = m.getSender().get("id");
				String message = m.getMessage().getText();
				DialogFlowWebHook dialogFlow= new DialogFlowWebHook();
				this.sendReply(id, dialogFlow.post(message));
			}
		}
	}

	private void sendReply(String id, String text) {
		FacebookMessageResponse response = new FacebookMessageResponse();
		response.setMessage_type("text");
		response.getRecipient().put("id", id);
		response.getMessage().put("text", text);
		HttpEntity<FacebookMessageResponse> entity = new HttpEntity<>(response);
		String result = template.postForEntity(FB_MSG_URL, entity, String.class).getBody();

	}
}
