package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$dummy_26_builtins.pl'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$dummy_26_builtins$002Epl_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("off");
    static SymbolTerm s2 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("user");
    static Predicate _$dummy_26_builtins$002Epl_2_sub_1 = new PRED_$dummy_26_builtins$002Epl_2_sub_1();
    static Predicate _$dummy_26_builtins$002Epl_2_1 = new PRED_$dummy_26_builtins$002Epl_2_1();
    static Predicate _$dummy_26_builtins$002Epl_2_2 = new PRED_$dummy_26_builtins$002Epl_2_2();

    public Term arg1, arg2;

    public PRED_$dummy_26_builtins$002Epl_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$dummy_26_builtins$002Epl_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$dummy_26_builtins.pl(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$dummy_26_builtins$002Epl_2_1, _$dummy_26_builtins$002Epl_2_sub_1);
    }
}

class PRED_$dummy_26_builtins$002Epl_2_sub_1 extends PRED_$dummy_26_builtins$002Epl_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dummy_26_builtins$002Epl_2_2);
    }
}

class PRED_$dummy_26_builtins$002Epl_2_1 extends PRED_$dummy_26_builtins$002Epl_2 {
    public Predicate exec(Prolog engine) {
    // '$dummy_26_builtins.pl'(A,B):-B==off,!,call(user:A)
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$dummy_26_builtins.pl'(A,B):-['$get_level'(C),'$equality_of_term'(B,off),'$cut'(C),call(user:A)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $equality_of_term(a(2),s(1))
        a2 = a2.dereference();
        if (! a2.equals(s1)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(3))
        a3 = a3.dereference();
        if (! a3.isInteger()) {
            throw new IllegalTypeException("integer", a3);
        } else {
            engine.cut(((IntegerTerm) a3).intValue());
        }
        //END inline expansion
        Term[] y1 = {s3, a1};
        a4 = new StructureTerm(s2, y1);
        return new PRED_call_1(a4, cont);
    }
}

class PRED_$dummy_26_builtins$002Epl_2_2 extends PRED_$dummy_26_builtins$002Epl_2 {
    public Predicate exec(Prolog engine) {
    // '$dummy_26_builtins.pl'(A,B):-'$trace_goal'(user:A)
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$dummy_26_builtins.pl'(A,B):-['$trace_goal'(user:A)]
        Term[] y1 = {s3, a1};
        a3 = new StructureTerm(s2, y1);
        return new PRED_$trace_goal_1(a3, cont);
    }
}
