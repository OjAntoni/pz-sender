package com.example.pzsender.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserMessage {
    private String email;
    private String topicTitle;
    private String articleTitle;
    private String author;
}
