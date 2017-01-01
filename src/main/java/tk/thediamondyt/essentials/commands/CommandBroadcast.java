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
package tk.thediamondyt.essentials.commands;

import cn.nukkit.command.CommandSender;

import tk.thediamondyt.essentials.Main;

public class CommandBroadcast extends EssentialsCommand {

    public CommandBroadcast(Main plugin) {
        super(plugin, "broadcast", "Broadcast a message to the server", "<message>", new String[]{"ebc", "bc", "bcast", "eshout", "shout"});
        setPermission("essentials.broadcast");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!testPermission(sender)) return true;

        if(args.length < 1) {
            sender.sendMessage(f("<red>Usage: /broadcast <message>"));
            return false;
        }		
        sender.getServer().broadcastMessage(f("<gold>[<darkred>Broadcast<gold>] <green>" + Utils.split(args)));
        return true;
    }
}
