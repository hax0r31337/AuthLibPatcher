# AuthLibPatcher
A mod/agent that patches Mojang's Authlib for custom authentication support

## Usage
Don't forgot to launch your mock Yggdrasil server at `http://127.0.0.1:4000/`!
### Forge mod
Just put the jar in your `.minecraft/mods/` folder and launch the game.

### Java agent
Add the JVM argument `-javaagent:/full/path/to/AuthLibPatcher.jar` and launch the game.