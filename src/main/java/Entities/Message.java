package Entities;

import Enums.MessageType;


public class Message {
    private int id;
    private int userId;
    private MessageType messageType;
    private String title;
    private String text;

    public Message() {
    }

    public Message(int userId, MessageType messageType, String title, String text) {
        this.userId = userId;
        this.messageType = messageType;
        this.title = title;
        this.text = text;
    }

    public Message(int id, int userId, MessageType messageType, String title, String text) {
        this.id = id;
        this.userId = userId;
        this.messageType = messageType;
        this.title = title;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", userId=" + userId +
                ", messageType=" + messageType +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
