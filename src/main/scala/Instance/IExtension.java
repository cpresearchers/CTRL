package Instance;

public class IExtension extends IConstraint {
    public int[][] tuples;
    public boolean positive;

    public IExtension(int id, String name, IVariable[] scope, boolean positive, int[][] tuples) {
        super(id, name, scope, ConstraintType.extension);
        this.positive = positive;
        this.tuples = tuples;
    }

    @Override
    public void Show() {
        String sem = positive ? "supports" : "conflicts";
        ITools.P("id: " + id + " type: extension semantics: " + sem + " size: " + tuples.length + " arity: " + scope.length + " scope = ");
        for (var v : scope) {
            ITools.P(v.id + " ");
        }
        ITools.Pn();
        ITools.Pn(tuples);
    }
}
