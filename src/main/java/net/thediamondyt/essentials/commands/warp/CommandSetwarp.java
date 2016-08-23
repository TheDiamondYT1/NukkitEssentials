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
package net.thediamondyt.essentials.commands.warp;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

import cn.nukkit.level.Location;
import net.thediamondyt.essentials.Main;
import net.thediamondyt.essentials.commands.EssentialsCommand;

import java.util.List;

public class CommandSetwarp extends EssentialsCommand {

    public CommandSetwarp(Main plugin) {
        super(plugin, "setwarp", "Set a warp.", null, new String[]{"addwarp"});
        setPermission("essentials.setwarp");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length >= 2 || args.length < 1) {
            sender.sendMessage(f("<red>Usage: /setwarp <name>"));
            return false;
        }

        Location l = ((Player) sender).getLocation();

        String name = args[0];

        getPlugin().getConfig().set("warps", name);
        sender.sendMessage(f("<gold>Warp <red>" + name + " <gold>set."));
        getPlugin().getConfig().save();
        return true;
    }
}
