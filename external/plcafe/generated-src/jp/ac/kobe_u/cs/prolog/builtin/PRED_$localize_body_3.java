package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.IllegalTypeException;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.ListTerm;
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
 <code>'$localize_body'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$localize_body_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("call", 1);
    static SymbolTerm s2 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol(",", 2);
    static SymbolTerm s4 = SymbolTerm.makeSymbol("->", 2);
    static SymbolTerm s5 = SymbolTerm.makeSymbol(";", 2);
    static SymbolTerm s6 = SymbolTerm.makeSymbol("user");
    static Predicate _$localize_body_3_top = new PRED_$localize_body_3_top();
    static Predicate _$localize_body_3_var = new PRED_$localize_body_3_var();
    static Predicate _$localize_body_3_var_1 = new PRED_$localize_body_3_var_1();
    static Predicate _$localize_body_3_var_2 = new PRED_$localize_body_3_var_2();
    static Predicate _$localize_body_3_var_3 = new PRED_$localize_body_3_var_3();
    static Predicate _$localize_body_3_var_4 = new PRED_$localize_body_3_var_4();
    static Predicate _$localize_body_3_var_5 = new PRED_$localize_body_3_var_5();
    static Predicate _$localize_body_3_var_6 = new PRED_$localize_body_3_var_6();
    static Predicate _$localize_body_3_var_7 = new PRED_$localize_body_3_var_7();
    static Predicate _$localize_body_3_var_8 = new PRED_$localize_body_3_var_8();
    static Predicate _$localize_body_3_var_9 = new PRED_$localize_body_3_var_9();
    static Predicate _$localize_body_3_int = new PRED_$localize_body_3_int();
    static Predicate _$localize_body_3_int_1 = new PRED_$localize_body_3_int_1();
    static Predicate _$localize_body_3_int_2 = new PRED_$localize_body_3_int_2();
    static Predicate _$localize_body_3_int_3 = new PRED_$localize_body_3_int_3();
    static Predicate _$localize_body_3_int_4 = new PRED_$localize_body_3_int_4();
    static Predicate _$localize_body_3_int_5 = new PRED_$localize_body_3_int_5();
    static Predicate _$localize_body_3_str = new PRED_$localize_body_3_str();
    static Predicate _$localize_body_3_str_0 = new PRED_$localize_body_3_str_0();
    static Predicate _$localize_body_3_str_0_1 = new PRED_$localize_body_3_str_0_1();
    static Predicate _$localize_body_3_str_0_2 = new PRED_$localize_body_3_str_0_2();
    static Predicate _$localize_body_3_str_0_3 = new PRED_$localize_body_3_str_0_3();
    static Predicate _$localize_body_3_str_0_4 = new PRED_$localize_body_3_str_0_4();
    static Predicate _$localize_body_3_str_0_5 = new PRED_$localize_body_3_str_0_5();
    static Predicate _$localize_body_3_str_0_6 = new PRED_$localize_body_3_str_0_6();
    static Predicate _$localize_body_3_str_1 = new PRED_$localize_body_3_str_1();
    static Predicate _$localize_body_3_str_1_1 = new PRED_$localize_body_3_str_1_1();
    static Predicate _$localize_body_3_str_1_2 = new PRED_$localize_body_3_str_1_2();
    static Predicate _$localize_body_3_str_1_3 = new PRED_$localize_body_3_str_1_3();
    static Predicate _$localize_body_3_str_1_4 = new PRED_$localize_body_3_str_1_4();
    static Predicate _$localize_body_3_str_1_5 = new PRED_$localize_body_3_str_1_5();
    static Predicate _$localize_body_3_str_1_6 = new PRED_$localize_body_3_str_1_6();
    static Predicate _$localize_body_3_str_2 = new PRED_$localize_body_3_str_2();
    static Predicate _$localize_body_3_str_2_1 = new PRED_$localize_body_3_str_2_1();
    static Predicate _$localize_body_3_str_2_2 = new PRED_$localize_body_3_str_2_2();
    static Predicate _$localize_body_3_str_2_3 = new PRED_$localize_body_3_str_2_3();
    static Predicate _$localize_body_3_str_2_4 = new PRED_$localize_body_3_str_2_4();
    static Predicate _$localize_body_3_str_2_5 = new PRED_$localize_body_3_str_2_5();
    static Predicate _$localize_body_3_str_2_6 = new PRED_$localize_body_3_str_2_6();
    static Predicate _$localize_body_3_str_3 = new PRED_$localize_body_3_str_3();
    static Predicate _$localize_body_3_str_3_1 = new PRED_$localize_body_3_str_3_1();
    static Predicate _$localize_body_3_str_3_2 = new PRED_$localize_body_3_str_3_2();
    static Predicate _$localize_body_3_str_3_3 = new PRED_$localize_body_3_str_3_3();
    static Predicate _$localize_body_3_str_3_4 = new PRED_$localize_body_3_str_3_4();
    static Predicate _$localize_body_3_str_3_5 = new PRED_$localize_body_3_str_3_5();
    static Predicate _$localize_body_3_str_3_6 = new PRED_$localize_body_3_str_3_6();
    static Predicate _$localize_body_3_1 = new PRED_$localize_body_3_1();
    static Predicate _$localize_body_3_2 = new PRED_$localize_body_3_2();
    static Predicate _$localize_body_3_3 = new PRED_$localize_body_3_3();
    static Predicate _$localize_body_3_4 = new PRED_$localize_body_3_4();
    static Predicate _$localize_body_3_5 = new PRED_$localize_body_3_5();
    static Predicate _$localize_body_3_6 = new PRED_$localize_body_3_6();
    static Predicate _$localize_body_3_7 = new PRED_$localize_body_3_7();
    static Predicate _$localize_body_3_8 = new PRED_$localize_body_3_8();
    static Predicate _$localize_body_3_9 = new PRED_$localize_body_3_9();
    static Predicate _$localize_body_3_10 = new PRED_$localize_body_3_10();
    static java.util.Hashtable<Term, Predicate> str = new java.util.Hashtable<Term, Predicate>(4);
    static {
        str.put(s2, _$localize_body_3_str_0);
        str.put(s3, _$localize_body_3_str_1);
        str.put(s4, _$localize_body_3_str_2);
        str.put(s5, _$localize_body_3_str_3);
    }

    public Term arg1, arg2, arg3;

    public PRED_$localize_body_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$localize_body_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$localize_body(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        return _$localize_body_3_top;
    }
}

