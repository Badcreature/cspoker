package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Arithmetic;
import jp.ac.kobe_u.cs.prolog.lang.BuiltinException;
import jp.ac.kobe_u.cs.prolog.lang.IllegalTypeException;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.StructureTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>op/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_op_3 extends Predicate {
    static IntegerTerm si1 = new IntegerTerm(0);
    static IntegerTerm si2 = new IntegerTerm(1200);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("domain", 2);
    static SymbolTerm s4 = SymbolTerm.makeSymbol("integer");
    static SymbolTerm s5 = SymbolTerm.makeSymbol("-", 2);
    static Term[] s6 = {si1, si2};
    static StructureTerm s7 = new StructureTerm(s5, s6);
    static Term[] s8 = {s4, s7};
    static StructureTerm s9 = new StructureTerm(s3, s8);
    static SymbolTerm s10 = SymbolTerm.makeSymbol("op", 3);
    static IntegerTerm si11 = new IntegerTerm(1);
    static Predicate _op_3_sub_1 = new PRED_op_3_sub_1();
    static Predicate _op_3_1 = new PRED_op_3_1();
    static Predicate _op_3_2 = new PRED_op_3_2();

    public Term arg1, arg2, arg3;

    public PRED_op_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_op_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "op(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_op_3_1, _op_3_sub_1);
    }
}

class PRED_op_3_sub_1 extends PRED_op_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_op_3_2);
    }
}

class PRED_op_3_1 extends PRED_op_3 {
    public Predicate exec(Prolog engine) {
    // op(A,B,C):-integer(A),0=<A,A=<1200,!,'$op1'(A,B,C)
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // op(A,B,C):-['$get_level'(D),integer(A),'$less_or_equal'(0,A),'$less_or_equal'(A,1200),'$cut'(D),'$op1'(A,B,C)]
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of integer(a(1))
        a1 = a1.dereference();
        if (! a1.isInteger()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $less_or_equal(si(1),a(1))
        try {
            if (si1.arithCompareTo(Arithmetic.evaluate(a1)) > 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        //START inline expansion of $less_or_equal(a(1),si(2))
        try {
            if (Arithmetic.evaluate(a1).arithCompareTo(si2) > 0) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        //START inline expansion of $cut(a(4))
        a4 = a4.dereference();
        if (! a4.isInteger()) {
            throw new IllegalTypeException("integer", a4);
        } else {
            engine.cut(((IntegerTerm) a4).intValue());
        }
        //END inline expansion
        return new PRED_$op1_3(a1, a2, a3, cont);
    }
}

class PRED_op_3_2 extends PRED_op_3 {
    public Predicate exec(Prolog engine) {
    // op(A,B,C):-illarg(domain(integer,0-1200),op(A,B,C),1)
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // op(A,B,C):-[illarg(domain(integer,0-1200),op(A,B,C),1)]
        Term[] y1 = {a1, a2, a3};
        a4 = new StructureTerm(s10, y1);
        return new PRED_illarg_3(s9, a4, si11, cont);
    }
}