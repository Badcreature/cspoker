package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>ground/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_ground_1 extends Predicate {

    public Term arg1;

    public PRED_ground_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_ground_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "ground(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
    // ground(A):-ground(A)
        engine.setB0();
        Term a1;
        a1 = arg1;
    // ground(A):-[ground(A)]
        //START inline expansion of ground(a(1))
        a1 = a1.dereference();
        if (! a1.isGround()) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}
