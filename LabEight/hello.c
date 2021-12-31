#include <stdio.h>

/**
*	Rudimentary program in learning basic C program compilation.
*	@Author Joseph Kehoe, Eoin Farrell (Replication of program and documentation)
*/
int main(void){

    printf("Hello World\n");

    int multiplier=1;
    int total=0;
    
    for(int k=0;k<10;k++){
        total = total * (k*multiplier);
        multiplier++;
    }
    printf("Total is:%d multiplayer is: %d\n", total, multiplier);
}
