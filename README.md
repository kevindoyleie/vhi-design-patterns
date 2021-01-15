# vhi-designpatterns Workspace

Web Team workspace to present and discuss design patterns used within our apps.


# Creational Patterns

## Builder Pattern
`Separate the construction of a complex object from its representation so that the same construction 
process can create different representations.`

### Intent
Separate the construction of a complex object from its representation so that the same construction 
process can create different representations. 

### Benefits and Advantages of Builder Pattern
Undoubtedly, the **number of lines of code increase** at least to double in builder pattern, but the effort pays 
off in terms of **design flexibility** and much more **readable code**. The **parameters to the constructor are reduced** 
and are provided in **highly readable method calls**.

Builder pattern also helps to minimize the number of parameters in constructor and thus there is **no need to 
pass in null for optional parameters** to the constructor. It’s really attracts me.

Another advantage is that Object is always instantiated in a `complete` state rather than sitting in an 
incomplete state until the developer calls (if ever calls) the appropriate “setter” method to set additional 
fields.

You can build **immutable objects** without much complex logic in object building process.

### Costs and Disadvantages of Builder Pattern

Though Builder pattern reduce some line of code by eliminating the need of setter methods, still in **double up 
total lines** by introducing the Builder object. Furthermore, although client code is more readable, the client 
code is also more verbose. Though for me, readability weighs more than lines of code.

### Real-time examples

All implementations of `java.lang.Appendable` are infact good example of use of Builder pattern in java. e.g.

`java.lang.StringBuilder#append()` [Unsynchronized class]

`java.lang.StringBuffer#append()` [Synchronized class]

`java.nio.ByteBuffer#put()` (also on CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer and DoubleBuffer)

```StringBuilder builder = new StringBuilder("Temp");
String data = builder.append(1)
.append(true)
.append("friend")
.toString();
System.out.println(data);

Output:
Temp1truefriend
```

Another use can be found in `javax.swing.GroupLayout.Group#addComponent()`.

### Vhi examples


## Factory Method Pattern
`Define an interface for creating an object, but let subclasses decide which class to instantiate.  Factory 
Methods lets a class defer instantiation to subclasses.`


Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under 
creational pattern as this pattern provides one of the best ways to create an object.

In Factory pattern, we create an object without exposing the creation logic to the client and refer to the 
newly created object using a common interface.

### Intent
Define an interface for creating an object, but let the subclass decide which class to instantiate.  Factory 
Methods lets a class defer instantiation to subclasses.

#### Also Known As
Virtual Constructor

### Benefits and Advantages of Factory Pattern

Factory Method Pattern allows the sub-classes to choose the type of objects to create.

It promotes the loose-coupling by eliminating the need to bind application-specific classes into the code. 
That means the code interacts solely with the resultant interface or abstract class, so that it will work with 
any classes that implement that interface or that extends that abstract class.

### Real-time examples
This design pattern has been widely used in JDK, such as:
1. getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design 
   pattern.
2. All the wrapper classes like Integer, Boolean etc, in Java uses this pattern to evaluate the values using 
   valueOf() method.
3. java.nio.charset.Charset.forName(), java.sql.DriverManager#getConnection(), java.net.URL.openConnection(), 
   java.lang.Class.newInstance(), java.lang.Class.forName() are some examples where factory method design 
   pattern has been used.

### Vhi examples