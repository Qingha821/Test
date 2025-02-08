package cn.zbx1425.resourcepackupdater.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ServerLockTask {

    public static final ResourceLocation TYPE = new ResourceLocation("zbx_rpu:server_lock");
    private final String serverLockKey;

    public ServerLockTask(String serverLockKey) {
        this.serverLockKey = serverLockKey;
    }

    public void sendToPlayer(ServerPlayer player) {
        ServerPlayNetworking.send(player, ServerLockS2CPacket.TYPE, new ServerLockS2CPacket(serverLockKey).toBuffer());
    }
}