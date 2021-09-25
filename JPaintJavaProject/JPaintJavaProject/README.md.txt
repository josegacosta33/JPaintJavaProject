JPaintJavaProject

Patterns:
Command Pattern:
I used the Command Pattern for my CommandsHandler under draw.commands. It includes the
code for Draw, Select, and Move. The CommandHandler gathers the MouseAdapter code and
ApplicationState(under model.persistence) from the ClickHandler, which is where you see
mousePressed and mouseReleased code. So if the CommandsHandler is in DRAW mode then
Create.java under draw.command will create a new Shape and add it to Shapes.java (it is a
Shape List) under model package.

Strategy Pattern:
I used the Strategy Pattern for the Draw package where you will find Background, Circle,
Rectangle, and Triangle. These classes are called in the Drawer.java under model package.
DrawShapes uses a for loop and it chooses what to draw based on the ShapeType (Rectangle,
Circle, Triangle). Every shape has a strategy pattern and this allowed me to add different code
for each shape and keep it independent from the Drawer so it will not affect it.

Observer Pattern:
This pattern allowed me to change color, shading, and the type of Shape(Circle, Rectangle
Trinagle). The ApplicationState under model.persistence was modified with adding the observer
methods(ObservableState, ObserveState). The uiStateChange in ObservableState.java under
model package lets the ObserveState.java know what was added. ObserveState takes a String
and runs a method in ConShape.java under model package. This will update the type of Shape
and draw it again.

Singleton Pattern:
I used this pattern for the different lists. This made it less repetitive. Look at Shapes.java, which
is a list for Shapes and includes methods like put, changeArray, getArray, and removeLastShape.
This would be a good example describing singleton pattern.

Conclusion:
I used four patterns including Strategy, Command, Observer, and Singleton. Although I didn’t
use interfaces much I was able to get everything done. For some reason it was confusing me
more than helping so I just decided to make many classes. My copy and paste is giving me
problems and my MOVE as well.
My Move code works well, but the undo for Move doesn’t work. Another problem is that when
I try and change the color of the shape to draw a new Shape the color for the first Shape
changes instead of the second. This something I couldn’t solve.
My Copy and Paste also seems to be acting up as well. It works when I have few shapes.
However, when I have many shapes drawn it’s hard to copy and paste. I think my select might
have a bug, but not positive.
I had a really tough time starting this project and I didn’t know what the appropriate
package(location) would be for each class, since it involved an MVC structure. As you can see it
is kind of messy, but it works for the most part. Those were the only the only two issues I found.
I did do the extra credit for changing the color after its drawn, and I also did Redo using the
Command pattern.
