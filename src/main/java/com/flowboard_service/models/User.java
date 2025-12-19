package com.flowboard_service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collation = "user")

public class User
{
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
}
