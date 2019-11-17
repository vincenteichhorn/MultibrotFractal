# MultibrotFractal
This program creates an image of a multibrot fractal - an extension of the Mandelbrot fractal.
The idea is to change the iteration rule of Mandelbrot. The potency two becomes a variable potency, which can be any real number.

## Equations
![equation](https://latex.codecogs.com/gif.latex?z_{n&plus;1}&space;=&space;z_{n}^2&space;&plus;&space;c&space;\rightarrow&space;z_{n&plus;1}&space;=&space;z_{n}^p&space;&plus;&space;c) <br>
Z is an element of the complete numbers (a + bi) and p is a real number. <br> 
![equation](https://latex.codecogs.com/gif.latex?z&space;=&space;(a&space;&plus;&space;bi)&space;=&space;r(cos(\alpha&space;)&space;&plus;sin(\alpha&space;)i)) <br>
![equation](https://latex.codecogs.com/gif.latex?r&space;=&space;\arg&space;(z)&space;=&space;\sqrt{a^2&space;&plus;&space;b^2}) <br>
![equation](https://latex.codecogs.com/gif.latex?\alpha&space;=&space;\arctan&space;2(b,&space;a)) <br><br>

![equation](https://latex.codecogs.com/gif.latex?z%5Ep%20%3D%20r%5Ep%28cos%28p%5Calpha%20%29&plus;sin%28p%5Calpha%20%29i%29%29) <br>
![equation](https://latex.codecogs.com/gif.latex?a_%7Bn%20&plus;%201%7D%20%3D%20%5Csqrt%20%7Ba_%7Bn%7D%5E%7B2%7D%20&plus;%20b_%7Bn%7D%5E2%7D%5E%7Bp%7D*cos%28p%20*%20%5Carctan2%28b_%7Bn%7D%2C%20a_%7Bn%7D%29%29) <br>
![equation](https://latex.codecogs.com/gif.latex?b_%7Bn%20&plus;%201%7D%20%3D%20%5Csqrt%20%7Ba_%7Bn%7D%5E%7B2%7D%20&plus;%20b_%7Bn%7D%5E2%7D%5E%7Bp%7D*sin%28p%20*%20%5Carctan2%28b_%7Bn%7D%2C%20a_%7Bn%7D%29%29i)

## Variables in Main.java
Variable | Means | Default
------------ | ------------- | -------------
`int width` | width of the image | 1400
`int height` | height of the image | 720
`int ratioWidth`| image width/height ration | `width / height`
`double power` | power for calculation: 2 gives mandelbrot set| 2
`int maxIterations`| maximal interations | 100
`int breakPoint`| divergence border| 16
`Point"D center`| coordinates in center of the image| .Double(-0.5, 0)
`double size`| length of the x/y-axis in **each** direction| 1.25

## Contributing - feel free to edit
 1. Fork it!
 2. Create your feature branch: git checkout -b my-new-feature
 3. Commit your changes: git commit -am 'Add some feature'
 4. Push to the branch: git push origin my-new-feature
 5. Submit a pull request
