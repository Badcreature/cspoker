package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.Predicate;
import jp.ac.kobe_u.cs.prolog.lang.Prolog;
import jp.ac.kobe_u.cs.prolog.lang.StructureTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.Term;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>','/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_$002C_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("jp.ac.kobe_u.cs.prolog.builtin");

    public Term arg1, arg2;

    public PRED_$002C_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$002C_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return ",(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
    // A,B:-call(A),call(B)
        engine.setB0();
        Term a1, a2, a3, a4;
        Predicate p1;
        a1 = arg1;
        a2 = arg2;
    // A,B:-[call('jp.ac.kobe_u.cs.prolog.builtin':A),call('jp.ac.kobe_u.cs.prolog.builtin':B)]
        Term[] y1 = {s2, a1};
        a3 = new StructureTerm(s1, y1);
        Term[] y2 = {s2, a2};
        a4 = new StructureTerm(s1, y2);
        p1 = new PRED_call_1(a4, cont);
        return new PRED_call_1(a3, p1);
    }
}