# Better Block Sounds Fork 2.0.0 (Fabric, Minecraft 1.20.1)

This branch is a standalone Fabric project with no Architectury/Forge/Quilt subprojects.

Sound profiles and ordered block rules live in `config/bbsf/sounds.json`. The file is generated automatically on first launch using the Minecraft 1.20.1 defaults ported from the legacy branch. It supports explicit block IDs and block tags. The last matching rule wins.

YACL 3.6.6 and Mod Menu 7.2.2 are optional. Install both for a settings GUI via Mod Menu; otherwise edit the JSON manually. Use `/bbsf reload` to apply file edits without restarting.

Build with Java 21 as the Gradle runtime and Java 17 for the Minecraft mod target: `./gradlew build`. The compiled mod requires Java 17 and Fabric for Minecraft 1.20.1.

The original multi-loader `1.20.1` branch is preserved separately.
