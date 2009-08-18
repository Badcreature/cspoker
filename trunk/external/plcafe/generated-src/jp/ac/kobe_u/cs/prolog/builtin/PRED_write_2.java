package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.ListTerm;
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
 <code>write/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_write_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("numbervars", 1);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("true");
    static Term[] s3 = {s2};
    static StructureTerm s4 = new StructureTerm(s1, s3);
    static SymbolTerm s5 = SymbolTerm.makeSymbol("[]");
    static ListTerm s6 = new ListTerm(s4, s5);

    public Term arg1, arg2;

    public PRED_write_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_write_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "write(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
    // write(A,B):-write_term(A,B,[numbervars(true)])
        engine.setB0();
        Term a1, a2;
        a1 = arg1;
        a2 = arg2;
    // write(A,B):-[write_term(A,B,[numbervars(true)])]
        return new PRED_write_term_3(a1, a2, s6, cont);
    }
}
