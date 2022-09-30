package edu.nagy.jpa_security_learning.api.dto.outgoing;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@RequiredArgsConstructor
public class SimpleMessagesDTO implements Serializable {
    private final Collection<String> messages;
}
