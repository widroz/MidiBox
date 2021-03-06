# MidiBox
A Java program which can be used to visualize polyphony of a .mid file.

## How does it work?
A midi file's rute is given to the program.
The X axis is divided in 128 equidistant points. Each one is asociated with a musical note, from the lowest pitch (C0) to the highest (G9).
The Y axis is divided in the number of channels existing in that midi file.

Then, the program reproduces the midi file and (in real time) catches each note and draws geometric patterns associated with these notes (X, Y) coordinates.
Seven modes have been implemented, three of them listed below with a short demo.

## Examples
You can click one of these thumbnails, it will redirect to a short Youtube video where you can take a look -with sound- to the selected mode working on an example song's fragment written by me.

### Fill Rectangles Mode

Click [here](https://www.youtube.com/watch?v=tSGapqXVWQQ) to be redirected to a video including audio and the animation below.
![Rectangles gif](https://github.com/widroz/MidiBox/blob/main/gifs/rectangles.gif)


### Center Mode
Click [here](https://youtu.be/xy9jdx1v4aA) to be redirected to a video including audio and the animation below.
![Center mode gif](https://github.com/widroz/MidiBox/blob/main/gifs/center.gif)

### N Dimensional Mode
Click [here](https://youtu.be/WJ1Dp1ehDDY) to be redirected to a video including audio and the animation below.
![NDimensional gif](https://github.com/widroz/MidiBox/blob/main/gifs/ndimensional.gif)
