package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Arithmetic;
import jp.ac.kobe_u.cs.prolog.lang.BuiltinException;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>put/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_put_2 extends Predicate {

    public Term arg1, arg2;

    public PRED_put_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_put_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "put(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
    // put(A,B):-C is B,put_code(A,C)
        engine.setB0();
        Term a1, a2, a3;
        a1 = arg1;
        a2 = arg2;
    // put(A,B):-[C is B,put_code(A,C)]
        a3 = new VariableTerm(engine);
        //START inline expansion of a(3)is a(2)
        try {
            if (! a3.unify(Arithmetic.evaluate(a2), engine.trail)) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        return new PRED_put_code_2(a1, a3, cont);
    }
}
