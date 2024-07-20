package com.app.agripulse.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment extends BaseModel{

    private String comment;
    private Long userId;
}
