package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>compare/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_compare_3 extends Predicate {

    public Term arg1, arg2, arg3;

    public PRED_compare_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_compare_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "compare(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
    // compare(A,B,C):-'$compare0'(D,B,C),'$map_compare_op'(D,A)
        engine.setB0();
        Term a1, a2, a3, a4;
        Predicate p1;
        a1 = arg1;
        a2 = arg2;
        a3 = arg3;
    // compare(A,B,C):-['$compare0'(D,B,C),'$map_compare_op'(D,A)]
        a4 = new VariableTerm(engine);
        p1 = new PRED_$map_compare_op_2(a4, a1, cont);
        return new PRED_$compare0_3(a4, a2, a3, p1);
    }
}
