package cn.psvmc.ws_server2.ws;

import io.netty.handler.codec.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.yeauty.annotation.*;
import org.yeauty.pojo.Session;

import java.io.IOException;

@ServerEndpoint(prefix = "netty-websocket")
@Component
public class MyWebSocket {

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers) throws IOException {
        System.out.println("new connection");
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("one connection closed");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }

    @OnMessage
    public void OnMessage(Session session, String message) {
        System.out.println(message);
        session.sendText("服务器发送："+message);
    }
}
