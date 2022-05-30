# MidiBox
A Java program which can be used to visualize polyphony of a .mid file.

## How does it work?
A midi file is given to the program.
The X axis is divided in 128 equidistant points. Each one is asociated with a musical note, from the lowest pitch (C0) to the highest (G9).
The Y axis is divided in the number of channels existing in that midi file.

Then, the program reproduces the midi file and (in real time) catches each note and draws geometric patterns associated with these notes (X, Y) coordinates.
Seven modes have been implemented, three of them listed below with a short demo.

## Examples
You can click one of these examples, it will redirect to a short Youtube video where you can take a look to that mode working on an example song's fragment written by me.

### Fill Rectangles Mode
[![Fill Rectangles Mode](https://img.youtube.com/vi/tSGapqXVWQQ/0.jpg)](https://www.youtube.com/watch?v=tSGapqXVWQQ)

### Center Mode
[![Center Mode](https://img.youtube.com/vi/xy9jdx1v4aA/0.jpg)](https://www.youtube.com/watch?v=xy9jdx1v4aA)

### N Dimensional Mode
[![N Dimensional Mode](https://img.youtube.com/vi/WJ1Dp1ehDDY/0.jpg)](https://www.youtube.com/watch?v=WJ1Dp1ehDDY)
