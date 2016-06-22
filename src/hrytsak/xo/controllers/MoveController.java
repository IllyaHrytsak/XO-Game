package hrytsak.xo.controllers;


import hrytsak.xo.model.Field;
import hrytsak.xo.model.Figure;
import hrytsak.xo.model.exception.AlreadyOccupiedException;
import hrytsak.xo.model.exception.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Figure figure,
                            final Point point) throws InvalidPointException,
                                                      AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);
    }

}
