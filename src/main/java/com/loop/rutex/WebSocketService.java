/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loop.rutex;

import java.net.URI;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

/**
 *
 * @author Zainul Saifulah Aziz
 */
public class WebSocketService extends WebSocketClient {

//    private static final Object LOCK = new Object();
//    private static volatile WebSocketClient sInstance;
//
//    public static WebSocketClient getInstance(URI serverUri) {
//        if (sInstance == null) {
//            synchronized (LOCK) {
//                if (sInstance == null) {
//                    sInstance = new WebSocketService(serverUri);
//                }
//            }
//        }
//        return sInstance;
//    }

    public WebSocketService(URI serverUri, Draft protocolDraft) {
        super(serverUri, protocolDraft);
    }

    public WebSocketService(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake sh) {
        send("Hello, it is me. Mario :) It's second line");
        System.out.println("new connection opened");
    }

    @Override
    public void onMessage(String string) {
        
    }

    @Override
    public void onClose(int i, String string, boolean bln) {
        System.out.println("closed with exit code " + i + " additional info: " + string);
    }

    @Override
    public void onError(Exception excptn) {
        System.err.println("an error occurred:" + excptn);
    }

}
