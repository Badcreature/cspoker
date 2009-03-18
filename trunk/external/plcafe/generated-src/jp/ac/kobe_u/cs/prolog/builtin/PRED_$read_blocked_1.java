package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$read_blocked'/1</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$read_blocked_1 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(" ? ");

    public Term arg1;

    public PRED_$read_blocked_1(Term a1, Predicate cont) {
        arg1 = a1;
        this.cont = cont;
    }

    public PRED_$read_blocked_1(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        this.cont = cont;
    }

    public int arity() { return 1; }

    public String toString() {
        return "$read_blocked(" + arg1 + ")";
    }

    public Predicate exec(Prolog engine) {
    // '$read_blocked'(A):-'$fast_write'(' ? '),flush_output,read_line(B),'$dummy_28_builtins.pl'(B,C,D),'$debug_option'(C,A)
        engine.setB0();
        Term a1, a2, a3;
        Predicate p1, p2, p3, p4;
        a1 = arg1;
    // '$read_blocked'(A):-['$fast_write'(' ? '),flush_output,read_line(B),'$dummy_28_builtins.pl'(B,C,D),'$debug_option'(C,A)]
        a2 = new VariableTerm(engine);
        a3 = new VariableTerm(engine);
        p1 = new PRED_$debug_option_2(a3, a1, cont);
        p2 = new PRED_$dummy_28_builtins$002Epl_3(a2, a3, new VariableTerm(engine), p1);
        p3 = new PRED_read_line_1(a2, p2);
        p4 = new PRED_flush_output_0(p3);
        return new PRED_$fast_write_1(s1, p4);
    }
}
