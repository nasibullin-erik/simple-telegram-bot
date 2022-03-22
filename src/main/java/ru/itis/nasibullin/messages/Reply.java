package ru.itis.nasibullin.messages;

import java.util.Objects;

public class Reply {
    private String chatId;
    private Object data;
    private ReplyType replyType;

    public Reply() {
    }

    public Reply(String chatId, Object data, ReplyType replyType) {
        this.chatId = chatId;
        this.data = data;
        this.replyType = replyType;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ReplyType getReplyType() {
        return replyType;
    }

    public void setReplyType(ReplyType replyType) {
        this.replyType = replyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return Objects.equals(chatId, reply.chatId) && Objects.equals(data, reply.data) && replyType == reply.replyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, data, replyType);
    }

    @Override
    public String toString() {
        return "Reply{" +
          "chatId='" + chatId + '\'' +
          ", data=" + data +
          ", replyType=" + replyType +
          '}';
    }
}
