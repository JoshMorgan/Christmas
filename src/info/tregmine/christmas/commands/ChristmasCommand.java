package info.tregmine.christmas.commands;

import info.tregmine.christmas.ChristmasMain;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChristmasCommand implements CommandExecutor {
	public ChristmasMain plugin;

	public ChristmasCommand(ChristmasMain plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		String s = ChatColor.RED + "=" + ChatColor.GREEN + "=";
		String e = ChatColor.RED + "=";

		if(args.length == 0){
			player.sendMessage(s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+e);
			player.sendMessage(ChatColor.DARK_AQUA + "About the " + ChatColor.YELLOW + "Christmas Adventure " + ChatColor.DARK_AQUA +  "Project: ");
			player.sendMessage(ChatColor.GOLD + "Christmas Adventure is an " + ChatColor.RED + "open source" + ChatColor.GOLD + " festive plugin coded for Christmas 2013," + ChatColor.GOLD + " by " + ChatColor.BLUE + "ice374" + ChatColor.GOLD + ". The goal is to provide players with a bit of fun to have over Christmas.");
			player.sendMessage(ChatColor.DARK_AQUA + "Tips: ");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "Use " + ChatColor.RED + "/xmas help" + ChatColor.GREEN + " to see all commands");
			player.sendMessage(ChatColor.DARK_AQUA + "Developers: ");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "ice374" + ChatColor.BLUE + " (Founder)");
			player.sendMessage(ChatColor.DARK_AQUA + "Useful Links: ");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "github.com/JoshMorgan/Christmas/issues/" + ChatColor.GOLD + " Bug Reporting");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "dev.bukkit.org/bukkit-plugins/christmas-plugin/" + ChatColor.GOLD + " Bukkit Dev");
			if(plugin.getConfig().getBoolean("donors.display") == true){
				player.sendMessage(ChatColor.DARK_AQUA + "Top Donators: ");
				player.sendMessage(ChatColor.RED + " $30 " +  ChatColor.BLUE + "- " + ChatColor.GREEN + "Tregmine" + ChatColor.BLUE + " - " + ChatColor.GREEN + "The Tregmine Network" + ChatColor.BLUE + " - " + ChatColor.GOLD + "mc.tregmine.info");
				player.sendMessage(ChatColor.RED + " $15 " +  ChatColor.BLUE + "- " + ChatColor.GREEN + "LenyNero" + ChatColor.BLUE + " - " + ChatColor.GREEN + "The Politzania Server" + ChatColor.BLUE + " - " + ChatColor.GOLD + "198.12.65.50:25865");
				player.sendMessage(ChatColor.RED + " $10 " +  ChatColor.BLUE + "- " + ChatColor.GREEN + "Sarham" + ChatColor.BLUE + " - " + ChatColor.GREEN + "The WebGamer Hosting" + ChatColor.BLUE + " - " + ChatColor.GOLD + "twgs.thewebgamer.net");
			}
			player.sendMessage(ChatColor.DARK_AQUA + "Donation Info: ");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "PayPal Donation Page" + ChatColor.BLUE + " - " + ChatColor.GOLD + " goo.gl/6FQAt2");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "I'm only 15 and greatfully accept every single donation!");
			player.sendMessage(s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+e);
		}

		else if(args[0].equalsIgnoreCase("warp")){
			if(!player.isOp()){
				return true;
			}

			if(args.length != 3){
				player.sendMessage(ChatColor.RED + 	"Invalid arguements, Did you mean /xmas warp <add|rem> <player> ?");
				player.sendMessage(ChatColor.RED + 	"Or did you mean /xmas warp whitelist <on|off> ?");
			}

			else if(args[1].equalsIgnoreCase("add")){
				plugin.getConfig().set("player." + args[2] + ".warp", plugin.getConfig().getBoolean("player." + args[2] + ".warp"));
				plugin.getConfig().set("player." + args[2] + ".warp", true);
				plugin.saveConfig();
				player.sendMessage(ChatColor.GREEN + args[2] + " has been added to the christmas world whitelist.");
			}else if(args[1].equalsIgnoreCase("remove") || args[1].equalsIgnoreCase("rem")){
				if(plugin.getConfig().contains("player." + args[2] + ".warp")){
					plugin.getConfig().set("player." + args[2] + ".warp", plugin.getConfig().getBoolean("whitelist.warp." + args[2]));
					plugin.getConfig().set("player." + args[2] + ".warp", false);
					plugin.saveConfig();
					player.sendMessage(ChatColor.RED + args[2] + " has been removed from the christmas world whitelist.");
				}else{
					player.sendMessage("" + args[2] + " is not in the christmas world whitelist");
				}
			}else if(args[1].equalsIgnoreCase("whitelist")){
				plugin.getConfig().set("whitelist.warp.status", plugin.getConfig().getBoolean("whitelist.warp.status"));
				if(args[2].equalsIgnoreCase("on")){
					plugin.getConfig().set("whitelist.warp.status", true);
					player.sendMessage(ChatColor.GREEN + "Christmas world whitelist turned on!");
				}else if(args[2].equalsIgnoreCase("off")){
					plugin.getConfig().set("whitelist.warp.status", false);
					player.sendMessage(ChatColor.GREEN + "Christmas world whitelist turned off!");
				}else{
					player.sendMessage(ChatColor.RED + 	"Invalid arguements, Did you mean /xmas build whitelist <on|off> ?");
				}
			}else{
				player.sendMessage(ChatColor.RED + 	"Invalid arguements, Did you mean /xmas warp <add|rem> <player> ?");
				player.sendMessage(ChatColor.RED + 	"Or did you mean /xmas warp whitelist <on|off> ?");
			}
		}

		else if(args[0].equalsIgnoreCase("build")){
			if(!player.isOp()){
				return true;
			}			

			if(args.length != 3){
				player.sendMessage(ChatColor.RED + 	"Invalid arguements, Did you mean /xmas build <add|rem> <player> ?");
				player.sendMessage(ChatColor.RED + 	"Or did you mean /xmas build whitelist <on|off> ?");
			}

			if(args[1].equalsIgnoreCase("add")){
				plugin.getConfig().set("player." + args[2] + ".build", plugin.getConfig().getBoolean("whitelist.warp." + args[2]));
				plugin.getConfig().set("player." + args[2] + ".build", true);
				plugin.saveConfig();
				player.sendMessage(ChatColor.GREEN + args[2] + " has been added to the christmas world whitelist.");
			}else if(args[1].equalsIgnoreCase("remove") || args[1].equalsIgnoreCase("rem")){
				if(plugin.getConfig().contains("player." + args[2] + ".build")){
					plugin.getConfig().set("player." + args[2] + ".build", plugin.getConfig().getBoolean("player." + args[2] + ".build"));
					plugin.getConfig().set("player." + args[2] + ".build", false);
					plugin.saveConfig();
					player.sendMessage(ChatColor.RED + args[2] + " has been removed from the christmas build whitelist.");
				}else{
					player.sendMessage("" + args[2] + " is not in the christmas build whitelist");
				}
			}else if(args[1].equalsIgnoreCase("whitelist")){
				plugin.getConfig().set("whitelist.build.status", plugin.getConfig().getBoolean("whitelist.build.status"));
				if(args[2].equalsIgnoreCase("on")){
					plugin.getConfig().set("whitelist.build.status", true);
					player.sendMessage(ChatColor.GREEN + "Christmas world whitelist turned on!");
					plugin.saveConfig();
				}else if(args[2].equalsIgnoreCase("off")){
					plugin.getConfig().set("whitelist.build.status", false);
					player.sendMessage(ChatColor.GREEN + "Christmas world whitelist turned off!");
					plugin.saveConfig();
				}else{
					player.sendMessage(ChatColor.RED + 	"Invalid arguements, Did you mean /xmas build whitelist <on|off> ?");
				}
			}else{
				player.sendMessage(ChatColor.RED + 	"Invalid arguements, Did you mean /xmas build <add|rem> <player> ?");
				player.sendMessage(ChatColor.RED + 	"Or did you mean /xmas build whitelist <on|off> ?");
			}
		}
		else if(args[0].equalsIgnoreCase("help")){
			player.sendMessage(s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+e);
			player.sendMessage(ChatColor.BLUE + "Christmas Adventure Help: ");
			player.sendMessage(ChatColor.DARK_AQUA + "Tips: ");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "If you have any issues please go to: '" + ChatColor.GOLD + "http://dev.bukkit.org/bukkit-plugins/christmas-plugin");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "Type '" + ChatColor.RED + "/xmas" + ChatColor.GREEN + "' to see plugin info");
			player.sendMessage(ChatColor.DARK_AQUA + "Commands: ");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "Build Whitelist On/Off" + ChatColor.GOLD + " /xmas build whitelist <on|off>");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "Build Whitelist Player Add/Remove" + ChatColor.GOLD + " /xmas build <add|rem> <player>");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "Warp Whitelist On/Off" + ChatColor.GOLD + " /xmas warp whitelist <on|off>");
			player.sendMessage(ChatColor.GOLD + " - " + ChatColor.GREEN + "Warp Whitelist Player Add/Remove" + ChatColor.GOLD + " /xmas warp <add|rem> <player>");
			player.sendMessage(s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+s+e);
		}
		else{
			player.sendMessage(ChatColor.GOLD + "Did you mean to type '/xmas help' ?");
		}

		return true;
	}
}