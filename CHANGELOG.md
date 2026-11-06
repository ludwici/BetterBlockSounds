# Better Block Sounds Fork 2.0.0

### Added
- In-game sound configuration screen powered by YACL.
- Custom sound types with adjustable volume, pitch, and sound events.
- Block and tag rules for assigning sound types.
- Expandable block previews with localized names, item icons, and block IDs.

### Improved
- Create, rename, remove, and reorder sound types directly in the settings.
- Renaming a sound type updates its associated rules.
- Reorder block rules to control priority; the last matching rule takes precedence.
- Save sound settings to `config/bbsf/sounds.json`.

### Notes
- YACL 3 is optional and only needed for the in-game configuration screen. All sound settings can also be configured manually in `config/bbsf/sounds.json`.
- Reopen the settings after adding a sound type or changing rules to refresh the editor and previews.
