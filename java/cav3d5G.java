/*
 * cav3d5G.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Sep 4 2025, 00:48 by COMSOL 6.3.0.335. */
public class cav3d5G {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("C:\\Users\\ymino\\Documents\\GitHub\\MPh\\mph");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("emw", "ElectromagneticWaves", "geom1");

    model.study().create("std1");
    model.study("std1").create("eig", "Eigenfrequency");
    model.study("std1").feature("eig").set("conrad", "1");
    model.study("std1").feature("eig").set("linpsolnum", "auto");
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("ngenAUX", "1");
    model.study("std1").feature("eig").set("goalngenAUX", "1");
    model.study("std1").feature("eig").set("ngenAUX", "1");
    model.study("std1").feature("eig").set("goalngenAUX", "1");
    model.study("std1").feature("eig").setSolveFor("/physics/emw", true);

    model.component("comp1").geom("geom1").lengthUnit("\u00b5m");
    model.component("comp1").geom("geom1").create("wp1", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp1").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp1").geom().create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("size", new double[]{2.4, 0.7});
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("pos", new double[]{-1.4, -0.35});
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("pos", new int[]{0, 0});
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("size", new int[]{25000, 7000});
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp1").geom().create("r2", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r2").set("size", new double[]{2500, 7000});
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r2").set("pos", new double[]{-2500, 0});
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp1").geom().create("r3", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r3").set("size", new double[]{3000, 7000});
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r3").set("pos", new double[]{25000, 0});
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r3");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r3").set("size", new int[]{2500, 7000});
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r3");
    model.component("comp1").geom("geom1").run();
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r3");
    model.component("comp1").geom("geom1").feature("wp1").geom().create("fil1", "Fillet");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("fil1").selection("pointinsketch")
         .set("r2", 1, 4);
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("fil1").selection("pointinsketch")
         .set("r3", 2, 3);
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("fil1").set("radius", 2500);
    model.component("comp1").geom("geom1").feature("wp1").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp1").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp1").geom().create("uni1", "Union");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("uni1").selection("input")
         .set("fil1", "r1");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("uni1").set("intbnd", false);
    model.component("comp1").geom("geom1").feature("wp1").geom().run("uni1");
    model.component("comp1").geom("geom1").feature("wp1").label("cav-def");
    model.component("comp1").geom("geom1").run("wp1");
    model.component("comp1").geom("geom1").feature().create("ext1", "Extrude");
    model.component("comp1").geom("geom1").feature("ext1").set("workplane", "wp1");
    model.component("comp1").geom("geom1").feature("ext1").selection("input").set("wp1");
    model.component("comp1").geom("geom1").feature("ext1").setIndex("distance", 28000, 0);
    model.component("comp1").geom("geom1").runPre("fin");

    model.component("comp1").view("view1").set("transparency", true);

    model.component("comp1").geom("geom1").feature("ext1").setIndex("distance", "Lcav", 0);

    model.param().set("Lcav", "28 [mm]");

    model.component("comp1").geom("geom1").run("ext1");
    model.component("comp1").geom("geom1").create("wp2", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp2").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp2").label("Ports-def");
    model.component("comp1").geom("geom1").feature("wp2").set("quickplane", "zx");

    model.param().set("Lp", "7 [mm]");

    model.component("comp1").geom("geom1").feature("wp2").set("quickplane", "xz");
    model.component("comp1").geom("geom1").feature("wp2").geom().create("c1", "Circle");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1").set("r", 5000);
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1")
         .set("pos", new double[]{13000, 18000});
    model.component("comp1").geom("geom1").feature("wp2").geom().run("c1");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1")
         .set("pos", new String[]{"15000", "28000 - 8000"});
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1").set("r", 2100);
    model.component("comp1").geom("geom1").feature("wp2").geom().run("c1");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1").setIndex("pos", 12500, 0);
    model.component("comp1").geom("geom1").feature("wp2").geom().run("c1");
    model.component("comp1").geom("geom1").feature("wp2").geom().run("c1");
    model.component("comp1").geom("geom1").feature("wp2").geom().create("mir1", "Mirror");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").selection("input").set("c1");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").set("pos", new int[]{0, 14000});
    model.component("comp1").geom("geom1").feature("wp2").geom().run("mir1");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").set("axis", new int[]{0, 1});
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").set("keep", true);
    model.component("comp1").geom("geom1").feature("wp2").geom().run("mir1");
    model.component("comp1").geom("geom1").run("wp2");
    model.component("comp1").geom("geom1").feature().create("ext2", "Extrude");
    model.component("comp1").geom("geom1").feature("ext2").set("workplane", "wp2");
    model.component("comp1").geom("geom1").feature("ext2").selection("input").set("wp2");
    model.component("comp1").geom("geom1").feature("ext2").setIndex("distance", "-Lp", 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("ext2").setIndex("distance", "Lp", 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("ext2").label("Ports");

    model.param().set("L_in", "6000 [um]");
    model.param().set("L_out", "6000 [um]");

    model.component("comp1").geom("geom1").run("ext2");
    model.component("comp1").geom("geom1").create("wp3", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp3").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp3").set("quickplane", "xz");
    model.component("comp1").geom("geom1").feature("wp3").set("quicky", "-Lp");
    model.component("comp1").geom("geom1").feature("wp3").geom().create("c1", "Circle");
    model.component("comp1").geom("geom1").feature("wp3").geom().feature("c1").set("r", 1500);
    model.component("comp1").geom("geom1").feature("wp3").geom().feature("c1")
         .set("pos", new double[]{12500, 20000});
    model.component("comp1").geom("geom1").feature("wp3").geom().run("c1");
    model.component("comp1").geom("geom1").feature("wp3").geom().feature("c1").set("r", 200);
    model.component("comp1").geom("geom1").feature("wp3").label("Pin-def");
    model.component("comp1").geom("geom1").run("wp3");
    model.component("comp1").geom("geom1").feature().create("ext3", "Extrude");
    model.component("comp1").geom("geom1").feature("ext3").set("workplane", "wp3");
    model.component("comp1").geom("geom1").feature("ext3").selection("input").set("wp3");
    model.component("comp1").geom("geom1").feature("ext3").setIndex("distance", "L_in", 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("ext3").setIndex("distance", "-L_in", 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("ext3").label("Pin");
    model.component("comp1").geom("geom1").run("ext3");
    model.component("comp1").geom("geom1").create("wp4", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp4").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp4").label("Pout-def");
    model.component("comp1").geom("geom1").feature("wp4").set("quickz", "-Lp");
    model.component("comp1").geom("geom1").feature("wp4").set("quickplane", "xz");
    model.component("comp1").geom("geom1").feature("wp4").set("quicky", "-Lp");
    model.component("comp1").geom("geom1").feature("wp4").geom().create("c1", "Circle");
    model.component("comp1").geom("geom1").feature("wp4").geom().feature("c1").set("r", 1000);
    model.component("comp1").geom("geom1").feature("wp4").geom().feature("c1").set("pos", new double[]{12500, 8000});
    model.component("comp1").geom("geom1").feature("wp4").geom().run("c1");
    model.component("comp1").geom("geom1").feature("wp3").geom().feature("c1").set("r", 300);
    model.component("comp1").geom("geom1").feature("wp4").geom().feature("c1").set("r", 300);
    model.component("comp1").geom("geom1").run("wp4");
    model.component("comp1").geom("geom1").feature().create("ext4", "Extrude");
    model.component("comp1").geom("geom1").feature("ext4").set("workplane", "wp4");
    model.component("comp1").geom("geom1").feature("ext4").selection("input").set("wp4");
    model.component("comp1").geom("geom1").feature("ext4").setIndex("distance", "-L_out", 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run("ext4");
    model.component("comp1").geom("geom1").create("imp1", "Import");
    model.component("comp1").geom("geom1").feature().remove("imp1");
    model.component("comp1").geom("geom1").run("ext4");
    model.component("comp1").geom("geom1").create("wp5", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp5").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp5").set("quickz", 14000);
    model.component("comp1").geom("geom1").feature("wp5").geom().create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r1").set("size", new double[]{2000, 7000});
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r1").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r1").set("pos", new double[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp5").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r1").set("size", new int[]{3000, 14000});
    model.component("comp1").geom("geom1").feature("wp5").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp5").geom().create("fil1", "Fillet");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("fil1").set("radius", 833.55859375);
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("fil1").selection("pointinsketch")
         .set("r1", 4, 3, 1, 2);
    model.component("comp1").geom("geom1").feature("wp5").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("fil1").set("radius", 1000);
    model.component("comp1").geom("geom1").feature("wp5").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp5").label("Chip space-def");
    model.component("comp1").geom("geom1").run("wp5");
    model.component("comp1").geom("geom1").feature().create("ext5", "Extrude");
    model.component("comp1").geom("geom1").feature("ext5").set("workplane", "wp5");
    model.component("comp1").geom("geom1").feature("ext5").selection("input").set("wp5");
    model.component("comp1").geom("geom1").feature("ext5").setIndex("distance", -650, 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("ext5").label("Chip space");
    model.component("comp1").geom("geom1").run("ext5");
    model.component("comp1").geom("geom1").create("uni1", "Union");
    model.component("comp1").geom("geom1").feature("uni1").selection("input").set("ext1", "ext2", "ext5");
    model.component("comp1").geom("geom1").feature("uni1").set("intbnd", false);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run("uni1");
    model.component("comp1").geom("geom1").create("wp6", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp6").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp6").set("quickz", "14000-650");
    model.component("comp1").geom("geom1").feature("wp6").geom().create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r1").set("size", new double[]{2000, 8000});
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r1").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r1").set("pos", new double[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp6").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r1").set("size", new int[]{3000, 12000});
    model.component("comp1").geom("geom1").feature("wp6").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp6").label("Chip");
    model.component("comp1").geom("geom1").run("wp6");
    model.component("comp1").geom("geom1").feature().create("ext6", "Extrude");
    model.component("comp1").geom("geom1").feature("ext6").set("workplane", "wp6");
    model.component("comp1").geom("geom1").feature("ext6").selection("input").set("wp6");
    model.component("comp1").geom("geom1").feature("ext6").setIndex("distance", 300, 0);
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").propertyGroup().create("NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat1").propertyGroup().create("idealGas", "Ideal gas");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat1").label("Air");
    model.component("comp1").material("mat1").set("family", "air");
    model.component("comp1").material("mat1").propertyGroup("def").label("Basic");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").label("Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").label("Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("k").label("Piecewise 3");
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").label("Analytic 2");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").label("Analytic 1");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").label("Analytic 2a");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2")
         .set("plotargs", new String[][]{{"T", "200", "1600"}});
    model.component("comp1").material("mat1").propertyGroup("def").set("thermalexpansioncoefficient", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("molarmass", "");
    model.component("comp1").material("mat1").propertyGroup("def").set("bulkviscosity", "");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
    model.component("comp1").material("mat1").propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat1").propertyGroup("def").set("bulkviscosity", "muB(T)");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def").set("dynamicviscosity", "eta(T)");
    model.component("comp1").material("mat1").propertyGroup("def").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
    model.component("comp1").material("mat1").propertyGroup("def").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat1").propertyGroup("def").set("density", "rho(pA,T)");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
    model.component("comp1").material("mat1").propertyGroup("def").set("soundspeed", "cs(T)");
    model.component("comp1").material("mat1").propertyGroup("def").addInput("temperature");
    model.component("comp1").material("mat1").propertyGroup("def").addInput("pressure");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").label("Refractive index");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("NonlinearModel").label("Nonlinear model");
    model.component("comp1").material("mat1").propertyGroup("NonlinearModel").set("BA", "(def.gamma+1)/2");
    model.component("comp1").material("mat1").propertyGroup("idealGas").label("Ideal gas");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("molarmass", "0.02897");
    model.component("comp1").material("mat1").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat1").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat1").materialType("nonSolid");
    model.component("comp1").material("mat1").set("family", "air");
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat2").propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat2").label("Silicon");
    model.component("comp1").material("mat2").set("family", "custom");
    model.component("comp1").material("mat2").set("customspecular", new double[]{0.7843137254901961, 1, 1});
    model.component("comp1").material("mat2")
         .set("customdiffuse", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat2")
         .set("customambient", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat2").set("noise", true);
    model.component("comp1").material("mat2").set("fresnel", 0.7);
    model.component("comp1").material("mat2").set("metallic", 0);
    model.component("comp1").material("mat2").set("pearl", 0);
    model.component("comp1").material("mat2").set("diffusewrap", 0);
    model.component("comp1").material("mat2").set("clearcoat", 0);
    model.component("comp1").material("mat2").set("reflectance", 0);
    model.component("comp1").material("mat2").propertyGroup("def").label("Basic");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("electricconductivity", new String[]{"1e-12[S/m]", "0", "0", "0", "1e-12[S/m]", "0", "0", "0", "1e-12[S/m]"});
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"2.6e-6[1/K]", "0", "0", "0", "2.6e-6[1/K]", "0", "0", "0", "2.6e-6[1/K]"});
    model.component("comp1").material("mat2").propertyGroup("def").set("heatcapacity", "700[J/(kg*K)]");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("relpermittivity", new String[]{"11.7", "0", "0", "0", "11.7", "0", "0", "0", "11.7"});
    model.component("comp1").material("mat2").propertyGroup("def").set("density", "2329[kg/m^3]");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("thermalconductivity", new String[]{"130[W/(m*K)]", "0", "0", "0", "130[W/(m*K)]", "0", "0", "0", "130[W/(m*K)]"});
    model.component("comp1").material("mat2").propertyGroup("Enu").label("Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat2").propertyGroup("Enu").set("E", "170[GPa]");
    model.component("comp1").material("mat2").propertyGroup("Enu").set("nu", "0.28");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex").label("Refractive index");
    model.component("comp1").material("mat2").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"3.48", "0", "0", "0", "3.48", "0", "0", "0", "3.48"});
    model.component("comp1").material("mat2").set("family", "custom");
    model.component("comp1").material("mat2").set("lighting", "cooktorrance");
    model.component("comp1").material("mat2").set("fresnel", 0.7);
    model.component("comp1").material("mat2").set("roughness", 0.5);
    model.component("comp1").material("mat2").set("anisotropy", 0);
    model.component("comp1").material("mat2").set("flipanisotropy", false);
    model.component("comp1").material("mat2").set("metallic", 0);
    model.component("comp1").material("mat2").set("pearl", 0);
    model.component("comp1").material("mat2").set("diffusewrap", 0);
    model.component("comp1").material("mat2").set("clearcoat", 0);
    model.component("comp1").material("mat2").set("reflectance", 0);
    model.component("comp1").material("mat2").set("ambient", "custom");
    model.component("comp1").material("mat2")
         .set("customambient", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat2").set("diffuse", "custom");
    model.component("comp1").material("mat2")
         .set("customdiffuse", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat2").set("specular", "custom");
    model.component("comp1").material("mat2").set("customspecular", new double[]{0.7843137254901961, 1, 1});
    model.component("comp1").material("mat2").set("noisecolor", "custom");
    model.component("comp1").material("mat2").set("customnoisecolor", new double[]{0, 0, 0});
    model.component("comp1").material("mat2").set("noisescale", 0);
    model.component("comp1").material("mat2").set("noise", "off");
    model.component("comp1").material("mat2").set("noisefreq", 1);
    model.component("comp1").material("mat2").set("normalnoisebrush", "0");
    model.component("comp1").material("mat2").set("normalnoisetype", "0");
    model.component("comp1").material("mat2").set("alpha", 1);
    model.component("comp1").material("mat2").set("anisotropyaxis", new double[]{0, 0, 1});
    model.component("comp1").material("mat1").selection().set(1, 3, 4);
    model.component("comp1").material("mat2").selection().set(2);

    model.component("comp1").physics("emw").create("lelement1", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement1").label("Zin");
    model.component("comp1").physics("emw").feature("lelement1").selection().set(13);
    model.component("comp1").physics("emw").feature("lelement1").set("PortType", "Coaxial");
    model.component("comp1").physics("emw").create("lelement2", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement2").label("Zout");
    model.component("comp1").physics("emw").feature("lelement2").selection().set(10);
    model.component("comp1").physics("emw").feature("lelement2").set("PortType", "Coaxial");

    model.study("std1").feature("eig").set("neigsactive", true);
    model.study("std1").feature("eig").set("neigs", 3);
    model.study("std1").feature("eig").set("shift", "7");

    model.sol().create("sol1");
    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");

    return model;
  }

  public static Model run2(Model model) {
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").label("\u96fb\u5834 (emw)");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").set("defaultPlotID", "ElectromagneticWaves/phys1/pdef1/pcond1/pg1");
    model.result("pg1").feature().create("mslc1", "Multislice");
    model.result("pg1").feature("mslc1").label("\u8907\u6570\u65ad\u9762");
    model.result("pg1").feature("mslc1").set("smooth", "internal");
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").feature("mslc1").feature().create("filt1", "Filter");
    model.result("pg1").feature("mslc1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().numerical().create("gev1", "EvalGlobal");
    model.result().numerical("gev1").label("\u56fa\u6709\u5468\u6ce2\u6570 (emw)");
    model.result().numerical("gev1").set("data", "dset1");
    model.result().numerical("gev1").set("expr", new String[]{"emw.freq", "emw.Qfactor"});
    model.result().numerical("gev1").set("unit", new String[]{"GHz", "1"});
    model.result().table().create("tbl1", "Table");
    model.result().numerical("gev1").set("table", "tbl1");

    model.sol("sol1").runAll();

    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.component("comp1").material("mat2").propertyGroup("def").set("relpermittivity", new String[]{"11.45"});

    model.component("comp1").mesh("mesh1").autoMeshSize(3);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").setIndex("expr", "emw.freq", 0);
    model.result().numerical("gev1").setIndex("unit", "GHz", 0);
    model.result().numerical("gev1").setIndex("descr", "\u5468\u6ce2\u6570", 0);
    model.result().numerical("gev1").setIndex("expr", "emw.Qfactor", 1);
    model.result().numerical("gev1").setIndex("unit", 1, 1);
    model.result().numerical("gev1").setIndex("descr", "Q\u5024", 1);
    model.result().numerical("gev1").setIndex("expr", "1/(2*pi*emw.freq/emw.Qfactor)", 2);
    model.result().numerical("gev1").setIndex("unit", "us", 2);
    model.result().numerical("gev1").setIndex("descr", "T1", 2);
    model.result().numerical("gev1").setIndex("expr", "emw.freq/emw.Qfactor", 3);
    model.result().numerical("gev1").setIndex("unit", "MHz", 3);
    model.result().numerical("gev1").setIndex("descr", "kappa", 3);
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").create("pec2", "PerfectElectricConductor", 2);
    model.component("comp1").physics("emw").feature("pec2").selection()
         .set(8, 9, 11, 12, 33, 34, 36, 37, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.param().set("L_in", "4500 [um]");
    model.param().set("L_out", "6200 [um]");

    model.component("comp1").geom("geom1").run("ext6");
    model.component("comp1").geom("geom1").create("wp7", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp7").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp7").set("quickz", "14000-650+300");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").set("size", new double[]{1600, 1200});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").set("pos", new double[]{12000, 5600});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").set("pos", new int[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").set("size", new int[]{250, 400});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r1");

    model.param().set("W", "250");
    model.param().set("D", "400");

    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").set("size", new String[]{"W", "D"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r1");

    model.param().set("A", "100");

    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1")
         .set("pos", new String[]{"12500+D/2+A/2", "3500"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").setIndex("pos", "3500+D/2+A/2", 1);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r1").setIndex("pos", 12500, 0);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature().duplicate("r2", "r1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2").set("pos", new int[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2").set("size", new String[]{"20", "D"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2").set("size", new String[]{"20", "A"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("size", new String[]{"20", "A/2-8"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2-(A/2-8)"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2-8"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2").set("pos", new int[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("size", new String[]{"20", "A/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500-A/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2-A/4"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("size", new String[]{"20", "A/2-8"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r2")
         .set("pos", new String[]{"12500", "3500+A/2-(A/2-8)/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("uni1", "Union");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("uni1").selection("input").set("r1", "r2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("uni1").set("intbnd", false);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("uni1");
    model.component("comp1").geom("geom1").feature("wp7").geom().run("uni1");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("mir1", "Mirror");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir1").selection("input").set("uni1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir1").set("pos", new int[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("mir1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir1").set("keep", true);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir1").set("axis", new int[]{0, 1});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("mir1");
    model.component("comp1").geom("geom1").feature("wp7").label("Transmon pad");
    model.component("comp1").geom("geom1").runPre("fin");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r3", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r3").set("size", new double[]{20, 16});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r3").set("pos", new double[]{12490, 3492});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r3");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").physics("emw").create("lelement3", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement3").selection().set(43);
    model.component("comp1").physics("emw").feature("lelement3").set("LumpedElementType", "Inductor");
    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "13 [nH]");
    model.component("comp1").physics("emw").feature("pec2").selection()
         .set(8, 9, 11, 12, 33, 34, 36, 37, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51);
    model.component("comp1").physics("emw").feature("lelement3").label("LJ");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();

    model.param().set("L_out", "6500 [um]");
    model.param().set("L_in", "4000 [um]");

    model.result("pg1").run();

    model.component("comp1").geom("geom1").run();

    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("rangecoloractive", true);
    model.result("pg1").feature("mslc1").set("rangedataactive", true);
    model.result("pg1").feature("mslc1").set("rangecolormax", 800000);
    model.result("pg1").feature("mslc1").set("rangecoloractive", false);
    model.result("pg1").feature("mslc1").set("rangedataactive", false);
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{5});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{6});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("xnumber", "0");
    model.result("pg1").feature("mslc1").set("ynumber", "0");
    model.result("pg1").feature("mslc1").set("multiplanezmethod", "coord");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("zcoord", "14000-650+300");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.component("comp1").mesh("mesh1").run();
    model.component("comp1").mesh("mesh1").autoMeshSize(2);
    model.component("comp1").mesh("mesh1").run();

    model.component("comp1").geom("geom1").feature("wp7").geom().create("fil1", "Fillet");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil1").set("radius", 24.683349609374545);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil1").selection("pointinsketch")
         .set("uni1", 2, 8, 1, 7);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil1").set("radius", 20);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("fil2", "Fillet");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil2").set("radius", 43.189208984375);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil2").selection("pointinsketch")
         .set("mir1", 1, 7, 8, 2);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil2").set("radius", 20);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil2");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").mesh("mesh1").autoMeshSize(1);
    model.component("comp1").mesh("mesh1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");

    model.component("comp1").mesh("mesh1").autoMeshSize(2);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");

    return model;
  }

  public static Model run3(Model model) {
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("colorscalemode", "logarithmic");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("xnumber", "2");
    model.result("pg1").feature("mslc1").set("ynumber", "2");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("colorscalemode", "linear");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("rangedataactive", true);
    model.result("pg1").feature("mslc1").set("rangedatamax", 350000);
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("rangedatamax", 100000);
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("rangedatamax", 50000);
    model.result("pg1").run();

    model.component("comp1").physics("emw").feature("lelement3").active(false);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("rangedataactive", false);
    model.result("pg1").run();
    model.result("pg1").run();

    model.param().set("A", "200");

    model.component("comp1").geom("geom1").run();

    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.param().set("D", "500");

    model.component("comp1").geom("geom1").run();

    model.param().set("W", "300");

    model.component("comp1").geom("geom1").run();

    model.param().set("W", "200");
    model.param().set("D", "600");

    model.component("comp1").geom("geom1").run();

    model.component("comp1").physics("emw").feature("pec2").selection()
         .set(8, 9, 11, 12, 33, 34, 36, 37, 39, 40, 44, 45, 46, 47, 48, 49, 50, 51);

    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("pec2").selection()
         .set(8, 9, 11, 12, 33, 34, 36, 37, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 51);
    model.component("comp1").physics("emw").feature("lelement3").active(true);
    model.component("comp1").physics("emw").feature("lelement1").active(false);
    model.component("comp1").physics("emw").feature("lelement2").active(false);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical().create("gev2", "EvalGlobal");
    model.result().numerical("gev2").setIndex("expr", "emw.intWe+emw.intWm", 0);
    model.result().numerical("gev2").setIndex("unit", "J", 0);
    model.result().numerical("gev2").setIndex("descr", "", 0);
    model.result().numerical("gev2").setIndex("expr", "emw.intWe", 1);
    model.result().numerical("gev2").setIndex("unit", "J", 1);
    model.result().numerical("gev2").setIndex("descr", "\u5168\u96fb\u6c17\u30a8\u30cd\u30eb\u30ae\u30fc", 1);
    model.result().numerical("gev2").setIndex("expr", "emw.intWm", 2);
    model.result().numerical("gev2").setIndex("unit", "J", 2);
    model.result().numerical("gev2")
         .setIndex("descr", "\u5168\u78c1\u6c17\u30a8\u30cd\u30eb\u30ae\u30fc without LE", 2);
    model.result().numerical("gev2").setIndex("expr", "emw.freq/emw.Qfactor", 3);
    model.result().numerical("gev2").setIndex("unit", "Hz", 3);
    model.result().numerical("gev2").setIndex("descr", "kappa", 3);
    model.result().numerical("gev2").setIndex("expr", "abs(0.25*emw.Ielement_3^2) * Lr + emw.intWm", 4);
    model.result().numerical("gev2").setIndex("unit", "J", 4);
    model.result().numerical("gev2")
         .setIndex("descr", "\u5168\u78c1\u6c17\u30a8\u30cd\u30eb\u30ae\u30fc with LE", 4);
    model.result().numerical("gev2").label("g_qr");
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result().table("tbl1").clearTableData();
    model.result().table().create("tbl2", "Table");
    model.result().table("tbl2").comments("g_qr");
    model.result().numerical("gev2").set("table", "tbl2");
    model.result().numerical("gev2").remove("unit", 4);
    model.result().numerical("gev2").remove("descr", 4);
    model.result().numerical("gev2").remove("expr", new int[]{4});
    model.result().table().create("tbl3", "Table");
    model.result().table("tbl3").comments("g_qr");
    model.result().numerical("gev2").set("table", "tbl3");
    model.result().numerical("gev2").setResult();
    model.result("pg1").run();
    model.result("pg1").run();

    model.param().set("A", "100");
    model.param().set("D", "400");
    model.param().set("W", "250");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl3").clearTableData();
    model.result().numerical("gev2").set("table", "tbl3");
    model.result().numerical("gev2").setResult();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "10 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl3").clearTableData();
    model.result().numerical("gev2").set("table", "tbl3");
    model.result().numerical("gev2").setResult();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.Ey");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("colortable", "Wave");
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.Ex");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.Ez");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("colorscalemode", "linearsymmetric");
    model.result("pg1").feature("mslc1").set("expr", "emw.Ey");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("data", "dset1");
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.component("comp1").material("mat1").selection().set(1, 3, 4);

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "6 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement1").active(true);
    model.component("comp1").physics("emw").feature("lelement2").active(true);
    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "3 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");

    return model;
  }

  public static Model run4(Model model) {
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.normE");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.Ez");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.Ey");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("colorscalemode", "linearsymmetric");
    model.result("pg1").feature("mslc1").set("expr", "emw.Ex");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.normE");
    model.result("pg1").run();

    model.component("comp1").measure().selection().geom(2);
    model.component("comp1").measure().selection().set(43);

    model.component("comp1").physics("emw").feature("lelement3").selection().set(20, 43);

    model.component("comp1").measure().selection().geom(2);
    model.component("comp1").measure().selection().set(20, 43);
    model.component("comp1").measure().selection().geom(2);
    model.component("comp1").measure().selection().set(20, 43);

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "10 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement3").selection().set(43);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").run();

    model.param().set("W", "300");
    model.param().set("A", "200");
    model.param().set("D", "600");

    model.component("comp1").geom("geom1").run();

    model.param().set("W", "100");

    model.component("comp1").geom("geom1").run();

    model.param().set("W", "300");
    model.param().set("A", "100");

    model.component("comp1").geom("geom1").run();

    model.param().set("A", "200");
    model.param().set("D", "300");

    model.component("comp1").geom("geom1").run();

    model.param().set("D", "600");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result("pg1").run();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "6 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "8 [nH]");

    model.param().set("W", "500");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil2");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("mov1", "Move");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mov1").selection("input")
         .set("fil1", "fil2", "r3");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mov1").set("displx", "Shift");

    model.param().set("Shift", "1000");

    model.component("comp1").geom("geom1").run();

    model.param().rename("Shift", "Xs");
    model.param().set("Ys", "1000");

    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mov1").set("displx", "Xs");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mov1").set("disply", "Ys");
    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "9 [nH]");

    model.param().set("Xs", "0");
    model.param().set("Ys", "0");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "3 [nH]");

    return model;
  }

  public static Model run5(Model model) {

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.param().set("W", "250");
    model.param().set("D", "300");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("expr", "emw.Ez");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{5});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();

    model.component("comp1").physics("emw").feature("lelement1").active(false);
    model.component("comp1").physics("emw").feature("lelement2").active(false);

    model.param().set("W", "400");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{4});
    model.result("pg1").run();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "9 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "3 [nH]");

    model.param().set("W", "500");
    model.param().set("D", "600");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.param().set("W", "250");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{4});
    model.result("pg1").run();

    model.param().set("W", "350");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.label("cav3d_cu_v2.mph");

    model.result("pg1").run();

    model.param().set("W", "500");

    model.component("comp1").geom("geom1").run();

    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "9 [nH]");

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);

    return model;
  }

  public static Model run6(Model model) {
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement1").active(true);
    model.component("comp1").physics("emw").feature("lelement2").active(true);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").geom("geom1").feature("wp7").geom().run("mov1");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("rot1", "Rotate");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").selection("input").set("mov1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").set("pos", new int[]{14000, 3500});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("rot1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").set("rot", 90);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("rot1");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").set("pos", new int[]{12500, 3500});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("rot1");
    model.component("comp1").geom("geom1").run();

    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").geom("geom1").feature("wp7").geom().feature().move("rot1", 7);

    model.param().set("Ys", "500");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.param().set("Xs", "500");

    model.result("pg1").run();

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").set("rot", 45);

    model.param().set("Xs", "0");
    model.param().set("Ys", "0");

    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").set("rot", 60);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("mov1");
    model.component("comp1").geom("geom1").run();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").feature("lelement1").active(false);
    model.component("comp1").physics("emw").feature("lelement2").active(false);

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl3").clearTableData();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev2").set("table", "tbl3");
    model.result().numerical("gev2").setResult();

    model.component("comp1").physics("emw").feature("lelement1").active(true);
    model.component("comp1").physics("emw").feature("lelement2").active(true);

    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.sol("sol1").study("std1");

    model.study("std1").feature("eig").set("notlistsolnum", 1);
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("listsolnum", 1);
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("linplistsolnum", new String[]{"1"});
    model.study("std1").feature("eig").set("linpsolnum", "auto");

    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("\u63a8\u5968\u76f4\u63a5\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});

    return model;
  }

  public static Model run7(Model model) {
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result().table("tbl1").clearTableData();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();

    model.component("comp1").physics("emw").create("lport1", "LumpedPort", 2);
    model.component("comp1").physics("emw").feature("lport1").selection().set(43);
    model.component("comp1").physics("emw").feature("lport1").set("TerminalType", "Current");

    model.study().create("std2");
    model.study("std2").create("freq", "Frequency");
    model.study("std2").feature("freq").set("plotgroup", "Default");
    model.study("std2").feature("freq").set("solnum", "auto");
    model.study("std2").feature("freq").set("notsolnum", "auto");
    model.study("std2").feature("freq").set("ngenAUX", "1");
    model.study("std2").feature("freq").set("goalngenAUX", "1");
    model.study("std2").feature("freq").set("ngenAUX", "1");
    model.study("std2").feature("freq").set("goalngenAUX", "1");
    model.study("std2").feature("freq").setSolveFor("/physics/emw", true);
    model.study("std2").feature("freq").set("plist", 5.611);

    model.param().set("R", "60");

    model.component("comp1").geom("geom1").feature("wp7").geom().feature("rot1").set("rot", "R");

    model.param().set("R", "0");

    model.component("comp1").geom("geom1").run();

    model.param().set("R", "60");

    model.component("comp1").geom("geom1").run();

    model.study("std2").create("param", "Parametric");
    model.study("std2").feature("param").setIndex("pname", "Lcav", 0);
    model.study("std2").feature("param").setIndex("plistarr", "", 0);
    model.study("std2").feature("param").setIndex("punit", "m", 0);
    model.study("std2").feature("param").setIndex("pname", "Lcav", 0);
    model.study("std2").feature("param").setIndex("plistarr", "", 0);
    model.study("std2").feature("param").setIndex("punit", "m", 0);
    model.study("std2").feature("param").setIndex("pname", "R", 0);
    model.study("std2").feature("param").setIndex("punit", "degree", 0);
    model.study("std2").feature("param").setIndex("punit", "", 0);
    model.study("std2").feature("param").setIndex("plistarr", "range(0,5,90)", 0);

    model.component("comp1").physics("emw").feature("lelement3").active(false);

    model.sol().create("sol2");
    model.sol("sol2").study("std2");

    model.study("std2").feature("freq").set("notlistsolnum", 1);
    model.study("std2").feature("freq").set("notsolnum", "auto");
    model.study("std2").feature("freq").set("listsolnum", 1);
    model.study("std2").feature("freq").set("solnum", "auto");

    model.sol("sol2").create("st1", "StudyStep");
    model.sol("sol2").feature("st1").set("study", "std2");
    model.sol("sol2").feature("st1").set("studystep", "freq");
    model.sol("sol2").create("v1", "Variables");
    model.sol("sol2").feature("v1").set("control", "freq");
    model.sol("sol2").create("s1", "Stationary");
    model.sol("sol2").feature("s1").set("stol", 0.01);
    model.sol("sol2").feature("s1").create("p1", "Parametric");
    model.sol("sol2").feature("s1").feature().remove("pDef");
    model.sol("sol2").feature("s1").feature("p1").set("pname", new String[]{"freq"});
    model.sol("sol2").feature("s1").feature("p1").set("plistarr", new String[]{"5.611"});
    model.sol("sol2").feature("s1").feature("p1").set("punit", new String[]{"GHz"});
    model.sol("sol2").feature("s1").feature("p1").set("pcontinuationmode", "no");
    model.sol("sol2").feature("s1").feature("p1").set("preusesol", "auto");
    model.sol("sol2").feature("s1").feature("p1").set("pdistrib", "off");
    model.sol("sol2").feature("s1").feature("p1").set("plot", "on");
    model.sol("sol2").feature("s1").feature("p1").set("plotgroup", "Default");
    model.sol("sol2").feature("s1").feature("p1").set("probesel", "all");
    model.sol("sol2").feature("s1").feature("p1").set("probes", new String[]{});
    model.sol("sol2").feature("s1").feature("p1").set("control", "freq");
    model.sol("sol2").feature("s1").set("linpmethod", "sol");
    model.sol("sol2").feature("s1").set("linpsol", "zero");
    model.sol("sol2").feature("s1").set("control", "freq");
    model.sol("sol2").feature("s1").feature("aDef").set("complexfun", true);
    model.sol("sol2").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol2").feature("s1").create("i1", "Iterative");
    model.sol("sol2").feature("s1").feature("i1").set("linsolver", "gmres");
    model.sol("sol2").feature("s1").feature("i1").set("prefuntype", "right");
    model.sol("sol2").feature("s1").feature("i1").set("itrestart", "300");
    model.sol("sol2").feature("s1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol2").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol2").feature("s1").feature("fc1").set("linsolver", "i1");
    model.sol("sol2").feature("s1").feature().remove("fcDef");
    model.sol("sol2").attach("std2");

    model.batch().create("p1", "Parametric");
    model.batch("p1").study("std2");
    model.batch("p1").create("so1", "Solutionseq");
    model.batch("p1").feature("so1").set("seq", "sol2");
    model.batch("p1").feature("so1").set("store", "on");
    model.batch("p1").feature("so1").set("clear", "on");
    model.batch("p1").feature("so1").set("psol", "none");
    model.batch("p1").set("pname", new String[]{"R"});
    model.batch("p1").set("plistarr", new String[]{"range(0,5,90)"});
    model.batch("p1").set("sweeptype", "sparse");
    model.batch("p1").set("probesel", "all");
    model.batch("p1").set("probes", new String[]{});
    model.batch("p1").set("plot", "off");
    model.batch("p1").set("err", "on");
    model.batch("p1").attach("std2");
    model.batch("p1").set("control", "param");

    model.sol().create("sol3");
    model.sol("sol3").study("std2");
    model.sol("sol3").label("\u30d1\u30e9\u30e1\u30c8\u30ea\u30c3\u30af\u89e3 1");

    model.batch("p1").feature("so1").set("psol", "sol3");

    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").label("\u96fb\u5834 (emw) 1");
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").set("data", "dset3");
    model.result("pg2").set("defaultPlotID", "ElectromagneticWaves/phys1/pdef1/pcond1/pg1");
    model.result("pg2").feature().create("mslc1", "Multislice");
    model.result("pg2").feature("mslc1").label("\u8907\u6570\u65ad\u9762");
    model.result("pg2").feature("mslc1").set("smooth", "internal");
    model.result("pg2").feature("mslc1").set("data", "parent");
    model.result("pg2").feature("mslc1").feature().create("filt1", "Filter");
    model.result("pg2").feature("mslc1").feature("filt1").set("expr", "!isScalingSystemDomain");

    model.batch("p1").run("compute");

    model.result("pg2").set("data", "dset3");
    model.result("pg2").run();
    model.result().numerical().create("gev3", "EvalGlobal");
    model.result().numerical("gev3").setIndex("expr", "emw.Vport_1", 0);
    model.result().numerical("gev3").setIndex("unit", "", 0);
    model.result().numerical("gev3").setIndex("descr", "\u96c6\u4e2d\u30dd\u30fc\u30c8\u96fb\u5727", 0);
    model.result().numerical("gev3").setIndex("expr", "emw.Velement_1", 1);
    model.result().numerical("gev3").setIndex("unit", "V", 1);
    model.result().numerical("gev3").setIndex("descr", "Input", 1);
    model.result().numerical("gev3").setIndex("expr", "emw.Velement_2", 2);
    model.result().numerical("gev3").setIndex("unit", "V", 2);
    model.result().numerical("gev3").setIndex("descr", "Output", 2);
    model.result().numerical("gev3").setIndex("expr", "emw.Velement_7", 3);
    model.result().numerical("gev3").setIndex("unit", "V", 3);
    model.result().numerical("gev3").setIndex("descr", "Drive0", 3);
    model.result().numerical("gev3").setIndex("expr", "emw.Velement_8", 4);
    model.result().numerical("gev3").setIndex("unit", "V", 4);
    model.result().numerical("gev3").setIndex("descr", "Drive1", 4);
    model.result().numerical("gev3").set("data", "dset3");
    model.result().numerical("gev3").remove("unit", new int[]{3, 4});
    model.result().numerical("gev3").remove("descr", new int[]{3, 4});
    model.result().numerical("gev3").remove("expr", new int[]{3, 4});
    model.result().table("tbl1").clearTableData();
    model.result().table().create("tbl4", "Table");
    model.result().table("tbl4").comments("\u30b0\u30ed\u30fc\u30d0\u30eb\u8a55\u4fa1 3");
    model.result().numerical("gev3").set("table", "tbl4");
    model.result().numerical("gev3").setResult();
    model.result().table("tbl4").save("C:\\Users\\hqcrt\\COMSOL_data\\Shirai\\ICEPP\\rot_kappa.csv");

    model.study("std2").feature("param").setIndex("plistarr", "range(0,3,88)", 0);

    model.sol("sol2").study("std2");

    model.study("std2").feature("freq").set("notlistsolnum", 1);
    model.study("std2").feature("freq").set("notsolnum", "auto");
    model.study("std2").feature("freq").set("listsolnum", 1);
    model.study("std2").feature("freq").set("solnum", "auto");

    model.sol("sol2").feature().remove("s1");
    model.sol("sol2").feature().remove("v1");
    model.sol("sol2").feature().remove("st1");
    model.sol("sol2").create("st1", "StudyStep");
    model.sol("sol2").feature("st1").set("study", "std2");
    model.sol("sol2").feature("st1").set("studystep", "freq");
    model.sol("sol2").create("v1", "Variables");
    model.sol("sol2").feature("v1").set("control", "freq");
    model.sol("sol2").create("s1", "Stationary");
    model.sol("sol2").feature("s1").set("stol", 0.01);
    model.sol("sol2").feature("s1").create("p1", "Parametric");
    model.sol("sol2").feature("s1").feature().remove("pDef");
    model.sol("sol2").feature("s1").feature("p1").set("pname", new String[]{"freq"});
    model.sol("sol2").feature("s1").feature("p1").set("plistarr", new String[]{"5.611"});
    model.sol("sol2").feature("s1").feature("p1").set("punit", new String[]{"GHz"});
    model.sol("sol2").feature("s1").feature("p1").set("pcontinuationmode", "no");
    model.sol("sol2").feature("s1").feature("p1").set("preusesol", "auto");
    model.sol("sol2").feature("s1").feature("p1").set("pdistrib", "off");
    model.sol("sol2").feature("s1").feature("p1").set("plot", "on");
    model.sol("sol2").feature("s1").feature("p1").set("plotgroup", "pg1");
    model.sol("sol2").feature("s1").feature("p1").set("probesel", "all");
    model.sol("sol2").feature("s1").feature("p1").set("probes", new String[]{});
    model.sol("sol2").feature("s1").feature("p1").set("control", "freq");
    model.sol("sol2").feature("s1").set("linpmethod", "sol");
    model.sol("sol2").feature("s1").set("linpsol", "zero");
    model.sol("sol2").feature("s1").set("control", "freq");
    model.sol("sol2").feature("s1").feature("aDef").set("complexfun", true);
    model.sol("sol2").feature("s1").create("fc1", "FullyCoupled");
    model.sol("sol2").feature("s1").create("i1", "Iterative");
    model.sol("sol2").feature("s1").feature("i1").set("linsolver", "gmres");
    model.sol("sol2").feature("s1").feature("i1").set("prefuntype", "right");
    model.sol("sol2").feature("s1").feature("i1").set("itrestart", "300");
    model.sol("sol2").feature("s1").feature("i1").label("\u63a8\u5968\u53cd\u5fa9\u30bd\u30eb\u30d0\u30fc (emw)");
    model.sol("sol2").feature("s1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol2").feature("s1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol2").feature("s1").feature("fc1").set("linsolver", "i1");
    model.sol("sol2").feature("s1").feature().remove("fcDef");
    model.sol("sol2").attach("std2");

    model.batch("p1").feature().remove("so1");
    model.batch("p1").create("so1", "Solutionseq");
    model.batch("p1").feature("so1").set("seq", "sol2");
    model.batch("p1").feature("so1").set("store", "on");
    model.batch("p1").feature("so1").set("clear", "on");
    model.batch("p1").feature("so1").set("psol", "sol3");
    model.batch("p1").set("pname", new String[]{"R"});
    model.batch("p1").set("plistarr", new String[]{"range(0,3,88)"});
    model.batch("p1").set("sweeptype", "sparse");
    model.batch("p1").set("probesel", "all");
    model.batch("p1").set("probes", new String[]{});
    model.batch("p1").set("plot", "off");
    model.batch("p1").set("err", "on");
    model.batch("p1").attach("std2");
    model.batch("p1").set("control", "param");
    model.batch("p1").run("compute");

    model.result("pg2").run();
    model.result().table("tbl4").clearTableData();
    model.result().numerical("gev3").label("decay");
    model.result().numerical("gev3").set("table", "tbl4");
    model.result().numerical("gev3").setResult();
    model.result().table("tbl4").save("C:\\Users\\hqcrt\\COMSOL_data\\Shirai\\ICEPP\\rot_kappa2.csv");

    model.component("comp1").geom("geom1").run();

    model.label("cav3d_cu_v2.mph");

    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.sol("sol1").clearSolutionData();
    model.sol("sol2").clearSolutionData();
    model.sol("sol3").clearSolutionData();
    model.sol("sol4").clearSolutionData();
    model.sol("sol5").clearSolutionData();
    model.sol("sol6").clearSolutionData();
    model.sol("sol7").clearSolutionData();
    model.sol("sol8").clearSolutionData();
    model.sol("sol9").clearSolutionData();
    model.sol("sol10").clearSolutionData();
    model.sol("sol11").clearSolutionData();
    model.sol("sol12").clearSolutionData();
    model.sol("sol13").clearSolutionData();
    model.sol("sol14").clearSolutionData();
    model.sol("sol15").clearSolutionData();
    model.sol("sol16").clearSolutionData();
    model.sol("sol17").clearSolutionData();
    model.sol("sol18").clearSolutionData();
    model.sol("sol19").clearSolutionData();
    model.sol("sol20").clearSolutionData();
    model.sol("sol21").clearSolutionData();
    model.sol("sol22").clearSolutionData();
    model.sol("sol23").clearSolutionData();
    model.sol("sol24").clearSolutionData();
    model.sol("sol25").clearSolutionData();
    model.sol("sol26").clearSolutionData();
    model.sol("sol27").clearSolutionData();
    model.sol("sol28").clearSolutionData();
    model.sol("sol29").clearSolutionData();
    model.sol("sol30").clearSolutionData();
    model.sol("sol31").clearSolutionData();
    model.sol("sol32").clearSolutionData();
    model.sol("sol33").clearSolutionData();

    model.label("cav3d5G.mph");

    model.result("pg1").run();
    model.result("pg2").run();

    model.sol("sol1").study("std1");
    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").feature("aDef").set("cachepattern", false);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("Suggested Direct Solver (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("Suggested Iterative Solver (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runFromTo("st1", "e1");

    model.result("pg1").run();
    model.result("pg1").set("data", "dset2");
    model.result("pg1").run();
    model.result("pg1").set("data", "dset1");
    model.result("pg1").run();
    model.result("pg1").set("data", "dset3");
    model.result("pg1").run();
    model.result("pg1").set("data", "dset2");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();

    model.label("cav3d5G.mph");

    model.result("pg1").run();
    model.result("pg1").run();

    model.param().set("R", "0");

    model.component("comp1").geom("geom1").run("fin");

    model.sol("sol1").study("std1");
    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").feature("aDef").set("cachepattern", false);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("Suggested Direct Solver (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("Suggested Iterative Solver (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();

    model.component("comp1").physics("emw").feature("lport1").active(false);
    model.component("comp1").physics("emw").feature("lelement3").active(true);

    model.sol("sol1").study("std1");
    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").feature("aDef").set("cachepattern", false);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("Suggested Direct Solver (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("Suggested Iterative Solver (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").appendResult();
    model.result().table().remove("tbl1");
    model.result().table().create("tbl5", "Table");
    model.result().table("tbl5").comments("\u56fa\u6709\u5468\u6ce2\u6570 (emw)");
    model.result().numerical("gev1").set("table", "tbl5");
    model.result().numerical("gev1").setResult();
    model.result("pg1").run();
    model.result("pg1").create("arwv1", "ArrowVolume");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("arwv1").set("data", "dset2");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("arwv1").set("data", "dset1");
    model.result("pg1").feature("arwv1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("data", "dset1");
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").run();
    model.result("pg1").feature("arwv1").set("data", "parent");
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").create("arwv2", "ArrowVolume");
    model.result("pg1").feature("arwv2").set("expr", new String[]{"emw.Hx", "emw.Hy", "emw.Hz"});
    model.result("pg1").feature("arwv2").set("descr", "Magnetic field");
    model.result("pg1").run();
    model.result("pg1").feature("arwv2").set("color", "blue");
    model.result("pg1").run();
    model.result("pg1").feature("arwv2").set("color", "green");
    model.result("pg1").run();
    model.result("pg1").set("phasetype", "manual");
    model.result("pg1").set("phase", 45);
    model.result("pg1").run();
    model.result("pg1").set("phase", 90);
    model.result("pg1").run();
    model.result("pg1").set("phase", 180);

    return model;
  }

  public static Model run8(Model model) {
    model.result("pg1").run();
    model.result("pg1").set("phase", 270);
    model.result("pg1").run();
    model.result("pg1").set("phase", 360);
    model.result("pg1").run();
    model.result("pg1").set("phase", 0);
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").stepFirst(0);
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{4});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{5});
    model.result("pg1").run();

    model.label("cav3d5G.mph");

    model.result("pg1").run();

    model.component("comp1").geom("geom1").lengthUnit("\u00b5in");
    model.component("comp1").geom("geom1").lengthUnit("\u00b5m");
    model.component("comp1").geom("geom1").feature("wp1").geom().runPre("fil1");

    model.result("pg2").run();
    model.result("pg2").run();

    model.sol("sol1").study("std1");
    model.sol("sol1").feature().remove("e1");
    model.sol("sol1").feature().remove("v1");
    model.sol("sol1").feature().remove("st1");
    model.sol("sol1").create("st1", "StudyStep");
    model.sol("sol1").feature("st1").set("study", "std1");
    model.sol("sol1").feature("st1").set("studystep", "eig");
    model.sol("sol1").create("v1", "Variables");
    model.sol("sol1").feature("v1").set("control", "eig");
    model.sol("sol1").create("e1", "Eigenvalue");
    model.sol("sol1").feature("e1").set("eigref", "7");
    model.sol("sol1").feature("e1").set("control", "eig");
    model.sol("sol1").feature("e1").feature("aDef").set("complexfun", true);
    model.sol("sol1").feature("e1").feature("aDef").set("cachepattern", false);
    model.sol("sol1").feature("e1").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("d1").set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").label("Suggested Direct Solver (emw)");
    model.sol("sol1").feature("e1").create("i1", "Iterative");
    model.sol("sol1").feature("e1").feature("i1").set("linsolver", "gmres");
    model.sol("sol1").feature("e1").feature("i1").set("prefuntype", "right");
    model.sol("sol1").feature("e1").feature("i1").set("itrestart", "300");
    model.sol("sol1").feature("e1").feature("i1").label("Suggested Iterative Solver (emw)");
    model.sol("sol1").feature("e1").feature("i1").create("mg1", "Multigrid");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").set("iter", "1");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("prefun", "sorvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("pr").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").create("sv1", "SORVector");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("prefun", "soruvec");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("iter", 2);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1").set("relax", 1);
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("po").feature("sv1")
         .set("sorvecdof", new String[]{"comp1_E"});
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").create("d1", "Direct");
    model.sol("sol1").feature("e1").feature("i1").feature("mg1").feature("cs").feature("d1")
         .set("linsolver", "pardiso");
    model.sol("sol1").feature("e1").feature("d1").active(true);
    model.sol("sol1").attach("std1");
    model.sol("sol1").runAll();

    model.result("pg1").run();
    model.result("pg2").run();
    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result().create("pg3", "PlotGroup2D");
    model.result("pg3").run();
    model.result().remove("pg3");
    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result().create("pg3", "PlotGroup2D");
    model.result("pg3").run();
    model.result().remove("pg3");
    model.result().create("pg3", "PlotGroup3D");
    model.result("pg3").run();
    model.result("pg3").set("looplevel", new int[]{2});
    model.result().remove("pg3");
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").create("slc1", "Slice");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature().remove("slc1");
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("arwv1").active(false);
    model.result("pg1").run();
    model.result("pg1").feature("arwv2").active(false);
    model.result("pg1").run();
    model.result("pg1").feature("mslc1").active(false);
    model.result("pg1").feature("mslc1").active(true);
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{2});
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").create("slc1", "Slice");
    model.result("pg1").run();
    model.result("pg1").feature("slc1").set("colorscalemode", "logarithmic");
    model.result("pg1").feature("slc1").set("quickxnumber", 3);
    model.result("pg1").run();
    model.result("pg1").feature("slc1").set("quickplane", "zx");
    model.result("pg1").run();
    model.result("pg1").feature("slc1").set("quickynumber", 1);
    model.result("pg1").run();
    model.result("pg1").run();
    model.result("pg1").feature("slc1").set("quickynumber", 1);
    model.result("pg1").run();
    model.result("pg1").feature("slc1").set("colorscalemode", "linear");
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{3});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{1});
    model.result("pg1").run();
    model.result("pg1").set("looplevel", new int[]{4});
    model.result("pg1").run();

    model.component("comp1").geom("geom1").feature("wp1").set("unite", true);

    model.component("comp1").view("view1").set("showDirections", false);
    model.component("comp1").view("view1").set("showlabels", false);
    model.component("comp1").view("view1").set("renderwireframe", false);
    model.component("comp1").view("view1").set("transparency", true);
    model.component("comp1").view("view1").set("ssao", false);
    model.component("comp1").view("view1").set("shadowmapping", false);

    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").setAttribute("construction", "off");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1")
         .setAttribute("construction", "inherit");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").material().create("mat3", "Common");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat3").propertyGroup()
         .create("RefractiveIndex", "RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat3").propertyGroup()
         .create("NonlinearModel", "NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat3").propertyGroup().create("idealGas", "idealGas", "Ideal gas");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat3").label("Air 1");
    model.component("comp1").material("mat3").set("family", "air");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotaxis", new String[]{"off", "on"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotfixedvalue", new String[]{"101325", "273.15"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("plotfixedvalue", new String[]{"273.15"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotaxis", new String[]{"off", "on"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotfixedvalue", new String[]{"101325", "273.15"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2")
         .set("plotfixedvalue", new String[]{"200"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2")
         .set("plotargs", new String[][]{{"T", "200", "1600"}});
    model.component("comp1").material("mat3").propertyGroup("def").set("thermalexpansioncoefficient", "");
    model.component("comp1").material("mat3").propertyGroup("def").set("molarmass", "");
    model.component("comp1").material("mat3").propertyGroup("def").set("bulkviscosity", "");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
    model.component("comp1").material("mat3").propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat3").propertyGroup("def").set("bulkviscosity", "muB(T)");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("def").set("dynamicviscosity", "eta(T)");
    model.component("comp1").material("mat3").propertyGroup("def").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
    model.component("comp1").material("mat3").propertyGroup("def").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat3").propertyGroup("def").set("density", "rho(pA,T)");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
    model.component("comp1").material("mat3").propertyGroup("def").set("soundspeed", "cs(T)");
    model.component("comp1").material("mat3").propertyGroup("def").addInput("temperature");
    model.component("comp1").material("mat3").propertyGroup("def").addInput("pressure");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("NonlinearModel").set("BA", "def.gamma-1");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat3").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat3").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat3").materialType("nonSolid");
    model.component("comp1").material().remove("mat3");

    model.component("comp1").geom("geom1").runPre("uni1");

    model.component("comp1").material("mat1").selection().set();
    model.component("comp1").material("mat1").selection().all();
    model.component("comp1").material("mat1").selection().set(1, 3, 4);
    model.component("comp1").material("mat2").selection().set(1, 2);
    model.component("comp1").material().create("mat3", "Common");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat3").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat3").propertyGroup()
         .create("RefractiveIndex", "RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat3").propertyGroup()
         .create("NonlinearModel", "NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat3").propertyGroup().create("idealGas", "idealGas", "Ideal gas");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat3").label("Air 1");
    model.component("comp1").material("mat3").set("family", "air");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotaxis", new String[]{"off", "on"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotfixedvalue", new String[]{"101325", "273.15"});
    model.component("comp1").material("mat3").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat3").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("plotfixedvalue", new String[]{"273.15"});
    model.component("comp1").material("mat3").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotaxis", new String[]{"off", "on"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotfixedvalue", new String[]{"101325", "273.15"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat3").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2")
         .set("plotfixedvalue", new String[]{"200"});
    model.component("comp1").material("mat3").propertyGroup("def").func("an2")
         .set("plotargs", new String[][]{{"T", "200", "1600"}});
    model.component("comp1").material("mat3").propertyGroup("def").set("thermalexpansioncoefficient", "");
    model.component("comp1").material("mat3").propertyGroup("def").set("molarmass", "");
    model.component("comp1").material("mat3").propertyGroup("def").set("bulkviscosity", "");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
    model.component("comp1").material("mat3").propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat3").propertyGroup("def").set("bulkviscosity", "muB(T)");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("def").set("dynamicviscosity", "eta(T)");
    model.component("comp1").material("mat3").propertyGroup("def").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
    model.component("comp1").material("mat3").propertyGroup("def").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat3").propertyGroup("def").set("density", "rho(pA,T)");
    model.component("comp1").material("mat3").propertyGroup("def")
         .set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
    model.component("comp1").material("mat3").propertyGroup("def").set("soundspeed", "cs(T)");
    model.component("comp1").material("mat3").propertyGroup("def").addInput("temperature");
    model.component("comp1").material("mat3").propertyGroup("def").addInput("pressure");
    model.component("comp1").material("mat3").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat3").propertyGroup("NonlinearModel").set("BA", "def.gamma-1");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat3").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat3").propertyGroup("idealGas").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat3").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat3").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat3").materialType("nonSolid");
    model.component("comp1").material("mat3").selection().set(1);

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    model = run2(model);
    model = run3(model);
    model = run4(model);
    model = run5(model);
    model = run6(model);
    model = run7(model);
    run8(model);
  }

}
