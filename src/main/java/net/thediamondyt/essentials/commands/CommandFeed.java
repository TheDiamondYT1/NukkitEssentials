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

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

import net.thediamondyt.essentials.Main;

public class CommandFeed extends EssentialsCommand {

    public CommandFeed(Main plugin) {
        super(plugin, "feed", "Feed yourself or another player", "[player]", new String[]{"efeed", "eat", "eeat"});
        setPermission("essentials.feed");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length >= 2) {
            sender.sendMessage(sender instanceof Player ? f("<red>Usage: /feed [player]") : f("<red>Usage: /feed <player>"));
            return false;
        }

        if(args.length == 1) {
            Player target = sender.getServer().getPlayer(args[0]);

            if(!(target instanceof Player)) {
                sender.sendMessage(f("<red>That player is not online."));
                return true;
            }
            ((Player) target).getFoodData().setLevel(20);
            target.sendMessage(f("<gold>You have been fed by " + sender.getName()));
            sender.sendMessage(f("<gold>Your apetite has been sated."));
            return true;
        }

        if(!(sender instanceof Player)) {
            sender.sendMessage(f("<red>Usage: /feed <player>"));
            return true;
        }

        ((Player) sender).getFoodData().setLevel(20);
        sender.sendMessage(f("<gold>Your apetite has been sated."));
        return true;
    }
}
