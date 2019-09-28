package Instance;

import org.xcsp.common.Types;
import org.xcsp.parser.callbacks.XCallbacks2;
import org.xcsp.parser.entries.XVariables;

import java.util.*;

public class IModel implements XCallbacks2 {

    private Implem implem = new Implem(this);
    public String filePath;
    public String fileName;
    public ArrayList<IVariable> Vars = new ArrayList<>();
    public ArrayList<IConstraint> Cons = new ArrayList<>();
    //    public boolean need_positive;
    public int maxArity = Integer.MIN_VALUE;
    public int maxDomainSize = Integer.MIN_VALUE;
    public int minDomainSize = Integer.MAX_VALUE;
//    public int maxTuplesSize = Integer.MIN_VALUE;
//    public double avg_tuples_size = Double.MIN_VALUE;

    protected Map<String, IVariable> vars_map = new LinkedHashMap<>();

    @Override
    public Implem implem() {
        return implem;
    }

    public IModel(String fileName) throws Exception {
        loadInstance(fileName);
    }

    @Override
    public void buildVarInteger(XVariables.XVarInteger x, int[] values) {
        IVariable v = new IVariable(Vars.size(), x.id, values);
        vars_map.put(v.name, v);
        Vars.add(v);
        maxDomainSize = Math.max(maxDomainSize, v.values.length);
        minDomainSize = Math.min(minDomainSize, v.values.length);
    }

    @Override
    public void buildVarInteger(XVariables.XVarInteger x, int minValue, int maxValue) {
        IVariable v = new IVariable(Vars.size(), x.id, minValue, maxValue);
        vars_map.put(v.name, v);
        Vars.add(v);
        maxDomainSize = Math.max(maxDomainSize, v.values.length);
        minDomainSize = Math.min(minDomainSize, v.values.length);
    }

    @Override
    public void buildCtrExtension(String id, XVariables.XVarInteger[] list, int[][] tuples, boolean positive, Set<Types.TypeFlag> flags) {
//        Instance.IVariable[] vs = new Instance.IVariable[list.length];
//        for (int i = 0; i < list.length; i++) {
//            vs[i] = vars_map.get(list[i].id);
//        }

        IExtension c = new IExtension(Cons.size(), id, getScope(list), positive, tuples);
        Cons.add(c);
        maxArity = Math.max(maxArity, c.scope.length);
    }

    @Override
    public void buildCtrAllDifferent(String id, XVariables.XVarInteger[] list) {
//        System.out.println(id);
//        for (var v : list) {
//            System.out.println("\t" + v.id);
//        }
//
//        Instance.IVariable[] vs = new Instance.IVariable[list.length];
//        for (int i = 0; i < list.length; i++) {
//            vs[i] = vars_map.get(list[i].id);
//        }


        IAllDifferent c = new IAllDifferent(Cons.size(), id, getScope(list));
        Cons.add(c);
        maxArity = Math.max(maxArity, c.scope.length);
    }

    private IVariable[] getScope(XVariables.XVarInteger[] list) {
        IVariable[] vs = new IVariable[list.length];
        for (int i = 0; i < list.length; i++) {
            vs[i] = vars_map.get(list[i].id);
        }

        return vs;
    }

    public void Show() {
        ITools.Pn("-------------------Show Model-------------------");
        ITools.Pn("show model: numVars = " + Vars.size());
        Vars.forEach(e -> e.Show());
        ITools.Pn("show model: numTabs = " + Cons.size());
        Cons.forEach(e -> e.Show());
        ITools.Pn("------------------------------------------------");
    }
    //    public String name;
}
