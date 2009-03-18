package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$unify'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_$unify_2 extends Predicate {

    public Term arg1, arg2;

    public PRED_$unify_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$unify_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$unify(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$unify'(A,B):-'$unify'(A,B)
        engine.setB0();
        Term a1, a2;
        a1 = arg1;
        a2 = arg2;
    // '$unify'(A,B):-['$unify'(A,B)]
        //START inline expansion of $unify(a(1),a(2))
        if (! a1.unify(a2, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}
