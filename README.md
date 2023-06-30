# Java-Android-Bezier-Curve-Implementation-Using-Interpolation
Bezier curve implementation from scratch in Java android using interpolation.<br />
# Description
**Linear interpolation** also known as **lerp** function in programming languages::<br />
```java
public Point linearInterpolation(float t, Point start, Point stop) {
  float Px = (1 - t) * start.x + t * stop.x;
  float Py = (1 - t) * start.y + t * stop.y;
  Point P = new Point((int) Px, (int) Py);
  return P;
}
```
There are three parameters, the first one is **t** value from **0 to 1** , which calculates the **point between the start and stop points** of the line . <br />
For example, let's set two points on the coordinate  **(x, y)**: <br /> 
**A=(100,100)** and <br /> 
**B=(200,200)** <br /> 
Now we have two points, and let's say that:<br />
**Start point** is **A**<br />
**End point** is **B**<br />
Now let's set the value to **t = 0.5** and add these **t**, **A** and **B** three parameters to our **linearInterpolation** function<br />
```java
linearInterpolation(t, A, B)
```
then the **linearInterpolation function** will return us the point between A and B:<br />
```
(150,150)
```
# Examples
According to the rule **t**, it should be between **0 < t <1** or equal to **t = 0** or **t = 1**, but not **0 > t > 1**.<br />

Example №1:<br />
```java
float t = 0.664f;
Point A = new Point(45, 100);
Point B = new Point(784, 135);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output: C(x=535, y=123)
```
Example №2:<br />
```java
float t = 0.91564644f;
Point A = new Point(876879, 54678);
Point B = new Point(786874, 786135);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output:  C(x=794466, y=724434)
```
Example №3:<br />
```java
float t = 0.5f;
Point A = new Point(0, 100);
Point B = new Point(100, 0);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output:  C(x=50, y=50)
```

if **t<0**:
```java
float t = -0.5f;
Point A = new Point(0, 100);
Point B = new Point(100, 0);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output: C(x=-50,y=150)
```
if **t=0**:
```java
float t = 0.0f;
Point A = new Point(0, 100);
Point B = new Point(100, 0);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output: C(x=0,y=100)
```
if **t=1**:
```java
float t = 1.0f;
Point A = new Point(0, 100);
Point B = new Point(100, 0);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output: C(x=100,y=0)
```
if **t>1**:
```java
float t = 1.5f;
Point A = new Point(0, 100);
Point B = new Point(100, 0);
Point C = linearInterpolation(t, A, B);
System.out.println("C(x=" + C.x + ", y=" + C.y + ")");
// Output: C(x=150,y=-50)
```
# Demonstration:
https://youtube.com/shorts/xUuIoobyBQQ?feature=share
[![Watch the video](https://img.youtube.com/vi/xUuIoobyBQQ/maxresdefault.jpg)](https://youtu.be/xUuIoobyBQQ)
