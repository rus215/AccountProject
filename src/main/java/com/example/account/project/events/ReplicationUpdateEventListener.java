package com.example.account.project.events;

import com.example.account.project.entity.Account;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@RequiredArgsConstructor
@Component
public class ReplicationUpdateEventListener implements PostUpdateEventListener {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        final Object entity = event.getEntity();
        if (entity.getClass().isAssignableFrom(Account.class)) {
            Account account = (Account) entity;
            String msg = format(
                    "Актуальный остаток на счете %s: %s %s",
                    account.getNumber(),
                    account.getSum(),
                    account.getCurrency()
            );
            kafkaTemplate.send("account-topic", msg);
        }
    }

    @Override
    public boolean requiresPostCommitHanding(EntityPersister persister) {
        return false;
    }
}
