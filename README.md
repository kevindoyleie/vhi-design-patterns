# Vhi Design Patterns Workspace

Web Team workspace to present and discuss design patterns used within our apps.


# Creational Patterns

In software engineering, creational design patterns are design patterns that deal with object creation mechanisms, 
trying to create objects in a manner suitable to the situation. The basic form of object creation could result in 
design problems or in added complexity to the design. Creational design patterns solve this problem by somehow 
controlling this object creation.

Creational design patterns are composed of two dominant ideas. One is encapsulating knowledge about which concrete 
classes the system uses. Another is hiding how instances of these concrete classes are created and combined.

Creational design patterns are further categorized into object-creational patterns and Class-creational patterns, where 
Object-creational patterns deal with Object creation and Class-creational patterns deal with Class-instantiation. In 
greater details, Object-creational patterns defer part of its object creation to another object, while Class-creational 
patterns defer its object creation to subclasses.


## Builder Pattern
```
Separate the construction of a complex object from its representation so that the same construction 
process can create different representations.
```

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

All implementations of `java.lang.Appendable` are in fact good example of use of Builder pattern in java. e.g.

`java.lang.StringBuilder#append()` [Un-synchronized class]

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

In the FindAPlanPlanController class we use a builder pattern to build a get quote command for the request to Kana.
```
IndicativeQuoteListCommand indicativeQuoteListCommand = quoteService.getIndicativeQuoteListCommandBuilder()
            .withCoversetCodes(coversets)
            .withNaturalLanguageFormDetails(details)
            .withEffectiveDate(funnelStateHolder.getStartDate())
            .build();
```


## Factory Method Pattern

```
Define an interface for creating an object, but let subclasses decide which class to instantiate.  Factory 
Methods lets a class defer instantiation to subclasses.
```

Factory pattern is one of the most used design patterns in Java. This type of design pattern comes under 
creational pattern as this pattern provides one of the best ways to create an object.

In Factory pattern, we create an object without exposing the creation logic to the client and refer to the 
newly created object using a common interface.

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

We use these a lot to build things like quote commands that will be sent to the quote engine.  

For example, in `ContractQueryAxis2ClientImpl`, the `ContractQueryRequestBuilderFactory` is used to create a 
GetQuoteInput that will be sent to Ciboodle to get a quote.
```
GetQuoteInput input = builderFactory.newGetQuoteInputBuilder()
                                    .withQuoteSetId(quoteSetId)
                                    .buildGetQuoteInput();
```



# Structural Patterns

Structural patterns are concerned with how classes and object are composed to form larger structures.  
Structural class patterns use inheritance to compose interfaces or implementations.


## Adaptor Pattern

```
Convert the interface of a class into another interface clients expect.  Adaptor lets classes work 
together that couldn't otherwise because of incompatible interfaces.
```

#### Also Known As
```
Wrapper
```

An adapter allows two incompatible interfaces to work together. This is the real-world definition for an 
adapter. Interfaces may be incompatible, but the inner functionality should suit the need. The adapter design 
pattern allows otherwise incompatible classes to work together by converting the interface of one class into 
an interface expected by the clients.


Use the adaptor pattern when
* You want to use an existing class, and its interface does not match the one you need.
* You want to create a reusable class that cooperates with the unrelated or unforeseen classes, that is, 
  classes that don't necessarily have compatible interfaces.
* (_object adaptor only_) you need to use several existing subclasses, but it's impractical to adapt their 
  interface by subclassing every one. An object adaptor can adapt the interface of its parent class.

Adapter pattern lets you wrap an otherwise incompatible object in an adapter to make it compatible with 
another class.
 

### Structure

A `class adaptor` uses multiple inheritance to adapt one interface to another.

An `object adaptor` relies on object composition.

### Consequences

Class and object adapters have different trade-offs. 

A class adapter
* adapts Adaptee to Target by committing to a concrete Adaptee class. As a consequence, a class adapter 
  won’t work when we want to adapt a class and all its subclasses.
* lets Adapter override some of Adaptee’s behavior, since Adapter is a subclass of Adaptee.
* introduces only one object, and no additional pointer indirection is needed to get to the adaptee.

An object adapter
* lets a single Adapter work with many Adaptees—that is, the Adaptee itself and all of its subclasses (if 
  any). The Adapter can also add functionality to all Adaptees at once.
* makes it harder to override Adaptee behavior. It will require subclassing Adaptee and making Adapter 
  refer to the subclass rather than the Adaptee itself.
  

### Real-time examples
   
```
java.util.Arrays#asList()
java.util.Collections#list()
java.util.Collections#enumeration()
javax.xml.bind.annotation.adapters.XMLAdapter
```

### Vhi examples




## Facade Pattern

```
Provide a unified interface to a set of interfaces in a subsystem.  Facade defines a higher-level 
interface that makes the subsystem easier to use.
```

Structuring a system into subsystems helps reduce complexity.  A common design goal is to minimize the
communication and dependencies between subsystems.  One way to achieve this goal is to introduce a
`facade` object that provides a single, simplified interface to the more general facilities of a subsystem.

Facade pattern hides the complexities of the system and provides an interface to the client using which 
the client can access the system.

This pattern involves a single class which provides simplified methods required by a client and delegates 
calls to methods of existing system classes.

Simply put, a facade encapsulates a complex subsystem behind a simple interface. **It hides much of the 
complexity and makes the subsystem easy to use.**

Also, if we need to use the complex subsystem directly, we still can do that; we aren't forced to use the 
facade all the time.

Besides, a much simpler interface, there's one more benefit of using this design pattern. **It decouples a 
client implementation from the complex subsystem**. Thanks to this, we can make changes to the existing 
subsystem and don't affect a client.

