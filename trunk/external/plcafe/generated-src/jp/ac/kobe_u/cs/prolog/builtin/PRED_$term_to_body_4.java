package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$term_to_body'/4</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$term_to_body_4 extends Predicate {

    public Term arg1, arg2, arg3, arg4;

    public PRED_$term_to_body_4(Term a1, Term a2, Term a3, Term a4, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        this.cont = cont;
    }

    public PRED_$term_to_body_4(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        this.cont = cont;
    }

    public int arity() { return 4; }

    public String toString() {
        return "$term_to_body(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$term_to_body'(A,B,C,D):-'$localize_body'(A,C,B)
        engine.setB0();
        Term a1, a2, a3, a4;
        a1 = arg1;
        a2 = arg2;
        a3 = arg3;
        a4 = arg4;
    // '$term_to_body'(A,B,C,D):-['$localize_body'(A,C,B)]
        return new PRED_$localize_body_3(a1, a3, a2, cont);
    }
}
