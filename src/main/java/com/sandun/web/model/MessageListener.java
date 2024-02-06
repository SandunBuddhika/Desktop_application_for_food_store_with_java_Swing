package com.sandun.web.model;

import com.sandun.web.entities.Message;
import com.sandun.web.service.MessageService;
import java.util.List;

public class MessageListener extends MediatorComponent {

    private long handlerId;
    private MessageService messageService;
    private List<Message> currentMessageList;
    private boolean stillListening;

    public MessageListener() {
        messageService = new MessageService();
    }

    public void setHandlerId(long handlerId) {
        this.handlerId = handlerId;
    }

    public void setCurrentMessageList(List<Message> currentMessageList) {
        this.currentMessageList = currentMessageList;

    }

    public boolean isListenerStarted() {
        return stillListening;
    }

    public void setStillListening(boolean stillListening) {
        this.stillListening = stillListening;
    }

    public void startListener() {
        if (handlerId != 0 && stillListening) {
            new Thread(() -> {
                while (stillListening && chatManager.isIsChatOpen().isIsChatOpen()) {
                    try {
                        long mSize = messageService.getChatSizeByOrderId(handlerId);
                        if (mSize != currentMessageList.size()) {
                            chatManager.loadChat(handlerId);
                        }
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
