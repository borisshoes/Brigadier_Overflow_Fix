package net.borisshoes.brigadieroverflowfix.mixin;


import net.minecraft.network.packet.c2s.play.RequestCommandCompletionsC2SPacket;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {
   
   @Inject(method = "onRequestCommandCompletions", at=@At("HEAD"), cancellable = true)
   private void overflowfix$rejectBadPacket(RequestCommandCompletionsC2SPacket packet, CallbackInfo ci){
      String text = packet.getPartialCommand();
      final int length = text.length();
      
      if (length > 256) {
         ci.cancel();
         return;
      }
   }
}
