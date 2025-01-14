package ru.nanit.limbo.protocol.packets.login;

import ru.nanit.limbo.protocol.ByteMessage;
import ru.nanit.limbo.protocol.PacketOut;
import ru.nanit.limbo.protocol.registry.Version;

public class PacketDisconnect implements PacketOut {

    private String reason;

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void encode(ByteMessage msg, Version version) {
        msg.writeString(String.format("{\"text\": \"%s\"}", reason));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