class PRED_$localize_body_3_top extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        engine.setB0();
        return engine.switch_on_term(_$localize_body_3_var, _$localize_body_3_int, _$localize_body_3_int, _$localize_body_3_int, _$localize_body_3_str, _$localize_body_3_int);
    }
}

class PRED_$localize_body_3_var extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$localize_body_3_1, _$localize_body_3_var_1);
    }
}

class PRED_$localize_body_3_var_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_2, _$localize_body_3_var_2);
    }
}

class PRED_$localize_body_3_var_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_3, _$localize_body_3_var_3);
    }
}

class PRED_$localize_body_3_var_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_4, _$localize_body_3_var_4);
    }
}

class PRED_$localize_body_3_var_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_5, _$localize_body_3_var_5);
    }
}

class PRED_$localize_body_3_var_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_6, _$localize_body_3_var_6);
    }
}

class PRED_$localize_body_3_var_6 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_7, _$localize_body_3_var_7);
    }
}

class PRED_$localize_body_3_var_7 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_8, _$localize_body_3_var_8);
    }
}

class PRED_$localize_body_3_var_8 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_9, _$localize_body_3_var_9);
    }
}

class PRED_$localize_body_3_var_9 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$localize_body_3_10);
    }
}

class PRED_$localize_body_3_int extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$localize_body_3_1, _$localize_body_3_int_1);
    }
}

