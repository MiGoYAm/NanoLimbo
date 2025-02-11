package ru.nanit.limbo.protocol.packets.login;

import ru.nanit.limbo.protocol.ByteMessage;
import ru.nanit.limbo.protocol.PacketOut;
import ru.nanit.limbo.protocol.registry.Version;

import java.util.UUID;

public class PacketLoginSuccess implements PacketOut {

    private UUID uuid;
    private String username;

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void encode(ByteMessage msg, Version version) {
        if (version.moreOrEqual(Version.V1_16)) {
            msg.writeUuid(uuid);
        } else {
            msg.writeString(uuid.toString());
        }
        msg.writeString(username);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
