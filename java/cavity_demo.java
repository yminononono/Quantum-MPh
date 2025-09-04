/*
 * cavity_demo.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Sep 4 2025, 02:33 by COMSOL 6.3.0.335. */
public class cavity_demo {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("C:\\Users\\ymino\\Documents\\GitHub\\MPh\\mph");

    model.label("cavity");

    model.param().label("Parameters");
    model.param().set("cavity_width", "30[mm]");
    model.param().set("cavity_length", "7[mm]");
    model.param().set("cavity_height", "28[mm]");
    model.param().set("cavity_fillet", "2.5[mm]");
    model.param().set("port_distance", "12[mm]");
    model.param().set("port_height", "7[mm]");
    model.param().set("port_in_depth", "4[mm]");
    model.param().set("port_out_depth", "6.5[mm]");
    model.param().set("port_inner_radius", "0.3[mm]");
    model.param().set("port_outer_radius", "2.1[mm]");
    model.param().set("wafer_space_fillet", "1[mm]");
    model.param().set("wafer_space_length", "2*cavity_length");
    model.param().set("wafer_space_height", "0.650[mm]");
    model.param().set("wafer_space_width", "wafer_width");
    model.param().set("wafer_height", "0.300[mm]");
    model.param().set("wafer_width", "3[mm]");
    model.param().set("wafer_length", "wafer_space_length - 2*wafer_space_fillet");
    model.param().set("chip_gap", "200[um]");
    model.param().set("chip_width", "500[um]");
    model.param().set("chip_height", "600[um]");
    model.param().set("chip_fillet", "10[um]");
    model.param().set("chip_inductance", "9[nH]");
    model.param().set("jj_width", "20[um]");
    model.param().set("jj_height", "16[um]");
    model.param().set("finger_height", "(chip_gap - jj_height)/2");
    model.param().set("cavity_width", "30[mm]", "Cavity Width");
    model.param().set("cavity_length", "7[mm]", "Cavity Length");
    model.param().set("cavity_height", "28[mm]", "Cavity Height");
    model.param().set("cavity_fillet", "2.5[mm]", "Rounding Radius for cavity");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);
    model.component("comp1").geom("geom1").lengthUnit("um");
    model.component("comp1").geom("geom1").run();
    model.component("comp1").geom("geom1").create("wp1", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp1").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp1").geom().create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1")
         .set("size", new String[]{"cavity_width", "cavity_length"});
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1")
         .set("pos", new String[]{"-cavity_width/2", "0"});
    model.component("comp1").geom("geom1").feature("wp1").geom().run("r1");
    model.component("comp1").geom("geom1").feature("wp1").geom().create("fil1", "Fillet");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("fil1").selection("pointinsketch")
         .set("r1", 1, 2, 3, 4);
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("fil1").set("radius", "cavity_fillet");
    model.component("comp1").geom("geom1").feature("wp1").geom().run("fil1");
    model.component("comp1").geom("geom1").feature("wp1").label("cav-def");
    model.component("comp1").geom("geom1").run("wp1");
    model.component("comp1").geom("geom1").create("ext1", "Extrude");
    model.component("comp1").geom("geom1").feature("ext1").set("workplane", "wp1");
    model.component("comp1").geom("geom1").feature("ext1").selection("input").set("wp1");
    model.component("comp1").geom("geom1").feature("ext1").setIndex("distance", "cavity_height", 0);
    model.component("comp1").geom("geom1").run("ext1");
    model.component("comp1").geom("geom1").create("wp2", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp2").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp2").label("Ports-def");
    model.component("comp1").geom("geom1").feature("wp2").set("quickplane", "xz");
    model.component("comp1").geom("geom1").feature("wp2").geom().create("c1", "Circle");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1").set("r", "port_outer_radius");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("c1")
         .set("pos", new String[]{"0", "(cavity_height + port_distance)/2"});
    model.component("comp1").geom("geom1").feature("wp2").geom().create("mir1", "Mirror");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").selection("input").set("c1");
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1")
         .set("pos", new String[]{"0", "cavity_height/2"});
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").set("axis", new double[]{0, 1});
    model.component("comp1").geom("geom1").feature("wp2").geom().feature("mir1").set("keep", true);
    model.component("comp1").geom("geom1").feature("wp2").geom().run("mir1");
    model.component("comp1").geom("geom1").run("wp2");
    model.component("comp1").geom("geom1").create("ext2", "Extrude");
    model.component("comp1").geom("geom1").feature("ext2").set("workplane", "wp2");
    model.component("comp1").geom("geom1").feature("ext2").selection("input").set("wp2");
    model.component("comp1").geom("geom1").feature("ext2").setIndex("distance", "port_height", 0);
    model.component("comp1").geom("geom1").feature("ext2").label("Ports");
    model.component("comp1").geom("geom1").run("ext2");
    model.component("comp1").geom("geom1").create("wp3", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp3").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp3").set("quickplane", "xz");
    model.component("comp1").geom("geom1").feature("wp3").set("quicky", "-port_height");
    model.component("comp1").geom("geom1").feature("wp3").geom().create("c2", "Circle");
    model.component("comp1").geom("geom1").feature("wp3").geom().feature("c2")
         .set("pos", new String[]{"0", "(cavity_height + port_distance)/2"});
    model.component("comp1").geom("geom1").feature("wp3").geom().feature("c2").set("r", "port_inner_radius");
    model.component("comp1").geom("geom1").feature("wp3").label("Pin-def");
    model.component("comp1").geom("geom1").run("wp3");
    model.component("comp1").geom("geom1").create("ext3", "Extrude");
    model.component("comp1").geom("geom1").feature("ext3").set("workplane", "wp3");
    model.component("comp1").geom("geom1").feature("ext3").selection("input").set("wp3");
    model.component("comp1").geom("geom1").feature("ext3").setIndex("distance", "-port_in_depth", 0);
    model.component("comp1").geom("geom1").feature("ext3").label("Pin");
    model.component("comp1").geom("geom1").run("ext3");
    model.component("comp1").geom("geom1").create("wp4", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp4").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp4").set("quickplane", "xz");
    model.component("comp1").geom("geom1").feature("wp4").set("quicky", "-port_height");
    model.component("comp1").geom("geom1").feature("wp4").geom().create("c2", "Circle");
    model.component("comp1").geom("geom1").feature("wp4").geom().feature("c2")
         .set("pos", new String[]{"0", "(cavity_height - port_distance)/2"});
    model.component("comp1").geom("geom1").feature("wp4").geom().feature("c2").set("r", "port_inner_radius");
    model.component("comp1").geom("geom1").feature("wp4").label("Pout-def");
    model.component("comp1").geom("geom1").run("wp4");
    model.component("comp1").geom("geom1").create("ext4", "Extrude");
    model.component("comp1").geom("geom1").feature("ext4").set("workplane", "wp4");
    model.component("comp1").geom("geom1").feature("ext4").selection("input").set("wp4");
    model.component("comp1").geom("geom1").feature("ext4").setIndex("distance", "-port_out_depth", 0);
    model.component("comp1").geom("geom1").feature("ext4").label("Pout");
    model.component("comp1").geom("geom1").run("ext4");
    model.component("comp1").geom("geom1").create("wp5", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp5").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp5").set("quickz", "cavity_height/2");
    model.component("comp1").geom("geom1").feature("wp5").geom().create("r2", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r2")
         .set("size", new String[]{"wafer_space_width", "wafer_space_length"});
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r2").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("r2")
         .set("pos", new String[]{"0", "cavity_length/2"});
    model.component("comp1").geom("geom1").feature("wp5").geom().run("r2");
    model.component("comp1").geom("geom1").feature("wp5").geom().create("fil2", "Fillet");
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("fil2").selection("pointinsketch")
         .set("r2", 4, 3, 1, 2);
    model.component("comp1").geom("geom1").feature("wp5").geom().feature("fil2").set("radius", "wafer_space_fillet");
    model.component("comp1").geom("geom1").feature("wp5").geom().run("fil2");
    model.component("comp1").geom("geom1").feature("wp5").label("Chip space-def");
    model.component("comp1").geom("geom1").run("wp5");
    model.component("comp1").geom("geom1").create("ext5", "Extrude");
    model.component("comp1").geom("geom1").feature("ext5").set("workplane", "wp5");
    model.component("comp1").geom("geom1").feature("ext5").selection("input").set("wp5");
    model.component("comp1").geom("geom1").feature("ext5").setIndex("distance", "-wafer_space_height", 0);
    model.component("comp1").geom("geom1").feature("ext5").label("Chip space");
    model.component("comp1").geom("geom1").run("ext5");
    model.component("comp1").geom("geom1").create("uni1", "Union");
    model.component("comp1").geom("geom1").feature("uni1").selection("input").set("ext1", "ext2", "ext5");
    model.component("comp1").geom("geom1").feature("uni1").set("intbnd", false);
    model.component("comp1").geom("geom1").run("uni1");
    model.component("comp1").geom("geom1").create("wp6", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp6").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp6").set("quickz", "cavity_height/2 - wafer_space_height");
    model.component("comp1").geom("geom1").feature("wp6").geom().create("r3", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r3").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp6").geom().feature("r3")
         .set("pos", new String[]{"0", "cavity_length/2"});
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
    model.component("comp1").geom("geom1").feature("wp7")
         .set("quickz", "cavity_height/2 - wafer_space_height + wafer_height");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r4", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r4")
         .set("size", new String[]{"chip_width", "chip_height"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r4").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r4")
         .set("pos", new String[]{"0", "cavity_length/2 + chip_height/2 + chip_gap/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r4");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("fil3", "Fillet");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil3").selection("pointinsketch")
         .set("r4", 1, 2, 3, 4);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("fil3").set("radius", "chip_fillet");
    model.component("comp1").geom("geom1").feature("wp7").geom().run("fil3");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r5", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r5").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r5")
         .set("pos", new String[]{"0", "cavity_length/2 + jj_height/2 + finger_height/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r5")
         .set("size", new String[]{"jj_width", "finger_height"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r5");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("uni2", "Union");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("uni2").selection("input").set("r4", "r5");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("uni2").set("intbnd", false);
    model.component("comp1").geom("geom1").feature("wp7").geom().run("uni2");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("mir2", "Mirror");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2").selection("input").set("uni2");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2")
         .set("pos", new String[]{"0", "cavity_length/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2").set("keep", true);
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("mir2").set("axis", new double[]{0, 1});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("mir2");
    model.component("comp1").geom("geom1").feature("wp7").label("Transmon pad");
    model.component("comp1").geom("geom1").feature("wp7").geom().create("r6", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r6").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r6")
         .set("size", new String[]{"jj_width", "jj_height"});
    model.component("comp1").geom("geom1").feature("wp7").geom().feature("r6")
         .set("pos", new String[]{"0", "cavity_length/2"});
    model.component("comp1").geom("geom1").feature("wp7").geom().run("r6");
    model.component("comp1").geom("geom1").run("wp7");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").view("view1").set("transparency", true);

    model.component("comp1").material().create("mat1", "Common");
    model.component("comp1").material("mat1").label("Air");
    model.component("comp1").material("mat1").set("family", "air");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("eta", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("rho", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("k", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("cs", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("an1", "Analytic");
    model.component("comp1").material("mat1").propertyGroup("def").func().create("an2", "Analytic");
    model.component("comp1").material("mat1").propertyGroup()
         .create("RefractiveIndex", "RefractiveIndex", "Refractive index");
    model.component("comp1").material("mat1").propertyGroup()
         .create("NonlinearModel", "NonlinearModel", "Nonlinear model");
    model.component("comp1").material("mat1").propertyGroup().create("idealGas", "idealGas", "Ideal gas");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func().create("Cp", "Piecewise");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("eta").set("fununit", "Pa*s");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("expr", "pA*0.02897/R_const[K*mol/J]/T");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho").set("fununit", "kg/m^3");
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("plotaxis", new String[]{"off", "on"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("plotfixedvalue", new String[]{"101325", "273.15"});
    model.component("comp1").material("mat1").propertyGroup("def").func("rho")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("def").func("k")
         .set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("def").func("k").set("fununit", "W/(m*K)");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("args", new String[]{"T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("fununit", "m/s");
    model.component("comp1").material("mat1").propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("plotfixedvalue", new String[]{"273.15"});
    model.component("comp1").material("mat1").propertyGroup("def").func("cs")
         .set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("funcname", "alpha_p");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1").set("fununit", "1/K");
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("argunit", new String[]{"Pa", "K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("plotaxis", new String[]{"off", "on"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("plotfixedvalue", new String[]{"101325", "273.15"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an1")
         .set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("funcname", "muB");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("args", new String[]{"T"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("fununit", "Pa*s");
    model.component("comp1").material("mat1").propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
    model.component("comp1").material("mat1").propertyGroup("def").func("an2")
         .set("plotfixedvalue", new String[]{"200"});
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
    model.component("comp1").material("mat1").propertyGroup("RefractiveIndex")
         .set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
    model.component("comp1").material("mat1").propertyGroup("NonlinearModel").set("BA", "def.gamma-1");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").label("Piecewise 2");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("arg", "T");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp")
         .set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("argunit", "K");
    model.component("comp1").material("mat1").propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("Rs", "R_const/Mn");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
    model.component("comp1").material("mat1").propertyGroup("idealGas").set("molarmass", "0.02897[kg/mol]");
    model.component("comp1").material("mat1").propertyGroup("idealGas").addInput("temperature");
    model.component("comp1").material("mat1").propertyGroup("idealGas").addInput("pressure");
    model.component("comp1").material("mat1").materialType("nonSolid");
    model.component("comp1").material().create("mat2", "Common");
    model.component("comp1").material("mat2").label("Silicon");
    model.component("comp1").material("mat2").set("family", "custom");
    model.component("comp1").material("mat2").propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
    model.component("comp1").material("mat2").propertyGroup().create("RefractiveIndex", "Refractive index");
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

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").physics().create("emw", "ElectromagneticWaves", "geom1");
    model.component("comp1").physics("emw").create("lelement1", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement1").label("Zin");
    model.component("comp1").physics("emw").feature("lelement1").selection().set(13);
    model.component("comp1").physics("emw").feature("lelement1").set("PortType", "Coaxial");
    model.component("comp1").physics("emw").create("lelement2", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement2").label("Zout");
    model.component("comp1").physics("emw").feature("lelement2").selection().set(10);
    model.component("comp1").physics("emw").feature("lelement2").set("PortType", "Coaxial");
    model.component("comp1").physics("emw").create("lelement3", "LumpedElement", 2);
    model.component("comp1").physics("emw").feature("lelement3").selection().set(43);
    model.component("comp1").physics("emw").feature("lelement3").set("LumpedElementType", "Inductor");
    model.component("comp1").physics("emw").feature("lelement3").set("Lelement", "chip_inductance");
    model.component("comp1").physics("emw").feature("lelement3").label("LJ");

    model.study().create("std1");
    model.study("std1").create("eig", "Eigenfrequency");
    model.study("std1").feature("eig").set("conrad", "1");
    model.study("std1").feature("eig").set("linpsolnum", "auto");
    model.study("std1").feature("eig").set("solnum", "auto");
    model.study("std1").feature("eig").set("notsolnum", "auto");
    model.study("std1").feature("eig").set("ngenAUX", "1");

    return model;
  }

  public static Model run2(Model model) {
    model.study("std1").feature("eig").set("goalngenAUX", "1");
    model.study("std1").feature("eig").setSolveFor("/physics/emw", true);

    model.label("cavity_demo.mph");

    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").run("blk1");
    model.component("comp1").geom("geom1").create("dif1", "Difference");
    model.component("comp1").geom("geom1").feature("dif1").selection("input2").set();
    model.component("comp1").geom("geom1").feature("dif1").selection("input").set("uni1");
    model.component("comp1").geom("geom1").feature("dif1").selection("input2").set("uni1");

    return model;
  }

  public static void main(String[] args) {
    Model model = run();
    run2(model);
  }

}
