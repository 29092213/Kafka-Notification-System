package com.MessageKafka.testeKafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic TopicCozinha(){
        return TopicBuilder.name("Cozinha")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic DivisionTopic(){
        return TopicBuilder.name("RegisterMessage")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic TopicProducao(){
        return TopicBuilder.name("Producao")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic TopicAumoxarifado(){
        return TopicBuilder.name("Aumoxarifado")
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic TopicRecurHumam(){
        return TopicBuilder.name("RecurHumam")
                .partitions(1)
                .replicas(1)
                .build();
    }
}

//cd C:\Users\luizr\IdeaProjects\testeKafka\docker     ##   docker compose -f kafka-compose.yml logs -f kafka
