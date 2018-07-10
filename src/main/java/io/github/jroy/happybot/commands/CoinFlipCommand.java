package io.github.jroy.happybot.commands;

import io.github.jroy.happybot.commands.base.CommandBase;
import io.github.jroy.happybot.commands.base.CommandCategory;
import io.github.jroy.happybot.commands.base.CommandEvent;

public class CoinFlipCommand extends CommandBase {

    public CoinFlipCommand() {
        super("coinflip", null, "Flips a coin.", CommandCategory.FUN);
        this.aliases = new String[]{"flipcoin"};
    }

    @Override
    protected void executeCommand(CommandEvent e) {
        double random = Math.random();
        if (random < 0.5) {
            e.reply("Heads!");
        } else {
            e.reply("Tails!");
        }
    }
}
