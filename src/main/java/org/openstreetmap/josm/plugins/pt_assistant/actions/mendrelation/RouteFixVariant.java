package org.openstreetmap.josm.plugins.pt_assistant.actions.mendrelation;

import java.awt.Color;
import java.util.function.Function;

import org.openstreetmap.josm.plugins.pt_assistant.utils.ColorPalette;
import org.openstreetmap.josm.tools.I18n;

public enum RouteFixVariant {
    REMOVE_WAYS(ColorPalette.GREEN, 'A', '1', __ -> I18n.marktr("Remove ways")),
    NOT_REMOVE_WAYS(ColorPalette.RED, 'B', '2', __ -> I18n.marktr("Do not remove ways")),
    REMOVE_WAYS_WITH_PREVIOUS_WAY(ColorPalette.CYAN, 'R', '3', __ -> I18n.marktr("Remove ways along with previous way")),
    ADD_ONEWAY_VEHICLE_NO_TO_WAY(ColorPalette.YELLOW, 'C', '4', it -> it instanceof PersonalTransportMendRelationAction ? I18n.marktr("Add oneway:bicycle=no to way") : I18n.marktr("Add oneway:bus=no to way")),
    TURN_BY_TURN_NEXT_INTERSECTION(ColorPalette.ORANGE, 'W', '0', it -> it.shorterRoutes ? I18n.marktr("solutions based on other route relations") : I18n.marktr("turn-by-turn at next intersection")),
    SKIP(ColorPalette.WHITE, 'S', '7', __ -> I18n.marktr("Skip")),
    BACKTRACK_WHITE_EDGE(ColorPalette.WHITE, 'V', '8', __ -> I18n.marktr("Split white edge")),
    REMOVE_CURRENT_EDGE(ColorPalette.WHITE, 'Q', '9', __ -> I18n.marktr("Remove current edge (white)"));

    private final char alphabeticCharacter;
    private final Color color;
    private final Function<? super AbstractMendRelation, String> description;
    private final char numericCharacter;

    RouteFixVariant(final Color color, final char alphabeticCharacter, final char numericCharacter, final Function<? super AbstractMendRelation, String> description) {
        this.color = color;
        this.alphabeticCharacter = alphabeticCharacter;
        this.numericCharacter = numericCharacter;
        this.description = description;
    }

    public char getAlphabeticCharacter() {
        return alphabeticCharacter;
    }

    public Color getColor() {
        return color;
    }

    public String getDescription(final AbstractMendRelation forObject) {
        return description.apply(forObject);
    }

    public char getNumericCharacter() {
        return numericCharacter;
    }
}
