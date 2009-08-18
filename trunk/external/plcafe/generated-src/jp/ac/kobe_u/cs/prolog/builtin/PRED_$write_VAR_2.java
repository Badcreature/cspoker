package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Arithmetic;
import jp.ac.kobe_u.cs.prolog.lang.BuiltinException;
import jp.ac.kobe_u.cs.prolog.lang.IllegalTypeException;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$write_VAR'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$write_VAR_2 extends Predicate {
    static IntegerTerm si1 = new IntegerTerm(26);
    static IntegerTerm si2 = new IntegerTerm(65);
    static Predicate _$write_VAR_2_sub_1 = new PRED_$write_VAR_2_sub_1();
    static Predicate _$write_VAR_2_1 = new PRED_$write_VAR_2_1();
    static Predicate _$write_VAR_2_2 = new PRED_$write_VAR_2_2();

    public Term arg1, arg2;

    public PRED_$write_VAR_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$write_VAR_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$write_VAR(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$write_VAR_2_1, _$write_VAR_2_sub_1);
    }
}

class PRED_$write_VAR_2_sub_1 extends PRED_$write_VAR_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_VAR_2_2);
    }
}

class PRED_$write_VAR_2_1 extends PRED_$write_VAR_2 {
    public Predicate exec(Prolog engine) {
    // '$write_VAR'(A,B):-A<26,!,C is A mod 26+[65],put_code(B,C)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$write_VAR'(A,B):-['$get_level'(C),'$less_than'(A,26),'$cut'(C),'$mod'(A,26,D),'$plus'(D,65,E),put_code(B,E)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $less_than(a(1),si(1))
        try {
            if (Arithmetic.evaluate(a1).arithCompareTo(si1) >= 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
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
        a4 = new VariableTerm(engine);
        //START inline expansion of $mod(a(1),si(1),a(4))
        try {
            if (! a4.unify(Arithmetic.evaluate(a1).mod(si1), engine.trail)) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        a5 = new VariableTerm(engine);
        //START inline expansion of $plus(a(4),si(2),a(5))
        try {
            if (! a5.unify(Arithmetic.evaluate(a4).add(si2), engine.trail)) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        return new PRED_put_code_2(a2, a5, cont);
    }
}

class PRED_$write_VAR_2_2 extends PRED_$write_VAR_2 {
    public Predicate exec(Prolog engine) {
    // '$write_VAR'(A,B):-C is A mod 26+[65],put_code(B,C),D is A//26,'$fast_write'(B,D)
        Term a1, a2, a3, a4, a5;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$write_VAR'(A,B):-['$mod'(A,26,C),'$plus'(C,65,D),put_code(B,D),'$int_quotient'(A,26,E),'$fast_write'(B,E)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $mod(a(1),si(1),a(3))
        try {
            if (! a3.unify(Arithmetic.evaluate(a1).mod(si1), engine.trail)) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        a4 = new VariableTerm(engine);
        //START inline expansion of $plus(a(3),si(2),a(4))
        try {
            if (! a4.unify(Arithmetic.evaluate(a3).add(si2), engine.trail)) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        a5 = new VariableTerm(engine);
        p1 = new PRED_$fast_write_2(a2, a5, cont);
        p2 = new PRED_$int_quotient_3(a1, si1, a5, p1);
        return new PRED_put_code_2(a2, a4, p2);
    }
}
