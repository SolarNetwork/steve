package de.rwth.idsg.steve.ocpp.ws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.PingMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 17.03.2015
 */
@Slf4j
@RequiredArgsConstructor
public class PingTask implements Runnable {
    private final WebSocketSession session;

    private static final PingMessage pingMessage = new PingMessage(ByteBuffer.wrap("ping".getBytes()));

    @Override
    public void run() {
        log.info("[id={}] Sending ping message", session.getId());
        try {
            session.sendMessage(pingMessage);
        } catch (IOException e) {
            log.error("[id={}] Ping failed", session.getId());
            // TODO: Do something about this
        }
    }
}
