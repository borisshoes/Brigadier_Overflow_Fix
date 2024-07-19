package net.borisshoes.brigadieroverflowfix;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BrigadierOverflowFix implements ModInitializer {
   private static final Logger logger = LogManager.getLogger("Brigadier Overflow Fix");
   
   @Override
   public void onInitialize(){
      logger.info("Patching Brigadier Overflow Exploit");
   }
   
   
}
