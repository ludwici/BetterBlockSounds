# Better Block Sounds Fork 2.0 — Minecraft 1.20.1

This branch is the original Architectury multi-loader project (Fabric, Forge and Quilt) with a JSON-driven sound-type configuration backport.

The configuration lives at `config/bbsf/sounds.json`. Original block-specific rules are imported into the bundled defaults. The JSON schema uses `sound_types` and ordered `rules`, with the last matching rule taking precedence. For example: `minecraft:stone=stone_ore` as a rule in the editor, or `{"target":"minecraft:stone","sound_type":"stone_ore"}` in JSON. Each sound type contains `volume`, `pitch`, `break`, `step`, `place`, `hit` and `fall`.

On Fabric, install compatible YACL and Mod Menu to open the editor via Mod Menu. Both are optional: the mod works without them using the JSON file. On Forge and Quilt, edit the JSON manually and restart the game to reload. This legacy branch does not include the client command `/bbsf reload`.

Do not assume settings for Minecraft 1.21.1 or 26.x are valid for 1.20.1: registered blocks and sounds can differ by version.
