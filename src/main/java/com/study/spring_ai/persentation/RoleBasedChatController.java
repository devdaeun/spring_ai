package com.study.spring_ai.persentation;

import com.study.spring_ai.application.service.RoleBasedChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleBasedChatController {

    private final RoleBasedChatService roleBasedChatService;

    @GetMapping("/api/chat/role")
    public ResponseEntity<String> roleBasedChat(@RequestParam String prompt,
                                                @RequestParam String role) {
        return ResponseEntity.ok(roleBasedChatService.roleBasedChat(prompt, role));
    }
}
