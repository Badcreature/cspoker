package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.ListTerm;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>builtin_java_convert_args/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_builtin_java_convert_args_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _builtin_java_convert_args_2_var = new PRED_builtin_java_convert_args_2_var();
    static Predicate _builtin_java_convert_args_2_var_1 = new PRED_builtin_java_convert_args_2_var_1();
    static Predicate _builtin_java_convert_args_2_1 = new PRED_builtin_java_convert_args_2_1();
    static Predicate _builtin_java_convert_args_2_2 = new PRED_builtin_java_convert_args_2_2();

    public Term arg1, arg2;

    public PRED_builtin_java_convert_args_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_builtin_java_convert_args_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "builtin_java_convert_args(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_builtin_java_convert_args_2_var, _fail_0, _fail_0, _builtin_java_convert_args_2_1, _fail_0, _builtin_java_convert_args_2_2);
    }
}

class PRED_builtin_java_convert_args_2_var extends PRED_builtin_java_convert_args_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_builtin_java_convert_args_2_1, _builtin_java_convert_args_2_var_1);
    }
}

class PRED_builtin_java_convert_args_2_var_1 extends PRED_builtin_java_convert_args_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_builtin_java_convert_args_2_2);
    }
}

class PRED_builtin_java_convert_args_2_1 extends PRED_builtin_java_convert_args_2 {
    public Predicate exec(Prolog engine) {
    // builtin_java_convert_args([],[]):-!
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // builtin_java_convert_args([],[]):-['$neck_cut']
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s1))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s1))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_builtin_java_convert_args_2_2 extends PRED_builtin_java_convert_args_2 {
    public Predicate exec(Prolog engine) {
    // builtin_java_convert_args([A|B],[C|D]):-java_conversion(A,C),builtin_java_convert_args(B,D)
        Term a1, a2, a3, a4, a5, a6;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // builtin_java_convert_args([A|B],[C|D]):-[java_conversion(A,C),builtin_java_convert_args(B,D)]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a3 = args[0];
            a4 = args[1];
        } else if (a1.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a3, a4), engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isList()){
            Term[] args = {((ListTerm)a2).car(), ((ListTerm)a2).cdr()};
            a5 = args[0];
            a6 = args[1];
        } else if (a2.isVariable()){
            a5 = new VariableTerm(engine);
            a6 = new VariableTerm(engine);
            ((VariableTerm) a2).bind(new ListTerm(a5, a6), engine.trail);
        } else {
            return engine.fail();
        }
        p1 = new PRED_builtin_java_convert_args_2(a4, a6, cont);
        return new PRED_java_conversion_2(a3, a5, p1);
    }
}
