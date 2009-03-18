package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$read_tokens1'/5</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$read_tokens1_5 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("error", 1);
    static SymbolTerm s2 = SymbolTerm.makeSymbol("[]");
    static SymbolTerm s3 = SymbolTerm.makeSymbol("{SYNTAX ERROR}");
    static SymbolTerm s4 = SymbolTerm.makeSymbol("** ");
    static SymbolTerm s5 = SymbolTerm.makeSymbol(" **");
    static SymbolTerm s6 = SymbolTerm.makeSymbol("end_of_file");
    static SymbolTerm s7 = SymbolTerm.makeSymbol(".");
    static ListTerm s8 = new ListTerm(s7, s2);
    static ListTerm s9 = new ListTerm(s6, s8);
    static SymbolTerm s10 = SymbolTerm.makeSymbol("var", 1);
    static SymbolTerm s11 = SymbolTerm.makeSymbol("_");
    static Term[] s12 = {s11};
    static StructureTerm s13 = new StructureTerm(s10, s12);
    static SymbolTerm s14 = SymbolTerm.makeSymbol("var", 2);
    static SymbolTerm s15 = SymbolTerm.makeSymbol("=", 2);
    static Predicate _$read_tokens1_5_sub_1 = new PRED_$read_tokens1_5_sub_1();
    static Predicate _$read_tokens1_5_sub_2 = new PRED_$read_tokens1_5_sub_2();
    static Predicate _$read_tokens1_5_sub_3 = new PRED_$read_tokens1_5_sub_3();
    static Predicate _$read_tokens1_5_sub_4 = new PRED_$read_tokens1_5_sub_4();
    static Predicate _$read_tokens1_5_sub_5 = new PRED_$read_tokens1_5_sub_5();
    static Predicate _$read_tokens1_5_sub_6 = new PRED_$read_tokens1_5_sub_6();
    static Predicate _$read_tokens1_5_1 = new PRED_$read_tokens1_5_1();
    static Predicate _$read_tokens1_5_2 = new PRED_$read_tokens1_5_2();
    static Predicate _$read_tokens1_5_3 = new PRED_$read_tokens1_5_3();
    static Predicate _$read_tokens1_5_4 = new PRED_$read_tokens1_5_4();
    static Predicate _$read_tokens1_5_5 = new PRED_$read_tokens1_5_5();
    static Predicate _$read_tokens1_5_6 = new PRED_$read_tokens1_5_6();
    static Predicate _$read_tokens1_5_7 = new PRED_$read_tokens1_5_7();

    public Term arg1, arg2, arg3, arg4, arg5;

    public PRED_$read_tokens1_5(Term a1, Term a2, Term a3, Term a4, Term a5, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        arg5 = a5;
        this.cont = cont;
    }

    public PRED_$read_tokens1_5(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        arg5 = args[4];
        this.cont = cont;
    }

    public int arity() { return 5; }

    public String toString() {
        return "$read_tokens1(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + "," + arg5 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.aregs[5] = arg5;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$read_tokens1_5_1, _$read_tokens1_5_sub_1);
    }
}

class PRED_$read_tokens1_5_sub_1 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$read_tokens1_5_2, _$read_tokens1_5_sub_2);
    }
}

class PRED_$read_tokens1_5_sub_2 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$read_tokens1_5_3, _$read_tokens1_5_sub_3);
    }
}

class PRED_$read_tokens1_5_sub_3 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$read_tokens1_5_4, _$read_tokens1_5_sub_4);
    }
}

class PRED_$read_tokens1_5_sub_4 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$read_tokens1_5_5, _$read_tokens1_5_sub_5);
    }
}

class PRED_$read_tokens1_5_sub_5 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
        return engine.retry(_$read_tokens1_5_6, _$read_tokens1_5_sub_6);
    }
}

class PRED_$read_tokens1_5_sub_6 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$read_tokens1_5_7);
    }
}

