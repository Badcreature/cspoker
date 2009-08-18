package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.IllegalTypeException;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.ListTerm;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$dummy_25_builtins.pl'/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$dummy_25_builtins$002Epl_1 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("off");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("info");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("debug");
    static SymbolTerm s4 = SymbolTerm.makeSymbol("[]");
    static ListTerm s5 = new ListTerm(s3, s4);
    static Predicate _$dummy_25_builtins$002Epl_1_sub_1 = new PRED_$dummy_25_builtins$002Epl_1_sub_1();
    static Predicate _$dummy_25_builtins$002Epl_1_1 = new PRED_$dummy_25_builtins$002Epl_1_1();
    static Predicate _$dummy_25_builtins$002Epl_1_2 = new PRED_$dummy_25_builtins$002Epl_1_2();

    public Term arg1;

    public PRED_$dummy_25_builtins$002Epl_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_$dummy_25_builtins$002Epl_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "$dummy_25_builtins.pl(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$dummy_25_builtins$002Epl_1_1, _$dummy_25_builtins$002Epl_1_sub_1);
    }
}

class PRED_$dummy_25_builtins$002Epl_1_sub_1 extends PRED_$dummy_25_builtins$002Epl_1 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dummy_25_builtins$002Epl_1_2);
    }
}

class PRED_$dummy_25_builtins$002Epl_1_1 extends PRED_$dummy_25_builtins$002Epl_1 {
    public Predicate exec(Prolog engine) {
    // '$dummy_25_builtins.pl'(A):-A==off,!,true
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$dummy_25_builtins.pl'(A):-['$get_level'(B),'$equality_of_term'(A,off),'$cut'(B)]
        a2 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(2))
        if (! a2.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $equality_of_term(a(1),s(1))
        a1 = a1.dereference();
        if (! a1.equals(s1)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(2))
        a2 = a2.dereference();
        if (! a2.isInteger()) {
            throw new IllegalTypeException("integer", a2);
        } else {
            engine.cut(((IntegerTerm) a2).intValue());
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$dummy_25_builtins$002Epl_1_2 extends PRED_$dummy_25_builtins$002Epl_1 {
    public Predicate exec(Prolog engine) {
    // '$dummy_25_builtins.pl'(A):-print_message(info,[debug])
        Term a1;
        Predicate cont;
        a1 = engine.aregs[1];
        cont = engine.cont;
    // '$dummy_25_builtins.pl'(A):-[print_message(info,[debug])]
        return new PRED_print_message_2(s2, s5, cont);
    }
}
