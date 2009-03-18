package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>== /2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_$003D$003D_2 extends Predicate {

    public Term arg1, arg2;

    public PRED_$003D$003D_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$003D$003D_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "==(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
    // A==B:-A==B
        engine.setB0();
        Term a1, a2;
        a1 = arg1;
        a2 = arg2;
    // A==B:-['$equality_of_term'(A,B)]
        //START inline expansion of $equality_of_term(a(1),a(2))
        a1 = a1.dereference();
        a2 = a2.dereference();
        if (! a1.equals(a2)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}
