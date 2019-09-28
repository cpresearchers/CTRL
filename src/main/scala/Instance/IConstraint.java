package Instance;

public abstract class IConstraint extends IBase {
    IVariable[] scope;
    ConstraintType type;

    public IConstraint(int id, String name, IVariable[] scope, ConstraintType type) {
        super(id, name);
        this.scope = scope;
        this.type = type;
    }

    public void Show() {

    }
}
