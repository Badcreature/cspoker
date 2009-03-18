package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$existential_variables_set'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$existential_variables_set_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");

    public Term arg1, arg2;

    public PRED_$existential_variables_set_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$existential_variables_set_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$existential_variables_set(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$existential_variables_set'(A,B):-'$existential_variables_set'(A,[],B)
        engine.setB0();
        Term a1, a2;
        a1 = arg1;
        a2 = arg2;
    // '$existential_variables_set'(A,B):-['$existential_variables_set'(A,[],B)]
        return new PRED_$existential_variables_set_3(a1, s1, a2, cont);
    }
}
