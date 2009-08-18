package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.StructureTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$meta_call'/4</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$meta_call_4 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("trace");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("/", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("interpret");
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _$meta_call_4_var = new PRED_$meta_call_4_var();
    static Predicate _$meta_call_4_var_1 = new PRED_$meta_call_4_var_1();
    static Predicate _$meta_call_4_con = new PRED_$meta_call_4_con();
    static Predicate _$meta_call_4_1 = new PRED_$meta_call_4_1();
    static Predicate _$meta_call_4_2 = new PRED_$meta_call_4_2();
    static java.util.Hashtable<Term, Predicate> con = new java.util.Hashtable<Term, Predicate>(2);
    static {
        con.put(s1, _$meta_call_4_1);
        con.put(s3, _$meta_call_4_2);
    }

    public Term arg1, arg2, arg3, arg4;

    public PRED_$meta_call_4(Term a1, Term a2, Term a3, Term a4, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        this.cont = cont;
    }

    public PRED_$meta_call_4(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        this.cont = cont;
    }

    public int arity() { return 4; }

    public String toString() {
        return "$meta_call(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$meta_call_4_var, _fail_0, _fail_0, _$meta_call_4_con, _fail_0, _fail_0);
    }
}

class PRED_$meta_call_4_var extends PRED_$meta_call_4 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$meta_call_4_1, _$meta_call_4_var_1);
    }
}

class PRED_$meta_call_4_var_1 extends PRED_$meta_call_4 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$meta_call_4_2);
    }
}

class PRED_$meta_call_4_con extends PRED_$meta_call_4 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(con, _fail_0);
    }
}

class PRED_$meta_call_4_1 extends PRED_$meta_call_4 {
    public Predicate exec(Prolog engine) {
    // '$meta_call'(trace,A,B,C):-!,functor(C,D,E),'$trace_goal'(C,B,D/E,A)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$meta_call'(trace,A,B,C):-['$neck_cut',functor(C,D,E),'$trace_goal'(C,B,D/E,A)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s1))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        a5 = new VariableTerm(engine);
        a6 = new VariableTerm(engine);
        Term[] y1 = {a5, a6};
        a7 = new StructureTerm(s2, y1);
        p1 = new PRED_$trace_goal_4(a4, a3, a7, a2, cont);
        return new PRED_functor_3(a4, a5, a6, p1);
    }
}

class PRED_$meta_call_4_2 extends PRED_$meta_call_4 {
    public Predicate exec(Prolog engine) {
    // '$meta_call'(interpret,A,B,C):-functor(C,D,E),'$call_internal'(C,B,D/E,A,interpret)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // '$meta_call'(interpret,A,B,C):-[functor(C,D,E),'$call_internal'(C,B,D/E,A,interpret)]
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s3))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s3, engine.trail);
        } else {
            return engine.fail();
        }
        a5 = new VariableTerm(engine);
        a6 = new VariableTerm(engine);
        Term[] y1 = {a5, a6};
        a7 = new StructureTerm(s2, y1);
        p1 = new PRED_$call_internal_5(a4, a3, a7, a2, s3, cont);
        return new PRED_functor_3(a4, a5, a6, p1);
    }
}
