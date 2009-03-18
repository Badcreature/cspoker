package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$stream_property'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$stream_property_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(",", 2);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("domain", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("stream");
    static Term[] s4 = {s3, s3};
    static StructureTerm s5 = new StructureTerm(s2, s4);
    static SymbolTerm s6 = SymbolTerm.makeSymbol("stream_property", 2);
    static IntegerTerm si7 = new IntegerTerm(1);
    static Predicate _$stream_property_2_sub_1 = new PRED_$stream_property_2_sub_1();
    static Predicate _$stream_property_2_sub_2 = new PRED_$stream_property_2_sub_2();
    static Predicate _$stream_property_2_1 = new PRED_$stream_property_2_1();
    static Predicate _$stream_property_2_2 = new PRED_$stream_property_2_2();
    static Predicate _$stream_property_2_3 = new PRED_$stream_property_2_3();

    public Term arg1, arg2;

    public PRED_$stream_property_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$stream_property_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$stream_property(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$stream_property_2_1, _$stream_property_2_sub_1);
    }
}

class PRED_$stream_property_2_sub_1 extends PRED_$stream_property_2 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$stream_property_2_2, _$stream_property_2_sub_2);
    }
}

class PRED_$stream_property_2_sub_2 extends PRED_$stream_property_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$stream_property_2_3);
    }
}

class PRED_$stream_property_2_1 extends PRED_$stream_property_2 {
    public Predicate exec(Prolog engine) {
    // '$stream_property'(A,B):-var(A),!,'$get_stream_manager'(C),hash_map(C,D),'$builtin_member'((A,E),D),java(A),'$builtin_member'(B,E)
        Term a1, a2, a3, a4, a5, a6, a7;
        Predicate p1, p2, p3, p4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$stream_property'(A,B):-['$get_level'(C),var(A),'$cut'(C),'$get_stream_manager'(D),hash_map(D,E),'$builtin_member'((A,F),E),java(A),'$builtin_member'(B,F)]
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
        a4 = new VariableTerm(engine);
        a5 = new VariableTerm(engine);
        a6 = new VariableTerm(engine);
        Term[] y1 = {a1, a6};
        a7 = new StructureTerm(s1, y1);
        p1 = new PRED_$builtin_member_2(a2, a6, cont);
        p2 = new PRED_java_1(a1, p1);
        p3 = new PRED_$builtin_member_2(a7, a5, p2);
        p4 = new PRED_hash_map_2(a4, a5, p3);
        return new PRED_$get_stream_manager_1(a4, p4);
    }
}

class PRED_$stream_property_2_2 extends PRED_$stream_property_2 {
    public Predicate exec(Prolog engine) {
    // '$stream_property'(A,B):-java(A),!,'$get_stream_manager'(C),hash_get(C,A,D),'$builtin_member'(B,D)
        Term a1, a2, a3, a4, a5;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$stream_property'(A,B):-['$get_level'(C),java(A),'$cut'(C),'$get_stream_manager'(D),hash_get(D,A,E),'$builtin_member'(B,E)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        //START inline expansion of java(a(1))
        a1 = a1.dereference();
        if (! a1.isJavaObject()) {
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
        a4 = new VariableTerm(engine);
        a5 = new VariableTerm(engine);
        p1 = new PRED_$builtin_member_2(a2, a5, cont);
        p2 = new PRED_hash_get_3(a4, a1, a5, p1);
        return new PRED_$get_stream_manager_1(a4, p2);
    }
}

class PRED_$stream_property_2_3 extends PRED_$stream_property_2 {
    public Predicate exec(Prolog engine) {
    // '$stream_property'(A,B):-illarg(domain(stream,stream),stream_property(A,B),1)
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$stream_property'(A,B):-[illarg(domain(stream,stream),stream_property(A,B),1)]
        Term[] y1 = {a1, a2};
        a3 = new StructureTerm(s6, y1);
        return new PRED_illarg_3(s5, a3, si7, cont);
    }
}
