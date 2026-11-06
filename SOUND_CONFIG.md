# Better Block Sounds Fork 2.0.0 (Forge / early NeoForge, Minecraft 1.20.1)

This standalone branch uses the NeoForge team's **ModDevGradle Legacy Forge** plugin to target MinecraftForge 47.x. Minecraft 1.20.1 NeoForge was a Forge-compatible pre-hard-fork release; the NeoForge team recommends Forge for 1.20.1 today.

The mod targets Java 17 and builds as `bbsf-forge-1.20.1`. No Fabric or Architectury dependency is required.

All sound profiles and ordered block rules are stored in `config/bbsf/sounds.json`. The default rules are ported from the original Minecraft 1.20.1 project. The last matching rule wins. YACL `3.6.6+1.20.1-forge` is optional and enables the configuration screen inside the Forge Mods list; without YACL, edit the JSON manually and restart Minecraft.

The legacy multi-loader `1.20.1` branch remains preserved.
