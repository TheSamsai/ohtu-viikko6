package statistics.matcher;

import statistics.Player;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        return this.matcher;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher,
                            new PlaysIn(team)
                        );
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String field) {
        this.matcher = new And(matcher,
                            new HasAtLeast(value, field)
                        );
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String field) {
        this.matcher = new And(matcher,
                            new HasFewerThan(value, field)
                        );
        return this;
    }
}