class PRED_$read_tokens1_5_1 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,error(B),[],C,D):-!,write('{SYNTAX ERROR}'),nl,write('** '),write(B),write(' **'),nl,'$read_tokens_until_fullstop'(A),fail
        Term a1, a2, a3, a4, a5, a6;
        Predicate p1, p2, p3, p4, p5, p6, p7;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,error(B),[],C,D):-['$neck_cut',write('{SYNTAX ERROR}'),nl,write('** '),write(B),write(' **'),nl,'$read_tokens_until_fullstop'(A),fail]
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s1.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a6 = args[0];
        } else if (a2.isVariable()){
            a6 = new VariableTerm(engine);
            Term[] args = {a6};
            ((VariableTerm) a2).bind(new StructureTerm(s1, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isSymbol()){
            if (! a3.equals(s2))
                return engine.fail();
        } else if (a3.isVariable()){
            ((VariableTerm) a3).bind(s2, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        p1 = new PRED_fail_0(cont);
        p2 = new PRED_$read_tokens_until_fullstop_1(a1, p1);
        p3 = new PRED_nl_0(p2);
        p4 = new PRED_write_1(s5, p3);
        p5 = new PRED_write_1(a6, p4);
        p6 = new PRED_write_1(s4, p5);
        p7 = new PRED_nl_0(p6);
        return new PRED_write_1(s3, p7);
    }
}

class PRED_$read_tokens1_5_2 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,end_of_file,[end_of_file,'.'],[],B):-!
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,end_of_file,[end_of_file,'.'],[],B):-['$neck_cut']
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s6))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s6, engine.trail);
        } else {
            return engine.fail();
        }
        if (! s9.unify(a3, engine.trail))
            return engine.fail();
        a4 = a4.dereference();
        if (a4.isSymbol()){
            if (! a4.equals(s2))
                return engine.fail();
        } else if (a4.isVariable()){
            ((VariableTerm) a4).bind(s2, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_$read_tokens1_5_3 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,'.',['.'],[],B):-!
        Term a1, a2, a3, a4, a5;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,'.',['.'],[],B):-['$neck_cut']
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s7))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s7, engine.trail);
        } else {
            return engine.fail();
        }
        if (! s8.unify(a3, engine.trail))
            return engine.fail();
        a4 = a4.dereference();
        if (a4.isSymbol()){
            if (! a4.equals(s2))
                return engine.fail();
        } else if (a4.isVariable()){
            ((VariableTerm) a4).bind(s2, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_$read_tokens1_5_4 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,var('_'),[var('_',B)|C],['_'=B|D],E):-!,'$read_tokens'(A,C,D,['_'=B|E])
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,var('_'),[var('_',B)|C],['_'=B|D],E):-['$neck_cut','$read_tokens'(A,C,D,['_'=B|E])]
        if (! s13.unify(a2, engine.trail))
            return engine.fail();
        a3 = a3.dereference();
        if (a3.isList()){
            Term[] args = {((ListTerm)a3).car(), ((ListTerm)a3).cdr()};
            a6 = args[0];
            a7 = args[1];
        } else if (a3.isVariable()){
            a6 = new VariableTerm(engine);
            a7 = new VariableTerm(engine);
            ((VariableTerm) a3).bind(new ListTerm(a6, a7), engine.trail);
        } else {
            return engine.fail();
        }
        a6 = a6.dereference();
        if (a6.isStructure()){
            if (! s14.equals(((StructureTerm)a6).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a6).args();
            if (! s11.unify(args[0], engine.trail))
                return engine.fail();
            a8 = args[1];
        } else if (a6.isVariable()){
            a8 = new VariableTerm(engine);
            Term[] args = {s11, a8};
            ((VariableTerm) a6).bind(new StructureTerm(s14, args), engine.trail);
        } else {
            return engine.fail();
        }
        a4 = a4.dereference();
        if (a4.isList()){
            Term[] args = {((ListTerm)a4).car(), ((ListTerm)a4).cdr()};
            a9 = args[0];
            a10 = args[1];
        } else if (a4.isVariable()){
            a9 = new VariableTerm(engine);
            a10 = new VariableTerm(engine);
            ((VariableTerm) a4).bind(new ListTerm(a9, a10), engine.trail);
        } else {
            return engine.fail();
        }
        a9 = a9.dereference();
        if (a9.isStructure()){
            if (! s15.equals(((StructureTerm)a9).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a9).args();
            if (! s11.unify(args[0], engine.trail))
                return engine.fail();
            if (! a8.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a9.isVariable()){
            Term[] args = {s11, a8};
            ((VariableTerm) a9).bind(new StructureTerm(s15, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        Term[] y1 = {s11, a8};
        a11 = new StructureTerm(s15, y1);
        a12 = new ListTerm(a11, a5);
        return new PRED_$read_tokens_4(a1, a7, a10, a12, cont);
    }
}

class PRED_$read_tokens1_5_5 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,var(B),[var(B,C)|D],E,F):-'$mem_pair'(B=C,F),!,'$read_tokens'(A,D,E,F)
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,var(B),[var(B,C)|D],E,F):-['$get_level'(G),'$mem_pair'(B=C,F),'$cut'(G),'$read_tokens'(A,D,E,F)]
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s10.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a6 = args[0];
        } else if (a2.isVariable()){
            a6 = new VariableTerm(engine);
            Term[] args = {a6};
            ((VariableTerm) a2).bind(new StructureTerm(s10, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isList()){
            Term[] args = {((ListTerm)a3).car(), ((ListTerm)a3).cdr()};
            a7 = args[0];
            a8 = args[1];
        } else if (a3.isVariable()){
            a7 = new VariableTerm(engine);
            a8 = new VariableTerm(engine);
            ((VariableTerm) a3).bind(new ListTerm(a7, a8), engine.trail);
        } else {
            return engine.fail();
        }
        a7 = a7.dereference();
        if (a7.isStructure()){
            if (! s14.equals(((StructureTerm)a7).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a7).args();
            if (! a6.unify(args[0], engine.trail))
                return engine.fail();
            a9 = args[1];
        } else if (a7.isVariable()){
            a9 = new VariableTerm(engine);
            Term[] args = {a6, a9};
            ((VariableTerm) a7).bind(new StructureTerm(s14, args), engine.trail);
        } else {
            return engine.fail();
        }
        a10 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(10))
        if (! a10.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        Term[] y1 = {a6, a9};
        a11 = new StructureTerm(s15, y1);
        p1 = new PRED_$read_tokens_4(a1, a8, a4, a5, cont);
        p2 = new PRED_$cut_1(a10, p1);
        return new PRED_$mem_pair_2(a11, a5, p2);
    }
}

class PRED_$read_tokens1_5_6 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,var(B),[var(B,C)|D],[B=C|E],F):-!,'$read_tokens'(A,D,E,[B=C|F])
        Term a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,var(B),[var(B,C)|D],[B=C|E],F):-['$neck_cut','$read_tokens'(A,D,E,[B=C|F])]
        a2 = a2.dereference();
        if (a2.isStructure()){
            if (! s10.equals(((StructureTerm)a2).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a2).args();
            a6 = args[0];
        } else if (a2.isVariable()){
            a6 = new VariableTerm(engine);
            Term[] args = {a6};
            ((VariableTerm) a2).bind(new StructureTerm(s10, args), engine.trail);
        } else {
            return engine.fail();
        }
        a3 = a3.dereference();
        if (a3.isList()){
            Term[] args = {((ListTerm)a3).car(), ((ListTerm)a3).cdr()};
            a7 = args[0];
            a8 = args[1];
        } else if (a3.isVariable()){
            a7 = new VariableTerm(engine);
            a8 = new VariableTerm(engine);
            ((VariableTerm) a3).bind(new ListTerm(a7, a8), engine.trail);
        } else {
            return engine.fail();
        }
        a7 = a7.dereference();
        if (a7.isStructure()){
            if (! s14.equals(((StructureTerm)a7).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a7).args();
            if (! a6.unify(args[0], engine.trail))
                return engine.fail();
            a9 = args[1];
        } else if (a7.isVariable()){
            a9 = new VariableTerm(engine);
            Term[] args = {a6, a9};
            ((VariableTerm) a7).bind(new StructureTerm(s14, args), engine.trail);
        } else {
            return engine.fail();
        }
        a4 = a4.dereference();
        if (a4.isList()){
            Term[] args = {((ListTerm)a4).car(), ((ListTerm)a4).cdr()};
            a10 = args[0];
            a11 = args[1];
        } else if (a4.isVariable()){
            a10 = new VariableTerm(engine);
            a11 = new VariableTerm(engine);
            ((VariableTerm) a4).bind(new ListTerm(a10, a11), engine.trail);
        } else {
            return engine.fail();
        }
        a10 = a10.dereference();
        if (a10.isStructure()){
            if (! s15.equals(((StructureTerm)a10).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a10).args();
            if (! a6.unify(args[0], engine.trail))
                return engine.fail();
            if (! a9.unify(args[1], engine.trail))
                return engine.fail();
        } else if (a10.isVariable()){
            Term[] args = {a6, a9};
            ((VariableTerm) a10).bind(new StructureTerm(s15, args), engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        Term[] y1 = {a6, a9};
        a12 = new StructureTerm(s15, y1);
        a13 = new ListTerm(a12, a5);
        return new PRED_$read_tokens_4(a1, a8, a11, a13, cont);
    }
}

class PRED_$read_tokens1_5_7 extends PRED_$read_tokens1_5 {
    public Predicate exec(Prolog engine) {
    // '$read_tokens1'(A,B,[B|C],D,E):-'$read_tokens'(A,C,D,E)
        Term a1, a2, a3, a4, a5, a6;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        a5 = engine.aregs[5];
        cont = engine.cont;
    // '$read_tokens1'(A,B,[B|C],D,E):-['$read_tokens'(A,C,D,E)]
        a3 = a3.dereference();
        if (a3.isList()){
            Term[] args = {((ListTerm)a3).car(), ((ListTerm)a3).cdr()};
            if (! a2.unify(args[0], engine.trail))
                return engine.fail();
            a6 = args[1];
        } else if (a3.isVariable()){
            a6 = new VariableTerm(engine);
            ((VariableTerm) a3).bind(new ListTerm(a2, a6), engine.trail);
        } else {
            return engine.fail();
        }
        return new PRED_$read_tokens_4(a1, a6, a4, a5, cont);
    }
}
