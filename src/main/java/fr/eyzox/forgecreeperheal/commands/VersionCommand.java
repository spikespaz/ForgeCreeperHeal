package fr.eyzox.forgecreeperheal.commands;

import fr.eyzox.forgecreeperheal.ForgeCreeperHeal;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class VersionCommand extends ForgeCreeperHealCommands {

    @Override
    public void _execute(MinecraftServer server, ICommandSender sender, String[] args) {
        sender.sendMessage(new TextComponentString(ForgeCreeperHeal.MODNAME));
    }

    @Override
    protected String getFCHCommandName() {
        return null;
    }

    @Override
    protected String getHelp() {
        return "fch.command.version.help";
    }

    @Override
    protected String getFCHUsage() {
        return "";
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }
}
