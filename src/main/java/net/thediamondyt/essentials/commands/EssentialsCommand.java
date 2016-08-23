/*
 *
 *   __________         ______                                   ____      _________
 *   |__   __| |        |  __ \(_)                               | \ \   / /__   __|
 *      | |  | |__   ___| |  | |_  __ _ _ __ ___   ___  _ __   __| |\ \_/ /   | |
 *      | |  | '_ \ / _ \ |  | | |/ _` | '_ ` _ \ / _ \| '_ \ / _` | \   /    | |
 *      | |  | | | |  __/ |__| | | (_| | | | | | | (_) | | | | (_| |  | |     | |
 *      |_|  |_| |_|\___|_____/|_|\__,_|_| |_| |_|\___/|_| |_|\__,_|  |_|     |_|
 *
 *
 * NukkitEssentials v1.0
 */
package net.thediamondyt.essentials.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandMap;
import cn.nukkit.command.PluginIdentifiableCommand;

import net.thediamondyt.essentials.Main;

abstract class EssentialsCommand extends Command implements PluginIdentifiableCommand {

    private Main plugin;
    
    public EssentialsCommand(Main plugin, String name, String desc, String usage) {
        super(name, desc, usage);

        this.plugin = plugin;
    }
    
    public EssentialsCommand(Main plugin, String name, String desc, String usage, String[] aliases) {
        super(name, desc, usage, aliases);

        this.plugin = plugin;
    }

    // Only for commands that override default ones
    public EssentialsCommand(Main plugin, Boolean override, String name, String desc, String usage, String[] aliases) {
        super(override, name, desc, usage, aliases);

        this.plugin = plugin;
        
        CommandMap map = plugin.getServer().getCommandMap();
        Command command = map.getCommand(name);
        command.setLabel(name + "_disabled");
        command.unregister(map);
    }

    /*
     * The main class of the plugin
     * @return plugin
     */
    public Main getPlugin() {
        return plugin;
    }

    /*
     * Replace colour tags in messages
     * @return string
     */
    public String f(String string) {
        return string.replace("<black>", "\u00A70")
                .replace("<navy>", "\u00A71")
                .replace("<green>", "\u00A72")
				.replace("<red>", "\u00A7c")
                .replace("<darkred>", "\u00A74")
                .replace("<purple>", "\u00A75")
                .replace("<gold>", "\u00A76")
                .replace("<silver>", "\u00A77")
                .replace("<gray>", "\u00A78")
                .replace("<blue>", "\u00A79")
                .replace("<lime>", "\u00A7a")
                .replace("<aqua>", "\u00A7b")
                .replace("<rose>", "\u00A7c")
                .replace("<pink>", "\u00A7d")
                .replace("<yellow>", "\u00A7e")
                .replace("<white>", "\u00A7f");
    }
}
