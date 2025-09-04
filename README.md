## Install

### Conda environment

Use the conda environment to install the MPh package and other useful packages.  

```bash
$ conda create -n MPh python=3.12
$ conda activate MPh
$ conda install pip
$ conda install tqdm ipykernel pyyaml
$ pip install MPh
```

or just call

```bash
$ conda env create -f environment.yml  
```

## How to make your own design?

### Read java files

If you already have a comsol design created by hand, you can save the project as a java file by ```File -> SaveAs -> <Change file format to java>``` and open the java file to check the java commands.

```python
import mph

client = mph.start()
pymodel = client.create('Model')
model = pymodel.java

model = model.java
model.component().create("comp1", True)
model.component("comp1").geom().create("geom1", 3) # 3 means 3D
model.component("comp1").geom("geom1").lengthUnit("\u00b5m")
model.component("comp1").geom("geom1").create("wp1", "WorkPlane")
model.component("comp1").geom("geom1").feature("wp1").set("unite", True)
model.component("comp1").geom("geom1").feature("wp1").geom().create("r1", "Rectangle")
model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("size", [2.4, 0.7])
model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("pos", [-1.4, -0.35])
model.component("comp1").geom("geom1").feature("wp1").geom().run("r1")

# or even more shorter
# comp1 = model.component().create("comp1", True)
# geom1 = comp1.geom().create("geom1", 3) # 3 means 3D
# geom1.lengthUnit("\u00b5m")
# wp1 = geom1.create("wp1", "WorkPlane")
# wp1.set("unite", True)
# r1 = wp1.geom().create("r1", "Rectangle")
# r1.set("size", [2.4, 0.7])
# r1.set("pos", [-1.4, -0.35])
# wp1.geom().run("r1")
```

### Configuration