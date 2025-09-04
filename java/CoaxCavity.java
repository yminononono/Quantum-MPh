/*
 * CoaxCavity.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Sep 4 2025, 09:12 by COMSOL 6.3.0.335. */
public class CoaxCavity {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("C:\\Users\\ymino\\Documents\\GitHub\\MPh\\mph");

    model.label("CoaxCavity");

    model.param().label("Parameters");
    model.param().set("outer_radius", "8[mm]");
    model.param().set("outer_height", "38[mm]");
    model.param().set("coax_radius", "1.5[mm]");
    model.param().set("coax_height", "9[mm]");
    model.param().set("antenna_height", "18[mm]");
    model.param().set("antenna_radius", "1.5[mm]");
    model.param().set("antenna_outer_height", "8[mm]");
    model.param().set("antenna_outer_radius", "3[mm]");
    model.param().set("chip_inductance", "9[nH]");
    model.param().set("chip_gap", "200[um]");
    model.param().set("chip_width", "500[um]");
    model.param().set("chip_height", "600[um]");
    model.param().set("chip_theta", "0[deg]");
    model.param().set("chip_fillet", "10[um]");
    model.param().set("chip_pos_z_ratio", "0.6");
    model.param().set("chip_pos_z", "chip_pos_z_ratio*coax_height");
    model.param().set("chip_pos_y", "coax_radius + 0.5*(outer_radius - coax_radius)");
    model.param().set("wafer_height", "0.525[mm]");
    model.param().set("wafer_width", "2[mm]");
    model.param().set("wafer_length", "6[mm]");
    model.param().set("box_height", "40[mm]");
    model.param().set("box_length", "2*outer_radius + 10[mm]");
    model.param().set("jj_width", "20[um]");
    model.param().set("jj_height", "16[um]");
    model.param().set("finger_height", "(chip_gap - jj_height)/2");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);
    model.component("comp1").geom("geom1").lengthUnit("mm");
    model.component("comp1").geom("geom1").run();
    model.component("comp1").geom("geom1").create("block1", "Block");
    model.component("comp1").geom("geom1").feature("block1")
         .set("pos", new String[]{"-box_length/2", "-box_length/2", "outer_height - box_height"});
    model.component("comp1").geom("geom1").feature("block1")
         .set("size", new String[]{"box_length", "box_length", "box_height"});
    model.component("comp1").geom("geom1").run("block1");
    model.component("comp1").geom("geom1").create("wp1", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp1").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp1").geom().create("c1", "Circle");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("c1").set("pos", new double[]{0, 0});
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("c1").set("r", "outer_radius");
    model.component("comp1").geom("geom1").feature("wp1").geom().run("c1");
    model.component("comp1").geom("geom1").create("ext1", "Extrude");
    model.component("comp1").geom("geom1").feature("ext1").set("workplane", "wp1");
    model.component("comp1").geom("geom1").feature("ext1").selection("input").set("wp1");
    model.component("comp1").geom("geom1").feature("ext1").setIndex("distance", "outer_height", 0);
    model.component("comp1").geom("geom1").run("ext1");
    model.component("comp1").geom("geom1").create("wp2", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp2").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp2").geom().create("c2", "Circle");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c2").set("pos", new double[]{0, 0});
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c2").set("r", "coax_radius");
    model.component("comp1").geom("geom1").feature("wp2").geom().run("c2");
    model.component("comp1").geom("geom1").create("ext2", "Extrude");
    model.component("comp1").geom("geom1").feature("ext2").set("workplane", "wp2");
    model.component("comp1").geom("geom1").feature("ext2").selection("input").set("wp2");
    model.component("comp1").geom("geom1").feature("ext2").setIndex("distance", "coax_height", 0);
    model.component("comp1").geom("geom1").run("ext2");
    model.component("comp1").geom("geom1").create("diff1", "Difference");
    model.component("comp1").geom("geom1").feature("diff1").selection("input").set("block1");
    model.component("comp1").geom("geom1").feature("diff1").selection("input2").set("ext1");
    model.component("comp1").geom("geom1").run("diff1");
    model.component("comp1").geom("geom1").create("uni1", "Union");
    model.component("comp1").geom("geom1").feature("uni1").selection("input").set("diff1", "ext2");
    model.component("comp1").geom("geom1").feature("uni1").set("intbnd", false);
    model.component("comp1").geom("geom1").run("uni1");
    model.component("comp1").geom("geom1").create("boundary", "Block");
    model.component("comp1").geom("geom1").feature("boundary")
         .set("pos", new String[]{"-box_length/2", "-box_length/2", "outer_height - box_height"});
    model.component("comp1").geom("geom1").feature("boundary")
         .set("size", new String[]{"box_length", "box_length", "box_height"});
    model.component("comp1").geom("geom1").run("boundary");
    model.component("comp1").geom("geom1").create("air", "Difference");
    model.component("comp1").geom("geom1").feature("air").selection("input").set("boundary");
    model.component("comp1").geom("geom1").feature("air").selection("input2").set("uni1");
    model.component("comp1").geom("geom1").feature("air").set("keepsubtract", true);
    model.component("comp1").geom("geom1").run("air");
    model.component("comp1").geom("geom1").create("wp6", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp6").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp6").set("quickz", "chip_pos_z - wafer_height");
    model.component("comp1").geom("geom1").feature("wp6").geom().create("r3", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r3").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r3")
         .set("pos", new String[]{"0", "chip_pos_y"});
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r3")
         .set("size", new String[]{"wafer_width", "wafer_length"});
    model.component("comp1").geom("geom1").feature("wp6").geom().run("r3");
    model.component("comp1").geom("geom1").feature("wp6").label("Chip");
    model.component("comp1").geom("geom1").run("wp6");
    model.component("comp1").geom("geom1").create("ext6", "Extrude");
    model.component("comp1").geom("geom1").feature("ext6").set("workplane", "wp6");
    model.component("comp1").geom("geom1").feature("ext6").selection("input").set("wp6");
    model.component("comp1").geom("geom1").feature("ext6").setIndex("distance", "wafer_height", 0);
    model.component("comp1").geom("geom1").run("ext6");
    model.component("comp1").geom("geom1").create("wp7", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp7").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp7").set("quickz", "chip_pos_z");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r4", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r4")
         .set("size", new String[]{"chip_width", "chip_height"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r4").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r4")
         .set("pos", new String[]{"0", "chip_pos_y + chip_height/2 + chip_gap/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r4");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("fil3", "Fillet");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil3").selection("pointinsketch")
         .set("r4", 1, 2, 3, 4);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil3").set("radius", "chip_fillet");
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil3");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r5", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r5").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r5")
         .set("pos", new String[]{"0", "chip_pos_y + jj_height/2 + finger_height/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r5")
         .set("size", new String[]{"jj_width", "finger_height"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r5");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("uni2", "Union");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("uni2").selection("input")
         .set("fil3", "r5");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("uni2").set("intbnd", false);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("uni2");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("mir2", "Mirror");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2").selection("input").set("uni2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2")
         .set("pos", new String[]{"0", "chip_pos_y"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2").set("keep", true);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2").set("axis", new double[]{0, 1});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("mir2");
    model.component("comp1").geom("geom1").feature("wp7").label("Transmon pad");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r6", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r6").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r6")
         .set("size", new String[]{"jj_width", "jj_height"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r6")
         .set("pos", new String[]{"0", "chip_pos_y"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r6");
    model.component("comp1").geom("geom1").run("wp7");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").view("view1").set("transparency", true);

    model.component("comp1").geom("geom1").feature("air").set("selresult", true);
    model.component("comp1").geom("geom1").feature("uni1").set("selresult", true);
    model.component("comp1").geom("geom1").feature("ext6").set("selresult", true);
    model.component("comp1").geom("geom1").feature("wp7").set("selresult", true);
    model.component("comp1").geom("geom1").feature("air").set("selresultshow", "all");
    model.component("comp1").geom("geom1").feature("uni1").set("selresultshow", "all");
    model.component("comp1").geom("geom1").feature("ext6").set("selresultshow", "all");
    model.component("comp1").geom("geom1").feature("wp7").set("selresultshow", "all");

    model.component("comp1").material().create("mat3", "Common");
    model.component("comp1").material("mat3").label("Air");
    model.component("comp1").material("mat3").set("family", "air");
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
    model.component("comp1").material("mat3").selection().named("geom1_air_dom");
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat2").propertyGroup()
         .create("Enu", "Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat2").propertyGroup().create("linzRes", "linzRes", "Linearized resistivity");
    model.component("comp1").material("mat2").label("Copper");
    model.component("comp1").material("mat2").set("family", "copper");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("electricconductivity", new String[]{"5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]"});
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"17e-6[1/K]", "0", "0", "0", "17e-6[1/K]", "0", "0", "0", "17e-6[1/K]"});
    model.component("comp1").material("mat2").propertyGroup("def").set("heatcapacity", "385[J/(kg*K)]");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat2").propertyGroup("def").set("density", "8960[kg/m^3]");
    model.component("comp1").material("mat2").propertyGroup("def")
         .set("thermalconductivity", new String[]{"400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]"});
    model.component("comp1").material("mat2").propertyGroup("Enu").set("E", "110[GPa]");
    model.component("comp1").material("mat2").propertyGroup("Enu").set("nu", "0.35");
    model.component("comp1").material("mat2").propertyGroup("linzRes").set("rho0", "1.72e-8[ohm*m]");
    model.component("comp1").material("mat2").propertyGroup("linzRes").set("alpha", "0.0039[1/K]");
    model.component("comp1").material("mat2").propertyGroup("linzRes").set("Tref", "298[K]");
    model.component("comp1").material("mat2").propertyGroup("linzRes").addInput("temperature");
    model.component("comp1").material("mat2").selection().named("geom1_uni1_dom");
    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").label("Silicon");
    model.component("comp1").material("mat1").set("family", "silicon");
    model.component("comp1").material("mat1").propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat1").propertyGroup().create("RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").set("customspecular", new double[]{0.7843137254901961, 1, 1});
    model.component("comp1").material("mat1")
         .set("customdiffuse", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat1")
         .set("customambient", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat1").set("noise", true);
    model.component("comp1").material("mat1").set("fresnel", 0.7);
    model.component("comp1").material("mat1").set("metallic", 0);
    model.component("comp1").material("mat1").set("pearl", 0);
    model.component("comp1").material("mat1").set("diffusewrap", 0);
    model.component("comp1").material("mat1").set("clearcoat", 0);
    model.component("comp1").material("mat1").set("reflectance", 0);
    model.component("comp1").material("mat1").propertyGroup("def").label("Basic");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("electricconductivity", new String[]{"1e-12[S/m]", "0", "0", "0", "1e-12[S/m]", "0", "0", "0", "1e-12[S/m]"});
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalexpansioncoefficient", new String[]{"2.6e-6[1/K]", "0", "0", "0", "2.6e-6[1/K]", "0", "0", "0", "2.6e-6[1/K]"});
    model.component("comp1").material("mat1").propertyGroup("def").set("heatcapacity", "700[J/(kg*K)]");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("relpermittivity", new String[]{"11.7", "0", "0", "0", "11.7", "0", "0", "0", "11.7"});
    model.component("comp1").material("mat1").propertyGroup("def").set("density", "2329[kg/m^3]");
    model.component("comp1").material("mat1").propertyGroup("def")
         .set("thermalconductivity", new String[]{"130[W/(m*K)]", "0", "0", "0", "130[W/(m*K)]", "0", "0", "0", "130[W/(m*K)]"});
    model.component("comp1").material("mat1").propertyGroup("Enu").label("Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("E", "170[GPa]");
    model.component("comp1").material("mat1").propertyGroup("Enu").set("nu", "0.28");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex").label("Refractive index");
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"3.48", "0", "0", "0", "3.48", "0", "0", "0", "3.48"});
    model.component("comp1").material("mat1").set("family", "custom");
    model.component("comp1").material("mat1").set("lighting", "cooktorrance");
    model.component("comp1").material("mat1").set("fresnel", 0.7);
    model.component("comp1").material("mat1").set("roughness", 0.5);
    model.component("comp1").material("mat1").set("anisotropy", 0);
    model.component("comp1").material("mat1").set("flipanisotropy", false);
    model.component("comp1").material("mat1").set("metallic", 0);
    model.component("comp1").material("mat1").set("pearl", 0);
    model.component("comp1").material("mat1").set("diffusewrap", 0);
    model.component("comp1").material("mat1").set("clearcoat", 0);
    model.component("comp1").material("mat1").set("reflectance", 0);
    model.component("comp1").material("mat1").set("ambient", "custom");
    model.component("comp1").material("mat1")
         .set("customambient", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat1").set("diffuse", "custom");
    model.component("comp1").material("mat1")
         .set("customdiffuse", new double[]{0.6666666666666666, 0.6666666666666666, 0.7058823529411765});
    model.component("comp1").material("mat1").set("specular", "custom");
    model.component("comp1").material("mat1").set("customspecular", new double[]{0.7843137254901961, 1, 1});
    model.component("comp1").material("mat1").set("noisecolor", "custom");
    model.component("comp1").material("mat1").set("customnoisecolor", new double[]{0, 0, 0});
    model.component("comp1").material("mat1").set("noisescale", 0);
    model.component("comp1").material("mat1").set("noise", "off");
    model.component("comp1").material("mat1").set("noisefreq", 1);
    model.component("comp1").material("mat1").set("normalnoisebrush", "0");
    model.component("comp1").material("mat1").set("normalnoisetype", "0");
    model.component("comp1").material("mat1").set("alpha", 1);
    model.component("comp1").material("mat1").set("anisotropyaxis", new double[]{0, 0, 1});
    model.component("comp1").material("mat1").selection().named("geom1_ext6_dom");

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("emw", "ElectromagneticWaves", "geom1");
    model.component("comp1").physics("emw").create("pec2", "PerfectElectricConductor", 2);
    model.component("comp1").physics("emw").feature("pec2").selection().named("geom1_uni1_bnd");
    model.component("comp1").physics("emw").create("pec3", "PerfectElectricConductor", 2);
    model.component("comp1").physics("emw").feature("pec3").selection().named("geom1_wp7_bnd");
    model.component("comp1").physics("emw").create("lelement1", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement1").selection().set(20);
    model.component("comp1").physics("emw").feature("lelement1").set("LumpedElementType", "Inductor");
    model.component("comp1").physics("emw").feature("lelement1").set("Lelement", "chip_inductance");

    model.component("comp1").mesh("mesh1").run();

    model.study().create("std1");
    model.study("std1").create("eig", "Eigenfrequency");
    model.study("std1").feature("eig").set("linpsolnum", "auto");
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("ngenAUX", "1");
    model.study("std1").feature("eig").set("goalngenAUX", "1");
    model.study("std1").feature("eig").set("ngenAUX", "1");
    model.study("std1").feature("eig").set("goalngenAUX", "1");
    model.study("std1").feature("eig").setSolveFor("/physics/emw", true);
    model.study("std1").feature("eig").set("shift", "5[GHz]");

    model.sol().create("sol1");
    model.sol("sol1").study("std1");

    model.study("std1").createAutoSequences("all");

    model.sol("sol1").runAll();

    model.result().create("pg1", "PlotGroup3D");
    model.result("pg1").label("Electric Field (emw)");
    model.result("pg1").set("data", "dset1");
    model.result("pg1").set("frametype", "spatial");
    model.result("pg1").set("showlegendsmaxmin", true);
    model.result("pg1").selection().named("geom1_air_dom");
    model.result("pg1").feature().create("mslc1", "Multislice");
    model.result("pg1").feature("mslc1").label("Multislice");
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("smooth", "internal");
    model.result("pg1").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg1").feature("mslc1").set("data", "parent");
    model.result("pg1").feature("mslc1").set("znumber", "0");
    model.result("pg1").feature("mslc1").set("ynumber", "0");
    model.result("pg1").feature("mslc1").set("colortable", "RainbowClassic");
    model.result("pg1").feature("mslc1").set("colorscalemode", "logarithmic");
    model.result("pg1").feature("mslc1").feature().create("filt1", "Filter");
    model.result("pg1").feature("mslc1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().numerical().create("gev1", "EvalGlobal");
    model.result().numerical("gev1").label("Eigenfrequencies (emw)");
    model.result().numerical("gev1").set("data", "dset1");
    model.result().numerical("gev1").set("expr", new String[]{"emw.freq", "emw.Qfactor"});
    model.result().numerical("gev1").set("unit", new String[]{"GHz", "1"});
    model.result().table().create("tbl1", "Table");
    model.result().numerical("gev1").set("table", "tbl1");
    model.result().numerical("gev1").run();
    model.result().numerical("gev1").setResult();

    return model;
  }

  public static Model run2(Model model) {
    model.result("pg1").run();

    model.label("CoaxCavity.mph");

    model.study().create("std2");
    model.study("std2").create("eig", "Eigenfrequency");
    model.study("std2").feature("eig").set("plotgroup", "Default");
    model.study("std2").feature("eig").set("linpsolnum", "auto");
    model.study("std2").feature("eig").set("solnum", "auto");
    model.study("std2").feature("eig").set("notsolnum", "auto");
    model.study("std2").feature("eig").set("outputmap", new String[]{});
    model.study("std2").feature("eig").set("ngenAUX", "1");
    model.study("std2").feature("eig").set("goalngenAUX", "1");
    model.study("std2").feature("eig").set("ngenAUX", "1");
    model.study("std2").feature("eig").set("goalngenAUX", "1");
    model.study("std2").feature("eig").setSolveFor("/physics/emw", true);
    model.study("std2").feature("eig").set("shift", "5[GHz]");
    model.study("std2").feature("eig").set("neigsactive", true);
    model.study("std2").feature("eig").set("neigs", 4);
    model.study("std2").feature("eig").set("eigwhich", "si");
    model.study("std2").createAutoSequences("all");
    model.study("std2").feature("eig").set("neigs", 3);
    model.study("std2").feature("eig").set("eigwhich", "lm");
    model.study("std2").createAutoSequences("all");

    model.sol("sol3").runAll();

    model.result().create("pg2", "PlotGroup3D");
    model.result("pg2").label("Electric Field (emw) 1");
    model.result("pg2").set("data", "dset3");
    model.result("pg2").setIndex("looplevel", 1, 0);
    model.result("pg2").set("frametype", "spatial");
    model.result("pg2").set("showlegendsmaxmin", true);
    model.result("pg2").feature().create("mslc1", "Multislice");
    model.result("pg2").feature("mslc1").label("Multislice");
    model.result("pg2").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg2").feature("mslc1").set("smooth", "internal");
    model.result("pg2").feature("mslc1").set("showsolutionparams", "on");
    model.result("pg2").feature("mslc1").set("data", "parent");
    model.result("pg2").feature("mslc1").feature().create("filt1", "Filter");
    model.result("pg2").feature("mslc1").feature("filt1").set("expr", "!isScalingSystemDomain");
    model.result().numerical().create("gev2", "EvalGlobal");
    model.result().numerical("gev2").label("Eigenfrequencies (emw) 1");
    model.result().numerical("gev2").set("data", "dset3");
    model.result().numerical("gev2").set("expr", new String[]{"emw.freq", "emw.Qfactor"});
    model.result().numerical("gev2").set("unit", new String[]{"GHz", "1"});
    model.result().table().create("tbl2", "Table");
    model.result().numerical("gev2").set("table", "tbl2");
    model.result().numerical("gev2").run();
    model.result().numerical("gev2").setResult();
    model.result("pg2").run();
    model.result("pg2").set("looplevel", new int[]{4});
    model.result("pg2").run();
    model.result("pg1").run();
    model.result("pg1").set("data", "dset3");
    model.result("pg1").set("looplevel", new int[]{4});
    model.result("pg1").run();

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    run2(model);
  }

}
