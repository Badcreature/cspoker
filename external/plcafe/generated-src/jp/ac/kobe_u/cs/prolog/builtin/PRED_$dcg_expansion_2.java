package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$dcg_expansion'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$dcg_expansion_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("-->", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol(":-", 2);
    static SymbolTerm s4 = SymbolTerm.makeSymbol(",", 2);
    static Predicate _$dcg_expansion_2_top = new PRED_$dcg_expansion_2_top();
    static Predicate _$dcg_expansion_2_var = new PRED_$dcg_expansion_2_var();
    static Predicate _$dcg_expansion_2_var_1 = new PRED_$dcg_expansion_2_var_1();
    static Predicate _$dcg_expansion_2_var_2 = new PRED_$dcg_expansion_2_var_2();
    static Predicate _$dcg_expansion_2_var_3 = new PRED_$dcg_expansion_2_var_3();
    static Predicate _$dcg_expansion_2_str = new PRED_$dcg_expansion_2_str();
    static Predicate _$dcg_expansion_2_str_0 = new PRED_$dcg_expansion_2_str_0();
    static Predicate _$dcg_expansion_2_str_0_1 = new PRED_$dcg_expansion_2_str_0_1();
    static Predicate _$dcg_expansion_2_str_1 = new PRED_$dcg_expansion_2_str_1();
    static Predicate _$dcg_expansion_2_str_1_1 = new PRED_$dcg_expansion_2_str_1_1();
    static Predicate _$dcg_expansion_2_str_1_2 = new PRED_$dcg_expansion_2_str_1_2();
    static Predicate _$dcg_expansion_2_1 = new PRED_$dcg_expansion_2_1();
    static Predicate _$dcg_expansion_2_2 = new PRED_$dcg_expansion_2_2();
    static Predicate _$dcg_expansion_2_3 = new PRED_$dcg_expansion_2_3();
    static Predicate _$dcg_expansion_2_4 = new PRED_$dcg_expansion_2_4();
    static java.util.Hashtable<Term, Predicate> str = new java.util.Hashtable<Term, Predicate>(2);
    static {
        str.put(s1, _$dcg_expansion_2_str_0);
        str.put(s2, _$dcg_expansion_2_str_1);
    }

    public Term arg1, arg2;

    public PRED_$dcg_expansion_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$dcg_expansion_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$dcg_expansion(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        return _$dcg_expansion_2_top;
    }
}

class PRED_$dcg_expansion_2_top extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        engine.setB0();
        return engine.switch_on_term(_$dcg_expansion_2_var, _$dcg_expansion_2_1, _$dcg_expansion_2_1, _$dcg_expansion_2_1, _$dcg_expansion_2_str, _$dcg_expansion_2_1);
    }
}

class PRED_$dcg_expansion_2_var extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$dcg_expansion_2_1, _$dcg_expansion_2_var_1);
    }
}

class PRED_$dcg_expansion_2_var_1 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$dcg_expansion_2_2, _$dcg_expansion_2_var_2);
    }
}

class PRED_$dcg_expansion_2_var_2 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$dcg_expansion_2_3, _$dcg_expansion_2_var_3);
    }
}

class PRED_$dcg_expansion_2_var_3 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dcg_expansion_2_4);
    }
}

class PRED_$dcg_expansion_2_str extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.switch_on_hash(str, _$dcg_expansion_2_1);
    }
}

class PRED_$dcg_expansion_2_str_0 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$dcg_expansion_2_1, _$dcg_expansion_2_str_0_1);
    }
}

class PRED_$dcg_expansion_2_str_0_1 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dcg_expansion_2_2);
    }
}

class PRED_$dcg_expansion_2_str_1 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_$dcg_expansion_2_1, _$dcg_expansion_2_str_1_1);
    }
}

class PRED_$dcg_expansion_2_str_1_1 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$dcg_expansion_2_3, _$dcg_expansion_2_str_1_2);
    }
}

class PRED_$dcg_expansion_2_str_1_2 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$dcg_expansion_2_4);
    }
}

class PRED_$dcg_expansion_2_1 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
    // '$dcg_expansion'(A,B):-var(A),!,A=B
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$dcg_expansion'(A,B):-['$get_level'(C),var(A),'$cut'(C),'$unify'(A,B)]
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
        //START inline expansion of $unify(a(1),a(2))
        if (! a1.unify(a2, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}

class PRED_$dcg_expansion_2_2 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
    // '$dcg_expansion'(A:B,A:C):-!,'$dcg_expansion'(B,C)
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$dcg_expansion'(A:B,A:C):-['$neck_cut','$dcg_expansion'(B,C)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s1.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a3 = args[0];
            a4 = args[1];
        } else if (a1.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            Term[] args = {a3, a4};
            ((VariableTerm) a1).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s1.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            if (! a3.unify(args[0], engine.trail))
                return engine.fail();
            a5 = args[1];
        } else if (a2.isVariable()){
            a5 = new VariableTerm(engine);
            Term[] args = {a3, a5};
            ((VariableTerm) a2).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        engine.aregs[1] = a4;
        engine.aregs[2] = a5;
        engine.cont = cont;
        return _$dcg_expansion_2_top;
    }
}

