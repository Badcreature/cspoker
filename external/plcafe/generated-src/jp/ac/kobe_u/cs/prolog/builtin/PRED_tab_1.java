package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>tab/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_tab_1 extends Predicate {

    public Term arg1;

    public PRED_tab_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_tab_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "tab(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
    // tab(A):-current_output(B),tab(B,A)
        engine.setB0();
        Term a1, a2;
        Predicate p1;
        a1 = arg1;
    // tab(A):-[current_output(B),tab(B,A)]
        a2 = new VariableTerm(engine);
        p1 = new PRED_tab_2(a2, a1, cont);
        return new PRED_current_output_1(a2, p1);
    }
}
