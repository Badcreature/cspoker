package jp.ac.kobe_u.cs.prolog.builtin;
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
 <code>'$dummy_31_builtins.pl'/5</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$dummy_31_builtins$002Epl_5 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("type_error", 4);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("instantiation_error", 2);
    static Predicate _$dummy_31_builtins$002Epl_5_sub_1 = new PRED_$dummy_31_builtins$002Epl_5_sub_1();
    static Predicate _$dummy_31_builtins$002Epl_5_1 = new PRED_$dummy_31_builtins$002Epl_5_1();
    static Predicate _$dummy_31_builtins$002Epl_5_2 = new PRED_$dummy_31_builtins$002Epl_5_2();

    public Term arg1, arg2, arg3, arg4, arg5;

    public PRED_$dummy_31_builtins$002Epl_5(Term a1, Term a2, Term a3, Term a4, Term a5, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        this.cont = cont;
    }

    public PRED_$dummy_31_builtins$002Epl_5(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        arg5 = args[4];
        this.cont = cont;
    }

    public int arity() { return 5; }

    public String toString() {
        return "$dummy_31_builtins.pl(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.aregs[5] = arg5;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$dummy_31_builtins$002Epl_5_1, _$dummy_31_builtins$002Epl_5_sub_1);
    }
}

class PRED_$dummy_31_builtins$002Epl_5_sub_1 extends PRED_$dummy_31_builtins$002Epl_5 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dummy_31_builtins$002Epl_5_2);
    }
}

class PRED_$dummy_31_builtins$002Epl_5_1 extends PRED_$dummy_31_builtins$002Epl_5 {
    public Predicate exec(Prolog engine) {
    // '$dummy_31_builtins.pl'(A,B,C,D,E):-nonvar(E),!,C=type_error(D,A,B,E)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$dummy_31_builtins.pl'(A,B,C,D,E):-['$get_level'(F),nonvar(E),'$cut'(F),'$unify'(C,type_error(D,A,B,E))]
        a6 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(6))
        if (! a6.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of nonvar(a(5))
        a5 = a5.dereference();
        if (a5.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(6))
        a6 = a6.dereference();
        if (! a6.isInteger()) {
            throw new IllegalTypeException("integer", a6);
        } else {
            engine.cut(((IntegerTerm) a6).intValue());
        }
        //END inline expansion
        Term[] y1 = {a4, a1, a2, a5};
        a7 = new StructureTerm(s1, y1);
        //START inline expansion of $unify(a(3),a(7))
        if (! a3.unify(a7, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$dummy_31_builtins$002Epl_5_2 extends PRED_$dummy_31_builtins$002Epl_5 {
    public Predicate exec(Prolog engine) {
    // '$dummy_31_builtins.pl'(A,B,C,D,E):-C=instantiation_error(D,A)
        Term a1, a2, a3, a4, a5, a6;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$dummy_31_builtins.pl'(A,B,C,D,E):-['$unify'(C,instantiation_error(D,A))]
        Term[] y1 = {a4, a1};
        a6 = new StructureTerm(s2, y1);
        //START inline expansion of $unify(a(3),a(6))
        if (! a3.unify(a6, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}
