package com.sandun.web.model;

import javax.swing.JPanel;

public abstract class MediatorComponent extends JPanel{

    protected ChatManager chatManager;

    public void setChatManager(ChatManager chatManager) {
        this.chatManager = chatManager;
    }

}
