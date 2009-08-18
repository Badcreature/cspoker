package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>fail/0</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_fail_0 extends Predicate {

    public PRED_fail_0(Predicate cont) {
        this.cont = cont;
    }

    public PRED_fail_0(){}

    public void setArgument(Term[] args, Predicate cont) {
        this.cont = cont;
    }

    public int arity() { return 0; }

    public String toString() {
        return "fail";
    }

    public Predicate exec(Prolog engine) {
    // fail:-fail
        engine.setB0();
    // fail:-[fail]
        //START inline expansion of fail
        return engine.fail();
        //END inline expansion
    }
}
