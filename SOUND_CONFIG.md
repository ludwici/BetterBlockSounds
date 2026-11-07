# Sound configuration (Fabric 1.20.1)

Better Block Sounds Fork works without YACL or Mod Menu. On the first launch it creates `config/bbsf/sounds.json` using the bundled sound definitions and block-tag rules.

## In-game editor

Install YetAnotherConfigLib **3.6.6+1.20.1-fabric** and Mod Menu **11.0.3** to use the **Configure** button in Mod Menu. Both mods are optional: BBSF runs with neither, and manual JSON editing remains fully available. The former `/bbsf config` command was removed because opening the GUI from the command handler was unreliable.

The editor has four tabs:

- **Block rules:** reorder, remove, and add rules using `#namespace:tag=sound_type` for block tags or `namespace:block=sound_type` for a single block. The last matching rule wins, exactly as in the original mod.
- **Manage sound types:** add or delete sound-type identifiers. New types start as copies of `stone_ore`; save and reopen the editor to change their parameters. Update rules if you delete or rename a type.
- **Vanilla sound types:** the built-in sound types whose identifiers start with `vanilla_` (such as `vanilla_tuff`).
- **Custom sound types:** the original BBSF definitions (such as `stone_ore`) and any sound types you add. Both sound-type tabs edit volume, pitch and the five sound events (break, step, place, hit, fall).

Click **Save** in YACL to write the JSON and apply your changes without restarting.

## Manual editing

No UI dependencies are needed for manual editing. The JSON file contains:

```json
{
  "sound_types": {
    "my_stone": {
      "volume": 1.0,
      "pitch": 0.9,
      "break": "minecraft:block.deepslate.break",
      "step": "minecraft:block.deepslate.step",
      "place": "minecraft:block.deepslate.place",
      "hit": "minecraft:block.deepslate.hit",
      "fall": "minecraft:block.deepslate.fall"
    }
  },
  "rules": [
    {
      "target": "minecraft:stone",
      "sound_type": "my_stone"
    },
    {
      "target": "#bbsf:stone_bricks",
      "sound_type": "my_stone"
    }
  ]
}
```

This example illustrates the schema. Preserve any existing sound definitions and rules that you want to keep.

A rule target beginning with `#` is a block tag. The tag must actually exist in the game's datapacks. A target without `#` is a specific registered block ID.

After changing the JSON externally, run the client-side command `/bbsf reload` or restart Minecraft. Loading invalid JSON preserves the previously loaded settings; invalid event IDs or rule references are skipped and logged.

## Defaults and compatibility

The bundled `assets/bbsf/default_sounds.json` contains 1.20.1-compatible grouped rules and sound-type definitions. Existing `config/bbsf/sounds.json` files are preserved. When the user's JSON is created, the `vanilla` presets are expanded to explicit volume, pitch and registered sound IDs from Minecraft 1.20.1.

The bundled `data/bbsf/tags/blocks/*.json` files define the block groups for Minecraft 1.20.1. Sound events must refer to registered sound IDs. The client can use this mod without installing it on the server.
