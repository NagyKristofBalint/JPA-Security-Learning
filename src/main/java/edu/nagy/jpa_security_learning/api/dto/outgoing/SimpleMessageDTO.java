package edu.nagy.jpa_security_learning.api.dto.outgoing;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimpleMessageDTO implements Serializable {
    private final String message;
}
