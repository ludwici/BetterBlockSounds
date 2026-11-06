# Better Block Sounds Fork 2.0.0

**Minecraft 1.21.1 | NeoForge**

Version 2.0.0 brings a fully configurable block sound system, an in-game configuration screen, and a more convenient way to explore which blocks use each sound type.

## What's New

### In-game sound configuration
- Manage block sounds through the mod's configuration screen, powered by **YetAnotherConfigLib (YACL) 3**.
- Edit existing sound types or create your own.
- Customize **volume**, **pitch**, and individual sound events for breaking, walking, placing, hitting, and falling.
- Adjust vanilla-based and custom sound definitions separately.

### Improved sound type management
- **Add, rename, remove, and reorder** sound type identifiers in **Manage sound types**.
- Click the **▶** arrow next to a sound type to expand its associated block list.
- See each block's **item icon, localized display name, and registry ID**.
- Browse large block lists directly inside the expanded entry.
- Renaming an existing sound type also updates the rules that refer to it.
- Newly created sound types initially copy the settings of `stone_ore`.

### Block and tag rules
- Assign sounds to **individual blocks** or **entire block tags**.
- Add, remove, and reorder rules in the **Block rules** tab.
- Rules are evaluated in order: **the last matching rule takes priority**.
- Block previews help you understand the effective sound assignments.

### Configuration and compatibility
- Sound definitions and rules are stored in `config/bbsf/sounds.json`.
- A default configuration is generated automatically on first launch.
- The configuration can also be edited directly as JSON.
- English and Russian translations are available for the settings screen.
- Added CurseForge and GitHub issue tracker links to the NeoForge mod metadata.

## How to Use

1. Install **Better Block Sounds Fork 2.0.0** on **Minecraft 1.21.1 with NeoForge**.
2. Install **YetAnotherConfigLib (YACL) 3** if you want to use the in-game configuration screen.
3. Open **Mods → Better Block Sounds Fork → Config**.
4. In **Manage sound types**, use the list buttons to add, rename, reorder, or remove sound types. Expand a type with **▶** to inspect its assigned blocks.
5. Open **Vanilla sound types** or **Custom sound types** to edit sound properties.
6. Open **Block rules** to assign sound types to blocks or tags.
7. Save your changes. Reopen the configuration screen to refresh the block previews and to edit the sound events of newly added types.

### Rule Format

Each rule follows the pattern `block_or_tag=sound_type`.

```text
minecraft:stone=stone_ore
#minecraft:logs=vanilla_stem
```

- `minecraft:stone` targets a single block.
- `#minecraft:logs` targets every block in that tag.
- `stone_ore` and `vanilla_stem` refer to sound type identifiers.
- If multiple rules target the same block, **the last matching rule wins**.

### Sound Type Properties

| Property | Description |
| --- | --- |
| `volume` | Sound volume (0 or higher) |
| `pitch` | Sound pitch (greater than 0) |
| `break` | Block breaking sound |
| `step` | Footstep sound |
| `place` | Block placement sound |
| `hit` | Block hit sound |
| `fall` | Landing/falling sound |

Sound events use registered IDs, such as `minecraft:block.stone.break`.

### Configuration File

The configuration is saved to:

```text
config/bbsf/sounds.json
```

You can edit this file manually if you prefer. Restart the game or server after modifying the file outside the in-game editor.

**Please note:**
- YACL is required for the in-game settings screen. File-based sound configuration can work without the editor.
- A dedicated server uses its own configuration file; client-side edits are not automatically synchronized to the server.
- The expanded block preview reflects the current configuration when the screen is opened. Some modded or datapack tags may only be available after their registries have loaded.
- When removing a sound type, update any rules that still reference it.

## Links

- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/better-block-sounds-fork)
- [Source code](https://github.com/ludwici/BetterBlockSounds)
- [Report issues](https://github.com/ludwici/BetterBlockSounds/issues)
