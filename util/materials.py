
def assign_material(node, material, tag, name):

    if material == "copper":
        mat = node.material().create(tag, "Common")
        mat.propertyGroup().create("Enu", "Enu", "Young's modulus and Poisson's ratio")
        mat.propertyGroup().create("linzRes", "linzRes", "Linearized resistivity")
        mat.label(name)
        mat.set("family", material)
        mat.propertyGroup("def").set("relpermeability", ["1", "0", "0", "0", "1", "0", "0", "0", "1"])
        mat.propertyGroup("def").set("electricconductivity", ["5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]"])
        mat.propertyGroup("def").set("thermalexpansioncoefficient", ["17e-6[1/K]", "0", "0", "0", "17e-6[1/K]", "0", "0", "0", "17e-6[1/K]"])
        mat.propertyGroup("def").set("heatcapacity", "385[J/(kg*K)]")
        mat.propertyGroup("def").set("relpermittivity", ["1", "0", "0", "0", "1", "0", "0", "0", "1"])
        mat.propertyGroup("def").set("density", "8960[kg/m^3]")
        mat.propertyGroup("def").set("thermalconductivity", ["400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]"])
        mat.propertyGroup("Enu").set("E", "110[GPa]")
        mat.propertyGroup("Enu").set("nu", "0.35")
        mat.propertyGroup("linzRes").set("rho0", "1.72e-8[ohm*m]")
        mat.propertyGroup("linzRes").set("alpha", "0.0039[1/K]")
        mat.propertyGroup("linzRes").set("Tref", "298[K]")
        mat.propertyGroup("linzRes").addInput("temperature")