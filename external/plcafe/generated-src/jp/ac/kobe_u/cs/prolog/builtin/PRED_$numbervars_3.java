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
 <code>'$numbervars'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$numbervars_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("$VAR", 1);
    static IntegerTerm si2 = new IntegerTerm(1);
    static Predicate _$numbervars_3_sub_1 = new PRED_$numbervars_3_sub_1();
    static Predicate _$numbervars_3_sub_2 = new PRED_$numbervars_3_sub_2();
    static Predicate _$numbervars_3_sub_3 = new PRED_$numbervars_3_sub_3();
    static Predicate _$numbervars_3_1 = new PRED_$numbervars_3_1();
    static Predicate _$numbervars_3_2 = new PRED_$numbervars_3_2();
    static Predicate _$numbervars_3_3 = new PRED_$numbervars_3_3();
    static Predicate _$numbervars_3_4 = new PRED_$numbervars_3_4();

    public Term arg1, arg2, arg3;

    public PRED_$numbervars_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$numbervars_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$numbervars(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$numbervars_3_1, _$numbervars_3_sub_1);
    }
}

class PRED_$numbervars_3_sub_1 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$numbervars_3_2, _$numbervars_3_sub_2);
    }
}

class PRED_$numbervars_3_sub_2 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$numbervars_3_3, _$numbervars_3_sub_3);
    }
}

class PRED_$numbervars_3_sub_3 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$numbervars_3_4);
    }
}

class PRED_$numbervars_3_1 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
    // '$numbervars'(A,B,C):-var(A),!,A='$VAR'(B),C is B+1
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$numbervars'(A,B,C):-['$get_level'(D),var(A),'$cut'(D),'$unify'(A,'$VAR'(B)),'$plus'(B,1,C)]
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(1))
        a1 = a1.dereference();
        if (! a1.isVariable()) {
            return engine.fail();
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
        Term[] y1 = {a2};
        a5 = new StructureTerm(s1, y1);
        //START inline expansion of $unify(a(1),a(5))
        if (! a1.unify(a5, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $plus(a(2),si(2),a(3))
        try {
            if (! a3.unify(Arithmetic.evaluate(a2).add(si2), engine.trail)) {
                return engine.fail();
            }
        } catch (BuiltinException e) {
            e.goal = this;
            throw e;
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$numbervars_3_2 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
    // '$numbervars'(A,B,B):-atomic(A),!
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$numbervars'(A,B,B):-['$get_level'(C),atomic(A),'$cut'(C)]
        if (! a2.unify(a3, engine.trail))
            return engine.fail();
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of atomic(a(1))
        a1 = a1.dereference();
        if (! a1.isSymbol() && ! a1.isNumber()) {
            return engine.fail();
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
        return cont;
    }
}

class PRED_$numbervars_3_3 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
    // '$numbervars'(A,B,B):-java(A),!
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$numbervars'(A,B,B):-['$get_level'(C),java(A),'$cut'(C)]
        if (! a2.unify(a3, engine.trail))
            return engine.fail();
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of java(a(1))
        a1 = a1.dereference();
        if (! a1.isJavaObject()) {
            return engine.fail();
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
        return cont;
    }
}

class PRED_$numbervars_3_4 extends PRED_$numbervars_3 {
    public Predicate exec(Prolog engine) {
    // '$numbervars'(A,B,C):-functor(A,D,E),'$numbervars_str'(1,E,A,B,C)
        Term a1, a2, a3, a4;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$numbervars'(A,B,C):-[functor(A,D,E),'$numbervars_str'(1,E,A,B,C)]
        a4 = new VariableTerm(engine);
        p1 = new PRED_$numbervars_str_5(si2, a4, a1, a2, a3, cont);
        return new PRED_functor_3(a1, new VariableTerm(engine), a4, p1);
    }
}
