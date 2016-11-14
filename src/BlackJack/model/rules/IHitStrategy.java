package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IHitStrategy extends IStrategy {
    boolean DoHit(Player a_dealer);
}