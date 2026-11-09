package itamio.versionshow;

import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("versionshow")
public class VersionShowMod {
    public VersionShowMod() {
        MinecraftForge.EVENT_BUS.addListener(this::onRegisterCommands);
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("versionshow").requires(s -> s.hasPermission(0))
            .executes(ctx -> {
                ctx.getSource().sendSuccess(() -> Component.literal("Minecraft 1.20.1 | Forge 47.4.20"), false);
                return 1;
            }));
    }
}
