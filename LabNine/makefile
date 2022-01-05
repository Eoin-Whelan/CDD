#	Set flags
CC = gcc
CFLAGS = -fopenmp

#	Creating the executable from the .o file.
#	make clean called afterwards to clean .o file from directory.
GameOfLife: GameOfLifeParallel.o
	$(CC) $(CFLAGS) -o GameOfLifeParallel GameOfLifeParallel.o
	make clean

#	Creating the .o files using .c file
GameOfLife.o: GameOfLifeParallel.c
	$(CC) $(CFLAGS) -c GameOfLifeParallel.c

#	Make command
clean:
	rm GameOfLifeParallel.o