### Consequences

The facade pattern doesn't force us to unwanted tradeoffs, because it only adds additional layers of 
abstraction.  Sometimes the pattern can be overused in simple scenarios, which will lead to redundant 
implementations.


### Real-time examples

`javax.faces.context.FacesContext` uses `LifeCycle`, `ViewHandler`, `NavigationHandler` classes under the 
hood, but most clients are not aware of that.

`javax.faces.context.ExternalContext` uses `ServletContext`, `HttpSession`, `HttpServletRequest`, 
`HttpServletResponse` and others inside.

### Vhi examples

In `WAM_SERVICES` there are a few examples of the facade pattern

In the `ForgotPasswordPINServiceWrapper` class, we hide what's going on in `ldapService` and 
`sessionInvalidUserService`.

In the UserContactDetailsWrapper class, we create an interface that calls many services under the hood. 
For example:
```
int partnerId = authenticationService.getUserPartnerRef(user);
String[] addressFields = giosDataSourceService.getLatestCoord(Integer.toString(partnerId), COORDINATE_TYPE_POSTAL_ADDRESS);
```


# Behavioral Patterns

In software engineering, behavioral design patterns are design patterns that identify common communication patterns
among objects. By doing so, these patterns increase flexibility in carrying out communication.
                      

## Controller Pattern

```
The pattern relates to the design of Web applications. It provides a centralized entry point for handling 
requests.
```

It is "a _controller_ that handles all requests for a website", which is a useful structure for web application
developers to achieve the flexibility and reuse without code redundancy.

The controller is an entrance for users to handle requests in the system. It realizes authentication by playing the
role of delegating helper or initiate contact retrieval.

Note: the front controller pattern is a specialized kind of [mediator](#mediator-pattern) pattern.

### Benefits and liabilities

There are three benefits for using front controller pattern:
* **Centralized control**.  Front controller handles all the requests to the web application. This implementation of
  centralized control that avoids using multiple controllers is desirable for enforcing application-wide policies
  such as users tracking and security.
* **Thread-safety**.  A new command object arises when receiving a new request and the command objects are not meant
  to be thread safe.  Thus, it will be safe in the command classes. Though safety is not guaranteed when threading
  issues are gathered, codes that act with command is still thread safe.
* **Configurability**.  Since only one front controller is needed in web application, the configuration of web
  applications implementation is largely simplified. The handler accomplishes the rest of dispatching so that it is
  not required to change anything before adding new commands with dynamic ones.

In terms of liability, front controllers that determine the following activities by searching the database or XML
documents, performance might be decreased. And implementation of front controller to existed systems always
involving replacing the current ones, which makes it harder for beginners to start with.

### Relationship with MVC pattern

1. In order to improve system reliability and maintainability, duplicated codes should be avoided and centralized when
   they are of the same common logic through the whole system.
2. The data for the application is better to be handled in one location, thus there will be no need to duplicate
   database retrieval code.
3. Different roles in the MVC pattern should be separated to increase testability, which is also true for controller
   part in the MVC pattern.

#### Comparison

|            | Page Controller      | Front Controller |
| -----------| ----------- | ----------- |
| Base class | Base class is needed and will grow simultaneously with the development of the application. | The centralization of solving all requests is easier to modify than base class method. |
| Security | Low security because various objects react differently without consistency.   | High. The controller is implemented in coordinated fashion, making the application safer. |
| Logical Page | Single object on each logical page. | Only one controller handles all requests. |
| Complexity | Low   | High        |

### Real-time examples

### Vhi examples

## Mediator Pattern

```
Define an object that encapsulates how a set of objects interact.  Mediator promotes loose coupling by keeping 
objects from referring to each other explicitly, and lets you vary their interaction independently.
```

In software engineering, the mediator pattern defines an object that encapsulates how a set of objects interact. 
This pattern is considered to be a behavioral pattern due to the way it can alter the program's running behavior.

In object-oriented programming, programs often consist of many classes. Business logic and computation are 
distributed among these classes.  However, as more classes are added to a program, especially during maintenance 
and/or refactoring, the problem of communication between these classes may become more complex.  This makes the 
program harder to read and maintain.  Furthermore, it can become difficult to change the program, since any change 
may affect code in several other classes.

With the mediator pattern, communication between objects is encapsulated within a mediator object.  Objects no 
longer communicate directly with each other, but instead communicate through the mediator.  This reduces the 
dependencies between communicating objects, thereby reducing coupling.

### What problems can the Mediator design pattern solve?
* Tight coupling between a set of interacting objects should be avoided.
* It should be possible to change the interaction between a set of objects independently.

Defining a set of interacting objects by accessing and updating each other directly is inflexible because it tightly 
couples the objects to each other and makes it impossible to change the interaction independently of (without having 
to change) the objects.  And it stops the objects from being reusable and makes them hard to test.

_Tightly coupled objects_ are hard to implement, change, test, and reuse because they refer to and know about many 
objects.
 
### What solution does the Mediator design pattern describe?

* Define a separate (mediator) object that encapsulates the interaction between a set of objects.
* Objects delegate their interaction to a mediator object instead of interacting with each other directly.

The objects interact with each other indirectly through a mediator object that controls and coordinates the interaction.

This makes the objects loosely coupled.  They only refer to and know about their mediator object and have no 
explicit knowledge of each other.

The essence of the Mediator Pattern is to "_define an object that encapsulates how a set of objects interact_".  It 
promotes loose coupling by keeping objects from referring to each other explicitly, and it allows their interaction to 
be varied independently.  Client classes can use the mediator to send messages to other clients, and can receive 
messages from other clients via an event on the mediator class.

