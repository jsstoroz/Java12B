Jennifer Storozum
7/23/2017
PA2 Part2
readmepart2.txt

The program creates an aviary with different kinds of birds that fly around.
There are four kinds of birds. Cardinals are red birds that fly up and down
in the aviary. Hummingbirds are pink birds that fly around randomly in the aviary.
Bluebirds are blue birds that fly in a left to right zig-zag in the aviary. 
Vultures are black birds that fly in counter clockwise circles.

The program has no bugs as far as I am aware.

I chose to have an AbstractBird class because there are
lots of behaviors and fields common to all birds that would
be redundant to write multiple times in each class.

I also added an enum to keep track of which directions the birds face (except
the hummingbird because it doesn't have a direction).