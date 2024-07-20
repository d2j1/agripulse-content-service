package com.app.agripulse.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Like extends BaseModel {

    private Long userId;
}
