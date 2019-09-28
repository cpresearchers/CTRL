package Instance;

public class IAllDifferent extends IConstraint {
    public IAllDifferent(int id, String name, IVariable[] scope) {
        super(id, name, scope, ConstraintType.allDifferent);
    }

    @Override
    public void Show() {
        ITools.P("id: " + id + " type: allDifferent arity: " + scope.length + " scope = ");
        for (var v : scope) {
            ITools.P(v.id + " ");
        }
        ITools.Pn();
    }
}