class PRED_$localize_body_3_int_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_6, _$localize_body_3_int_2);
    }
}

class PRED_$localize_body_3_int_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_7, _$localize_body_3_int_3);
    }
}

class PRED_$localize_body_3_int_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_8, _$localize_body_3_int_4);
    }
}

class PRED_$localize_body_3_int_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_9, _$localize_body_3_int_5);
    }
}

class PRED_$localize_body_3_int_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$localize_body_3_10);
    }
}

class PRED_$localize_body_3_str extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(str, _$localize_body_3_int);
    }
}

class PRED_$localize_body_3_str_0 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$localize_body_3_1, _$localize_body_3_str_0_1);
    }
}

class PRED_$localize_body_3_str_0_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_2, _$localize_body_3_str_0_2);
    }
}

class PRED_$localize_body_3_str_0_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_6, _$localize_body_3_str_0_3);
    }
}

class PRED_$localize_body_3_str_0_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_7, _$localize_body_3_str_0_4);
    }
}

class PRED_$localize_body_3_str_0_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_8, _$localize_body_3_str_0_5);
    }
}

class PRED_$localize_body_3_str_0_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_9, _$localize_body_3_str_0_6);
    }
}

class PRED_$localize_body_3_str_0_6 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$localize_body_3_10);
    }
}

class PRED_$localize_body_3_str_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$localize_body_3_1, _$localize_body_3_str_1_1);
    }
}

class PRED_$localize_body_3_str_1_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_3, _$localize_body_3_str_1_2);
    }
}

class PRED_$localize_body_3_str_1_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_6, _$localize_body_3_str_1_3);
    }
}

class PRED_$localize_body_3_str_1_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_7, _$localize_body_3_str_1_4);
    }
}

class PRED_$localize_body_3_str_1_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_8, _$localize_body_3_str_1_5);
    }
}

class PRED_$localize_body_3_str_1_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_9, _$localize_body_3_str_1_6);
    }
}

class PRED_$localize_body_3_str_1_6 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$localize_body_3_10);
    }
}

class PRED_$localize_body_3_str_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$localize_body_3_1, _$localize_body_3_str_2_1);
    }
}

class PRED_$localize_body_3_str_2_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_4, _$localize_body_3_str_2_2);
    }
}

class PRED_$localize_body_3_str_2_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_6, _$localize_body_3_str_2_3);
    }
}

class PRED_$localize_body_3_str_2_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_7, _$localize_body_3_str_2_4);
    }
}

class PRED_$localize_body_3_str_2_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_8, _$localize_body_3_str_2_5);
    }
}

class PRED_$localize_body_3_str_2_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_9, _$localize_body_3_str_2_6);
    }
}

class PRED_$localize_body_3_str_2_6 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$localize_body_3_10);
    }
}

class PRED_$localize_body_3_str_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$localize_body_3_1, _$localize_body_3_str_3_1);
    }
}

class PRED_$localize_body_3_str_3_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_5, _$localize_body_3_str_3_2);
    }
}

class PRED_$localize_body_3_str_3_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_6, _$localize_body_3_str_3_3);
    }
}

class PRED_$localize_body_3_str_3_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_7, _$localize_body_3_str_3_4);
    }
}

class PRED_$localize_body_3_str_3_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_8, _$localize_body_3_str_3_5);
    }
}

class PRED_$localize_body_3_str_3_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$localize_body_3_9, _$localize_body_3_str_3_6);
    }
}

class PRED_$localize_body_3_str_3_6 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$localize_body_3_10);
    }
}

class PRED_$localize_body_3_1 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A,B,C):-var(A),!,'$localize_body'(call(A),B,C)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A,B,C):-['$get_level'(D),var(A),'$cut'(D),'$localize_body'(call(A),B,C)]
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
        Term[] y1 = {a1};
        a5 = new StructureTerm(s1, y1);
        engine.aregs[1] = a5;
        engine.aregs[2] = a2;
        engine.aregs[3] = a3;
        engine.cont = cont;
        return _$localize_body_3_top;
    }
}

