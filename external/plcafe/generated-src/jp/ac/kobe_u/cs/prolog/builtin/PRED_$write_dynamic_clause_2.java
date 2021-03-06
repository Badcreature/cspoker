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
 <code>'$write_dynamic_clause'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$write_dynamic_clause_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(":-", 2);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("true");
    static IntegerTerm si3 = new IntegerTerm(0);
    static SymbolTerm s4 = SymbolTerm.makeSymbol(".");
    static SymbolTerm s5 = SymbolTerm.makeSymbol(" :-");
    static IntegerTerm si6 = new IntegerTerm(8);
    static Predicate _$write_dynamic_clause_2_sub_1 = new PRED_$write_dynamic_clause_2_sub_1();
    static Predicate _$write_dynamic_clause_2_sub_2 = new PRED_$write_dynamic_clause_2_sub_2();
    static Predicate _$write_dynamic_clause_2_1 = new PRED_$write_dynamic_clause_2_1();
    static Predicate _$write_dynamic_clause_2_2 = new PRED_$write_dynamic_clause_2_2();
    static Predicate _$write_dynamic_clause_2_3 = new PRED_$write_dynamic_clause_2_3();

    public Term arg1, arg2;

    public PRED_$write_dynamic_clause_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$write_dynamic_clause_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$write_dynamic_clause(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$write_dynamic_clause_2_1, _$write_dynamic_clause_2_sub_1);
    }
}

class PRED_$write_dynamic_clause_2_sub_1 extends PRED_$write_dynamic_clause_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$write_dynamic_clause_2_2, _$write_dynamic_clause_2_sub_2);
    }
}

class PRED_$write_dynamic_clause_2_sub_2 extends PRED_$write_dynamic_clause_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$write_dynamic_clause_2_3);
    }
}

class PRED_$write_dynamic_clause_2_1 extends PRED_$write_dynamic_clause_2 {
    public Predicate exec(Prolog engine) {
    // '$write_dynamic_clause'(A,B):-var(B),!,fail
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$write_dynamic_clause'(A,B):-['$get_level'(C),var(B),'$cut'(C),fail]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of var(a(2))
        a2 = a2.dereference();
        if (! a2.isVariable()) {
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
        //START inline expansion of fail
        return engine.fail();
        //END inline expansion
    }
}

class PRED_$write_dynamic_clause_2_2 extends PRED_$write_dynamic_clause_2 {
    public Predicate exec(Prolog engine) {
    // '$write_dynamic_clause'(A,(B:-true)):-!,numbervars(B,0,C),'$write_dynamic_head'(A,B),write('.'),nl
        Term a1, a2, a3;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$write_dynamic_clause'(A,(B:-true)):-['$neck_cut',numbervars(B,0,C),'$write_dynamic_head'(A,B),write('.'),nl]
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s1.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a3 = args[0];
            if (! s2.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a2.isVariable()){
            a3 = new VariableTerm(engine);
            Term[] args = {a3, s2};
            ((VariableTerm) a2).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        p1 = new PRED_nl_0(cont);
        p2 = new PRED_write_1(s4, p1);
        p3 = new PRED_$write_dynamic_head_2(a1, a3, p2);
        return new PRED_numbervars_3(a3, si3, new VariableTerm(engine), p3);
    }
}

class PRED_$write_dynamic_clause_2_3 extends PRED_$write_dynamic_clause_2 {
    public Predicate exec(Prolog engine) {
    // '$write_dynamic_clause'(A,(B:-C)):-!,numbervars((B:-C),0,D),'$write_dynamic_head'(A,B),write(' :-'),nl,'$write_dynamic_body'(C,8),write('.'),nl
        Term a1, a2, a3, a4, a5;
        Predicate p1, p2, p3, p4, p5, p6;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$write_dynamic_clause'(A,(B:-C)):-['$neck_cut',numbervars((B:-C),0,D),'$write_dynamic_head'(A,B),write(' :-'),nl,'$write_dynamic_body'(C,8),write('.'),nl]
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s1.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a3 = args[0];
            a4 = args[1];
        } else if (a2.isVariable()){
            a3 = new VariableTerm(engine);
            a4 = new VariableTerm(engine);
            Term[] args = {a3, a4};
            ((VariableTerm) a2).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        Term[] y1 = {a3, a4};
        a5 = new StructureTerm(s1, y1);
        p1 = new PRED_nl_0(cont);
        p2 = new PRED_write_1(s4, p1);
        p3 = new PRED_$write_dynamic_body_2(a4, si6, p2);
        p4 = new PRED_nl_0(p3);
        p5 = new PRED_write_1(s5, p4);
        p6 = new PRED_$write_dynamic_head_2(a1, a3, p5);
        return new PRED_numbervars_3(a5, si3, new VariableTerm(engine), p6);
    }
}
