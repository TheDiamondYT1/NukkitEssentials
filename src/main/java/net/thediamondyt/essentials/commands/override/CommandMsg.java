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
package net.thediamondyt.essentials.commands.override;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

import net.thediamondyt.essentials.Main;
import net.thediamondyt.essentials.Utils;

public class CommandMsg extends EssentialsCommand {

    public CommandMsg(Main plugin) {
        super(plugin, true, "tell", "Send a message to a player.", "<player> <message...>", new String[]{"msg", "m", "whisper", "w", "tell"});
        setPermission("essentials.msg");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length < 2) {
            sender.sendMessage(f("<red>Usage: /tell <player> <message...>"));
            return false;
        }
        
        Player target = sender.getServer().getPlayer(args[0]);
        

        if(!(target instanceof Player)) {
            sender.sendMessage(f("<red>That player is not online."));
            return true;
        }
        
        String senderName = sender instanceof Player ? ((Player) sender).getDisplayName() : sender.getName();
        
        StringBuilder sb = new StringBuilder();
        for(String arg : args) {
            sb.append(arg + " ");
        }
        sender.sendMessage(f("<gold>[me -> " + ((Player) target).getDisplayName() + "] <white>" + sb.toString()));
        target.sendMessage(f("<gold>[ " + senderName + " -> me] <white>" + sb.toString());
        return true;
    }
}
