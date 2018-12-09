package statistics.matcher;

import statistics.Player;

public class QueryBuilder {

    private Matcher matcher;

    public QueryBuilder() {
        this.matcher = new All();
    }

    public Matcher build() {
        Matcher newMatcher = this.matcher;
        this.matcher = new All();

        return newMatcher;
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

    public QueryBuilder not(Matcher matcher) {
        this.matcher = new And(this.matcher,
                            new Not(matcher)
                        );

        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);

        return this;
    }
}
