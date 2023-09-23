public enum Jours {
    LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE;

    public Jours Lendemain (Jours j) {
        switch (j) {
            case LUNDI      : return Jours.MARDI;
            case MARDI      : return Jours.MERCREDI;
            case MERCREDI   : return Jours.JEUDI ;
            case JEUDI      : return Jours.VENDREDI;
            case VENDREDI   : return Jours.SAMEDI ;
            case SAMEDI     : return Jours.DIMANCHE ;
            default         : return Jours.LUNDI ;
            } 
    }
}
