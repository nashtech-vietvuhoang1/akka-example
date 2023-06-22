package com.example.practices.messages;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.util.UUID;

@Builder
public record Response<T>(@NonNull @With UUID requestId, @With T payload) {
}
