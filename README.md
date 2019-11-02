## Hyperium Addon Workspace

Hyperium uses a system called addons, which allow you to add whatever you'd like to the client.

### Getting Started

To get started, first you want to either clone or download the addon workspace from here,
open it in an IDE that supports Java or Kotlin (preferably [IntelliJ](https://www.jetbrains.com/idea/)), and import the `build.gradle` file.

Likely, at first you won't have access to the decompiled Minecraft code. To fix this, all you have to do
is open the Gradle tab on the right side of your screen. Open the dropdown menu, `Tasks`, `forgegradle`, and run `setupDecompWorkspace`.

After this, refresh your gradle deps using the button that looks like two arrows spinning around eachother. 
Once you've done that, you can open `Tasks`, `forgegradle`, and run `genIntellijRuns`. This is going to create the base for
running the client once you're ready to test something.

Test to see if it setup properly by going into the top right and seeing a dropdown menu saying `Minecraft Client`, beside that is a green arrow.
Press the arrow, if it starts up, you're all good, otherwise, click on the dropdown menu, and where it says `Use classpath of module: %WORKSPACE_NAME%`,
you will want to change that to be `%WORKSPACE_NAME%.main`. An example of this would be `ExampleAddon.main`.

At this point, you should be good to go.

If you wish to login to your account to test something on a server, open the dropdown menu saying Minecraft Client, and insert
 `--username (username/email) --password (password)` then run the client.

### Addon Manifests

All of your addon information will go into `resources/addon.json`.

Listed below is all of the manifest information, and an example provided.

* **name**: The name of your addon. **ExampleAddon**
* **version**: The version of your addon. **1.0**
* **mainClass**: The path to the main class of your addon. **com.example.AddonExample** 
* **desc**: A description of your addon. **This is an addon that is made for an example.**
* **versionCode**: MUST match up to the client's versionCode. **The current versionCode is available in `AddonMinecraftBootstrap#VERSION_CODE`**


### Examples

An example of a completed addon.json file is below.

```json
{
  "name":"Addon Example",
  "version":"1.0",
  "mainClass":"com.example.AddonExample",
  "desc":"Hyperium Addon Example",
  "versionCode": "1.0"
}
```

An example of a basic addon is below.

```java
// All addons must implement IAddon
public class AddonExample implements IAddon {

    /**
     * Invoked once the plugin has successfully loaded
     * {@link cc.hyperium.internal.addons.AddonMinecraftBootstrap#init}
     */
    @Override
    public void onLoad() {
        // Log that the addon has loaded
        Hyperium.LOGGER.info("Successfully loaded Addon!");
        
        // Register the class to the EventBus
        EventBus.INSTANCE.register(this);
    }
    
    @InvokeEvent
    public void onInitialization(InitializationEvent event) {
        // Register a command on initialization
        Hyperium.INSTANCE.getHandlers().getCommandHandler().registerCommand(new AddonCommand());
    }
    
    @InvokeEvent
    public void onChatMessage(ChatEvent event) {
        // If any chat message contains "secret message!"
        if (event.getChat().getUnformattedText().contains("secret message!")) {
            //Toggle fullscreen
            Minecraft.getMinecraft().toggleFullscreen();
        }
    }
    
    /**
     * Invoked once the game has been closed
     * this is executed at the start of {@link net.minecraft.client.Minecraft#shutdown}
     */
    @Override
    public void onClose() {
        // Log that the addon is being closed
        Hyperium.LOGGER.info("Closing...");
    }

    /**
     * Invoked on debug call. Can be used to add things into crash reports
     * <p>
     * This does not need to be overriden if it's not needed
     */
    @Override
    public void sendDebugInfo() {
    }
}
```

An example of a basic addon command is below.

```java
public class AddonCommand implements BaseCommand {
    
    /**
     * Gets the name of the command
     */
    @Override
    public String getName() {
        return "addon_example";
    }

    /**
     * Gets the usage string for the command.
     */
    @Override
    public String getUsage() {
        return "/" + getName();
    }

    /**
     * Callback when the command is invoked
     *
     * @param args
     * @throws CommandException for errors inside the command, these errors
     *                          will log directly to the players chat (without a prefix)
     */
    @Override
    public void onExecute(String[] args) throws CommandException {
        Minecraft.getMinecraft().toggleFullscreen();
    }
}
```