package com.example.practices.messages;

import lombok.Builder;
import lombok.With;

import java.util.UUID;

@Builder
public record StopPingActorCommand(@With UUID id) implements Message {
}