class PRED_$dcg_expansion_2_3 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
    // '$dcg_expansion'((A-->B),(C:-D,E)):-nonvar(A),A=(F,G),!,'$dcg_translate_dcg_atom'(F,C,H,I),'$dcg_translate_dcg'(B,D,H,J),'$dcg_translate_dcg'(G,E,I,J)
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$dcg_expansion'((A-->B),(C:-D,E)):-['$get_level'(F),nonvar(A),'$unify'(A,(G,H)),'$cut'(F),'$dcg_translate_dcg_atom'(G,C,I,J),'$dcg_translate_dcg'(B,D,I,K),'$dcg_translate_dcg'(H,E,J,K)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s2.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a3 = args[0];
            a4 = args[1];
        } else if (a1.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            Term[] args = {a3, a4};
            ((VariableTerm) a1).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s3.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a5 = args[0];
            a6 = args[1];
        } else if (a2.isVariable()){
            a5 = new VariableTerm(engine);
            a6 = new VariableTerm(engine);
            Term[] args = {a5, a6};
            ((VariableTerm) a2).bind(new StructureTerm(s3, args), engine.trail);
        } else {
            return engine.fail();
        }
        a6 = a6.dereference();
        if (a6.isStructure()){
            if (! s4.equals(((StructureTerm)a6).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a6).args();
            a7 = args[0];
            a8 = args[1];
        } else if (a6.isVariable()){
            a7 = new VariableTerm(engine);
            a8 = new VariableTerm(engine);
            Term[] args = {a7, a8};
            ((VariableTerm) a6).bind(new StructureTerm(s4, args), engine.trail);
        } else {
            return engine.fail();
        }
        a9 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(9))
        if (! a9.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of nonvar(a(3))
        a3 = a3.dereference();
        if (a3.isVariable()) {
            return engine.fail();
        }
        //END inline expansion
        a10 = new VariableTerm(engine);
        a11 = new VariableTerm(engine);
        Term[] y1 = {a10, a11};
        a12 = new StructureTerm(s4, y1);
        //START inline expansion of $unify(a(3),a(12))
        if (! a3.unify(a12, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of $cut(a(9))
        a9 = a9.dereference();
        if (! a9.isInteger()) {
            throw new IllegalTypeException("integer", a9);
        } else {
            engine.cut(((IntegerTerm) a9).intValue());
        }
        //END inline expansion
        a13 = new VariableTerm(engine);
        a14 = new VariableTerm(engine);
        a15 = new VariableTerm(engine);
        p1 = new PRED_$dcg_translate_dcg_4(a11, a8, a14, a15, cont);
        p2 = new PRED_$dcg_translate_dcg_4(a4, a7, a13, a15, p1);
        return new PRED_$dcg_translate_dcg_atom_4(a10, a5, a13, a14, p2);
    }
}

class PRED_$dcg_expansion_2_4 extends PRED_$dcg_expansion_2 {
    public Predicate exec(Prolog engine) {
    // '$dcg_expansion'((A-->B),(C:-D)):-'$dcg_translate_dcg_atom'(A,C,E,F),'$dcg_translate_dcg'(B,D,E,F)
        Term a1, a2, a3, a4, a5, a6, a7, a8;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$dcg_expansion'((A-->B),(C:-D)):-['$dcg_translate_dcg_atom'(A,C,E,F),'$dcg_translate_dcg'(B,D,E,F)]
        a1 = a1.dereference();
        if (a1.isStructure()){
            if (! s2.equals(((StructureTerm)a1).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a1).args();
            a3 = args[0];
            a4 = args[1];
        } else if (a1.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            Term[] args = {a3, a4};
            ((VariableTerm) a1).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s3.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a5 = args[0];
            a6 = args[1];
        } else if (a2.isVariable()){
            a5 = new VariableTerm(engine);
            a6 = new VariableTerm(engine);
            Term[] args = {a5, a6};
            ((VariableTerm) a2).bind(new StructureTerm(s3, args), engine.trail);
        } else {
            return engine.fail();
        }
        a7 = new VariableTerm(engine);
        a8 = new VariableTerm(engine);
        p1 = new PRED_$dcg_translate_dcg_4(a4, a6, a7, a8, cont);
        return new PRED_$dcg_translate_dcg_atom_4(a3, a5, a7, a8, p1);
    }
}