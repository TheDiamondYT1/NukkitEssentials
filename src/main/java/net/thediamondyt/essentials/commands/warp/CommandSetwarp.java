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

import net.thediamondyt.essentials.Main;
import net.thediamondyt.essentials.commands.EssentialsCommand;

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
        
        getPlugin().getWarps().set("warps", args[1]);
        sender.sendMessage(f("<gold>Set warp " + args[1] + ". This is a test and will later change."));
        return true;
    }
}
