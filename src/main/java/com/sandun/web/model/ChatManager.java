package com.sandun.web.model;

import com.sandun.web.entities.Message;
import com.sandun.web.entities.OrderManager;
import com.sandun.web.entities.User;
import com.sandun.web.entities.enums.MessageType;
import com.sandun.web.entities.enums.OrderState;
import com.sandun.web.entities.enums.UserType;
import com.sandun.web.panel.Chat;
import com.sandun.web.template.ChatOrderItem;
import com.sandun.web.template.MessageContainer;
import com.sandun.web.template.MessageTemplate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.Box;
import javax.swing.JPanel;
import com.sandun.web.service.MessageService;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;

public class ChatManager {

    private Chat chat;
    private MessageListener listener;

    private ClickEffectManager cem;
    private MessageService messageService;
    private User u;
    private OrderManager currentHandler;
    private ChatOpenChecker isChatOpen;

    public ChatManager(Chat chat, MessageListener listener, ChatOpenChecker isChatOpen) {
        this.chat = chat;
        this.listener = listener;
        this.messageService = new MessageService();
        this.isChatOpen = isChatOpen;
        cem = new ClickEffectManager(new Color(204, 204, 204), new Color(153, 153, 153));
    }

    public ChatOpenChecker isIsChatOpen() {
        return isChatOpen;
    }

    public void loadChatOrders() {
        new Thread(() -> {
            if (u == null) {
                u = SessionManager.getUSER();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<OrderManager> handlers = messageService.getOrderHandlers(OrderState.PREPARING, u.getId());
            chat.jPanel1.removeAll();
            for (OrderManager h : handlers) {
                String name = h.getId() + "(" + sdf.format(h.getOrder().getDate()) + ")";
                ChatOrderItem item = new ChatOrderItem(name, cem);
                item.getMyPanelRound4().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        listener.setHandlerId(h.getId());
                        currentHandler = h;
                        chat.jLabel4.setText(name);
                        loadChat(h.getId());
                    }
                });
                chat.jPanel1.add(item);
                chat.jPanel1.add(Box.createVerticalStrut(5));
            }
            chat.jPanel1.repaint();
            chat.jPanel1.revalidate();
        }).start();
    }

    public void loadChat(long id) {
        if (u == null) {
            u = SessionManager.getUSER();
        }
        List<Message> messages = messageService.getChatByOrderId(id);
        listener.setCurrentMessageList(messages);
        chat.jPanel4.removeAll();
        for (Message m : messages) {
            MessageContainer mc = new MessageContainer();
            FlowLayout layout = (FlowLayout) mc.getLayout();

            boolean t = true;

            if (u.getType() == UserType.EMPLOOYEE && m.getType() == MessageType.USER) {
                t = false;
            } else if (u.getType() == UserType.CUSTOMER && m.getType() == MessageType.EMPLOYEE) {
                t = false;
            }

            if (t) {
                layout.setAlignment(FlowLayout.RIGHT);
            } else {
                layout.setAlignment(FlowLayout.LEFT);
            }
            MessageTemplate mt = new MessageTemplate(m.getMessage());
            int w = 10 + (m.getMessage().length() * 13);
            int h = (12 * Math.round((w / 350)));
            if (w > 350) {
                w = 350;
            }
            System.out.println(h);
            if (h < 70) {
                h = 50;
            }
            if (w < 138) {
                w = 138;
            }

            mc.setPreferredSize(new Dimension(755, h + 10));
            mc.setMaximumSize(new Dimension(755, h + 10));
            mc.setSize(new Dimension(755, h + 10));
            mt.setPreferredSize(new Dimension(w, h));
            mt.setSize(new Dimension(w, h));
            JPanel p = mt.getMyPanelRound1();
            p.setPreferredSize(new Dimension(w, h));
            p.setSize(new Dimension(w, h));
            mc.add(mt);
            chat.jPanel4.add(mc);
        }
        SwingUtilities.invokeLater(() -> scrollDown(false));
        if (!listener.isListenerStarted()) {
            listener.setStillListening(true);
            listener.startListener();
        }

    }

    private void scrollDown(boolean pause) {
        new Thread(() -> {
            if (pause) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
            JScrollBar vertical = chat.jScrollPane1.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximumSize().height);
            chat.revalidate();
            chat.repaint();
        }).start();
    }

    public void sendMessage(String msg) {
        if (currentHandler != null) {
            MessageType type = MessageType.USER;
            if (u.getId() == currentHandler.getHandler().getId()) {
                type = MessageType.EMPLOYEE;
            }
            messageService.setMessage(currentHandler, type, msg);
            loadChat(currentHandler.getId());
            SwingUtilities.invokeLater(() -> scrollDown(true));
        }
    }
}
