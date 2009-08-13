package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$process_order'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$process_order_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("var");
    static SymbolTerm s2 = SymbolTerm.makeSymbol("?-", 1);
    static IntegerTerm si3 = new IntegerTerm(1);
    static SymbolTerm s4 = SymbolTerm.makeSymbol("end_of_file");
    static SymbolTerm s5 = SymbolTerm.makeSymbol("debug");
    static SymbolTerm s6 = SymbolTerm.makeSymbol("yes");
    static SymbolTerm s7 = SymbolTerm.makeSymbol("no");
    static Predicate _$process_order_2_var = new PRED_$process_order_2_var();
    static Predicate _$process_order_2_var_1 = new PRED_$process_order_2_var_1();
    static Predicate _$process_order_2_var_2 = new PRED_$process_order_2_var_2();
    static Predicate _$process_order_2_var_3 = new PRED_$process_order_2_var_3();
    static Predicate _$process_order_2_var_4 = new PRED_$process_order_2_var_4();
    static Predicate _$process_order_2_int = new PRED_$process_order_2_int();
    static Predicate _$process_order_2_int_1 = new PRED_$process_order_2_int_1();
    static Predicate _$process_order_2_int_2 = new PRED_$process_order_2_int_2();
    static Predicate _$process_order_2_con = new PRED_$process_order_2_con();
    static Predicate _$process_order_2_con_1 = new PRED_$process_order_2_con_1();
    static Predicate _$process_order_2_con_2 = new PRED_$process_order_2_con_2();
    static Predicate _$process_order_2_con_3 = new PRED_$process_order_2_con_3();
    static Predicate _$process_order_2_lis = new PRED_$process_order_2_lis();
    static Predicate _$process_order_2_lis_1 = new PRED_$process_order_2_lis_1();
    static Predicate _$process_order_2_lis_2 = new PRED_$process_order_2_lis_2();
    static Predicate _$process_order_2_lis_3 = new PRED_$process_order_2_lis_3();
    static Predicate _$process_order_2_1 = new PRED_$process_order_2_1();
    static Predicate _$process_order_2_2 = new PRED_$process_order_2_2();
    static Predicate _$process_order_2_3 = new PRED_$process_order_2_3();
    static Predicate _$process_order_2_4 = new PRED_$process_order_2_4();
    static Predicate _$process_order_2_5 = new PRED_$process_order_2_5();

    public Term arg1, arg2;

    public PRED_$process_order_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$process_order_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$process_order(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_$process_order_2_var, _$process_order_2_int, _$process_order_2_int, _$process_order_2_con, _$process_order_2_int, _$process_order_2_lis);
    }
}

class PRED_$process_order_2_var extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$process_order_2_1, _$process_order_2_var_1);
    }
}

class PRED_$process_order_2_var_1 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_2, _$process_order_2_var_2);
    }
}

class PRED_$process_order_2_var_2 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_3, _$process_order_2_var_3);
    }
}

class PRED_$process_order_2_var_3 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_4, _$process_order_2_var_4);
    }
}

class PRED_$process_order_2_var_4 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$process_order_2_5);
    }
}

class PRED_$process_order_2_int extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$process_order_2_1, _$process_order_2_int_1);
    }
}

class PRED_$process_order_2_int_1 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_4, _$process_order_2_int_2);
    }
}

class PRED_$process_order_2_int_2 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$process_order_2_5);
    }
}

class PRED_$process_order_2_con extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$process_order_2_1, _$process_order_2_con_1);
    }
}

class PRED_$process_order_2_con_1 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_2, _$process_order_2_con_2);
    }
}

class PRED_$process_order_2_con_2 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_4, _$process_order_2_con_3);
    }
}

class PRED_$process_order_2_con_3 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$process_order_2_5);
    }
}

class PRED_$process_order_2_lis extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$process_order_2_1, _$process_order_2_lis_1);
    }
}

class PRED_$process_order_2_lis_1 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_3, _$process_order_2_lis_2);
    }
}

class PRED_$process_order_2_lis_2 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$process_order_2_4, _$process_order_2_lis_3);
    }
}

class PRED_$process_order_2_lis_3 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$process_order_2_5);
    }
}

class PRED_$process_order_2_1 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
    // '$process_order'(A,B):-var(A),!,illarg(var,(?-A),1)
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$process_order'(A,B):-['$get_level'(C),var(A),'$cut'(C),illarg(var,(?-A),1)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(1))
        a1 = a1.dereference();
        if (! a1.isVariable()) {
            return engine.fail();
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
        Term[] y1 = {a1};
        a4 = new StructureTerm(s2, y1);
        return new PRED_illarg_3(s1, a4, si3, cont);
    }
}

class PRED_$process_order_2_2 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
    // '$process_order'(end_of_file,A):-!
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$process_order'(end_of_file,A):-['$neck_cut']
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s4))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s4, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_$process_order_2_3 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
    // '$process_order'([A|B],C):-!,consult([A|B])
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$process_order'([A|B],C):-['$neck_cut',consult([A|B])]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a3 = args[0];
            a4 = args[1];
        } else if (a1.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a3, a4), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        a5 = new ListTerm(a3, a4);
        return new PRED_consult_1(a5, cont);
    }
}

class PRED_$process_order_2_4 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
    // '$process_order'(A,B):-current_prolog_flag(debug,C),'$dummy_26_builtins.pl'(A,C),nl,'$rm_redundant_vars'(B,D),'$give_answers_with_prompt'(D),!,'$fast_write'(yes),nl
        Term a1, a2, a3, a4, a5;
        Predicate p1, p2, p3, p4, p5, p6, p7;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$process_order'(A,B):-['$get_level'(C),current_prolog_flag(debug,D),'$dummy_26_builtins.pl'(A,D),nl,'$rm_redundant_vars'(B,E),'$give_answers_with_prompt'(E),'$cut'(C),'$fast_write'(yes),nl]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a4 = new VariableTerm(engine);
        a5 = new VariableTerm(engine);
        p1 = new PRED_nl_0(cont);
        p2 = new PRED_$fast_write_1(s6, p1);
        p3 = new PRED_$cut_1(a3, p2);
        p4 = new PRED_$give_answers_with_prompt_1(a5, p3);
        p5 = new PRED_$rm_redundant_vars_2(a2, a5, p4);
        p6 = new PRED_nl_0(p5);
        p7 = new PRED_$dummy_26_builtins$002Epl_2(a1, a4, p6);
        return new PRED_current_prolog_flag_2(s5, a4, p7);
    }
}

class PRED_$process_order_2_5 extends PRED_$process_order_2 {
    public Predicate exec(Prolog engine) {
    // '$process_order'(A,B):-nl,'$fast_write'(no),nl
        Term a1, a2;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$process_order'(A,B):-[nl,'$fast_write'(no),nl]
        p1 = new PRED_nl_0(cont);
        p2 = new PRED_$fast_write_1(s7, p1);
        return new PRED_nl_0(p2);
    }
}