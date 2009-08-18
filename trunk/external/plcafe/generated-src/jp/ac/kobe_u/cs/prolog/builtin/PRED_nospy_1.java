package jp.ac.kobe_u.cs.prolog.builtin;
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
 <code>nospy/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_nospy_1 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("nospy", 1);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("leap");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("no");

    public Term arg1;

    public PRED_nospy_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_nospy_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "nospy(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
    // nospy(A):-'$term_to_predicateindicator'(A,B,nospy(A)),'$retract_spypoint'(B),'$set_debug_flag'(leap,no),!
        engine.setB0();
        Term a1, a2, a3, a4;
        Predicate p1, p2, p3;
        a1 = arg1;
    // nospy(A):-['$get_level'(B),'$term_to_predicateindicator'(A,C,nospy(A)),'$retract_spypoint'(C),'$set_debug_flag'(leap,no),'$cut'(B)]
        a2 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(2))
        if (! a2.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a3 = new VariableTerm(engine);
        Term[] y1 = {a1};
        a4 = new StructureTerm(s1, y1);
        p1 = new PRED_$cut_1(a2, cont);
        p2 = new PRED_$set_debug_flag_2(s2, s3, p1);
        p3 = new PRED_$retract_spypoint_1(a3, p2);
        return new PRED_$term_to_predicateindicator_3(a1, a3, a4, p3);
    }
}
