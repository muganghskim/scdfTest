package com.example.scdfsource.repository;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TwoOutputSource {
    @Output("output1")
    MessageChannel output1();

    @Output("output2")
    MessageChannel output2();
}