class PRED_$localize_body_3_2 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A:B,C,D):-!,'$localize_body'(B,A,D)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A:B,C,D):-['$neck_cut','$localize_body'(B,A,D)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s2.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a4 = args[0];
            a5 = args[1];
        } else if (a1.isVariable()){
            a4 = new VariableTerm(engine);
            a5 = new VariableTerm(engine);
            Term[] args = {a4, a5};
            ((VariableTerm) a1).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        engine.aregs[1] = a5;
        engine.aregs[2] = a4;
        engine.aregs[3] = a3;
        engine.cont = cont;
        return _$localize_body_3_top;
    }
}

class PRED_$localize_body_3_3 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'((A,B),C,(D,E)):-!,'$localize_body'(A,C,D),'$localize_body'(B,C,E)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'((A,B),C,(D,E)):-['$neck_cut','$localize_body'(A,C,D),'$localize_body'(B,C,E)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s3.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a4 = args[0];
            a5 = args[1];
        } else if (a1.isVariable()){
            a4 = new VariableTerm(engine);
            a5 = new VariableTerm(engine);
            Term[] args = {a4, a5};
            ((VariableTerm) a1).bind(new StructureTerm(s3, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s3.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            a6 = args[0];
            a7 = args[1];
        } else if (a3.isVariable()){
            a6 = new VariableTerm(engine);
            a7 = new VariableTerm(engine);
            Term[] args = {a6, a7};
            ((VariableTerm) a3).bind(new StructureTerm(s3, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        p1 = new PRED_$localize_body_3(a5, a2, a7, cont);
        engine.aregs[1] = a4;
        engine.aregs[2] = a2;
        engine.aregs[3] = a6;
        engine.cont = p1;
        return _$localize_body_3_top;
    }
}

class PRED_$localize_body_3_4 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'((A->B),C,(D->E)):-!,'$localize_body'(A,C,D),'$localize_body'(B,C,E)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'((A->B),C,(D->E)):-['$neck_cut','$localize_body'(A,C,D),'$localize_body'(B,C,E)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s4.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a4 = args[0];
            a5 = args[1];
        } else if (a1.isVariable()){
            a4 = new VariableTerm(engine);
            a5 = new VariableTerm(engine);
            Term[] args = {a4, a5};
            ((VariableTerm) a1).bind(new StructureTerm(s4, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s4.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            a6 = args[0];
            a7 = args[1];
        } else if (a3.isVariable()){
            a6 = new VariableTerm(engine);
            a7 = new VariableTerm(engine);
            Term[] args = {a6, a7};
            ((VariableTerm) a3).bind(new StructureTerm(s4, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        p1 = new PRED_$localize_body_3(a5, a2, a7, cont);
        engine.aregs[1] = a4;
        engine.aregs[2] = a2;
        engine.aregs[3] = a6;
        engine.cont = p1;
        return _$localize_body_3_top;
    }
}

class PRED_$localize_body_3_5 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'((A;B),C,(D;E)):-!,'$localize_body'(A,C,D),'$localize_body'(B,C,E)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'((A;B),C,(D;E)):-['$neck_cut','$localize_body'(A,C,D),'$localize_body'(B,C,E)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s5.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a4 = args[0];
            a5 = args[1];
        } else if (a1.isVariable()){
            a4 = new VariableTerm(engine);
            a5 = new VariableTerm(engine);
            Term[] args = {a4, a5};
            ((VariableTerm) a1).bind(new StructureTerm(s5, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s5.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            a6 = args[0];
            a7 = args[1];
        } else if (a3.isVariable()){
            a6 = new VariableTerm(engine);
            a7 = new VariableTerm(engine);
            Term[] args = {a6, a7};
            ((VariableTerm) a3).bind(new StructureTerm(s5, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        p1 = new PRED_$localize_body_3(a5, a2, a7, cont);
        engine.aregs[1] = a4;
        engine.aregs[2] = a2;
        engine.aregs[3] = a6;
        engine.cont = p1;
        return _$localize_body_3_top;
    }
}

class PRED_$localize_body_3_6 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A,B,C):-functor(A,D,E),'$builtin_meta_predicates'(D,E,F),!,A=..[D|G],'$localize_args'(F,G,B,H),C=..[D|H]
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
        Predicate p1, p2, p3, p4, p5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A,B,C):-['$get_level'(D),functor(A,E,F),'$builtin_meta_predicates'(E,F,G),'$cut'(D),'$univ'(A,[E|H]),'$localize_args'(G,H,B,I),'$univ'(C,[E|I])]
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a5 = new VariableTerm(engine);
        a6 = new VariableTerm(engine);
        a7 = new VariableTerm(engine);
        a8 = new VariableTerm(engine);
        a9 = new ListTerm(a5, a8);
        a10 = new VariableTerm(engine);
        a11 = new ListTerm(a5, a10);
        p1 = new PRED_$univ_2(a3, a11, cont);
        p2 = new PRED_$localize_args_4(a7, a8, a2, a10, p1);
        p3 = new PRED_$univ_2(a1, a9, p2);
        p4 = new PRED_$cut_1(a4, p3);
        p5 = new PRED_$builtin_meta_predicates_3(a5, a6, a7, p4);
        return new PRED_functor_3(a1, a5, a6, p5);
    }
}

class PRED_$localize_body_3_7 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A,B,call(B:A)):-var(B),!
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A,B,call(B:A)):-['$get_level'(C),var(B),'$cut'(C)]
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s1.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            a4 = args[0];
        } else if (a3.isVariable()){
            a4 = new VariableTerm(engine);
            Term[] args = {a4};
            ((VariableTerm) a3).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        a4 = a4.dereference();
        if (a4.isStructure()){
            if (! s2.equals(((StructureTerm)a4).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a4).args();
            if (! a2.unify(args[0], engine.trail))
                return engine.fail();
            if (! a1.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a4.isVariable()){
            Term[] args = {a2, a1};
            ((VariableTerm) a4).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        a5 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(5))
        if (! a5.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(2))
        a2 = a2.dereference();
        if (! a2.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(5))
        a5 = a5.dereference();
        if (! a5.isInteger()) {
            throw new IllegalTypeException("integer", a5);
        } else {
            engine.cut(((IntegerTerm) a5).intValue());
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$localize_body_3_8 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A,user,A):-!
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A,user,A):-['$neck_cut']
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s6))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s6, engine.trail);
        } else {
            return engine.fail();
        }
        if (! a1.unify(a3, engine.trail))
            return engine.fail();
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_$localize_body_3_9 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A,B,A):-system_predicate(A),!
        Term a1, a2, a3, a4;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A,B,A):-['$get_level'(C),system_predicate(A),'$cut'(C)]
        if (! a1.unify(a3, engine.trail))
            return engine.fail();
        a4 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(4))
        if (! a4.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        p1 = new PRED_$cut_1(a4, cont);
        return new PRED_system_predicate_1(a1, p1);
    }
}

class PRED_$localize_body_3_10 extends PRED_$localize_body_3 {
    public Predicate exec(Prolog engine) {
    // '$localize_body'(A,B,B:A):-true
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$localize_body'(A,B,B:A):-[]
        a3 = a3.dereference();
        if (a3.isStructure()){
            if (! s2.equals(((StructureTerm)a3).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a3).args();
            if (! a2.unify(args[0], engine.trail))
                return engine.fail();
            if (! a1.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a3.isVariable()){
            Term[] args = {a2, a1};
            ((VariableTerm) a3).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        return cont;
    }
}
