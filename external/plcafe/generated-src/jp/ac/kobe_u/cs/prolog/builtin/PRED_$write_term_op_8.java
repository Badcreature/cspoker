package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$write_term_op'/8</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$write_term_op_8 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("punct");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("(");
    static SymbolTerm s3 = SymbolTerm.makeSymbol(")");
    static Predicate _$write_term_op_8_sub_1 = new PRED_$write_term_op_8_sub_1();
    static Predicate _$write_term_op_8_1 = new PRED_$write_term_op_8_1();
    static Predicate _$write_term_op_8_2 = new PRED_$write_term_op_8_2();

    public Term arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8;

    public PRED_$write_term_op_8(Term a1, Term a2, Term a3, Term a4, Term a5, Term a6, Term a7, Term a8, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        arg6 = a6;
        arg7 = a7;
        arg8 = a8;
        this.cont = cont;
    }

    public PRED_$write_term_op_8(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        arg5 = args[4];
        arg6 = args[5];
        arg7 = args[6];
        arg8 = args[7];
        this.cont = cont;
    }

    public int arity() { return 8; }

    public String toString() {
        return "$write_term_op(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + "," + arg6 + "," + arg7 + "," + arg8 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.aregs[5] = arg5;
        engine.aregs[6] = arg6;
        engine.aregs[7] = arg7;
        engine.aregs[8] = arg8;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$write_term_op_8_1, _$write_term_op_8_sub_1);
    }
}

class PRED_$write_term_op_8_sub_1 extends PRED_$write_term_op_8 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_term_op_8_2);
    }
}

class PRED_$write_term_op_8_1 extends PRED_$write_term_op_8 {
    public Predicate exec(Prolog engine) {
    // '$write_term_op'(A,B,C,D,E,punct,F,G):-current_op(H,B,A),H>D,!,'$write_space_if_needed'(E,punct,G),put_char(G,'('),'$write_term_op1'(A,B,C,H,punct,I,F,G),put_char(G,')')
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;
        Predicate p1, p2, p3, p4, p5, p6;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        a6 = engine.aregs[6];
        a7 = engine.aregs[7];
        a8 = engine.aregs[8];
        cont = engine.cont;
    // '$write_term_op'(A,B,C,D,E,punct,F,G):-['$get_level'(H),current_op(I,B,A),'$greater_than'(I,D),'$cut'(H),'$write_space_if_needed'(E,punct,G),put_char(G,'('),'$write_term_op1'(A,B,C,I,punct,J,F,G),put_char(G,')')]
        a6 = a6.dereference();
        if (a6.isSymbol()){
            if (! a6.equals(s1))
                return engine.fail();
        } else if (a6.isVariable()){
            ((VariableTerm) a6).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        a9 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(9))
        if (! a9.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a10 = new VariableTerm(engine);
        p1 = new PRED_put_char_2(a8, s3, cont);
        p2 = new PRED_$write_term_op1_8(a1, a2, a3, a10, s1, new VariableTerm(engine), a7, a8, p1);
        p3 = new PRED_put_char_2(a8, s2, p2);
        p4 = new PRED_$write_space_if_needed_3(a5, s1, a8, p3);
        p5 = new PRED_$cut_1(a9, p4);
        p6 = new PRED_$greater_than_2(a10, a4, p5);
        return new PRED_current_op_3(a10, a2, a1, p6);
    }
}

class PRED_$write_term_op_8_2 extends PRED_$write_term_op_8 {
    public Predicate exec(Prolog engine) {
    // '$write_term_op'(A,B,C,D,E,F,G,H):-current_op(I,B,A),'$write_term_op1'(A,B,C,I,E,F,G,H)
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        a6 = engine.aregs[6];
        a7 = engine.aregs[7];
        a8 = engine.aregs[8];
        cont = engine.cont;
    // '$write_term_op'(A,B,C,D,E,F,G,H):-[current_op(I,B,A),'$write_term_op1'(A,B,C,I,E,F,G,H)]
        a9 = new VariableTerm(engine);
        p1 = new PRED_$write_term_op1_8(a1, a2, a3, a9, a5, a6, a7, a8, cont);
        return new PRED_current_op_3(a9, a2, a1, p1);
    }
}
