package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$dummy_33_builtins.pl'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$dummy_33_builtins$002Epl_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");
    static Predicate _$dummy_33_builtins$002Epl_3_sub_1 = new PRED_$dummy_33_builtins$002Epl_3_sub_1();
    static Predicate _$dummy_33_builtins$002Epl_3_1 = new PRED_$dummy_33_builtins$002Epl_3_1();
    static Predicate _$dummy_33_builtins$002Epl_3_2 = new PRED_$dummy_33_builtins$002Epl_3_2();

    public Term arg1, arg2, arg3;

    public PRED_$dummy_33_builtins$002Epl_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$dummy_33_builtins$002Epl_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$dummy_33_builtins.pl(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$dummy_33_builtins$002Epl_3_1, _$dummy_33_builtins$002Epl_3_sub_1);
    }
}

class PRED_$dummy_33_builtins$002Epl_3_sub_1 extends PRED_$dummy_33_builtins$002Epl_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dummy_33_builtins$002Epl_3_2);
    }
}

class PRED_$dummy_33_builtins$002Epl_3_1 extends PRED_$dummy_33_builtins$002Epl_3 {
    public Predicate exec(Prolog engine) {
    // '$dummy_33_builtins.pl'(A,B,C):-C=[]
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$dummy_33_builtins.pl'(A,B,C):-['$unify'(C,[])]
        //START inline expansion of $unify(a(3),s(1))
        if (! a3.unify(s1, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$dummy_33_builtins$002Epl_3_2 extends PRED_$dummy_33_builtins$002Epl_3 {
    public Predicate exec(Prolog engine) {
    // '$dummy_33_builtins.pl'(A,B,C):-C=[B|A]
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$dummy_33_builtins.pl'(A,B,C):-['$unify'(C,[B|A])]
        a4 = new ListTerm(a2, a1);
        //START inline expansion of $unify(a(3),a(4))
        if (! a3.unify(a4, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}
