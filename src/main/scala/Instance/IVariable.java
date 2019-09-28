package Instance;

public class IVariable extends IBase {
    public int[] values;

    public IVariable(int id, String name, int[] vals) {
        super(id, name);
        values = vals.clone();
    }

    public IVariable(int id, String name, int minValue, int maxValue) {
        super(id, name);
        values = new int[maxValue - minValue + 1];
        for (int i = minValue, j = 0; i <= maxValue; ++i, ++j) {
            values[j] = i;
        }
    }

    public void Show() {
        ITools.Pn("name: " + id + " name: " + name);
        ITools.Pn(values);
    }
}
