package pl.edu.agh.model.HTML;

import pl.droidsonroids.jspoon.annotation.Selector;

class Niezaznaczona {
    @Selector("td.info-list-label")
    String label;
    @Selector("td.info-list-value")
    String value;
}

