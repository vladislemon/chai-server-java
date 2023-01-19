package net.vladislemon.chai.server;

public class MessageBuilder {
    private Integer id;
    private byte[] data;

    public MessageBuilder id(int id) {
        this.id = id;
        return this;
    }

    public MessageBuilder data(byte[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        this.data = data;
        return this;
    }

    public Message build() {
        return new Message(id, data);
    }
}
