package net.lwenstrom.studentWebService;


import com.google.gson.Gson;
import net.lwenstrom.model.MessageBodyActivationLinkClicked;
import net.lwenstrom.model.MessageBodyStartProcessInstance;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class StudentIdRestController {

    @PostMapping("/submit")
    public String submit(@RequestParam(value="studentID") int studentID) {
        System.out.println(studentID);
        MessageBodyStartProcessInstance msgBody = new MessageBodyStartProcessInstance(studentID);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(msgBody);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final String baseUrl = "http://host.docker.internal:8080/engine-rest/process-definition/key/student-money/start";
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);

        return "Antrag erfolgreich gestellt! Check deine E-Mails";
    }

    @GetMapping("/activationLink")
    public String activationLinkClicked(@RequestParam(value="uuid") String uuid) {
        System.out.println(uuid);
        MessageBodyActivationLinkClicked msgBody = new MessageBodyActivationLinkClicked(uuid);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(msgBody);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        final String baseUrl = "http://host.docker.internal:8080/engine-rest/message";
        HttpEntity<String> entity = new HttpEntity<>(jsonBody, headers);
        restTemplate.exchange(baseUrl, HttpMethod.POST, entity, String.class);
        return "Aktivierungslink geklickt. Wir werden den Antrag als PDF erzeugen und dir per E-Mail senden!";
    }
}

