package com.example.practices.messages;

import java.util.UUID;

public interface Result extends Message {
  UUID requestId();

  boolean isSuccess();

  Throwable error();
}
