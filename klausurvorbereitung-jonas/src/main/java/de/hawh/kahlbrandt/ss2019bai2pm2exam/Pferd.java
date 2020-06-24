package de.hawh.kahlbrandt.ss2019bai2pm2exam;

public class Pferd {

    private enum Gangart {
        STAND(0, 0, 1),
        SCHRITT(1, 0, 2),
        TRAB(2, 1, 3),
        GALOPP(3, 2, 3);

        private final int index;
        private final int vorherige;
        private final int naechste;

        Gangart(int index, int vorherige, int naechste) {
            this.index = index;
            this.vorherige = vorherige;
            this.naechste = naechste;
        }

        public Gangart schneller() {
            for (Gangart gangart : values()) {
                if (gangart.index == naechste) {
                    return gangart;
                }
            }
            return this;
        }

        public Gangart langsamer() {
            for (Gangart gangart : values()) {
                if (gangart.index == vorherige) {
                    return gangart;
                }
            }
            return this;
        }

        @Override
        public String toString() {
            return name();
        }
    }

    private enum Befehl {

        IGNORED("ungültiger Befehl"),
        BRR("Brr"),
        HUE("Hü");

        private final String name;

        Befehl(String name) {
            this.name = name;
        }

        public static Befehl getBefehlByName(String name) {
            for (Befehl befehl : values()) {
                if (befehl.name.equals(name)) {
                    return befehl;
                }
            }
            return IGNORED;
        }
    }

    private Gangart gangart;

    public Pferd() {
        gangart = Gangart.STAND;
    }

    public void befehl(String befehl) {
        switch (Befehl.getBefehlByName(befehl)) {
            case HUE:
                gangart = gangart.schneller();
                break;
            case BRR:
                gangart = gangart.langsamer();
                break;
            case IGNORED:
                // Nothing happens
                break;
        }
    }

    @Override
    public String toString() {
        return "Pferd{" +
                "gangart=" + gangart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pferd pferd = (Pferd) o;

        return gangart == pferd.gangart;
    }

    @Override
    public int hashCode() {
        return gangart != null ? gangart.hashCode() : 0;
    }

    public static void main(String[] args) {

        Pferd pferd = new Pferd();
        System.out.println(pferd);
        pferd.befehl("Hü");
        System.out.println(pferd);
        pferd.befehl("Hü");
        System.out.println(pferd);
        pferd.befehl("Hü");
        System.out.println(pferd);
        pferd.befehl("Hü");
        System.out.println(pferd);
        pferd.befehl("Hü");
        System.out.println(pferd);
        pferd.befehl("Hü");
        System.out.println(pferd);
        pferd.befehl("Brr");
        System.out.println(pferd);
        pferd.befehl("Friss");
        System.out.println(pferd);
    }
}
