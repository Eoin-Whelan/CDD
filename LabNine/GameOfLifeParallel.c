#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include <omp.h>

/*
	Author:	Eoin Farrell
	Student No:	C00164364
	Description:	GameOfLifeParallel.c is a parellelized version of
			Conway's Game of Life. OpenMP is imported via the
			above #inclide <omp.h> header file, and the 
			implementation to make it operate concurrently.
*/

#define for_x for (int x = 0; x < w; x++)
#define for_y for (int y = 0; y < h; y++)
#define for_xy for_x for_y

#define MAX_T 2

void show(void *u, int w, int h)
{

	int (*univ)[w] = u;
	printf("\033[H");
	for_y {
		for_x printf(univ[y][x] ? "\033[07m  \033[m" : "  ");
		printf("\033[E");
	}
	
	fflush(stdout);
}

void evolve(void *u, int w, int h)
{

	unsigned (*univ)[w] = u;
	unsigned new[h][w];
	#pragma omp parallel shared(new)
	#pragma omp for
	for_y for_x {
		int n = 0;
		for (int y1 = y - 1; y1 <= y + 1; y1++)
			for (int x1 = x - 1; x1 <= x + 1; x1++)
				if (univ[(y1 + h) % h][(x1 + w) % w])
					n++;

		if (univ[y][x]) n--;
		#pragma omp critical
		new[y][x] = (n == 3 || (n == 2 && univ[y][x]));
	}

	for_y for_x univ[y][x] = new[y][x];
}

/*
	game takes a width and height for the board.
	
	Converting Conway's Game of Life to a paralell execution
	entails defining the region containing the while look as
	a region for a single thread to create two additional task
	threads that perform the show() and evolve() calls, 
	respectively.
	
	The structure of the parallel region is as follows:
		- A parallel region of two threads is created from MAX_T
			A barrier is setup to ensure before both threads
			complete before another cycle of show and evolve 
			happen.
*/
void game(int w, int h)
{
	unsigned univ[h][w];
	for_xy univ[y][x] = rand() < RAND_MAX / 10 ? 1 : 0;
	#pragma omp parallel num_threads(MAX_T)
	{
		while (1) {
			show(univ, w, h);
			evolve(univ, w, h);
			#pragma omp barrier
			usleep(200000);
		}
	}
}

int main(int c, char **v)
{
	int w = 0, h = 0;
	if (c > 1) w = atoi(v[1]);
	if (c > 2) h = atoi(v[2]);
	if (w <= 0) w = 30;
	if (h <= 0) h = 30;
	game(w, h);
}
